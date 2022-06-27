package control.tables;

import org.hibernate.SessionFactory;

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

		TableColumn<Carro, String> col4 = new TableColumn<>("Valor");
		col4.setCellValueFactory(new PropertyValueFactory<>("valor"));

		TableColumn<Carro, String> col5 = new TableColumn<>("Disponibilidade");
		col5.setCellValueFactory(new PropertyValueFactory<>("situacao"));

		TableColumn<Carro, String> col6 = new TableColumn<>("Data Cadastro");
		col6.setCellValueFactory(new PropertyValueFactory<>("data_cadastro"));

		TableColumn<Carro, String> col7 = new TableColumn<>("Ano");
		col7.setCellValueFactory(new PropertyValueFactory<>("ano"));

		tableCarro.getColumns().addAll(col1, col2, col3, col4, col5, col6, col7);
		
		tableCarro.setItems(carroLista);
		
		tableCarro.setStyle("-fx-font: 14 arial");
	}

	public TableView<Carro> getTable() {
		return tableCarro;
	}

}
