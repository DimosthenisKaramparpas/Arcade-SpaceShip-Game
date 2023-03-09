package spaceships;

import java.awt.Color;

import javax.swing.ImageIcon;

public class SpaceShipZERO extends SpaceShip{
	public SpaceShipZERO(){
		Speed=5;
		imgIcon= new ImageIcon(this.getClass().getResource("/images/ZERO.png"));
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		sizediff=10;
		laserColor = Color.pink;
	}
}