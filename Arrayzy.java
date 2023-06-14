/* cse174 lab8 - you drive me arrayzy
   Ross Hamey
   6/14/2023 */

public class Arrayzy {
  
  /* makeArray method to create a 1D array
   * @param numberOfValues the int number that you want to be
   * the length of the array
   * @param fillValue the int number that you want to fill each
   * element of the array
   * @return myArray the array created by the method
   */
  public static int[] makeArray(int numberOfValues, int fillValue) {
  
    // assign our array with length numberOfValues
    int[] myArray = new int[numberOfValues];
    
    // iterate through our array, fill each element with fillValue
    // then return array
    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = fillValue;
    }
    return myArray;
    
  }
  
  /* makeArray method to create a 2D array
   * @param rows the int number of rows for the matrix / 2d array
   * @param columns the int number of columns for the matrix / 2d array
   * @param fillValue the int number you want to fill each element
   * @return myArray the 2D array created by the method
   */
  public static int[][] makeArray(int rows, int columns, int fillValue) {
  
    // declare our 2d array with appropriate rows / columns
    int[][] myArray = new int[rows][columns];
    
    // iterate through each row and call our makeArray method
    // to build a 1d array of length columns populated with
    // our fillValue val, then return 2d array
    for (int i = 0; i < myArray.length; i++) {
      myArray[i] = makeArray(columns, fillValue);
    }
    return myArray;
    
  }
  
  /* print method to print a 1D array in an easy to view format
   * @param array an int 1D array
   */
  public static void print(int[] array) {
  
    // iterate through each element within array, then
    // print that element followed by a space
    for (int i = 0; i < array.length; i++) {
      System.out.print(array[i] + " ");
    }
    // print new line to separate this print from
    // other prints
    System.out.println();
    
  }
  
  /* print method to print a @D array in an easy to view format
   * @param array an int 2D array
   */
  public static void print(int[][] array) {
  
    // nested for loop - we iterate through each element
    // of our outer array
    for (int i = 0; i < array.length; i++) {
      // and in the inner array, we iterate through each
      // element within that inner array, and print the
      // element followed by a space
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      // at the end of each iteration through the inner
      // array, we print a new line for formatting
      System.out.println();
    }
    // lastly we print a new line to separate this
    // print from other prints
    System.out.println();
    
  }
  
}