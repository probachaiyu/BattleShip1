package swing;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.util.ArrayList;
import java.util.Iterator;

import logic.FieldShip;
import logic.Computer;

//Главное окно
public class GameModel {
	private ArrayList<ISubscriber> listeners = new ArrayList<ISubscriber>();
	public FieldShip playerFiledA;
	public FieldShip playerFiledB;
	public Computer comp;
	public int currentPlayer;


	public GameModel() {
		this.currentPlayer = 0;
		playerFiledA = new FieldShip();
		playerFiledB = new FieldShip();
		comp = new Computer(playerFiledA);
	}

	//Расстановка кораблей
	public void newGame() {
		playerFiledA.PutShip();
		playerFiledB.PutShip();
		updateSubscribers();
	}

	// Выстрел по текущему игроку
	public void doShotByOpponent(int x, int y) {
		// если ходит локальный игрок
		if (currentPlayer == 0) {
			// если промах
			if (playerFiledB.doShot(x, y) == false) {
				currentPlayer = 1;
			}
		}
		
		// если ходит противник
		if (currentPlayer ==1) {
			while (comp.move());
			currentPlayer = 0;
		}
		updateSubscribers();
	}
	
	// регистрация элементов, которые будут обновлять при перерисовки данных на форме

	public void register(ISubscriber o) {
		listeners.add(o);
		o.update();
	}
	
	//разрегистрация элеметов отображения

	public void unRegister(ISubscriber o) {
		listeners.remove(o);
	}
	
	//перерисовка данных в представлении

	public void updateSubscribers() {
		Iterator<ISubscriber> i = listeners.iterator();
		while(i.hasNext()) {
			ISubscriber o = (ISubscriber)i.next();
			o.update();
		}
	}

}
