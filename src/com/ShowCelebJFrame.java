package com;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShowCelebJFrame { 
	private static BufferedImage image; 
	private static JFrame frame = new JFrame();;
	
	public static void setupShowCelebJFrame(String i) {
		try { 
			image = ImageIO.read(new File(i)); // gets the image of celebrities 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.setName("Matches");
		frame.setResizable(false);
		frame.setPreferredSize(new Dimension(750, 500));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void show() {
		JLabel imageicon = new JLabel(new ImageIcon(image));
		JPanel temp = new JPanel();
		temp.add(imageicon);
		temp.setVisible(true);
		frame.add(temp);
		frame.pack();
		frame.setVisible(true);
	}

}
