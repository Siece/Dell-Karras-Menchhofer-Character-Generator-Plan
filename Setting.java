/**
* Setting.java
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

public class Setting extends Story {

   private String genre;
   private String place;
   private String time;
   private String building;
   
   /* @param the genre of the story as a String
   * @return nothing
   * constructs the Setting class, puts genre in a field, calls methods for more information
   */
   public Setting(String genre) throws FileNotFoundException {
      this.genre = genre;
      location();
      timePeriod();
      buildings();
   }
   
   /* @param nothing
   * @return nothing
   * picks a random year based on the genre and turns it into a phrase with (B)CE at the end, and
   * a random month, using textToArray and randomize methods, and stores it in the time field
   */
   public void timePeriod() throws FileNotFoundException {
      //finding a random year as an int based on genre
      int time = 0;
      Random years = new Random();
      if (genre.equalsIgnoreCase("Sci-fi")) {
         time = years.nextInt(7777) + 2015; //from present to far future
      } else if (genre.equalsIgnoreCase("Historical")) {
         time = years.nextInt(4690) - 2700; //from ancient Egypt to 1990
      } else if(genre.equalsIgnoreCase("Fantasy")){
         time = years.nextInt(4720) - 2700; //Egypt to 2020
      } else if (genre.equalsIgnoreCase("Any")) {
         time = years.nextInt(300) + 1800; //1800 to 2100
      } else { //normal
         time = years.nextInt(70) + 1950; //from 1950 to 2020
      }
      //finding a random month
      Scanner info = new Scanner(new File("months.txt" ));
      ArrayList<String> data = textToArray(info);
      String month = capitalize(randomize(data));
      //turning it into a phrase rather than just a number
      String timePhrase = month + ", ";
      if (time < 0) {
         timePhrase += (int) Math.abs(time) + " BCE";
      } else {
         timePhrase += time + " CE";
      }
      this.time = timePhrase;
   }
   
   /* @param nothing
   * @return nothing
   * picks a random place based on genre, using textToArray and randomize methods, and stores it
   * in the place field.
   */
   public void location() throws FileNotFoundException {
      String place = "";
      //finding a random place based on genre
      if (genre.equalsIgnoreCase("Sci-fi")) {
         place = randomize(textToArray(new Scanner(new File("Sci-fiPlaces.txt"))));
         place += " Star System";
      } else if (genre.equalsIgnoreCase("Fantasy") || genre.equalsIgnoreCase("historical")) {
         place = randomize(textToArray(new Scanner(new File("FantasyPlaces.txt"))));
      } else if (genre.equalsIgnoreCase("any")){
         ArrayList<String> all = textToArray(new Scanner(new File("Sci-fiPlaces.txt")));
         addToArray(new Scanner(new File("FantasyPlaces.txt")), all);
         addToArray(new Scanner(new File("countries.txt")), all);
         place = randomize(all);
      } else { //normal
         place = randomize(textToArray(new Scanner(new File("countries.txt"))));
      }
      //fixing the capitalization of the name (inconsistant between the files)
      this.place = capitalize(place);
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random building from the file,
   * which it stores in the building field
   */
   public void buildings() throws FileNotFoundException {
      Scanner info = new Scanner(new File("buildings.txt" ));
      ArrayList<String> data = textToArray(info);
      this.building = capitalize(randomize(data));
   }
   
   /* @param nothing
   * @return a String version of the Setting w/ location, time period, and an important building
   * makes headings for the information generated in the Setting class and prints the fields
   */
   public String toString() {
      return "Setting: \n " +  "Location: " + this.place + "\n Time period: " + this.time + 
         "\n Important Building: " + this.building;
   }  
}