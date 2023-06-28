package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

	private Color color = Color.BLACK;

	@FXML
	private Pane drawingAreaPane;

	@FXML
	void drawingAreaMouseDragged(MouseEvent event) {

		Circle newCircle = new Circle(event.getX(), event.getY(), 4, color);
		drawingAreaPane.getChildren().add(newCircle);
	}

	@FXML
	void clearButtonPressed(ActionEvent event) {

		drawingAreaPane.getChildren().clear();
	}

	@FXML
	void eraserButtonPressed(ActionEvent event) {
		color = Color.WHITE;
	}

	@FXML
	void penButtonPressed(ActionEvent event) {
		color = Color.BLACK;
	}

}
