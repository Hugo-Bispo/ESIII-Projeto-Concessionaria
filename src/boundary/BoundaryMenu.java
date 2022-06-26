package boundary;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoundaryMenu extends Application {
	
	private ComboBox<String> typeTable = new ComboBox<String>(FXCollections.observableArrayList("Vendas", "Funcionarios", "Carros", "Clientes"));
	
	private Button btnCadastrarCarro = new Button("Cadastrar Carro");
	private Button btnPesquisarCarro = new Button("Pesquisar Carro");
	private Button btnCadastrarFuncionario = new Button("Cadastrar Funcionario");
	private Button btnCadastrarCliente = new Button("Cadastrar Cliente");
	private Button btnCadastrarVenda = new Button("Cadastrar Venda");
	private Button btnGerarTable = new Button("Gerar Tabela");
	
	private Text textPesquisarTable = new Text("Pesquisar por: ");

	public void start(Stage stage) throws Exception {
		
		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		
		textPesquisarTable.setFill(Color.WHITE);
			
		GridPane gridMenu = new GridPane();
		gridMenu.add(btnCadastrarCarro, 0, 0);
		gridMenu.add(btnPesquisarCarro, 1, 0);
		gridMenu.add(btnCadastrarFuncionario, 0, 1);
		gridMenu.add(btnCadastrarCliente, 1, 1);
		gridMenu.add(btnCadastrarVenda, 0, 2);
		gridMenu.add(textPesquisarTable, 0, 3);
		gridMenu.add(typeTable, 1, 3);
		gridMenu.add(btnGerarTable, 2, 3);
		gridMenu.setHgap(50);
		gridMenu.setVgap(25);
		gridMenu.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		gridMenu.setAlignment(Pos.CENTER);
		
		BorderPane borderMenu = new BorderPane();
		borderMenu.setCenter(gridMenu);
		borderMenu.setBackground(new Background(background));
		
		btnPesquisarCarro.setOnAction(e -> pesquisarCarro());
		btnCadastrarCarro.setOnAction(e -> cadastrarCarro());
		btnCadastrarVenda.setOnAction(e -> cadastrarVenda());
		btnCadastrarFuncionario.setOnAction(e -> cadastrarFuncionario());
		btnGerarTable.setOnAction(e -> gerarTable());
		
		Scene snc = new Scene(borderMenu, 1280, 720);

		stage.setTitle("Menu");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}
	
	public void cadastrarCarro() {
		SubBoundaryCadastrarCarro carroCadastrar = new SubBoundaryCadastrarCarro();
		try {
			carroCadastrar.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void pesquisarCarro() {
		SubBoundaryPesquisarCarro carroPesquisar = new SubBoundaryPesquisarCarro();
		try {
			carroPesquisar.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void cadastrarFuncionario() {
		SubBoundaryCadastrarFuncionario funcionarioCadastrar = new SubBoundaryCadastrarFuncionario();
		try {
			funcionarioCadastrar.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void cadastrarVenda() {
		SubBoundaryCadastrarVenda vendaCadastrar = new SubBoundaryCadastrarVenda();
		try {
			vendaCadastrar.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void gerarTable() {
		SubBoundaryTables gerarTable = new SubBoundaryTables();
		try {
			gerarTable.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	

	public static void main(String[] args) {
		Application.launch(args);
	}
}
