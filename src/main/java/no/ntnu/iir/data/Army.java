package no.ntnu.iir.data;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represent an army with a set of units.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class Army {

    private String name;
    private List<Unit> units;
    private final Random randomGenerator = new Random();
    private static final String ILLEGALARGUMENTEXCEPTION = "Invalid Input.";

    /**
     * Creats an list that can hold units.
     * @param name of the army.
     */
    public Army(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
        else {
            this.name = name;
        }
        units = new ArrayList<>();
    }

    /**
     * Creates an army.
     * It has a list that holds on units.
     * @param name of the army.
     * @param units type of unit.
     */
    public Army(String name, List<Unit> units){
        if(name == null || name.isBlank() || units == null) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
        else {
            this.name = name;
            this.units = units;
        }
    }

    /**
     * Returns name of the army.
     * @return name of the army.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set new name to the army
     * @param newName the new name you want giv the army
     */
    public void setName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
        else {
            this.name = newName;
        }
    }

    /**
     * Adds a unit to the list.
     * @param unit type of unit that you want to add.
     */
    public void addUnit(Unit unit) {
        if(unit != null) {
            this.units.add(unit);
        }
        else {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
    }

    /**
     * Adds all units to a list.
     * @param units type of units you want to add.
     */
    public void addAllUnits(List<Unit> units) {
        if(units != null) {
            this.units.addAll(units);
        }
        else {
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
    }

    /**
     * Removes a unit from the list.
     * @param unit type of unit you want to move.
     */
    public void removeUnit(Unit unit) {
        if(unit != null) {
            this.units.remove(unit);
        }
        else{
            throw new IllegalArgumentException(ILLEGALARGUMENTEXCEPTION);
        }
    }

    /**
     * Return True or False. True if the list have a unit. False if the list don't have a unit.
     * @return True or False, doseListHaveUnits.
     */
    public boolean hasUnits() {
        boolean doseListHaveUnits;
        doseListHaveUnits = !units.isEmpty();
        return doseListHaveUnits;
    }

    /**
     * Returns a list of units
     * @return all units.
     */
    public List<Unit> getAllUnits() {
        return units;
    }

    /**
     * Returns a random unit.
     * @return a random unit.
     */
    public Unit getRandom() {
        int index = randomGenerator.nextInt(units.size());
        return units.get(index);
    }

    /**
     * Returns all infantry units in a army.
     * @return infantry units.
     */
    public List<Unit> getInfantryUnits() {
        return this.units.stream()
                .filter(unit -> unit.getClass() == InfantryUnit.class)
                .collect(Collectors.toList());
    }

    /**
     * Returns all cavlary units in an army.
     * @return cavalry units.
     */
    public List<Unit> getCavlaryUnits() {
        return this.units.stream()
                .filter(unit -> unit.getClass() == CavlryUnit.class)
                .collect(Collectors.toList());
    }

    /**
     * Returns all ranged units in an army.
     * @return ranged units.
     */
    public List<Unit> getRangeUnits() {
        return this.units.stream()
                .filter(unit -> unit.getClass() == RangedUnit.class)
                .collect(Collectors.toList());
    }

    /**
     * Returns all MageUnits in an army.
     * @return MageUnit.
     */
    public List<Unit> getMageUnits() {
        return this.units.stream()
                .filter(unit -> unit.getClass() == MageUnit.class)
                .collect(Collectors.toList());
    }

    /**
     * Returns all commander units for an army.
     * @return commander units.
     */
    public List<Unit> getCommanderUnits() {
        return this.units.stream()
                .filter(unit -> unit.getClass() == CommanderUnit.class)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Army{" +
                "name='" + name + '\'' +
                ", units=" + units +
                ", randomGenerator=" + randomGenerator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army army = (Army) o;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units) && Objects.equals(randomGenerator, army.randomGenerator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, units, randomGenerator);
    }
}
