//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Yiju Choi

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class Ammo extends MovingThing {
	private int speed;
	private boolean alive = true;
	private Image image;
  private Color color = Color.RED;

	public Ammo() {
		this(5, 5, 5);
	}

	public Ammo(int x, int y) {
		this(x, y, 5);
	}

  public Ammo(int x, int y, int s) {
		super(x, y);
		speed = s;
		try
        {
            // URL url = getClass().getResource("src//images//ship.jpg");
             image = ImageIO.read(new File("src//images//Bullet.png"));
        }
        catch(Exception e)
        {
            System.out.println("assets failed to deploy");
        }

	}

	public Ammo(int x, int y, int s, Color c) {
		super(x, y);
		speed = s;
    color = c;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), 4, 10);
	}
  
	public void move(String direction) {
		if (direction.equals("RIGHT")) {
			setX(getX() + speed);		
		}
		if (direction.equals("LEFT")) {
			setX(getX() - speed);
		}
		if (direction.equals("UP")) {
			setY(getY() - speed);
		}
		if (direction.equals("DOWN")) {
			setY(getY() + speed);
		}
	}

	public String toString() {
		return super.toString() + " " + getSpeed();
	}

	public boolean didCollide(Alien al) {
		if (getX() + 10 >= al.getX() && getX() <= al.getX() + al.getWidth()
				&& getY() - 10 >= al.getY()
				&& getY() <= al.getY() + al.getHeight()) {
      System.out.println("Ammo-Alien Collision: " + getX() + " " + getY());
			kill();
			return true;
		} else {
			return false;
		}
	}

  public boolean didCollideShip(Ship s) {
		if (getX() + 10 >= s.getX() && getX() <= s.getX() + s.getWidth()
				&& getY() - 10 >= s.getY()
				&& getY() <= s.getY() + s.getHeight()) {
			kill();
			return true;
		} else {
			return false;
		}
	}

	public boolean isAlive() {
		if (getY() < 0) {
			kill();
		}
		return alive;
	}

	public void kill() {
		alive = false;
	}
}