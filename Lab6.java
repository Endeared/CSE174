/* cse174 lab6 - add em up, break em down
   Ross Hamey
   6/7/2023 */

public class Lab6 {

  /*
  * method returns the sum of two integers
  * @param n1 an integer value
  * @param n2 an integer value
  * @return sum of n1 and n2
  */
  public static int add(int n1, int n2) {
    // calculate sum of inputs and return it
    int sum = n1 + n2;
    return sum;
  }
  
  /*
  * method returns the sum of three integers
  * @param n1 an integer value
  * @param n2 an integer value
  * @param n3 an integer value
  * @return sum of n1, n2, and n3
  */
  public static int add(int n1, int n2, int n3) {
    // calculate sum of inputs and return it
    int sum = n1 + n2 + n3;
    return sum;
  }
  
  /*
  * method returns the sum of four integers
  * @param n1 an integer value
  * @param n2 an integer value
  * @param n3 an integer value
  * @param n4 an integer value
  * @return sum of n1, n2, n3, and n4
  */
  public static int add(int n1, int n2, int n3, int n4) {
    // calculate sum of inputs and return it
    int sum = n1 + n2 + n3 + n4;
    return sum;
  }
  
  /*
  * method returns the sum of five integers
  * @param n1 an integer value
  * @param n2 an integer value
  * @param n3 an integer value
  * @param n4 an integer value
  * @param n5 an integer value
  * @return sum of n1, n2, n3, n4, and n5
  */
  public static int add(int n1, int n2, int n3, int n4, int n5) {
    // calculate sum of inputs and return it
    int sum = n1 + n2 + n3 + n4 + n5;
    return sum;
  }
  
  /*
  * method returns true or false if an integer is breakable
  * @param num an integer value
  * @return boolean as true / false
  */
  public static boolean isBreakable(int num) {
    // convert integer to a string
    String stringNum = String.valueOf(num);
    
    // iterate through each character of the string
    for (int i = 0; i < stringNum.length(); i++) {
      // for each iteration, assign a boolean foundNotPrime
      // which we use to check if a digit is not a prime num
      boolean foundNotPrime = false;
      
      // grab the character at the current index, convert the
      // character into string, then convert string to integer
      // (as trying to directly cast a char to int gives us the
      // ascii value)
      char thisChar = stringNum.charAt(i);
      String thisCharString = String.valueOf(thisChar);
      int thisDigit = Integer.parseInt(thisCharString);
      
      // if the digit is greater than or equal to 4, it has
      // the possibility to not be prime, so we then create
      // another loop
      if (thisDigit >= 4) {
        // next loop starts at 2 since dividing by 0 isnt possible
        // and every positive int can be divided by 1. iterate
        // up to int before thisDigit, and if any digit in the loop
        // is divisible by our iterator j with a remainder of 0, the
        // number is not prime, so we assigne foundNotPrime to true
        for (int j = 2; j < (thisDigit); j++) {
          if ((thisDigit % j) == 0) {
            foundNotPrime = true;
          }
        }
      // otherwise, if the digit is equal to 0 or 1, it isnt prime
      // and we assign foundNotPrime to true
      } else if (thisDigit == 0 || thisDigit == 1) {
        foundNotPrime = true;
      // otherwise, if the digit is 3, its prime so return true
      } else if (thisDigit < 4) {
        return true;
      }
      // lastly, if foundNotPrime is still false meaning we didnt
      // find a non-prime digit, we return true
      if (foundNotPrime == false) {
        return true;
      }
    }
    // if foundNotPrime is true, we end up returning false
    return false;
  }
  
