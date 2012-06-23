// $Id$
package me.kukkii.roster.tree;

import me.kukkii.roster.Player;

public class Node implements java.io.Serializable{
	
	private Player p;
	private Node left;
	private Node right;

	public Node(Player p){
		this.p = p;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public Node getRight(){
		return right;
	}
	
	public void setLeft(Node left){
		this.left = left;
	}
	
	public void setRight(Node right){
		this.right = right;
	}
	
	public Player getPlayer(){
		return p;
	}
	
	public void setPlayer(Player p){
		this.p = p;
	}
	
}
