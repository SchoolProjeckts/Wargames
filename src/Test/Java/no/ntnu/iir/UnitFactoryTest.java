package no.ntnu.iir;

import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;
import no.ntnu.iir.logic.UnitFactory;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * This class test the class UnitFactory.
 * Testes the class for.
 * <ul>
 *     <li>Test createAUnit with valid parameters.
 *     <ul>
 *         <li>Creates a InfatryUnit.</li>
 *         <li>Creates a RangeUnit.</li>
 *         <li>Creates a CavlryUnit.</li>
 *         <li>Creates a CommanderUnit.</li>
 *     </ul></li>
 *     <li>Test createAUnit with invalid parameters.
 *     <ul>
 *         <li>TypeOfUnit doesn't match anny type of units that exist.</li>
 *         <li>Name is set as null.</li>
 *         <li>Name is empty.</li>
 *         <li>Health is 0.</li>
 *         <li>Health is below 0.</li>
 *         <li>TerrainType is set as null.</li>
 *     </ul></li>
 *     <li>Test createUnits with valid parameters.</li>
 *     <li>Test createUnits with invalid parameters.
 *     <ul>
 *         <li>NumberOfUnits is 0.</li>
 *         <li>NumberOfUnits is below 0.</li>
 *     </ul></li>
 *
 *     <li>Test createAUnitAllStatsChoose with valid parameters.
 *     <ul>
 *         <li>Creates a InfatryUnit.</li>
 *         <li>Creates a RangeUnit.</li>
 *         <li>Creates a CavlryUnit.</li>
 *         <li>Creates a CommanderUnit.</li>
 *     </ul></li>
 *     <li>Test createAUnitAllStatsChoose with invalid parameters.
 *     <ul>
 *         <li>TypeOfUnit doesn't match anny type of units that exist.</li>
 *         <li>Name is set as null.</li>
 *         <li>Name is empty.</li>
 *         <li>Health is 0.</li>
 *         <li>Health is below 0.</li>
 *         <li>Attack is 0.</li>
 *         <li>Attack is below 0.</li>
 *         <li>Armor is 0.</li>
 *         <li>Armor is below 0.</li>
 *         <li>TerrainType is set as null.</li>
 *     </ul></li>
 *     <li>Test createUnitsFullStatsChoose with valid parameters.</li>
 *     <li>Test createUnitsFullStatsChoose with invalid parameters.
 *     <ul>
 *         <li>NumberOfUnits is 0.</li>
 *         <li>NumberOfUnits is below 0.</li>
 *     </ul></li>
 * </ul>
 *
 * @author Ole Kristian
 * @version 1.0
 */
public class UnitFactoryTest {

