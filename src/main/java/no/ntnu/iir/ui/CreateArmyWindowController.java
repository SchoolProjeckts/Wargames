package no.ntnu.iir.ui;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import no.ntnu.iir.data.Army;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;
import no.ntnu.iir.fileshandlers.CSVFileHandler;
import no.ntnu.iir.logic.UnitFactory;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The controller class for the Create_Army_Window.fxml file.
 * Handles every function create army window has for the application.
 *
 * @author Ole Kristian Dvergsdal.
 * @version 1.0
 */
public class CreateArmyWindowController {

    //Infantry TextFields
    @FXML
    private MFXTextField infatryName;
    @FXML
    private MFXTextField infatryHealth;
    @FXML
    private MFXTextField infatryAttack;
    @FXML
    private MFXTextField infatryArmor;
    @FXML
    private MFXTextField infatryNumberOfUnits;

    //RangeUnits TextFields
    @FXML
    private MFXTextField rangeName;
    @FXML
    private MFXTextField rangeHealth;
    @FXML
    private MFXTextField rangeAttack;
    @FXML
    private MFXTextField rangeArmor;
    @FXML
    private MFXTextField rangeNumberOfUnits;

    //CavlryUnit TextFields
    @FXML
    private MFXTextField cavlryName;
    @FXML
    private MFXTextField cavlryHealth;
    @FXML
    private MFXTextField cavlryAttack;
    @FXML
    private MFXTextField cavlryArmor;
    @FXML
    private MFXTextField cavlryNumberOfUnits;

    //MageUnit TextFields
    @FXML
    private MFXTextField mageName;
    @FXML
    private MFXTextField mageHealth;
    @FXML
    private MFXTextField mageAttack;
    @FXML
    private MFXTextField mageArmor;
    @FXML
    private MFXTextField mageNumberOfUnits;

    //Name and commander TextFields
    @FXML
    private MFXTextField armyName;
    @FXML
    private MFXTextField commanderName;
    @FXML
    private MFXTextField commanderHealth;

    //CheckBokses
    @FXML
    private MFXCheckbox infatryCheckBox;
    @FXML
    private MFXCheckbox rangeCheckBox;
    @FXML
    private MFXCheckbox cavlryCheckBox;
    @FXML
    private MFXCheckbox mageCheckBox;

    //Scenes
    private Scene startWindowScene;
    private Scene infoWindowScene;

    //Controllers
    private InfoWindowController infoWindowController;

    //Strings
    private static final String WRONGINPUTINTEXTFIELD = "Wrong Input In Text Filed";
    private static final String WRONGNUMBERINPUTINNUMBERTEXTFIELDS = "The text filed for Health, Attack, Armor and Number Of Units most be a number positive number, but on of the are not.";
    private static final String FILEDHASNOTBEENFFILLEDTOCREATEARMY = "Filed has not been filled to create Army ";

    /**
     * Sets up Start_Window.fxml as a scene in this class.
     * @param startWindowScene the startWindow scene.
     */
    public void setStartWindowScene(Scene startWindowScene) {
        this.startWindowScene = startWindowScene;
    }

    /**
     * Sets up Create_Army_Window.fxml as a scene in this class.
     * @param infoWindowScene the infoWindow scene.
     */
    public void setInfoWindowScene(Scene infoWindowScene) {
        this.infoWindowScene = infoWindowScene;
    }

    /**
     * Sets up the controller for Info_Window.fxml.
     * @param infoWindowController the controller you want as infoWindowController.
     */
    public void setInfoWindowController(InfoWindowController infoWindowController) {
        this.infoWindowController = infoWindowController;
    }

