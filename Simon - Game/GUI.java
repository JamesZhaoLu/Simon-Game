/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2016/12/13
 */


import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import java.io.*;


public class GUI implements ActionListener{
	JFrame Simon;
	//Frame for the game
	
	ArrayList<JButton> btnSequence = new ArrayList<JButton>();
	//This is the ArrayList that will hold the buttons
	
	JPanel buttons;
	//Holds the Buttons for the Game
	

	JLabel cOrW;
	//Labels to contain text to tell player if the are right or wrong
	
	Timer time;
	int ticks;
	int counter;
	//These are variables that will be associated with the Timer
	//Ticks measure how many ticks there were and then notes if it should be turned on or off
	

	
	int numSquares;
	//this variable is used to denote the number of squares in the Game - based on difficulty level
	Game SimonGame;
	//Game associated with GUI
	
	ArrayList<Integer> numbers = new ArrayList<Integer>();
	//temp just for testing
	//SIde note any arraylists for counting need to start from 0 - size of array minus 1
	int tempCounter;
    int countWin;
    //These are temp variables
    boolean isSeqGoing;
    //Boolean to ensure that players do not play when timer is going

  	int playerTicks;
    //counts the ticks to count the time for the player to answer

    public GUI() { //eMH is a int that holds difficulty level of game
    
    	
    	Simon = new JFrame("Simon");
    	Simon.setSize(1000,500);
    	//sets size of JFrame
    	
    	Simon.setResizable(false);
    	//makes sure they cannot resize the game
    	
    	Simon.getContentPane().setBackground(Color.DARK_GRAY);
    	//sets background to dark grey
    	
    	
    	buttons = new JPanel(new GridLayout(2,3));
    	buttons.setPreferredSize(new Dimension(600,400));
    	
    	//Set size and creates JPanel for buttons
    	
    	cOrW = new JLabel();
    	//creates new JLabel
    	cOrW.setForeground(Color.WHITE);
    	cOrW.setFont(new Font("Impact", Font.BOLD, 100));
    	//sets font size and color of JLabel
    	
    	ArrayList<Integer> game = new ArrayList<Integer>();
    	game = Game.fillInitial(numSquares);
    	
    	Object[] possibleValues = { "Easy", "Medium", "Hard" };
		Object selectedValue = JOptionPane.showInputDialog(null,"Please select a difficulty level!", "Input",JOptionPane.INFORMATION_MESSAGE, null,possibleValues, possibleValues[0]);
		//This creates a JOPtion pane where they can select from a drop down list - eliminating the need for a catch block
    	if (selectedValue.equals("Easy")){
    		SimonGame = new gameEasy(8);
    		createButtons(8);
    		//creates game with 8 buttons
    	}
    	else if (selectedValue.equals("Medium")){
    		SimonGame = new gameMed(12);
    		createButtons(12);
    		//creates game with 12 buttons
    	}
    	else if (selectedValue.equals("Hard")){
    		SimonGame = new gameHard(16);
    		createButtons(16);
    		//creates game with 16 buttons
    	}
    	System.out.println (SimonGame.p1);
    	//Generates the Game that goes with the GUI
    	//uses the level of difficulty that corresponds with user input
    	
		
		time = new Timer(1000, this);
		//Creates timer with wanted interval
		
		counter = 0;
    	//Timer counter 
    	
    	
    	
    	countWin=0;
    	tempCounter = 0;
    	//sets counters to 0
    	
    	
    	
    }
    public static void main (String[] args) {
    	//GUIInitial initialScreen = new GUIInitial();
    	//initialScreen.initial.show();
    	
    	JOptionPane.showMessageDialog(null, "Welcome to Simon! Here are instructions on how to play. \nMomentarily you will be asked to choose a difficulty and give your name. Please do so truthfully. \nNext the game screen will open up and you will see a group of buttons. \nThe buttons will flash in a particular order. \nThe goal of the game is to remember thew order that the buttons flashed. You will then be asked to repeat this sequence. \nEvery correct answer will be worth points. Wrong clicks will result in game over. \nGood Luck!");
    	//These are the intructions to the game
    	
    	GUI game = new GUI();
    	game.Simon.setLayout(new FlowLayout());
    	
    	game.Simon.add(game.buttons);
    	//add Panel to JFrame
    	game.Simon.add(game.cOrW);
    	
		JOptionPane.showMessageDialog(null, "The game is about to begin! The level is now: " + game.SimonGame.level + " - Good Luck!");
    	//shows the message to know the game is beginning
    	
    	game.Simon.setVisible(true);
    	//Shows the JFrame
    	
    	game.time.setInitialDelay(100);
    	
    	game.time.start();
    	game.isSeqGoing=true;
    	System.out.println ("start");//test code
    	//Starts the timer and starts the timer with a delay
    	
    	
    	
    	
    }
    public void actionPerformed(ActionEvent e){
    	
    	System.out.println (SimonGame.p1);
    	
    	//There should be an ArrayList of Integers passed to it from Game class but right now I will hard copde the sequence
    
    	//used to see how many numbers from the ArrayList have gone
    	
    
    	if (e.getSource().equals(time)){
    		
    		System.out.println (isSeqGoing); //test code
    			if (isSeqGoing == true){
    				System.out.println ("go");//extra code
    				for (int i = 0; i < btnSequence.size(); i++){
    					btnSequence.get(i).setEnabled(false);
    				}
    				
    				if (ticks%2 == 0){
    					btnSequence.get(SimonGame.sequence.get(counter)).setBackground(Color.GREEN);
    					//if the ticks are divisible by 2 then that means it has been 2 seconds - proceed to next button in sequence
    				}
    				else if (ticks % 2 == 1){
    					 btnSequence.get(SimonGame.sequence.get(counter)).setBackground(Color.RED);
    					 counter++;
    					 //if ticks are not divisible by 2 that means button has been shown for 1 second - take away color of button
    				}
    				ticks++;
    	
    				if(counter == SimonGame.sequence.size()){
    					isSeqGoing = false;
    					//if the sequence has been finished (counter = length of the sequence)
    					
    					for (int i = 0; i < btnSequence.size(); i++){
    						btnSequence.get(i).setEnabled(true);
    					}
    					//Sets the buttons to be usable again because then user can set off code that begins with the click of the button
    					JOptionPane.showMessageDialog(null, "You can now repeat the sequence! Good Luck!");
    					//time.stop(); //- might need to change
    					//==size because it is AFTER the showing that counter increases therefore wait till after to stop timer!!!
    					System.out.println (SimonGame.p1);
    				}
    			}
    			//if sequence begins the ability to enable/press buttons is false.
    			else if (isSeqGoing == false){ //sequence is not going - can time the players response
    				playerTicks++;
    				
    			}
    			
    			
    			
    	
    	}
    	else{


			if (isSeqGoing == false){
				//checks to see if the timer is going
				//If not then start checking
				
				int initialPlayer = playerTicks;
				//save what the total number of ticks is at the beginning of the game
				
				
				for (int i=0; i<btnSequence.size(); i++){
    			//btnSequence is the ArrayList of buttons
    				if (btnSequence.get(i).equals(e.getSource())){
    					//checks to see if out of all the buttons in the loop if the loop is matched with the one used
    					//assures that code underneath ensues only when the button that the user clicked is used
    				
    					if (i == SimonGame.sequence.get(tempCounter)){
    						//checks if Sequence - from Game class is the same as the correct number
    						//Note: counts from 0 to numberOfSquares-1
    						
    						cOrW.setText("Correct");
    						//then correct
    						
    						countWin++;
    						//Counter to determine if everything the player clicked is correct 
    						
    						tempCounter++;
    						//add to counter to see if correct
    						//System.out.println (tempCounter);
    						System.out.println (SimonGame.p1);
    						
    						int timeBetween = (playerTicks - initialPlayer);
    						//this give the number of ticks between when game starts and they finish the sequence
    						
    						SimonGame.CalculateScore(timeBetween);
    						//Add points for every correct score
    						System.out.println (SimonGame.p1);
    					} 
    					else {
//    						System.out.println (SimonGame.sequence.get(tempCounter));
//    						System.out.println (i);
							try{
							
								//Player aPlayer = new Player();
								ArrayList<Player> players = new ArrayList<Player>();
								//used to store the array List
								//This is so that you can loop through the while statement while making sure you read every line 
								
    							String line;
    							//while loop that goes through all the lines to fill and array list with a line from the text
								//Every iteration of the loop reads a line
								
    							ArrayList<String> linesOfScores = new ArrayList<String>();
    							//Each item of the Array is a line of the text document
    							
    							BufferedReader in = new BufferedReader(new FileReader("highScores.txt"));
    							in.readLine();
    							in.readLine();
    							//Skip first 2 lines since not useful
    							while((line = in.readLine()) != null){
    								linesOfScores.add(line);
    								//save data in an ArrayList to simplify reading

								}
								in.close();
								
								
								for (String item: linesOfScores){
									String[] player = item.split(" ");
									//splits a text document into individual pieces which will be used to create an instance of player below
									players.add(new Player(player));
									System.out.println (item);
							
								}
								players.add(SimonGame.p1);
								//add player to the list of highScores
								//code below sorts all the players
								
								boolean sorted = false;
    							int sortCounter = 0;
								while(sorted != true){
    								for (int j = 0; j< players.size()-1; j++){
    									if (players.get(j).points < players.get(j+1).points){
    									Player temp = players.get(j);
    									players.set(j, players.get(j+1));
    									players.set(j+1, temp);
    									sortCounter++;
    									//bubble sort that sorts the players
    									//from lowest to highest
    									}
    								}
    								if (sortCounter == 0)sorted = true;
    								sortCounter =0;
    							}
    							//after bubble sorting all the players
    			
							
								//for loop used to put player score from game into highScore count
								BufferedWriter out = new BufferedWriter(new FileWriter("highScores.txt"));
								
								out.write("HighScores");
								out.newLine();
								out.newLine();
								//write the first 2 lines of the document - good format 
								
								for (int j = 0; j < players.size(); j++){
									System.out.println ((j+1) + ". " + players.get(j) + "\n");
									out.write((j+1) + ". " + players.get(j));
									//print out the high scores with the player inside to highScores.txt file
									out.newLine();
								}
							
								out.close();
								
							
    						}
    						catch (FileNotFoundException ex){
    							//used ex as varable since e already used in ActionEvent method
    							System.out.println ("Could not find file");
    						}
    						catch (IOException ex){
    							
    						}
    						
    						//incorrect
    						//(JButton)e.getSource().setBackground(Color.BLACK); - Change button backGround - incorrect
    						
    						
    						
    						//isSeqGoing = false; //not working
    						JOptionPane.showMessageDialog(null,"Incorrect, Game Over. Check highScores.txt to see you rank against other Players");
    						//tells Player there guess was incorrect
    				
    						Simon.setVisible(false);
    						System.exit(0);
    						//close the program
    						//no restart OPTION!!!!!!
    					}
    				}
    			}
    			if (countWin == SimonGame.sequence.size()){
    				
    				SimonGame.level += 1;
    				//add to the level
    				
    				JOptionPane.showMessageDialog(null, "You bested the round! The next round is level: " + SimonGame.level + " - Good Luck!");
    				//notifies Player you are correct round is complete
    				
    				isSeqGoing = true;
    				//check if got sequence right
    				System.out.println ("herer"); // test code
    				
    			
    				
    				restart();
    				
    			}
			}
    		
    		
    	}
    	
    	
    	
    }
    public void createButtons(int numSquares){
    		for (int i = 0; i<numSquares; i++){
			JButton btn = new JButton();
			btn.setSize(200,200);
			btn.setBackground(Color.RED);
			buttons.add(btn);
			btnSequence.add(btn);
			btn.addActionListener(this);
			
		}
		//code used to create buttons in each game
    }
    public void restart(){
    	countWin = 0;
    	//countWin is to count how mnay correct plays the user has made
    	
    	tempCounter = 0;
    	//tempCounter is to count where in the array a button is
    	
    	counter = 0;
    	//counter is for timer ticks
    	
    	SimonGame.addSequence(8);
    	//adds to the seqeuence of the game
    	//NOTE NEED TO CHANGE 8 TO A VARIABLE IN FUTURE
    	
    	time.start();
    	//Starts Timer for next round
    }
    
    
    
    
}


