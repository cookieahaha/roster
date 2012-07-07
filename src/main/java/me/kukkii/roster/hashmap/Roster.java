package me.kukkii.roster.hashtable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.kukkii.roster.Player;


// hash table
public class Roster implements java.io.Serializable{

	private Player[] hashTable;
	private static final int SIZE = 11;
	
	// constructer 
	public Roster() {
		hashTable = new Player[SIZE];
	}

	
    // This method adds a player to the array list
    public void addPlayer(Player p) {
    	if(p.hashCode()%SIZE<0){
    		hashTable[-(p.hashCode()%SIZE)] = p;   		
    	}
    	else{
    		hashTable[p.hashCode()%SIZE] = p;
    	}
    }
     
    // This method deletes a player from the array list
    public void deletePlayer(String ln) {
    	if(ln.hashCode()%SIZE<0){
    		hashTable[-(ln.hashCode()%SIZE)] = null;   		
    	}
    	else{
    		hashTable[ln.hashCode()%SIZE] = null;
    	}
    }


    // This method looks up a player in the array list by last name
    public void lookUpPLayer(String ln){
    	if(ln.hashCode()%SIZE<0){
    		hashTable[-(ln.hashCode()%SIZE)].showInfo();   		
    	}
    	else{
    		hashTable[ln.hashCode()%SIZE].showInfo();
    	}
    }
    
    // This method shows all players in the array list
    public void showEntire(){
    	for(int i=0;i<hashTable.length;i++){
    		if(hashTable[i]!=null){
    			hashTable[i].showInfo();
    		}
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


