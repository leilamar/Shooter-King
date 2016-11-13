import java.awt.Image;

import javax.imageio.ImageIO;

import org.francisparker.mmaunu.gameengine.AIObject;
import org.francisparker.mmaunu.gameengine.DrawableGameObject;
import org.francisparker.mmaunu.gameengine.GameFrame;
import org.francisparker.mmaunu.gameengine.CollisionDetector;
import org.francisparker.mmaunu.gameengine.Drawable;
import org.francisparker.mmaunu.gameengine.ControllableObject;

public class Projectile extends AIObject
{
	private int currDirection;
	private static int DIR_UP = 1;
	
	public Projectile(int x, int y, Image img, int width, int height, int speed)
	{
		super(x, y, img, width, height, speed);
		currDirection = DIR_UP;
	}
	
	public void act()
	{
		int speed = getSpeed();
		int currY = getY();
		int height = getHeight();
		
		int newY = currY;
		
		if(currDirection == DIR_UP && newY - speed >= 0)
			newY -= speed;
		else
			GameFrame.removeDrawableObject(this);
		
		setY(newY);	
		
		
		Drawable possibleCollision = CollisionDetector.moveCollidesWith(this, getX(), newY);
		
		
		if(possibleCollision instanceof Alien)
		{
			GameFrame.removeDrawableObject(this);
			GameFrame.removeDrawableObject((DrawableGameObject)possibleCollision);
			GameFrame.incrementScore(1);
		}
		
		
		
	}
}
