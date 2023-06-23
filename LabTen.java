/* cse174 lab10 - a place for everything
   Ross Hamey
   6/21/2023 */

// scanner import for inputs, arraylist import
// for arraylists
import java.util.Scanner;
import java.util.ArrayList;

public class LabTen {
  
  /* sortPoints method that takes in an arraylist of double arrays
   * and sorts the arraylist by the x and y values of the double
   * arrays within the arraylist using bubble sort
   * @param ourPoints an ArrayList containing double Arrays at
   * each element
   */
  public static void sortPoints(ArrayList<double []> ourPoints) {
  
    // we assign a boolean for our bubble sort
    boolean madeSwap;
    
    do {
      // in our do loop, we set madeSwap to false initially. this
      // way, if the loop finishes and madeSwap is still false,
      // our sort is over and we break out of the loop
      madeSwap = false;
      // we iterate through each element and compare it to the
      // following elements X value
      for (int i = 0; i < ourPoints.size() - 1; i++) {
        // if our current elements X value is greater than the
        // next elements X value, we swap their positions
        if (ourPoints.get(i)[0] > ourPoints.get(i + 1)[0]) {
          double[] tempArray = ourPoints.get(i);
          ourPoints.set(i, ourPoints.get(i + 1));
          ourPoints.set(i + 1, tempArray);
          madeSwap = true;
        // if both X values are equal, we swap according to which
        // element has the larger Y value
        } else if (ourPoints.get(i)[0] == ourPoints.get(i + 1)[0]) {
          double[] tempArray = ourPoints.get(i);
          if (ourPoints.get(i)[1] > ourPoints.get(i + 1)[1]) {
            ourPoints.set(i, ourPoints.get(i + 1));
            ourPoints.set(i + 1, tempArray);
            madeSwap = true;
          }
        }
        // otherwise, we do nothing
      } 
    } while (madeSwap);
  }
  
  /* printPoints method that takes in an arraylist of double arrays
   * and returns the contents of the arraylist in a cleanly formatted
   * manner
   * @param ourPoints an ArrayList containing double Arrays at each
   * element
   * @return a String containing the arraylist in a clean format
   */
  public static String printPoints(ArrayList<double []> ourPoints) {
  
    // we get the size of our arraylist
    int size = ourPoints.size();
    // start off our string to return with an outer bracket
    String returnString = "[";
    
    // we iterate through our arraylist, grabbing the array at each
    // element and adding the X and Y values of that array to our
    // string alongside parentheses and commas accordingly
    for (int i = 0; i < size; i++) {
      double[] storedArray = ourPoints.get(i);
      returnString += "(" + storedArray[0] + ", " + storedArray[1] + "), ";
    }
    
    // once our for loop is over, we cut the last two characters of
    // our returnString and declare it to finalString. we then add
    // our closing bracket before returning finalString
    String finalString = returnString.substring(0, returnString.length() - 2);
    finalString += "]";
    return (finalString);
  }
  
  // our main method here
  public static void main(String[] args) {
  
    // create input scanner, create an empty array list, and then
    // prompt the user for how many points to store / sort
    Scanner input = new Scanner(System.in);
    ArrayList<double []> pointList = new ArrayList<>();
    System.out.print("How many points would you like to sort? ");
    int points = input.nextInt();
    
    // then we repeatedly ask the user for X and Y values until
    // we have the correct amount of points, and we assign these
    // x and y values as dobules to a double Array
    for (int i = 0; i < points; i++) {
      System.out.print("Enter X value for your point: ");
      double thisX = input.nextInt();
      System.out.print("Enter Y value for your point: ");
      double thisY = input.nextInt();
      double[] theseCoords = new double[2];
      theseCoords[0] = thisX;
      theseCoords[1] = thisY;
      // we then add this array to our arraylist and print out
      // a new line for formatting
      pointList.add(theseCoords);
      System.out.println();
    }
    
    // lastly, we print our unsorted and sorted arrays by first
    // calling printPoints with our original list, sorting it
    // with sortPoints, then calling printPoints a final time
    System.out.println("Unsorted: " + printPoints(pointList));
    sortPoints(pointList);
    System.out.println("Sorted  : " + printPoints(pointList));
  }
}