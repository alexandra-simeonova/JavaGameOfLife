package application;

import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.scene.control.*;
import javafx.event.*;

import java.io.File;

import foundation.GOLBoard;
import foundation.GOLFileException;

public class GOLControllerPane extends VBox {

	private static final int BUTTONWIDTH = 60;

	private GOLBoard currentBoard = new GOLBoard();

	public GOLControllerPane(GOLCanvas canvas) {
		super(10);

		// Create the button. 
		Button btnLoad = new Button("Load");
		btnLoad.setMinWidth(BUTTONWIDTH);
		// set the handler of the ActionEvent to select a GOL file
		// and then reconstruct the 'currentBoard' with the 
		// filename selected with appropriate handling of GOLFileException (Alert)

		// Add them to the box. 
		getChildren().addAll(btnLoad);
		canvas.show(currentBoard);
	}

}
