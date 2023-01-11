package no.ntnu.iir.data;

/**
 * Represent a Cavlry Unit.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class CavlryUnit extends Unit{

    private int numberOfAttacks = 0;

    /**
     * Create a CavlryUnit where you can set all stats yourself.
     *
     * @param name   name of the type of unit.
     * @param health the health of a unit.
     * @param attack the attack of a unit.
     * @param arrmor the arrmor of a unit.
     * @param terrainType the terrain of a unit.
     */
    public CavlryUnit(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    /**
     * Create a CalvryUnit where you can set health and name.
     *
     * @param name of the unit
     * @param health of the unit
     * @param terrainType the terrain of a unit.
     */
    public CavlryUnit(String name, int health, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, 20, 12, terrainType);
    }

    @Override
    public int getAttackBonus() {
        int attackBonus = 2;
        if(numberOfAttacks < 1) {
            numberOfAttacks = numberOfAttacks + 1;
            attackBonus = 6;
        }
        if(getTerrain() == TerrainType.PLAINS) {
            attackBonus ++;
        }
         return attackBonus;
    }

    @Override
    public int getResistBonus() {
        int resistBonus = 1;
        if(getTerrain() == TerrainType.FOREST)
            resistBonus = 0;
        return resistBonus;
    }
}
