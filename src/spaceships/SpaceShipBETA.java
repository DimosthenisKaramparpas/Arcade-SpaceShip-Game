package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipBETA extends SpaceShip{
	public SpaceShipBETA(){
		Speed=20;
		imgIcon = new ImageIcon(this.getClass().getResource("/images/BETA.png"));
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		sizediff=10;
		laserColor = Color.green;
	}
}