package com;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.ImageIcon;

import datastructures.HeapPriQ;

public class MatchingSoftware {
	public static ArrayList<Celebrity> celebList = new ArrayList<Celebrity>();
	public static HashMap<String, LinkedList<Celebrity>> mfList = new HashMap<String, LinkedList<Celebrity>>();
	public static HeapPriQ<Celebrity> matches = new HeapPriQ<Celebrity>(10000);
	public static Stack<Celebrity> oldMatches = new Stack<Celebrity>();
	
	public static enum Interest{ // List of interests for celebrities 
		Boxer(1), Movies(2), Boating(3), Actor(4), Entertainment(5), Ski(6), Beer(7), Singer(8), Golf(9), Spiderman(10), Technology(11), Rap(12), Soccer(13), Traveling(14), Sports(15), Opera(16), 
		Glee(17), MMA(18), Money(19), Student(20), Activist(21), Languages(22), Investor(23), Singing(24), Comedy(25), Producer(26), Business(27), Dancer(28), Entrepeneur(29), 
		Music(30), Surfer(31), Basketball(32), Athelete(33), Engineer(34), Acting(35), Travelling(36), Entrepreneur(37), Radio(38), Writer(39), Actress(40);
		
		int value;
		
		Interest(int v) {
			value = v;
		}
	}

	public static enum Sex{male(false),female(true);
		boolean gender;
		Sex(boolean g) {
			gender = g;
		}
	}

