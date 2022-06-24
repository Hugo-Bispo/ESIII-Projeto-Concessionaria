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
import model.CarroBuilder;

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
		sql.append("SELECT carro.placa, carro.modelo, carro.versao, carro.marca, carro.ano, carro.situacao,"
				+ "carro.data_cadastro, carro.valor, carac.cilindrada, carac.combustivel, carac.cambio,"
				+ "carac.cor, carac.quilometragem from carro "
				+ "INNER JOIN carrocaracteristicas as carac ON carac.id_caracteristica = carro.id_caracteristica;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> carroResultSet = query.getResultList();
		List<Carro> carros = new ArrayList<Carro>();
		for (Object[] o : carroResultSet) {
			Carro carro = CarroBuilder.builder()
					.addPlaca(o[0].toString())
					.addCarroInformacao(o[1].toString(), o[2].toString(), o[3].toString(), Integer.parseInt(o[4].toString()))
					.addSituacao(o[5].toString())
					.addDataCadastro(LocalDate.parse(o[6].toString()))
					.addValor(Double.parseDouble(o[7].toString()))
					.addCaracteristicas(Double.parseDouble(o[7].toString()), o[7].toString(), o[7].toString(), o[7].toString())
					.get();

			carros.add(carro);
		}

		return carros;
	}
}
