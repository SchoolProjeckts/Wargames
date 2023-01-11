package no.ntnu.iir.data;

/**
 * Represent an Infantry Unit.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class InfantryUnit extends Unit {

    /**
     * Create a InfantryUnit where you can set all set yourself.
     * @param name   name of the type of unit.
     * @param health the health of a unit.
     * @param attack the attack of a unit.
     * @param arrmor the arrmor of a unit.
     * @param terrainType the terrain of a unit.
     */
    public InfantryUnit(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    /**
     * Creates a InfantryUnit where you can set health and name.
     * @param name name of the type of unit.
     * @param health the health of a unit.
     * @param terrainType the terrain of a unit.
     */
    public InfantryUnit(String name, int health, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, 15, 10, terrainType);
    }

    @Override
    public int getAttackBonus() {
        int attackBonus = 2;
        if(getTerrain() == TerrainType.FOREST) {
            attackBonus ++;
        }
        return attackBonus;
    }

    @Override
    public int getResistBonus() {
        int resistBonus = 1;
        if(getTerrain() == TerrainType.FOREST) {
            resistBonus ++;
        }
        return resistBonus;
    }
}
