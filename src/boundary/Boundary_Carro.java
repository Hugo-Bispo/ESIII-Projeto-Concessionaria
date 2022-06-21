package boundary;

import java.sql.SQLException;

import control.CarroController;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

public class Boundary_Carro extends Application {
	control.CarroController control_carro = new CarroController();

	private TextField txtPlaca = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");
	private Button btnCriar = new Button("Criar");

	private Text textTitulo = new Text("Controle de Veiculos");
	private Text textValor = new Text();
	private Text textDisponibilidade = new Text();
	private Text calendarDataCadastro = new Text();
	private Text textModelo = new Text();
	private Text textVersao = new Text();
	private Text textMarca = new Text();
	private Text textAno = new Text();
	private Text textQuilometragem = new Text();
	private Text textCombustivel = new Text();
	private Text textCilindrada = new Text();
	private Text textCambio = new Text();
	private Text textCor = new Text();

	public void start(Stage stage) throws Exception {

		BackgroundImage background = new BackgroundImage(new Image(getClass().getResourceAsStream("backgound.jpg")),
				BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
				BackgroundSize.DEFAULT);
//		GridPane Pesquisar - Criar Carro		
		GridPane pane_pesquisar = new GridPane();
		Text Text_Placa = new Text("Placa do Carro:");
		Text_Placa.setFill(Color.BLACK);

		pane_pesquisar.add(Text_Placa, 0, 0);
		pane_pesquisar.add(txtPlaca, 2, 0);
		pane_pesquisar.add(btnPesquisar, 3, 0);
		pane_pesquisar.add(btnCriar, 4, 0);
		pane_pesquisar.setHgap(5);
		pane_pesquisar.setMinSize(200, 200);
		pane_pesquisar.setAlignment(Pos.CENTER);
		pane_pesquisar.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtPlaca.textProperty(), control_carro.placaProperty());

		btnCriar.setOnAction(e -> cadastrar_carro());
		btnPesquisar.setOnAction(e -> {
			try {
				control_carro.pesquisar();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
//		GridPane Uniao Titulo com Pesquisar - Criar Carro
		textTitulo.setFill(Color.BLACK);
		textTitulo.setStyle("-fx-font: 40 arial;-fx-font-weight: bold");
		textTitulo.setTextAlignment(TextAlignment.CENTER);
		GridPane pane_titulo = new GridPane();
		pane_titulo.add(textTitulo, 0, 0);
		pane_titulo.add(pane_pesquisar, 0, 1);
		pane_titulo.setAlignment(Pos.CENTER);

//		GridPane Informacao do Carro
		GridPane paneModelo = new GridPane();
		paneModelo = TextStyle("Modelo:", textModelo);
		GridPane paneVersao = new GridPane();
		paneVersao = TextStyle("Versão:", textVersao);
		GridPane paneMarca = new GridPane();
		paneMarca = TextStyle("Marca:", textMarca);
		GridPane paneValor = new GridPane();
		paneValor = TextStyle("Valor:", textValor);
		GridPane paneDisponibilidade = new GridPane();
		paneDisponibilidade = TextStyle("Disponiblidade:", textDisponibilidade);
		GridPane paneAgencia = new GridPane();
		paneAgencia = TextStyle("Data Cadastro:", calendarDataCadastro);
		GridPane paneAno = new GridPane();
		paneAno = TextStyle("Ano:", textAno);
		GridPane paneQuilometragem = new GridPane();
		paneQuilometragem = TextStyle("Quilometragem:", textQuilometragem);
		GridPane paneCilindrada = new GridPane();
		paneCilindrada = TextStyle("Cilindrada:", textCilindrada);
		GridPane paneCombustivel = new GridPane();
		paneCombustivel = TextStyle("Combustivel:", textCombustivel);
		GridPane paneCambio = new GridPane();
		paneCambio = TextStyle("Câmbio:", textCambio);
		GridPane paneCor = new GridPane();
		paneCor = TextStyle("Cor:", textCor);


		GridPane pane_info_carro = new GridPane();
		pane_info_carro.add(paneModelo, 0, 0);
		pane_info_carro.add(paneVersao, 1, 0);
		pane_info_carro.add(paneMarca, 2, 0);
		pane_info_carro.add(paneValor, 0, 1);
		pane_info_carro.add(paneDisponibilidade, 1, 1);
		pane_info_carro.add(paneAgencia, 2, 1);
		pane_info_carro.add(paneAno, 0, 2);
		pane_info_carro.add(paneQuilometragem, 1, 2);
		pane_info_carro.add(paneCilindrada, 2, 2);
		pane_info_carro.add(paneCombustivel, 0, 3);
		pane_info_carro.add(paneCambio, 1, 3);
		pane_info_carro.add(paneCor, 2, 3);
		pane_info_carro.setStyle("-fx-font: 20 arial;-fx-font-weight: bold");
		pane_info_carro.setHgap(100);
		pane_info_carro.setVgap(20);

		pane_info_carro.setMinSize(1100, 500);
		pane_info_carro.setMaxSize(1100, 500);
		pane_info_carro.setAlignment(Pos.CENTER);

		Bindings.bindBidirectional(textModelo.textProperty(), control_carro.modeloProperty());
		Bindings.bindBidirectional(textVersao.textProperty(), control_carro.versaoProperty());
		Bindings.bindBidirectional(textMarca.textProperty(), control_carro.marcaProperty());

		Bindings.bindBidirectional(textValor.textProperty(), control_carro.valorProperty());
		Bindings.bindBidirectional(textDisponibilidade.textProperty(), control_carro.situacaoProperty());
		Bindings.bindBidirectional(calendarDataCadastro.textProperty(), control_carro.data_cadastroProperty(), new LocalDateStringConverter());
		
		Bindings.bindBidirectional(textAno.textProperty(), control_carro.anoProperty());
		Bindings.bindBidirectional(textQuilometragem.textProperty(), control_carro.quilometragemProperty());
		Bindings.bindBidirectional(textCilindrada.textProperty(), control_carro.cilindraProperty());

		Bindings.bindBidirectional(textCombustivel.textProperty(), control_carro.combustivelProperty());
		Bindings.bindBidirectional(textCambio.textProperty(), control_carro.cambioProperty());
		Bindings.bindBidirectional(textCor.textProperty(), control_carro.corProperty());

		BorderPane border_pane = new BorderPane();
		border_pane.setTop(pane_titulo);
		border_pane.setCenter(pane_info_carro);
		border_pane.setBackground(new Background(background));
		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setTitle("Controle de Veiculos");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}

	public GridPane TextStyle(String textIndice, Text textButton) {
		GridPane paneStyle = new GridPane();
		Text text = new Text(textIndice);
		text.setFill(Color.WHITE);
		text.setStyle("-fx-font: 22 arial;-fx-font-weight: bold");
		textButton.setFill(Color.WHITE);
		paneStyle.add(text, 0, 0);
		paneStyle.add(textButton, 1, 0);
		paneStyle.setMinSize(300, 50);
		paneStyle.setMaxSize(300, 50);
		paneStyle.setAlignment(Pos.CENTER);
		paneStyle.setStyle("-fx-background-radius: 300px;-fx-border-radius: 300px;"
				+ "-fx-border-width: 5px;-fx-border-color: GRAY;");

		return paneStyle;
	}

	public void cadastrar_carro() {
		SubBoundary_Cadastrar_Carro carro = new SubBoundary_Cadastrar_Carro();
		try {
			carro.start(new Stage());
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(Boundary_Carro.class, args);
	}

}
