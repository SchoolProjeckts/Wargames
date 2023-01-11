package no.ntnu.iir;

import no.ntnu.iir.data.MageUnit;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class that test the class RangeUnits.
 * <ul>
 *     <li>
 *         Test get AttackBonus return correct AttackBonus.
 *     </li>
 *     <li>
 *         Test get ResistBonus return correct ResistBonus.
 *     </li>
 * </ul>
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class MageUnitTest {
    /**
     * Test getAttackBonus with Forest terrain.
     */
    @Test
    public void testGetAttacBonus() {
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = new MageUnit("MageUnit", 20, terrainType);
        assertEquals(2, unit.getAttackBonus());
    }

    /**
     * Test getResistBonus with Forest terrain.
     */
    @Test
    public void testGetResistBonus() {
        TerrainType terrainType = TerrainType.TESTTERRAIN;
        Unit unit = new MageUnit("MageUnit", 20, terrainType);
        assertEquals(2, unit.getResistBonus());
    }
}
