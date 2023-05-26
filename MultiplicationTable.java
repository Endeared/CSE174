/* cse174 lab4pt1 - multiplication table
   Ross Hamey
   5/26/2023 */
   

// scanner import for row / column inputs
import java.util.Scanner;

public class MultiplicationTable {
  public static void main(String[] args) {
    
    // initializing our input scanner
    Scanner input = new Scanner(System.in);
    
    // initializing our columns / rows variable, doing this now
    // so they are in the correct scope
    int columns;
    int rows;
  
    // first do-while loop; we repeatedly ask the user how many
    // columns should be in the table and grab their input, and
    // repeat anytime their input is less than 1 or greater
    // than 25 (#1)
    do {
      System.out.print("How many columns should be in the table: ");
      columns = input.nextInt();
    } while (columns < 1 || columns > 25);
    
    // second do-while loop; we repeatedly ask the user how many
    // rows should be in the table this time, and then once again
    // grab their input. we repeatedly do this until their input
    // is less than 1 or greater than 25 (#1)
    do {
      System.out.print("How many rows should be in the table: ");
      rows = input.nextInt();
    } while (rows < 1 || rows > 25);
    
    // printing a new line for the multiplication table to start
    System.out.println();
    
    // first for loop, we assign the row num (going down the
    // first column), and each time our nested loop finishes
    // we go to a new line and increment our row #
    for (int rowNum = 1; rowNum <= rows; rowNum++) {
    
      // second & nested for loop, we assign col num (going across
      // each row), and we declare our product variable by taking
      // the rowNum times the colNum. we then printf our product
      // num with a space of 5 digits and with the number left
      // aligned (#2 & #3)
      for (int colNum = 1; colNum <= columns; colNum++) {
        int product = rowNum * colNum;
        System.out.printf("%-5d", product);    
      }
      
      // this is our println statement from the first for loop
      // to go to a new line
      System.out.println();
      
    }
   
  }
}