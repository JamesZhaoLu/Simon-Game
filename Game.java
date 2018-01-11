/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/12/12
 */
import javax.swing.Timer;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Game {
	ArrayList<Integer> sequence;
	//Primitive that keeps track of the Sequence order
	
	Player p1;
	//Player playing the game
	
	int numSquares;
	//Denotes one aspect of the hardness of the game - in the sense where it goes with how many squares there are
	
	int level;
	//variable used to count the level
	//which round the player is on
	
    public Game(int numSquares) {
    	
    
    	try{
    		String name = JOptionPane.showInputDialog("Please enter your name").trim();
    		while(name.equals(null) || name.equals("")){
    			JOptionPane.showMessageDialog(null, "Please enter a valid name");
    			//makes sure they created a person with a valid name
    			name = JOptionPane.showInputDialog("Please enter your name").trim();
    		}
    		System.out.println (name);
    		p1 = new Player(name);
    		System.out.println (p1.name);
    		//Creates a new Player and asks them for their name
    		
    		level = 1;
    		//Begin the game at level 1
 			
    		sequence = fillInitial(numSquares);
//    		//Creates initial Sequence
    	}
    	catch(Exception e){
    		System.out.println ("oh no");
    	}
    	
    
    	
    
    }
    public Game(){
    	p1 = new Player();
    	numSquares = 0;
    	sequence = new ArrayList<Integer>();
    	
    }
    public static ArrayList<Integer> fillInitial(int numSquares){
    	//This method is used to initially fill the ArrayList - so that it can be used in the super class
    	
    	ArrayList<Integer> sequence = new ArrayList<Integer>();
    	for (int i = 0; i<(numSquares-5); i++){
    		sequence.add((int)(Math.random()*numSquares));
    		//Using the loop - add a number to the sequence - on medium begin with 3
    	}
    	return sequence;
    }
    public void addSequence(int numSquares){
    	sequence.add((int)(Math.random()*numSquares));
    	//adds a number to the sequence 
    	//think about overidding this iin other classes - maybe for hard add 2 numbers at a time
    }
     public void CalculateScore(int time){
    	p1.points += 1;
    	if (p1.points > 50) p1.points += level;
    }
    
    
}
    
    
