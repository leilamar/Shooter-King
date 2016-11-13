//Leila Mardoum, Andrew Asbille
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.francisparker.mmaunu.gameengine.GameFrame;

public class ShooterKing 
{
	
	public static void main(String[] args) 
	{
		new ShooterKing();
	}

	@SuppressWarnings("static-access")
	public ShooterKing()
	{
		System.out.println("making new game");
		
		GameFrame mainWindow = new GameFrame("Shooter King", 600, 600, true, true);
		mainWindow.setNumberLives(5);
		
		Image shooterImg = null, alienImg = null, laserImg = null;
		try
		{	
			//read images relative to this class' location
			laserImg = ImageIO.read(this.getClass().getResource("/laser1.jpg"));			
			shooterImg = ImageIO.read(this.getClass().getResource("/shooter.gif"));
			alienImg = ImageIO.read(this.getClass().getResource("/alien.gif"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		Shooter hero = new Shooter(300, 470, shooterImg, 64, 64, 15);
		Alien alien1 = new Alien(50, 50, alienImg, 48, 45, 5);
		Alien alien2 = new Alien(275, 50, alienImg, 48, 45, 5);
		Alien alien3 = new Alien(500, 50, alienImg, 48, 45, 5);
		Projectile laser = new Projectile(hero.getX(), hero.getY(), laserImg, 28, 46, 15 );
		
		
		mainWindow.setControllableObject(hero);
		mainWindow.addDrawableObject(alien1);
		mainWindow.addDrawableObject(alien2);
		mainWindow.addDrawableObject(alien3);
		
		mainWindow.addKeyListener(hero);
		
		try {
			mainWindow.setGameBackground(ImageIO.read(this.getClass().getResource("/space2.jpg")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mainWindow.setScoreBackground(Color.green);
		mainWindow.setNumberLivesBackground(Color.green);
		mainWindow.setFPS(24);
		
		mainWindow.setVisible(true);
		
			
	}
}
