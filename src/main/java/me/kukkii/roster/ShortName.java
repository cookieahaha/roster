// $Id$
package me.kukkii.roster;

/*
 * title:        shortName.java
 * 
 * description: a simple representation of a name for use in
 *              demo programs
 */
public class ShortName {
	private String firstName;
	private String lastName;
	
	//Define the constructors...
	
	public ShortName() {}
	
	public ShortName(String First, String Last)
	{
		firstName = First;
		lastName  = Last;
	}
	
	//Define some mutators....
	
	public void setFirst(String First) { firstName = First; }
	public void setLast(String Last)   { lastName  = Last;  }
	
	//...and some accessors
	
	public String getFirst() { return firstName; }
	public String getLast()  { return lastName;  }
	
}