  /*
  * method returns true or false if an double is breakable
  * on one side, but not on both
  * @param double a decimal number / double value
  * @return boolean as true / false
  */
  public static boolean isBreakable(double num) {
    // this above method was too long on the code style
    // check, but not on jgrasp. couldnt imagine
    // squashing this into 25 lines without a major
    // rewrite
  
    // convert double to string so we can iterate through all
    // the characters
    String stringNum = String.valueOf(num);
    
    // create empty strings to store both halves of the string
    // double on either side of the decimal
    String firstHalf = "";
    String secondHalf = "";
    
    // assign decimal int to 0, we will change this later when
    // we find the decimal and use this as our decimal index
    int decimal = 0;
    
    // create two booleans that track whether the first or
    // second halves of the num are breakable or not (both
    // sides of the decimal)
    boolean firstHalfBreakable = false;
    boolean secondHalfBreakable = false;
    
    // our first loop, we iterate through our stringNum and
    // stop when we reach the decimal, adding each char to
    // our firstHalf string
    for (int i = 0; i < stringNum.length(); i++) {
      // try-catch to find our decimal
      try {
        // convert character at index i (our iterator) to a
        // char, then convert that char back to string, then
        // try to parseInt our string. if the parseInt succeeds,
        // we then add that substring to our firstHalf string
        char thisChar = stringNum.charAt(i);
        String thisCharString = String.valueOf(thisChar);
        int thisDigit = Integer.parseInt(thisCharString);
        firstHalf += thisCharString;
      // if our parseInt fails and we receive an exception, we know
      // that the value is the decimal we were looking for, so
      // we assign decimal to i (the index of that character) and
      // break
      } catch (Exception error) {
        decimal = i;
        break;
      }
    }
    
    // our second loop, we iterate through our stringNum starting
    // at 1 index above our decimal index, adding each char to
    // our secondHalf string
    for (int i = (decimal + 1); i < stringNum.length(); i++) {
      // we know the rest of the "digits" in our string should all
      // be viable ints, so we convert the character at the index to
      // a char, then convert it to a string
      char thisChar = stringNum.charAt(i);
      String thisCharString = String.valueOf(thisChar);
      secondHalf += thisCharString;
    }
    
    // our 3rd loop, here we will iterate through our firstHalf
    // string and look for prime or non-prime digits on this side
    // of the decimal
    for (int i = 0; i < firstHalf.length(); i++) {
      // we assign a foundNotPrime boolean to false to track whether
      // we have found a prime number or not
      boolean foundNotPrime = false;
      
      // we convert the character at the index i (our iterator) of
      // this firstHalf string to a character, then convert it to a
      // string, then convert the string to an int using parseInt.
      char thisChar = firstHalf.charAt(i);
      String thisCharString = String.valueOf(thisChar);
      int thisDigit = Integer.parseInt(thisCharString);
      
      // if our int is greater than or equal to 4, we create a new
      // loop
      if (thisDigit >= 4) {
        // we iterate through all digits less than our current digit
        // starting at 2, and if our current digit is divisible by any
        // of these said digits with a remainder of 0, we know it is
        // not a prime number and we set foundNotPrime to true
        for (int j = 2; j < (thisDigit); j++) {
          if ((thisDigit % j) == 0) {
            foundNotPrime = true;
          }
        }
      // otherwise, if our digit is less than 4 and is 0 or 1, the
      // digit is not prime so we set foundNotPrime to true
      } else if (thisDigit == 0 || thisDigit == 1) {
        foundNotPrime = true;
      // otherwise, if our digit is 3, we know it is a prime number
      // so we set firstHalfBreakable to true and break out of the
      // for loop
      } else if (thisDigit < 4) {
        firstHalfBreakable = true;
        break;
      }
      
      // lastly, if foundNotPrime is still equal to false (meaning our
      // number was greater than or equal to 4 and was not a non-prime
      // number), we set firstHalfBreakable to true and break the for
      // loop
      if (foundNotPrime == false) {
        firstHalfBreakable = true;
        break;
      }
    }
    
    // our last for loop of our main block in our method, we iterate
    // through our secondHalf string and look for prime numbers
    for (int i = 0; i < secondHalf.length(); i++) {
      // we create a foundNotPrime boolean to track whether we have
      // found a prime number or not
      boolean foundNotPrime = false;
      
      // for each character in the string at the index of our 
      // iterator i, we declare the character as a char and then
      // convert the char to a string, then convert the string to
      // an int
      char thisChar = secondHalf.charAt(i);
      String thisCharString = String.valueOf(thisChar);
      int thisDigit = Integer.parseInt(thisCharString);
      
      // if our digit int is greater than or equal to 4, we create
      // a nested loop
      if (thisDigit >= 4) {
        // we check each digit between 2 and thisDigit - 1, and if
        // thisDigit divided by any of those digits has a remainder
        // of 0, we know the digit is non-prime, so we assign
        // foundNotPrime to true
        for (int j = 2; j < (thisDigit); j++) {
          if ((thisDigit % j) == 0) {
            foundNotPrime = true;
          }
        }
      // otherwise, if our digit is less than 4 and is 0 or 1, then
      // the number is prime so we assign foundNotPrime to true
      } else if (thisDigit == 0 || thisDigit == 1) {
        foundNotPrime = true;
      // otherwise, if our digit is 3, we know 3 is a prime number
      // so we assign secondHalfBreakable to true and break the loop
      } else if (thisDigit < 4) {
        secondHalfBreakable = true;
        break;
      }
      
      // lastly, if foundNotPrime is still equal to false, meaning
      // we failed to find a non-prime number, we assign
      // secondHalfBreakable to true and break
      if (foundNotPrime == false) {
        secondHalfBreakable = true;
        break;
      }
    }
    
    // now we do our final checks to determine what we return from
    // this method. if both halves are breakable, we return false
    // since we are checking if only one half is breakable. so, if
    // both halves are NOT breakable we return false, and then
    // any other case (one half breakable one half not), we return
    // true since it satisfies our requirements
    if (firstHalfBreakable == true && secondHalfBreakable == true) {
      return false;
    } else if (firstHalfBreakable == false && secondHalfBreakable == false) {
      return false;
    } else {
      return true;
    }
  }
}