package boundary;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BoundaryMenu extends Application {
	private Button btnCadastrarCarro = new Button("Cadastrar Carro");
	private Button btnPesquisarCarro = new Button("Pesquisar Carro");
	private Button btnCadastrarFuncionario = new Button("Cadastrar Funcionario");
	private Button btnCadastrarCliente = new Button("Cadastrar Cliente");
	private Button btnCadastrarVenda = new Button("Cadastrar Venda");
	
	private Button btnGerarTableVendas = new Button("Tabela Vendas");
	private Button btnGerarTableFuncionarios = new Button("Tabela Funcionarios");
	private Button btnGerarTableCarros = new Button("Tabela Carros");
	private Button btnGerarTableClientes = new Button("Tabela Clientes");

	public void start(Stage stage) throws Exception {
		
		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		
			
		GridPane gridMenu = new GridPane();
		gridMenu.add(btnPesquisarCarro, 0, 0);
		gridMenu.add(btnCadastrarCarro, 0, 1);
		gridMenu.add(btnCadastrarFuncionario, 1, 1);
		gridMenu.add(btnCadastrarCliente, 2, 1);
		gridMenu.add(btnCadastrarVenda, 3, 1);
		gridMenu.add(btnGerarTableCarros, 0, 2);
		gridMenu.add(btnGerarTableFuncionarios, 1, 2);
		gridMenu.add(btnGerarTableClientes, 2, 2);
		gridMenu.add(btnGerarTableVendas, 3, 2);

		gridMenu.setHgap(50);
		gridMenu.setVgap(25);
		gridMenu.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		gridMenu.setAlignment(Pos.CENTER);
		
		BorderPane borderMenu = new BorderPane();
		borderMenu.setCenter(gridMenu);
		borderMenu.setBackground(new Background(background));
		
//		Bindings.bindBidirectional(boxTable.valueProperty(), subtable.boxTableProperty());		
		btnPesquisarCarro.setOnAction(e -> pesquisarCarro());
		btnCadastrarCarro.setOnAction(e -> cadastrarCarro());
		btnCadastrarVenda.setOnAction(e -> cadastrarVenda());
		btnCadastrarFuncionario.setOnAction(e -> cadastrarFuncionario());
		btnCadastrarCliente.setOnAction(e -> cadastrarCliente());
		btnGerarTableVendas.setOnAction(e -> gerarTableVendas());
		btnGerarTableCarros.setOnAction(e -> gerarTableCarros());
		btnGerarTableClientes.setOnAction(e -> gerarTableClientes());
		btnGerarTableFuncionarios.setOnAction(e -> gerarTableFuncionarios());
		
//		btnGerarTable.setOnAction(e -> gerarTable());
		
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
	
	public void cadastrarCliente() {
		SubBoundaryCadastrarCliente clienteCadastrar = new SubBoundaryCadastrarCliente();
		try {
			clienteCadastrar.start(new Stage());
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
	
	public void gerarTableVendas() {
		SubBoundaryTableVendas gerarTable = new SubBoundaryTableVendas();
		try {
			gerarTable.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void gerarTableCarros() {
		SubBoundaryTableCarros gerarTable = new SubBoundaryTableCarros();
		try {
			gerarTable.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void gerarTableFuncionarios() {
		SubBoundaryTableFuncionarios gerarTable = new SubBoundaryTableFuncionarios();
		try {
			gerarTable.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void gerarTableClientes() {
		SubBoundaryTableClientes gerarTable = new SubBoundaryTableClientes();
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
