package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Vendedor;
import model.VendedorBuilder;

public class VendedorDAO implements IFuncoesDAO<Vendedor> {
	private SessionFactory sf;

	public VendedorDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Vendedor vendedor) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(vendedor);
		transaction.commit();
	}

	@Override
	public void update(Vendedor vendedor) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(vendedor);
		transaction.commit();
	}

	@Override
	public void delete(Vendedor vendedor) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(vendedor);
		transaction.commit();
	}

	@Override
	public Vendedor selectOne(Vendedor vendedor) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		vendedor = entityManager.find(Vendedor.class, vendedor.getFuncional());
		return vendedor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendedor> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT funcional, nome, telefone, cargo FROM vendedor;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> vendedorResultSet = query.getResultList();
		List<Vendedor> vendedores = new ArrayList<Vendedor>();
		for (Object[] o : vendedorResultSet) {
			Vendedor vendedor = VendedorBuilder.builder()
					.addFuncional(Integer.parseInt(o[0].toString()))
					.addNome((o[1].toString()))
					.addTelefone((o[2].toString()))
					.addCargo((o[3].toString()))
					.get();
			vendedores.add(vendedor);
		}

		return vendedores;
	}

}
