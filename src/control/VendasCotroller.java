package control;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.SessionFactory;

import control.descontoCoR.DescontoMarca;
import model.Carro;
import model.Venda;
import model.Vendedor;
import persistence.CarroDAO;
import persistence.VendaDAO;
import persistence.VendedorDAO;
import util.HibernateUtil;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendasCotroller implements IController<Venda> {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	CarroDAO carroDAO = new CarroDAO(sf);
	VendaDAO vendaDAO = new VendaDAO(sf);
	VendedorDAO vendedorDAO = new VendedorDAO(sf);
	DescontoMarca descontoCoR = new DescontoMarca();

	DecimalFormat df = new DecimalFormat("#,###.00");

	private StringProperty codigoVendedor = new SimpleStringProperty("");
	private StringProperty nomeVendedor = new SimpleStringProperty("");
	private StringProperty telefoneVendedor = new SimpleStringProperty("");
	private StringProperty cargoVendedor = new SimpleStringProperty();

	private StringProperty placaCarro = new SimpleStringProperty("");
	private StringProperty modeloCarro = new SimpleStringProperty("");
	private StringProperty versaoCarro = new SimpleStringProperty("");
	private StringProperty marcaCarro = new SimpleStringProperty("");
	private StringProperty valorCarro = new SimpleStringProperty("");
	private StringProperty valorDescontoCarro = new SimpleStringProperty("");
	private StringProperty valorFinalCarro = new SimpleStringProperty("");

	private String placaEntity;

	public StringProperty codigoVendedorProperty() {
		return codigoVendedor;
	}

	public StringProperty nomeVendedorProperty() {
		return nomeVendedor;
	}

	public StringProperty telefoneVendedorProperty() {
		return telefoneVendedor;
	}

	public StringProperty cargoVendedorProperty() {
		return cargoVendedor;
	}

	public StringProperty placaCarroProperty() {
		return placaCarro;
	}

	public StringProperty modeloCarroProperty() {
		return modeloCarro;
	}

	public StringProperty versaoCarroProperty() {
		return versaoCarro;
	}

	public StringProperty marcaCarroProperty() {
		return marcaCarro;
	}

	public StringProperty valorCarroProperty() {
		return valorCarro;
	}

	public StringProperty valorDescontoCarroProperty() {
		return valorDescontoCarro;
	}

	public StringProperty valorFinalCarroProperty() {
		return valorFinalCarro;
	}

	@Override
	public Venda boundaryToEntity() throws SQLException {
		Venda venda = new Venda();
		Carro carro = new Carro();
		Vendedor vendedor = new Vendedor();

		placaEntity = placaCarro.get();
		placaEntity = placaEntity.replace("-", "");
		carro.setPlaca(placaEntity);
		carro = carroDAO.selectOne(carro);

		try {
			vendedor.setFuncional(Integer.parseInt(codigoVendedor.get()));
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		vendedor = vendedorDAO.selectOne(vendedor);
		venda.setCarro(carro);
		venda.setVendedor(vendedor);
		return venda;
	}

	@Override
	public void entityToBoundary(Venda v) {
		if (v != null) {
			nomeVendedor.set(v.getVendedor().getNome());
			telefoneVendedor.set(v.getVendedor().getTelefone());
			cargoVendedor.set(v.getVendedor().getCargo());
			modeloCarro.set(v.getCarro().getModelo());
			versaoCarro.set(v.getCarro().getVersao());
			marcaCarro.set(v.getCarro().getMarca());
			valorCarro.set(String.valueOf(df.format(v.getCarro().getValor())));
			if(v.getCarro().getValorFinal() == 0) {
				valorDescontoCarro.set("0");
			}else {
				valorDescontoCarro.set(String.valueOf(df.format(v.getCarro().getValor() - v.getCarro().getValorFinal())));
			}
			valorFinalCarro.set(String.valueOf(df.format(v.getCarro().getValorFinal())));

		}

	}

	@Override
	public void adicionar() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		System.out.println(v.toString());
		v.getCarro().setSituacao("V");
		v.setData_venda(LocalDate.now());
		vendaDAO.insert(v);
		carroDAO.update(v.getCarro());
	}

	public void procurarDesconto() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		descontoCoR.proximoDesconto(v);
		System.out.println(v.getCarro().getValorFinal());
		entityToBoundary(v);
	}

	@Override
	public void pesquisar() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		entityToBoundary(v);
	}

}