    /**
     * Event when the Cancel button is pressed.
     * Clear all files in Create Army.
     * Change scene to StartWindowScene
     * @param actionEvent when the button is pressed.
     */
    @FXML
    protected void cancelButtonPressed(ActionEvent actionEvent) {
        clearAllFields();
        this.infoWindowController.setLastScene(startWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.startWindowScene);
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
     * Clear all the text filed and checkboxes.
     */
    private void clearAllFields() {
        //TextFields
        this.infatryName.clear();
        this.infatryHealth.clear();
        this.infatryAttack.clear();
        this.infatryArmor.clear();
        this.infatryNumberOfUnits.clear();
        this.rangeName.clear();
        this.rangeHealth.clear();
        this.rangeAttack.clear();
        this.rangeArmor.clear();
        this.rangeNumberOfUnits.clear();
        this.cavlryName.clear();
        this.cavlryHealth.clear();
        this.cavlryAttack.clear();
        this.cavlryArmor.clear();
        this.cavlryNumberOfUnits.clear();
        this.mageName.clear();
        this.mageHealth.clear();
        this.mageAttack.clear();
        this.mageArmor.clear();
        this.mageNumberOfUnits.clear();
        this.armyName.clear();
        this.commanderName.clear();
        this.commanderHealth.clear();
        //CheckBoxes
        this.infatryCheckBox.setSelected(false);
        this.rangeCheckBox.setSelected(false);
        this.cavlryCheckBox.setSelected(false);
        this.mageCheckBox.setSelected(false);
    }

    /**
     * Create an army form the info from the fields.
     * @return the army that is created
     */
    private Army createArmy() {
        List<Unit> armyUnits = new ArrayList<>();
        UnitFactory unitFactory = new UnitFactory();
        Army army = new Army(this.armyName.getText(), armyUnits);
        Unit commanderUnit = unitFactory.createAUnit("CommanderUnit", this.commanderName.getText(), Integer.parseInt(this.commanderHealth.getText()), TerrainType.DEFAULTTERAIN);
        army.addUnit(commanderUnit);
        createInfantryUnitsAndAddToArmy(army, unitFactory);
        createRangeUnitsAndAddToArmy(army, unitFactory);
        createCavlryUnitsAndAddToArmy(army, unitFactory);
        createMageUnitsAndAddToArmy(army, unitFactory);
        return army;
    }

    /**
     * Create InfantryUnits based on the infantry TextFields if the infantryCheckBox is selected.
     * @param army army the units is added to.
     * @param unitFactory a unitFactory object that can create units.
     */
    private void createInfantryUnitsAndAddToArmy(Army army, UnitFactory unitFactory) {
        if(infatryCheckBox.isSelected()) {
            if(infatryAttack.getText().isBlank() && infatryArmor.getText().isBlank()) {
                List<Unit> units = unitFactory.createUnits("InfantryUnit", this.infatryName.getText(), Integer.parseInt(this.infatryHealth.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.infatryNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
            else{
                List<Unit> units = unitFactory.createUnitsFullStatsChoose("InfantryUnit", this.infatryName.getText(), Integer.parseInt(this.infatryHealth.getText()), Integer.parseInt(this.infatryAttack.getText()), Integer.parseInt(this.infatryArmor.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.infatryNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
        }
    }

    /**
     * Create RangeUnits based on the range unit TextFields if the rangeCheckBox is selected.
     * @param army army the units is added to.
     * @param unitFactory a unitFactory object that can create units.
     */
    private void createRangeUnitsAndAddToArmy(Army army, UnitFactory unitFactory) {
        if(rangeCheckBox.isSelected()) {
            if(rangeAttack.getText().isBlank() && rangeArmor.getText().isBlank()) {
                List<Unit> units = unitFactory.createUnits("RangedUnit", this.rangeName.getText(), Integer.parseInt(this.rangeHealth.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.rangeNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
            else{
                List<Unit> units = unitFactory.createUnitsFullStatsChoose("RangedUnit", this.rangeName.getText(), Integer.parseInt(this.rangeHealth.getText()), Integer.parseInt(this.rangeAttack.getText()), Integer.parseInt(this.rangeArmor.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.rangeNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
        }
    }

    /**
     * Create CavlryUnits based on the calvry unit TextFields if the cavlryCheckBox is selected.
     * @param army army the units is added to.
     * @param unitFactory a unitFactory object that can create units.
     */
    private void createCavlryUnitsAndAddToArmy(Army army, UnitFactory unitFactory) {
        if(cavlryCheckBox.isSelected()) {
            if(cavlryAttack.getText().isBlank() && cavlryArmor.getText().isBlank()) {
                List<Unit> units = unitFactory.createUnits("CavlryUnit", this.cavlryName.getText(), Integer.parseInt(this.cavlryHealth.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.cavlryNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
            else{
                List<Unit> units = unitFactory.createUnitsFullStatsChoose("CavlryUnit", this.cavlryName.getText(), Integer.parseInt(this.cavlryHealth.getText()), Integer.parseInt(this.cavlryAttack.getText()), Integer.parseInt(this.cavlryArmor.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.cavlryNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
        }
    }

    /**
     * Create CalvryUnits based on the calvry unit TextFields if the cavlryCheckBox is selected.
     * @param army army the units is added to.
     * @param unitFactory a unitFactory object that can create units.
     */
    private void createMageUnitsAndAddToArmy(Army army, UnitFactory unitFactory) {
        if(mageCheckBox.isSelected()) {
            if(mageAttack.getText().isBlank() && mageArmor.getText().isBlank()) {
                List<Unit> units = unitFactory.createUnits("MageUnit", this.mageName.getText(), Integer.parseInt(this.mageHealth.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.mageNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
            else{
                List<Unit> units = unitFactory.createUnitsFullStatsChoose("MageUnit", this.mageName.getText(), Integer.parseInt(this.mageHealth.getText()), Integer.parseInt(this.mageAttack.getText()), Integer.parseInt(this.mageArmor.getText()), TerrainType.DEFAULTTERAIN, Integer.parseInt(this.mageNumberOfUnits.getText()));
                army.addAllUnits(units);
            }
        }
    }

    /**
     * Events when the Create Army button is pressed.
     * <ul>
     *     <li>
     *          Creates an army form the info form the text fields.
     *     </li>
     *     <li>
     *         If something is wrong, the user gets an alert.
     *     </li>
     *     <li>
     *         The user get a choice where to save the army fields.
     *     </li>
     *     <li>
     *         If everything is correct, it changes scene to StartWindow and clears all fields.
     *     </li>
     *     <li>
     *         If not correct nothing happens, expect alert popups.
     *     </li>
     * </ul>
     * @param actionEvent an action event
     * @throws FileNotFoundException file not found exception.
     */
    @FXML
    protected void createArmyButtonPressed(ActionEvent actionEvent) throws FileNotFoundException {

        checkIfArmyNameIsFiledIsValid();
        checkTheCheckBoksesIsSelected();
        checkIfCommanderUnitFiledAreValid();

        //Creates the army file.
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        Army army = this.createArmy();
        csvFileHandler.creatCSVFile(army, csvFileHandler.saveFilePath().toString());

        //Army was created Alert.
        armyWasCreateAlert().showAndWait();
        this.clearAllFields();

        //Change scene to StartWindowScene.
        this.infoWindowController.setLastScene(startWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.startWindowScene);
    }

    /**
     * An alert that tell the user that the file was created.
     */
    private Alert armyWasCreateAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Army Was Created");
        alert.setContentText("The army was created as a csv file. You can find the file where you chose to save the file.");
        return alert;
    }

    /**
     * An alert that tell the user that the army name is empty
     */
    private void armyNameIsEmptyAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No army name");
        alert.setContentText("Need an army name before the army can be created.");
        alert.show();
    }

    /**
     * An alert that tell that the textFiles for InfantryUnit aren't a number.
     */
    private void textFiledForInfantryAreNotAPositiveNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText("There is wrong input in InfantryUnit text filed");
        alert.setContentText(WRONGNUMBERINPUTINNUMBERTEXTFIELDS);
        alert.show();
    }

    /**
     * An alert that tell that the textFiled name for InfantryUnit are wrong.
     */
    private void textFiledNameForInfetryIsWorngAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText(FILEDHASNOTBEENFFILLEDTOCREATEARMY);
        alert.setContentText("The InfantryUnits most have a name, an health number and a number of units you want to create. One or more of this text filed are empty. Fill the to create an army. (Attack and Armor does not need to be fill to create an army.");
        alert.show();
    }

    /**
     * An alert that tell that the textFiles for RangeUnit aren't a number.
     */
    private void textFiledForRangeAreNotAPositiveNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText("There is wrong input in RangeUnit text filed");
        alert.setContentText(WRONGNUMBERINPUTINNUMBERTEXTFIELDS);
        alert.show();
    }

    /**
     * An alert that tell that the textFiled name for RangeUnit are wrong.
     */
    private void textFiledNameForRangeIsWorngAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText(FILEDHASNOTBEENFFILLEDTOCREATEARMY);
        alert.setContentText("The RangeUnit most have a name, an health number and a number of units you want to create. One or more of this text filed are empty. Fill the to create an army. (Attack and Armor does not need to be fill to create an army.");
        alert.show();
    }

    /**
     * An alert that tell that the textFiles for CavlryUnit aren't a number.
     */
    private void textFiledForCavlryAreNotAPositiveNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText("There is wrong input in CavlryUnit text filed");
        alert.setContentText(WRONGNUMBERINPUTINNUMBERTEXTFIELDS);
        alert.show();
    }

    /**
     * An alert that tell that the textFiled name for CavlryUnit are wrong.
     */
    private void textFiledNameForCavlryIsWorngAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText(FILEDHASNOTBEENFFILLEDTOCREATEARMY);
        alert.setContentText("The CavlryUnit most have a name, an health number and a number of units you want to create. One or more of this text filed are empty. Fill the to create an army. (Attack and Armor does not need to be fill to create an army.");
        alert.show();
    }

    /**
     * An alert that tell that the textFiles for MageUnit aren't a number.
     */
    private void textFiledForMageAreNotAPositiveNumberAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText("There is wrong input in MageUnit text filed");
        alert.setContentText(WRONGNUMBERINPUTINNUMBERTEXTFIELDS);
        alert.show();
    }

    /**
     * An alert that tell that the textFiled name for MageUnit are wrong.
     */
    private void textFiledNameForMageIsWorngAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(WRONGINPUTINTEXTFIELD);
        alert.setHeaderText(FILEDHASNOTBEENFFILLEDTOCREATEARMY);
        alert.setContentText("The MageUnit most have a name, an health number and a number of units you want to create. One or more of this text filed are empty. Fill the to create an army. (Attack and Armor does not need to be fill to create an army.");
        alert.show();
    }

    /**
     * An alert that tell that commander need a name.
     */
    private void commanderDoesNotHaveANameAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong Input For Text Filed");
        alert.setHeaderText("Commander Does not have a name");
        alert.setContentText("The Commander for the army need a name, before you can create the army");
        alert.show();
    }

    /**
     * An aler that tell that the commander need a health.
     */
    private void commanderNeedHealthAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Wrong Input For Text Filed");
        alert.setHeaderText("The commander does not have a health");
        alert.setContentText("Commander needs a positive health number before you can create the army");
        alert.show();
    }

    /**
     * Checks if the armyName TextFiled is empty.
     * If it's empty then an alert is shown, that tels the user to
     */
    private void checkIfArmyNameIsFiledIsValid() {
        if(this.armyName.getText().isBlank()) {
            armyNameIsEmptyAlert();
        }
    }

    /**
     * Checks all the checkbokses if anny of them are selected.
     * If one is selected, the text fields that are connected to the checkboks are checked if the are valid.
     */
    private void checkTheCheckBoksesIsSelected() {
        if(this.infatryCheckBox.isSelected()) {
            this.checksThatTextFileForInfatryUnitAreValid();
        }
        if(this.rangeCheckBox.isSelected()) {
            this.checksThatTextFileForRangeUnitAreValid();
        }
        if(this.cavlryCheckBox.isSelected()){
            this.checksThatTextFileForCalvryUnitAreValid();
        }
        if(this.mageCheckBox.isSelected()) {
            this.checksThatTextFileForMageUnitAreValid();
        }
    }

    /**
     * Checks the textFiled for InfantryUnits.
     * <ul>
     *     <li>
     *         Checks if the filed that need a number are a number.
     *     </li>
     *     <li>
     *         Checks if the numbers are not 0 or below.
     *     </li>
     *     <li>
     *         Checks if name, health and numberOfUnits text filed is not empty.
     *     </li>
     * </ul>|
     */
    private void checksThatTextFileForInfatryUnitAreValid() {
        if(this.infatryName.getText().isBlank() || this.infatryHealth.getText().isBlank() || this.infatryNumberOfUnits.getText().isBlank()) {
            textFiledNameForInfetryIsWorngAlert();
        }
        else if(!this.infatryName.getText().isBlank() && !this.infatryHealth.getText().isBlank() && !this.infatryNumberOfUnits.getText().isBlank() && this.infatryAttack.getText().isBlank() && this.infatryArmor.getText().isBlank()) {
            if (!isNumeric(this.infatryHealth.getText())  || !isNumeric(this.infatryNumberOfUnits.getText())) {
                textFiledForInfantryAreNotAPositiveNumberAlert();
            }
            if (this.infatryHealth.getText().contains("-")  || this.infatryNumberOfUnits.getText().contains("-")) {
                textFiledForInfantryAreNotAPositiveNumberAlert();
            }
        }
        else if(!this.infatryName.getText().isBlank() && !this.infatryHealth.getText().isBlank() && !this.infatryNumberOfUnits.getText().isBlank() && !this.infatryAttack.getText().isBlank() && !this.infatryArmor.getText().isBlank()) {
            if (!isNumeric(this.infatryHealth.getText()) || !isNumeric(this.infatryNumberOfUnits.getText()) || !isNumeric(this.infatryAttack.getText()) || !isNumeric(this.infatryArmor.getText())) {
                textFiledForInfantryAreNotAPositiveNumberAlert();
            }
            if (this.infatryHealth.getText().contains("-") || this.infatryAttack.getText().contains("-") || this.infatryArmor.getText().contains("-") || this.infatryNumberOfUnits.getText().contains("-")) {
                textFiledForInfantryAreNotAPositiveNumberAlert();
            }
        }
    }

    /**
     * Checks the textFiled for RangeUnit.
     * <ul>
     *     <li>
     *         Checks if the filed that need a number are a number.
     *     </li>
     *     <li>
     *         Checks if the numbers are not 0 or below.
     *     </li>
     *     <li>
     *         Checks if name, health and numberOfUnits text filed is not empty.
     *     </li>
     * </ul>
     */
    private void checksThatTextFileForRangeUnitAreValid() {
        if(this.rangeName.getText().isBlank() || this.rangeHealth.getText().isBlank() || this.rangeNumberOfUnits.getText().isBlank()) {
            textFiledNameForRangeIsWorngAlert();
        }
        else if(!this.rangeName.getText().isBlank() && !this.rangeHealth.getText().isBlank() && !this.rangeNumberOfUnits.getText().isBlank() && this.rangeAttack.getText().isBlank() && this.rangeArmor.getText().isBlank()) {
            if (!isNumeric(this.rangeHealth.getText())  || !isNumeric(this.rangeNumberOfUnits.getText())) {
                textFiledForRangeAreNotAPositiveNumberAlert();
            }
            if (this.infatryHealth.getText().contains("-")  || this.infatryNumberOfUnits.getText().contains("-")) {
                textFiledForRangeAreNotAPositiveNumberAlert();
            }
        }
        else if(!this.rangeName.getText().isBlank() && !this.rangeHealth.getText().isBlank() && !this.rangeNumberOfUnits.getText().isBlank() && !this.rangeAttack.getText().isBlank() && !this.rangeArmor.getText().isBlank()) {
            if (!isNumeric(this.rangeHealth.getText()) || !isNumeric(this.rangeNumberOfUnits.getText()) || !isNumeric(this.rangeAttack.getText()) || !isNumeric(this.rangeArmor.getText())) {
                textFiledForRangeAreNotAPositiveNumberAlert();
            }
            if (this.rangeHealth.getText().contains("-") || this.rangeAttack.getText().contains("-") || this.rangeArmor.getText().contains("-") || this.rangeNumberOfUnits.getText().contains("-")) {
                textFiledForRangeAreNotAPositiveNumberAlert();
            }
        }
    }

    /**
     * Checks the textFiled for CalvryUnit.
     * <ul>
     *     <li>
     *         Checks if the filed that need a number are a number.
     *     </li>
     *     <li>
     *         Checks if the numbers are not 0 or below.
     *     </li>
     *     <li>
     *         Checks if name, health and numberOfUnits text filed is not empty.
     *     </li>
     * </ul>
     */
    private void checksThatTextFileForCalvryUnitAreValid() {
        if(this.cavlryName.getText().isBlank() || this.cavlryHealth.getText().isBlank() || this.cavlryNumberOfUnits.getText().isBlank()) {
            textFiledNameForRangeIsWorngAlert();
        }
        else if(!this.cavlryName.getText().isBlank() && !this.cavlryHealth.getText().isBlank() && !this.cavlryNumberOfUnits.getText().isBlank() && this.cavlryAttack.getText().isBlank() && this.cavlryArmor.getText().isBlank()) {
            if (!isNumeric(this.cavlryHealth.getText())  || !isNumeric(this.cavlryNumberOfUnits.getText())) {
                textFiledForCavlryAreNotAPositiveNumberAlert();
            }
            if (this.cavlryHealth.getText().contains("-")  || this.cavlryNumberOfUnits.getText().contains("-")) {
                textFiledForCavlryAreNotAPositiveNumberAlert();
            }
        }
        else if(!this.cavlryName.getText().isBlank() && !this.cavlryHealth.getText().isBlank() && !this.cavlryNumberOfUnits.getText().isBlank() && !this.cavlryAttack.getText().isBlank() && !this.cavlryArmor.getText().isBlank()) {
            if (!isNumeric(this.cavlryHealth.getText()) || !isNumeric(this.cavlryNumberOfUnits.getText()) || !isNumeric(this.cavlryAttack.getText()) || !isNumeric(this.cavlryArmor.getText())) {
                textFiledForCavlryAreNotAPositiveNumberAlert();
            }
            if (this.cavlryHealth.getText().contains("-") || this.cavlryAttack.getText().contains("-") || this.cavlryArmor.getText().contains("-") || this.cavlryNumberOfUnits.getText().contains("-")) {
                textFiledForCavlryAreNotAPositiveNumberAlert();
            }
        }
    }

    /**
     * Checks the textFiled for MageUnit.
     * <ul>
     *     <li>
     *         Checks if the filed that need a number are a number.
     *     </li>
     *     <li>
     *         Checks if the numbers are not 0 or below.
     *     </li>
     *     <li>
     *         Checks if name, health and numberOfUnits text filed is not empty.
     *     </li>
     * </ul>
     */
    private void checksThatTextFileForMageUnitAreValid() {
        if(this.mageName.getText().isBlank() || this.mageHealth.getText().isBlank() || this.mageNumberOfUnits.getText().isBlank()) {
            textFiledNameForMageIsWorngAlert();
        }
        else if(!this.mageName.getText().isBlank() && !this.mageHealth.getText().isBlank() && !this.mageNumberOfUnits.getText().isBlank() && this.mageAttack.getText().isBlank() && this.mageArmor.getText().isBlank()) {
            if (!isNumeric(this.mageHealth.getText())  || !isNumeric(this.mageNumberOfUnits.getText())) {
                textFiledForMageAreNotAPositiveNumberAlert();
            }
            if (this.mageHealth.getText().contains("-")  || this.mageNumberOfUnits.getText().contains("-")) {
                textFiledForMageAreNotAPositiveNumberAlert();
            }
        }
        else if(!this.mageName.getText().isBlank() && !this.mageHealth.getText().isBlank() && !this.mageNumberOfUnits.getText().isBlank() && !this.mageAttack.getText().isBlank() && !this.mageArmor.getText().isBlank()) {
            if (!isNumeric(this.mageHealth.getText()) || !isNumeric(this.mageNumberOfUnits.getText()) || !isNumeric(this.mageAttack.getText()) || !isNumeric(this.mageArmor.getText())) {
                textFiledForMageAreNotAPositiveNumberAlert();
            }
            if (this.mageHealth.getText().contains("-") || this.mageAttack.getText().contains("-") || this.mageArmor.getText().contains("-") || this.mageNumberOfUnits.getText().contains("-")) {
                textFiledForMageAreNotAPositiveNumberAlert();
            }
        }
    }

    /**
     * Checks the textFiled for CommanderUnit
     * <ul>
     *     <li>
     *         Checks if health is a number above 0.
     *     </li>
     *     <li>
     *         Checks if name is not empty.
     *     </li>
     * </ul>
     */
    public void checkIfCommanderUnitFiledAreValid() {
        if(commanderName.getText().isBlank()) {
            commanderDoesNotHaveANameAlert();
        }
        if(!isNumeric(this.commanderHealth.getText()) || this.commanderHealth.getText().isBlank() || this.commanderHealth.getText().contains("-")) {
            commanderNeedHealthAlert();
        }
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
     * Checks if the String is a number or not.
     *
     * @param string the String you want to check.
     * @return boolean statement.
     */
    public static boolean isNumeric(String string) {
        Boolean tureOrFalse;
        try {
            Double.parseDouble(string);
            tureOrFalse = true;
        } catch(NumberFormatException e){
            tureOrFalse = false;
        }
        return tureOrFalse;
    }
}
