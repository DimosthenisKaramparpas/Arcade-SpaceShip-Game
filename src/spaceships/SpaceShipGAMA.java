package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipGAMA extends SpaceShip{
	public SpaceShipGAMA(){
		Speed=30;
		imgIcon= new ImageIcon(this.getClass().getResource("/images/GAMA.png"));
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		laserColor = Color.orange;
	}
}
