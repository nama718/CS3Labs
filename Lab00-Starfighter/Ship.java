
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing
{
    private int speed;
    private Image image;

    public Ship()
    {
        this(10,10,10,10,10);
    }

    public Ship(int x, int y)
    {
       this(x,y,10,10,10);
       
        
    }

    public Ship(int x, int y, int s)
    {
       this(x,y,10,10,s);
    }

    public Ship(int x, int y, int w, int h, int s)
    {
        super(x, y, w, h);
        speed=s;
        try
        {
            // URL url = getClass().getResource("src//images//ship.jpg");
            image = ImageIO.read(new File("src//images//ship.jpg"));
        }
        catch(Exception e)
        {
            System.out.println("assets failed to deploy");
        }
    }


    public void setSpeed(int s)
    {
       speed = s;
    }

    public int getSpeed()
    {
       return speed;
    }

    public void move(String direction)
    {
        if(direction.equals("UP"))
        {
            //setX(getX() - speed);
            setY(getY() - speed);
        }
    if(direction.equals("DOWN"))
        {
            //setX(getX() - speed);
            setY(getY() + speed);
        }
        if(direction.equals("RIGHT"))
        {
            setX(getX() + speed);
            //setY(getY() + speed);
        }
    if(direction.equals("LEFT"))
        {
            setX(getX() - speed);
            //setY(getY() + speed);
        }
        
    }
    

    public void draw( Graphics window )
    {
       window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString()
    {
        return super.toString() + getSpeed();
    }
}