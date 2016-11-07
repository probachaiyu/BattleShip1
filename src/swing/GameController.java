package swing;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

// ���������� �������� ����

public class GameController implements ActionListener {
	public GameModel model;
	public GameView view;

	public GameController(GameView view, GameModel model) {
		this.view = view;
		this.model = model;
	}

	// ���������� ������ ����

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		// *** �������: ����� ����
		if (cmd == "New game") { 	
				model.newGame();
		}
		// **** �������: About
		if (cmd == "About") {
			System.out.println("About");

		}
		// *** �������: ����� �� ����
		if (cmd == "Exit") {	
			System.exit(0);
		}
	}

	// ���������� ����� �����

	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX() / 15;
		int y = arg0.getY() / 15;
		model.doShotByOpponent(x, y);
	}

}
