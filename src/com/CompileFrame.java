package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CompileFrame extends JPanel {
	// button for title and buttons for generating matches and previous matches
	private JLabel title;
	private JButton prevMatches;
	private JButton genMatches;
	
	public CompileFrame() { // dimension of frame 
		this.setPreferredSize(new Dimension(650,400));
		
		init();
		add();
	}
	// Set gui for initial page 
	public void init() {
		this.setLayout(new BorderLayout());
		
		// message of screen
		title = new JLabel("Welcome to Celeberity Match Maker");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setForeground(Color.BLACK);
		// message of screen
		prevMatches = new JButton("Previous Matches"); // buttons created
		genMatches = new JButton("Generate Match");
		//set font, bold, and size
		prevMatches.setFont(new Font("Arial", Font.BOLD, 16));
		genMatches.setFont(new Font("Arial", Font.BOLD, 16));
		
		prevMatches.addActionListener(new ButtonListen());
		genMatches.addActionListener(new ButtonListen());
	}
	
	public void add() { // add function for adding various javafx components 
		JPanel tempPS = new JPanel(); // add jpanel
		tempPS.setLayout(new BorderLayout()); // add tempPSpanel
		
		this.add(tempPS, BorderLayout.PAGE_START);
		tempPS.add(title, BorderLayout.BEFORE_LINE_BEGINS);
		
		JLabel chooseG = new JLabel("Generate Match!!!!!");
		chooseG.setFont(new Font("Arial", Font.BOLD, 16));
		chooseG.setForeground(Color.DARK_GRAY);
		
		JPanel tempC = new JPanel();
		tempC.setBackground(Color.LIGHT_GRAY);
		this.add(tempC, BorderLayout.CENTER);
		
		JPanel tempPE = new JPanel();
		tempPE.setBackground(Color.LIGHT_GRAY);
		
		tempC.add(chooseG);
		
		this.add(tempPE, BorderLayout.PAGE_END);
		
		tempPE.add(prevMatches);
		tempPE.add(genMatches);
		
		this.setVisible(true);
	}
	
	private class ButtonListen implements ActionListener { // private class for our custom 
		// panel implements the ActionListener interface to allow for customer click 
		// handler for our buttons
		
		@Override // demanded method by the interface in order to specify functionality of the click
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == genMatches) {
				System.out.println("Generated");
				try {
					MatchingSoftware.generateMatches(DataAbout.gender, DataAbout.year, DataAbout.iOne, DataAbout.iTwo, DataAbout.iThree);
				} catch (ParseException ex) {
					ex.printStackTrace();
				}
			}else if(e.getSource() == prevMatches) {
				if(!MatchingSoftware.oldMatches.isEmpty()) {
					//JOptionPane.showMessageDialog(CompileFrame.this, MatchingSoftware.oldMatches.pop().name);
					ShowCelebJFrame.setupShowCelebJFrame(MatchingSoftware.oldMatches.pop().image);
					ShowCelebJFrame.show();
				}
			}
		}
	}
}
