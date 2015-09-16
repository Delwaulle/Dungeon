package possible_interface;
public class Visiteurs
{
	//Attributs
	private String image;
	private int type;
	private int x;
	private int y;

	//Méthodes

	//Constructeurs
	public Visiteurs(int a, int b, int c)
	{
		type=a;
		x=b;
		y=c;
		if(type==1)
		{
			image="bizuth.png";
		}
		if(type == 2)
		{
			image="carre.jpg";
		}
		if(type==3)
		{
			image="cube.jpg";
		}
		if(type==4)
		{
			image="bica.jpg";
		}
		if(type==5)
		{
			image="penta.jpg";
		}
		if(type==6)
		{
			image="perso1.jpg";
		}
		if(type==7)
		{
			image="perso2.jpg";
		}
		if(type==8)
		{
			image="perso3.jpg";
		}
		if(type==9)
		{
			image="perso4.jpg";
		}
		if(type==10)
		{
			image="perso5.jpg";
		}if(type==11)
		{
			image="perso6.jpg";
		}if(type==12)
		{
			image="perso7.jpg";
		}if(type==13)
		{
			image="perso8.jpg";
		}if(type==14)
		{
			image="perso9.jpg";
		}if(type==15)
		{
			image="perso10.jpg";
		}if(type==16)
		{
			image="perso11.jpg";
		}if(type==17)
		{
			image="perso12.jpg";
		}if(type==18)
		{
			image="perso13.jpg";
		}if(type==19)
		{
			image="perso14.jpg";
		}if(type==20)
		{
			image="perso15.jpg";
		}if(type==21)
		{
			image="perso16.jpg";
		}if(type==22)
		{
			image="perso17.jpg";
		}if(type==23)
		{
			image="perso18.jpg";
		}if(type==24)
		{
			image="perso19.jpg";
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

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}


	// Modifieurs

	public void setImage(String x)
	{
		image=x;
	}

	public void setType(int a)
	{
		type=a;
	}

	public void setX(int b)
	{
		x=b;
	}
	public void setY(int c)
	{
		y=c;
	}
}