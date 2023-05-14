public class MethodDemo {
   public static void main(String[] args) {
      System.out.println("amy");
      animals();
      names();
      animals();
   } 
   
   public static void animals() {
      System.out.println("dog"); 
      System.out.println("cat"); 
      names();
   } 
   
   public static void names() {
      System.out.println("amy"); 
      System.out.println("tom"); 
   } 

} // end class