public class Testing {
  public static void main(String[] args) {
   
    double base = 3.0;
    double root = Math.sqrt(base);
    
    double testOne = 1.0;
    double testTwo = 5.44;
    double testThree = 14.447;
    
    System.out.printf("With a base of %.2f, the root of said base is %.4f.%n", base, root);
    System.out.printf("%6.2f%n", testOne);
    System.out.printf("%6.2f%n", testTwo);
    System.out.printf("%6.2f%n", testThree);
    
  }
}