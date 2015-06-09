/**
 * StoryFrame.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/26/15
 * @author Rachel Dell
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class StoryFrame extends Frame {
   
   public StoryFrame() {
      setTitle("Character Generator");
      setLayout(new FlowLayout());
      setSize(300, 200);
      setResizable(true);
      setBackground(Color.WHITE);
      
      
      //set up a button to tell when user is done and output is displayed
      Button buttonDone = new Button("Done");   
      add(buttonDone);                    
      buttonDone.addActionListener(this);
      
   }
   
   public void actionPerformed(ActionEvent evt) {
      //change display to show all the output
   }



}
