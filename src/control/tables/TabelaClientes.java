package control.tables;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Cliente;
import persistence.ClienteDAO;
import util.HibernateUtil;

public class TabelaClientes implements ITables<Cliente>{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	ClienteDAO clienteDAO = new ClienteDAO(sf);
	
	ObservableList<Cliente> vendedorLista = FXCollections.observableArrayList();
	
	private TableView<Cliente> tableCliente = new TableView<>();

	@SuppressWarnings("unchecked")
	public TabelaClientes() {
		vendedorLista.addAll(clienteDAO.selectAll());
		
		TableColumn<Cliente, String> col1 = new TableColumn<>("CPF");
		col1.setCellValueFactory(new PropertyValueFactory<>("CPF"));

		TableColumn<Cliente, String> col2 = new TableColumn<>("Nome");
		col2.setCellValueFactory(new PropertyValueFactory<>("nome"));

		TableColumn<Cliente, String> col3 = new TableColumn<>("Telefone");
		col3.setCellValueFactory(new PropertyValueFactory<>("telefone"));

		TableColumn<Cliente, String> col4 = new TableColumn<>("Endereco");
		col4.setCellValueFactory(new PropertyValueFactory<>("endereco"));

		tableCliente.getColumns().addAll(col1, col2, col3, col4);
		
		tableCliente.setItems(vendedorLista);
		
		tableCliente.setStyle("-fx-font: 14 arial");
	}

	public TableView<Cliente> getTable() {
		return tableCliente;
	}

}
