package control.tables;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Vendedor;
import persistence.VendedorDAO;
import util.HibernateUtil;

public class TabelaFuncionarios implements ITables<Vendedor>{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	VendedorDAO vendedeorDAO = new VendedorDAO(sf);
	
	ObservableList<Vendedor> vendedorLista = FXCollections.observableArrayList();
	
	private TableView<Vendedor> tableVendedor = new TableView<>();

	@SuppressWarnings("unchecked")
	public TabelaFuncionarios() {
		vendedorLista.addAll(vendedeorDAO.selectAll());
		
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
		
		tableVendedor.setStyle("-fx-font: 14 arial");
	}

	public TableView<Vendedor> getTable() {
		return tableVendedor;
	}

}
