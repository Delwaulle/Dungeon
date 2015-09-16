package possible_interface;

import java.awt.*;
import javax.swing.*;

public class Panneau extends JPanel
{

	//Attributs
	private int grille[][];
	private boolean affichage;
	private Personnages perso;
	private Objets[][] objets;
	private Visiteurs[] visit;
	private int scrollY;

	//Constructeurs
	public Panneau()
	{
		grille=new int[49][28];
		for (int l = 0; l < 49; l++)
		{
			for (int c = 0; c < 28; c++)
			{
				grille[l][c] = 1;
			}
		}

		//Bitume
		for (int l = 32; l <33; l++)
		{
			for (int c = 10; c<11; c++)
			{
				grille[l][c] = 2;
			}
		}

		for (int l = 32; l <33; l++)
		{
			for (int c = 8; c<9; c++)
			{
				grille[l][c] = 2;
			}
		}

		for (int l = 32; l <34; l++)
		{
			for (int c = 0; c<8; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 30; l <32; l++)
		{
			for (int c = 3; c<4; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 31; l <32; l++)
		{
			for (int c = 4; c<8; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 30; l <32; l++)
		{
			for (int c = 3; c<4; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 30; l <31; l++)
		{
			for (int c = 7; c<8; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 33; l <35; l++)
		{
			for (int c = 8; c<16; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 30; l <31; l++)
		{
			for (int c = 9; c<13; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 31; l <32; l++)
		{
			for (int c = 11; c<12; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 32; l <33; l++)
		{
			for (int c = 11; c<18; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 30; l <31; l++)
		{
			for (int c = 14; c<16; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 31; l <32; l++)
		{
			for (int c = 15; c<17; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 34; l <35; l++)
		{
			for (int c = 16; c<18; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 35; l <36; l++)
		{
			for (int c = 15; c<26; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 36; l <37; l++)
		{
			for (int c = 19; c<25; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 37; l <38; l++)
		{
			for (int c = 21; c<23; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 37; l <49; l++)
		{
			for (int c = 19; c<20; c++)
			{
				grille[l][c] = 2;
			}
		}
		for (int l = 34; l <35; l++)
		{
			for (int c = 25; c<27; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 30; l <34; l++)
		{
			for (int c = 26; c<28; c++)
			{
				grille[l][c] = 2;
			}
		}	
		for (int l = 24; l <27; l++)
		{
			for (int c = 18; c<21; c++)
			{
				grille[l][c] = 2;
			}
		}	

		//toits
		for (int l = 39; l <45; l++)
		{
			for (int c = 21; c<23; c++)
			{
				grille[l][c] = 3;
			}
		}	
		for (int l = 41; l <42; l++)
		{
			for (int c = 20; c<21; c++)
			{
				grille[l][c] = 3;
			}
		}	
		for (int l = 28; l <29; l++)
		{
			for (int c = 19; c<20; c++)
			{
				grille[l][c] = 3;
			}
		}	
		for (int l = 28; l <29; l++)
		{
			for (int c = 17; c<18; c++)
			{
				grille[l][c] = 3;
			}
		}	
		for (int l = 28; l <29; l++)
		{
			for (int c = 15; c<16; c++)
			{
				grille[l][c] = 3;
			}
		}	
		for (int l = 30; l <31; l++)
		{
			for (int c = 4; c<7; c++)
			{
				grille[l][c] = 3;
			}
		}	

		//terrebattue
		for (int l = 0; l <28; l++)
		{
			for (int c = 4; c<5; c++)
			{
				grille[l][c] = 4;
			}
		}	
		for (int l = 0; l <30; l++)
		{
			for (int c = 13; c<14; c++)
			{
				grille[l][c] = 4;
			}
		}	
		for (int l = 14; l <15; l++)
		{
			for (int c = 5; c<13; c++)
			{
				grille[l][c] = 4;
			}
		}
		for (int l = 27; l <28; l++)
		{
			for (int c = 1; c<4; c++)
			{
				grille[l][c] = 4;
			}
		}		
		for (int l = 28; l <32; l++)
		{
			for (int c = 1; c<2; c++)
			{
				grille[l][c] = 4;
			}
		}
		for (int l = 29; l <30; l++)
		{
			for (int c = 11; c<13; c++)
			{
				grille[l][c] = 4;
			}
		}

		//bar	
		for (int l = 39; l <41; l++)
		{
			for (int c = 22; c<23; c++)
			{
				grille[l][c] = 5;
			}
		}	

		//scene		
		for (int l = 19; l <21; l++)
		{
			for (int c = 17; c<20; c++)
			{
				grille[l][c] = 6;
			}
		}	
		for (int l = 44; l <45; l++)
		{
			for (int c = 21; c<23; c++)
			{
				grille[l][c] = 6;
			}
		}

		//stade
		for (int l = 1; l <13; l++)
		{
			for (int c = 6; c<12; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 3; l <13; l++)
		{
			for (int c = 15; c<22; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 6; l <10; l++)
		{
			for (int c = 0; c<3; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 14; l <18; l++)
		{
			for (int c = 0; c<3; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 20; l <24; l++)
		{
			for (int c = 0; c<3; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 16; l <28; l++)
		{
			for (int c = 6; c<12; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 34; l <38; l++)
		{
			for (int c = 0; c<8; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 42; l <46; l++)
		{
			for (int c = 4; c<7; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 38; l <48; l++)
		{
			for (int c = 11; c<18; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 39; l <43; l++)
		{
			for (int c = 24; c<27; c++)
			{
				grille[l][c] = 7;
			}
		}
		for (int l = 44; l <48; l++)
		{
			for (int c = 24; c<27; c++)
			{
				grille[l][c] = 7;
			}
		}

		//batiment
		for (int l = 30; l <31; l++)
		{
			for (int c = 8; c<9; c++)
			{
				grille[l][c] = 8;
			}
		}
		for (int l = 31; l <32; l++)
		{
			for (int c = 8; c<11; c++)
			{
				grille[l][c] = 8;
			}
		}
		for (int l = 31; l <32; l++)
		{
			for (int c = 12; c<15; c++)
			{
				grille[l][c] = 8;
			}
		}
		for (int l = 30; l <31; l++)
		{
			for (int c = 13; c<14; c++)
			{
				grille[l][c] = 8;
			}
		}
		for (int l = 30; l <31; l++)
		{
			for (int c = 16; c<18; c++)
			{
				grille[l][c] = 8;
			}
		}
		for (int l = 31; l <32; l++)
		{
			for (int c = 17; c<18; c++)
			{
				grille[l][c] = 8;
			}
		}
		

		//estrade
		for (int l = 18; l <19; l++)
		{
			for (int c = 18; c<21; c++)
			{
				grille[l][c] = 9;
			}
		}
		for (int l = 21; l <22; l++)
		{
			for (int c = 18; c<21; c++)
			{
				grille[l][c] = 9;
			}
		}
		for (int l = 19; l <21; l++)
		{
			for (int c = 20; c<21; c++)
			{
				grille[l][c] = 9;
			}
		}
		for (int l = 25; l <26; l++)
		{
			for (int c = 2; c<3; c++)
			{
				grille[l][c] = 9;
			}
		}

		//tentebar
		for (int l = 32; l <33; l++)
		{
			for (int c = 9; c<10; c++)
			{
				grille[l][c] = 10;
			}
		}
		for (int l = 14; l <15; l++)
		{
			for (int c = 16; c<17; c++)
			{
				grille[l][c] = 10;
			}
		}
		for (int l = 33; l <34; l++)
		{
			for (int c = 21; c<24; c++)
			{
				grille[l][c] = 10;
			}
		}

		//perso = new Personnages
		
		
		objets = new Objets[98][56];

		//Position objets
		for (int l = 0; l < 98; l++)
		{
			for (int c = 0; c < 56; c++)
			{
				objets[l][c] = new Objets(0);
			}
		}

		objets[28][32].setType(1);
		objets[90][8].setType(2);
		objets[56][30].setType(3);
		objets[41][36].setType(4);
		objets[62][1].setType(5);
		objets[12][1].setType(6);
		objets[50][38].setType(7);
		objets[82][22].setType(8);
		objets[60][8].setType(9);

		
		//Position personnages
		//Perso principal
		perso = new Personnages(1);

		//Visiteur
		visit = new Visiteurs[9];
		visit[0] = new Visiteurs(6,0,552);
		visit[1] = new Visiteurs(7,23,552);
		visit[2] = new Visiteurs(8,46,552);
		visit[3] = new Visiteurs(9,0,414);
		visit[4] = new Visiteurs(10,23,414);
		visit[5] = new Visiteurs(11,46,414);
		visit[6] = new Visiteurs(12,0,230);
		visit[7] = new Visiteurs(13,23,230);
		visit[8] = new Visiteurs(14,46,230);

		scrollY = 0;
	}

	//Accesseurs
	public int getGrille(int x, int y)
	{
		return grille[x][y];
	}

	public boolean getAffichage()
	{
		return affichage;
	}

	public Personnages getPerso()
	{
		return perso;
	}

	public Objets getObjets(int x, int y)
	{
		return objets[x][y];
	}

	public Visiteurs getVisit(int x)
	{
		return visit[x];
	}

	//Modifieurs

	public void setAffichage(boolean x)
	{
		affichage=false;
	}

	public void deplacementPersoDroite()
	{
		if (perso.getX() < 667)
		{
			perso.setX(perso.getX() + 1);
		}
	}
	public void deplacementPersoGauche()
	{
		if (perso.getX() > 0)
		{
			perso.setX(perso.getX() - 1);
		}
	}

	public void deplacementPersoHaut()
	{
		if (perso.getY() > 0)
		{
			perso.setY(perso.getY() - 1);
			if (perso.getY() < 976 && perso.getY() > 248)
			{
				scrollY = scrollY - 1;

			}
			
		}
	}

	public void deplacementPersoBas()
	{
		if (perso.getY() < 1116)
		{
			perso.setY(perso.getY() + 1);
			if (perso.getY() > 248	&& perso.getY() < 976)	
			{
				scrollY = scrollY + 1;
			}
		}
	}


	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.lightGray);
		g.fillRect(0,0,792,566);

		
		int taille = 23;

		//Grille
		for (int l = 0; l < 49; l++)
		{
			for (int c = 0; c < 28; c++)
			{
				if (grille[l][c] == 1)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/herbe.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 2)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/bitume.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);

				}
				if (grille[l][c] == 3)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/toit.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);

				}
				if (grille[l][c] == 4)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/terrebattue.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 5)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/bar.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 6)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/scene.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 7)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/stade.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 8)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/batiment.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 9)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/estrade.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
				if (grille[l][c] == 10)
				{
					g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/tentebar.jpg"), 71 + c * taille, 107 + l * taille - scrollY, taille, taille, this);
				}
			}
		}

		//Objets
		for (int l = 0; l < 98; l++)
		{
			for (int c = 0; c < 56; c++)
			{
				g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/"+objets[l][c].getImage()), 71 + c * taille/2, 107 + l * taille/2 - scrollY, taille/2, taille/2, this);
			}	
		}

		for (int numPers = 0; numPers < 9; numPers++)
		{
			g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/"+visit[numPers].getImage()), 71 + visit[numPers].getX(), 107 + visit[numPers].getY() - scrollY, taille/2, taille/2, this);
		}

		//Personnages
		g.drawImage(Toolkit.getDefaultToolkit().getImage("Images/"+perso.getImage()), 71 + perso.getX(), 107 + perso.getY() - scrollY, taille/2, taille/2, this);
	

		//g.setColor(Color.lightGray);
		//g.fillRect(71,107+400,28*taille,566-(107+400));
		
		//g.setColor(Color.gray);
		//g.fillRect(216,519,360,41);
		//g.fillRect(649,519,72,41);
		//g.fillRect(71,54,650,41);
		

		g.setColor(Color.black);
		g.drawRect(71,107,28*taille,400);
	}
		
}