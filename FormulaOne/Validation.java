import java.util.*;
import java.io.*;

public class Validation
{
    
    /** 
    * The default constructor of the Validation class
    */ 
    public Validation()
    {
    
    }
    
    
    /** 
    * The method which checks if the passed number is within a specified range or not.
    * @param number: The passed integer number which is to be checked if it falls within a given range.
    * @param min: the minmum limit of the range
    * @param max: the maximum limit of the range
    */ 
    public boolean isWithinRange(int number,int min,int max)
    {
      if (number <= max && number >= min)
      {
        return true;  
      }
      else
      {
        return false;
      }
    }
    
    /** 
    * The method which checks if the passed number is positive
    * @param number: The passed integer number
    */
    public boolean ifPositiveNumber(int number)
    {
        if (number < 1)
        {
          return false;
        }
        else
        {
          return true;
        }
    }
    
    /** 
    * The method which checks if it is going to rain or not.
    * @param randomNumber: A random number
    * @param rainChance: Double specifying the chance of rain
    */ 
    public boolean ifRainChance(int randomNumber,double rainChance)
    {
        boolean result = false;
        if (randomNumber <= rainChance * 100)
        {
           result = true;
        }
        else
        {
          result = false;
        }
        return result;
    }
    
    /** 
    * The method which checks if there is an unrecoverable Mechanical fault or not.
    * @param randomNumber: A random number
    */ 
    public boolean unrecoverableMechanicalFault(int randomNumber)
    {
        boolean result = true;
        if (randomNumber == 1)
        {
           result = true;
        }
        else
        {
           result = false;
        }
        return result;
    }
    
    /** 
    * The method which checks if there is a chance of the driver changing the dry tyres to wet tyres.
    * @param randomNumber: A random number
    */ 
    public boolean ifWetTyre(int randomNumber)
    {
         boolean result = false;
         if (randomNumber <= 50)
         {
           result = true;
         }
         else
         {
           result = false;
         }
         return result;
    }
    
    /** 
    * The method which checks if there is a chance of minor mechanical fault or not.
    * @param randomNumber: A random number
    */ 
    public boolean minorMechanicalFault(int randomNumber)
    {
        boolean result = true;
        if (randomNumber <= 5)
        {
        result = true;
        }
        else
        {
        result = false;
        }
        return result;
    }
    
    /** 
    * The method which checks if there is a chance of major mechanical fault or not.
    * @param randomNumber: A random number
    */ 
    public boolean majorMechanicalFault(int randomNumber)
    {
        boolean result = true;
        if (randomNumber <= 3)
        {
           result = true;
        }
        else
        {
           result = false;
        }
        return result;
    }
    
    /** 
    * This method checks if the number of venues is less than the number of races in the championship.
    * @param noOfVenues: An integer specifying the number of venues.
    * @param noOfRaces: An integer specifying the number of races in the championship.
    */  
    public boolean ifEnoughVenues(int noOfVenues,int noOfRaces)
    {
        if (noOfVenues < noOfRaces)
        {
           return false;
        }
        else
        {
          return true;
        }
    }
    
}
