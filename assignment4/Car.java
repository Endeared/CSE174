/**
 * Defines a simple Car for keeping track of make, mileage, and color, 
 * as well as whether the car is dirty or clean.
 * @author Norm Krumpe
 * @version 1.0
 */

public class Car {

  public static double WASH_MILEAGE = 500.0;
  private String make;
  private double mileage;
  private double mileageWhenLastWashed;
  private String color;

  /**
   * Constructs a clean unpainted car with a specified make and mileage. 
   * @param make
   *            the make of the car (Mazda, Ford, etc.)
   * @param mileage
   *            the mileage of the car
   */
  public Car(String make, double mileage) {
    this.make = make;
    this.mileage = mileage;
    this.mileageWhenLastWashed = mileage;
    this.color = "UNPAINTED";
  }

  /**
   * Constructs a clean unpainted car with a specified make, setting the 
   * mileage to 0.0.
   * 
   * @param make
   *            the make of this car
   */
  public Car(String make) {
    this(make, 0.0);
  }

  /**
   * Gets the make of this car.
   * 
   * @return the make of this car
   */
  public String getMake() {
    return make;
  }

  /**
   * Gets the mileage of this car.
   * 
   * @return the mileage of this car
   */
  public double getMileage() {
    return mileage;
  }

  /**
   * Drives this car a specified distance, increasing the mileage whether this
   * car was driven forward or backward.
   * 
   * @param miles
   *            the miles driven (negative for driving in reverse)
   */
  public void drive(double miles) {
    mileage += Math.abs(miles);
  }
    
  /**
  * Gets the color of the car.
  * @return the color of the car.
  */
  public String getColor() {
    return color;
  }
    
  /**
  * Paints the car a specified color. The car
  * will be washed when it is painted.
  * @param color the new color for the car
  */
  public void paint(String color) {
    this.color = color;
    wash();
  }    
  
  /**
  * Emits an ear-piercing noise to alert pedestrians and 
  * other drivers that this car is nearby.
  */
  public void honkHorn() {
    System.out.println("BEEP BEEP!");
  }

  /**
   * Washes the car.
   */
  public void wash() {
    mileageWhenLastWashed = mileage;
  }

  /**
   * Returns true if the car is dirty. 
   * @return true if the car is considered dirty (driven more than WASH_MILEAGE
   *               miles since last wash), and false otherwise.
   */
  public boolean isDirty() {
    return mileage - mileageWhenLastWashed > WASH_MILEAGE;
  }

  /**
   * Returns a String representation of this car, useful for debugging.
   * purposes
   */
  public String toString() {
    return String.format("%s %s: %.1f miles, %s", color, make, mileage, 
        isDirty() ? "dirty" : "clean");
  }

}
