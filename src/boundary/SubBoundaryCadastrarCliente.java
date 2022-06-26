package boundary;

import java.sql.SQLException;

import control.ClienteController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SubBoundaryCadastrarCliente extends Application{

	ClienteController clienteController = new ClienteController();
	
	private Button btnCriar = new Button("Cadastrar");
	private Button btnAtualizar = new Button("Atualizar");
	private Button btnExcluir = new Button("Excluir");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private TextField txtCPF = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtTelefone = new TextField();
	private TextField txtRua = new TextField();
	private TextField txtNumero = new TextField();
	private TextField txtCEP = new TextField();
	private TextField txtBairro = new TextField();
	private TextField txtCidade = new TextField();

	public void start(Stage stage) throws Exception {
		
		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		
		BorderPane tela_pane = new BorderPane();
//		TilePane Menu Cadastrar
		TilePane menuPane = new TilePane();
		menuPane.getChildren().addAll(TextStyle("Cadastrar Cliente"), btnCriar, btnPesquisar, btnExcluir, btnAtualizar);
		menuPane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		menuPane.setAlignment(Pos.CENTER);
		
//		Gridpane para Cadastrar Vendedor
		GridPane vendedor_pane = new GridPane();
		vendedor_pane.add(TextStyle("Nome:"), 0, 0);
		vendedor_pane.add(txtNome, 1, 0);
		vendedor_pane.add(TextStyle("CPF:"), 2, 0);
		vendedor_pane.add(txtCPF, 3, 0);
		vendedor_pane.add(TextStyle("Telefone:"), 4, 0);
		vendedor_pane.add(txtTelefone, 5, 0);
		vendedor_pane.add(TextStyle("Logadouro:"), 0, 1);
		vendedor_pane.add(txtRua, 1, 1);
		vendedor_pane.add(TextStyle("Numero:"), 2, 1);
		vendedor_pane.add(txtNumero, 3, 1);
		vendedor_pane.add(TextStyle("CEP:"), 4, 1);
		vendedor_pane.add(txtCEP, 5, 1);
		vendedor_pane.add(TextStyle("Bairro:"), 0, 2);
		vendedor_pane.add(txtBairro, 1, 2);
		vendedor_pane.add(TextStyle("Cidade:"), 2, 2);
		vendedor_pane.add(txtCidade, 3, 2);
		vendedor_pane.setHgap(5);
		vendedor_pane.setVgap(10);
		vendedor_pane.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		vendedor_pane.setAlignment(Pos.CENTER);
		
		Bindings.bindBidirectional(txtNome.textProperty(), clienteController.nomeClienteProperty());
		Bindings.bindBidirectional(txtCPF.textProperty(), clienteController.cpfClienteProperty());
		Bindings.bindBidirectional(txtTelefone.textProperty(), clienteController.telefoneClienteProperty());
		Bindings.bindBidirectional(txtRua.textProperty(), clienteController.ruaClienteProperty());
		Bindings.bindBidirectional(txtNumero.textProperty(), clienteController.numeroClienteProperty());
		Bindings.bindBidirectional(txtCEP.textProperty(), clienteController.cepClienteProperty());
		Bindings.bindBidirectional(txtBairro.textProperty(), clienteController.bairroClienteProperty());
		Bindings.bindBidirectional(txtCidade.textProperty(), clienteController.cidadeClienteProperty());
		
		btnCriar.setOnAction(e -> {
			try {
				clienteController.adicionar();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		btnPesquisar.setOnAction(e -> {
			try {
				clienteController.pesquisar();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		btnAtualizar.setOnAction(e -> {
			try {
				clienteController.atualizar();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		btnExcluir.setOnAction(e -> {
			try {
				clienteController.excluir();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});
		
		tela_pane.setTop(menuPane);
		tela_pane.setCenter(vendedor_pane);
		tela_pane.setBackground(new Background(background));
		
		Scene snc = new Scene(tela_pane, 1280, 400);
		stage.setTitle("Pesquisar Funcionario");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}
	
	public Text TextStyle(String texto) {
		Text text = new Text(texto);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-font: 24 arial;-fx-font-weight: bold;");
		return text;
	}
}
