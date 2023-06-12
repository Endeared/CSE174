/* cse174 assignment4 - dont drive angry
   Ross Hamey
   6/12/2023 */

// scanner import for our values
import java.util.Scanner;

public class Race {

  // assigning our global variables to be accessed
  // across multiple methods
  static int raceLength;
  static Car carA = new Car("Ford", 0.0);
  static Car carB = new Car("Honda", 0.0);

  public static void main(String[] args) {
    
    // painting each car
    carA.paint("Red");
    carB.paint("Blue");
    
    //This code is provided to students to setup seeded
    //random number generators for driving the cars
    //and determine the race length
    Scanner in = new Scanner(System.in);
    int carASeed = in.nextInt();
    RandomMiles carARand = new RandomMiles(carASeed);
    int carBSeed = in.nextInt();
    RandomMiles carBRand = new RandomMiles(carBSeed);
    raceLength = in.nextInt();
    
    // assigning day count for day status prints
    int day = 0;
    
    // while the race is not over, increment the day and
    // call drive for each car. then, grab mileage, and
    // call printStatus and print out appropriate prompts
    do {
      day += 1;
      drive(carA, carARand);
      drive(carB, carBRand);
      double carAmileage = carA.getMileage();
      double carBmileage = carB.getMileage();
      
      System.out.println("Day " + day + ":");
      printStatus(carAmileage, carBmileage);
      System.out.println();
    } while (!raceOver());
    
    // lastly, print out winner of the race by calling
    // getWinner
    System.out.println(getWinner());   
  }
  
  /* helper method to print and format the status of each
   * car during each day of the race. i use this to keep
   * method lengths less than 25 lines. takes in the
   * mileage for each car.
   * @param carAMiles the mileage of carA (in double)
   * @param carBMiles the mileage of carB (in double)
   */
  public static void printStatus(double carAMiles, double carBMiles) {
  
    // checking if carA is dirty or not and printing out
    // correct prompt with miles
    if (carA.isDirty()) {
      System.out.printf("Red Ford: %.1f miles, dirty", carAMiles);
      System.out.println();
    } else {
      System.out.printf("Red Ford: %.1f miles, clean", carAMiles);
      System.out.println();
    }
    
    // checking if carB is dirty or not and printing out
    // correct promprt with miles
    if (carB.isDirty()) {
      System.out.printf("Blue Honda: %.1f miles, dirty", carBMiles);
      System.out.println();
    } else {
      System.out.printf("Blue Honda: %.1f miles, clean", carBMiles);
      System.out.println();
    }
    
    return;
  }
  
  /* method that returns a prompt of the winning car as
   * a string message. if both cars have same miles, the
   * method will instead return "It's a tie!".
   * @return the winner of the race as color and make
   */
  public static String getWinner() {
   
    // grabbing mileage of each car
    double milesA = carA.getMileage();
    double milesB = carB.getMileage();
    
    // comparing miles and responding accordingly
    if (milesA > milesB) {
      return ("Congratulations to the Winner: Red Ford");
    } else if (milesB > milesA) {
      return ("Congratulations to the Winner: Blue Honda");
    } else {
      return ("Congratulations to the Winner: It's a tie!");
    }
  
  }
  
  /* method that determines if the race is over and returns
   * the status as a boolean. a race is over if either car
   * has crossed the finish line / race length.
   * @return true if race is over, false if not
   */
  public static boolean raceOver() {
  
    // grabbing miles for each car
    double milesA = carA.getMileage();
    double milesB = carB.getMileage();
    
    // seeing if either miles are over the race length
    if (milesA >= raceLength || milesB >= raceLength) {
      return true;
    } else {
      return false;
    }
    
  }
  
  /* method that drives the car or washes the car for
   * the day. if the car is dirty, it is washed. otherwise,
   * the car is driven by a random amount of miles based
   * on that car's RandomMiles object.
   * @param car the Car that is being called
   * @param rand the RandomMiles object for that car
   */
  public static void drive(Car car, RandomMiles rand) {
   
    // checking if car is dirty. if so, wash - otherwise,
    // drive by random amount of miles using getRandom()
    if (car.isDirty()) {
      car.wash();
    } else {
      car.drive(rand.getRandom());
    }
    
  }
  
  
}