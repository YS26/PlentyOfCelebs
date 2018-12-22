package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InterestSelectionFrame extends JPanel {
	public static String[] interests = {"Boxer","Boating","Actor","Entertainment","Ski","Singer","Golf","Spiderman","Technology","Rap","Soccer","Traveling","Sports","Opera",
			"Glee","MMA","Money","Student","Activist","Languages","Investor","Singing","Comedy","Producer","Business","Dancer","Entrepeneur",
			"Music","Surfer","Basketball","Athelete","Engineer","Movies","Acting","Travelling","Entrepreneur","Radio","Writer","Actress","Beer"};
	//  drop down of interests for interests 
	private JComboBox interestOne;
	private JComboBox interestTwo;
	private JComboBox interestThree;
	private JLabel title;

	public InterestSelectionFrame() { 
		this.setPreferredSize(new Dimension(650,400));
		this.setBackground(Color.GRAY);
		
		init();
		add();
	}
	
	public int getInterestOne() {
		return interestOne.getSelectedIndex() + 1; 
	}
	
	public int getInterestTwo() {
		return interestTwo.getSelectedIndex() + 1;
	}
	
	public int getInterestThree() {
		return interestThree.getSelectedIndex() + 1;
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Welcome to Celeberity Match Maker");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setForeground(Color.BLACK);
		
		interestOne = new JComboBox(interests); // adds list of interests to the jcombobox controls 
		interestOne.setSelectedIndex(0);
		
		interestTwo = new JComboBox(interests);
		interestTwo.setSelectedIndex(0);
		
		interestThree = new JComboBox(interests);
		interestThree.setSelectedIndex(0);
	}
	
	public void add() { // add controls 
		JPanel tempPS = new JPanel();
		tempPS.setLayout(new BorderLayout());
		
		this.add(tempPS, BorderLayout.PAGE_START);
		tempPS.add(title, BorderLayout.BEFORE_LINE_BEGINS);
		
		JLabel chooseG = new JLabel("Choose three Interests!!!");
		chooseG.setFont(new Font("Arial", Font.BOLD, 16));
		chooseG.setForeground(Color.DARK_GRAY);
		
		JPanel tempC = new JPanel();
		tempC.setBackground(Color.LIGHT_GRAY);
		this.add(tempC, BorderLayout.CENTER);
		
		JPanel tempPE = new JPanel();
		tempPE.setBackground(Color.LIGHT_GRAY);
		
		tempC.add(chooseG);
		
		this.add(tempPE, BorderLayout.PAGE_END);
		
		tempPE.add(interestOne);
		tempPE.add(interestTwo);
		tempPE.add(interestThree);
		
		this.setVisible(true);
	}
}