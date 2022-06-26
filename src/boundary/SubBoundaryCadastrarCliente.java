package boundary;

import java.sql.SQLException;

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
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubBoundaryCadastrarCliente extends Application{

	private Button btnCriar = new Button("Cadastrar");
	private Button btnAtualizar = new Button("Atualizar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private TextField txtCPFCNJP = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private ComboBox<String> boxCargo = new ComboBox<String>(FXCollections.observableArrayList("Vendedor", "Gerente"));

	public void start(Stage stage) throws Exception {
		
//		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
//				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
//				BackgroundSize.DEFAULT);
//		
//		BorderPane tela_pane = new BorderPane();
//
////		Gridpane para Cadastrar Vendedor
//		GridPane vendedor_pane = new GridPane();
//		vendedor_pane.add(new Text("Cadastrar Cliente"), 0, 0);
//		vendedor_pane.add(new Label("Nome:"), 0, 1);
//		vendedor_pane.add(txtNome, 1, 1);
//		vendedor_pane.add(new Label("CPF/CNPJ:"), 0, 2);
//		vendedor_pane.add(txtCPFCNJP, 1, 2);
//		vendedor_pane.add(new Label("Telefone:"), 0, 3);
//		vendedor_pane.add(txtTelefone, 1, 3);
//		vendedor_pane.add(btnCriar, 0, 4);
//		vendedor_pane.add(btnPesquisar, 1, 4);
//		vendedor_pane.add(btnExcluir, 0, 5);
//		vendedor_pane.add(btnAtualizar, 1, 5);
//		vendedor_pane.setHgap(5);
//		vendedor_pane.setVgap(10);
//		vendedor_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
//		vendedor_pane.setAlignment(Pos.CENTER);
//
//		tela_pane.setCenter(vendedor_pane);
//		tela_pane.setBackground(new Background(background));
//
//		Bindings.bindBidirectional(txtFuncionalVendedor.textProperty(), controlVendedor.funcionalProperty());
//		Bindings.bindBidirectional(txtNome.textProperty(), controlVendedor.nomeProperty());
//		Bindings.bindBidirectional(txtTelefone.textProperty(), controlVendedor.telefoneProperty());
//		Bindings.bindBidirectional(boxCargo.valueProperty(), controlVendedor.cargoProperty());
//
//		btnCriar.setOnAction(e -> {
//			try {
//				controlVendedor.adicionar();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		});
//		
//		btnPesquisar.setOnAction(e -> {
//			try {
//				controlVendedor.pesquisar();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		});
//
//		btnAtualizar.setOnAction(e -> {
//			try {
//				controlVendedor.atualizar();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		});
//		
//		btnExcluir.setOnAction(e -> {
//			try {
//				controlVendedor.excluir();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		});
		
//		Scene snc = new Scene(tela_pane, 720, 480);
//		stage.setTitle("Pesquisar Funcionario");
//		stage.setResizable(false);
//		stage.setScene(snc);
//		stage.show();
	}
}
