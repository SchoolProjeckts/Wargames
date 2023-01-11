package no.ntnu.iir;
import no.ntnu.iir.data.TerrainType;
import no.ntnu.iir.data.Unit;

/**
 * A Dummy class that inherit for the class unit.
 * The class is ust for testing the different classes that needs a units for testing.
 *
 * @author Ole KRistian Dvrgsdal
 * @version 1.0
 */
public class DummyUnitForTesting extends Unit {

    public DummyUnitForTesting(String name, int health, int attack, int arrmor, TerrainType terrainType) throws IllegalArgumentException {
        super(name, health, attack, arrmor, terrainType);
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }

    @Override
    public int getResistBonus() {
        return 1;
    }
}
