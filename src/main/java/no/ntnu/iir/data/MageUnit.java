package no.ntnu.iir.data;

/**
 * Represent a mage unit.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class MageUnit extends Unit{


    /**
     * Make and sett stats of a unit.
     *
     * @param name    name of the type of unit.
     * @param health  the health of a unit.
     * @param attack  the attack of a unit.
     * @param arrmor  the arrmor of a unit.
     * @param terrainType the terrain of a unit.
     */
    public MageUnit(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    /**
     * Make and sett stats of a unit.
     *
     * @param name    name of the type of unit.
     * @param health  the health of a unit.
     * @param terrainType the terrain of a unit.
     */
    public MageUnit(String name, int health, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, 20, 1, terrainType);
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }

    @Override
    public int getResistBonus() {
        return 2;
    }
}
