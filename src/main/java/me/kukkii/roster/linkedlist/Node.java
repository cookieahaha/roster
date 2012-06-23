// $Id$
package me.kukkii.roster.linkedlist;

import me.kukkii.roster.Player;

public class Node implements java.io.Serializable{
	
	private Player pr;
	private Node next;
	private Node pre;

	public Node(Player pr){
		this.pr = pr;
	}
	
	public Node getNext(){
		return next;
	}
	
	public Node getPre(){
		return pre;
	}
	
	public void setNext(Node next){
		this.next = next;
	}
	
	public void setPre(Node pre){
		this.pre = pre;
	}
	
	public Player getPlayer(){
		return pr;
	}
	
}
