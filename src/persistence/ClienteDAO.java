package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Cliente;

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
		sql.append("SELECT carro.placa, carro.modelo, carro.versao, carro.marca, carro.ano, carro.situacao,"
				+ "carro.data_cadastro, carro.valor, carac.cilindrada, carac.combustivel, carac.cambio,"
				+ "carac.cor, carac.quilometragem from carro "
				+ "INNER JOIN carrocaracteristicas as carac ON carac.id_caracteristica = carro.id_caracteristica;");
		
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> clienteResultSet = query.getResultList();
		List<Cliente> clientes = new ArrayList<Cliente>();
//		for (Object[] o : clienteResultSet) {
//			Cliente cliente = CarroBuilder.builder()
//					.addPlaca(o[0].toString())
//					.addCarroInformacao(o[1].toString(), o[2].toString(), o[3].toString(), Integer.parseInt(o[4].toString()))
//					.addSituacao(o[5].toString())
//					.addDataCadastro(LocalDate.parse(o[6].toString()))
//					.addValor(Double.parseDouble(o[7].toString()))
//					.addCaracteristicas(Double.parseDouble(o[7].toString()), o[7].toString(), o[7].toString(), o[7].toString())
//					.get();
//
//			carros.add(carro);
//		}

		return clientes;
	}
}
