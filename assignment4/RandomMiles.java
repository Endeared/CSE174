import java.util.Random;

public class RandomMiles {

  private Random rand;
  
  public RandomMiles(int seed){
    rand = new Random(seed);
  }
  
  public int getRandom() {
    return rand.nextInt(300);
  }

}