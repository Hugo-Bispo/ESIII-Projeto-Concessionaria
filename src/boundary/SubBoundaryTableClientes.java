package boundary;

import control.tables.TabelaCarros;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubBoundaryTableClientes extends Application {
	
	TabelaCarros tableCarro = new TabelaCarros();
	
	public void start(Stage stage) throws Exception {

	
		BorderPane tela_pane = new BorderPane();

		tela_pane.setCenter(tableCarro.getTable());
		
		Scene snc = new Scene(tela_pane);

		stage.setTitle("Tabela Carros");
		stage.setScene(snc);
		stage.show();

	}
}
