package no.ntnu.iir;

import no.ntnu.iir.data.TerrainType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Test class that test the class Units.
 * <ul>
 *     <li>Test constructor with valid parameter.</li>
 *     <li>Test constructor with invalid parameter.
 *     <ul>
 *         <li>Name set as null.</li>
 *         <li>Name is empty.</ln>
 *         <li>Health is set as null.</li>
 *         <li>Health is set as 0 or below.</li>
 *         <li>Attack is set as null.</li>
 *         <li>Attack is set as 0 or below.</li>
 *         <li>Arrmor is set as null.</li>
 *         <li>Arrmor is set as 0 or below .</li>
 *         <li>TerrainType is set as null.</li>
 *     </ul></li>
 *     <li>Test attack set correct new health on a unit that is attack</li>
 *     <li>Test if attack unit have more resist than the attacker have attach. The health goes down whit one.</li>
 *     <li>Test attack with invalid parameter. Unit is set as null.</li>
 * </ul>
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class UnitTest {

    /**
     * Test Unit constructor with valid parameter.
     */
    @Test
    public void testConnstructorIsCorrect() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting = new DummyUnitForTesting("DummyUnit", 10, 15, 20, terrainTypet);
        assertEquals("DummyUnit", dummyUnitForTesting.getName());
        assertEquals(10, dummyUnitForTesting.getHealth());
        assertEquals(15, dummyUnitForTesting.getAttack());
        assertEquals(20, dummyUnitForTesting.getArrmor());
        assertEquals("TESTTERRAIN", dummyUnitForTesting.getTerrain().toString());
    }

    /**
     * Test constructor with invalid parameter.
     * Test if the name is set blank ("").
     */
    @Test
    public void testCOnstructorWithNameBlank() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("", 10, 10, 10, terrainTypet);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test constructor with invalid parameter.
     * Test if the name is set as null.
     */
    @Test
    public void testConstructorIfNameIsSetAsNull() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting(null, 10, 10, 10, terrainTypet);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test constructor invalid parameter.
     * Test if health is set as 0.
     */
    @Test
    public void testConstructorWithHealthAs0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 0, 10, 10, terrainTypet);
                }
        );
        assertEquals("Health most be a number above 0.", exception.getMessage());
    }

    /**
     * Test constructor invalid parameter.
     * Test if health is set below 0.
     */
    @Test
    public void testConstructorWithHealthBelow0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", -10, 10, 10, terrainTypet);
                }
        );
        assertEquals("Health most be a number above 0.", exception.getMessage());
    }


    /**
     * Test constructor with invalid parameter.
     * Test if attack is set as 0.
     */
    @Test
    public void testConstructorWithAttackAs0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 10, 0, 10, terrainTypet);
                }
        );
        assertEquals("Attack most be a number above 0.", exception.getMessage());
    }

    /**
     * Test constructor invalid parameter.
     * Test if Attack is set below 0.
     */
    @Test
    public void testConstructorWithAttackBelow0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 10, -10, 10, terrainTypet);
                }
        );
        assertEquals("Attack most be a number above 0.", exception.getMessage());
    }

    /**
     * Test constructor invalid parameter.
     * Test if arrmor is set as 0.
     */
    @Test
    public void testConstructorWithArrmorAs0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 10, 10, 0, terrainTypet);
                }
        );
        assertEquals("Arrmor most be a number above 0.", exception.getMessage());
    }

    /**
     * Test constructor invalid parameter.
     * Test if arrmor is below 0.
     */
    @Test
    public void testConstructorWithArrmorBelow0() {
        TerrainType terrainTypet = TerrainType.TESTTERRAIN;
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 10, 10, -10, terrainTypet);
                }
        );
        assertEquals("Arrmor most be a number above 0.", exception.getMessage());
    }

    /**
     * Test constructor with invalid parameter.
     * TerrainType is set as null.
     */
    @Test
    public void testConstructorWithTerrainTypeAsNull() {
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    DummyUnitForTesting unitForTesting = new DummyUnitForTesting("Unit", 10, 10, -10, null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test attack method set correct new helth to a unit.
     * New hp is 19.
     * 20(hp) - (5(attack)+2(attackBonus)) + (5(arrmor)+1(resistBonus) = 19.
     */
    @Test
    public void testIfAttackSettsCorrectNewHeltToAUnit() {
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("Nils", 20, 5,5, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("Arne", 20, 5,5, terrainType);
        dummyUnitForTesting1.attack(dummyUnitForTesting2);
        assertEquals(19,dummyUnitForTesting2.getHealth());
    }

    /**
     * Test attack method does NOT set new health if the new health is higher than the old health.
     * Old health is 20 and the new health is 19.
     * 20(hp) - (5(attack)+2(attackBonus)) + (7(arrmor) + 1(resistBonus)) = 21.
     * But sins the health is more then the last one the old health goes down with one. 20 - 1 = 19
     */
    @Test
    public void testIfAttackDoesNotSetNewHealthIfTheNewOneIsHigherThanTheOldHealth() {
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting1 = new DummyUnitForTesting("Nils", 20, 5, 7, terrainType);
        DummyUnitForTesting dummyUnitForTesting2 = new DummyUnitForTesting("Arne", 20, 5, 7, terrainType);
        dummyUnitForTesting1.attack(dummyUnitForTesting2);
        assertEquals(19,dummyUnitForTesting2.getHealth());
    }

    /**
     * Test if setHealt set correct new health.
     */
    @Test
    public void testSetHealthSetsCorrectNewHealth() {
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        DummyUnitForTesting dummyUnitForTesting = new DummyUnitForTesting("DummyUnit", 10, 10, 10, terrainType);
        dummyUnitForTesting.setHealth(15);
        assertEquals(15,dummyUnitForTesting.getHealth());
    }
}
