import java.util.Scanner;

public class Testing2 {
  public static void main(String[] args) {
          
    int years = 50;
    double balance = 10000;
    double targetBalance = 20000;
    double rate = 3;
    for (int i = 1; i <= years; i++) {
       if (balance >= targetBalance) {
          i = years + 1;
       } else {
          double interest = balance * rate / 100;
          balance = balance + interest;
       }
       System.out.println("executed");
    }

  }
}
