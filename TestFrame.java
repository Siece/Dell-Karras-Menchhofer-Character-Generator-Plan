/**
 * TestFrame.java
 * Assignment: Final Project
 * Purpose: To let us have some experience with actual coding, rather than
 * just systematically fulfilling assignments through which we are 
 * walked step by step.
 * @version 05/28/15
 * @author Rachel Dell; Sierramtice Karras
 */


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TestFrame implements ActionListener {
     
   private JFrame frame;
   private JPanel introduction;    
   private JList genreList;
   private String[] genres;
   private JLabel questLabel;
   private JButton next;
   private JLabel introLabel1;
   private JLabel introLabel2;
   private JLabel introLabel3;
   private JLabel introLabel4;
   private JLabel blankSpace;
   private String genre = "";
   private String[] infoTypes;
   
   public static void main(String[] args) {
      new TestFrame();
   }
   
   /* @param nothing
   * @return nothing
   * @see a new frame with an introduction to the program, a prompt to pick a genre, and a list
   * of genres from which to choose
   * creates a new TestFrame, with the first screen to introduce the program and ask the user
   * to pick the genre of their story from a list of options
   */
   public TestFrame() { 
      frame = new JFrame("Story Generator");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ends program when window is closed     
      
      //components 
      introLabel1 = new JLabel("Hello, and welcome to the magical");
      introLabel2 = new JLabel(" and mysterious story generator!");
      introLabel3 = new JLabel("Choose genre and data for generating,");
      introLabel4 = new JLabel("create stories to your heart's content!");
      blankSpace = new JLabel("");
      questLabel= new JLabel ("What genre do you want?");
      String[] genres = {"Sci-fi", "Mystery", "Fantasy", "Realistic", "Historical", "Superhero", 
         "Any"};
      this.genres = genres;
      genreList = new JList(genres);
      
      next = new JButton("Next >");
      next.addActionListener(this);
      
      //layout      
      frame.setLayout(new BorderLayout());
      //creates a panel for the northern region
      introduction = new JPanel(new GridLayout(5, 1));
      introduction.add(introLabel1);
      introduction.add(introLabel2);
      introduction.add(introLabel3);
      introduction.add(introLabel4);
      introduction.add(blankSpace);
      frame.add(introduction, BorderLayout.NORTH);
      //creates a panel for the central region
      JPanel center = new JPanel(new BorderLayout());
      center.add(questLabel, BorderLayout.NORTH);
      center.add(genreList, BorderLayout.SOUTH);
      frame.add(center, BorderLayout.CENTER);
      frame.add(next, BorderLayout.SOUTH);
      
      frame.setSize(new Dimension(300, 300));
      frame.setLocation(new Point(500, 350));  
      frame.pack();  //changes the formatting to fit what's in it
      frame.setVisible(true);
   }
   
   /* @param an ActionEvent from the frame
   * @return nothing
   * @see updates the frame shown to a prompt to pick a category of information to be developed,
   * and a list of options from which to choose
   * responds to the event from the frame (the "next" button being clicked) by changing the 
   * frame to the next step, asking the user to pick the type of information they want from
   * a list of options
   */
   public void actionPerformed(ActionEvent event) {
      int index = genreList.getSelectedIndex();
      try {
         this.genre = genres[index];    //stores the selected genre in a String
      } 
      catch (ArrayIndexOutOfBoundsException e) {
         questLabel.setText("Please choose a genre to continue!");
      }
      
      if(event.getActionCommand().equals("Next >") && !genre.equals("")) {
         frame.remove(introduction);
         questLabel.setText("What infomation do you want?"); // (character/setting/plot/item)
         introLabel1.setText("");
         introLabel2.setText("");
         introLabel3.setText("");
         introLabel4.setText("");
         String[] infoTypes = {"Character", "Setting", "Plot", "Item"};
         genreList = new JList(infoTypes);
      }
   }  
}
