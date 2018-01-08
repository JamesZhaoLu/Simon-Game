/**
 * @(#)Text3.java
 *
 *
 * @author 
 * @version 1.00 2016/12/15
 */


public class gameMed extends Game{

    public gameMed(int numSquares) {
    	super(numSquares);
    }
    public void CalculateScore(int time){
    	p1.points+= ((1* level) - time);
    	
    }
    
    
}