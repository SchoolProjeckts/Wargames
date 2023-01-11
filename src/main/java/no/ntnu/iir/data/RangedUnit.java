package no.ntnu.iir.data;

/**
 * Represent a Ranged Unit.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class RangedUnit extends Unit {

    private int numberOfAttacks = 0;
    private int resistBonus = 4;

    /**
     * Create a RangeUnit where you can set all stats yourself.
     *
     * @param name   name of the type of unit.
     * @param health the health of a unit.
     * @param attack the attack of a unit.
     * @param arrmor the arrmor of a unit.
     * @param terrainType the terrain of a unit.
     */
    public RangedUnit(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    /**
     * Create a RangeUnit where you can set health and name.
     *
     * @param name name of the unit.
     * @param health of the unit.
     * @param terrainType the terrain of a unit.
     */
    public RangedUnit(String name, int health, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, 15, 8, terrainType);
    }

    @Override
    public int getAttackBonus() {
        int attackBonus = 3;
        if(getTerrain() == TerrainType.HILLS) {
            attackBonus ++;
        }
        else if(getTerrain() == TerrainType.FOREST) {
            attackBonus --;
        }
        return attackBonus;
    }

   @Override
    public int getResistBonus() {
        if (numberOfAttacks < 3) {
            resistBonus --;
            numberOfAttacks ++;
        } else {
            resistBonus = 1;
        }
        return resistBonus;
    }
}
