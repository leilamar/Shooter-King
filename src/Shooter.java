import java.awt.Image;

import org.francisparker.mmaunu.gameengine.ControllableObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.francisparker.mmaunu.gameengine.GameFrame;

public class Shooter extends ControllableObject implements KeyListener
{	
	
	public Shooter(int x, int y, Image img, int width, int height, int speed)
	{
		super(x, y, img, width, height, speed);
	}
	
	public void act()
	{
		int currX = getX();
		int currY = getY();
		int speed = getSpeed();

		int newX = currX;
		int newY = currY;
		
		if(isMovingLeft() && newX - speed >= 0)
			newX -= speed;
		else if(isMovingRight() && newX + speed <= GameFrame.getWidthOfGameArea() - 60)
			newX += speed;

		setX(newX);
		
		if(GameFrame.getNumberLives() <= 0)
		{
			JOptionPane.showMessageDialog(null, "GAME OVER");
			int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
			if(response == 0)
			{
				GameFrame.closeWindow();
				ShooterKing.main(null);
			}
			else
				GameFrame.closeWindow();
		}
		
		
		
		if(GameFrame.getScore() >= 3)
		{
			JOptionPane.showMessageDialog(null, "YOU WON!");
			int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?");
			if(response == 0)
			{
				GameFrame.closeWindow();
				ShooterKing.main(null);
			}
			else
				GameFrame.closeWindow();
		}
	}
	
	
	
	public void keyPressed(KeyEvent evt)
	{
		//The KeyEvent object can tell us the code for the key that the user pressed
		int key = evt.getKeyCode();
		if( key == KeyEvent.VK_SPACE )
		{
			try
			{
				Image img = ImageIO.read(this.getClass().getResource("/laser1.jpg"));
				GameFrame.addDrawableObject( new Projectile (getX() + 32, getY(), img, 39, 36, 20 ));
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
}
	}
	
	@Override
	public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	
	public String toString()
	{
		return "Shooter";
	}
}
