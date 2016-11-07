package logic;

/**
 * Created by Yulia on 06.11.2016.
 */

public class TrigerShipSet extends TrigerShip {
	
	private Ship ship;
	
	public TrigerShipSet(Ship ship) {
		super(ship);
		this.ship = ship;
	}
	
	@Override
	public boolean Ship(int m, int n) {
		field.SetElement(m, n, ElementStates.Well);
		ship.elements.add(field.elements[m][n]);
		field.elements[m][n].ship = ship;
		return true;
	}
	
	@Override
	public boolean Border(int m, int n) {
		field.SetElement(m, n, ElementStates.Border);
		return true;
	}
}
