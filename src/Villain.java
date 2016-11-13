import java.awt.Image;

import javax.imageio.ImageIO;

import org.francisparker.mmaunu.gameengine.AIObject;
import org.francisparker.mmaunu.gameengine.GameFrame;

public class Villain extends AIObject
{
	private int currDirection;
	private static int N = 1, NE = 2, E = 3, SE = 4, S = 5, SW = 6, W = 7, NW = 8;
	
	public Villain(int x, int y, Image img, int width, int height, int speed)
	{
		super(x, y, img, width, height, speed);
		currDirection = NE;
	}
	
	public void act()
	{
		int currX = getX();
		int speed = 3*getSpeed();
		int width = getWidth();
		int newX = currX;
		

		if(currDirection == NW && currX - speed >= 0)
		{
			newX -= speed;
		}
		
		else if(currDirection == NW)
		{
			currDirection = NE;
		}
		else if (currDirection == NE && 
					newX + width + speed  <= GameFrame.getWidthOfGameArea())
			newX += speed;
		
		else
		{
			 currDirection = NW;
			newX -= speed;
		}
			
	
		setX(newX);
		
		
		if(Math.random() < 0.07)
		{
			try
			{
				Image alienProjectile = ImageIO.read( this.getClass().getResource("/plasmaBall.gif") );
				
				PlasmaBall plasma = new PlasmaBall(getX(), getY(), alienProjectile, 28, 11, 10);
				GameFrame.addDrawableObject(plasma);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}

