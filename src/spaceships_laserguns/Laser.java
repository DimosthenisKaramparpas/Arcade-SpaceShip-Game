	package spaceships_laserguns;
	import spaceships.SpaceShip;
	
	public class Laser {
		public int x;
		public int y;
		public Laser(int x,int y){
			this.x=x+ SpaceShip.getSpaceShipWidth()/2;
			this.y=y;
		}
	}
