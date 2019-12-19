import java.util.*;

public class RNG
{
   private int minimumValue;
   private int maximumValue;
   
   /** 
   * The default constructor of the RNG class
   */ 
   public RNG()
   {
      minimumValue = 0;
      maximumValue = 0;
   }
   
   /** 
   * The alternate constructor of the RNG class
   * @param newMinimumValue: minimum limit of the random number
   * @param newMaximumValue: maximum limit of the random number
   */ 
   public RNG(int newMinimumValue,int newMaximumValue)
   {
      minimumValue = newMinimumValue;
      maximumValue = newMaximumValue;
   }
   
   /** 
   * The accessor method to get the minimum value
   */ 
   public int getMinimumValue()
   {
   return minimumValue; 
   }
   
   /** 
   * The accessor method to get the maximum value
   */ 
   public int getMaximumValue()
   {
   return maximumValue; 
   }
   
   /** 
   * The mutator method to set the minimum value
   * @param newMinimumValue: minimum limit to be set
   */ 
   public void setMinimumValue(int newMinimumValue)
   {
   minimumValue = newMinimumValue; 
   }
   
   /** 
   * The mutator method to set the maximum value
   * @param newMaximumValue: maximum limit to be set
   */ 
   public void setMaximumValue(int newMaximumValue)
   {
   maximumValue = newMaximumValue; 
   }
   
   /** 
   * The method to generate the random number
   * @param minimum: minimum range of the random number
   * @param maximum: maximum range of the random number
   */ 
   public int generateRandomNumber(int minimum,int maximum)
   {
    int range = (maximum - minimum) + 1;
    int randomNumber = (int)(Math.random() * range) + minimum;
    return randomNumber;
   }

}
