import java.awt.Image;

import org.francisparker.mmaunu.gameengine.AIObject;
import org.francisparker.mmaunu.gameengine.CollisionDetector;
import org.francisparker.mmaunu.gameengine.Drawable;
import org.francisparker.mmaunu.gameengine.DrawableGameObject;
import org.francisparker.mmaunu.gameengine.GameFrame;


public class PlasmaBall extends AIObject
{
	private int currDirection;
	private static int DIR_DOWN = 1;
	
	public PlasmaBall(int x, int y, Image img, int width, int height, int speed)
	{
		super(x, y, img, width, height, speed);
		currDirection = DIR_DOWN;
	}
	
	public void act()
	{
		int speed = getSpeed();
		int currY = getY();
		int height = getHeight();
		
		int newY = currY;
		
		
		if(currDirection == DIR_DOWN && newY + speed <= 600)
			newY += speed;
		else
			GameFrame.removeDrawableObject(this);
		
		setY(newY);	
		
		Drawable possibleCollision = CollisionDetector.moveCollidesWith(this, getX(), newY);
		
		if(possibleCollision instanceof Shooter)
		{
			System.out.println("hit");
			GameFrame.removeDrawableObject(this);
			GameFrame.decrementNumberLives(1);
		}
	}	
}
