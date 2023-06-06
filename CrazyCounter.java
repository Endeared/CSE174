/* cse174 assignment3 - crazy counter
   Ross Hamey
   6/5/2023 */
   
// scanner import for inputs
import java.util.Scanner;

public class CrazyCounter {
  public static void main(String[] args) {
    
    // declaring our initial vars / scanner var.
    // booleans are for our do-while loop checks,
    // and our startCount / endCount / step are for
    // later inputs
    Scanner input = new Scanner(System.in);
    boolean valid = false;
    boolean firstInt = false;
    boolean secondInt = false;
    boolean thirdInt = false;
    boolean correct = false;
    int startCount = 0;
    int endCount = 0;
    int step = 0;
    
    // first do-while loop, we repeat the initial 3 set prompt
    // until our valid boolean is true (aka we get 3 viable inputs)
    do {
    
      // first nested do-while loop, we repeat this prompt until
      // we get a valid input for our startCount
      do {
        System.out.print("Where would you like to start counting? ");
        // we try converting our input to an integer, if it works
        // we break out of this loop by setting the boolean to
        // true. otherwise, our catch statement prompts the user
        // for another input
        try {
          startCount = Integer.parseInt(input.next());
          firstInt = true;
        } catch (Exception error) {
          System.out.println("Silly you! That's not a number. Try again.");
        }
      } while (!firstInt);
      
      // second nested do-while loop. again, we repeat this prompt
      // until we have a valid input for endCount
      do {
        System.out.print("Where would you like to finish counting? ");
        // again, we try converting our input to an integer. same as
        // before, if it works we break out of the loop by setting the
        // boolean to true, otherwise our catch statement again prompts
        // the user for another input
        try {
          endCount = Integer.parseInt(input.next());
          secondInt = true;
        } catch (Exception error) {
          System.out.println("Silly you! That's not a number. Try again.");
        }
      } while (!secondInt);
      
      // final nested do-while loop. as usual, we are just
      // repeating a prompt until we have a valid inptu for step
      do {
        System.out.print("What number do you want to count by? ");
        // again, we try converting our input to an integer. same as
        // before, if it works we break out of the loop by setting the
        // boolean to true, otherwise our catch statement again prompts
        // the user for another input
        try {
          step = Integer.parseInt(input.next());
          thirdInt = true;
        } catch (Exception error) {
          System.out.println("Silly you! That's not a number. Try again.");
        }
      } while (!thirdInt);
      
      // first of our final checks before we declare the inputs
      // as valid. if our step is less than 1 / less than or
      // equal to 0, we prompt the user for a new set of inputs
      if (step <= 0) {
        System.out.println("Silly you! You can't count by less than 1." 
            + " Try again.");
        System.out.println();
      // second check, if our startCount is greater than our
      // endCount, we prompt the user for a new set of inputs
      } else if (startCount > endCount) {
        System.out.println("Silly you! The start can't come after the end."
            + " Try again.");
        System.out.println();
      // otherwise, if the other checks pass, we set our valid
      // boolean to true to break out of the loop
      } else {
        valid = true;
      }
    } while (!valid);
    
    // printing new lines for formatting and our initial
    // preparation prompt
    System.out.println();
    System.out.println("Get Ready to Count from " + startCount + " to " 
        + endCount + " by " + step + "!");
    System.out.println();
    
    // this should always be our very first prompt no matter what,
    // so i just decided to put this here
    System.out.print("What number comes first? ");
      
    // for loop, we set an interator int to our startCount, and while
    // that iterator is <= our endCount, we repeat the loop and increment
    // the iterator by the step each time.
    for (int iterator = startCount; iterator <= endCount; iterator += step) {
      // we set our correct to false at the start of each iteration
      correct = false;
      
      // first check, if our iterator is equal to startCount, meaning
      // startCount hasnt been incremented yet, we know we are on the
      // first number of our counter which requires special prompts
      if (iterator == startCount) {
        // nested do-while loop which repeats until the user
        // is correct with their guess
        do {
          // try-catch statement. we try to assign the user input
          // to an int. if we fail, we print out a prompt asking
          // for another input
          try {
            int thisGuess = Integer.parseInt(input.next());
            // if our input IS a number, we create our first check, which
            // sees if our guess is correct.
            if (thisGuess == startCount) {
              // if our guess is correct, we need to check if our future
              // iterator value is more than the endCount, which we do
              // by adding step to our startCount. we do this because
              // if our future value is greater than the endCount, we
              // should print out the end prompt right now. admittedly,
              // this took me a little while to figure out from the hidden
              // tests...
              if ((step + startCount) > endCount) {
                System.out.println("That's right! You did it!");
                // setting boolean to true to break out of do-while loop
                correct = true;
              // otherwise, if our future iterator isnt more than the
              // endCount, we know our program shouldnt terminate after
              // this guess, so we prompt for the next number.
              } else {
                System.out.print("That's right! What number comes next? ");
                // setting boolean to true to break out of do-while loop
                correct = true;
              }
            // if our guess is incorrect, prompt the user for a new guess
            } else {
              System.out.print("Sorry, that's incorrect! "
                  + "What number comes next? ");
            }
          // our catch as described from earlier. if the user puts in
          // a non-number, we print these statements
          } catch (Exception error) {
            System.out.println("Silly you! That's not a number. Try again.");
            System.out.print("What number comes first? ");
          } 
        } while (!correct);
      
      // second check. if our iterator is <= (endCount - step)), we know
      // this is not the last guess in our program, so there should always
      // be a prompt for the next number.
      } else if (iterator <= (endCount - step)) {
        // keep prompting the user for an input until it is valid with
        // this loop
        do {
          // we use this try-catch to see if the user inputs a number.
          // if they dont, in our catch statement we ask for a new
          // input
          try {
            // trying to assign input to int
            int thisGuess = Integer.parseInt(input.next());
            // if our guess is correct and our input can be converted,
            // to an int, prompt accordingly and break out of the loop
            // by assigning boolean to true
            if (thisGuess == iterator) {
              System.out.print("That's right! What number comes next? ");
              correct = true;
            // otherwise, prompt for guess again
            } else {
              System.out.print("Sorry, that's incorrect!"
                  + " What number comes next? ");
            }
          // catch statement as described earlier
          } catch (Exception error) {
            System.out.println("Silly you! That's not a number. Try again.");
            System.out.print("What number comes next? ");
          }
        } while (!correct);
        
      // default behavior, which should always be the last guess of our
      // program given the logic above
      } else {
        // do-while loop that will continue to prompt user for an input
        // while our boolean is false
        do {
          // try-catch statement. if our user inputs a number, we continue,
          // if they dont, we ask for a new input in our catch statement
          try {
            // trying to assign input to int
            int thisGuess = Integer.parseInt(input.next());
            // if our guess is correct and our input can be converted,
            // to an int, prompt accordingly and break out of the loop
            // by assigning boolean to true. this is our last prompt
            if (thisGuess == iterator) {
              System.out.println("That's right! You did it!");
              correct = true;
            // if our guess is incorrect, prompt user for a new guess
            } else {
              System.out.print("Sorry, that's incorrect!" 
                  + " What number comes next? ");
            }
          // catch statement as described earlier
          } catch (Exception error) {
            System.out.println("Silly you! That's not a number. Try again.");
            System.out.print("What number comes next? ");
          }
        } while (!correct);
        
      }
    }
  
      
  }
}