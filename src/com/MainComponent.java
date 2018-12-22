package com;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


/*
 * 
 * 
 * DataStructures used
 * 		ArrayList
 * 		LinkedList
 * 		Hashmap
 * 		Piority Queue
 * 		stack
 * 
 * */


public class MainComponent extends JFrame {
	private JButton nextPage;
	private JButton prevPage;
	private JPanel bottomPage;
	private JPanel centerPage;
	private int page;
	
	private static ArrayList<JPanel> pages = new ArrayList<JPanel>();  
	// static arraylist of jpanels initiatlized on line 24 

	public MainComponent() { // constructor 
		//Initial Code for generating the list and seperating them correctly
		try {
			MatchingSoftware.loadInitialList();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		MatchingSoftware.generateInterestList();
	
		// different custom jpanel subclasses
		pages.add(new GenderSelectionFrame());
		pages.add(new YearSelectionFrame());
		pages.add(new InterestSelectionFrame());
		pages.add(new CompileFrame());
		nextPage = new JButton("Next");
		prevPage = new JButton("Back");
		bottomPage = new JPanel();
		centerPage = new JPanel();
		
		// next page button to allow the user to change the page
		nextPage.addActionListener(new ButtonListen());
		prevPage.addActionListener(new ButtonListen());
		
		page = 0;
		
		// calling additional initialization methods 
		initFrame();
		addComponents();
	}
	
	public void initFrame() {
		// setting properties on the MainComponent Jframe 
		this.setName("Match Making");
		this.setResizable(false);
		this.setPreferredSize(new Dimension(750, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.pack();
		this.setVisible(true);
		
		bottomPage = new JPanel();
		bottomPage.setBackground(Color.WHITE);
		bottomPage.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		centerPage.add(pages.get(page));
		
		prevPage.setVisible(false);
	}
	
	public void addComponents() {
		// bottom/center pages to the MainComponent JFrame
		this.add(bottomPage, BorderLayout.PAGE_END);
		this.add(centerPage, BorderLayout.CENTER);
		
		// previous and next pages are added to the bottom page
		bottomPage.add(prevPage);
		bottomPage.add(nextPage);
	}
	
	public static void main(String[] args) {
		new MainComponent();
	}
	
	private class ButtonListen implements ActionListener {  
		// action listener 
		// to reference the arraylist of pages 
		

		@Override
		public void actionPerformed(ActionEvent e) {
			centerPage.removeAll();
			
			if(pages.get(page) instanceof GenderSelectionFrame) {
				DataAbout.gender = ((GenderSelectionFrame)pages.get(page)).isGender();
			}else if(pages.get(page) instanceof YearSelectionFrame) {
				DataAbout.year = ((YearSelectionFrame)pages.get(page)).getYear();
			}else if(pages.get(page) instanceof InterestSelectionFrame) {
				DataAbout.iOne = ((InterestSelectionFrame)pages.get(page)).getInterestOne();
				DataAbout.iTwo = ((InterestSelectionFrame)pages.get(page)).getInterestTwo();
				DataAbout.iThree = ((InterestSelectionFrame)pages.get(page)).getInterestThree();
			}
			
			if(e.getSource() == nextPage) {
				if(page >= 0 && page < 3)	page++;
			}else if(e.getSource() == prevPage) {
				if(page > 0 && page <= 3)	page--;
			}
			
			if(page == 0) {
				prevPage.setVisible(false);
			}else {
				prevPage.setVisible(true);
			}
			
			if(page == 3) {
				nextPage.setVisible(false);
			}else {
				nextPage.setVisible(true);
			}
			
			centerPage.add(pages.get(page));
			MainComponent.this.repaint();
			MainComponent.this.setVisible(true);
			
			System.out.println("Page: " + page);
			
		}
	}
}
