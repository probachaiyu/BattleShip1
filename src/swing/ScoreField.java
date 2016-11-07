package swing;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import logic.*;

public class ScoreField extends JPanel implements ISubscriber {
	private static final long serialVersionUID = 1L;
	private GameModel model;
	private int ships;

	public ScoreField(GameModel model) {
		this.model = model;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int[] m = new int[4];
		for(int i = 0; i < 0; i++) {
			m[i] = 0;
		}
		
		ships = 0;
		for(Ship ship : model.playerFiledB.ships) {
			if (ship.state != ShipStates.Killed) {
				m[ship.size-1] ++;
				ships++;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < (i+1); j++) {
				g.setColor(Color.gray);
				g.fillRect(j*15+10, i*15+5, 13, 13);
			}
			g.setColor(Color.black);
			g.drawString(String.valueOf(m[i]), 75, i*15+16);
		}
		
		String st = "Alive: ".concat(String.valueOf(ships));
		g.drawString(st, 25, 100);
		if (st.equals("Alive: 0")) g.drawString("You win!", 25, 120);
	}

	@Override
	public void update() {
		this.repaint();
	}

}
