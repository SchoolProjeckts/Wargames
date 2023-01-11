package no.ntnu.iir.data;

/**
 * Represent a Commander Unit.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class CommanderUnit  extends CavlryUnit {

    /**
     * Creates a Commander Unit where you can sett all stats
     * @param name of the unit
     * @param health of the unit
     * @param attack of the unit
     * @param arrmor of the unit
     * @param terrainType the terrain of a unit.
     */
    public CommanderUnit(String name, int health, int attack, int arrmor ,TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    /**
     * Creates a Commander Unit where you can set name and health.
     * Attack and arrmor is already set.
     * @param name of the unit
     * @param health of the unit
     * @param terrainType the terrain of a unit.
     */
    public CommanderUnit(String name, int health, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, 25, 15, terrainType);
    }
}
