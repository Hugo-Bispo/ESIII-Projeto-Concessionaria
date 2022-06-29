package control.tables;

import org.hibernate.SessionFactory;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Carro;
import persistence.CarroDAO;
import util.HibernateUtil;

public class TabelaCarros implements ITables<Carro>{
	private SessionFactory sf = HibernateUtil.getSessionFactory();
	private CarroDAO carroDAO = new CarroDAO(sf);
	
	private TableView<Carro> tableCarro = new TableView<>();
	ObservableList<Carro> carroLista = FXCollections.observableArrayList();

	@SuppressWarnings("unchecked")
	public TabelaCarros() {
		carroLista.addAll(carroDAO.selectAll());
		TableColumn<Carro, Integer> col1 = new TableColumn<>("Placa Carro");
		col1.setCellValueFactory(new PropertyValueFactory<>("placa"));

		TableColumn<Carro, String> col2 = new TableColumn<>("Versão");
		col2.setCellValueFactory(new PropertyValueFactory<>("versao"));

		TableColumn<Carro, String> col3 = new TableColumn<>("Marca");
		col3.setCellValueFactory(new PropertyValueFactory<>("marca"));

		TableColumn<Carro, String> col4 = new TableColumn<>("Ano");
		col4.setCellValueFactory(new PropertyValueFactory<>("ano"));
		
		TableColumn<Carro, String> col5 = new TableColumn<>("Cor");
		col5.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarroCaracteristicas().getCor()));
		
		TableColumn<Carro, String> col6 = new TableColumn<>("Câmbio");
		col6.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCarroCaracteristicas().getCambio()));
		
		TableColumn<Carro, Double> col7 = new TableColumn<>("Motor");
		col7.setCellValueFactory(cellData -> (new SimpleDoubleProperty(cellData.getValue().getCarroCaracteristicas().getCilindrada()).asObject()));
		
		TableColumn<Carro, Double> col8 = new TableColumn<>("Quilimetragem");
		col8.setCellValueFactory(cellData -> (new SimpleDoubleProperty(cellData.getValue().getCarroCaracteristicas().getQuilometragem()).asObject()));
		
		TableColumn<Carro, String> col9 = new TableColumn<>("Valor");
		col9.setCellValueFactory(new PropertyValueFactory<>("valor"));

		TableColumn<Carro, String> col10 = new TableColumn<>("Disponibilidade");
		col10.setCellValueFactory(new PropertyValueFactory<>("situacao"));

		TableColumn<Carro, String> col11 = new TableColumn<>("Data Cadastro");
		col11.setCellValueFactory(new PropertyValueFactory<>("data_cadastro"));;

		tableCarro.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7, col9, col10, col11);
		
		tableCarro.setMinSize(720, 480);
		tableCarro.setItems(carroLista);
		
		tableCarro.setStyle("-fx-font: 14 arial");
	}

	public TableView<Carro> getTable() {
		return tableCarro;
	}

}
