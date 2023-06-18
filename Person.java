public class Person {

  private String name;
  private int age;
  private String favoriteColor;
  

  /** 
   * Person constructor. 
   *
   * @param name  the name
   * @param age  the age
   * @param favoriteColor  the favorite color
   */
  public Person(String name, int age, String favoriteColor) { 
    this.name = name;
    this.age = age;
    this.favoriteColor = favoriteColor;
  }
  

  /** 
   * Sets the name
   *
   * @param name  the name
   */
  public void setName(String name) { 
    this.name = name;
  }
  

  /** 
   * Sets the age
   *
   * @param age  the age
   */
  public void setAge(int age) { 
    this.age = age;
  }
  
  
  /** 
   * Sets the favorite color
   *
   * @param favoriteColor  the favorite color
   */
  public void setFavoriteColor(String favoriteColor) { 

    this.favoriteColor = favoriteColor;
  }


  /** 
   * Gets the name of the Person
   *
   * @return the name
   */
  public String getName() { 
    return this.name;
  }
  

  /** 
   * Gets the age of the Person
   *
   * @return the age
   */
  public int getAge() { 
    return this.age;
  }
  

  /** 
   * Gets the favorite color of the Person
   *
   * @return the favorite color
   */
  public String getFavoriteColor() { 
    return this.favoriteColor;
  }
  
  /** 
   * Produces a string representation of the Person, e.g. Bob, 30 (favorite color: blue)
   *
   * @return a string representation of the Person
   */
  public String toString() { 
    return this.name + ", " + this.age + " (favorite color: " + this.favoriteColor + ")";
  }
}
