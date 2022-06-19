package persistence;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import model.Venda;

public class VendaDAO implements IFuncoesDAO<Venda>{

	private SessionFactory sf;

	public VendaDAO(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void insert(Venda venda) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(venda);
		transaction.commit();
	}

	@Override
	public void update(Venda venda) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(venda);
		transaction.commit();
	}

	@Override
	public void delete(Venda venda) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(venda);
		transaction.commit();
	}

	@Override
	public Venda selectOne(Venda venda) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		venda = entityManager.find(Venda.class, venda.getCarro().getPlaca());
		return venda;
	}

	@Override
	public List<Venda> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
