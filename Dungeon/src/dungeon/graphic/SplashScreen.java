package dungeon.graphic;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * @author Loic
 * screen of the loading of the game
 * 
 */

public class SplashScreen extends JWindow{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static SplashScreen splashScreen;
	public final String BACKGROUND_PATH="rsc/splashscreen";

	public SplashScreen() {
		splashScreen=this;
		createSplash();
	}

	private void createSplash() {
		SplashScreenPanel scp=new SplashScreenPanel(SplashScreen.splashScreen);
		this.setSize(800,400);
		this.getContentPane().add(scp);
		this.setVisible(true);
		setLocationRelativeTo(null);
	}
/*
	public static void main(String args[]) {
		new SplashScreen();
	}
*/



	public class SplashScreenPanel extends JPanel{
	
		private static final long serialVersionUID = 1L;
		private Image img;
		public SplashScreenPanel(SplashScreen ss){

			try {
				img=ImageIO.read(new File(BACKGROUND_PATH));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.setLayout(new FlowLayout(0,70,330));
			ProgressBar progressBar = new ProgressBar(ss);
			this.add(progressBar);
		}

		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(img,0,0,this);
		}

	}

}





