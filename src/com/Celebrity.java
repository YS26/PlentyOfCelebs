package com;

import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import com.MatchingSoftware.Interest;
import com.MatchingSoftware.Sex;

public class Celebrity implements Comparable { // celebrity implements comparable interface 
	String name; // string to hold name of the celebrity 
	int birthDate;// hold year in which celebrity was born 
	ArrayList<Interest> interests; // array list of interests 
	Sex sex; //
	int interest;
	double s;
	String image; // image of celebrity 

		// holds information about the celebrities 
	public Celebrity(String icon, String name,  int birthDate,Sex sex, Interest... arrayInterests) throws ParseException {
		this.name =name;
		this.sex = sex;
		interest = 0;
		image = icon;
		interests = new ArrayList<Interest>();
		for(Interest i: arrayInterests) {
			interests.add(i);
			interest += i.value;
		}
		
		s = 0;
	}
	
	public Celebrity(String name,  int birthDate,Sex sex, int iv) throws ParseException {
		this.name =name;
		this.sex = sex;
		interest = iv;
		s = 0;
	}

	@Override
	public int compareTo(Object p) {
		Celebrity that = (Celebrity) p;
		
		//  compare the two objects via the s field in order to check the differences between them
		// then return value as needed 
		if(this.s - that.s > 0)	{
			return -1;
		}else if(this.s - that.s < 0) { 
			return 1;
		}else {
			return 0;
		}
	}
}