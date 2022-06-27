package boundary;

import java.sql.SQLException;

import control.VendasCotroller;
import control.VendedorController;
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

public class SubBoundaryCadastrarVenda extends Application{
	VendedorController controlVendedor = new VendedorController();

	VendasCotroller controlVenda = new VendasCotroller();

	private Button btnVender = new Button("Vender");
	private Button btnProcurarDesconto = new Button("Desconto");

	private TextField txtFuncionalVendas = new TextField();
	private TextField txtPlaca = new TextField();
	private TextField txtClienteCPF = new TextField();
	
	private Button btnPesquisarCarro = new Button("Pesquisar");
	private Button btnPesquisarVendedor = new Button("Pesquisar");
	private Button btnPesquisarCliente = new Button("Pesquisar");

	private Text textNomeVendedor = new Text();
	private Text textTelefoneVendedor = new Text();
	private Text textCargo = new Text();

	private Text textModelo = new Text();
	private Text textVersao = new Text();
	private Text textMarca = new Text();
	private Text textValor = new Text();
	private Text textDesconto = new Text();
	private Text textValorFinal = new Text();
	
	private Text textNomeCliente = new Text();
	private Text textTelefoneCliente = new Text();
	private Text textCpfCliente = new Text();


	public void start(Stage stage) throws Exception {

		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);

		BorderPane border_pane = new BorderPane();

//		TilePane Titulo e Button Cadastrar Cliente
		TilePane index_pane = new TilePane();
		index_pane.getChildren().addAll(TextStyle("Cadastro de Vendas"));
		index_pane.setHgap(100);
		index_pane.setAlignment(Pos.CENTER);
		index_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");

//		Gridpane para Pesquisar Informacao
		GridPane pesquisa_pane = new GridPane();
		pesquisa_pane.add(TextStyle("Codº Vendedor:"), 0, 0);
		pesquisa_pane.add(txtFuncionalVendas, 1, 0);
		pesquisa_pane.add(btnPesquisarVendedor, 2, 0);
		
		pesquisa_pane.add(TextStyle("Placa Carro:"), 0, 1);
		pesquisa_pane.add(txtPlaca, 1, 1);
		pesquisa_pane.add(btnPesquisarCarro, 2, 1);
		
