package control;

import java.sql.SQLException;
import java.time.LocalDate;

import org.hibernate.SessionFactory;
import model.CarroCaracteristicas;
import persistence.CarroCaracteristicasDAO;
import util.HibernateUtil;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CarroController {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	CarroCaracteristicasDAO carroCaracDAO = new CarroCaracteristicasDAO(sf);

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

	private String placaEntity;

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

	public CarroCaracteristicas boundaryToEntity() {

		placaEntity = placa.get();
		placaEntity = placaEntity.replace("-", "");
		CarroCaracteristicas c = new CarroCaracteristicas();

		if (placaEntity.length() == 7) {
			c.setPlaca(placaEntity);
		} else {
		}

		c.setValor(Double.parseDouble(valor.get()));
//		c.setSituacao(situacao.get());
		c.setData_cadastro(data_cadastro.get());
		c.setModelo(modelo.get());
		c.setVersao(versao.get());
		c.setMarca(marca.get());

		try {
			c.setAno(Integer.parseInt(ano.get()));
		} catch (NumberFormatException e) {
		}

		try {
			c.setQuilometragem(Double.parseDouble(quilometragem.get()));
		} catch (NumberFormatException e) {
			c.setQuilometragem(null);
		}

		try {
			c.setCilindrada(Double.parseDouble(cilindrada.get()));
		} catch (NumberFormatException e) {
			c.setCilindrada(null);
		}
		c.setCombustivel(combustivel.get().toString());
		System.out.println(combustivel.get());
		c.setCambio(cambio.get());
		c.setCor(cor.get());

		return c;
	}

	public void entityToBoundary(CarroCaracteristicas c) {
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
			quilometragem.set(String.valueOf(c.getQuilometragem()));
			cilindrada.set(String.valueOf(c.getCilindrada()));
			combustivel.set(c.getCombustivel());
			cambio.set(c.getCambio());
			cor.set(c.getCor());
		}
	}

	public void adicionar() throws SQLException {
		CarroCaracteristicas c = new CarroCaracteristicas();
		c = boundaryToEntity();
		c.setSituacao("D");
		carroCaracDAO.insert(c);
	}

	public void pesquisar() throws SQLException {
		CarroCaracteristicas c = new CarroCaracteristicas();
		c.setPlaca(placa.get());
		c = carroCaracDAO.selectOne(c);
		entityToBoundary(c);
	}
}
