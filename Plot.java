/**
* Plot.java
* Assignment: Final Project
* Purpose: To let us have some experience with actual coding, rather than
* just systematically fulfilling assignments through which we are
* walked step by step.
* @version 05/29/15
* @author Luia Menchhofer
*/

import java.awt.*;
import java.io.*;
import java.util.*;

public class Plot extends Story {
   
   private String startingSentence;
   private String story;
   private String twist;
   
   /* @param nothing
   * @return nothing
   * constructor method for Plot
   */
   public Plot() throws FileNotFoundException {
      firstSentence();
      plotLine();
      plotTwist();
   }
   
   /*@param nothing
   * @return nothing
   * picks random first sentence by using randomize method and stores it in startingSentence field
   */
   public void firstSentence() throws FileNotFoundException {
      Scanner sentence = new Scanner(new File("randomSentences.txt"));
      ArrayList<String> data = textToArray(sentence);
      startingSentence = format(randomize(data));
   }
   
   /*@param nothing
   * @return nothing
   * picks the plotline by using randomize method and stores it in the story field
   */
   public void plotLine() throws FileNotFoundException {
      Scanner plotIdeas = new Scanner(new File("storylines.txt"));
      ArrayList<String> data = textToArray(plotIdeas);
      story = format(randomize(data));
   }
   
   /*@param nothing
   * @return nothing
   * picks the plot twist by using randomize method and stores it in the twist field
   */
   public void plotTwist() throws FileNotFoundException {
      Scanner twistIdeas = new Scanner(new File("plotTwist.txt"));
      ArrayList<String> data = textToArray(twistIdeas);
      twist = format(randomize(data));
   }
   
   /* @param nothing
   * @return a String version of the first sentence, plotline, and plot twist
   * makes headings for the information generated in the Plot class and prints the fields
   */
   public String toString() {
      return "Plot: \n " + "First Sentence: " + this.startingSentence + "\n Basic Storyline: "
         + this.story + "\n Plot Twist: " + this.twist;
   }
}