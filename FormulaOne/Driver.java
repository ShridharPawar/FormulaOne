import java.util.*;

public class Driver
{
    private String name;
    private int ranking;
    private String specialSkill;
    private boolean eligibleToRace;
    private int accumulatedScore;
    private int accumulatedTime;
    
    /** 
    * The default constructor of the Driver class
    */ 
    public Driver()
    {
    name = "";
    ranking = 0;
    specialSkill = "";
    eligibleToRace = true;
    accumulatedScore = 0;
    accumulatedTime = 0;
    }
    
    /** 
    * An alternate constructor of the driver class
    * @param newName: An integer
    * @param newRanking: A String specifying the name of the driver
    * @param newSpecialSkill: A String specifying the rank of a driver
    * @param newEligibleToRace: A String specifying the skill of a driver
    * @param newAccumulatedScore: A String specifying the eligibility to race of a driver
    * @param newAccumulatedTime: A String specifying the accumulated time of a driver
    */ 
    public Driver(String newName,int newRanking,String newSpecialSkill,boolean newEligibleToRace,int newAccumulatedScore,int newAccumulatedTime)
    {
       name = newName;
       if(newRanking < 0)
       {
          ranking = 0;
       }
       else
       {
           ranking = newRanking;
       }
       specialSkill = newSpecialSkill;
       eligibleToRace = newEligibleToRace;
       if(newAccumulatedScore < 0)
       {
          accumulatedScore = 0;
       }
       else
       {
          accumulatedScore = newAccumulatedScore;
       }
       if(newAccumulatedTime < 0)
       {
          accumulatedTime = 0;
       }
       else
       {
          accumulatedTime = newAccumulatedTime;
       }
      
    }
    
    /** 
    * The accessor method to get the name of the driver.
    */
    public String getDriverName()
    {
    return name;
    }
    
    /** 
    * The accessor method to get the accumulated time of the driver.
    */
    public int getDriverAccumulatedTime()
    {
    return accumulatedTime;
    }
    
    /** 
    * The accessor method to get the ranking of the driver.
    */
    public int getDriverRanking()
    {
    return ranking;
    }
    
    /** 
    * The accessor method to get the driver of the driver.
    */
    public String getDriverSpecialSkill()
    {
    return specialSkill;
    }
    
    /** 
    * The accessor method to get the eligibility to race of the driver.
    */
    public boolean getDriverEligibleToRace()
    {
    return eligibleToRace;
    }
    
    /** 
    * The accessor method to get the score of the driver.
    */
    public int getDriverAccumulatedScore()
    {
    return accumulatedScore;
    }
    
    /** 
    * The mutator method to set the name of the driver.
    * @param newName: A String specifying the name to be set.
    */
    public void setDriverName(String newName)
    {
    name = newName;
    }
    
    /** 
    * The mutator method to set the ranking of the driver.
    * @param newRanking: An integer specifying the ranking to be set.
    */
    public void setDriverRanking(int newRanking)
    {
       if(newRanking < 0)
       {
         ranking = 0;
       }
       else
       {
         ranking = newRanking;
       }
    }
    
    /** 
    * The mutator method to set the skill of the driver.
    * @param newSpecialSkill: A String specifying the skill to be set.
    */
    public void setDriverSpecialSkill(String newSpecialSkill)
    {
    specialSkill = newSpecialSkill;
    }
    
    /** 
    * The mutator method to set the eligibility of the driver.
    * @param newEligibleToRace: A boolean specifying if the driver is eligible to race or not.
    */
    public void setDriverEligibleToRace(boolean newEligibleToRace)
    {
    eligibleToRace = newEligibleToRace;
    }
    
    /** 
    * The mutator method to set the accumulated score of the driver.
    * @param newAccumulatedScore: An integer specifying the score to be set to the driver.
    */
    public void setDriverAccumulatedScore(int newAccumulatedScore)
    {
       if(newAccumulatedScore < 0)
       {
         accumulatedScore = 0;
       }
       else
       {
         accumulatedScore = newAccumulatedScore;
       }
    }
    
    /** 
    * The mutator method to set the accumulated time of the driver.
    * @param newAccumulatedTime: An integer specifying the time to be set to the driver.
    */
    public void setDriverAccumulatedTime(int newAccumulatedTime)
    {
       if(newAccumulatedTime < 0)
       {
         accumulatedTime = 0;
       }
       else
       {
         accumulatedTime = newAccumulatedTime;
       }
    }
}
