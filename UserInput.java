import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class UserInput {
  public static void main(String[] args) throws FileNotFoundException {
    
    Scanner keyboard = new Scanner(System.in);
    Scanner file = new Scanner(new File("data.txt"));
    
    System.out.println("Please input the first number.");
    double firstNum = keyboard.nextDouble();
    System.out.println("Please input the second number.");
    double secondNum = keyboard.nextDouble();
    
    double sum = firstNum + secondNum;
    System.out.printf("The sum of your two numbers is %s.%n", sum);
    
    int studentNum = file.nextInt();
    String firstName = file.next();
    String lastName = file.next();
    String className = file.next();
    System.out.printf("Your student number is " + studentNum + ". You are registered as " + firstName + " " + lastName + " under the class " + className + ".%n");
  }
}