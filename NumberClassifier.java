/* cse174 lab3 - number classifier
   Ross Hamey
   5/24/2023 */
   
// i feel like my workarounds for getting below the 80 char
// styling limit can be ugly / hard to read. is there a better
// way to go about doing this with prints / strings?
   
// scanner import for inputs
import java.util.Scanner;

public class NumberClassifier {
  public static void main(String[] args) {
  
    // declaring scanner
    Scanner input = new Scanner(System.in);
    
    // grabbing input
    System.out.print("Please provide an integer to classify: ");
    int classifyNum = input.nextInt();
    System.out.println();
    
    // declaring our even / odd check
    int checkEvenOrOdd = classifyNum % 2;
    
    
    // our nested conditionals start below... starts with checking if
    // num is 0, then checking if negative or positive if not 0, and
    // check if even or odd in nested conditionals. lastly, in each nested
    // conditional, we assign a result to a ternary operator to determine
    // if the num is large or not, and print the result
    
    // check if 0
    if (classifyNum == 0) {
      System.out.println("Your number is 0.\nFurther, " 
          + "this is not a large number.");
    // check if negative
    } else if (classifyNum < 0) {
      // check if even
      if (checkEvenOrOdd == 0) {
        String result = classifyNum <= -100 
            ? "Your number is negative and even.\nFurther, " 
            + "this is a large number." : 
            "Your number is negative and even.\nFurther, " 
            + "this is not a large number.";
        System.out.println(result);
      // otherwise, odd
      } else {
        String result = classifyNum <= -100 
            ? "Your number is negative and odd.\nFurther, "
            + "this is a large number." : 
            "Your number is negative and odd.\nFurther, " 
            + "this is not a large number.";
        System.out.println(result);
      }
    // check if positive
    } else if (classifyNum > 0) {
      // check if even
      if (checkEvenOrOdd == 0) {
        String result = classifyNum >= 100 
            ? "Your number is positive and even.\nFurther, " 
            + "this is a large number." : 
            "Your number is positive and even.\nFurther, " 
            + "this is not a large number.";
        System.out.println(result);
      // otherwise, odd
      } else {
        String result = classifyNum >= 100 
            ? "Your number is positive and odd.\nFurther, " 
            + "this is a large number." : 
            "Your number is positive and odd.\nFurther, " 
            + "this is not a large number.";
        System.out.println(result);
      }
    }
  
  }
}