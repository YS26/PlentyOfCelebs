package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class YearSelectionFrame extends JPanel { // extends J panel
	private JButton year1950; // buttons for years to select the year you want your match to be from
	private JButton year1960;
	private JButton year1975;
	private JButton year1990;
	private JLabel title;
	private int year;

	public YearSelectionFrame() {
		this.setPreferredSize(new Dimension(650,400)); // set dimensions 
		year = 1950;
		System.out.println(year);
		init();
		add();
	}
	
	public int getYear() { 
		return year;
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		//  set title of the celebrity dating app
		title = new JLabel("Welcome to PlentyOfCelebs");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setForeground(Color.BLACK);
		
		year1950 = new JButton("1950");
		year1960 = new JButton("1960");
		year1975 = new JButton("1975");
		year1990 = new JButton("1990");
		
		year1950.setFont(new Font("Arial", Font.BOLD, 16));
		year1960.setFont(new Font("Arial", Font.PLAIN, 12));
		year1975.setFont(new Font("Arial", Font.PLAIN, 12));
		year1990.setFont(new Font("Arial", Font.PLAIN, 12));
		
		year1950.addActionListener(new ButtonListen(year1950));
		year1960.addActionListener(new ButtonListen(year1960));
		year1975.addActionListener(new ButtonListen(year1975));
		year1990.addActionListener(new ButtonListen(year1990));
	}
	
	public void add() { // add method to add javafx objects
		JPanel tempPS = new JPanel();
		tempPS.setLayout(new BorderLayout());
		
		this.add(tempPS, BorderLayout.PAGE_START);
		tempPS.add(title, BorderLayout.BEFORE_LINE_BEGINS);
		
		JLabel chooseG = new JLabel("Choose Your Year!!!");
		chooseG.setFont(new Font("Arial", Font.BOLD, 16));
		chooseG.setForeground(Color.DARK_GRAY);
		
		JPanel tempC = new JPanel();
		tempC.setBackground(Color.LIGHT_GRAY);
		this.add(tempC, BorderLayout.CENTER);
		
		JPanel tempPE = new JPanel();
		tempPE.setBackground(Color.LIGHT_GRAY);
		
		tempC.add(chooseG);
		
		this.add(tempPE, BorderLayout.PAGE_END);
		
		tempPE.add(year1950);
		tempPE.add(year1960);
		tempPE.add(year1975);
		tempPE.add(year1990);
		
		this.setVisible(true);
	}
	
	private class ButtonListen implements ActionListener { 
		// ActionListener class to encapsulate our click handler
		private JButton button;
		
		public ButtonListen(JButton b) {
			button = b;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			clear();
			button.setFont(new Font("Arial", Font.BOLD, 16));
			
			if(e.getSource() == year1950) {
				year = 1950;
				System.out.println(year);
			}else if(e.getSource() == year1960) {
				year = 1960;
				System.out.println(year);
			}else if(e.getSource() == year1975) {
				year = 1975;
				System.out.println(year);
			}else if(e.getSource() == year1990) {
				year = 1990;
				System.out.println(year);
			}
		}
		
		public void clear() {
			year1950.setFont(new Font("Arial", Font.PLAIN, 12));
			year1960.setFont(new Font("Arial", Font.PLAIN, 12));
			year1975.setFont(new Font("Arial", Font.PLAIN, 12));
			year1990.setFont(new Font("Arial", Font.PLAIN, 12));
		}
	}
}
