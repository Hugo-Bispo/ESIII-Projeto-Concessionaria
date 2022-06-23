package control;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Carro;

public class TablesController {
	private TableView<Carro> tableCarro = new TableView<>();
	private StringProperty boxTypePesquisa = new SimpleStringProperty("");
	ObservableList<Carro> carroLista = FXCollections.observableArrayList();

	public StringProperty boxTypePesquisaProperty() {
		return boxTypePesquisa;
	}

	@SuppressWarnings("unchecked")
	public TablesController() {
		TableColumn<Carro, Integer> col1 = new TableColumn<>("Placa Carro");
		col1.setCellValueFactory(new PropertyValueFactory<>("placa"));

		TableColumn<Carro, String> col2 = new TableColumn<>("Versão");
		col2.setCellValueFactory(new PropertyValueFactory<>("versao"));

		TableColumn<Carro, String> col3 = new TableColumn<>("Marca");
		col3.setCellValueFactory(new PropertyValueFactory<>("marca"));

		TableColumn<Carro, String> col4 = new TableColumn<>("Valor");
		col4.setCellValueFactory(new PropertyValueFactory<>("valor"));

		TableColumn<Carro, String> col5 = new TableColumn<>("Disponibilidade");
		col5.setCellValueFactory(new PropertyValueFactory<>("disponibilidade"));

		TableColumn<Carro, String> col6 = new TableColumn<>("Data Cadastro");
		col6.setCellValueFactory(new PropertyValueFactory<>("data cadastro"));

		TableColumn<Carro, String> col7 = new TableColumn<>("Ano");
		col7.setCellValueFactory(new PropertyValueFactory<>("ano"));

		tableCarro.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
		
		tableCarro.setItems(carroLista);
		
		tableCarro.setMinSize(1000, 500);
		tableCarro.setMaxSize(1000, 500);
	}

	public TableView<Carro> getTable() {
		return tableCarro;
	}

}
