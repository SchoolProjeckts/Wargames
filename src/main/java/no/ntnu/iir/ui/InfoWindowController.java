package no.ntnu.iir.ui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller class for the Info_Window.fxml file.
 * It handles every function info window haves for the application.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class InfoWindowController implements Initializable {

    private Scene lastScene;
    @FXML
    private TextArea textArea = new TextArea();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textArea.setEditable(false);
    }

    /**
     * sets the last scene.
     * @param scene the last scene that was in set in the stage.
     */
    public void setLastScene(Scene scene) {
        this.lastScene = scene;
    }

    /**
     * Events that happen when BackButton is pressed.
     * When the BackButton is pressed the stage changes back to the scene that was last on the stage.
     * @param actionEvent action event.
     */
    @FXML
    public void backButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.lastScene);
    }

    /**
     * Change the scene in a stage.
     *
     * @param stage    the stage you want to change scene on.
     * @param newScene the new scene you want.
     */
    private void setScene(Stage stage, Scene newScene) {
        stage.hide();
        stage.setScene(newScene);
        stage.show();
    }
}