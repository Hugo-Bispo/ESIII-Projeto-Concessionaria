package control;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.SessionFactory;

import model.Carro;
import model.Venda;
import model.Vendedor;
import persistence.CarroDAO;
import persistence.VendaDAO;
import persistence.VendedorDAO;
import util.HibernateUtil;
import javafx.beans.property.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class VendasCotroller implements Controller_Interfaces<Venda> {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	CarroDAO carroDAO = new CarroDAO(sf);
	VendaDAO vendaDAO = new VendaDAO(sf);
	VendedorDAO vendedorDAO = new VendedorDAO(sf);

	ObservableList<Venda> vendasLista = FXCollections.observableArrayList();

	private StringProperty funcional = new SimpleStringProperty("");
	private StringProperty placa = new SimpleStringProperty("");
	private ObjectProperty<LocalDate> data_venda = new SimpleObjectProperty<LocalDate>();
	private StringProperty boxPesquisa = new SimpleStringProperty("");
	private StringProperty txtValuePesquisa = new SimpleStringProperty("");

	private String placaEntity;

	private TableView<Venda> table = new TableView<>();

	public StringProperty funcionalProperty() {
		return funcional;
	}

	public StringProperty placaProperty() {
		return placa;
	}

	public ObjectProperty<LocalDate> data_vendaObjectProperty() {
		return data_venda;
	}

	public StringProperty boxPesquisaProperty() {
		return boxPesquisa;
	}

	public StringProperty txtValuePesquisaProperty() {
		return txtValuePesquisa;
	}

	@SuppressWarnings("unchecked")

	public VendasCotroller() {
		System.out.println(vendasLista.toString());
		TableColumn<Venda, Integer> col1 = new TableColumn<>("Codº Vendedor");
		col1.setCellValueFactory(new PropertyValueFactory<>("funcional"));

		TableColumn<Venda, String> col2 = new TableColumn<>("Placa Carro");
		col2.setCellValueFactory(new PropertyValueFactory<>("placa"));

		TableColumn<Venda, String> col3 = new TableColumn<>("Modelo");
		col3.setCellValueFactory(new PropertyValueFactory<>("modelo"));

		TableColumn<Venda, String> col4 = new TableColumn<>("Versão");
		col4.setCellValueFactory(new PropertyValueFactory<>("versao"));

		TableColumn<Venda, String> col5 = new TableColumn<>("Marca");
		col5.setCellValueFactory(new PropertyValueFactory<>("marca"));

		TableColumn<Venda, String> col6 = new TableColumn<>("Câmbio");
		col6.setCellValueFactory(new PropertyValueFactory<>("cambio"));

		TableColumn<Venda, String> col7 = new TableColumn<>("Cor");
		col7.setCellValueFactory(new PropertyValueFactory<>("cor"));

		TableColumn<Venda, String> col8 = new TableColumn<>("Data");

		col8.setCellValueFactory((itemData) -> {
			LocalDate dt = itemData.getValue().getData_venda();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return new ReadOnlyStringWrapper(dt.format(formatter));
		});

		TableColumn<Venda, Double> col9 = new TableColumn<>("Valor");
		col9.setCellValueFactory(new PropertyValueFactory<>("valor"));

		table.setItems(vendasLista);
//		table.getColumns().addAll(col1, col8);
		table.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9);

		table.setMinSize(1000, 300);
		table.setMaxSize(1000, 300);
	}

	@Override
	public Venda boundaryToEntity() throws SQLException {
		Venda venda = new Venda();
		Carro carro = new Carro();
		Vendedor vendedor = new Vendedor();

		placaEntity = placa.get();
		placaEntity = placaEntity.replace("-", "");
		carro.setPlaca(placaEntity);
		carro = carroDAO.selectOne(carro);
		
		try {
			vendedor.setFuncional(Integer.parseInt(funcional.get()));
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		vendedor = vendedorDAO.selectOne(vendedor);
		venda.setCarro(carro);
		venda.setVendedor(vendedor);
		venda.setData_venda(data_venda.get());
		return venda;
	}

	@Override
	public void entityToBoundary(Venda v) {
//		if (v != null) {
//			funcional.set(v.getPlaca());
//			placa.set(v.getPlaca());
//			data_venda.set(v.getData_venda());
//		}

	}

	@Override
	public void adicionar() throws SQLException {
		Venda v = new Venda();
		v = boundaryToEntity();
		System.out.println(v.toString());
		v.getCarro().setSituacao("V");
		vendaDAO.insert(v);
		carroDAO.update(v.getCarro());
//		vendasLista.add(v);
	}

	@Override
	public void pesquisar() {
//		List<Venda> lista = dao.consultarVendaFuncional(txtValuePesquisa.get());
//		vendasLista.clear();
//		vendasLista.addAll(lista);
//		System.out.println(vendasLista.toString());
	}

	public TableView<Venda> getTable() {
		return table;
	}

}
