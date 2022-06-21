package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.CarroCaracteristicas;

public class CarroCaracteristicasDAO implements IFuncoesDAO<CarroCaracteristicas>{
	
	private SessionFactory sf;

	public CarroCaracteristicasDAO(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void insert(CarroCaracteristicas carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(carro);
		transaction.commit();
	}

	@Override
	public void update(CarroCaracteristicas carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(carro);
		transaction.commit();
	}

	@Override
	public void delete(CarroCaracteristicas carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(carro);
		transaction.commit();
	}

	@Override
	public CarroCaracteristicas selectOne(CarroCaracteristicas carro) throws SQLException {
		EntityManager entityManager = sf.createEntityManager();
		carro = entityManager.find(CarroCaracteristicas.class, carro.getPlaca());
		return carro;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CarroCaracteristicas> selectAll() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT placa, modelo, versao, marca, ano, situacao, "
				+ "data_cadastro, valor, valorFinal, cambio, cilindrada, "
				+ "combustivel, cor, quilometragem from carro;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> carroResultSet = query.getResultList();
		List<CarroCaracteristicas> carros = new ArrayList<CarroCaracteristicas>();
		for (Object[] o : carroResultSet) {
			CarroCaracteristicas carro = new CarroCaracteristicas();
			carro.setPlaca(o[0].toString());
			carro.setModelo(o[1].toString());
			carro.setVersao(o[2].toString());
			carro.setMarca(o[3].toString());
			carro.setAno(Integer.parseInt(o[4].toString()));
			carro.setSituacao(o[5].toString());
			carro.setData_cadastro(LocalDate.parse(o[6].toString()));
			carro.setValor(Double.parseDouble(o[7].toString()));
			carro.setValorFinal(Double.parseDouble(o[8].toString()));
			carro.setCambio(o[9].toString());
			carro.setCilindrada(Double.parseDouble(o[10].toString()));
			carro.setCombustivel(o[11].toString());
			carro.setCor(o[12].toString());
			carro.setQuilometragem(Double.parseDouble(o[13].toString()));

			carros.add(carro);
		}

		return carros;
	}


}
