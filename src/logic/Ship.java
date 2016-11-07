package logic;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.util.ArrayList;
import java.util.Random;


public class Ship {
	public int x, y;
	private int dx, dy;
	public int size;
	public int health;
	public ShipStates state;
	public FieldShip field;
	public ArrayList<Element> elements;
	
	 //�������� �������


	public Ship(FieldShip field, int size) {
		this.size = size;
		this.health = size;
		this.field = field;
		this.state = ShipStates.Well;
		
		do {
			this.GetPlace();
		} while (!this.CheckPlace());

		this.elements = new ArrayList<Element>();
		this.SetShip();
	}

	 // ��������� ��������� ������� � ��� �����������

	private void GetPlace() {
		Random rand = new Random();
		this.x = rand.nextInt(10);
		this.y = rand.nextInt(10);
		this.dx = 0;
		this.dy = 0;
		if (rand.nextInt(2) == 1) {
			this.dx = 1;
		} else {
			this.dy = 1;
		}
	}
	
	//������� ������ ������� � ��� ���������

	private boolean ByPass(TrigerShip tp) {
		int i, m, n;
		
		// �������
		for(i = 0; i < size; i++) {
			m = y+i*dy;
			n = x+i*dx;
			if (tp.Ship(m,n) == false) {
				return false;
			}
		}
		// �������� ������ � ����� �������
		for(i=0; i < size; i++) {
			m = y+i*dy-dx;
			n = x+i*dx-dy;
			if (tp.Border(m, n) == false) {
				return false;
			}
			m = y+i*dy+dx;
			n = x+i*dx+dy;
			if (tp.Border(m, n) == false) {
				return false;
			}
		}
		// �������� ����� � ������ �������
		for(i = -1; i < 2; i++) {
			m = y+i*dx-dy;
			n = x+i*dy-dx;
			if (tp.Border(m, n) == false) {
				return false;
			}
			m = y+i*dx+(dy*size);
			n = x+i*dy+(dx*size);
			if (tp.Border(m, n) == false) {
				return false;
			}
		}
		return true;
	}

	// �������� ������������ ���������� ������� �� ����

	private boolean CheckPlace() {
		return ByPass(new TrigerShipCheck(this));
	}


	 // ��������� �� ���� ������� � ��� ���������

	private void SetShip() {
		ByPass(new TrigerShipSet(this));
	}
}
