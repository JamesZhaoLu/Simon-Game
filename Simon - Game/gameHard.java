/**
 * @(#)Text4.java
 *
 *
 * @author 
 * @version 1.00 2016/12/15
 */


public class gameHard extends Game {


    public gameHard(int numSquares) {

    	super(numSquares);

    }
    
    public void CalculateScore(int time){
    	
    	p1.points += ((2*level) - (time/2));
    	
    }
     
    
}