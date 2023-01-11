package no.ntnu.iir.fileshandlers;
/**
 * Handling CSV files that are used for saving army.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */

import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import no.ntnu.iir.data.*;
import no.ntnu.iir.logic.UnitFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * A class that can control the file handeling of csv files.
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class CSVFileHandler {

    /**
     * Creats an csv files that have an army in it.
     * This you sett all stats of the unit.
     * @param army the army that you want to save.
     * @param fileName name of the file you are creating.
     * @throws FileNotFoundException file not found exception.
     */
    public void creatCSVFile(Army army, String fileName) throws FileNotFoundException {

        List<Unit> armyUnits = army.getAllUnits();
        File csvFile = new File(pathChecker(fileName));
        PrintWriter out = new PrintWriter(csvFile);

        out.println(army.getName());
        armyUnits.forEach(unit -> out.println(unit.getClass().getSimpleName()
                + ","
                + unit.getName()
                + ","
                + unit.getHealth()
                + ","
                + unit.getAttack()
                + ","
                + unit.getArrmor()
                + ","
                + unit.getTerrain().toString()));
        out.close();
    }
    //TODO file choser
    /**
     * Reads and returns an army basted on a csv file.
     * @param fileName path and name of the file.
     * @return the new army
     */
    public Army readCSVFile(String fileName) {

        Path stringToPath = Paths.get(pathChecker(fileName));
        Army army = new Army("name");
        UnitFactory unitFactory = new UnitFactory();

        try (BufferedReader bufferedReader = Files.newBufferedReader(stringToPath)) {
            String line = bufferedReader.readLine();
            while (line !=null) {
                String[] armyDataFile = line.split(",");
                if(armyDataFile.length == 1) {
                    army.setName(armyDataFile[0]);
                }
                else if (armyDataFile.length == 4) {
                    Unit unit = unitFactory.createAUnit(armyDataFile[0] ,armyDataFile[1], Integer.parseInt(armyDataFile[2]),getTerrainTypeFormACSVFIle(armyDataFile));
                    army.addUnit(unit);
                }
                else if(armyDataFile.length == 6) {
                    Unit unit = unitFactory.createAUnitAllStatsChoose(armyDataFile[0] ,armyDataFile[1], Integer.parseInt(armyDataFile[2]),Integer.parseInt(armyDataFile[3]),Integer.parseInt(armyDataFile[4]), getTerrainTypeFormACSVFIle(armyDataFile));
                    army.addUnit(unit);
                }
                else{
                    throw new IllegalArgumentException("Some Thing Wrong With The File");
                }
                line = bufferedReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return army;
    }

    /**
     * Checks a unit for a csv file what type of TerrainType it has.
     * Returns the TerrainTpe it has.
     * @param armyDataFile file you want to check.
     * @return TerrainType.
     */
    private TerrainType getTerrainTypeFormACSVFIle(String[] armyDataFile) {
        TerrainType terrainType = null;
        if(armyDataFile.length == 6) {
            switch (armyDataFile[5]) {
                case "FOREST":
                    terrainType = TerrainType.FOREST;
                    break;
                case "PLAINS":
                    terrainType = TerrainType.PLAINS;
                    break;
                case "HILLS":
                    terrainType = TerrainType.HILLS;
                    break;
                case "DEFAULTTERAIN":
                    terrainType = TerrainType.DEFAULTTERAIN;
                    break;
                default:
                    throw new IllegalArgumentException("The string didn't match anny of the cases");
            }
        }
        return terrainType;
    }

    /**
     * Checks the path to a file.
     * Checks if it's a csv or something else.
     * Also checks if the name of the file have .csv in it or not.
     * @param fileName name of tile file you want to check the path to.
     * @return a path with the file.
     */
    public String pathChecker(String fileName) {
        String path = null;
        if (fileName.contains(".csv")) {
            path = fileName;
        }
        else if (fileName.contains(".")) {
            throw new IllegalArgumentException("Cant read this type of file");
        }
        else{
            path = fileName + ".csv";
        }
        return path;
    }

    /**
     * Finds files
     * @return fileChooser
     */
    public File findFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("CSV Files", "*.csv");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File selectedFile = fileChooser.showOpenDialog(null);
        return selectedFile;
    }

    /**
     * Finds the path on the computer for the user.
     * @return selectedFile.
     */
    public File saveFilePath() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save Army File");
        File selectedFile = fileChooser.showSaveDialog(null);
        return selectedFile;
    }
}
