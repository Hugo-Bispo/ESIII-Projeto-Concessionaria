package control.tables;

import org.hibernate.SessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Venda;
import persistence.VendaDAO;
import util.HibernateUtil;

public class TabelaVendas implements ITableStrategy<Venda>{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	VendaDAO vendaDAO = new VendaDAO(sf);
	
	private TableView<Venda> tableVenda = new TableView<>();
	ObservableList<Venda> vendaLista = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public TabelaVendas() {
		vendaLista.addAll(vendaDAO.selectAll());
		TableColumn<Venda, Integer> col1 = new TableColumn<>("Cod ºVendedor");
		col1.setCellValueFactory(new PropertyValueFactory<>("vendedor"));

		TableColumn<Venda, String> col2 = new TableColumn<>("Placa do Carro");
		col2.setCellValueFactory(new PropertyValueFactory<>("carro"));

		TableColumn<Venda, String> col3 = new TableColumn<>("Data da Venda");
		col3.setCellValueFactory(new PropertyValueFactory<>("data_venda"));

		tableVenda.getColumns().addAll(col1, col2, col3);
		
		tableVenda.setItems(vendaLista);
		
		tableVenda.setStyle("-fx-font: 14 arial");
	}

	public TableView<Venda> getTable() {
		return tableVenda;
	}

}
