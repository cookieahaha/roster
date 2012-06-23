// $Id$
package me.kukkii.roster.linkedlist;

import me.kukkii.roster.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Roster implements java.io.Serializable{

	private Node head;
	private Node tail;
	
	// constructer 
	public Roster() {
		head = null;
		tail = null;
	}

	
    // This method adds a player to the array list
    public void addPlayer(Player player) {
 	   Node node = new Node(player);
 	   if(tail == null){    // this is for first node
 		   head = node;
 		   tail = node;
 	   }
 	   else{
 		   node.setPre(tail);
 		   tail.setNext(node);
 		   tail = node;  
 	   }
 	 //sort();
 	   return;
 	}
     
    // This method deletes a player from the array list
    public void deletePlayer(String lastname) {
    	Node node = head;
    	while(true){
       		if(node == null){
       	    	System.out.println("i could not found it");
       			break;
       		}
       		else if(node.getPlayer().getName().getLast().equals(lastname)){  // when found
       			if(node == head && node == tail){
       				head = null;
       				tail = null;
       			}
       			else if(node == head){
       				head = node.getNext();
       				head.setPre(null);
       			}
       			else if(node == tail){
       				tail = node.getPre();
       				tail.setNext(null);
       			}
       			else{
       				node.getPre().setNext(node.getNext());
       				node.getNext().setPre(node.getPre());
       			}
       			break;
    	   	}
    	   	else{
    	   		node = node.getNext();
    	   	}
    	}

    }


    // This method looks up a player in the array list by last name
    public void lookUpPLayer(String lastname){
       	Node node = head;
    	while(true){
       		if(node == null){
       	    	System.out.println("i could not found it");
       			break;
       		}
       		else if(node.getPlayer().getName().getLast().equals(lastname)){  // when found
    	        node.getPlayer().showInfo();
    	    	break;
    	    }
    	    else{
    	    	node = node.getNext();
    	    }
    	}
    }
    
    // This method shows all players in the array list
    public void showEntire(){
       	Node node = head;
       	while(true){
      		if(node == null){
       			break;
       		}
       		node.getPlayer().showInfo();
       		node = node.getNext();
       	}	
    }
    
    public void writeToFile(){
        try{
           FileOutputStream fileOut = new FileOutputStream("roster.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(this);
           out.close();
           fileOut.close();
        }
        catch(IOException i){
           i.printStackTrace();
        }
    }

    public static Roster readFromFile(){
    	File file = new File("roster.ser");
    	if(! file.exists()){
    		Roster list = new Roster();
    		return list;
    	}
    	try{
    		FileInputStream fileIn = new FileInputStream(file);
    		ObjectInputStream in = new ObjectInputStream(fileIn);
    		Roster list = (Roster) in.readObject();
    		in.close();
    		fileIn.close();
    		return list;
    	}
    	catch(IOException i){
    		i.printStackTrace();
    		return null;
    	}
    	catch(ClassNotFoundException c){
    		System.out.println("Roster class not found");
    		c.printStackTrace();
    		return null;
    	}
    }
    
}




/*

Welcome to Copperopolis Chili Beans's roster
Enter a for add, d for delete, s for search, e for show entire roster
e
name: aaaaaaa aaaaaaaa number: aaaaaaa position: aaaaaaa batting average: 1111111.0% hometown: aaaaaa high school: aaaaaa
name: eeeeeee eeeee number: eeee position: eeeee batting average: 2.0% hometown: eeeee high school: eeeee
Enter a for add, d for delete, s for search, e for show entire roster
a
Enter a player's firstname
bbbbbbbb
Enter a player's lastname
bbbbbbbbb
Enter a player's number
bbbbbbbbbb
Enter a player's position
bbbbbbbbbb
Enter a player's batting average
0
Enter a player's hometown
bbbbbbbbb
Enter a player's high school
bbbbbbbb
added
Enter a for add, d for delete, s for search, e for show entire roster

Welcome to Copperopolis Chili Beans's roster
Enter a for add, d for delete, s for search, e for show entire roster
e
name: aaaaaaa aaaaaaaa number: aaaaaaa position: aaaaaaa batting average: 1111111.0% hometown: aaaaaa high school: aaaaaa
name: eeeeeee eeeee number: eeee position: eeeee batting average: 2.0% hometown: eeeee high school: eeeee
name: bbbbbbbb bbbbbbbbb number: bbbbbbbbbb position: bbbbbbbbbb batting average: 0.0% hometown: bbbbbbbbb high school: bbbbbbbb
Enter a for add, d for delete, s for search, e for show entire roster

*/
