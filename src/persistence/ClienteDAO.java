package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Cliente;
import model.ClienteBuilder;

public class ClienteDAO implements IFuncoesDAO<Cliente> {

	private SessionFactory sf;

	public ClienteDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Cliente cliente) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(cliente);
		transaction.commit();
	}

	@Override
	public void update(Cliente cliente) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(cliente);
		transaction.commit();
	}

	@Override
	public void delete(Cliente cliente) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(cliente);
		transaction.commit();
	}

	@Override
	public Cliente selectOne(Cliente cliente) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		cliente = entityManager.find(Cliente.class, cliente.getCPF());
		return cliente;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"SELECT cliente.cpf, cliente.nomeCliente, cliente.telefoneCliente, clienteendereco.logadouro, clienteendereco.numero, "
						+ "clienteendereco.cep, clienteendereco.bairro, clienteendereco.cidade "
						+ "FROM cliente INNER JOIN clienteendereco ON cliente.id_endereco = clienteendereco.id_endereco;");

		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> clienteResultSet = query.getResultList();
		List<Cliente> clientes = new ArrayList<Cliente>();
		for (Object[] o : clienteResultSet) {
			Cliente cliente = ClienteBuilder.builder()
					.addNome(o[1].toString())
					.addDados(o[0].toString(), o[2].toString())
					.addEndereco(o[3].toString(), Integer.parseInt(o[4].toString()), o[5].toString(), o[6].toString(), o[7].toString())
					.get();
			clientes.add(cliente);
		}

		return clientes;
	}
}
