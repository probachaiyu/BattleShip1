package logic;

/**
 * Created by Yulia on 06.11.2016.
 */

public class TrigerShipCheck extends TrigerShip {

	public TrigerShipCheck(Ship ship) {
		super(ship);
	}

	@Override
	public boolean Ship(int m, int n) {
		ElementStates state = field.GetElement(m, n);
		return (state == ElementStates.Water);
	}

	@Override
	public boolean Border(int m, int n) {
		ElementStates state = field.GetElement(m, n);
		return (state == ElementStates.Border) ||
				(state == ElementStates.Water) ||
					(state == ElementStates.Empty);
	}
}
