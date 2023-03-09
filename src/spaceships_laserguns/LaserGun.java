package spaceships_laserguns;
import java.awt.Color;
import java.util.LinkedList;
public interface LaserGun {
	public Color LaserColor=null;
	public LinkedList<Laser> laserLinkedList=new LinkedList<Laser>();
	public void fire(int x,int y);
	
}
