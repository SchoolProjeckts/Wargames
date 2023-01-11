package no.ntnu.iir;

import no.ntnu.iir.data.Army;
import no.ntnu.iir.logic.Battle;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 * Test class that test the class Battle.
 * <ul>
 *     <li>Test constructor with valid parameters.</li>
 *     <li>Test constructor with invalid parameters.
 *     <ul>
 *         <li>armyOne set as null.</li>
 *         <li>armyTwo set as null.</li>
 *     </ul></li>
 * </ul>
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class BattleTest {

    /**
     * Test Constructor with valid parameter.
     */
    @Test
    public void testConstructorWithValidParameter() {
        Army army1 = new Army("ArmyOne");
        Army army2 = new Army("ArmyTwo");
        Battle battle = new Battle(army1, army2);
    }

    /**
     * Test if constructor with invalid parameter.
     * ArmyOne set as null.
     */
    @Test
    public void testConstructorWithWrongArmyOneInput() {
        Army army1 = new Army("ArmyOne");
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Battle battle = new Battle(null,army1);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }

    /**
     * Test of constructor with invalid parameter.
     * ArmyTwo set as null.
     */
    @Test
    public void testConstructorWithWrongArmyTwoInput() {
        Army army2 = new Army("ArmyTwo");
        Throwable exception = assertThrows(
                IllegalArgumentException.class, () -> {
                    Battle battle = new Battle(army2,null);
                }
        );
        assertEquals("Invalid Input.", exception.getMessage());
    }
}
