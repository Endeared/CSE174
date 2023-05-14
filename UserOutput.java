import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class UserOutput {
  public static void main(String[] args) throws FileNotFoundException {
    
    PrintWriter output = new PrintWriter(new File("hello.txt"));
    output.println("Hello World!");
    output.println("Goodbye!");
    output.close();
    
    PrintWriter sheet = new PrintWriter(new File("csvData.csv"));
    sheet.println("Ross,Hamey,CSE174");
    sheet.println("John,Doe,CSE174");
    sheet.println("Jane,Doe,CSE153");
    sheet.close();
  }
}