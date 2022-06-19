package boundary;

import java.sql.SQLException;

import control.VendasCotroller;
import control.VendedorController;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
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

public class Boundary_Vendas extends Application {
	VendedorController controlVendedor = new VendedorController();
	
	VendasCotroller controlVenda = new VendasCotroller();

	private Button btnNovoFuncionario = new Button("Criar Funcionario");
	private Button btnVender = new Button("Vender");

	private TextField txtFuncionalVendas = new TextField();
	private TextField txtPlaca = new TextField();
	private TextField txtValuePesquisa = new TextField();

	private DatePicker calendarDataVenda = new DatePicker();

	private Button btnPesquisar = new Button("Pesquisar");

	public void start(Stage stage) throws Exception {
		
		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
		
		BorderPane border_pane = new BorderPane();

//		TilePane Titulo e Button Cadastrar Cliente
		TilePane index_pane = new TilePane();
		index_pane.getChildren().addAll(TextStyle("Cadastro de Vendas"), btnNovoFuncionario);
		index_pane.setHgap(100);
		index_pane.setAlignment(Pos.CENTER);
		index_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");

		btnNovoFuncionario.setOnAction(e -> cadastrar_vendedor());

//		Gridpane para Cadastrar Venda de carro
		GridPane vendas_pane = new GridPane();
		vendas_pane.add(TextStyle("Codº Vendedor:"), 0, 0);
		vendas_pane.add(txtFuncionalVendas, 1, 0);
		vendas_pane.add(TextStyle("Placa Carro:"), 0, 1);
		vendas_pane.add(txtPlaca, 1, 1);
		vendas_pane.add(TextStyle("Data venda:"), 0, 2);
		vendas_pane.add(calendarDataVenda, 1, 2);
		vendas_pane.add(btnVender, 1, 3);
		vendas_pane.setHgap(5);
		vendas_pane.setVgap(10);
		vendas_pane.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtFuncionalVendas.textProperty(), controlVenda.funcionalProperty());
		Bindings.bindBidirectional(txtPlaca.textProperty(), controlVenda.placaProperty());
		Bindings.bindBidirectional(calendarDataVenda.valueProperty(), controlVenda.data_vendaObjectProperty());

		btnVender.setOnAction(e -> {
			try {
				controlVenda.adicionar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

//		GridPane Botões Pesquisa
		GridPane consulta_pane = new GridPane();
		consulta_pane.add(TextStyle("Pesquisar Vendas por Vendedor"), 0, 0);
		consulta_pane.add(txtValuePesquisa, 0, 1);
		consulta_pane.add(btnPesquisar, 1, 1);
		consulta_pane.setHgap(5);
		consulta_pane.setVgap(10);
		consulta_pane.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtValuePesquisa.textProperty(), controlVenda.txtValuePesquisaProperty());

		btnPesquisar.setOnAction(e -> controlVenda.pesquisar());

//		União GridPane Pesquisa e Cadastrar Venda
		GridPane PesquisaCadastra_pane = new GridPane();
		PesquisaCadastra_pane.add(vendas_pane, 0, 0);
		PesquisaCadastra_pane.add(consulta_pane, 1, 0);
		PesquisaCadastra_pane.setAlignment(Pos.CENTER);
		PesquisaCadastra_pane.setHgap(50);

//		BorderPane Definindo Posiçoes
		border_pane.setTop(index_pane);
		border_pane.setCenter(PesquisaCadastra_pane);
		border_pane.setBottom(controlVenda.getTable());
		border_pane.setBackground(new Background(background));
		BorderPane.setAlignment(controlVenda.getTable(), Pos.CENTER);

		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setTitle("Controle de Vendas");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();

	}

	public void cadastrar_vendedor() {
		SubBoundary_Vendedor vendedor = new SubBoundary_Vendedor();
		try {
			vendedor.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public GridPane GridStyle(GridPane grid) {
		GridPane paneStyle = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setStyle("-fx-text-fill: white;-fx-background-radius: 0px;-fx-border-radius: 0px;"
				+ "-fx-border-width: 5px;-fx-border-color: white;");

		return paneStyle;
	}
	
	public Text TextStyle(String texto) {
		Text text = new Text(texto);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-font: 24 arial;-fx-font-weight: bold;");
		return text;
	}

	public static void main(String[] args) {
		Application.launch(Boundary_Vendas.class, args);
	}

}
