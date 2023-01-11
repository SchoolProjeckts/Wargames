package no.ntnu.iir.ui;

import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import no.ntnu.iir.fileshandlers.CSVFileHandler;
import javafx.scene.media.Media;
import java.io.File;
import java.util.Optional;

/**
 * The class is the controller class for Start_Window.fxml.
 * Every function startWindow have is control in this class.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class StartWindowController {

    //Scenes
    private Scene battleWindowScene;
    private Scene createArmyWindowScene;
    private Scene customGameWindowScene;
    private Scene infoWindowScene;

    //Controllers
    private BattleWindowController battleWindowController;
    private InfoWindowController infoWindowController;

    private MediaPlayer mediaPlayer;

    //ChechBokses
    @FXML
    private MFXToggleButton musicChechBoks = new MFXToggleButton();

    /**
     * Sets up Battle_Window.fxml as a scene in this class.
     * @param battleWindowScene the battleWindow scene.
     */
    public void setBattleWindowScene(Scene battleWindowScene) {
        this.battleWindowScene = battleWindowScene;
    }

    /**
     * Sets up Create_Army_Window.fxml as a scene in this class.
     * @param createArmyWindowScene the createArmyWindow scene.
     */
    public void setCreateArmyWindowScene(Scene createArmyWindowScene) {
        this.createArmyWindowScene = createArmyWindowScene;
    }

    /**
     * Sets up Custom_Game_Window.fxml as a scene in this class.
     * @param customGameWindowScene the customGameWindow scene.
     */
    public void setCustomGameWindowScene(Scene customGameWindowScene) {
        this.customGameWindowScene = customGameWindowScene;
    }

    /**
     * Sets up Create_Army_Window.fxml as a scene in this class.
     * @param infoWindowScene the infoWindow scene.
     */
    public void setInfoWindowScene(Scene infoWindowScene) {
        this.infoWindowScene = infoWindowScene;
    }

    /**
     * Sets up battleWindowController.
     * @param battleWindowController the controller you want as battleWindowController.
     */
    public void setBattleWindowController(BattleWindowController battleWindowController) {
        this.battleWindowController = battleWindowController;
    }

    /**
     * Sets up InfoWindowController.
     * @param infoWindowController the controller you want as infoWindowController
     */
    public void setInfoWindowController(InfoWindowController infoWindowController) {
        this.infoWindowController = infoWindowController;
    }


    /**
     * Events when the standardBattleButton is pressed.
     * Change scene to Battle Window.
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void standardBattleButtonPressed(ActionEvent actionEvent) {
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        this.battleWindowController.setArmyOne(csvFileHandler.readCSVFile("The_Alliance.csv"));
        this.battleWindowController.setArmyTwo(csvFileHandler.readCSVFile("The_Horde.csv"));
        this.battleWindowController.setPathArmyOne("The_Alliance.csv");
        this.battleWindowController.setPathArmyTwo("The_Horde.csv");
        this.battleWindowController.setLabels();
        this.infoWindowController.setLastScene(this.battleWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.battleWindowScene);
    }

    /**
     * Events when the Create Army button is pressed.
     * Change scene to createArmyWindowScene.
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void cereateArmyButtonPressed(ActionEvent actionEvent) {
        this.infoWindowController.setLastScene(this.createArmyWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.createArmyWindowScene);
    }

    /**
     * Event when the customGame button ius pressed.
     * Change scene to customGameWindowScene.
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void customGameButtonPressed(ActionEvent actionEvent) {
        this.infoWindowController.setLastScene(this.customGameWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.customGameWindowScene);
    }

    /**
     * Event when the info button is pressed.
     * Change scene to infoWindowScene.
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void infoButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.infoWindowScene);
    }

    /**
     * Event when the exit button is pressed.
     * An alert popup asks if you want to close the application.
     * If user press ok button the application closes. If not the application does not close.
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void exitButtonPressed(ActionEvent actionEvent) {
        Optional<ButtonType> buttonType = exitAlert().showAndWait();
        if (buttonType.isPresent()) {
            ButtonType okButtonType = buttonType.get();
            if(okButtonType == ButtonType.OK) {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.close();
            }
        }
    }

    /**
     * A confirmation alert that asks if you want to exit WarGames or not.
     * Returns the alert.
     * @return the alert.
     */
    private Alert exitAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit WarGames");
        alert.setHeaderText("You are about to exit WarGames!");
        alert.setContentText("Are you sure you want to exit WarGames?");
        return alert;
    }

    /**
     * Change the scene in a stage.
     *
     * @param stage the stage you want to change scene on.
     * @param newScene the new scene you want.
     */
    private void setScene(Stage stage, Scene newScene) {
        stage.hide();
        stage.setScene(newScene);
        stage.show();
    }

    /**
     * Start and stop music BattleSong.mp3 when the musicChechkBoks is pressed.
     */
    @FXML
    protected void onMusicCheckBoksPressed() {
        if(this.musicChechBoks.isSelected()) {
            this.playSonge("BattleSong.mp3");
        }
        else {
            this.mediaPlayer.stop();
        }
    }

    /**
     * Creates a new media with song of your choosing and plays it.
     * @param fileName the name of the file of the song that you want to play.
     */
    private void playSonge(String fileName) {
        String path = getClass().getResource(fileName).getPath();
        Media media = new Media(new File(path).toURI().toString());
        this.mediaPlayer = new MediaPlayer(media);
        this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        this.mediaPlayer.play();
    }
}
