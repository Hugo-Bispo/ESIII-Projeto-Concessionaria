package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

import model.Vendedor;

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
			Vendedor vendedor = new Vendedor();
			vendedor.setFuncional(Integer.parseInt(o[0].toString()));
			vendedor.setNome((o[1].toString()));
			vendedor.setTelefone((o[2].toString()));
			vendedor.setCargo((o[3].toString()));
			vendedores.add(vendedor);
		}

		return vendedores;
	}

}
