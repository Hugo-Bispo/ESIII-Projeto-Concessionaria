package boundary;

import control.tables.ITableStrategy;
import control.tables.TabelaVendas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Venda;

public class SubBoundaryTableVendas extends Application {
	
	ITableStrategy<Venda> tableVendas = new TabelaVendas();
	
	public void start(Stage stage) throws Exception {

	
		BorderPane tela_pane = new BorderPane();

		tela_pane.setCenter(tableVendas.getTable());
		
		Scene snc = new Scene(tela_pane);

		stage.setTitle("Tabela Carros");
		stage.setScene(snc);
		stage.show();

	}
}
