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

public class GenderSelectionFrame extends JPanel {
	private JLabel title;
	private JButton male;
	private JButton female;
	private boolean gender;							// male: false	female: true

	public GenderSelectionFrame() {
		this.setPreferredSize(new Dimension(650,400));
		setGender(false);
		System.out.println("Male");
		init();
		add();
	}
	
	public void init() {
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Welcome to Celeberity Match Maker");
		title.setFont(new Font("Arial", Font.BOLD, 14));
		title.setForeground(Color.BLACK);
		
		male = new JButton("Male");
		female = new JButton("Female");
		
		male.setFont(new Font("Arial", Font.BOLD, 16));
		female.setFont(new Font("Arial", Font.PLAIN, 12));
		
		male.addActionListener(new ButtonListen(male));
		female.addActionListener(new ButtonListen(female));
	}
	
	public void add() {
		JPanel tempPS = new JPanel();
		tempPS.setLayout(new BorderLayout());
		
		this.add(tempPS, BorderLayout.PAGE_START);
		tempPS.add(title, BorderLayout.BEFORE_LINE_BEGINS);
		
		JLabel chooseG = new JLabel("Choose Gender!!!");
		chooseG.setFont(new Font("Arial", Font.BOLD, 16));
		chooseG.setForeground(Color.DARK_GRAY);
		
		JPanel tempC = new JPanel();
		tempC.setBackground(Color.LIGHT_GRAY);
		this.add(tempC, BorderLayout.CENTER);
		
		JPanel tempPE = new JPanel();
		tempPE.setBackground(Color.LIGHT_GRAY);
		
		tempC.add(chooseG);
		
		this.add(tempPE, BorderLayout.PAGE_END);
		
		tempPE.add(male);
		tempPE.add(female);
		
		
		this.setVisible(true);
	}
	
	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	private class ButtonListen implements ActionListener {
		private JButton button;
		
		public ButtonListen(JButton b) {
			button = b;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			clear();
			button.setFont(new Font("Arial", Font.BOLD, 16));
			
			if(e.getSource() == male) {
				setGender(false);
				System.out.println("Male");
			}else {
				System.out.println("Female");
				setGender(true);
			}
			
		}
		
		public void clear() {
			male.setFont(new Font("Arial", Font.PLAIN, 12));
			female.setFont(new Font("Arial", Font.PLAIN, 12));
		}
	}
}