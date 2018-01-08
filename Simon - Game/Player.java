/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/12/15
 */


public class Player {
	int points;
	//Variables that keeps track of the number of points of the player 
	int highScore;
	//Keeps track of the high score of the Player
	String name;
	//Name of the player
	

    public Player(String n) {
    	points =0;
    	highScore=0;
    	name = n;
    	System.out.println (n);
    	//contructor
    	
    }
    public Player(String[] lines){
    	name = lines[1];
    	points = Integer.parseInt(lines[2]);
    	
    }
    public Player(){
    	points = 0;
    	name = "James";
    	highScore = 0;
    	//default contructor
    }
    public String toString (){
    	return name + " " + points;
    }
    
    
}