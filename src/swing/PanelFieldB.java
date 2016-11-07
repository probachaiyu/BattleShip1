package swing;

/**
 * Created by Yulia on 06.11.2016.
 */


import java.awt.Color;
import java.awt.Graphics;
import logic.*;

public class PanelFieldB extends PanelField {
	private static final long serialVersionUID = -1770790832677981438L;

	public PanelFieldB(GameModel model) {
		super(model);
	}

	private Color getColorByStateElement(ElementStates state) {
		switch (state) {
		case Border:
			return new Color(225, 225, 255);
		case Water:
			return new Color(225, 225, 255);
		case Well:
			return new Color(225, 225, 255);
		case Injured:
			return Color.red;
		case Killed:
			return Color.gray;
		case Missed:
			return Color.black;
		}
		
		return Color.blue;
		
	}
	
	@Override
	protected void paintElement(Graphics g, int i, int j) {
		ElementStates state = model.playerFiledB.GetElement(i, j);
		g.setColor(getColorByStateElement(state));
		
		if (state == ElementStates.Missed) {
			g.fillRect(i*15+6, j*15+6, 4, 4);
		} else {
			g.fillRect(i*15+1, j*15+1, 14, 14);
		}
	}

}
