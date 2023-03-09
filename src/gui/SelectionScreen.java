package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.*;
import spaceships.*;
public class SelectionScreen extends JPanel{
	private static final long serialVersionUID=1L;
	SelectionScreen(){
		this.setBackground(Color.black);
		this.setLayout(new BorderLayout(500,10));
		JLabel l1=new JLabel("Please Choose Your Spaceship:");
		l1.setForeground(Color.white);
		JPanel SpaceShipPanel=new JPanel();
		SpaceShipPanel.setLayout(new GridLayout(1,5));
		SpaceShipPanel.setBackground(Color.black);
		
		LinkedList <JButton> Buttonlist=new LinkedList<JButton>();
		JButton AButton= new JButton((new SpaceShipALPHA()).getIcon());
		JButton BButton= new JButton((new SpaceShipBETA()).getIcon());
		JButton CButton= new JButton((new SpaceShipGAMA()).getIcon());
		JButton DButton= new JButton((new SpaceShipDELTA()).getIcon());
		JButton ZButton= new JButton((new SpaceShipZERO()).getIcon());
		Buttonlist.add(AButton);
		Buttonlist.add(BButton);
		Buttonlist.add(CButton);
		Buttonlist.add(DButton);
		Buttonlist.add(ZButton);
		for(int i=0;i<Buttonlist.size();i++) {
			Buttonlist.get(i).setContentAreaFilled(false);
			Buttonlist.get(i).setBorderPainted(false);
			SpaceShipPanel.add(Buttonlist.get(i));
		}
		l1.setFont(new Font("a",Font.PLAIN,25));
		this.add(l1,BorderLayout.NORTH);
		this.add(SpaceShipPanel,BorderLayout.CENTER);
		AButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlayScreen.setSpaceShip(new SpaceShipALPHA());
				SpaceFrame.changeCard(2);
			}
		});
		BButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlayScreen.setSpaceShip(new SpaceShipBETA());
				SpaceFrame.changeCard(2);
			}
		});
		CButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlayScreen.setSpaceShip(new SpaceShipGAMA());
				SpaceFrame.changeCard(2);
			}
		});
		DButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlayScreen.setSpaceShip(new SpaceShipDELTA());
				SpaceFrame.changeCard(2);
			}
		});
		ZButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GamePlayScreen.setSpaceShip(new SpaceShipZERO());
				SpaceFrame.changeCard(2);
			}
		});
	}
}
