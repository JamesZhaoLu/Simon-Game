/**
 * @(#)Text1.java
 *
 *
 * @author 
 * @version 1.00 2017/1/10
 */
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class GUIInitial implements ActionListener{
	JFrame initial;
	//inital frame for the game
	
	JButton proceed;
	//Button tio continue to the game
	
	JRadioButton easy;
	JRadioButton medium;
	JRadioButton hard;
	ButtonGroup radGroup;
	//Group of radio buttons
	
	static String level = "easy";
	//this is a variable that saves what level the player has chosen
	//default is easy

    public GUIInitial() {
    	initial = new JFrame("Initial");
    	initial.setSize(300,150);
    	initial.setLayout(new FlowLayout());
    	
    	radGroup = new ButtonGroup();
    	easy = new JRadioButton("easy");
    	easy.addActionListener(this);
    	medium = new JRadioButton("medium");
    	medium.addActionListener(this);
    	hard = new JRadioButton("hard");
    	hard.addActionListener(this);
    	//initialize the Radio Buttons
    	//as well as adding an Action Listner to it
    	radGroup.add(easy);
    	radGroup.add(medium);
    	radGroup.add(hard);
    	//Add to the button group
    	
    	initial.add(easy);
    	initial.add(medium);
    	initial.add(hard);
    	//add Radio buttons to group
    	
    	proceed = new JButton("Continue to Game");
    	//initialize the Button
    	
    	initial.add(proceed);
    }
    public void actionPerformed (ActionEvent e){
    	if (e.getSource().equals(easy)) level = "easy";
    	else if (e.getSource().equals(medium)) level = "medium";
    	else if (e.getSource().equals(hard)) level = "hard";
    	else if (e.getSource().equals("Continue to Game")){
    		initial.setVisible(false);
    		
    	}
    }

    
    
}