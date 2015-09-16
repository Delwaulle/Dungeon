package possible_interface;
public class Objets
{
	//Attributs
	private String image;
	private int type;
	private int temps;
	private boolean existe;

	//Méthodes

	//Constructeurs
	public Objets(int x)
	{
		type = x;
		if(type == 0)
		{
			image = "";
			temps = 0;
			existe = false;
		}
		if(type == 1)
		{
			image="ecocup.jpg";
			temps=50;
			existe = true;
		}
			if(type == 2)
		{
			image="ballon.jpg";
			temps=50;
			existe = true;
		}
			if(type == 3)
		{
			image="troussepremiersecours.jpg";
			temps=50;
			existe = true;
		}
			if(type == 4)
		{
			image="pompons.jpg";
			temps=50;
			existe = true;
		}
			if(type == 5)
		{
			image="presidentovalies.jpg";
			temps=50;
			existe = true;
		}
			if(type == 6)
		{
			image="drapeauberger.jpg";
			temps=50;
			existe = true;
		}
			if(type == 7)
		{
			image="fauteuilroulant.jpg";
			temps=50;
			existe = true;
		}
			if(type == 8)
		{
			image="repas.jpg";
			temps=50;
			existe = true;
		}
			if(type == 9)
		{
			image="alcoolfort.jpg";
			temps=50;
			existe = true;
		}
	}
	
	//Accesseurs
	public String getImage()
	{
		return image;
	}

	public int getType()
	{
		return type;
	}

	public int getTemps()
	{
		return temps;
	}
	public boolean getExiste()
	{
		return existe;
	}
	// Modifieurs

	public void setImage(String x)
	{
		image=x;
	}

	public void setType(int a)
	{
		type=a;
		if(type == 0)
		{
			image = "";
			temps = 0;
			existe = false;
		}
		if(type == 1)
		{
			image="ecocup.jpg";
			temps=50;
			existe = true;
		}
			if(type == 2)
		{
			image="ballon.jpg";
			temps=50;
			existe = true;
		}
			if(type == 3)
		{
			image="troussepremiersecours.jpg";
			temps=50;
			existe = true;
		}
			if(type == 4)
		{
			image="pompons.jpg";
			temps=50;
			existe = true;
		}
			if(type == 5)
		{
			image="presidentovalies.jpg";
			temps=50;
			existe = true;
		}
			if(type == 6)
		{
			image="drapeauberger.jpg";
			temps=50;
			existe = true;
		}
			if(type == 7)
		{
			image="fauteuilroulant.jpg";
			temps=50;
			existe = true;
		}
			if(type == 8)
		{
			image="repas.jpg";
			temps=50;
			existe = true;
		}
			if(type == 9)
		{
			image="alcoolfort.jpg";
			temps=50;
			existe = true;
		}
	}

	public void setTemps(int t)
	{
		temps=t;
	}
	public void setExiste(boolean x)
	{
		existe=x;
	}
}