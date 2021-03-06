package control;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;
import model.Venda;
import model.Vendedor;
import model.VendedorBuilder;
import persistence.VendaDAO;
import persistence.VendedorDAO;
import util.HibernateUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VendedorController implements IController<Vendedor> {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	VendedorDAO vendededorDAO = new VendedorDAO(sf);
	VendaDAO vendaDAO = new VendaDAO(sf);

	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty telefone = new SimpleStringProperty("");
	private StringProperty cargo = new SimpleStringProperty("");

	public StringProperty funcionalProperty() {
		return funcional;
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public StringProperty telefoneProperty() {
		return telefone;
	}

	public StringProperty cargoProperty() {
		return cargo;
	}

	public Vendedor boundaryToEntity() {
		Vendedor v = new Vendedor();
		int funcionalVendedor = 0;

		try {
			funcionalVendedor = Integer.parseInt(funcional.get());
			v = VendedorBuilder.builder().addFuncional(funcionalVendedor).addTelefone(telefone.get())
					.addCargo(cargo.get()).addNome(nome.get()).get();
		} catch (Exception e) {
			System.err.println(e);
		}
		return v;
	}

	public void entityToBoundary(Vendedor v) {
		if (v != null) {
			funcional.set(String.valueOf(v.getFuncional()));
			nome.set(v.getNome());
			telefone.set(v.getTelefone());
			cargo.set(v.getCargo());
		}
	}

	public void adicionar() throws SQLException {
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		vendededorDAO.insert(v);

	}

	public void pesquisar() throws SQLException {
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		v = vendededorDAO.selectOne(v);
		entityToBoundary(v);
	}

	@Override
	public void excluir() throws SQLException {
		List<Venda> vendas = vendaDAO.selectAll();
		boolean booleanExcluir = false;
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		v = vendededorDAO.selectOne(v);
		for (Venda venda : vendas) {
			if (venda.getVendedor().getFuncional() == v.getFuncional()) {
				booleanExcluir = true;
			}

		}
		if (booleanExcluir != true) {
			vendededorDAO.delete(v);
		} else {
			System.out.println("Vendedor vendas");
		}

	}

	@Override
	public void atualizar() throws SQLException {
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		vendededorDAO.update(v);
		v = vendededorDAO.selectOne(v);
		entityToBoundary(v);
	}

}
