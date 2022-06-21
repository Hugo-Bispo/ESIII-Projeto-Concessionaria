package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Carro;

public class CarroDAO implements IFuncoesDAO<Carro> {

	private SessionFactory sf;

	public CarroDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(Carro carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(carro);
		transaction.commit();
	}

	@Override
	public void update(Carro carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(carro);
		transaction.commit();
	}

	@Override
	public void delete(Carro carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(carro);
		transaction.commit();
	}

	@Override
	public Carro selectOne(Carro carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		carro = entityManager.find(Carro.class, carro.getPlaca());
		return carro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carro> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT placa, modelo, versao, marca, ano, situacao, data_cadastro, valor, valorFinal from carro;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> carroResultSet = query.getResultList();
		List<Carro> carros = new ArrayList<Carro>();
		for (Object[] o : carroResultSet) {
			Carro carro = new Carro();
			carro.setPlaca(o[0].toString());
			carro.setModelo(o[1].toString());
			carro.setVersao(o[2].toString());
			carro.setMarca(o[3].toString());
			carro.setAno(Integer.parseInt(o[4].toString()));
			carro.setSituacao(o[5].toString());
			carro.setData_cadastro(LocalDate.parse(o[6].toString()));
			carro.setValor(Double.parseDouble(o[7].toString()));
			carro.setValorFinal(Double.parseDouble(o[8].toString()));

			carros.add(carro);
		}

		return carros;
	}

}
