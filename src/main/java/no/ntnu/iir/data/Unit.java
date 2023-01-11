package no.ntnu.iir.data;

/**
 * Represent a unit and it stats
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public abstract class Unit {

    private final String name;
    private int health;
    private final int attack;
    private final int arrmor;
    private TerrainType terrainType;

    /**
     * Make and sett stats of a unit.
     * @param name name of the type of unit.
     * @param health the health of a unit.
     * @param attack the attack of a unit.
     * @param arrmor the arrmor of a unit.
     * @param terrainType the terrain of a unit.
     */
    protected Unit(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {

        if(name == null || name.isBlank() || terrainType == null) {
            throw new IllegalArgumentException("Invalid Input.");
        }
        else {
            this.name = name;
            this.terrainType = terrainType;
        }
        this.health = chekcNumber(health, "Health");
        this.attack = chekcNumber(attack, "Attack");
        this.arrmor = chekcNumber(arrmor, "Arrmor");
    }

    /**
     * Checks a number if its above 0 or if its 0 or lower.
     * If it's above 0 the number is return.
     * If it's 0 or lower a IllegalArguIllegalArgumentException is thrown.
     * @param numberThatWantsToCheck a number you want to check
     * @param prefiks the veribalname of the number you want to check, as a String.
     * @return the number that is check if its above 0.
     */
    public int chekcNumber(int numberThatWantsToCheck, String prefiks) {
        if (numberThatWantsToCheck <= 0) {
            throw new IllegalArgumentException(prefiks + " most be a number above 0.");
        }
        return numberThatWantsToCheck;
    }

    /**
     * Sets a new helth of a unit baste on a attack.
     * If the attack is lower then the resistent and arrmor of the unit, the health is sett as the same as before.
     * @param opponent the unit that gets a new health.
     */
    public void attack(Unit opponent) {
        if(opponent == null) {
            throw new IllegalArgumentException("Invalid Input");
        }
        int newHealth = opponent.getHealth() - (getAttack() + getAttackBonus()) + (opponent.getArrmor() + opponent.getResistBonus());
        if(newHealth > opponent.getHealth()) {
            opponent.setHealth(opponent.getHealth() - 1);
        }
        else {
            opponent.setHealth(newHealth);
        }
    }

    /**
     * Returns the name of the type of unit.
     * @return the name of the type of unit.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the health of a unit.
     * @return the health of a unit.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns the attack of a unit.
     * @return the attack of a unit.
     */
    public int getAttack() {
        return  this.attack;
    }

    /**
     * Returns the amount of arrmor of a unit.
     * @return the amount of arrmor of a unit.
     */
    public int getArrmor() {
        return this.arrmor;
    }

    /**
     * Returns the terrain type.
     * @return the terrain type.
     */
    public TerrainType getTerrain() {
        return this.terrainType;
    }

    /**
     * Sets new terrain type.
     * @param terrainType new terrain type.
     */
    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }

    /**
     * Set a new health for a unit.
     * @param newHealth the new health for a unit.
     */
    public void setHealth(int newHealth) {
            this.health = newHealth;
    }

    /**
     * return attackBounus stats.
     * @return attackBonus stats.
     */
    public abstract int getAttackBonus();

    /**
     * Returns arrmorBonus stats.
     * @return arrmorBonus stats.
     */
    public abstract int getResistBonus();

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                ", arrmor=" + arrmor +
                ", terrain=" + terrainType +
                '}';
    }
}
