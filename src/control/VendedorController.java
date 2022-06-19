package control;

import java.sql.SQLException;

import org.hibernate.SessionFactory;

import model.Vendedor;
import persistence.VendedorDAO;
import util.HibernateUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class VendedorController implements Controller_Interfaces<Vendedor> {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	VendedorDAO dao = new VendedorDAO(sf);
	
	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty nome = new SimpleStringProperty("");
	private StringProperty telefone = new SimpleStringProperty("");


	public StringProperty funcionalProperty() {
		return funcional;
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public StringProperty telefoneProperty() {
		return telefone;
	}

	public Vendedor boundaryToEntity() {
		Vendedor v = new Vendedor();
		try {
			v.setFuncional(Integer.parseInt(funcional.get()));
		} catch (NumberFormatException e) {
			return null;
		}
		v.setNome(nome.get());
		v.setTelefone(telefone.get());
		return v;
	}

	public void entityToBoundary(Vendedor v) {
		if (v != null) {
			funcional.set(String.valueOf(v.getFuncional()));
			nome.set(v.getNome());
			telefone.set(v.getTelefone());
		}
	}
	
	public void adicionar() throws SQLException {
		Vendedor v = new Vendedor();
		v = boundaryToEntity();
		dao.insert(v);
		
	}

	public void pesquisar() throws SQLException {
		System.out.println(funcional.get());
		Vendedor v = new Vendedor();
		v.setFuncional(Integer.parseInt(funcional.get()));
		v = dao.selectOne(v);
		entityToBoundary(v);
	}

}
