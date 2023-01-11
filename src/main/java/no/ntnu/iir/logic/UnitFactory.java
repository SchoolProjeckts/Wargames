package no.ntnu.iir.logic;

import no.ntnu.iir.data.*;
import java.util.ArrayList;
import java.util.List;
/**
 * This class is a unit factory class.
 * That means that this class if for creating units.
 * Every unit can be created in this class.
 * You can create one and one unit, or you can create a list of units.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class UnitFactory {

    /**
     * Create a set number of units.
     * @param typeOfUnit the type of unit you want to create. Most be InfantryUnit, RangeUnit, CavlryUnit or CommanderUnit.
     * @param name the name you want to giv the unit.
     * @param health the health you want to giv a unit.
     * @param numberOfUnits number of units you want to create
     * @param terrainType the type of terrain the unit has.
     * @return a list of units
     */
    //TODO sjekke om bruk av lambda
    public List<Unit> createUnits(String typeOfUnit ,String name, int health,TerrainType terrainType, int numberOfUnits) {
        List<Unit> listOfUnits = new ArrayList<>();
        if(numberOfUnits > 0) {
            for (int index = 1; index <= numberOfUnits; index++) {
                listOfUnits.add(createAUnit(typeOfUnit , name, health, terrainType));
            }
        }
        else {
            throw new IllegalArgumentException("Not a valid number");
        }
        return listOfUnits;
    }

    /**
     * Create a set number of units.
     * In this one you can set all stats.
     * @param typeOfUnit the type of unit you want to create. Most be InfantryUnit, RangeUnit, CavlryUnit or CommanderUnit.
     * @param name the name you want to giv the unit.
     * @param health the health stats you want to giv a unit.
     * @param attack the attack stats you want to giv the unit.
     * @param armor the armor stats you want to giv the unit.
     * @param numberOfUnits number of units you want to create
     * @param terrainType the type of terrain the unit has.
     * @return a list of units
     */
    //TODO sjekke om bruk av lambda
    public List<Unit> createUnitsFullStatsChoose(String typeOfUnit ,String name, int health, int attack, int armor, TerrainType terrainType, int numberOfUnits) {
        List<Unit> listOfUnits = new ArrayList<>();
        if(numberOfUnits > 0) {
            for (int index = 1; index <= numberOfUnits; index++) {
                listOfUnits.add(createAUnitAllStatsChoose(typeOfUnit , name, health, attack, armor, terrainType));
            }
        }
        else {
            throw new IllegalArgumentException("Not a valid number");
        }
        return listOfUnits;
    }

    /**
     * Create a unit, based on the type of unit you want to create.
     * @param typeOfUnit the type of unit you want to create. Most be InfantryUnit, RangeUnit, CavlryUnit or CommanderUnit.
     * @param name the name you want to giv the unit.
     * @param health the health you want to giv a unit.
     * @param terrainType the type of terrain the unit has.
     * @return a unit.
     */
    public Unit createAUnit(String typeOfUnit, String name, int health, TerrainType terrainType) {
        if(name == null || name.isBlank() || health <= 0 || terrainType == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        Unit aUnit = null;
        switch (typeOfUnit) {
            case "InfantryUnit":
                aUnit = createInfatryUnit(name, health ,terrainType);
                break;

            case "RangedUnit":
                aUnit = createRangeUnit(name, health, terrainType);
                break;

            case "CavlryUnit":
                aUnit = createCavlryUnit(name, health, terrainType);
                break;

            case "CommanderUnit":
                aUnit = createCommanderUnit(name, health, terrainType);
                break;

            case "MageUnit":
                aUnit = createMageUnit(name, health, terrainType);
                break;

            default:
                throw new IllegalArgumentException("The type of unit didn't match anny of the cases.");
        }
        return aUnit;
    }

    /**
     * Create a unit, based on the type of unit you want to create.
     * I this one you can set all stats.
     * @param typeOfUnit the type of unit you want to create. Most be InfantryUnit, RangeUnit, CavlryUnit or CommanderUnit.
     * @param name the name you want to giv the unit.
     * @param health the health you want to giv a unit.
     * @param attack the attack stats you want the units to have.
     * @param armor the armor stats you want the units to have.
     * @param terrainType the type of the terrain the units have.
     * @return a unit.
     */
    public Unit createAUnitAllStatsChoose(String typeOfUnit, String name, int health, int attack, int armor, TerrainType terrainType) {
        if(name == null || name.isBlank() || health <= 0 || attack <= 0 || armor <= 0 || terrainType == null) {
            throw new IllegalArgumentException("Invalid input");
        }
        Unit aUnit = null;
        switch (typeOfUnit) {
            case "InfantryUnit":
                aUnit = createInfatryUnitFullStatsChoose(name, health , attack, armor, terrainType);
                break;

            case "RangedUnit":
                aUnit = createRangedUnitFullStatsChoose(name, health , attack, armor, terrainType);
                break;

            case "CavlryUnit":
                aUnit = createCavlryUnitFullStatsChoose(name, health , attack, armor, terrainType);
                break;

            case "CommanderUnit":
                aUnit = createCommanderUnitFullStatsChoose(name, health , attack, armor, terrainType);
                break;

            case "MageUnit":
                aUnit = createMageUnitFullStatsChoose(name, health , attack, armor, terrainType);
                break;

            default:
                throw new IllegalArgumentException("The type of unit didn't match anny of the cases.");
        }
        return aUnit;
    }



    /**
     * Creates an infantry unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @return a infatryUnit
     */
    private static InfantryUnit createInfatryUnit(String name, int health, TerrainType terrainType) {
        return new InfantryUnit(name, health, terrainType);
    }

    /**
     * Creates an infantry unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @param attack of the unit you want to create.
     * @param armor of the unit you want to create.
     * @return a infatryUnit
     */
    private static InfantryUnit createInfatryUnitFullStatsChoose(String name, int health, int attack, int armor, TerrainType terrainType) {
        return new InfantryUnit(name, health, attack, armor, terrainType);
    }

    /**
     * Creates a range unit.
     * @param name of the unit you create.
     * @param health of the unit you create.
     * @return a RangedUnit.
     */
    private static RangedUnit createRangeUnit(String name, int health, TerrainType terrainType) {
        return new RangedUnit(name, health, terrainType);
    }

    /**
     * Creates an RangedUnit unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @param attack of the unit you want to create.
     * @param armor of the unit you want to create.
     * @return a RangedUnit
     */
    private static RangedUnit createRangedUnitFullStatsChoose(String name, int health, int attack, int armor, TerrainType terrainType) {
        return new RangedUnit(name, health, attack, armor, terrainType);
    }

    /**
     * Creates a cavlary unit.
     * @param name of the unit you create.
     * @param health of the unit you crate.
     * @return a CavlryUnit
     */
    private static CavlryUnit createCavlryUnit(String name, int health, TerrainType terrainType) {
        return new CavlryUnit(name, health, terrainType);
    }

    /**
     * Creates an CavlryUnit unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @param attack of the unit you want to create.
     * @param armor of the unit you want to create.
     * @return a CavlryUnit
     */
    private static CavlryUnit createCavlryUnitFullStatsChoose(String name, int health, int attack, int armor, TerrainType terrainType) {
        return new CavlryUnit(name, health, attack, armor, terrainType);
    }

    /**
     * Creates a comander unit.
     * @param name of the unit you crate.
     * @param health of the unit you create.
     * @return a ComanderUnit.
     */
    private static CommanderUnit createCommanderUnit(String name, int health, TerrainType terrainType) {
        return new CommanderUnit(name, health, terrainType);
    }

    /**
     * Creates an CommanderUnit unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @param attack of the unit you want to create.
     * @param armor of the unit you want to create.
     * @return a CommanderUnit
     */
    private static CommanderUnit createCommanderUnitFullStatsChoose(String name, int health, int attack, int armor, TerrainType terrainType) {
        return new CommanderUnit(name, health, attack, armor, terrainType);
    }

    /**
     * Creates a mage unit.
     * @param name of the unit you crate.
     * @param health of the unit you create.
     * @return a MagerUnit.
     */
    private static MageUnit createMageUnit(String name, int health, TerrainType terrainType) {
        return new MageUnit(name, health, terrainType);
    }

    /**
     * Creates an MageUnit unit.
     * @param name of the unit you create.
     * @param health of the unit you want to create.
     * @param attack of the unit you want to create.
     * @param armor of the unit you want to create.
     * @return a MageUnit
     */
    private static MageUnit createMageUnitFullStatsChoose(String name, int health, int attack, int armor, TerrainType terrainType) {
        return new MageUnit(name, health, attack, armor, terrainType);
    }
}
