/**
* Name: Ross Hamey
* Lab11 - You Put WHAT on Your Pizza?!
* CSE174
* This program executes a small pizza shop where the customer
* can choose to make their own pizza or create a "lucky" pizza.
* The program will display the customer's pizza choices and 
* the pizza cost at the end
*/

// scanner import for inputs
import java.util.Scanner;

public class PizzaShop {

  // scanner to grab inptus
  static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
  
    // menu selection
    int selection = 0;
    
    // do-while loop, prints out our main menu and takes
    // in our selection
    do {
      System.out.println("Welcome to the Pizza Shop!");
      System.out.println("--------------------------");
      System.out.println("1. Make my own pizza");
      System.out.println("2. Make a lucky pizza");
      System.out.println("3. Exit");
      System.out.print("Select an option: ");
      selection = in.nextInt();
      
      // checks to make sure selection isnt greater than 3
      // or less than 1. if it satisfies these conditions,
      // we evaluate whether our option is 1, 2, or 3 and
      // respond accordingly
      if (selection > 3 || selection < 1) {
        System.out.println("Invalid menu selection");
        continue;
      } else if (selection == 1) {
        makeMyOwn();
      } else if (selection == 2) {
        makeLuckyPizza();
      }
    } while (selection != 3);
    
    // print out our thanks for coming message when we exit
    System.out.println("Thanks for coming!");
      
  }
  
  // method that returns cost and details about a user
  // made pizza
  public static void makeMyOwn() {
  
    // printing out our initial selections and taking in inputs
    System.out.print("What size pizza would you like? (small/medium/large): ");
    String pizzaSize = in.next();
    System.out.print("What kind of crust would you like? "
        + "(thin/thick/stuffed): ");
    String crustType = in.next();
    
    // creating our pizza object, and creating a prompt to
    // check our first topping prompt response
    Pizza myPizza = new Pizza(pizzaSize, crustType);
    boolean firstToppingPrompt = false;
    
    // creating empty toppings string in correct scope
    String toppingsYesNo = "";
    
    // do-while loop to make sure user inputs y or n for
    // our first prompt before proceeding
    do {
      System.out.print("Any toppings? (y/n): ");
      toppingsYesNo = in.next();
      if (toppingsYesNo.equals("y") || toppingsYesNo.equals("n")) {
        firstToppingPrompt = true;
      }
    } while (firstToppingPrompt == false);
    
    // if our topping response equals y, we do more actions. if
    // it equals n, we proceed to the next steps
    if (toppingsYesNo.equals("y")) {
      // printing prompt for topping, creating addingToppings boolean
      // to keep prompting for toppings until we are done
      System.out.print("What topping would you like? ");
      boolean addingToppings = true;
      
      // continue loop until we are done adding toppings
      while (addingToppings == true) {
      
        // take in topping response, then add topping to pizza. we then
        // check if the topping exists in our pizza (added successfully
        // or not), and if it isnt, we throw an exception to reach our
        // catch statement. if it is added, we prompt the user for more
        // repeatedly
        String thisTopping = in.next();
        try {
          myPizza.addTopping(thisTopping);
          boolean added = myPizza.hasTopping(thisTopping);
          if (added == false) {
            throw new IllegalArgumentException("bad topping");
          }
          System.out.print("Topping added! Any other toppings? (y/n): ");
          String nestedYesOrNo = in.next();
          boolean anyOtherToppings = false;
          // while loop to make sure user enters y or n
          while (anyOtherToppings == false) {
            if (nestedYesOrNo.equals("y") || nestedYesOrNo.equals("n")) {
              break;
            }
            System.out.print("Any other toppings? (y/n): ");
            nestedYesOrNo = in.next();
          }
          
          // if we enter n, break out of addingToppings loop. otherwise,
          // ask for next topping
          if (nestedYesOrNo.equals("n")) {
            addingToppings = false;
          } else {
            System.out.print("What topping would you like? ");
          }
        // our catch statement. if we try to add an invalid topping,
        // we inform the user and ask for another topping
        } catch (Exception error) {
          System.out.print("Invalid topping. Any other toppings? (y/n): ");
          String nestedYesOrNo = in.next();
          boolean anyOtherToppings = false;
          // while loop to make sure user is inputting y or n
          while (anyOtherToppings == false) {
            if (nestedYesOrNo.equals("y") || nestedYesOrNo.equals("n")) {
              break;
            }
            System.out.print("Any other toppings? (y/n): ");
            nestedYesOrNo = in.next();
          }
          
          // if user inputs n, we break out of addingToppings loop.
          // otherwise, we just ask for the topping
          if (nestedYesOrNo.equals("n")) {
            addingToppings = false;
          } else {
            System.out.print("What topping would you like? ");
          }
        }
      }
    }
      
    // prompting user for delivery or carryout pizza, then taking
    // input and checking if it is delivery or carryout and
    // setting property appropriately
    System.out.print("Is the pizza for delivery or carryout? ");
    String deliveryOrCarryout = in.next();
    if (deliveryOrCarryout.equals("delivery")) {
      myPizza.setDelivery(true);
    } else if (deliveryOrCarryout.equals("carryout")) {
      myPizza.setDelivery(false);
    } else {
      myPizza.setDelivery(false);
    }
    
    // lastly, we get the pizza object in a string, and
    // print out our pizza string, and also call our
    // pizzaCost method with our myPizza object and print
    // out the cost accordingly (2 decimal places)
    String pizzaToString = myPizza.toString();
    System.out.printf("Your pizza: %s", pizzaToString);
    System.out.println();
    System.out.printf("Pizza cost: $%.2f", pizzaCost(myPizza));
    System.out.println();
    System.out.println();
    
  }
    
  // method that returns information and cost for a pizza
  // object generated by a user-selected integer
  public static void makeLuckyPizza() {
  
    // grabbing lucky number input from user
    System.out.print("Enter a lucky number: ");
    int luckyNumber = in.nextInt();
    
    // creating new pizza object from lucky number and
    // then formatting it to a string
    Pizza luckyPizza = new Pizza(luckyNumber);
    String pizzaToString = luckyPizza.toString();
    
    // printing out details about our pizza object and
    // cost of our pizza by calling pizzaCost method
    // (2 decimal places)
    System.out.printf("Your pizza: %s", pizzaToString);
    System.out.println();
    System.out.printf("Pizza cost: $%.2f", pizzaCost(luckyPizza));
    System.out.println();
    System.out.println();
    
  }

  /*
  * method that takes in a pizza object and returns cost
  * @param p a Pizza Object
  * @return cost of Pizza Object in double
  */
  public static double pizzaCost(Pizza p) {

    // creating our costs for pizza types. we could
    // skip this part but if we were to use this info
    // later i thought it might be useful
    double smallCost = 3.00;
    double medCost = 4.50;
    double largeCost = 6.50;
    double stuffedSmall = 4.00;
    double stuffedMed = 6.50;
    double stuffedLarge = 9.50;
    double delivery = 2.00;
    double totalCost = 0.00;
    
    // grabbing our crust, size, topping count, delivery
    // status, and whether the pizza has anchovies for our
    // pizza object
    String crustType = p.getCrust();
    String pizzaSize = p.getSize();
    int toppingsCount = p.toppingCount();
    boolean hasAnchovies = p.hasTopping("anchovies");
    boolean isDelivered = p.getDelivery();
    
    // size + crust checks, we check for small, medium
    // large pizzas with or without stuffed crust, and
    // increment our totalCost value by our previously
    // defined costs
    if (pizzaSize.equals("small")) {
      if (crustType.equals("stuffed")) {
        totalCost += stuffedSmall;
      } else {
        totalCost += smallCost;
      }
    } else if (pizzaSize.equals("medium")) {
      if (crustType.equals("stuffed")) {
        totalCost += stuffedMed;
      } else {
        totalCost += medCost;
      }
    } else if (pizzaSize.equals("large")) {
      if (crustType.equals("stuffed")) {
        totalCost += stuffedLarge;
      } else {
        totalCost += largeCost;
      }
    } else {
      totalCost += 0;
    }
    
    // we add to our totalCost however many toppings
    // we have * 0.50 (50 cents)
    totalCost += (toppingsCount * 0.50);
    
    // we check if we have anchovies on the pizza,
    // and if we do we add 50 cents to the cost
    if (hasAnchovies == true) {
      totalCost += 0.50;
    }
    
    // if our pizza is delivery and the cost is
    // 10 or over, we dont add a fee and just return
    // the current cost. otherwise, if it is delivery
    // and under 10, we add a 2 dollar fee and return
    // the cost
    if (isDelivered == true) {
      if (totalCost >= 10.00) {
        return totalCost;
      } else {
        totalCost += 2.00;
        return totalCost;
      }
    // otherwise, if our pizza is carryout, we just
    // return the total cost
    } else {
      return totalCost;
    }
    
  }

}