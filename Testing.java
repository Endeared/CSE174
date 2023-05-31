import java.util.*;

public class Testing {
  public static void main(String[] args) {
   
    Scanner in = new Scanner(System.in);
    int x = in.nextInt();
    int y = in.nextInt();
    
    if ( x < 0 ) {
        if ( y < 0 ) {
            System.out.println("A");
            System.out.println("B");
        } else if ( y == 0 ) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    } else if ( x == 0 ) {
        System.out.println("E");
    } else {
        if ( y % 2 == 0 ) {
            System.out.println("F");
        } else {
            System.out.println("G");
        }
    }
    
  }
}