/* cse174 lab8 - you drive me arrayzy
   Ross Hamey
   6/1/2023 */

// scanner import for our values
import java.util.Scanner;

public class TEST {
  
  public int[] remove(int[] arr, int index) {
    int[] newArray = new int[arr.length - 1];
    for (int i = 0; i < arr.length; i++) {
      if (i < index) {
        newArray[i] = arr[i];
      } else if (i == index) {
        continue;
      } else {
        newArray[i] = arr[i];
      }
    }
    return newArray;
  }
  
  public static void main(String[] args) {
    remove([1, 2, 3], 2);
  }



  
}