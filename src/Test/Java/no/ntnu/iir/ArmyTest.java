package no.ntnu.iir;

import no.ntnu.iir.data.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
/**
 * Test class that test the class Army.
 *<ul>
 *     <li>Test constructor with valid parameters.</li>
 *     <li>Test constructor with invalid parameters.
 *     <ul>
 *         <li>Name is set as null.</li>
 *         <li>Name is empty.</li>
 *         <li>The list is set as null.</li>
 *     </ul> </lis>
 *     <li>Test setName with valid parameters.</li>
 *     <li>Test setName with valid invalid parameters.
 *     <ul>
 *         <li>Name is set as null.</li>
 *         <li>Name is empty.</li>
 *     </ul></li>
 *     <li>Test addUnit with valid parameter.</li>
 *     <li>Test addUnit with valid in parameter. Unit is set as null.</li>
 *     <li>Test addAllUnits with valid parameter.</li>
 *     <li>Test addAllUnits with valid invalid parameter. List of units is set as null.</li>
 *     <li>Test removeUnit with valid parameter.</li>
 *     <li>Test removeUnit with valid invalid parameter. unit is set as null</li>
 *     <li>Test hasUnits returns correct boolean statement if the army has units or not.</li>
 *     <li>Test getInfantryUnits returns InfantryUnits.</li>
 *     <li>Test getCavlaryUnits returns CavlaryUnits.</li>
 *     <li>Test getRangeUnits returns RangeUnits.</li>
 *     <li>Test getMageUnit returns MageUnit.</li>
 *     <li>Test getCommanderUnits returns CommanderUnits.</li>
 *</ul>
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class ArmyTest {

    /**
     * Test constructor (Army(String name)) with valid parameter.
     */
    @Test
    public void testConstructorOneIsCorrect() {
        Army army = new Army("army");
        assertEquals("army", army.getName());
    }

    /**
     * Test constructor (Army(String name, ArrayList<Units> units)) with valid parameters.
     */
    @Test
    public void testConstructorTwoIsCorrect() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        assertEquals("army", army.getName());
    }

    /**
     * Test constructor (Army(String name)) with invalid parameter.
     * Name is set as null.
     */
    @Test
    public void testConstructorOneWithNameAsNull() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Army army = new Army(null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test constructor (Army(String name)) with invalid parameter.
     * Name is empty.
     */
    @Test
    public void testConstructorOneWithNameIsBlank() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Army army = new Army("");
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test if constructor with invalid parameter.
     * Test if name is set ass null.
     */
    @Test
    public void testConstructorTwoWithNameAsNull() {
        List<Unit> units = new ArrayList<>();
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Army army = new Army(null, units);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test if construct can handel wrong input.
     * Test if name is blank.
     */
    @Test
    public void testConstructorTwoWithNameAsBlank() {
        List<Unit> units = new ArrayList<>();
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Army army = new Army("", units);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test if constructor can handel wrong input.
     * If List is set ass null
     */
    @Test
    public void testIfConstructorTwoWithListIsBlank() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Army army = new Army("army", null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test setName with valid parameter.
     */
    @Test
    public void testSetNameWithValidParameter() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");
        assertEquals("armyTwo", army.getName());
    }

    /**
     * Test setName with invalid parameter.
     * Name is set as null.
     */
    @Test
    public void testSetNameWithNameSetAsNull() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    army.setName(null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test setName with invalid parameter.
     * Name is empty.
     */
    @Test
    public void testSetNameWhenNameIsEmpty() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    army.setName("");
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test addUnit with valid parameter.
     */
    @Test
    public void testIfAddUnitAddsUnitCorrectly() {
        List<Unit> units = new ArrayList<>();
        Army army1 = new Army("armyOne", units);
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting = new DummyUnitForTesting("SwordMan", 20, 20, 20, terrainType);
        army1.addUnit(dummyUnitForTesting);
        assertEquals(1, units.size());
        assertEquals(dummyUnitForTesting, units.get(0));
    }

    /**
     * Test addUnit with invalid parameter.
     * Unit input is set as null.
     */
    @Test
    public void testIfAddUnitWithWrongInput() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    army.addUnit(null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test addAllUnits with valid parameter.
     */
    @Test
    public void testAddAllUnitsIsAddedCorrectly() {
        List<Unit> units2 = new ArrayList<>();
        Army army2 = new Army("armyTwo", units2);
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20,terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20,terrainType);
        ArrayList<Unit> units3 = new ArrayList<>();
        units3.add(dummyUnitForTesting1);
        units3.add(dummyUnitForTesting2);
        army2.addAllUnits(units3);
        assertEquals(2, units2.size());
        assertEquals(dummyUnitForTesting1, units2.get(0));
        assertEquals(dummyUnitForTesting2, units2.get(1));
    }

    /**
     * Test if addAllUnits with invalid input.
     * Unit input is set as null.
     */
    @Test
    public void testIfAddUnitsWithWrongInput() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    army.addAllUnits(null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test if removeUnit with valid parameter.
     */
    @Test
    public void testRemoveUnitRemovesCorrectUnit () {
        List<Unit> units2 = new ArrayList<>();
        Army army2 = new Army("armyTwo", units2);
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        units2.add(dummyUnitForTesting1);
        units2.add(dummyUnitForTesting2);
        army2.removeUnit(dummyUnitForTesting1);
        assertEquals(1, units2.size());
        assertEquals(dummyUnitForTesting2, units2.get(0));
    }

    /**
     * Test if removeUnit with invalid parameter.
     * Unit set as null.
     */
    @Test
    public void testIfRemoveUnitWithWrongInput() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        army.setName("armyTwo");

        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    army.removeUnit(null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test hasUnit test true if army have unit and false if army don't have unit
     */
    @Test
    public void testHasUnitReturnCorrectBooleanStatement() {
        List<Unit> units = new ArrayList<>();
        Army army = new Army("army", units);
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting);
        assertTrue(army.hasUnits());
        army.removeUnit(dummyUnitForTesting);
        assertFalse(army.hasUnits());
    }

    /**
     * Test getAllUnits returns a list of units correctly.
     */
    @Test
    public void testAllUnitsReturnsCorretliy() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        Army army = new Army("army", units);
        assertEquals(units, army.getAllUnits());
    }

    /**
     * Test getInfantryUnits returns InfatryUnits
     */
    @Test
    public void testGetInfantryUnitsReturnsInfatryUnits() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        Unit unit1 = new InfantryUnit("Infantry", 20, 20, 20, terrainType);
        Unit unit2 = new InfantryUnit("Infantry", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("army", units);

        assertEquals(2,army.getInfantryUnits().size());
        army.getInfantryUnits().forEach(unit -> assertEquals("InfantryUnit", unit.getClass().getSimpleName()));
    }

    /**
     * Test getCavlaryUnits returns CavlaryUnits.
     */
    @Test
    public void testGetCavlaryUnitsReturnsCavlaryUnits() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        Unit unit1 = new CavlryUnit("CavlryUnit", 20, 20, 20, terrainType);
        Unit unit2 = new CavlryUnit("CavlryUnit", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("army", units);

        assertEquals(2, army.getCavlaryUnits().size());
        army.getCavlaryUnits().forEach(unit -> assertEquals("CavlryUnit", unit.getClass().getSimpleName()));
    }

    /**
     * Test getRangeUnits returns RangeUnits.
     */
    @Test
    public void testGetRangeUnitsReturnesRangeUnits() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        Unit unit1 = new RangedUnit("RangedUnit", 20, 20, 20, terrainType);
        Unit unit2 = new RangedUnit("RangedUnit", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("army", units);

        assertEquals(2,army.getRangeUnits().size());
        army.getRangeUnits().forEach(unit -> assertEquals("RangedUnit", unit.getClass().getSimpleName()));
    }

    /**
     * Test getRangeUnits returns RangeUnits.
     */
    @Test
    public void testGetMageUnitsReturnesRangeUnits() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        Unit unit1 = new MageUnit("MageUnit", 20, 20, 20, terrainType);
        Unit unit2 = new MageUnit("MageUnit", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("army", units);

        assertEquals(2,army.getMageUnits().size());
        army.getMageUnits().forEach(unit -> assertEquals("MageUnit", unit.getClass().getSimpleName()));
    }

    /**
     * Test getCommanderUnits returns CommanderUnits
     */
    @Test
    public void testGetCommanderUnitsReturndsCommanderUnits() {
        List<Unit> units = new ArrayList<>();
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("SwordMan1", 20, 20, 20, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("SwordMan2", 20, 20, 20, terrainType);
        Unit unit1 = new CommanderUnit("CommanderUnit", 20, 20, 20, terrainType);
        Unit unit2 = new CommanderUnit("CommanderUnit", 20, 20, 20, terrainType);
        units.add(dummyUnitForTesting1);
        units.add(dummyUnitForTesting2);
        units.add(unit1);
        units.add(unit2);
        Army army = new Army("army", units);

        assertEquals(2,army.getCommanderUnits().size());
        army.getCommanderUnits().forEach(unit -> assertEquals("CommanderUnit", unit.getClass().getSimpleName()));
    }
}
