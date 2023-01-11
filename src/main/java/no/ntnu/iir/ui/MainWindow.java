package no.ntnu.iir.ui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

/**
 * Main class for the UI.
 * <ul>
 *     <li>
 *         Sets up all he different FXML files
 *     </li>
 *     <li>
 *         Sets up controllers to the different FXML files.
 *     </li>
 *     <li>
 *         Sets up scenes for all the different FXML files.
 *     </li>
 *     <li>
 *         Hase the start application function.
 *     </li>
 * </ul>
 */
public class MainWindow extends Application {

    //Scenes
    private Scene battleWindowScene;
    private Scene createArmyWindowScene;
    private Scene customGameWindowScene;
    private Scene infoWindowScene;
    private Scene startWindowScene;
    private Scene lastScene;

    //Controllers
    private BattleWindowController battleWindowController;
    private CreateArmyWindowController createArmyWindowController;
    private CustomGameWindowController customGameWindowController;
    private InfoWindowController infoWindowController;
    private StartWindowController startWindowController;

    //Music
    private MediaPlayer mediaPlayer = null;

    @Override
    public void start(Stage stage) {
        try{
            //Load StartWindow
            FXMLLoader startWindowLoader = new FXMLLoader(getClass().getResource("Start_Window.fxml"));
            Parent startWindowPane = startWindowLoader.load();
            this.startWindowScene = new Scene(startWindowPane, 1280,720);
            this.startWindowController = startWindowLoader.getController();

            //Load BattleWindow
            FXMLLoader battleWindowLoader = new FXMLLoader(getClass().getResource("Battle_Window.fxml"));
            Parent battleWindowPane = battleWindowLoader.load();
            this.battleWindowScene = new Scene(battleWindowPane, 1920, 1000);
            this.battleWindowController = battleWindowLoader.getController();

            //Load CreateARmyWindow
            FXMLLoader createArmyWidnowLoader = new FXMLLoader(getClass().getResource("Create_Army_Window.fxml"));
            Parent createArmyWindwPane = createArmyWidnowLoader.load();
            this.createArmyWindowScene = new Scene(createArmyWindwPane, 1280,720);
            this.createArmyWindowController = createArmyWidnowLoader.getController();

            //Load CustomGameWindowController
            FXMLLoader customGameWindowLoader = new FXMLLoader(getClass().getResource("Custom_Game_Window.fxml"));
            Parent customGameWindowPane = customGameWindowLoader.load();
            this.customGameWindowScene = new Scene(customGameWindowPane, 1280,720);
            this.customGameWindowController = customGameWindowLoader.getController();

            //Load InfoWindow
            FXMLLoader infoWindowLoader = new FXMLLoader(getClass().getResource("Info_Window.fxml"));
            Parent infoWindowPane = infoWindowLoader.load();
            this.infoWindowScene = new Scene(infoWindowPane, 1280,720);
            this.infoWindowController = infoWindowLoader.getController();

            //Set Scenes in the different controllers
                //StartWindowController
            this.startWindowController.setBattleWindowScene(this.battleWindowScene);
            this.startWindowController.setCreateArmyWindowScene(this.createArmyWindowScene);
            this.startWindowController.setCustomGameWindowScene(this.customGameWindowScene);
            this.startWindowController.setInfoWindowScene(this.infoWindowScene);
                //CreateArmyController
            this.createArmyWindowController.setStartWindowScene(this.startWindowScene);
            this.createArmyWindowController.setInfoWindowScene(this.infoWindowScene);
                //CustomGameController
            this.customGameWindowController.setStartWindowScene(this.startWindowScene);
            this.customGameWindowController.setInfoWindowScene(this.infoWindowScene);
            this.customGameWindowController.setBattleWindowScene(this.battleWindowScene);
                //BattleWindowController
            this.battleWindowController.setStartWindowScene(this.startWindowScene);
            this.battleWindowController.setInfoWindowScene(this.infoWindowScene);
                //InfoWindow
            this.lastScene = startWindowScene;
            this.infoWindowController.setLastScene(lastScene);

            //SetController
            this.customGameWindowController.setBattleWindowController(this.battleWindowController);
            this.startWindowController.setBattleWindowController(this.battleWindowController);
            this.createArmyWindowController.setInfoWindowController(this.infoWindowController);
            this.startWindowController.setInfoWindowController(this.infoWindowController);
            this.customGameWindowController.setInfoWindowController(this.infoWindowController);
            this.battleWindowController.setInfoWindowController(infoWindowController);

            //Sets the stage up
            stage.setScene(startWindowScene);
            stage.show();

            stage.setOnCloseRequest(event -> {
                event.consume();
                exitApplication(stage);
            });
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Close the application when the exit button is pressed.
     * Creates a popup that asks if you want to close the application or not.
     *
     * @param stage the stage where the scenes are.
     */
    @FXML
    protected void exitApplication(Stage stage) {
        Optional<ButtonType> buttonType = exitAlert().showAndWait();
        if (buttonType.isPresent()) {
            ButtonType okButtonType = buttonType.get();
            if (okButtonType == ButtonType.OK) {
                stage.close();
            }
        }
    }

    /**
     * An alert that tels the user they are about to exit the application and asks if the user wants to clones it or not.
     * @return exit alert.
     */
    private Alert exitAlert() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit WarGames");
        alert.setHeaderText("You are about to exit WarGames!");
        alert.setContentText("Are you sure you want to exit WareGames?");
        return alert;
    }

    /**
     * Returns battleWindowController.
     * @return battleWindowController.
     */
    public BattleWindowController getBattleWindowController() {
        return this.battleWindowController;
    }

    /**
     * Returns creatArmyWindowController.
     * @return creatArmyWindowController.
     */
    public CreateArmyWindowController getCreateArmyWindowController() {
        return this.createArmyWindowController;
    }

    /**
     * Returns customGameController.
     * @return customGameController.
     */
    public CustomGameWindowController getCustomGameWindowController() {
        return this.customGameWindowController;
    }

    /**
     * Returns infoWindowController.
     * @return infoWindowController.
     */
    public InfoWindowController getInfoWindowController() {
        return this.infoWindowController;
    }

    /**
     * Returns startWindowController.
     * @return startWindowController.
     */
    public StartWindowController startWindowController() {
        return this.startWindowController;
    }

    /**
     * Starts the application.
     *
     * @param args The arguments to be run by the program.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
