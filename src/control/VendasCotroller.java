package control;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;

import org.hibernate.SessionFactory;

import control.descontoCoR.DescontoMarca;
import model.Venda;
import model.VendaBuilder;
import persistence.CarroDAO;
import persistence.VendaDAO;
import persistence.VendedorDAO;
import util.HibernateUtil;
import javafx.beans.property.*;

public class VendasCotroller{
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

	public Venda boundaryToEntity() throws SQLException {
		placaEntity = placaCarro.get();
		placaEntity = placaEntity.replace("-", "");
		int funcionalEntity = 0;
		funcionalEntity = Integer.parseInt(codigoVendedor.get());
		
		Venda venda = VendaBuilder.builder()
				.addPlaca(placaEntity)
				.addFuncional(funcionalEntity)
				.addDataVenda(LocalDate.now())
				.get();
		
		venda.setCarro(carroDAO.selectOne(venda.getCarro()));
		venda.setVendedor(vendedorDAO.selectOne(venda.getVendedor()));
		return venda;
	}

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

	public void adicionar() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		v.getCarro().setSituacao("V");
		vendaDAO.insert(v);
		carroDAO.update(v.getCarro());
	}

	public void procurarDesconto() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		descontoCoR.proximoDesconto(v);
		entityToBoundary(v);
	}

	public void pesquisar() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		entityToBoundary(v);
	}
}
