package swing;

/**
 * Created by Yulia on 06.11.2016.
 */

import javax.swing.UIManager;

public class FrameGameLauncher {
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		GameModel model = new GameModel();
		GameView view = new GameView(model);
		view.setVisible(true);		
	}

}
