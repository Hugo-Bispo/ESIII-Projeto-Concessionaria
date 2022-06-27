package boundary;

import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class StyleBoundary {
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
