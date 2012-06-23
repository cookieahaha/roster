// $Id$
package me.kukkii.roster.array;

import me.kukkii.roster.Player;

public class Roster {

	private static final int INITSIZE = 2;
	private Player[] list;
	private int listSpot = 0; // holds the next empty spot in the array
	
	// constructer 
	public Roster() {
		list = new Player[INITSIZE];
	}
	
    // This method adds a player to the array list
    public void addPlayer(Player player) {
 	   if(listSpot == list.length){
 		   Player[] newList = new Player[list.length * 2];
 		   for(int i=0; i<list.length; i++){
 			   newList[i] = list[i];
 		   }
 		   list = newList;
 	   }
 	   list[listSpot] = player;
 	   listSpot = listSpot+1;
 	   return;
 	}

    // This method deletes a player from the array list
    public void deletePlayer(String number) {
            for (int i=0; i<listSpot; i++){
            		if(list[i].getNumber().equals(number)){
            			for (int j=i; j<listSpot-1; j++){
            				list[j] = list[j+1];
            			}
            			listSpot = listSpot-1;
           				break;
            		}
            }
    }

    // This method looks up a player in the array list by last name
    public void lookUpPLayer(String lastname){
    	for(int i=0; i<listSpot; i++){
    		if(list[i].getName().getLast().equals(lastname)){
    			list[i].showInfo();
    		}
    	}
    }
    
    // This method shows all players in the array list
    public void showEntire(){
    	for(int i=0; i<listSpot; i++){
    		list[i].showInfo();
    	}
    }
    
}