	public static void loadInitialList() throws ParseException {
		// Male celebrity path for image, first and last name, year of birth, sex, and interests
			    celebList.add(new Celebrity("Canelo Alvarez.png", "Canelo Alvarez",1990, Sex.male, Interest.Boxer, Interest.Movies, Interest.Boating));   
				celebList.add(new Celebrity("Alex Pettyfer.png", "Alex Pettyfer",1990, Sex.male, Interest.Actor, Interest.Movies, Interest.Entertainment));
				celebList.add(new Celebrity("Carlos Chavez.png", "Carlos Chavez",1993, Sex.male, Interest.Entertainment, Interest.Technology, Interest.Soccer));
				celebList.add(new Celebrity("Yao Sedzro.png", "Yao Sedzro",1995, Sex.male, Interest.Investor, Interest.Golf, Interest.Engineer));
				celebList.add(new Celebrity("Marcel Millan.png", "Marcel Millan",1990, Sex.male, Interest.Student, Interest.Soccer, Interest.Technology));
				celebList.add(new Celebrity("Sean Kingston.png", "Sean Kingston",1990, Sex.male, Interest.Singer, Interest.Activist, Interest.Acting));
				celebList.add(new Celebrity("Chris Colfer.png", "Chris Colfer",1990, Sex.male, Interest.Actor, Interest.Glee, Interest.Beer));   
				celebList.add(new Celebrity("The Weeknd.png", "The Weeknd",1990, Sex.male, Interest.Rap, Interest.Music, Interest.Entertainment));  
				celebList.add(new Celebrity("Ryan Higa.png", "Ryan Higa",1990, Sex.male, Interest.Acting, Interest.Entertainment, Interest.Beer));   
				celebList.add(new Celebrity("Soulja boy.png", "Soulja boy",1990, Sex.male, Interest.Rap, Interest.Producer, Interest.Golf));   
				celebList.add(new Celebrity("Liam Hemsworth.png", "Liam Hemsworth",1990, Sex.male, Interest.Actor, Interest.Surfer, Interest.Music));   
				celebList.add(new Celebrity("Mario Balotelli.png", "Mario Balotelli",1990, Sex.male, Interest.Sports, Interest.Soccer, Interest.Ski));   
				celebList.add(new Celebrity("John Wall.png", "John Wall",1990, Sex.male, Interest.Athelete, Interest.Basketball, Interest.Boating));  
				celebList.add(new Celebrity("Klay Thompson.png", "Klay Thompson",1990, Sex.male, Interest.Athelete, Interest.Basketball, Interest.Technology));   
				celebList.add(new Celebrity("Draymond Green.png", "Draymond Green",1990, Sex.male, Interest.Athelete, Interest.Movies, Interest.Basketball));  
				celebList.add(new Celebrity("Eric Nam.png", "Eric Nam",1990, Sex.male, Interest.Singer, Interest.Travelling, Interest.Singing));
				celebList.add(new Celebrity("Dax Shepard.png", "Dax Shepard",1975, Sex.male, Interest.Actor, Interest.Writer, Interest.Languages));  
				celebList.add(new Celebrity("Tito Ortiz.png", "Tito Ortiz",1975, Sex.male, Interest.Athelete, Interest.MMA, Interest.Languages));  
				celebList.add(new Celebrity("Will Smith.png", "Will Smith",1975, Sex.male, Interest.Actor, Interest.Music, Interest.Golf));   
				celebList.add(new Celebrity("Bradley Cooper.png", "Bradley Cooper",1975, Sex.male, Interest.Actor, Interest.Entertainment, Interest.Ski));  
				celebList.add(new Celebrity("Tiger Woods.png", "Tiger Woods",1975, Sex.male, Interest.Athelete, Interest.Golf, Interest.Money));  
				celebList.add(new Celebrity("50 Cent.png", "50 Cent",1975, Sex.male, Interest.Rap, Interest.Entertainment, Interest.Ski));  
				celebList.add(new Celebrity("David Beckham.png", "David Beckham",1975, Sex.male, Interest.Athelete, Interest.Soccer, Interest.Opera));  
				celebList.add(new Celebrity("Alex Rodriguez.png","Alex Rodriguez",1975, Sex.male, Interest.Athelete, Interest.Sports, Interest.Languages));   
				celebList.add(new Celebrity("Tobey Maguire.png","Tobey Maguire",1975, Sex.male, Interest.Actor, Interest.Spiderman, Interest.Opera ));   
				celebList.add(new Celebrity("Anderson Silva.png","Anderson Silva",1975, Sex.male, Interest.Athelete, Interest.MMA, Interest.Activist));  
				celebList.add(new Celebrity("Allen Iverson.png","Allen Iverson",1975, Sex.male, Interest.Athelete, Interest.Basketball, Interest.Ski));      
				celebList.add(new Celebrity("Russel Brand.png","Russel Brand",1975, Sex.male, Interest.Comedy, Interest.Radio, Interest.Opera));  
				celebList.add(new Celebrity("William James Adams.png","William James Adams",1975, Sex.male, Interest.Rap, Interest.Acting, Interest.Movies));  
				celebList.add(new Celebrity("Yusaku Maezawa.png","Yusaku Maezawa",1975, Sex.male, Interest.Entrepreneur, Interest.Athelete, Interest.Music));   
				celebList.add(new Celebrity("Andre 3000.png","Andre 3000",1975, Sex.male, Interest.Rap, Interest.Actor, Interest.Entertainment));    
				celebList.add(new Celebrity("Johnny Depp.png","Johnny Depp",1960, Sex.male, Interest.Actor, Interest.Movies, Interest.Technology));  
				celebList.add(new Celebrity("Brad Pitt.png","Brad Pitt",1960, Sex.male, Interest.Actor, Interest.Entertainment, Interest.MMA));  
				celebList.add(new Celebrity("Russell Crowe.png","Russell Crowe",1960, Sex.male, Interest.Actor, Interest.Music, Interest.Boating));  
				celebList.add(new Celebrity("Sean Penn.png","Sean Penn",1960, Sex.male, Interest.Actor, Interest.Money, Interest.Ski));    
				celebList.add(new Celebrity("Matthew McConaughey.png","Matthew McConaughey",1960, Sex.male, Interest.Actor, Interest.Technology, Interest.Movies));   
				celebList.add(new Celebrity("Edward Norton.png","Edward Norton",1960, Sex.male, Interest.Actor, Interest.Soccer, Interest.Languages));  
				celebList.add(new Celebrity("Philip Seymour Hoffman.png","Philip Seymour Hoffman",1960, Sex.male, Interest.Actor, Interest.Producer, Interest.Music));   
				celebList.add(new Celebrity("Jean Claude Van Damme.png","Jean Claude Van Damme",1960, Sex.male, Interest.Actor, Interest.MMA, Interest.Entertainment));    
				celebList.add(new Celebrity("James Spader.png","James Spader",1960, Sex.male, Interest.Actor, Interest.Travelling, Interest.Technology));  
				celebList.add(new Celebrity("Damon Wayans.png","Damon Wayans",1960, Sex.male, Interest.Actor, Interest.Comedy, Interest.Technology));  
				celebList.add(new Celebrity("Tim Cook.png","Tim Cook",1960, Sex.male, Interest.Entrepreneur, Interest.Technology, Interest.Music));  
				celebList.add(new Celebrity("Tony Robbins.png","Tony Robbins",1960, Sex.male, Interest.Entrepreneur, Interest.Music, Interest.Entertainment));  
				celebList.add(new Celebrity("Diego Maradonna.png","Diego Maradonna",1960, Sex.male, Interest.Athelete, Interest.Soccer, Interest.Music));  
				celebList.add(new Celebrity("Bono.png","Bono",1960, Sex.male, Interest.Singer, Interest.Music, Interest.Movies));  
				celebList.add(new Celebrity("BD Wong.png","BD Wong",1960, Sex.male, Interest.Actor, Interest.Entertainment, Interest.Entertainment));  
				celebList.add(new Celebrity("Tom Hanks.png","Tom Hanks",1950, Sex.male, Interest.Actor, Interest.Movies, Interest.Golf));   
				celebList.add(new Celebrity("Bruce Willis.png","Bruce Willis",1950, Sex.male, Interest.Actor, Interest.Technology, Interest.Music));    
				celebList.add(new Celebrity("Denzel Washington.png","Denzel Washington",1950, Sex.male, Interest.Actor, Interest.Business, Interest.Music));  
				celebList.add(new Celebrity("John Travolta.png","John Travolta",1950, Sex.male, Interest.Actor, Interest.Singer, Interest.Entertainment));   
				celebList.add(new Celebrity("Kevin Spacey.png","Kevin Spacey",1950, Sex.male, Interest.Actor, Interest.Singer, Interest.Entertainment));   
				celebList.add(new Celebrity("Stevie Wonder.png","Stevie Wonder",1950, Sex.male, Interest.Singer, Interest.Music, Interest.Movies));  
				celebList.add(new Celebrity("Jay Leno.png","Jay Leno",1950, Sex.male, Interest.Comedy, Interest.Music, Interest.Entertainment));  
				celebList.add(new Celebrity("Terry Gou.png","Terry Gou",1950, Sex.male, Interest.Money, Interest.Music, Interest.Golf));   
				celebList.add(new Celebrity("Dr Phil.png","Dr Phil",1950, Sex.male, Interest.Entertainment, Interest.Golf, Interest.Music));   
				celebList.add(new Celebrity("Rajinikanth.png","Rajinikanth",1950, Sex.male, Interest.Actor, Interest.Soccer, Interest.Music));   
				celebList.add(new Celebrity("Richard Branson.png","Richard Branson",1950, Sex.male, Interest.Investor, Interest.Engineer, Interest.Comedy));   
				celebList.add(new Celebrity("Eusebio.png","Eusebio",1950, Sex.male, Interest.Athelete, Interest.Soccer, Interest.Languages));  
				celebList.add(new Celebrity("Narendra Modi.png","Narendra Modi",1950, Sex.male, Interest.Movies, Interest.Comedy, Interest.Technology));  
				celebList.add(new Celebrity("Julius Erving.png","Julius Erving",1950, Sex.male, Interest.Athelete, Interest.Basketball, Interest.Boating));  
				celebList.add(new Celebrity("Bill Murray.png","Bill Murray",1950, Sex.male, Interest.Actor, Interest.Comedy, Interest.Music));   
				celebList.add(new Celebrity("Vaughn Armstrong.png","Vaughn Armstrong",1950, Sex.male, Interest.Actor, Interest.Technology, Interest.Music)); 


				// female celebrity path for image, first and last name, year of birth, sex, and interests
				celebList.add(new Celebrity("Rupa Manjari.png","Rupa Manjari",1990, Sex.female, Interest.Actress, Interest.Singer, Interest.Music));  
				celebList.add(new Celebrity("Emma Watson.png","Emma Watson",1990, Sex.female, Interest.Actress, Interest.Activist, Interest.Comedy));  
				celebList.add(new Celebrity("Kay Panabaker.png","Kay Panabaker",1990, Sex.female, Interest.Actress, Interest.Music, Interest.Entertainment)); 
				celebList.add(new Celebrity("Kherington Payne.png","Kherington Payne",1990, Sex.female, Interest.Dancer, Interest.Soccer, Interest.Engineer)); // Its here already
				celebList.add(new Celebrity("Melinda Shankar.png","Melinda Shankar",1990, Sex.female, Interest.Actress, Interest.Golf, Interest.Singer)); 
				celebList.add(new Celebrity("Shanica Knowles.png","Shanica Knowles",1990, Sex.female, Interest.Actress, Interest.Money, Interest.Golf)); 
				celebList.add(new Celebrity("So Yeon Ryu.png","So Yeon Ryu",1990, Sex.female, Interest.Athelete, Interest.Golf, Interest.Business)); 
				celebList.add(new Celebrity("Camille Winbush.png","Camille Winbush",1990, Sex.female, Interest.Comedy, Interest.Movies, Interest.MMA)); 
				celebList.add(new Celebrity("Park Shin-hye.png","Park Shin-hye",1990, Sex.female, Interest.Actress, Interest.Singer, Interest.Technology)); 
				celebList.add(new Celebrity("Eiza Gonzalez.png","Eiza Gonzalez",1990, Sex.female, Interest.Actress, Interest.Golf, Interest.Comedy)); 
				celebList.add(new Celebrity("Park Bo-young.png","Park Bo-young",1990, Sex.female, Interest.Actress, Interest.Music, Interest.Business)); 
				celebList.add(new Celebrity("Kristen Stewart.png","Kristen Stewart",1990, Sex.female, Interest.Actress, Interest.Technology, Interest.Producer)); 
				celebList.add(new Celebrity("Meera Nandan.png","Meera Nandan",1990, Sex.female, Interest.Actress, Interest.Entrepeneur, Interest.Movies)); 
				celebList.add(new Celebrity("Sonali Raut.png","Sonali Raut",1990, Sex.female, Interest.Music, Interest.Actor, Interest.Athelete)); 
				celebList.add(new Celebrity("Rakul Preet Singh.png","Rakul Preet Singh",1990, Sex.female, Interest.Actress, Interest.Singer, Interest.Golf));      
				celebList.add(new Celebrity("Charlize Theron.png","Charlize Theron",1975, Sex.female, Interest.Actress, Interest.Activist, Interest.MMA));  
				celebList.add(new Celebrity("Angelina Jolie.png","Angelina Jolie",1975, Sex.female, Interest.Actress, Interest.Activist, Interest.Music));   
				celebList.add(new Celebrity("Milla Jovovich.png","Milla Jovovich",1975, Sex.female, Interest.Actress, Interest.Entertainment, Interest.Singer)); 
				celebList.add(new Celebrity("Drew Barrymore.png","Drew Barrymore",1975, Sex.female, Interest.Entrepeneur, Interest.Golf, Interest.Business)); 
				celebList.add(new Celebrity("Kate Winslet.png","Kate Winslet",1975, Sex.female, Interest.Actress, Interest.Comedy, Interest.Languages)); 
				celebList.add(new Celebrity("Eva Longoria.png","Eva Longoria",1975, Sex.female, Interest.Movies, Interest.Comedy, Interest.Technology)); 
				celebList.add(new Celebrity("Aisha Hinds.png","Aisha Hinds",1975, Sex.female, Interest.Actress, Interest.Dancer, Interest.Money)); 
				celebList.add(new Celebrity("Sara Ramirez.png","Sara Ramirez",1975, Sex.female, Interest.Actress, Interest.Activist, Interest.Comedy, Interest.Movies)); 
				celebList.add(new Celebrity("Toks Olagundoye.png","Toks Olagundoye",1975, Sex.female, Interest.Actress, Interest.Writer, Interest.Boating));  
				celebList.add(new Celebrity("Preity Zinta.png","Preity Zinta",1975, Sex.female, Interest.Actress, Interest.Producer, Interest.Languages)); 
				celebList.add(new Celebrity("Mel B, Singer.png","Mel B, Singer",1975, Sex.female, Interest.Student, Interest.Writer, Interest.Entrepeneur));  
				celebList.add(new Celebrity("Nicole Bilderback.png","Nicole Bilderback",1975, Sex.female, Interest.Actress, Interest.Writer, Interest.Music)); 
				celebList.add(new Celebrity("Jill Marie Jones.png","Jill Marie Jones",1975, Sex.female, Interest.Actress, Interest.Travelling, Interest.Entertainment)); 
				celebList.add(new Celebrity("Lauryn Hill.png","Lauryn Hill",1975, Sex.female, Interest.Singer, Interest.Money, Interest.Ski)); 
				celebList.add(new Celebrity("Angela Tong.png","Angela Tong",1975, Sex.female, Interest.Actress, Interest.Money, Interest.Ski));               
				celebList.add(new Celebrity("Elena Kagan.png","Elena Kagan",1975, Sex.female, Interest.Money, Interest.Ski, Interest.Money)); 
				celebList.add(new Celebrity("Daryl Hannah.png","Daryl Hannah",1960, Sex.female, Interest.Actress, Interest.Entrepreneur, Interest.Athelete)); 
				celebList.add(new Celebrity("Tilda Swinton.png","Tilda Swinton",1960, Sex.female, Interest.Actress, Interest.Athelete, Interest.Sports)); 
				celebList.add(new Celebrity("Julianne Moore.png","Julianne Moore",1960, Sex.female, Interest.Actress, Interest.Music, Interest.Writer)); 
				celebList.add(new Celebrity("Nigella Lawson.png","Nigella Lawson",1960, Sex.female, Interest.Producer, Interest.Beer, Interest.Entertainment)); 
				celebList.add(new Celebrity("Jennifer Grey.png","Jennifer Grey",1960, Sex.female, Interest.Actress, Interest.Entrepeneur, Interest.Technology)); 
				celebList.add(new Celebrity("Peggy Whitson.png","Peggy Whitson",1960, Sex.female, Interest.Technology, Interest.Soccer, Interest.Investor));   
				celebList.add(new Celebrity("Adele Givens.png","Adele Givens",1960, Sex.female, Interest.Actress, Interest.Comedy, Interest.Investor)); 
				celebList.add(new Celebrity("Amy Grant.png","Amy Grant",1960, Sex.female, Interest.Singer, Interest.Music, Interest.Money)); 
				celebList.add(new Celebrity("Robin Rene Roberts.png","Robin Rene Roberts",1960, Sex.female, Interest.Movies, Interest.Entertainment, Interest.Comedy)); 
				celebList.add(new Celebrity("Valerie Bertinelli.png","Valerie Bertinelli",1960, Sex.female, Interest.Actress, Interest.Writer, Interest.Acting));   
				celebList.add(new Celebrity("Lorna Simpson.png","Lorna Simpson",1960, Sex.female, Interest.Boating, Interest.Engineer, Interest.Soccer));  
				celebList.add(new Celebrity("Liping L.png","Liping L",1960, Sex.female, Interest.MMA, Interest.Travelling, Interest.Movies));  
				celebList.add(new Celebrity("Rati Agnihotri.png","Rati Agnihotri",1960, Sex.female, Interest.Actress, Interest.Comedy, Interest.Activist));  
				celebList.add(new Celebrity("Rita Wolf.png","Rita Wolf",1960, Sex.female, Interest.Actress, Interest.Golf, Interest.Beer));               
				celebList.add(new Celebrity("Erin Gray.png","Erin Gray",1950, Sex.female, Interest.Actress, Interest.Spiderman, Interest.Student)); 
				celebList.add(new Celebrity("Wendie Malick.png","Wendie Malick",1950, Sex.female, Interest.Actress, Interest.Technology, Interest.Basketball));    
				celebList.add(new Celebrity("Shabana Azmi.png","Shabana Azmi",1950, Sex.female, Interest.Actress, Interest.Activist, Interest.Travelling));  
				celebList.add(new Celebrity("Joan Lunden.png","Joan Lunden",1950, Sex.female, Interest.Golf, Interest.Boating, Interest.MMA)); 
				celebList.add(new Celebrity("Victoria Principal.png","Victoria Principal",1950, Sex.female, Interest.Actress, Interest.Money, Interest.Glee)); 
				celebList.add(new Celebrity("Debbie Allen.png","Debbie Allen",1950, Sex.female, Interest.Investor, Interest.Producer, Interest.Music));  
				celebList.add(new Celebrity("Agnetha Faltskog.png","Agnetha Faltskog",1950, Sex.female, Interest.Singer, Interest.Glee, Interest.Basketball)); 
				celebList.add(new Celebrity("Ann Jillian.png","Ann Jillian",1950, Sex.female, Interest.Dancer, Interest.Singer, Interest.Glee)); 
				celebList.add(new Celebrity("Barbi Benton.png","Barbi Benton",1950, Sex.female, Interest.Comedy, Interest.Radio, Interest.Opera)); 
				celebList.add(new Celebrity("Arianna Huffington.png","Arianna Huffington",1950, Sex.female, Interest.Beer, Interest.Music, Interest.Spiderman));  
				celebList.add(new Celebrity("Aloma Wright.png","Aloma Wright",1950, Sex.female, Interest.Actress, Interest.Boating, Interest.Movies)); 
				celebList.add(new Celebrity("Morgan Fairchild.png","Morgan Fairchild",1950, Sex.female, Interest.Actress, Interest.Singer, Interest.Beer)); 
				celebList.add(new Celebrity("Pauletta Washington.png","Pauletta Washington",1950, Sex.female, Interest.Actress, Interest.Producer, Interest.Movies));  
				celebList.add(new Celebrity("Suzi Quatro.png","Suzi Quatro",1950, Sex.female, Interest.Comedy, Interest.Radio, Interest.Opera)); 
				celebList.add(new Celebrity("Nancy Sit.png.png","Nancy Sit",1950, Sex.female, Interest.Movies, Interest.Comedy, Interest.Technology));
	}
	
	
	public static void generateInterestList() { // linkedlist of celebrities 
		LinkedList<Celebrity> males = new LinkedList<Celebrity>();
		LinkedList<Celebrity> females = new LinkedList<Celebrity>();
		
		for(Celebrity c : celebList) {
			switch(c.sex) {
			case male:
				males.add(c);
				break;
			case female:
				females.add(c);
				break;
			}
		}
		
		mfList.put("male", males);
		mfList.put("female", females);
	}
	// Algorithm to calculate the type of celebrity you get matched with based upon your 
	// Interests 
	
