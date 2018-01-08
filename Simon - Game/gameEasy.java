/**
 * @(#)Text2.java
 *
 *
 * @author 
 * @version 1.00 2016/12/15
 */


public class gameEasy extends Game {

     public gameEasy(int numSquares) {

    	super(numSquares);
    }
    public  void CalculateScore(int time){
    	p1.points += (1 - (time *1.5));
    }
    
    
}