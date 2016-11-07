package logic;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.util.ArrayList;

public class FieldShip {
	public Element[][] elements;
	public ArrayList<Ship> ships;

	//создание поля с кораблями

	public FieldShip() {
		// заполняем поле элементами воды
		elements = new Element[10][10]; 
		for(int j=0; j<10; j++) {
			for(int i=0; i<10; i++) {
				elements[i][j]=new Element(i, j);
			}
		}
		this.PutShip();
	}


	 // Функция заполнения поля водой и расставления кораблей

	public void PutShip() {

		// заполняем поле водой
		for(int j=0; j<10; j++) {
			for(int i=0; i<10; i++) {
				Element element = elements[i][j];
				element.state = ElementStates.Water;
				element.shuted = false;
			}
		}
		
		// заполняем поле короблями
		ships = new ArrayList<Ship>(); 
		for(int i=4; i>0; i--) {
			for(int j=(5-i); j>0; j--) {
				Ship ship=new Ship(this,i);
				ships.add(ship);
			}
		}
		
		// удаляем окружение коробля
		for(int j=0; j<10; j++) {
			for(int i=0; i<10; i++) {
				Element element = elements[i][j];
				if (element.state == ElementStates.Border) {
					element.state = ElementStates.Water;
				}
			}
		}
		
	}
	
	 //Сделать выстрел

	  //Возвращает результат выстрела

	public boolean doShot(int x, int y) {
		boolean shot = false;
		
		ElementStates state = this.GetElement(x, y);
		elements[x][y].shuted = true;
		if (state == ElementStates.Well) {
			shot = true;
			Ship ship = elements[x][y].ship; 
			if (ship.health != 0) {
				ship.health--;
				if (ship.health == 0) {
					ship.state = ShipStates.Killed;
					for(Element e : ship.elements) {
						e.state = ElementStates.Killed;
					}
				} else {
					ship.state = ShipStates.Injured;
					elements[x][y].state = ElementStates.Injured;
				}
			}
		} else {
			if ( (state == ElementStates.Border) ||
						(state == ElementStates.Water)) {
				this.SetElement(x, y, ElementStates.Missed);
			}
		}
		return shot;
	}
	
	// Проверка координат в пределах поля

 	public boolean isBound(int x, int y) {
		return !( (x<0) || (x>9) || (y<0) || (y>9) );
	}
	
	//Получить по координатам тип элемента

	public ElementStates GetElement(int x, int y) {
		if (isBound(x,y)) {
			return elements[x][y].state;
		} else {
			return ElementStates.Empty;
		}
	}
	
	 //  тип элемента по координатам

	public boolean SetElement(int x, int y, ElementStates state) {
		if (isBound(x,y)) {
			elements[x][y].state = state;
		}
		return true;
	}
	
	// отрисовка поля

	public void Draw() {
		for(int j=0; j<10; j++) {
			for(int i=0; i<10; i++) {
				System.out.print(elements[i][j].toString());
			}
			System.out.println();
		}
	}
	
}
