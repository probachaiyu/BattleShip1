package logic;

/**
 * Created by Yulia on 06.11.2016.
 */

public abstract class TrigerShip {
	public FieldShip field;
	
	public TrigerShip(Ship ship) {
		this.field = ship.field;
	}
	
	abstract public boolean Ship(int m, int n);
	abstract public boolean Border(int m, int n);
}


