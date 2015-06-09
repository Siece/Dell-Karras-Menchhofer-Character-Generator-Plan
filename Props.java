/**
* Props.java
* Assignment: Final Project
* Purpose: To let us have some experience with actual coding, rather than
* just systematically fulfilling assignments through which we are
* walked step by step.
* @version 05/29/15
* @author Rachel Dell, Luia Menchhofer
*/

import java.awt.*;
import java.io.*;
import java.util.*;

public class Props extends Story {
   
   private String item;
   private String personality;
   private String type;
   private String person;
   private String name;
   
   /* @param the genre of the story, the kind of information sought by the user, and the sentience
   * of the prop
   * @return nothing
   * constructs a Props class, storing the type and sentience in fields, abd calling methods for 
   * more information (based on type and sentience)
   */
   public Props(String genre, String type, String sentience) throws FileNotFoundException {
      this.type = type;
      this.person = sentience;
      if (type.equals("weapon")) {
         weapons(genre);
      } else if (type.equals("accessory")) {
         accessories();
      } else if (type.equals("pet")){
         pet();
      } else {
         random();
      }
      name();
      if (sentience.equals("yes")){
         personality = super.personality();
      } else {
         personality = "";
      }
   }
   
   /* @param a String containing the genre
   * @return nothing
   * picks a random weapon based on genre, using textToArray and randomize methods, and stores it
   * in the item field
   */
   public void weapons(String genre) throws FileNotFoundException {
      if (genre.equalsIgnoreCase("Historical")) {
         this.item = randomize(textToArray(new Scanner(new File("oldWeapons.txt"))));
      } else {
         this.item = randomize(textToArray(new Scanner(new File("ModernWeapons.txt"))));
      }
      this.item = capitalize(item);
   }
   
   /* @param nothing
   * @return nothing
   * picks a random item, using many text files, textToArray and randomize methods, and stores it
   * in the item field
   */
   public void random() throws FileNotFoundException {
      ArrayList<String> stuff = textToArray(new Scanner(new File("accesories.txt")));
      addToArray(new Scanner(new File("oldWeapons.txt")), stuff);
      addToArray(new Scanner(new File("ModernWeapons.txt")), stuff);
      addToArray(new Scanner(new File("RandomProps.txt")), stuff);
      addToArray(new Scanner(new File("animals.txt")), stuff);
      addToArray(new Scanner(new File("instuments.txt")), stuff);
      this.item = capitalize(randomize(stuff));
   }
   
   /* @param nothing
   * @return nothing
   * picks a random accessory, using textToArray and randomize methods, and stores it
   * in the item field
   */
   public void accessories() throws FileNotFoundException {
      this.item = capitalize(randomize(textToArray(new Scanner(new File("accesories.txt")))));
   }
   
   /* @param nothing
   * @return nothing
   * picks a random animal, using textToArray and randomize methods, and stores it in item field
   */
   public void pet() throws FileNotFoundException {
      this.item = capitalize(randomize(textToArray(new Scanner(new File("animals.txt")))));
   }
   
   /* @param nothing
   * @return nothing
   * picks a random name, using textToArray and randomize methods, and stores it in item field
   */
   public void name() throws FileNotFoundException {
      ArrayList<String> names = textToArray(new Scanner(new File("eitherGenderNames.txt")));
      addToArray(new Scanner(new File("PetNames.txt")), names);
      this.name = capitalize(randomize(names));
   }
   
   /* @param nothing
   * @return a String representation of the props
   * makes and returns a String version of the props contained in Props
   */
   public String toString() {
      String text = "";
      if (type.equalsIgnoreCase("pet")) {
         text += "Pet: ";
      } else if (type.equalsIgnoreCase("weapon")){
         text += "Weapon: ";
      } else if (type.equalsIgnoreCase("accessory")){
         text += "Accessory: ";
      } else {
         text += "Item: ";
      }
      text += item;
      text += "\n Name: " + name;
      if (person.equals("yes")){
         text += "\n Personality: " + personality;
      }
      return text;
   } 
}