		pesquisa_pane.add(TextStyle("CPF Cliente:"), 0, 2);
		pesquisa_pane.add(txtClienteCPF, 1, 2);
		pesquisa_pane.add(btnPesquisarCliente, 2, 2);
		
		
		pesquisa_pane.setHgap(5);
		pesquisa_pane.setVgap(10);
		pesquisa_pane.setStyle("-fx-font: 18 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtFuncionalVendas.textProperty(), controlVenda.codigoVendedorProperty());
		Bindings.bindBidirectional(txtPlaca.textProperty(), controlVenda.placaCarroProperty());
		Bindings.bindBidirectional(txtClienteCPF.textProperty(), controlVenda.cpfClienteProperty());

		btnPesquisarCarro.setOnAction(e -> {
			try {
				controlVenda.pesquisar();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		});

//		Gridpane Informacao Vendedor
		GridPane vendedor_pane = new GridPane();
		vendedor_pane.add(TextStyle("Nome: ", textNomeVendedor), 0, 0);
		vendedor_pane.add(TextStyle("Telefone: ", textTelefoneVendedor), 1, 0);
		vendedor_pane.add(TextStyle("Cargo: ", textCargo), 2, 0);
		vendedor_pane.setHgap(5);

		Bindings.bindBidirectional(textNomeVendedor.textProperty(), controlVenda.nomeVendedorProperty());
		Bindings.bindBidirectional(textTelefoneVendedor.textProperty(), controlVenda.telefoneVendedorProperty());
		Bindings.bindBidirectional(textCargo.textProperty(), controlVenda.cargoVendedorProperty());

//		Gridpane Informacao Carro
		GridPane carro_pane = new GridPane();
		carro_pane.add(TextStyle("Modelo: ", textModelo), 0, 0);
		carro_pane.add(TextStyle("Versão: ", textVersao), 1, 0);
		carro_pane.add(TextStyle("Marca: ", textMarca), 2, 0);
		carro_pane.add(TextStyle("Valor: ", textValor), 0, 1);
		carro_pane.add(TextStyle("Desconto: ", textDesconto), 1, 1);
		carro_pane.add(TextStyle("Valor Final: ", textValorFinal), 2, 1);
		carro_pane.setHgap(5);
		carro_pane.setVgap(1);
		
		Bindings.bindBidirectional(textModelo.textProperty(), controlVenda.modeloCarroProperty());
		Bindings.bindBidirectional(textVersao.textProperty(), controlVenda.versaoCarroProperty());
		Bindings.bindBidirectional(textMarca.textProperty(), controlVenda.marcaCarroProperty());
		Bindings.bindBidirectional(textValor.textProperty(), controlVenda.valorCarroProperty());
		Bindings.bindBidirectional(textDesconto.textProperty(), controlVenda.valorDescontoCarroProperty());
		Bindings.bindBidirectional(textValorFinal.textProperty(), controlVenda.valorFinalCarroProperty());
		
//		Gridpane Informacao Cliente
		GridPane cliente_pane = new GridPane();
		cliente_pane.add(TextStyle("Nome: ", textNomeCliente), 0, 0);
		cliente_pane.add(TextStyle("Telefone: ", textTelefoneCliente), 1, 0);
		cliente_pane.add(TextStyle("CPF: ", textCpfCliente), 2, 0);
		cliente_pane.setHgap(5);

		Bindings.bindBidirectional(textNomeCliente.textProperty(), controlVenda.nomeClienteProperty());
		Bindings.bindBidirectional(textTelefoneCliente.textProperty(), controlVenda.telefoneClienteProperty());
		Bindings.bindBidirectional(textCpfCliente.textProperty(), controlVenda.cpfClienteProperty());


//		TilePane Botoes Vender e Desconto
		TilePane descontoVender_pane = new TilePane();
		descontoVender_pane.getChildren().addAll(btnProcurarDesconto, btnVender);
		descontoVender_pane.setHgap(20);
		descontoVender_pane.setAlignment(Pos.BOTTOM_CENTER);
		descontoVender_pane.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");

		btnVender.setOnAction(e -> {
			try {
				controlVenda.adicionar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

		btnProcurarDesconto.setOnAction(e -> {
			try {
				controlVenda.procurarDesconto();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		btnPesquisarCarro.setOnAction(e -> {
			try {
				controlVenda.pesquisar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
//		GridPane Uniao Vendedor e Carro

		GridPane informacaoVenda_pane = new GridPane();
		informacaoVenda_pane.add(pesquisa_pane, 0, 0);
		informacaoVenda_pane.add(TextStyle("Informações Venda"), 0, 1);
		informacaoVenda_pane.add(TextStyle("Vendedor"), 0, 2);
		informacaoVenda_pane.add(vendedor_pane, 0, 3);
		informacaoVenda_pane.add(TextStyle("Carro"), 0, 4);
		informacaoVenda_pane.add(carro_pane, 0, 5);
		informacaoVenda_pane.add(TextStyle("Cliente"), 0, 6);
		informacaoVenda_pane.add(cliente_pane, 0, 7);
		informacaoVenda_pane.add(descontoVender_pane, 0, 8);
		informacaoVenda_pane.setAlignment(Pos.CENTER);
		informacaoVenda_pane.setHgap(5);
		informacaoVenda_pane.setVgap(10);
		informacaoVenda_pane.setMinSize(300, 50);
		informacaoVenda_pane.setMaxSize(300, 50);

//		BorderPane Definindo Posiçoes
		border_pane.setTop(index_pane);
		border_pane.setCenter(informacaoVenda_pane);
		border_pane.setBackground(new Background(background));

		Scene snc = new Scene(border_pane, 1280, 720);
		stage.setTitle("Controle de Vendas");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
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

	public GridPane TextStyle(String textIndice, Text textButton) {
		GridPane paneStyle = new GridPane();
		Text text = new Text(textIndice);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-font: 22 arial;-fx-font-weight: bold");
		textButton.setFill(Color.WHITE);
		textButton.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		paneStyle.add(text, 0, 0);
		paneStyle.add(textButton, 1, 0);
		paneStyle.setMinSize(300, 50);
		paneStyle.setMaxSize(300, 50);
		paneStyle.setAlignment(Pos.CENTER);
		paneStyle.setStyle("-fx-background-radius: 300px;-fx-border-radius: 300px;"
				+ "-fx-border-width: 5px;-fx-border-color: GRAY;");

		return paneStyle;
	}
}
