package spaceships;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SpaceShipALPHA extends SpaceShip{
	
	
	public SpaceShipALPHA(){
		Speed=10;
		imgIcon = new ImageIcon(this.getClass().getResource("/images/Alpha.png"));
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		laserColor = Color.magenta;
	}
	
}
