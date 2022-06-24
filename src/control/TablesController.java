package control;

import org.hibernate.SessionFactory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Carro;
import persistence.CarroDAO;
import util.HibernateUtil;

public class TablesController {
	SessionFactory sf = HibernateUtil.getSessionFactory();
	CarroDAO carroDAO = new CarroDAO(sf);

	private TableView<Carro> tableCarro = new TableView<>();
	private StringProperty boxTypePesquisa = new SimpleStringProperty("");
	ObservableList<Carro> carroLista = FXCollections.observableArrayList();

	public StringProperty boxTypePesquisaProperty() {
		return boxTypePesquisa;
	}

	@SuppressWarnings("unchecked")
	public TablesController() {

		carroLista.addAll(carroDAO.selectAll());
		System.out.println(carroLista.toString());

		TableColumn<Carro, Integer> col1 = new TableColumn<>("Placa Carro");
		col1.setCellValueFactory(new PropertyValueFactory<>("placa"));

		TableColumn<Carro, String> col2 = new TableColumn<>("Versão");
		col2.setCellValueFactory(new PropertyValueFactory<>("versao"));

		TableColumn<Carro, String> col3 = new TableColumn<>("Marca");
		col3.setCellValueFactory(new PropertyValueFactory<>("marca"));

		TableColumn<Carro, String> col4 = new TableColumn<>("Ano");
		col4.setCellValueFactory(new PropertyValueFactory<>("ano"));

		TableColumn<Carro, String> col5 = new TableColumn<>("Câmbio");
		col5.setCellValueFactory(new PropertyValueFactory<>("cambio"));

		TableColumn<Carro, String> col6 = new TableColumn<>("Motor");
		col6.setCellValueFactory(new PropertyValueFactory<>("cilindrada"));

		TableColumn<Carro, String> col7 = new TableColumn<>("Cor");
		col7.setCellValueFactory(new PropertyValueFactory<>("cor"));

		TableColumn<Carro, String> col8 = new TableColumn<>("Combustivel");
		col8.setCellValueFactory(new PropertyValueFactory<>("combustivel"));

		TableColumn<Carro, String> col9 = new TableColumn<>("Data Cadastro");
		col9.setCellValueFactory(new PropertyValueFactory<>("data_cadastro"));

		TableColumn<Carro, String> col10 = new TableColumn<>("Valor");
		col10.setCellValueFactory(new PropertyValueFactory<>("valor"));

		TableColumn<Carro, String> col11 = new TableColumn<>("Disponibilidade");
		col11.setCellValueFactory(new PropertyValueFactory<>("situacao"));

		tableCarro.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10, col11);

		tableCarro.setItems(carroLista);

		tableCarro.setMinSize(1000, 500);
		tableCarro.setMaxSize(1000, 500);
	}

	public TableView<Carro> getTable() {
		return tableCarro;
	}

}
