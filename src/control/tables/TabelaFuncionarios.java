package control.tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vendedor;

public class TabelaFuncionarios {
	private TableView<Vendedor> tableVendedor = new TableView<>();
	private StringProperty boxTypePesquisa = new SimpleStringProperty("");
	ObservableList<Vendedor> vendedorLista = FXCollections.observableArrayList();

	public StringProperty boxTypePesquisaProperty() {
		return boxTypePesquisa;
	}

	@SuppressWarnings("unchecked")
	public TabelaFuncionarios() {
		TableColumn<Vendedor, Integer> col1 = new TableColumn<>("Cod ºVendedor");
		col1.setCellValueFactory(new PropertyValueFactory<>("funcional"));

		TableColumn<Vendedor, String> col2 = new TableColumn<>("Nome");
		col2.setCellValueFactory(new PropertyValueFactory<>("nome"));

		TableColumn<Vendedor, String> col3 = new TableColumn<>("Telefone");
		col3.setCellValueFactory(new PropertyValueFactory<>("telefone"));

		TableColumn<Vendedor, String> col4 = new TableColumn<>("Cargo");
		col4.setCellValueFactory(new PropertyValueFactory<>("cargo"));

		tableVendedor.getColumns().addAll(col1, col2, col3, col4);
		
		tableVendedor.setItems(vendedorLista);
		
		tableVendedor.setMinSize(1000, 500);
		tableVendedor.setMaxSize(1000, 500);
	}

	public TableView<Vendedor> getTable() {
		return tableVendedor;
	}

}
