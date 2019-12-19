import java.util.*;
import java.io.*;

public class ListOfDrivers
{
   private ArrayList<Driver> drivers;
   
   /** 
   * The default constructor of the ListOfDrivers class
   */ 
   public ListOfDrivers()
   {
      drivers = new ArrayList<Driver>();
   }
   
   /** 
   * The alternate constructor of the ListOfVenues class
   * @param newDrivers: An ArrayList of Driver
   */ 
   public ListOfDrivers(ArrayList<Driver> newDrivers)
   {
      drivers = newDrivers;
   }
   
   /** 
   * The accessor method to get the list of drivers
   */
   public ArrayList<Driver> getDrivers()
   {
    return drivers;
   }
   
   /** 
   * The mutator method to set the list of drivers
   */
   public void setDrivers(ArrayList<Driver> newDrivers)
   {
     drivers = newDrivers;
   }
   
   /** 
   * The accessor method to get the name of the driver which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public String getName(int index)
   {
     return drivers.get(index).getDriverName();
   }
   
   /** 
   * The accessor method to get the ranking of the driver which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public int getRanking(int index)
   {
     return drivers.get(index).getDriverRanking();
   }
   
   /** 
   * The accessor method to get the accumulated time of the driver which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public int getAccumulatedTime(int index)
   {
     return drivers.get(index).getDriverAccumulatedTime();
   }
   
   /** 
   * The accessor method to get the skill of the driver which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public String getSpecialSkill(int index)
   {
     return drivers.get(index).getDriverSpecialSkill();
   }
   
   /** 
   * The accessor method to check if the driver is eligible to race which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public boolean getEligibleToRace(int index)
   {
     return drivers.get(index).getDriverEligibleToRace();
   }
   
   /** 
   * The accessor method to get the accumulated score of the driver which eventually calls a method in the Driver class.
   * @param index: An integer
   */
   public int getAccumulatedScore(int index)
   {
     return drivers.get(index).getDriverAccumulatedScore();
   }
   
   /** 
   * The accessor method to get a particular drive 
   * @param index: An integer
   */
   public Driver getDriver(int index)
   {
    return drivers.get(index);
   }
   
   /** 
   * The mutator method to set name to a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param name: Name of the driver to be set
   */
   public void setName(int index,String name)
   {
     drivers.get(index).setDriverName(name);
   }
   
   /** 
   * The mutator method to set ranking to a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param ranking: Ranking of the driver to be set
   */
   public void setRanking(int index,int ranking)
   {
     drivers.get(index).setDriverRanking(ranking);
   }
   
   /** 
   * The mutator method to set accumulated time of a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param time: Time to be set
   */
   public void setAccumulatedTime(int index,int time)
   {
     drivers.get(index).setDriverAccumulatedTime(time);
   }
   
   /** 
   * The mutator method to set skill of a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param skill: Skill to be set
   */
   public void setSpecialSkill(int index,String skill)
   {
     drivers.get(index).setDriverSpecialSkill(skill);
   }
   
   /** 
   * The mutator method to set eligibility to race of a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param isEligible: Boolean value to set the eligibility
   */
   public void setEligibleToRace(int index,boolean isEligible)
   {
     drivers.get(index).setDriverEligibleToRace(isEligible);
   }
   
   /** 
   * The mutator method to set score of a driver which eventually calls a method in the Driver class.
   * @param index: An integer
   * @param score: integer value
   */
   public void setAccumulatedScore(int index,int score)
   {
     drivers.get(index).setDriverAccumulatedScore(score);
   }
   
   /** 
   * The method which is called from the championship class to set the initial values to the venues attributes.
   * @param index: An integer
   * @param name: A String specifying the name of the driver
   * @param position: A String specifying the position of a driver
   * @param skill: A String specifying the skill of a driver
   */ 
   public void setDriver(int index,String name,String position,String skill)
   {
   Driver driver = new Driver();
   drivers.add(index,driver);
   drivers.get(index).setDriverName(name);
   drivers.get(index).setDriverRanking(Integer.parseInt(position));
   drivers.get(index).setDriverSpecialSkill(skill);
   }
   
}
 