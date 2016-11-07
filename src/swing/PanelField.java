package swing;

/**
 * Created by Yulia on 06.11.2016.
 */

import java.awt.Graphics;
import javax.swing.JPanel;

abstract public class PanelField extends JPanel implements ISubscriber {
	private static final long serialVersionUID = 1L;
	public GameModel model;

	public PanelField(GameModel model) {
		this.model = model;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// рисуем решётку
		for(int i = 0; i < 11; i++) {
			g.drawLine(i*15, 0, i*15,150);
			g.drawLine(0,i*15, 150, i*15);
		}
		
		// рисуем элементы
		for(int j = 0; j < 10; j++) {
			for(int i = 0; i < 10; i++) {
				paintElement(g, i, j);
			}
		}
	}

	// Рисуем элементы кораблей
	protected void paintElement(Graphics g, int i, int j) {
	}

	@Override
	public void update() {
		this.repaint();
	}
	
}
