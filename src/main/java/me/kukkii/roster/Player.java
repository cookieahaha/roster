// $Id$
package me.kukkii.roster;

public class Player {
	
	private ShortName name;
	private String number;
	private String position;
	private double battingAverage;
	private String hometown;
	private String highSchool;
	
	// constructer
	public Player(ShortName name, String number, String position, double battingAverage, String hometown, String highSchool){
		this.name = name;
		this.number = number;
		this.position = position;
		this.battingAverage = battingAverage;
		this.hometown = hometown;
		this.highSchool = highSchool;
	}
		
	// gets name
	public ShortName getName(){
		return name;
	}
	
	// gets number
	public String getNumber(){
		return number;
	}
	
	// gets position
	public String getPosition(){
		return position;
	}
	
	// gets batting average
	public double getBattingAverage(){
		return battingAverage;
	}

	// gets hometown
	public String getHomeTown(){
		return hometown;
	}

	// gets high school
	public String getHighSchool(){
		return highSchool;
	}
	
	// shows player's info
	public void showInfo(){
		System.out.println("name: " + name.getFirst() + " " + name.getLast() + " " + "number: " + number + " " + "position: " + position + " " + "batting average: " + battingAverage + "% " + "hometown: " + hometown + " " + "high school: " + highSchool);
	}
	
}

