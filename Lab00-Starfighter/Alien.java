//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(50,10,40,40,1);
	}

	public Alien(int x, int y)
	{
		this(x,y,40,40,1);
	}

	public Alien(int x, int y, int s)
	{
		this(x,y,40,40,s/2);
	}

	public Alien(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		speed = s/2;
		try {
			// URL url = getClass().getResource("C:/Users/amanb/Downloads/drive-download-20220825T180510Z-001/alien.JPG");
			image = image = ImageIO.read(new File("src//images//alien.jpg"));;
		} catch (Exception e) {
			System.out.println("Couldn't locate image file");
		}
	}


	public void setSpeed(int s)
	{
	   speed=s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
   {
	   if(direction.equals("RIGHT"))
		{
			setX(getX() + speed);
			//setY(getY() + speed);
		}
		if(direction.equals("UP"))
		{
			//setX(getX() + speed);
			setY(getY() + speed);
		}
		if(direction.equals("LEFT"))
		{
			setX(getX() - speed);
			//setY(getY() + speed);
		}
		if(direction.equals("DOWN"))
		{
			//setX(getX() - speed);
			setY(getY() + speed);
		}
	}

	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return super.toString() +" "+ getSpeed();
	}
}