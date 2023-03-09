package gui;

import java.awt.*;
import javax.swing.*;

public class SpaceFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private SelectionScreen select = new SelectionScreen();
	private GamePlayScreen gameplay = new GamePlayScreen();
	private static CardLayout clayout= new CardLayout();
	static Container cards = new Container();
	
	public SpaceFrame(int CosmosWidth,int CosmosHeight){
		this.addKeyListener(gameplay);
		cards.setLayout(clayout);
		this.setTitle("Space");
		cards.add(select,"1");
		cards.add(gameplay,"2");
		
		clayout.show(cards, "1");
		
		this.add(cards);
		this.setFocusable(true);
		this.setSize(CosmosWidth,CosmosHeight);
		this.setTitle("SpaceFrame");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	static void changeCard(int x) {
		clayout.show(cards,String.valueOf(x));
	}
}