    /**
     * Test createAUnit whit valid parameters.
     * Create InfatryUnit.
     */
    @Test
    public void testCreatAUnitInfatryUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnit("InfantryUnit", "Infatry", 20, terrainType);
        assertEquals("InfantryUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnit whit valid parameters.
     * Create RangedUnit.
     */
    @Test
    public void testCreatAUnitRangedyUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnit("RangedUnit", "Ranged", 20, terrainType);
        assertEquals("RangedUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnit whit valid parameters.
     * Create CavlryUnit.
     */
    @Test
    public void testCreatAUnitCavlryUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnit("CavlryUnit", "Cavlry", 20, terrainType);
        assertEquals("CavlryUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnit whit valid parameters.
     * Create CavlryUnit.
     */
    @Test
    public void testCreatAMageyUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnit("MageUnit", "MageUnit", 20, terrainType);
        assertEquals("MageUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnit whit valid parameters.
     * Create CommanderUnit.
     */
    @Test
    public void testCreatAUnitCommanderUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnit("CommanderUnit", "Commander", 20, terrainType);
        assertEquals("CommanderUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnit with invalid parameters.
     * TypeOfUnit doesn't match anny type of units that exist.
     */
    @Test
    public void testCreateAUnitWithTypeOfUnitThatDoesNotExist() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("WrongTypeOfUnit", "Unit", 20, terrainType);
                }
        );
        assertEquals("The type of unit didn't match anny of the cases.", exception.getMessage());
    }

    /**
     * Test createAUnit with invalid parameters.
     * Name is null.
     */
    @Test
    public void testCreateAUnitWithNameIsNull() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("InfantryUnit", null, 20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnit with invalid parameters.
     * Name is is empty.
     */
    @Test
    public void testCreateAUnitWithNameIsEmpty() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("InfantryUnit", "", 20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnit with invalid parameters.
     * Health is 0.
     */
    @Test
    public void testCreateAUnitWithHealthIs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("InfantryUnit", "unit", 0, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnit with invalid parameters.
     * Health is below 0.
     */
    @Test
    public void testCreateAUnitWithHealthIsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("InfantryUnit", "unit", -7, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnit with invalid parameters.
     * TerrainType is null
     */
    @Test
    public void testCreateAUnitWithTerrainTypeIsNull() {
        UnitFactory unitFactory = new UnitFactory();

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnit("InfantryUnit", "unit", 20, null);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createUnits with valid parameters.
     * Test that it creates correct amount of units.
     */
    @Test
    public void testCreateUnitsCreateCorrectAmountOfUnits() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        List<Unit> units = unitFactory.createUnits("InfantryUnit", "Units", 20, terrainType, 5);
        assertEquals(5, units.size());
    }

    /**
     * Test createUnits with invalid parameters.
     * NumberOfUnits is set as 0.
     */
    @Test
    public void testCreateUnitsWithNumberOfUnitsAs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createUnits("InfantryUnit", "units", 20, terrainType, 0);
                }
        );
        assertEquals("Not a valid number", exception.getMessage());
    }

    /**
     * Test createUnits with invalid parameters.
     * NumberOfUnits is set below 0.
     */
    @Test
    public void testCreateUnitsWithNumberOfUnitsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createUnits("InfantryUnit", "units", 20, terrainType, -5);
                }
        );
        assertEquals("Not a valid number", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose whit valid parameters.
     * Create InfatryUnit.
     */
    @Test
    public void testCreateAUnitAllStatsChooseInfatryUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnitAllStatsChoose("InfantryUnit", "Infatry", 20,20,20, terrainType);
        assertEquals("InfantryUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnitAllStatsChoose whit valid parameters.
     * Create RangedUnit.
     */
    @Test
    public void testCreateAUnitAllStatsChooseRangedyUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnitAllStatsChoose("RangedUnit", "Ranged", 20,20,20, terrainType);
        assertEquals("RangedUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnitAllStatsChoose whit valid parameters.
     * Create CavlryUnit.
     */
    @Test
    public void testCreateAUnitAllStatsChooseCavlryUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnitAllStatsChoose("CavlryUnit", "Cavlry", 20,20,20, terrainType);
        assertEquals("CavlryUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnitAllStatsChoose whit valid parameters.
     * Create CavlryUnit.
     */
    @Test
    public void testCreateAUnitAllStatsChooseMageyUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnitAllStatsChoose("MageUnit", "MageUnit", 20,20,20, terrainType);
        assertEquals("MageUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnitAllStatsChoose whit valid parameters.
     * Create CommanderUnit.
     */
    @Test
    public void testCreateAUnitAllStatsChooseCommanderUnit() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = unitFactory.createAUnitAllStatsChoose("CommanderUnit", "Commander", 20,20,20, terrainType);
        assertEquals("CommanderUnit", unit.getClass().getSimpleName());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * TypeOfUnit doesn't match anny type of units that exist.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithTypeOfUnitThatDoesNotExist() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("WrongTypeOfUnit", "Unit", 20,20,20, terrainType);
                }
        );
        assertEquals("The type of unit didn't match anny of the cases.", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Name is null.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithNameIsNull() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", null, 20,20,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Name is empty.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithNameIsEmpty() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "", 20,20,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Health is 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithHealthIs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 0,20,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Health is below 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithHealthIsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", -20,20,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Attack is 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithAttackIs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 20,0,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Attack is below 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithAttackIsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 20,-20,20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Armor is 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithArmorIs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 20,20,0, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * Armor is below 0.
     */
    @Test
    public void testCreateAUnitAllStatsChooseWithArmorIsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 20,20,-20, terrainType);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createAUnitAllStatsChoose with invalid parameters.
     * TerrainType is null
     */
    @Test
    public void testCreateAUnitAllStatsChooseTerrainTypeIsNull() {
        UnitFactory unitFactory = new UnitFactory();

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createAUnitAllStatsChoose("InfantryUnit", "unit", 20,20,20, null);
                }
        );
        assertEquals("Invalid input", exception.getMessage());
    }

    /**
     * Test createUnitsFullStatsChoose with valid parameters.
     * Test that it creates correct amount of units.
     */
    @Test
    public void testCreateUnitsFullStatsChooseCorrectAmountOfUnits() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        List<Unit> units = unitFactory.createUnitsFullStatsChoose("InfantryUnit", "Units", 20,20,20, terrainType, 5);
        assertEquals(5, units.size());
    }

    /**
     * Test createUnitsFullStatsChoose with invalid parameters.
     * NumberOfUnits is set as 0.
     */
    @Test
    public void testCreateUnitsFullStatsChooseWithNumberOfUnitsAs0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createUnitsFullStatsChoose("InfantryUnit", "units", 20,20,20, terrainType, 0);
                }
        );
        assertEquals("Not a valid number", exception.getMessage());
    }

    /**
     * Test createUnitsFullStatsChoose with invalid parameters.
     * NumberOfUnits is set below 0.
     */
    @Test
    public void testCreateUnitsFullStatsChooseWithNumberOfUnitsBelow0() {
        UnitFactory unitFactory = new UnitFactory();
        TerrainType terrainType = TerrainType.TESTTERRAIN;

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    unitFactory.createUnitsFullStatsChoose("InfantryUnit", "units", 20,20,20, terrainType, -5);
                }
        );
        assertEquals("Not a valid number", exception.getMessage());
    }

}
