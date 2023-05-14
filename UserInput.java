import java.util.Scanner;

public class UserInput {
  public static void main(String[] args) {
    
    Scanner keyboardReader = new Scanner(System.in);
    
    System.out.println("Please input the first number.");
    double firstNum = keyboardReader.nextDouble();
    System.out.println("Please input the second number.");
    double secondNum = keyboardReader.nextDouble();
    
    double sum = firstNum + secondNum;
    System.out.printf("The sum of your two numbers is %s.%n", sum);
  }
}