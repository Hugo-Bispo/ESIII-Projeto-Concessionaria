package boundary;

import java.sql.SQLException;

import control.TablesController;
import control.VendasCotroller;
import control.VendedorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubBoundaryTables extends Application {
	TablesController control = new TablesController();

	private ComboBox<String> boxTypePesquisa = new ComboBox<String>(
			FXCollections.observableArrayList("Carros", "Vendedores", "Vendas"));
	private Button btnPesquisar = new Button("Pesquisar");

	public void start(Stage stage) throws Exception {
		BorderPane tela_pane = new BorderPane();

//		TilePane_Pesquisa
		TilePane pesquisa_pane = new TilePane();
		pesquisa_pane.getChildren().addAll(new Label("Pesquisar por"), boxTypePesquisa, btnPesquisar);
		pesquisa_pane.setHgap(5);
		pesquisa_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		pesquisa_pane.setAlignment(Pos.CENTER);

		tela_pane.setTop(pesquisa_pane);
		tela_pane.setBottom(control.getTable());


		Scene snc = new Scene(tela_pane, 1280, 720);

		stage.setTitle("Tabelas");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}
}
