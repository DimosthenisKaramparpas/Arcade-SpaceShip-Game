package gui;
import spaceships.*;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import	mainPacket.MainClass;

public class GamePlayScreen extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static SpaceShip user;
	private Boolean gameover=false;
	private static SpaceShipENEMY enemy = new SpaceShipENEMY();
	GamePlayScreen(){
		addKeyListener(this);
		this.setBackground(Color.black);
		this.setVisible(true);
		this.setFocusable(true);
		createDaemon(); 
	}
	
	
	@Override
	public void keyPressed (KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_UP) {
			user.moveUP();
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			user.moveDOWN();
		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			user.moveLEFT();
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			user.moveRIGHT();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)	user.fire(user.getX(), user.getY());
		if (e.getKeyCode() == KeyEvent.VK_B && !gameover)	SpaceFrame.changeCard(1);
		//this.repaint();
	 }
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font(" Arial ",Font.PLAIN,22)) ;
		enemy.huntUser(user);
		user.getIcon().paintIcon(this,g,user.getX(),user.getY());
		enemy.getIcon().paintIcon(this,g,enemy.getX(),enemy.getY());
		g.setColor(Color.white);
		g.drawString("Your Lifes:"+ user.lifes, 0,550);
		g.drawString("Enemy Lifes:"+ enemy.lifes, 0, 20);
		if(enemy.lifes==0 || user.lifes==0) {
			g.setColor(Color.white);
			g.drawString("GAME OVER!", 200, 300);
		}
		for(int i=0;i<user.laserLinkedList.size();i++) {
			g.setColor(user.laserColor);
			//g.drawLine(enemy.getX()+20,enemy.getY()+90,enemy.getX()+80,enemy.getY()+90);		//*** HIT ***\\
			//g.drawLine(enemy.getX()+20,enemy.getY()+10,enemy.getX()+20,enemy.getY()+90);		//***	BOX	***\\
			g.drawLine(user.laserLinkedList.get(i).x, user.laserLinkedList.get(i).y, user.laserLinkedList.get(i).x, user.laserLinkedList.get(i).y-8);
			user.laserLinkedList.get(i).y-=5;
			if(user.laserLinkedList.get(i).y>(enemy.getY()+10)&&user.laserLinkedList.get(i).y<(enemy.getY()+90) && user.laserLinkedList.get(i).x<(enemy.getX()+80) && user.laserLinkedList.get(i).x>(enemy.getX()+20)) {
				enemy.lifes--;
				user.laserLinkedList.remove(i);
				if(enemy.lifes==0) {
					repaint();
					gameover=true;
				}
			}
		}
		for(int i=0;i<enemy.enemyLaserLinkedList.size();i++) {
			g.setColor(enemy.laserColor);
			g.drawLine(enemy.enemyLaserLinkedList.get(i).x, enemy.enemyLaserLinkedList.get(i).y, enemy.enemyLaserLinkedList.get(i).x,enemy.enemyLaserLinkedList.get(i).y-8);
			enemy.enemyLaserLinkedList.get(i).y+=5;
			//g.drawLine(user.getX()+20-user.sizediff,user.getY()+10,user.getX()+80,user.getY()+10);							//****	HIT ***\\
			//g.drawLine(user.getX()+20-user.sizediff,user.getY()+10,user.getX()+20-user.sizediff,user.getY()+90);			//*** BOX	***\\
			if(enemy.enemyLaserLinkedList.get(i).y>(user.getY()+10)&&enemy.enemyLaserLinkedList.get(i).y<(user.getY()+90) && enemy.enemyLaserLinkedList.get(i).x<(user.getX()+80-user.sizediff) && enemy.enemyLaserLinkedList.get(i).x>(user.getX()+20-user.sizediff)) {
				user.lifes--;
				enemy.enemyLaserLinkedList.remove(i);
				if(user.lifes==0) {
					repaint();
					gameover=true;
				}
			}
		}
	}
	static void setSpaceShip(SpaceShip s) {
		user = s;
	}
	private void createDaemon() {
		Timer timer = new Timer();
		TimerTask task = new monitorDeamonGame();
		timer.schedule(task, 16,16);
	}
	class monitorDeamonGame extends TimerTask{
		public void run() {
				if(!gameover) {
				repaint();
				}
			
		}
	}
}