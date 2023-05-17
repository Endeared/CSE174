/* cse174 lab1pt1 - area checker
   Ross Hamey
   5/17/2023 */

public class AreaChecker {
  public static void main(String[] args) {
    
    double longBase = 10;
    double shortBase = 5;
    double altitude = longBase * shortBase;
    double area = 0.0;
        
    System.out.println("Long Base = " + longBase);
    System.out.println("Short Base = " + shortBase);
    System.out.println("Altitude = " + altitude);
    
    /* CODE expected the ":" as part of the string on
    * canvas so i left it in, despite no output following
    * it...
    */
    System.out.println("\nAdjusting Altitude to 9:");
    altitude = 9;
        
    System.out.println("Long Base = " + longBase);
    System.out.println("Short Base = " + shortBase);
    System.out.println("Altitude = " + altitude);
    
    area = (longBase + shortBase) / 2 * altitude;
    System.out.println("\nArea = " + area);   
    
  }
}