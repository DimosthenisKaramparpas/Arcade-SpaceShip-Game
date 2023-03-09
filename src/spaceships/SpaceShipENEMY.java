package spaceships;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Image;

import mainPacket.MainClass;

import spaceships_laserguns.Laser;

import java.util.LinkedList;
public class SpaceShipENEMY extends SpaceShip{
	public LinkedList<Laser> enemyLaserLinkedList=new LinkedList<Laser>();
	public SpaceShipENEMY(){
		lifes = 100;
		imgIcon= new ImageIcon(this.getClass().getResource("/images/ENEMY.png"));
		Image image = imgIcon.getImage();
		Image newimg = image.getScaledInstance(100, 100,  java.awt.Image.SCALE_SMOOTH); 
		imgIcon = new ImageIcon(newimg); 
		laserColor=Color.red;
		
		SpaceShipHeight=imgIcon.getIconHeight();
		SpaceShipWidth=imgIcon.getIconWidth();
		Xcoords=MainClass.getCosmosWidth() - SpaceShipWidth;
		Ycoords=45;
		Speed=15;
		}
	public void fire(int x,int y) {
		enemyLaserLinkedList.add(enemyLaserLinkedList.size(),new Laser(x,y));
	}
	public void huntUser(SpaceShip user) {
		int rand = ThreadLocalRandom.current().nextInt(0,20);
		if(rand<5) {
		if(user.Xcoords>this.Xcoords) {
			this.moveRIGHT();
		}
		if (user.Xcoords<this.Xcoords){
			this.moveLEFT();
		}
		}
		if(rand==2) {
			fire(getX(),getY()+100);
		}
		
		int res=ThreadLocalRandom.current().nextInt(0,4);
		if (res==2)this.moveLEFT();
		if (res==3)this.moveRIGHT();
	}
}