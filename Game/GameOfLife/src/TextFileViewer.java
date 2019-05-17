// View a textfile

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class TextFileViewer extends Application {

    private ScrollPane scrlPane;
    private Button btnLoad;

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage myStage) {

        // Set up the stage  
        myStage.setTitle("Text File Viewer");

        // Use a FlowPane for the root node. 
        FlowPane pane = new FlowPane(10, 10);

        // Center the controls in the scene. 
        pane.setAlignment(Pos.CENTER);

        // Create a label that will be scrolled. 
        Label scrlLabel = new Label("");
        scrlLabel.setFont(Font.font("Courier New", 16));

        // Create a scroll pane, setting scrlLabel as the content. 
        scrlPane = new ScrollPane(scrlLabel);

        // Set the viewport width and height. 
        scrlPane.setPrefViewportWidth(400);
        scrlPane.setPrefViewportHeight(200);

        // Enable panning. 
        scrlPane.setPannable(true);

        // Create the load button 
        btnLoad = new Button("Load");

        
        // Handle action events for the reset button. 
        btnLoad.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
     
            	// choose a file
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Load File");
				fileChooser.setInitialDirectory(new File(System.getProperty("user.dir"))); 
				fileChooser.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("TXT", "*.txt"),
						new FileChooser.ExtensionFilter("XML", "*.xml"),
						new FileChooser.ExtensionFilter("All Files", "*.*")
						);
				File file = fileChooser.showOpenDialog(btnLoad.getScene().getWindow());
				if (file == null) return;
            	
            	// open and read a file
            	String fileText = "";                
				String line = "";
				BufferedReader in = null;
				
				try {
					// open the file
					in = new BufferedReader(new FileReader(file.getAbsolutePath()));

					// read loop
					while ((line = in.readLine()) != null) { // while not EOF

						fileText += line + '\n';
					}	
				} catch (FileNotFoundException fnfe) {
	            	Alert alert = new Alert(Alert.AlertType.ERROR);
	            	alert.setTitle("Severe Error");
	            	alert.setHeaderText("FileNotFoundException has occurred");
	            	alert.showAndWait();
				} catch (IOException ioe) {
	            	Alert alert = new Alert(Alert.AlertType.ERROR);
	            	alert.setTitle("Severe Error");
	            	alert.setHeaderText("IOException has occurred");
	            	alert.showAndWait();
				} finally {
					if (in != null) {
						try {
							in.close();
						} catch (IOException e) {}
					} 
				}
           	
                // set the text in the scrollable label 
                scrlLabel.setText(fileText.substring(0,  fileText.length()-1));
            }
        });

        // Add the scroll pane and button to the scene graph.  
        pane.getChildren().addAll(btnLoad, scrlPane);

        // Create a scene.  
        Scene scene = new Scene(pane, pane.getMinWidth(), pane.getMinHeight());

        // Set the scene on the stage  
        myStage.setScene(scene);
        myStage.setResizable(false);

        // Show the stage and its scene.  
        myStage.show();
    }
}
