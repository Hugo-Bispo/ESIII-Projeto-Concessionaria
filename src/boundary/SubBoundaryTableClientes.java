package boundary;

import control.tables.TabelaClientes;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubBoundaryTableClientes extends Application {
	
	private TabelaClientes tableClientes = new TabelaClientes();
	
	public void start(Stage stage) throws Exception {

	
		BorderPane tela_pane = new BorderPane();

		tela_pane.setCenter(tableClientes.getTable());
		
		Scene snc = new Scene(tela_pane);

		stage.setTitle("Tabela Clientes");
		stage.setScene(snc);
		stage.show();

	}
}
