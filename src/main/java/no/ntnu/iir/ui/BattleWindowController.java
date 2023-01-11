package no.ntnu.iir.ui;

import io.github.palexdev.materialfx.controls.MFXCheckbox;
import io.github.palexdev.materialfx.controls.MFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import no.ntnu.iir.data.Army;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.fileshandlers.CSVFileHandler;
import no.ntnu.iir.logic.Battle;
import javafx.event.ActionEvent;


/**
 * The controller class for the Battle_Window.fxml file.
 * It handles every function battle window haves for the application.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class BattleWindowController {

    //Armies
    private Army armyOne;
    private Army armyTwo;

    //Paths as String
    private String armyOnePath;
    private String armyTwoPath;

    //Scenes
    private Scene startWindowScene;
    private Scene infoWindowScene;

    //Controllerss
    private InfoWindowController infoWindowController;

    private static final String ALIVE = "Alive";
    private static final String DEAD = "Dead";

    //ChechBokses
    @FXML
    private MFXToggleButton musicChechBoks = new MFXToggleButton();

    //ArmyOne Commander and ArmyName Labels
    @FXML
    private Label armyOneLabel = new Label();
    @FXML
    private Label armyOneCommanderName = new Label();
    @FXML
    private Label armyOneCommanderAttackLabel = new Label();
    @FXML
    private Label armyOneCommanderHealth = new Label();
    @FXML
    private Label armyOneCommanderArmorLabel = new Label();
    @FXML
    private Label armyOneTotalNumberOfUnits = new Label();
    @FXML
    private Label armyOneCommanderAliveOrDeadLabel = new Label();

    //ArmyOne InfantryUnits Labels
    @FXML
    private Label armyOneInfatryUnitNameLabel = new Label();
    @FXML
    private Label armyOneInfatryUnitHealthLabel = new Label();
    @FXML
    private Label armyOneInfatryUnitAttackLabel = new Label();
    @FXML
    private Label armyOneInfatryUnitArmorLAbel = new Label();
    @FXML
    private Label armyOneInfatryUnitNumberOfUnitsLabel = new Label();

    //ArmyOne RangeUnits Labels
    @FXML
    private Label armyOneRangeUnitNameLabel = new Label();
    @FXML
    private Label armyOneRangeUnitHealthLabel = new Label();
    @FXML
    private Label armyOneRangeUnitAttackLabel = new Label();
    @FXML
    private Label armyOneRangeUnitArmorLAbel = new Label();
    @FXML
    private Label armyOneRangeUnitNumberOfUnitsLabel = new Label();

    //ArmyOne CalvaryUnits Labels
    @FXML
    private Label armyOneCavlryUnitNameLabel = new Label();
    @FXML
    private Label armyOneCavlryUnitHealthLabel = new Label();
    @FXML
    private Label armyOneCavlryUnitAttackLabel = new Label();
    @FXML
    private Label armyOneCavalryUnitArmorLAbel = new Label();
    @FXML
    private Label armyOneCavalryNumberOfUnitsLabel = new Label();

    //ArmyOne MageUnits Labels
    @FXML
    private Label armyOneMageUnitNameLabel = new Label();
    @FXML
    private Label armyOneMageUnitHealthLabel = new Label();
    @FXML
    private Label armyOneMageUnitAttackLabel = new Label();
    @FXML
    private Label armyOneMageUnitArmorLAbel = new Label();
    @FXML
    private Label armyOneMageNumberOfUnitsLabel = new Label();


    //ArmyTwo Commander and ArmyName Labels
    @FXML
    private Label armyTwoLabel = new Label();
    @FXML
    private Label armyTwoCommanderName = new Label();
    @FXML
    private Label armyTwoCommanderAttackLabel = new Label();
    @FXML
    private Label armyTwoCommanderHealth = new Label();
    @FXML
    private Label armyTwoCommanderArmorLabel = new Label();
    @FXML
    private Label armyTwoTotalNumberOfUnits = new Label();
    @FXML
    private Label armyTwoCommanderAliveOrDeadLabel = new Label();

    //ArmyTwo InfantryUnits Labels
    @FXML
    private Label armyTwoInfatryUnitNameLabel = new Label();
    @FXML
    private Label armyTwoInfatryUnitHealthLabel = new Label();
    @FXML
    private Label armyTwoInfatryUnitAttackLabel = new Label();
    @FXML
    private Label armyTwoInfatryUnitArmorLAbel = new Label();
    @FXML
    private Label armyTwoInfatryUnitNumberOfUnitsLabel = new Label();

    //ArmyTwo RangeUnits Labels
    @FXML
    private Label armyTwoRangeUnitNameLabel = new Label();
    @FXML
    private Label armyTwoRangeUnitHealthLabel = new Label();
    @FXML
    private Label armyTwoRangeUnitAttackLabel = new Label();
    @FXML
    private Label armyTwoRangeUnitArmorLAbel = new Label();
    @FXML
    private Label armyTwoRangeUnitNumberOfUnitsLabel = new Label();

    //ArmyTwo CavlryUnits Labels
    @FXML
    private Label armyTwoCavlryUnitNameLabel = new Label();
    @FXML
    private Label armyTwoCavlryUnitHealthLabel = new Label();
    @FXML
    private Label armyTwoCavlryUnitAttackLabel = new Label();
    @FXML
    private Label armyTwoCavalryUnitArmorLAbel = new Label();
    @FXML
    private Label armyTwoCavalryNumberOfUnitsLabel = new Label();

    //ArmyTwo MageUnits Labels
    @FXML
    private Label armyTwoMageUnitNameLabel = new Label();
    @FXML
    private Label armyTwoMageUnitHealthLabel = new Label();
    @FXML
    private Label armyTwoMageUnitAttackLabel = new Label();
    @FXML
    private Label armyTwoMageUnitArmorLAbel = new Label();
    @FXML
    private Label armyTwoMageNumberOfUnitsLabel = new Label();

    //CheckBokses
    @FXML
    private MFXCheckbox forestTerrainChechBoks = new MFXCheckbox();
    @FXML
    private MFXCheckbox hillsTerrainCheckBoks = new MFXCheckbox();
    @FXML
    private MFXCheckbox plainsTerrainCheckBoks = new MFXCheckbox();

    //BattleWindow info labels
    @FXML
    private Label winnerLabel = new Label();
    @FXML
    private Label armyOneVsArmyTwoLabel = new Label();

    /**
     * Sets up Start_Window.fxml as a scene in this class.
     *
     * @param startWindowScene the startWindow scene.
     */
    public void setStartWindowScene(Scene startWindowScene) {
        this.startWindowScene = startWindowScene;
    }

    /**
     * Set up Info_Window.fxml as a scene.
     * @param infoWindowScene the infoWindow scene.
     */
    public void setInfoWindowScene(Scene infoWindowScene) {
        this.infoWindowScene = infoWindowScene;
    }

    /**
     * Sets the controller class for infoWindowController.
     * @param infoWindowController the controller you want to set for infoWindowController.
     */
    public void setInfoWindowController(InfoWindowController infoWindowController) {
        this.infoWindowController = infoWindowController;
    }

    /**
     * Sets the labels for BattleWindow.
     */
    public void setLabels() {
        setArmyOneLabels();
        setArmyTwoLabels();
        armyOneVsArmyTwoLabel.setText(armyOne.getName() + " VS " + armyTwo.getName());
    }

    /**
     * Sets the labels on
     */
    private void setArmyOneLabels() {
        this.armyOneLabel.setText(armyOne.getName());
        this.armyOneCommanderName.setText(armyOne.getCommanderUnits().get(0).getName());
        this.armyOneCommanderAttackLabel.setText(armyOne.getCommanderUnits().get(0).getAttack() + "");
        this.armyOneCommanderHealth.setText(armyOne.getCommanderUnits().get(0).getHealth() + "");
        this.armyOneCommanderArmorLabel.setText(armyOne.getCommanderUnits().get(0).getArrmor() + "");
        this.armyOneTotalNumberOfUnits.setText(armyOne.getAllUnits().size() + "");
        setLabelsArmyOneInfantryUnit();
        setLabelsArmyOneRangeUnit();
        setLabelsArmyOneCavlryUnit();
        setArmyOneLabelsMageUnit();
        }


    /**
     * Sets the labels for armyOne InfantryUnits
     */
    private void setLabelsArmyOneInfantryUnit() {
        if (!armyOne.getInfantryUnits().isEmpty()) {
            this.armyOneInfatryUnitNameLabel.setText(armyOne.getInfantryUnits().get(0).getName());
            this.armyOneInfatryUnitHealthLabel.setText(armyOne.getInfantryUnits().get(0).getHealth() + "");
            this.armyOneInfatryUnitAttackLabel.setText(armyOne.getInfantryUnits().get(0).getAttack() + "");
            this.armyOneInfatryUnitArmorLAbel.setText(armyOne.getInfantryUnits().get(0).getArrmor() + "");
            this.armyOneInfatryUnitNumberOfUnitsLabel.setText(armyOne.getInfantryUnits().size() + "");
        } else {
            this.armyOneInfatryUnitNameLabel.setText("N/A");
            this.armyOneInfatryUnitHealthLabel.setText("N/A");
            this.armyOneInfatryUnitAttackLabel.setText("N/A");
            this.armyOneInfatryUnitArmorLAbel.setText("N/A");
            this.armyOneInfatryUnitNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for armyOne RangeUnits
     */
    private void setLabelsArmyOneRangeUnit() {
        if(!armyOne.getRangeUnits().isEmpty()) {
            this.armyOneRangeUnitNameLabel.setText(armyOne.getRangeUnits().get(0).getName());
            this.armyOneRangeUnitHealthLabel.setText(armyOne.getRangeUnits().get(0).getHealth() + "");
            this.armyOneRangeUnitAttackLabel.setText(armyOne.getRangeUnits().get(0).getAttack() + "");
            this.armyOneRangeUnitArmorLAbel.setText(armyOne.getRangeUnits().get(0).getArrmor() + "");
            this.armyOneRangeUnitNumberOfUnitsLabel.setText(armyOne.getRangeUnits().size() + "");
        }
        else {
            this.armyOneRangeUnitNameLabel.setText("N/A");
            this.armyOneRangeUnitHealthLabel.setText("N/A");
            this.armyOneRangeUnitAttackLabel.setText("N/A");
            this.armyOneRangeUnitArmorLAbel.setText("N/A");
            this.armyOneRangeUnitNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for armyOne CavlryUnits
     */
    private void setLabelsArmyOneCavlryUnit() {
        if(!armyOne.getCavlaryUnits().isEmpty()) {
            this.armyOneCavlryUnitNameLabel.setText(armyOne.getCavlaryUnits().get(0).getName());
            this.armyOneCavlryUnitHealthLabel.setText(armyOne.getCavlaryUnits().get(0).getHealth() + "");
            this.armyOneCavlryUnitAttackLabel.setText(armyOne.getCavlaryUnits().get(0).getAttack() + "");
            this.armyOneCavalryUnitArmorLAbel.setText(armyOne.getCavlaryUnits().get(0).getArrmor() + "");
            this.armyOneCavalryNumberOfUnitsLabel.setText(armyOne.getCavlaryUnits().size() + "");
        }
        else {
            this.armyOneCavlryUnitNameLabel.setText("N/A");
            this.armyOneCavlryUnitHealthLabel.setText("N/A");
            this.armyOneCavlryUnitAttackLabel.setText("N/A");
            this.armyOneCavalryUnitArmorLAbel.setText("N/A");
            this.armyOneCavalryNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for mage units in armyOne
     */
    private void setArmyOneLabelsMageUnit() {
        if(!armyOne.getMageUnits().isEmpty()) {
            this.armyOneMageUnitNameLabel.setText(armyOne.getMageUnits().get(0).getName());
            this.armyOneMageUnitHealthLabel.setText(armyOne.getMageUnits().get(0).getHealth() + "");
            this.armyOneMageUnitAttackLabel.setText(armyOne.getMageUnits().get(0).getAttack() + "");
            this.armyOneMageUnitArmorLAbel.setText(armyOne.getMageUnits().get(0).getArrmor() + "");
            this.armyOneMageNumberOfUnitsLabel.setText(armyOne.getMageUnits().size() + "");
        }
        else {
            this.armyOneMageUnitNameLabel.setText("N/A");
            this.armyOneMageUnitHealthLabel.setText("N/A");
            this.armyOneMageUnitAttackLabel.setText("N/A");
            this.armyOneMageUnitArmorLAbel.setText("N/A");
            this.armyOneMageNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels on armyTwo
     */
    private void setArmyTwoLabels() {
        this.armyTwoLabel.setText(armyTwo.getName());
        this.armyTwoCommanderName.setText(armyTwo.getCommanderUnits().get(0).getName());
        this.armyTwoCommanderAttackLabel.setText(armyTwo.getCommanderUnits().get(0).getAttack() + "");
        this.armyTwoCommanderHealth.setText(armyTwo.getCommanderUnits().get(0).getHealth() + "");
        this.armyTwoCommanderArmorLabel.setText(armyTwo.getCommanderUnits().get(0).getArrmor() + "");
        this.armyTwoTotalNumberOfUnits.setText(armyTwo.getAllUnits().size() + "");
        setLabelsArmyTwoInfantryUnit();
        setLabelsArmyTwoRangeUnit();
        setLabelsArmyTwoCavlryUnit();
        setArmyTwoLabelsMageUnit();
    }


    /**
     * Sets the labels for armyTwo InfantryUnits
     */
    private void setLabelsArmyTwoInfantryUnit() {
        if (!armyTwo.getInfantryUnits().isEmpty()) {
            this.armyTwoInfatryUnitNameLabel.setText(armyTwo.getInfantryUnits().get(0).getName());
            this.armyTwoInfatryUnitHealthLabel.setText(armyTwo.getInfantryUnits().get(0).getHealth() + "");
            this.armyTwoInfatryUnitAttackLabel.setText(armyTwo.getInfantryUnits().get(0).getAttack() + "");
            this.armyTwoInfatryUnitArmorLAbel.setText(armyTwo.getInfantryUnits().get(0).getArrmor() + "");
            this.armyTwoInfatryUnitNumberOfUnitsLabel.setText(armyTwo.getInfantryUnits().size() + "");
        } else {
            this.armyTwoInfatryUnitNameLabel.setText("N/A");
            this.armyTwoInfatryUnitHealthLabel.setText("N/A");
            this.armyTwoInfatryUnitAttackLabel.setText("N/A");
            this.armyTwoInfatryUnitArmorLAbel.setText("N/A");
            this.armyTwoInfatryUnitNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for armyTwo RangeUnits
     */
    private void setLabelsArmyTwoRangeUnit() {
        if(!armyTwo.getRangeUnits().isEmpty()) {
            this.armyTwoRangeUnitNameLabel.setText(armyTwo.getRangeUnits().get(0).getName());
            this.armyTwoRangeUnitHealthLabel.setText(armyTwo.getRangeUnits().get(0).getHealth() + "");
            this.armyTwoRangeUnitAttackLabel.setText(armyTwo.getRangeUnits().get(0).getAttack() + "");
            this.armyTwoRangeUnitArmorLAbel.setText(armyTwo.getRangeUnits().get(0).getArrmor() + "");
            this.armyTwoRangeUnitNumberOfUnitsLabel.setText(armyTwo.getRangeUnits().size() + "");
        }
        else {
            this.armyTwoRangeUnitNameLabel.setText("N/A");
            this.armyTwoRangeUnitHealthLabel.setText("N/A");
            this.armyTwoRangeUnitAttackLabel.setText("N/A");
            this.armyTwoRangeUnitArmorLAbel.setText("N/A");
            this.armyTwoRangeUnitNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for armyTwo CavlryUnits
     */
    private void setLabelsArmyTwoCavlryUnit() {
        if(!armyTwo.getCavlaryUnits().isEmpty()) {
            this.armyTwoCavlryUnitNameLabel.setText(armyTwo.getCavlaryUnits().get(0).getName());
            this.armyTwoCavlryUnitHealthLabel.setText(armyTwo.getCavlaryUnits().get(0).getHealth() + "");
            this.armyTwoCavlryUnitAttackLabel.setText(armyTwo.getCavlaryUnits().get(0).getAttack() + "");
            this.armyTwoCavalryUnitArmorLAbel.setText(armyTwo.getCavlaryUnits().get(0).getArrmor() + "");
            this.armyTwoCavalryNumberOfUnitsLabel.setText(armyTwo.getCavlaryUnits().size() + "");
        }
        else {
            this.armyTwoCavlryUnitNameLabel.setText("N/A");
            this.armyTwoCavlryUnitHealthLabel.setText("N/A");
            this.armyTwoCavlryUnitAttackLabel.setText("N/A");
            this.armyTwoCavalryUnitArmorLAbel.setText("N/A");
            this.armyTwoCavalryNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets the labels for mage units armyTwo
     */
    private void setArmyTwoLabelsMageUnit() {
        if(!armyTwo.getMageUnits().isEmpty()) {
            this.armyTwoMageUnitNameLabel.setText(armyTwo.getMageUnits().get(0).getName());
            this.armyTwoMageUnitHealthLabel.setText(armyTwo.getMageUnits().get(0).getHealth() + "");
            this.armyTwoMageUnitAttackLabel.setText(armyTwo.getMageUnits().get(0).getAttack() + "");
            this.armyTwoMageUnitArmorLAbel.setText(armyTwo.getMageUnits().get(0).getArrmor() +  "");
            this.armyTwoMageNumberOfUnitsLabel.setText(armyTwo.getMageUnits().size() + "");
        }
        else {
            this.armyTwoMageUnitNameLabel.setText("N/A");
            this.armyTwoMageUnitHealthLabel.setText("N/A");
            this.armyTwoMageUnitAttackLabel.setText("N/A");
            this.armyTwoMageUnitArmorLAbel.setText("N/A");
            this.armyTwoMageNumberOfUnitsLabel.setText("N/A");
        }
    }

    /**
     * Sets ArmyOne.
     * @param army the army you want on armyOne.
     */
    public void setArmyOne(Army army) {
        this.armyOne = army;
    }

    /**
     * Sets armyTwo.
     * @param army the army you want on armyTwo.
     */
    public void setArmyTwo(Army army) {
        this.armyTwo = army;
    }

    /**
     * Resets the armyOne.
     */
    public void resetArmyOne() {
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        this.armyOne = csvFileHandler.readCSVFile(armyOnePath);
    }

    /**
     * Resets the armyTwo.
     */
    public void resetArmyTwo() {
        CSVFileHandler csvFileHandler = new CSVFileHandler();
        this.armyTwo = csvFileHandler.readCSVFile(armyTwoPath);
    }

    /**
     * Sets armyOne String path to csv file.
     * @param path a String that works as a path.
     */
    public void setPathArmyOne(String path) {
        this.armyOnePath = path;
    }

    /**
     * Sets armyTwo String path to a csv file.
     * @param path a String that works as a path.
     */
    public void setPathArmyTwo(String path) {
        this.armyTwoPath = path;
    }

    /**
     * Events when the forestCheckBoks is click.
     * <ul>
     *     <li>
     *         If isSelected is true, then set all the units in both armies to Forest terrain, and uncheck the other checkbokses.
     *     </li>
     *     <li>
     *         If isSelected is false, then set all the units in both armies to Default terrain.
     *    </li>
     * </ul>
     */
    @FXML
    protected void forestCheckClick() {
        if(this.forestTerrainChechBoks.isSelected()) {
            this.hillsTerrainCheckBoks.setSelected(false);
            this.plainsTerrainCheckBoks.setSelected(false);
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.FOREST));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.FOREST));
        }
        else {
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
        }
    }

    /**
     * Events when the hillstCheckBoks is clickt.
     * <ul>
     *     <li>
     *         If isSelected is true, then set all the units in both armies to Hills terrain, and uncheck the outher checkbokses.
     *     </li>
     *     <li>
     *         If isSelcted is false, then set all the units in both armiess to Default terrain.
     *    </li>
     * </ul>
     */
    @FXML
    protected void hillsCheckClick() {
        if(this.hillsTerrainCheckBoks.isSelected()) {
            this.forestTerrainChechBoks.setSelected(false);
            this.plainsTerrainCheckBoks.setSelected(false);
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.HILLS));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.HILLS));
        }
        else {
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
        }
    }

    /**
     * Events when the plainsCheckBoks is clickt.
     * <ul>
     *     <li>
     *         If isSelected is true, then set all the units in both armies to Plains terrain, and uncheck the outher checkbokses.
     *     </li>
     *     <li>
     *         If isSelcted is false, then set all the units in both armiess to Default terrain.
     *    </li>
     * </ul>
     */
    @FXML
    protected void plainsCheckClick() {
        if(this.plainsTerrainCheckBoks.isSelected()) {
            this.hillsTerrainCheckBoks.setSelected(false);
            this.forestTerrainChechBoks.setSelected(false);
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.PLAINS));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.PLAINS));
        }
        else {
            this.armyOne.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
            this.armyTwo.getAllUnits().forEach(unit -> unit.setTerrainType(TerrainType.DEFAULTTERAIN));
        }
    }

    /**
     * Events that happens when the start button is pressed.
     * <ul>
     *     <li>
     *         Runs the battle simulation.
     *     </li>
     *     <li>
     *         Sets the winnerLabel with the army name of the winner for the battle.
     *     </li>
     *     <li>
     *         Sets the different labels that have number of units in them, with the new number of units in each army.
     *     </li>
     *     <li>
     *         Sets the commanders labels deadOrAlive. If the commander/commanders is dead then it's set as dead, if alive it's set as alive.
     *     </li>
     *     <li>
     *         If no terrain type is selected, an alert is show that the user need to choose a terrain type. The simulation is not run.
     *     </li>
     * </ul>
     */
    @FXML
    protected void startBattleButtonPressed() {
        if(forestTerrainChechBoks.isSelected() || hillsTerrainCheckBoks.isSelected() || plainsTerrainCheckBoks.isSelected()) {
            Battle battle = new Battle(armyOne, armyTwo);
            winnerLabel.setText("The Winner Of The Battle Is " + battle.simulateBattle().getName());

            setNumberOfunitsLabels();

            if(!this.armyOne.getCommanderUnits().isEmpty()) {
                this.armyOneCommanderAliveOrDeadLabel.setText(ALIVE);
            }
            else {
                this.armyOneCommanderAliveOrDeadLabel.setText(DEAD);
            }
            if(!this.armyTwo.getCommanderUnits().isEmpty()) {
                this.armyTwoCommanderAliveOrDeadLabel.setText(ALIVE);
            }
            else {
                this.armyTwoCommanderAliveOrDeadLabel.setText(DEAD);
            }
        }
        else {
            noTerrainTypeIsSelectedAlert();
        }
    }

    /**
     * Event when the resetBattle button is pressed.
     * <ul>
     *     <li>
     *         Clears the terrain chechbokses.
     *     </li>
     *     <li>
     *         Resets Army One.
     *     </li>
     *     <li>
     *         Resets Army Two.
     *     </li>
     *     <li>
     *         Sets the winner labe to blank.
     *     </li>
     *     <li>
     *         Resets the total number of units label in the armies.
     *     </li>
     *     <li>
     *         Reset the commander units aliveOrDeadLabel to alive in both armies
     *     </li>
     * </ul>
     */
    @FXML
    protected void resetBattleButtonPressed() {

        //Cleare the chechbokses
        clearTheCheckBokses();

        //Reset armyOne
        resetArmyOne();

        //Reset armyTwo
        resetArmyTwo();

        //Sets the number labels
        setNumberOfunitsLabels();

        //Cleare winnerLabel
        winnerLabel.setText("");

        //Reset the commander labels to alive
        this.armyOneCommanderAliveOrDeadLabel.setText(ALIVE);
        this.armyTwoCommanderAliveOrDeadLabel.setText(ALIVE);
    }

    /**
     * Sets the labels for the different numbers of units in both armies.
     * <ul>
     *     <li>
     *         Number of InfantryUnits.
     *     </li>
     *     <li>
     *         Number of RangeUnits.
     *     </li>
     *     <li>
     *         Number of CalvaryUnits.
     *     </li>
     *     <li>
     *         Number of MageUnits.
     *     </li>
     *     <li>
     *         Total number of Units.
     *     </li>
     * </ul>
     */
    private void setNumberOfunitsLabels() {
        this.armyOneTotalNumberOfUnits.setText(this.armyOne.getAllUnits().size() + "");
        this.armyOneInfatryUnitNumberOfUnitsLabel.setText(armyOne.getInfantryUnits().size() + "");
        this.armyOneRangeUnitNumberOfUnitsLabel.setText(armyOne.getRangeUnits().size() + "");
        this.armyOneCavalryNumberOfUnitsLabel.setText(armyOne.getCavlaryUnits().size() + "");
        this.armyOneMageNumberOfUnitsLabel.setText(armyOne.getMageUnits().size() + "");
        this.armyTwoTotalNumberOfUnits.setText(this.armyTwo.getAllUnits().size() + "");
        this.armyTwoInfatryUnitNumberOfUnitsLabel.setText(armyTwo.getInfantryUnits().size() + "");
        this.armyTwoRangeUnitNumberOfUnitsLabel.setText(armyTwo.getRangeUnits().size() + "");
        this.armyTwoCavalryNumberOfUnitsLabel.setText(armyTwo.getCavlaryUnits().size() + "");
        this.armyTwoMageNumberOfUnitsLabel.setText(armyTwo.getMageUnits().size() + "");
    }

    /**
     * Clear the chech bokses.
     */
    private void clearTheCheckBokses() {
        forestTerrainChechBoks.setSelected(false);
        hillsTerrainCheckBoks.setSelected(false);
        plainsTerrainCheckBoks.setSelected(false);
    }

    /**
     * An alert when the user try to start battle without choosing anny terrainType.
     * Tels the user to select a terrain type.
     */
    private void noTerrainTypeIsSelectedAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("No TerrainType Chosen.");
        alert.setContentText("You need to chose an terrain type before you can start the battle.");
        alert.show();
    }

    /**
     * Event when backButton is pressed.
     * <ul>
     *     <li>
     *         Cleare the check bokses.
     *     </li>
     *     <li>
     *         Set startWindowScene as new scene on the stage.
     *     </li>
     * </ul>
     * @param actionEvent actionEvent.
     */
    @FXML
    protected void backButtonPressed(ActionEvent actionEvent) {
        clearTheCheckBokses();
        this.infoWindowController.setLastScene(this.startWindowScene);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.startWindowScene);
    }

    /**
     * Events when InfoButton is pressed. Sets the stage to infoWindowScene, and switches window to Info_Window.fxml
     * @param actionEvent action event
     */
    @FXML
    protected void infoWindowButtonPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        this.setScene(stage, this.infoWindowScene);
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
