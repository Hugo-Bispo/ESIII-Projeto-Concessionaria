package persistence;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Venda;
import model.VendaBuilder;
import model.Vendedor;
import model.VendedorBuilder;

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Venda> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT funcional, nome, telefone, cargo FROM vendedor;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> vendedorResultSet = query.getResultList();
		List<Venda> vendas = new ArrayList<Venda>();
		for (Object[] o : vendedorResultSet) {
			Venda venda = VendaBuilder.builder()

					.get();
			vendas.add(venda);
		}

		return vendas;
	}

}
