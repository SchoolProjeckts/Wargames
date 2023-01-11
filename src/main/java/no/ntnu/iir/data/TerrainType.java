package no.ntnu.iir.data;

/**
 * Enum class that represent the different terrain types.
 * @author Ole Kristian Dvergsdal.
 * @version 1.0
 */
public enum TerrainType {
    /**
     * Represent hills terrain that giv different bonuses to different units.
     */
    HILLS,
    /**
     * Represent forest terrain that giv different bonuses to different units.
     */
    FOREST,
    /**
     * Represent plains terrain that giv different bonuses to different units.
     */
    PLAINS,
    /**
     * Represent a terrain for testing
     */
    TESTTERRAIN,
    /**
     * A default terreain type units have before they get a terrain that is before a battle.
     */
    DEFAULTTERAIN
}
