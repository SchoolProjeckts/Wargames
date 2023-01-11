package no.ntnu.iir.logic;

import no.ntnu.iir.data.Army;
import no.ntnu.iir.data.Unit;
import java.util.Random;

/**
 * Represent a battle.
 * All logic around the battle made here.
 *
 * @author Ole Kristian Dvergsdal
 * @version 1.0
 */
public class Battle {

    private Army armyOne;
    private Army armyTwo;
    private Random random = new Random();

    /**
     * Creates an object that can simulate battles.
     * It's holds on two armies that are used for the simulation.
     * @param armyOne First army you want to add.
     * @param armyTwo Second army you want to add.
     */
    public Battle(Army armyOne, Army armyTwo) {
        if(armyOne == null || armyTwo == null) {
            throw new IllegalArgumentException("Invalid Input.");
        }
        else {
            this.armyOne = armyOne;
            this.armyTwo = armyTwo;
        }
    }

    /**
     * A simulation that simulate of a battle between two armies, and returns a winner. The winner is a random outcome.
     * @return army winner.
     */
    public Army simulateBattle() {

        Army winner = null;
        int rounds = random.nextInt(2) + 1;

        while(armyOne.hasUnits() && armyTwo.hasUnits()) {

            Unit attackingUnit = rounds % 2 == 0 ? armyOne.getRandom(): armyTwo.getRandom();
            Unit deffendingUnit = rounds % 2 == 1 ? armyOne.getRandom(): armyTwo.getRandom();

            attackingUnit.attack(deffendingUnit);

            if(deffendingUnit.getHealth() <= 0) {
                if(rounds % 2 == 0) {
                    armyTwo.removeUnit(deffendingUnit);
                }
                else if (rounds % 2 == 1){
                    armyOne.removeUnit(deffendingUnit);
                }
            }
            rounds ++;
        }

        if(!armyOne.hasUnits()) {
            winner = armyTwo;
        }

        if(!armyTwo.hasUnits()) {
            winner = armyOne;
        }

        return winner;
    }

    @Override
    public String toString() {
        return "Battle{" +
                "armyOne=" + armyOne +
                ", armyTwo=" + armyTwo +
                ", random=" + random +
                '}';
    }
}
