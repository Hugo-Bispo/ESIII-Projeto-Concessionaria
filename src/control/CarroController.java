package control;

import java.sql.SQLException;
import java.time.LocalDate;
import org.hibernate.SessionFactory;
import model.Carro;
import model.CarroBuilder;
import persistence.CarroDAO;
import util.HibernateUtil;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CarroController implements IController<Carro>{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	CarroDAO carroCaracDAO = new CarroDAO(sf);

	private StringProperty placa = new SimpleStringProperty("");
	private StringProperty valor = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data_cadastro = new SimpleObjectProperty<LocalDate>();
	private StringProperty situacao = new SimpleStringProperty("");
	private StringProperty modelo = new SimpleStringProperty("");
	private StringProperty versao = new SimpleStringProperty("");
	private StringProperty marca = new SimpleStringProperty("");
	private StringProperty ano = new SimpleStringProperty("");
	private StringProperty quilometragem = new SimpleStringProperty("");
	private StringProperty cilindrada = new SimpleStringProperty("");
	private StringProperty combustivel = new SimpleStringProperty("");
	private StringProperty cambio = new SimpleStringProperty("");
	private StringProperty cor = new SimpleStringProperty("");
	
	public StringProperty placaProperty() {
		return placa;
	}

	public StringProperty valorProperty() {
		return valor;
	}

	public ObjectProperty<LocalDate> data_cadastroProperty() {
		return data_cadastro;
	}

	public StringProperty situacaoProperty() {
		return situacao;
	}

	public StringProperty modeloProperty() {
		return modelo;
	}

	public StringProperty versaoProperty() {
		return versao;
	}

	public StringProperty marcaProperty() {
		return marca;
	}

	public StringProperty anoProperty() {
		return ano;
	}

	public StringProperty quilometragemProperty() {
		return quilometragem;
	}

	public StringProperty cilindraProperty() {
		return cilindrada;
	}

	public StringProperty combustivelProperty() {
		return combustivel;
	}

	public StringProperty cambioProperty() {
		return cambio;
	}

	public StringProperty corProperty() {
		return cor;
	}

	public Carro boundaryToEntity() {
		Carro c = new Carro();
		String placaEntity = placa.get();
		int anoEntity = 0;
		Double valorEntity = null;
		LocalDate dataEntity = null;
		Double quilometragemEntity = null;
		Double cilindradaEntity = null;
		
		placaEntity = placaEntity.replace("-", "");
		if(placaEntity.length() != 7) {
			System.out.println("Placa Invalida");
			placaEntity = null;
		}
		try {
			anoEntity = Integer.parseInt(ano.get());
			valorEntity = Double.parseDouble(valor.get());
			dataEntity = data_cadastro.get();
			quilometragemEntity = Double.parseDouble(quilometragem.get());
			cilindradaEntity = Double.parseDouble(cilindrada.get());
			
			c = CarroBuilder.builder()
				.addPlaca(placaEntity)
				.addValor(valorEntity)
				.addSituacao("D")
				.addDataCadastro(dataEntity)
				.addCarroInformacao(modelo.get(), versao.get(), marca.get(), anoEntity)
				.addQuilometragem(quilometragemEntity)
				.addCaracteristicas(cilindradaEntity, combustivel.get(), cambio.get(), cor.get())
				.get();
		} catch (Exception e) {
			System.err.println(e);
		}
		return c;
	}

	public void entityToBoundary(Carro c) {
		if (c != null) {
			placa.set(c.getPlaca());
			valor.set(String.valueOf(c.getValor()));
			if (c.getSituacao().contains("D")) {
				situacao.set("Disponivel");
			} else if (c.getSituacao().contains("V")) {
				situacao.set("Vendido");
			}
			data_cadastro.set(c.getData_cadastro());
			modelo.set(c.getModelo());
			versao.set(c.getVersao());
			marca.set(c.getMarca());
			ano.set(String.valueOf(c.getAno()));
			quilometragem.set(String.valueOf(c.getCarroCaracteristicas().getQuilometragem()));
			cilindrada.set(String.valueOf(c.getCarroCaracteristicas().getCilindrada()));
			combustivel.set(c.getCarroCaracteristicas().getCombustivel());
			cambio.set(c.getCarroCaracteristicas().getCambio());
			cor.set(c.getCarroCaracteristicas().getCor());
		}else {
			placa.set("");
			valor.set("");
			data_cadastro.set(LocalDate.parse("0000-00-00"));
			modelo.set("");
			versao.set("");
			marca.set("");
			ano.set("");
			quilometragem.set("");
			cilindrada.set("");
			combustivel.set("");
			cambio.set("");
			cor.set("");
			
		}
	}

	public void adicionar() throws SQLException {
		Carro c = new Carro();
		c = boundaryToEntity();
		carroCaracDAO.insert(c);
	}

	public void pesquisar() throws SQLException {
		Carro c = new Carro();
		c.setPlaca(placa.get());
		c = carroCaracDAO.selectOne(c);
		entityToBoundary(c);
	}

	@Override
	public void excluir() throws SQLException {
		Carro c = new Carro();
		c = boundaryToEntity();
		c = carroCaracDAO.selectOne(c);
		if(c.getSituacao().equals("D")) {
			carroCaracDAO.delete(c);
			entityToBoundary(null);
		}else {
			System.out.println("Não é possivel apagar o Carro");
		}

	}

	@Override
	public void atualizar() throws SQLException {
		Carro c = new Carro();
		c = boundaryToEntity();
		c = carroCaracDAO.selectOne(c);
		
		Carro cUpdate = new Carro();
		cUpdate = boundaryToEntity();
		cUpdate.setCarroCaracteristicas(c.getCarroCaracteristicas());
		carroCaracDAO.update(cUpdate);
		c = carroCaracDAO.selectOne(cUpdate);
		entityToBoundary(cUpdate);
	}
	
	
}
