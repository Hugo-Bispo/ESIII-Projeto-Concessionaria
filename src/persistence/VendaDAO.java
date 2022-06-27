package persistence;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Venda;
import model.VendaBuilder;

public class VendaDAO implements IFuncoesDAO<Venda> {

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
		sql.append(
				"SELECT vendedor.funcional, vendedor.nome, vendedor.cargo, cliente.nomeCliente, cliente.cpf, carro.placa, "
				+ "carro.modelo, carro.versao, carro.marca, carro.ano, carro.valor, carro.valorFinal, "
				+ "venda.data_venda FROM venda "
				+ "INNER JOIN vendedor ON vendedor.funcional = venda.funcional "
				+ "INNER JOIN carro ON carro.placa = venda.placa "
				+ "INNER JOIN cliente ON cliente.cpf = venda.cliente;");
		EntityManager entityManager = sf.createEntityManager();
		Query query = entityManager.createNativeQuery(sql.toString());
		List<Object[]> vendedorResultSet = query.getResultList();
		List<Venda> vendas = new ArrayList<Venda>();
		for (Object[] o : vendedorResultSet) {
			Venda venda = VendaBuilder.builder()
					.addFuncional(Integer.parseInt(o[0].toString()))
					.addNomeFuncionario(o[1].toString())
					.addCargoFuncionario(o[2].toString())
					.addNomeCliente(o[3].toString())
					.addCPFCliente(o[4].toString())
					.addPlaca(o[5].toString())
					.addCarroInformacao(o[6].toString(), o[7].toString(), o[8].toString(), Integer.parseInt(o[9].toString()))
					.addValor(Double.parseDouble(o[10].toString()))
					.addValorFinal(Double.parseDouble(o[11].toString()))
					.addDataVenda(LocalDate.parse(o[12].toString()))
					.get();
			vendas.add(venda);
		}

		return vendas;
	}

}
