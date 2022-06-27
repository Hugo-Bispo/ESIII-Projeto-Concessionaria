package control.tables;

import java.time.LocalDate;

import org.hibernate.SessionFactory;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Cell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Venda;
import persistence.VendaDAO;
import util.HibernateUtil;

public class TabelaVendas implements ITables<Venda>{
	SessionFactory sf = HibernateUtil.getSessionFactory();
	VendaDAO vendaDAO = new VendaDAO(sf);
	
	private TableView<Venda> tableVenda = new TableView<>();
	ObservableList<Venda> vendaLista = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public TabelaVendas() {
		vendaLista.addAll(vendaDAO.selectAll());
		TableColumn<Venda, Integer> col1 = new TableColumn<>("Cod ºVendedor");
		col1.setCellValueFactory(cellData -> (new SimpleIntegerProperty(cellData.getValue().getVendedor().getFuncional()).asObject()));
		
		TableColumn<Venda, String> col2 = new TableColumn<>("Nome Vendedor");
		col2.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVendedor().getNome()));
		
		TableColumn<Venda, String> col3 = new TableColumn<>("CPF Cliente");
		col3.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getCPF()));
		
		TableColumn<Venda, String> col4 = new TableColumn<>("Nome Cliente");
		col4.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCliente().getNome()));

		TableColumn<Venda, String> col5 = new TableColumn<>("Placa");
		col5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarro().getPlaca()));
		
		TableColumn<Venda, String> col6 = new TableColumn<>("Modelo");
		col6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarro().getModelo()));
		
		TableColumn<Venda, String> col7 = new TableColumn<>("Vesao");
		col7.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarro().getVersao()));

		TableColumn<Venda, Integer> col8 = new TableColumn<>("Ano");
		col8.setCellValueFactory(cellData -> (new SimpleIntegerProperty(cellData.getValue().getCarro().getAno()).asObject()));
		
		TableColumn<Venda, Double> col9 = new TableColumn<>("Valor");
		col9.setCellValueFactory(cellData -> (new SimpleDoubleProperty(cellData.getValue().getCarro().getValor()).asObject()));
		
		TableColumn<Venda, Double> col10 = new TableColumn<>("Valor Final");
		col10.setCellValueFactory(cellData -> (new SimpleDoubleProperty(cellData.getValue().getCarro().getValorFinal()).asObject()));
		
//		TableColumn<Venda, String> col11 = new TableColumn<>("Data da Venda");
//		col11.setCellValueFactory(cellData -> (new SimpleStringProperty(cellData.getValue().getData_venda())));

		tableVenda.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col8, col9, col10);
		
		tableVenda.setItems(vendaLista);
		
		tableVenda.setStyle("-fx-font: 14 arial");
	}

	public TableView<Venda> getTable() {
		return tableVenda;
	}

}
