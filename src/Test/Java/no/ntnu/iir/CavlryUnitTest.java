package no.ntnu.iir;

import no.ntnu.iir.data.CavlryUnit;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Test class that test the class CavlryUnit.
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
public class CavlryUnitTest {

    /**
     * Test getAttackBonus with Forest terrain.
     */
    @Test
    public void testGetAttacBonusWithForestTerrain() {
        TerrainType terrainType = TerrainType.FOREST;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        Unit unit2 = new CavlryUnit("CavlryUnit2", 20, terrainType);
        assertEquals(6, unit.getAttackBonus());
        unit.attack(unit2);
        assertEquals(2, unit.getAttackBonus());
    }

    /**
     * Test getAttackBonus with Hills terrain.
     */
    @Test
    public void testGetAttacBonusWithHillsTerrain() {
        TerrainType terrainType = TerrainType.HILLS;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        Unit unit2 = new CavlryUnit("CavlryUnit2", 20, terrainType);
        assertEquals(6, unit.getAttackBonus());
        unit.attack(unit2);
        assertEquals(2, unit.getAttackBonus());
    }

    /**
     * Test getAttackBonus with Plains terrain.
     */
    @Test
    public void testGetAttacBonusWithPlainsTerrain() {
        TerrainType terrainType = TerrainType.PLAINS;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        Unit unit2 = new CavlryUnit("CavlryUnit2", 20, terrainType);
        assertEquals(7, unit.getAttackBonus());
        unit.attack(unit2);
        assertEquals(3, unit.getAttackBonus());
    }

    /**
     * Test getResistBonus with Forest terrain.
     */
    @Test
    public void testGetResistBonusWithForestTerrain() {
        TerrainType terrainType = TerrainType.FOREST;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        assertEquals(0, unit.getResistBonus());
    }

    /**
     * Test getResistBonus with Hills terrain.
     */
    @Test
    public void testGetResistBonusWithHilsTerrain() {
        TerrainType terrainType = TerrainType.HILLS;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        assertEquals(1, unit.getResistBonus());
    }

    /**
     * Test getResistBonus with Plains terrain.
     */
    @Test
    public void testGetResistBonusWithPlainsTerrain() {
        TerrainType terrainType = TerrainType.PLAINS;
        Unit unit = new CavlryUnit("CavlryUnit", 20, terrainType);
        assertEquals(1, unit.getResistBonus());
    }
}
