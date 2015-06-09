/**
* Character.java
* Assignment: Final Project
* Purpose: To let us have some experience with actual coding, rather than
* just systematically fulfilling assignments through which we are
* walked step by step.
* @version 05/18/15
* @author Sierramatice Karras
*/

import java.awt.*;
import java.io.*;
import java.util.*;

public class Character extends Story {
   
   private String gender;
   private int age;
   private String name;
   private String eyes;
   private String hair;
   private String skin;
   private String personality;
   private String job;
   private String height;
   private String genre;
   private String type;
   private String species;
   private String superpower;
   private String talent;
   private String sexuality;
   
   /* @param a String containing the gender of the character, the genre of the story, and the type
   * of information for which the user is looking
   * @return nothing
   * constructs a Character with the given gender, stores genre and type in fields to use in
   * deciding character traits
   */
   public Character(String gender, String genre, String type) throws FileNotFoundException {
      this.gender = gender;
      this.genre = genre;
      this.type = type;
      name();
      age(genre);
      eyes();
      hair();
      height();
      skinTone();
      personality = super.personality();
      occupation(genre);
      species(genre, type);
      talents();
      sexuality();
      if (genre.equals("superhero")) {
         superpowers();
      }
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random superpower from the file,
   * which it stores in the superpower field
   */
   public void superpowers() throws FileNotFoundException {
      Scanner superInfo = new Scanner(new File("superpowers.txt" ));
      ArrayList<String> powers = textToArray(superInfo);
      this.superpower = capitalize(randomize(powers));
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random talent from the file,
   * which it stores in the talent field
   */
   public void talents() throws FileNotFoundException {
      Scanner info = new Scanner(new File("Talents.txt" ));
      ArrayList<String> skills = textToArray(info);
      this.talent = capitalize(randomize(skills));
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random sexuality from the file,
   * which it stores in the sexuality field
   */
   public void sexuality() throws FileNotFoundException {
      Scanner info = new Scanner(new File("sexuality.txt" ));
      ArrayList<String> data = textToArray(info);
      this.sexuality = capitalize(randomize(data));
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random skin tone from the file, which
   * it stores in the skin field
   */
   public void skinTone() throws FileNotFoundException {
      Scanner skinInfo = new Scanner(new File("SkinTone.txt" ));
      ArrayList<String> skin = textToArray(skinInfo);
      this.skin = capitalize(randomize(skin));
   }
   
   /* @param a String containing the genre
   * @return nothing
   * computes and stores in the age field a random number (based on the genre) for age
   */
   public void age(String genre) {
      if (genre.equals("sci-fi")) {
         this.age = (int)(Math.random() * 200 + 5);
      } else if (genre.equals("historical")) {
         this.age = (int) (Math.random() * 31 + 5);
      } else {
         this.age = (int)(Math.random() * 70 + 5);
      }
   }
   
   /* @param nothing
   * @return nothing
   * picks the text file based on given gender, then picks and stores in the name field a random
   * name from it, uses the textToArray and randomize methods
   */
   public void name() throws FileNotFoundException {
      String file = "eitherGenderNames.txt";
      if (gender.equalsIgnoreCase("male")) {
         file = "maleNames.txt";
      } else if (gender.equalsIgnoreCase("female")) {
         file = "femaleNames.txt";
      }
      String firstName = randomize(textToArray(new Scanner(new File(file))));
      firstName = super.capitalize(firstName);
      String lastName = randomize(textToArray(new Scanner(new File("surnames.txt"))));
      lastName = super.capitalize(lastName);
      this.name = firstName + " " + lastName;
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random eye color from the file, which
   * it stores in the eyes field
   */
   public void eyes() throws FileNotFoundException {
      Scanner eyesInfo = new Scanner(new File("EyeColors.txt" ));
      ArrayList<String> eyes = textToArray(eyesInfo);
      this.eyes = capitalize(randomize(eyes));
   }
   
   /* @param nothing
   * @return nothing
   * uses the textToArray and randomize methods to pick a random hair color from the file, which
   * it stores in the hair field
   */
   public void hair() throws FileNotFoundException {
      Scanner hairInfo = new Scanner(new File("HairColor.txt" ));
      ArrayList<String> hairs = textToArray(hairInfo);
      this.hair = capitalize(randomize(hairs));
   }
   
   /* @param a String containing the genre
   * @return nothing
   * uses textToArray and randomize methods to pick a random job from the file, with the file
   * decided based on the genre, and stores it in the job field
   */
   public void occupation(String genre) throws FileNotFoundException {
      String file;
      if(genre.equals("sci-fi")) {
         file = "scifiJobs.txt";
      } else if (genre.equals("fantasy")) {
         file = "FantasyJobs.txt";
      } else {
         file = "occupations.txt";
      }
      Scanner input = new Scanner(new File(file));
      if(age > 15 || genre.equals("historical")) {
         ArrayList<String> jobs = textToArray(input);
         this.job = randomize(jobs);
      } else {
         this.job = "child - no job";
      }
      this.job = capitalize(job);
   }
   
   /* @param nothing
   * @return nothing
   * computes height taking into account age and stores it in hte height field
   */
   public void height() {
      int feet = (int)(Math.random() * 3);
      if(age > 12) {
         feet += 4;
      } else {
         feet += 2;
      }
      int inch = (int)(Math.random() * 6);
      if (feet <= 4) {
         inch += 5;
      } else if (feet == 5) {
         inch = (int)(Math.random() * 11);
      }
      this.height =  feet + "'" + inch + "\"";
   }
   
   /* @param a String with the genre, a String with the type (human/creature)
   * @return nothing
   * uses the textToArray and randomize methods if genre is fantasy and the type creature,
   * otherwise just picks a basic species based on type and genre, and stores it in the
   * species field
   */
   public void species(String genre, String type) throws FileNotFoundException {
      if(!type.equals("human")){
         if (genre.equals("sci-fi")){
            Scanner aliens = new Scanner(new File("scifiSpecies.txt" ));
            ArrayList<String> ufo = textToArray(aliens);
            this.species = randomize(ufo);
         } else if (genre.equals("fantasy")) {
            Scanner mythology = new Scanner(new File("creatures.txt" ));
            ArrayList<String> mythos = textToArray(mythology);
            this.species = randomize(mythos);
         } else {
            Scanner all = new Scanner(new File("scifiSpecies.txt" ));
            ArrayList<String> allCreature = textToArray(all);
            addToArray(new Scanner(new File("creatures.txt" )), allCreature);
            this.species = randomize(allCreature);
         }
      } else {
         this.species = "human";
      }
      species = capitalize(species);
   }
   
   /* @param nothing
   * @return a String with all the fields in it
   * turns all the fields and their names into a long String, which it returns
   */
   public String toString() {
      String text =  "Character: \n Name: " + this.name + "\n Age: " + this.age + "\n Appearance: "
         + "\n   Eye Color: " + this.eyes + "\n   Hair Color: " + this.hair + "\n   Height: " +
         this.height + "\n Personality: " + this.personality + "\n Occupation: " + this.job +
         "\n Talent: " + this.talent + "\n Sexuality: " + this.sexuality + "\n Species: " + 
         this.species;
      if (genre.equals("superhero")) {
         text += "\n Superpower: " + this.superpower;
      }
      return text;
   }
}