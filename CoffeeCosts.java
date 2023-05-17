/* cse174 lab1pt2 - calculating coffee costs
   Ross Hamey
   5/17/2023 */
   
/* when calculating the average total costs for
each month, i was able to find that using float 3.0
instead of int 3 as my month count yielded the
correct result of 166.68335 for medium, but yielded
187.81668 for small unless i changed the order of
operations around... wasnt really sure how else
to get around this... */

public class CoffeeCosts {
  public static void main(String[] args) {
  
    /* declaring costs as constant values... tried
    to follow java style guidelines for this,
    still not particularly used to multiple keywords 
    being used to help define variables, coming from 
    python/js/lua background... */
    final float SMALL_PRICE = 2.95f;
    final float MEDIUM_PRICE = 3.65f;
    final float LARGE_PRICE = 4.15f;
    
    // declaring small counts + small prints
    int febCountSm = 60;
    int marCountSm = 68;
    int aprCountSm = 63;
    int smallTotalCount = febCountSm + marCountSm + aprCountSm;
    float smallTotalAvgCost = (smallTotalCount * SMALL_PRICE / 3.0f);
    System.out.println("Number of small coffees bought: " + smallTotalCount);
    System.out.println("Average monthly price of buying small: $" + smallTotalAvgCost);
    
    // declaring medium counts + medium prints
    int febCountM = 43;
    int marCountM = 48;
    int aprCountM = 46;
    int mediumTotalCount = febCountM + marCountM + aprCountM;
    float mediumTotalAvgCost = (mediumTotalCount / 3.0f * MEDIUM_PRICE);
    System.out.println("Number of medium coffees bought: " + mediumTotalCount);
    System.out.println("Average monthly price of buying medium: $" + mediumTotalAvgCost);
    
    // declaring large counts + large prints
    int febCountL = 28;
    int marCountL = 31;
    int aprCountL = 30;
    int largeTotalCount = febCountL + marCountL + aprCountL;
    float largeTotalAvgCost = (largeTotalCount / 3.0f * LARGE_PRICE);
    System.out.println("Number of large coffees bought: " + largeTotalCount);
    System.out.println("Average monthly price of buying large: $" + largeTotalAvgCost);
    
  }
}