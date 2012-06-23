// $Id$
package me.kukkii.roster;

import java.util.Scanner;
//import me.kukkii.roster.array.Roster;
import me.kukkii.roster.linkedlist.Roster;

// Copperopolis Chili Beans's roster UI
public class UI {

	// user interface
	public static void main(String[] args) {
		System.out.println("Welcome to Copperopolis Chili Beans's roster");
		Roster list = new Roster();
		while(true){
			System.out.println("Enter a for add, d for delete, s for search, e for show entire roster");
		    Scanner scan = new Scanner(System.in);
		    String str = scan.next();
			if(str.equals("a")){
				System.out.println("Enter a player's firstname");
				String firstname = scan.next();
				System.out.println("Enter a player's lastname");
				String lastname = scan.next();				
				System.out.println("Enter a player's number");
				String number = scan.next();
				System.out.println("Enter a player's position");
				String position = scan.next();
				System.out.println("Enter a player's batting average");
				double battingAverage = scan.nextDouble();
				System.out.println("Enter a player's hometown");
				String hometown = scan.nextLine();
				System.out.println("Enter a player's high school");
				String highSchool = scan.nextLine();
				ShortName name = new ShortName(firstname, lastname);
				Player player = new Player(name, number, position, battingAverage, hometown, highSchool);
				list.addPlayer(player);
				System.out.println("added");
			}
			if(str.equals("d")){
				System.out.println("Enter a player's number you want to delete");
				str = scan.next();
				list.deletePlayer(str);
				System.out.println("deleted");
			}
			if(str.equals("s")){
				System.out.println("Enter a player's lastname you want to search");				
				str = scan.next();
				list.lookUpPLayer(str);
			}
			if(str.equals("e")){
				list.showEntire();
			}
		}
	}
}

/*
Welcome to Copperopolis Chili Beans's roster
Enter a for add, d for delete, s for search, e for show entire roster
a
Enter a player's firstname
john
Enter a player's lastname
berry
Enter a player's number
001
Enter a player's position
center
Enter a player's batting average
99.999
Enter a player's hometown
foothill
Enter a player's high school
fotthill high
added
Enter a for add, d for delete, s for search, e for show entire roster
a
Enter a player's firstname
yasukazu
Enter a player's lastname
kashii
Enter a player's number
007
Enter a player's position
left
Enter a player's batting average
0.0001
Enter a player's hometown
mountain
Enter a player's high school
mountain high
added
Enter a for add, d for delete, s for search, e for show entire roster
a
Enter a player's firstname
a
Enter a player's lastname
a
Enter a player's number
004
Enter a player's position
catcher
Enter a player's batting average
22.5
Enter a player's hometown
abc
Enter a player's high school
abc highschool
added
Enter a for add, d for delete, s for search, e for show entire roster
e
name: john berry number: 001 position: center batting average: 99.999% hometown: foothill high school: fotthill
name: yasukazu kashii number: 007 position: left batting average: 1.0E-4% hometown: mountain high school: mountain high
name: a a number: 004 position: catcher batting average: 22.5% hometown: abc high school: abc
Enter a for add, d for delete, s for search, e for show entire roster
s
Enter a player's lastname you want to search
berry
name: john berry number: 001 position: center batting average: 99.999% hometown: foothill high school: fotthill
Enter a for add, d for delete, s for search, e for show entire roster
d
Enter a player's number you want to delete
007
deleted
Enter a for add, d for delete, s for search, e for show entire roster
e
name: john berry number: 001 position: center batting average: 99.999% hometown: foothill high school: fotthill
name: a a number: 004 position: catcher batting average: 22.5% hometown: abc high school: abc
Enter a for add, d for delete, s for search, e for show entire roster
*/
