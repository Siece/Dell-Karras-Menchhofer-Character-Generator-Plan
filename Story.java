/**
* Story.java
* Assignment: Final Project
* Purpose: To let us have some experience with actual coding, rather than
* just systematically fulfilling assignments through which we are
* walked step by step.
* @version 05/29/15
* @author Rachel Dell
*/

import java.awt.*;
import java.io.*;
import java.util.*;

public abstract class Story {
   
   /* @param a Scanner with the text which ones wishes to change to an ArrayList
   * @return an ArrayList with each line stored seperately
   * takes a Scanner containing text and stores each line seperately into one ArrayList
   */
   public ArrayList<String> textToArray(Scanner text){
      ArrayList<String> data = new ArrayList<String>();
      while (text.hasNext()){
         data.add(text.nextLine());
      }
      return data;
   }
   
   /* @param an ArrayList of Strings
   * @return a random String from the ArrayList
   * finds a random index, and returns the String in the ArrayList at that index
   */
   public String randomize(ArrayList<String> data){
      int numb = (int)(Math.random() * data.size());
      return data.get(numb);
   }
   
   /* @param a Scanner with the text which ones wishes to change to an ArrayList, and the ArrayList
   * to which the text is to be added
   * @return an ArrayList with each line stored seperately
   * takes a Scanner containing text, and an ArrayList, and adds more infomation to the ArrayList
   * by storing each line seperately into the original ArrayList
   */
   public ArrayList<String> addToArray(Scanner text, ArrayList<String> data){
      while (text.hasNext()){
         data.add(text.nextLine());
      }
      return data;
   }
   
   /* @param nothing
   * @return a String with two randomly selected personality traits
   * uses textToArray and randomize methods to pick two random personality traits from the file
   */
   public String personality() throws FileNotFoundException {
      Scanner personality = new Scanner(new File("PersonalityTraits.txt" ));
      ArrayList<String> traits = textToArray(personality);
      String persons = capitalize(randomize(traits)) + " and " + capitalize(randomize(traits));
      return persons;
   }
   
   /* @param a String containing the text for formating
   * @return a String containing the same text as the parameter, now properly formatted
   * formats the given text in the String so that it fits on the console screen
   */
   public String format(String text) {
      String formattedText = "";
      boolean changed = false;
      int end = 85;
      int start = 0;
      while (text.length() >= 95) {
         changed = true;
         while (text.charAt(end) != ' ') {
            end++;
         }
         formattedText += text.substring(start, end + 1) + "\n    ";
         text = text.substring(end);
         end += 85;
         start += 85;
      }
      if (changed) {
         formattedText += text;
         return formattedText;
      } else {
         return text;
      }
   }
   
   /* @param a String with text for capitalizing
   * @return a String containing the same text as the parameter, now capitalized properly
   * capitalizes the given text in the String
   */
   public String capitalize(String text) {
      text = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
      return text;
   }
   
   /* @param nothing
   * @return a String representation of the information of the class
   * takes the information stored in or passed to the class, turns it into a String version,
   * and returns that String
   */
   public abstract String toString();
}