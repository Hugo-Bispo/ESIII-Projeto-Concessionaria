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

public class SubBoundaryPesquisarCarro extends Application{
	private StyleBoundary style = new StyleBoundary();
	private CarroController carroController = new CarroController();

	private TextField txtPlaca = new TextField();
	private Button btnPesquisar = new Button("Pesquisar");

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
		Text_Placa.setFill(Color.WHITE);

		pane_pesquisar.add(Text_Placa, 0, 0);
		pane_pesquisar.add(txtPlaca, 2, 0);
		pane_pesquisar.add(btnPesquisar, 3, 0);
		pane_pesquisar.setHgap(5);
		pane_pesquisar.setMinSize(200, 200);
		pane_pesquisar.setAlignment(Pos.CENTER);
		pane_pesquisar.setStyle("-fx-font: 24 arial;-fx-font-weight: bold");

		Bindings.bindBidirectional(txtPlaca.textProperty(), carroController.placaProperty());

		btnPesquisar.setOnAction(e -> {
			try {
				carroController.pesquisar();
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
		paneModelo = style.TextStyle("Modelo:", textModelo);
		GridPane paneVersao = new GridPane();
		paneVersao = style.TextStyle("Versão:", textVersao);
		GridPane paneMarca = new GridPane();
		paneMarca = style.TextStyle("Marca:", textMarca);
		GridPane paneValor = new GridPane();
		paneValor = style.TextStyle("Valor:", textValor);
		GridPane paneDisponibilidade = new GridPane();
		paneDisponibilidade = style.TextStyle("Disponiblidade:", textDisponibilidade);
		GridPane paneAgencia = new GridPane();
		paneAgencia = style.TextStyle("Data Cadastro:", calendarDataCadastro);
		GridPane paneAno = new GridPane();
		paneAno = style.TextStyle("Ano:", textAno);
		GridPane paneQuilometragem = new GridPane();
		paneQuilometragem = style.TextStyle("Quilometragem:", textQuilometragem);
		GridPane paneCilindrada = new GridPane();
		paneCilindrada = style.TextStyle("Cilindrada:", textCilindrada);
		GridPane paneCombustivel = new GridPane();
		paneCombustivel = style.TextStyle("Combustivel:", textCombustivel);
		GridPane paneCambio = new GridPane();
		paneCambio = style.TextStyle("Câmbio:", textCambio);
		GridPane paneCor = new GridPane();
		paneCor = style.TextStyle("Cor:", textCor);


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
		pane_info_carro.setVgap(5);

		pane_info_carro.setMinSize(1100, 400);
		pane_info_carro.setMaxSize(1100, 400);
		pane_info_carro.setAlignment(Pos.CENTER);

		Bindings.bindBidirectional(textModelo.textProperty(), carroController.modeloProperty());
		Bindings.bindBidirectional(textVersao.textProperty(), carroController.versaoProperty());
		Bindings.bindBidirectional(textMarca.textProperty(), carroController.marcaProperty());

		Bindings.bindBidirectional(textValor.textProperty(), carroController.valorProperty());
		Bindings.bindBidirectional(textDisponibilidade.textProperty(), carroController.situacaoProperty());
		Bindings.bindBidirectional(calendarDataCadastro.textProperty(), carroController.data_cadastroProperty(), new LocalDateStringConverter());
		
		Bindings.bindBidirectional(textAno.textProperty(), carroController.anoProperty());
		Bindings.bindBidirectional(textQuilometragem.textProperty(), carroController.quilometragemProperty());
		Bindings.bindBidirectional(textCilindrada.textProperty(), carroController.cilindraProperty());

		Bindings.bindBidirectional(textCombustivel.textProperty(), carroController.combustivelProperty());
		Bindings.bindBidirectional(textCambio.textProperty(), carroController.cambioProperty());
		Bindings.bindBidirectional(textCor.textProperty(), carroController.corProperty());

		BorderPane border_pane = new BorderPane();
		border_pane.setTop(pane_titulo);
		border_pane.setCenter(pane_info_carro);
		border_pane.setBackground(new Background(background));
		Scene snc = new Scene(border_pane, 1280, 720);

		stage.setTitle("Pesquisar Carro");
		stage.setResizable(false);
		stage.setScene(snc);
		stage.show();
	}
}
