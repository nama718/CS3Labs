//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
    private List<Alien> aliens;
    private boolean right = true;
    private boolean left = false;
    private boolean down = true;
    private int score = 0;
    private int size = 0;
    private int health = 3;

    public AlienHorde(int size)
    {
        aliens = new ArrayList<Alien>(size);
		this.size = size;
    }

    public void add(Alien al)
    {
        aliens.add(al);
    }

    public void drawEmAll( Graphics window )
    {
        if (getSize() > 0) {
			for (Alien a : aliens) {
				a.draw(window);
			}
		}
    }

    public void moveEmAll()
    {
        if (getSize() > 0) {
			if (aliens.get(0).getX() <= 0) {
				right = true;
				left = false;
				down = true;
			} else if (aliens.get(getSize() - 1).getX()
					+ aliens.get(getSize() - 1).getWidth() >= 800 - 18) {
				right = false;
				left = true;
				down = true;
			}
			if (right == true) {
				for (Alien a : aliens) {
					a.move("RIGHT");
				}
			} else {
				for (Alien a : aliens) {
					a.move("LEFT");
				}
			}
			if (down == true) {
				for (Alien a : aliens) {
					a.move("DOWN");
				}
				down = false;
			}
		}
    }

    public void removeDeadOnes(Bullets shots) {
		if (getSize() > 0) {
			for (int i = 0; i < getSize(); i++) {
				if (shots.getSize() > 0) {
					for (int j = 0; j < shots.getSize(); j++) {
						if (shots.getAmmo(j).didCollide(aliens.get(i))) {
							score += 1;
							aliens.remove(i);
							i = 0;
							break;
						}
					}
				}
			}
		}
	}
	
    public int getHealth() {
    return health;
  }

	public List<Alien> getList() {
		return aliens;
	}

	public int getSize() {
		return aliens.size();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

    public String toString()
    {
        return "";
    }
}