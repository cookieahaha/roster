// $Id$
package me.kukkii.roster.tree;

import me.kukkii.roster.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Roster implements java.io.Serializable{

	private Node root;
	
	// constructer 
	public Roster() {
		root = null;
	}

	
    // This method adds a player to the array list
    public void addPlayer(Player p) {
 	   if(root == null){  // this is for first node
 		   Node n = new Node(p);
 		   root = n;
 	   }
 	   else{ 
 		   Node compare = root;
 		   while(true){
 			   if(p.compareTo(compare.getPlayer()) < 0){	   
 				   if(compare.getLeft() == null){
 					   Node n = new Node(p);
 					   compare.setLeft(n);
 					   System.out.println("added l");
 					   return;
 				   }
 				   else{
 					   compare = compare.getLeft();
 				   }
 			   }
 			   else if(p.compareTo(compare.getPlayer()) > 0){
 				   if(compare.getRight() == null){
 					   Node n = new Node(p);
 					   compare.setRight(n);
 					   System.out.println("added r");
 					   return;
 				   }
 				   else{
 					   compare = compare.getRight();
 				   }
 		   		}
 		   	}
 	   }
 	   
 	   
    	
 	 //sort();
 	   return;
 	}
     
    // This method deletes a player from the array list
    public void deletePlayer(String ln) {
   	   if(root == null){  // this is for first node
  		   System.out.println("there's no player in the roster");
 	   }
 	   else{ 
 		   Node compare = root;
 		   Node parent = null;
 		   while(true){
 			   if(ln.compareTo(compare.getPlayer().getName().getLast()) < 0){
 				   if(compare.getLeft() == null){
 			  		   System.out.println("couldnt find a player with the name you entered");
 					   return;
 				   }
 				   else{
 					   parent = compare;
 					   compare = compare.getLeft();
 				   }
 			   }
 			   else if(ln.compareTo(compare.getPlayer().getName().getLast()) > 0){
 				   if(compare.getRight() == null){
 			  		   System.out.println("couldnt find a player with the name you entered");
 					   return;
 				   }
 				   else{
 					   parent = compare;
 					   compare = compare.getRight();
 				   }
 		   		}
 			   else if(ln.compareTo(compare.getPlayer().getName().getLast()) == 0){
 				   Node right = compare.getRight();
 				   if(right == null){
 					   if(parent == null){
 						   root = root.getLeft();
 						   return;
 					   }
 					   if(parent.getLeft() == compare){
 						   parent.setLeft(compare.getLeft());
 					   }
 					   else{
 						   parent.setRight(compare.getLeft());
 					   }
 					   return;
 				   }
 				   Node left = right;
 				   Node pol = null;
 				   while(true){
 					   if(left.getLeft() != null){
 						   pol = left;
 						   left = left.getLeft();
 					   }
 					   else{
 						   if(pol == null){
 							   compare.setPlayer(right.getPlayer());
 							   compare.setRight(right.getRight());
 						   }
 						   else{
 							   compare.setPlayer(left.getPlayer());
 							   pol.setLeft(left.getRight());
 						   }
 						   return;
 					   }
 				   }
 				   
 			   }
 		   	}
 	   }  

    }


    // This method looks up a player in the array list by last name
    public void lookUpPLayer(String ln){
  	   if(root == null){  // this is for first node
  		   System.out.println("there's no player in the roster");
 	   }
 	   else{ 
 		   Node compare = root;
 		   while(true){
 			   if(ln.compareTo(compare.getPlayer().getName().getLast()) < 0){
 				   if(compare.getLeft() == null){
 			  		   System.out.println("couldnt find a player with the name you entered");
 					   return;
 				   }
 				   else{
 					   compare = compare.getLeft();
 				   }
 			   }
 			   else if(ln.compareTo(compare.getPlayer().getName().getLast()) > 0){
 				   if(compare.getRight() == null){
 			  		   System.out.println("couldnt find a player with the name you entered");
 					   return;
 				   }
 				   else{
 					   compare = compare.getRight();
 				   }
 		   		}
 			   else if(ln.compareTo(compare.getPlayer().getName().getLast()) == 0){
 				   compare.getPlayer().showInfo();
 				   return;
 			   }
 		   	}
 	   }
    }
    
    // This method shows all players in the array list
    public void showEntire(){
    	showTree(root);
    }
    
    public void showTree(Node n){
    	if(n == null){
    		return;
    	}
    	showTree(n.getLeft()); //Recursive step
    	n.getPlayer().showInfo(); //this is called "Visiting The Node"
    	showTree(n.getRight()); //Recursive step
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
