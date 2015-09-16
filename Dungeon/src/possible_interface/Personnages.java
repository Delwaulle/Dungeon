package possible_interface;
public class Personnages extends Visiteurs
{

	//Attributs
	private int tailleVentre;
	private int chpVision;
	private int vitesse;
	private Objets[] inventaire;

	//Méthodes

	//Constructeurs
	public Personnages(int x)
	{
		super(x,5,5);
		if(x==1)
		{
			tailleVentre=1;
			chpVision = 5;
			vitesse = 5;
		}
		if(x==2)
		{
			tailleVentre=2;
			chpVision = 4;
			vitesse = 4;
		} 
			if(x==3)
		{
			tailleVentre=3;
			chpVision = 3;
			vitesse = 3;
		} 
			if(x==4)
		{
			tailleVentre=4;
			chpVision = 2;
			vitesse = 2;
		} 
			if(x==5)
		{
			tailleVentre=5;
			chpVision = 1;
			vitesse = 1;
		} 
		
		inventaire = new Objets[9];
		for(int i=0;i<9;i++)
		{
			inventaire[i] = new Objets(0);
		}
	}

	// Accesseurs

	public Objets getInventaire(int x)
	{
		return inventaire[x];
	}

	public int getTailleVentre()
	{
		return tailleVentre;
	}

	public int getChpVision()
	{
		return chpVision;
	}

	public int getVitesse()
	{
		return vitesse;
	}


	// Modifieurs

	public void setTailleVentre(int x)
	{
		tailleVentre=x;
	}

	public void setChpVision(int y)
	{
		chpVision=y;
	}

	public void setVitesse(int z)
	{
		vitesse=z;
	}
}

