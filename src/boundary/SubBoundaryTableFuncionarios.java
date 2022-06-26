package boundary;

import control.tables.TabelaFuncionarios;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubBoundaryTableFuncionarios extends Application {
	
	TabelaFuncionarios tableFuncionarios = new TabelaFuncionarios();
	
	public void start(Stage stage) throws Exception {

	
		BorderPane tela_pane = new BorderPane();

		tela_pane.setCenter(tableFuncionarios.getTable());
		
		Scene snc = new Scene(tela_pane);

		stage.setTitle("Tabela Carros");
		stage.setScene(snc);
		stage.show();

	}
}
