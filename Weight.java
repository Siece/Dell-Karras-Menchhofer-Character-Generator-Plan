public class Weight implements Comparable<Weight> {
   private int pounds;
   private int ounces; 
   
   public Weight (int lbs, int oz) {
      this.pounds = lbs;
      this.ounces = oz;
   }
   
   public int compareTo(Weight other) {
      if(other.getPounds() != pounds) {
         return pounds - other.getPounds();
      } 
      else {
         return ounces - other.getOunces();
      }
   }
   
   private void distribute() {
      if(ounces >= 16) {
         ounces -= 16; 
         pounds += 1;
      } 
   }
   
   public int getPounds(){
      return pounds;
   }
   
   public int getOunces() {
      return ounces;
   }
   
   public String toString () {
      distribute();
      String text = "";
      if(pounds == 1) {
         text += pounds + "1b ";
      } 
      else if (pounds > 1) {
         text += pounds + "lbs ";
      } 
      if(ounces >= 1) {
         text += ounces + "oz";
      }
      return text;
   }
}

