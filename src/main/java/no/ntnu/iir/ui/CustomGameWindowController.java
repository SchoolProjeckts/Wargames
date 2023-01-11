package no.ntnu.iir.ui;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import no.ntnu.iir.data.Army;
import no.ntnu.iir.fileshandlers.CSVFileHandler;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The controller class for the Custom_Game_Window.fxml file
 * Handles every function custom game window has for the application.
 *
 * @author Ole Kristian Dvergsdal.
 * @version 1.0
 */
public class CustomGameWindowController implements Initializable {

    //TextFields
    @FXML
    private MFXTextField armyOneText;
    @FXML
    private MFXTextField armyTwoText;

    //Scenes
    private Scene startWindowScene;
    private Scene infoWindowScene;
    private Scene battleWindowScene;

    //Paths as String
    private String pathArmyOne;
    private String pathArmyTwo;

    //Armies
    private Army armyOne;
    private Army armyTwo;

    //Controllers
    private BattleWindowController battleWindowController;
    private InfoWindowController infoWindowController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.armyOneText.setAllowEdit(false);
        this.armyTwoText.setAllowEdit(false);
    }

    /**
     * Sets up Start_Window.fxml as a scene in this class.
     *
     * @param startWindowScene the startWindow scene.
     */
    public void setStartWindowScene(Scene startWindowScene) {
        this.startWindowScene = startWindowScene;
    }

    /**
     * Sets up Battle_Window.fxml as a scene in this class.
     *
     * @param battleWindowScene the battleWindow scene.
     */
    public void setBattleWindowScene(Scene battleWindowScene) {
        this.battleWindowScene = battleWindowScene;
    }

    /**
     * Sets up Create_Army_Window.fxml as a scene in this class.
     *
     * @param infoWindowScene the infoWindow scene.
     */
    public void setInfoWindowScene(Scene infoWindowScene) {
        this.infoWindowScene = infoWindowScene;
    }

    /**
     * Sets up the infoWindowController.
     * @param infoWindowController the controller you want to set as infoWindowController.
     */
    public void setInfoWindowController(InfoWindowController infoWindowController) {
        this.infoWindowController = infoWindowController;
    }

    /**
     * Sets up the battleWindowController.
     * @param battleWindowController the controller you want to set as battleWindowController.
     */
    public void setBattleWindowController(BattleWindowController battleWindowController) {
        this.battleWindowController = battleWindowController;
    }

    /**
     * Event when the Cancel button is pressed.
     * Clear all files in Create Army.
     * Change scene to StartWindowScene
     *
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void cancelButtonPressed(ActionEvent actionEvent) {
        this.infoWindowController.setLastScene(startWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.startWindowScene);
    }

    /**
     * Event when the info button is pressed.
     * Change scene to infoWindowScene.
     *
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void infoButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.infoWindowScene);
    }

    /**
     * Events when the play is pressed.
     * Change scene to Battle Window.
     *
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void playButtonPressed(ActionEvent actionEvent) {
        if(this.armyOneText.getText().isBlank() || this.armyTwoText.getText().isBlank()) {
            this.armiesNotChoseAlert();
        }
        else {
            this.battleWindowController.setArmyOne(armyOne);
            this.battleWindowController.setArmyTwo(armyTwo);
            this.battleWindowController.setLabels();
            this.battleWindowController.setPathArmyOne(this.pathArmyOne);
            this.battleWindowController.setPathArmyTwo(this.pathArmyTwo);
            this.infoWindowController.setLastScene(battleWindowScene);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            this.setScene(stage, this.battleWindowScene);
        }
    }

    /**
     * Event when the find file army one button is pressed.
     * <ul>
     *     <li>
     *         Open a folder that for the user to find a file.
     *     </li>
     *     <li>
     *         Checks if the same file is chosen as in find file army two. If it is an alert is shown, that tels the us that he cant chose the same file.
     *     </li>
     *     <li>
     *         Creates a new army for armyOne, based on whats in the file that is chosen. Also seth the armyOnePath tho the chose file.
     *     </li>
     * </ul>
     */
    @FXML
    protected void findFileArmyOneButtonPressed() {

        CSVFileHandler csvFileHandler = new CSVFileHandler();
        File file = csvFileHandler.findFile();
        this.pathArmyOne = file.getPath();

        if (this.pathArmyOne.equals(this.pathArmyTwo)) {
            this.sameFileChosenAlert();
        } else {
            armyOne = (csvFileHandler.readCSVFile(pathArmyOne));
            this.armyOneText.setText(armyOne.getName());
        }
    }

    /**
     * Event when the find file army two button is pressed.
     * <ul>
     *     <li>
     *         Open a folder that for the user to find a file.
     *     </li>
     *     <li>
     *         Checks if the same file is chosen as in find file army one. If it is an alert is shown, that tels the us that he cant chose the same file.
     *     </li>
     *     <li>
     *         Creates a new army for armyTwo, based on whats in the file that is chosen. Also seth the armyTwoPath tho the chose file.
     *     </li>
     * </ul>
     */
    @FXML
    protected void findFileArmyTwoButtonPressed() {

        CSVFileHandler csvFileHandler = new CSVFileHandler();
        File file = csvFileHandler.findFile();
        this.pathArmyTwo = file.getPath();

        if (this.pathArmyTwo.equals(this.pathArmyOne)) {
            this.sameFileChosenAlert();
        } else {
            armyTwo = (csvFileHandler.readCSVFile(pathArmyTwo));
            this.armyTwoText.setText(armyTwo.getName());
        }
    }

    /**
     * An alert that tels the user that he cant choose the same file for both armies.
     */
    private void sameFileChosenAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cant choose file.");
        alert.setContentText("The file you are trying to use is already chosen.");
        alert.show();
    }

    /**
     * An alert that tels the user that he need to chose armies before he can play.
     */
    private void armiesNotChoseAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Cant play game");
        alert.setContentText("Need to chose armies before you can play.");
        alert.show();
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

    /**
     * Return armyOne.
     * @return armyOne.
     */
    public Army getArmyOne() {
        return this.armyOne;
    }

    /**
     * Return armyTwo.
     * @return armyTwo.
     */
    public Army getArmyTwo() {
        return this.armyTwo;
    }
}
