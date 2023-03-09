package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipDELTA extends SpaceShip{
	public SpaceShipDELTA(){
		Speed=40;
		imgIcon= new ImageIcon(this.getClass().getResource("/images/DELTA.png"));
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		sizediff=10;
		laserColor = Color.yellow;
	}
}
