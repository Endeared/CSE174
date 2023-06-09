import java.awt.Point;

public class Testing { 
  public static void main(String[] args) {
  
    Point a = new Point(3, 4);
    Point b = null;
    

    System.out.println(a);
    
    System.out.println(a.equals(b));
    
    System.out.println(a == b);
    
    System.out.println(b);
    
    boolean result = (b == b);
    
  }

}