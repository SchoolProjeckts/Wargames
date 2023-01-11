package no.ntnu.iir;

import no.ntnu.iir.data.InfantryUnit;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class that test the class InfantryUnit.
 * <ul>
 *     <li>Test that getAttackBonus returns correct attackBonus with different TerrainTypes.
 *     <ul>
 *         <li>Test with Forest</li>
 *         <li>Test with Plains</li>
 *         <li>Test with Hills</li>
 *     </ul></li>
 *     <li>Test that getReistBonus return correct resistBonus with different TerrainTypes.
 *     <ul>
 *         <li>Test with Forest</li>
 *         <li>Test with Plains</li>
 *         <li>Test with Hills</li>
 *     </ul></li>
 * </ul>
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class InfantryUnitTest {

    /**
     * Test getAttackBonus with Forest terrain.
     */
    @Test
    public void testGetAttacBonusWithForestTerrain() {
        TerrainType terrainType = TerrainType.FOREST;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(3, unit.getAttackBonus());
    }

    /**
     * Test getAttackBonus with Hills terrain.
     */
    @Test
    public void testGetAttacBonusWithHillsTerrain() {
        TerrainType terrainType = TerrainType.HILLS;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(2, unit.getAttackBonus());
    }

    /**
     * Test getAttackBonus with Plains terrain.
     */
    @Test
    public void testGetAttacBonusWithPlainsTerrain() {
        TerrainType terrainType = TerrainType.PLAINS;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(2, unit.getAttackBonus());
    }

    /**
     * Test getResistBonus with Forest terrain.
     */
    @Test
    public void testGetResistBonusWithForestTerrain() {
        TerrainType terrainType = TerrainType.FOREST;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(2, unit.getResistBonus());
    }

    /**
     * Test getResistBonus with Hills terrain.
     */
    @Test
    public void testGetResistBonusWithHilsTerrain() {
        TerrainType terrainType = TerrainType.HILLS;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(1, unit.getResistBonus());
    }

    /**
     * Test getResistBonus with Plains terrain.
     */
    @Test
    public void testGetResistBonusWithPlainsTerrain() {
        TerrainType terrainType = TerrainType.PLAINS;
        Unit unit = new InfantryUnit("InfantryUnit", 20, terrainType);
        assertEquals(1, unit.getResistBonus());
    }
}