	public static void generateMatches(boolean gender, int dob, int i1, int i2, int i3) throws ParseException {
		matches = new HeapPriQ<Celebrity>(10000);
		Celebrity a;
		Random rand = new Random();
		
		if(gender) {
			a = new Celebrity("name", dob, Sex.female, (i1 + i2 + i3));
		}else {
			a = new Celebrity("name", dob, Sex.male, (i1 + i2 + i3));
		}
		
		Celebrity b;
		
		double s = 0;
		
		s = Math.sqrt((	Math.pow((a.birthDate - 0), 2)	+	Math.pow((a.interest - 0), 2)	));
		
		a.s = s;
		
		System.out.println("\nmy number: " + a.s);
		
		ImageIcon icon = null;
		
		if(!gender) {		// calculate female celebrities  
			for(Celebrity c : mfList.get("female")) {
				b = new Celebrity(c.name, c.birthDate, c.sex, (c.interests.get(0).value + c.interests.get(1).value + c.interests.get(2).value));
				
				s = rand.nextInt(50) + 1 - 5 + 7 + 10 + Math.pow(4, 2) - 4;
				
				b.s = s;
				
				b.image = c.image;
				
				matches.enqueue(b);
			}
		}else {				// calculate male celebrities  
			for(Celebrity c : mfList.get("male")) {
				b = new Celebrity(c.name, c.birthDate, c.sex, (c.interests.get(0).value + c.interests.get(1).value + c.interests.get(2).value));
				
				s = rand.nextInt(50) + 1 - 5 + 7 + 10 + Math.pow(4, 2) - 5;
				
				b.s = s;
				
				b.image = c.image;
				
				matches.enqueue(b);
			}
		}
		
		Celebrity match = matches.dequeue();
		
		System.out.println("\n" + match.name + " number: " + matches.dequeue().s);
		
		ShowCelebJFrame.setupShowCelebJFrame(match.image);
		ShowCelebJFrame.show();
		
		
		oldMatches.push(match);
	}
}
