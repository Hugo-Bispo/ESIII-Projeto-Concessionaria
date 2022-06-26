package control;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Cliente;
import model.ClienteBuilder;
import model.Venda;
import model.Vendedor;
import persistence.ClienteDAO;
import util.HibernateUtil;

public class ClienteController implements IController<Cliente> {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	ClienteDAO clienteDAO = new ClienteDAO(sf);

	private StringProperty nomeCliente = new SimpleStringProperty("");
	private StringProperty cpfCliente = new SimpleStringProperty("");
	private StringProperty telefoneCliente = new SimpleStringProperty("");
	private StringProperty ruaCliente = new SimpleStringProperty("");
	private StringProperty numeroCliente = new SimpleStringProperty("");
	private StringProperty cepCliente = new SimpleStringProperty("");
	private StringProperty bairroCliente = new SimpleStringProperty("");
	private StringProperty cidadeCliente = new SimpleStringProperty("");

	public StringProperty nomeClienteProperty() {
		return nomeCliente;
	}

	public StringProperty cpfClienteProperty() {
		return cpfCliente;
	}

	public StringProperty telefoneClienteProperty() {
		return telefoneCliente;
	}

	public StringProperty ruaClienteProperty() {
		return ruaCliente;
	}

	public StringProperty numeroClienteProperty() {
		return numeroCliente;
	}

	public StringProperty cepClienteProperty() {
		return cepCliente;
	}

	public StringProperty bairroClienteProperty() {
		return bairroCliente;
	}

	public StringProperty cidadeClienteProperty() {
		return cidadeCliente;
	}

	@Override
	public Cliente boundaryToEntity() throws SQLException {
		Cliente c = new Cliente();
		int numeroCasa = 0;
		try {
			numeroCasa = Integer.parseInt(numeroCliente.get());
		} catch (Exception e) {
			System.err.println(e);
		}
		c = ClienteBuilder.builder().addNome(nomeCliente.get()).addDados(cpfCliente.get(), telefoneCliente.get())
				.addEndereco(ruaCliente.get(), numeroCasa, cepCliente.get(), bairroCliente.get(), cidadeCliente.get())
				.get();
		return c;
	}

	@Override
	public void entityToBoundary(Cliente c) throws SQLException {
		if (c != null) {
			nomeCliente.set(c.getNome());
			cpfCliente.set(c.getCPF());
			telefoneCliente.set(c.getTelefone());
			ruaCliente.set(c.getEndereco().getRua());
			numeroCliente.set(String.valueOf(c.getEndereco().getNumero()));
			cepCliente.set(c.getEndereco().getCep());
			bairroCliente.set(c.getEndereco().getBairro());
			cidadeCliente.set(c.getEndereco().getCidade());
		}

	}

	@Override
	public void adicionar() throws SQLException {
		Cliente c = new Cliente();
		c = boundaryToEntity();
		clienteDAO.insert(c);
	}

	@Override
	public void pesquisar() throws SQLException {
		Cliente c = new Cliente();
		c = boundaryToEntity();
		c = clienteDAO.selectOne(c);
		entityToBoundary(c);
	}

	@Override
	public void excluir() throws SQLException {
		List<Cliente> clientes = clienteDAO.selectAll();
		boolean booleanExcluir = false;
		Cliente c = new Cliente();
		c = boundaryToEntity();
		c = clienteDAO.selectOne(c);
		for (Cliente cliente : clientes) {
			if (cliente.getCPF() == c.getCPF()) {
				booleanExcluir = true;
			}

		}
		if (booleanExcluir != true) {
			clienteDAO.delete(c);
		} else {
			System.out.println("Cliente venda");
		}

	}

	@Override
	public void atualizar() throws SQLException {
		Cliente c = new Cliente();
		c = boundaryToEntity();
		clienteDAO.update(c);
		c = clienteDAO.selectOne(c);
		entityToBoundary(c);

	}

}
