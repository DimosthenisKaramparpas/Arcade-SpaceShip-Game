package spaceships;
import mainPacket.MainClass;
import spaceships_laserguns.*;

import java.awt.Color;
import java.util.LinkedList;

import javax.swing.ImageIcon;
abstract public class SpaceShip implements Navigation,LaserGun{
	public int lifes=3;
	public int sizediff=0;
	protected int Xcoords=0;
	protected int Ycoords=480;
	protected ImageIcon imgIcon;
	static int SpaceShipWidth;
	static int SpaceShipHeight;
	public Color laserColor=Color.white;
	public LinkedList<Laser> laserLinkedList=new LinkedList<Laser>();
	public void printInfo() {
		System.out.println(this.getClass().getSimpleName()+ " "+"Xcoords:"+Xcoords+" Ycoords:"+Ycoords);
	}
	
	//code for movement
	protected int Speed;
	public int moveUP() {
		if(Ycoords-Speed>0)
		Ycoords-=Speed;
		else Ycoords=0;
		return Ycoords;
	}
	public int moveDOWN() {
		if(Ycoords+SpaceShipHeight+Speed<MainClass.getCosmosHeight())
		Ycoords+=Speed;
		else Ycoords=MainClass.getCosmosHeight()-SpaceShipHeight;
		return Ycoords;
	}
	public int moveRIGHT() {
		if(Xcoords+SpaceShipWidth+Speed<MainClass.getCosmosWidth())
		Xcoords+=Speed;
		else Xcoords=MainClass.getCosmosWidth()-SpaceShipWidth;
		return Xcoords;
	}
	public int moveLEFT() {
		if(Xcoords-Speed>0)
		Xcoords-=Speed;
		else Xcoords=0;
		return Xcoords;
	}
	public int getX() {
		return Xcoords;
	}
	public int getY() {
		return Ycoords;
	}
	public ImageIcon getIcon() {
		return imgIcon;
	}
	public static int getSpaceShipWidth() {
		return SpaceShipWidth;
	}
	public static int getSpaceShipHeight() {
		return SpaceShipHeight;
	}
	//ffire
	public void fire(int x,int y) {
		laserLinkedList.add(laserLinkedList.size(),new Laser(x,y));
	}
}