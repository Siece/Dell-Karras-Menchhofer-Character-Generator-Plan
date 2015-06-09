import java.util.*;
public class WeightClient {
   public static void main (String [] args) {
      ArrayList<Weight> stuff = new ArrayList<Weight>();
      
      Weight boxs = new Weight (16, 2);
      Weight cans = new Weight (2, 19);
      Weight crates = new Weight (100, 0);
      Weight boxs2 = new Weight (16, 3);
      stuff.add(boxs);
      stuff.add(cans);
      stuff.add(crates);
      stuff.add(boxs2);

      int a = boxs.compareTo(boxs2);
      System.out.println(stuff);
      Collections.sort(stuff);
      System.out.println(stuff);
   }
}

