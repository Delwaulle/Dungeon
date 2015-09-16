package possible_interface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Fenetre extends JFrame implements KeyListener, Runnable
{


	//Attributs
	private int temps;
	private Panneau pan;
	private JLabel mission; 
	private boolean gauche, droite, haut, bas;
	private Thread t;


	//Constructeurs
	public Fenetre()
	{
		this.setTitle("Ovalies");
		this.setSize(new Dimension(800,600));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		pan=new Panneau();
		this.setContentPane(pan);
		this.setLayout(null);
		pan.setBackground(Color.lightGray);

		this.addKeyListener(this);
		mission=new JLabel("Mission:");

		mission.setBounds(500,10,150,20);
		
		haut = false;
		bas =false;
		droite = false;
		gauche =false;
		
		temps=0;
		t = new Thread (this);
		t.start();
	}

	public int getTemps()
	{
		return temps;
	}

	public Panneau getPan()
	{
		return pan;
	}

	public void keyPressed(KeyEvent ke) 
	{
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) 
		{
			droite = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			gauche = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) 
		{
			haut = true;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			bas = true;
		}
	}

	public void keyReleased(KeyEvent ke) 
	{
		if (ke.getKeyCode() == KeyEvent.VK_RIGHT) 
		{
			droite = false;
		}
		if (ke.getKeyCode() == KeyEvent.VK_LEFT) 
		{
			gauche = false;
		}
		if (ke.getKeyCode() == KeyEvent.VK_UP) 
		{
			haut = false;
		}
		if (ke.getKeyCode() == KeyEvent.VK_DOWN) 
		{
			bas = false;
		}
	}

	public void keyTyped(KeyEvent ke) 
	{
		
	}

	public void run ()
	{
		while (true)
		{
			try
			{
				if (droite == true)
				{
					pan.deplacementPersoDroite();
				}
				if (gauche == true)
				{
					pan.deplacementPersoGauche();
				}
				if (haut == true)
				{
					pan.deplacementPersoHaut();
				}
				if (bas == true)
				{
					pan.deplacementPersoBas();
				}
				
				pan.repaint();
				t.sleep(5);
			} catch (Exception e) {}
		}
	}
}