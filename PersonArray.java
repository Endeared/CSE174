/* cse174 lab9 - people arent objects
   Ross Hamey
   6/16/2023 */

// arrays import from 6.3 for our toString
// in our print method
import java.util.Arrays;

public class PersonArray {
   
  /* print method to take an array of person objects, and
   * print out a new array of each person's name and
   * their age
   * @param arr an array of Person objects
   */
  public static void print(Person[] arr) {
  
    // create new array
    String[] newArr = new String[arr.length];
    
    // iterate input array, grabbing name and age of each
    // object at index and formatting it then assigning
    // it to the new array
    for (int i = 0; i < arr.length; i++) {
      String name = arr[i].getName();
      String age = Integer.toString(arr[i].getAge());
      newArr[i] = "(" + name + ", " + age + ")";
    }
    
    // print out new array
    System.out.println(Arrays.toString(newArr));
    
  }
  
  /* helper method to check if two Person objects are matches
   * @param thisPerson any given Person object
   * @param key a Person object to use as a benchmark
   * @return true if both inputs match, false if not
   */
  public static boolean checkIfMatch(Person thisPerson, Person key) {
  
    // 3 if statements - we check if our current person object
    // and key object match eachother with respect to their
    // names, ages, and favorite colors. couldve done this with
    // && but preferred this for more flexibility
    if (thisPerson.getName() == key.getName()) {
      if (thisPerson.getAge() == key.getAge()) {
        if (thisPerson.getFavoriteColor() == key.getFavoriteColor()) {
          // if everything matches, return true
          return true;
        }
      }
    }
    // otherwise, return false
    return false;
  }
  
  /* insert method to take an array of Person objects, a position
   * and a provided Person object to insert into the array
   * @param arr an array of Person objects
   * @param pos an int index to insert an object into arr at
   * @param newPerson a Person object to insert into arr
   * @return newArr an array of Person objects with newPerson
   * added at index pos
   */
  public static Person[] insert(Person[] arr, int pos, Person newPerson) {
  
    // creating new person array
    Person[] newArr = new Person[arr.length + 1];
    
    // iterating through array, and simply duplicating
    // values from first array into new array EXCEPT
    // at our target pos, where we insert newPerson
    for (int i = 0; i <= arr.length; i++) {
      if (i < pos) {
        newArr[i] = arr[i];
      } else if (i == pos) {
        newArr[i] = newPerson;
      } else {
        newArr[i] = arr[i - 1];
      }
    }
    
    // return our new array
    return newArr;
  }
  
  /* remove method to take an array of Person objects and
   * a position, then remove the Person object at that position
   * in the array, then returns new array
   * @param arr an array of Person objects
   * @param pos the int index to remove from arr
   * @return newArr an array of Person objects with the Person
   * at index pos removed
   */
  public static Person[] remove(Person[] arr, int pos) {
    
    // creating new person array
    Person[] newArr = new Person[arr.length - 1];
    
    // iterating through our input array, and duplicating
    // values from input array into new array EXCEPT at
    // our target pos, where we skip that element
    for (int i = 0; i < arr.length; i++) {
      if (i < pos) {
        newArr[i] = arr[i];
      } else if (i == pos) {
        continue;
      } else {
        newArr[i - 1] = arr[i];
      }
    }
    
    // return new array
    return newArr;
  }

  /* linearSearch method to take an array of Person objects
   * and a key Person object, and find the first match /
   * instance of that key within the array using a linear
   * search algorithm
   * @param arr an array of Person objects to search
   * @param key a Person object to search for in arr
   * @return i the int index at which a match is found for
   * the key, otherwise returns -1
   */
  public static int linearSearch(Person[] arr, Person key) {
    
    // iterating each element in our input array and
    // seeing if it matches our key by calling our
    // checkIfMatch helper method
    for (int i = 0; i < arr.length; i++) {
      if (checkIfMatch(arr[i], key)) {
        // if its a match (checkIfMatch returns true),
        // we return the index it was found at
        return i;
      }
    }
    
    // otherwise, no match was found so we return -1
    return (-1);
  }
  
  /* binarySearch method to take an array of Person objects
   * and a key Person object, and find the first match /
   * instance of thet key within the array using a binary
   * search algorithm
   * @param arr an array of Person objects to search in
   * @param key a Person object to search for in arr
   * @return i the int index at which a match is found for
   * the key within the array, otherwise returns -1
   */
  public static int binarySearch(Person[] arr, Person key) {
  
    // assigning our min, max, and current index for our
    // binary search (our search window / frame)
    int min = 0;
    int max = arr.length - 1;
    int index = 0;
    
    // while min <= max (meaning we still have a frame
    // to search in
    while (min <= max) {
      // we assign our index as the halfway point of our
      // frame, then we check for a match at that index
      // to our key. if we get a match, we return the
      // index, otherwise, we adjust our min and max based
      // on whether our key age is < or > our element age
      // at our index and repeat
      index = (min + max) / 2;
      if (checkIfMatch(arr[index], key)) {
        return index;
      } else if (arr[index].getAge() < key.getAge()) {
        min = index + 1;
      } else {
        max = index - 1;
      }
    }
    
    // otherwise, no match was found so we return -1
    return (-1);
  }

  
}