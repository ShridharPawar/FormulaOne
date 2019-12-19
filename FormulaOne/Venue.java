import java.util.*;

//the class Venue
public class Venue
{
   private String venueName;
   private int noOfLaps;
   private int averageLapTime;
   private double chanceOfRain;
   
   /** 
   * The default constructor of the Venue class
   */ 
   public Venue()
   {
       venueName = "";
       noOfLaps = 0;
       averageLapTime = 0;
       chanceOfRain = 0;
   }
   
   /** 
   * The non default constructor of the Venue class
   * @param newVenueName: A String specifying the new name of the venue
   * @param newNoOfLaps: An integer specifying the new number of laps
   * @param newAverageLapTime: An integer specifying the average lap time
   * @param newChanceOfRain: A double specifying the chance of rain
   */
   public Venue(String newVenueName,int newNoOfLaps,int newAverageLapTime,double newChanceOfRain)
   {
       venueName = newVenueName;
       noOfLaps = newNoOfLaps;
       averageLapTime = newAverageLapTime;
       chanceOfRain = newChanceOfRain;
   }
   
   /** 
   * The accessor method to get the name of the venue.
   */
   public String getVenueName()
   {
   return venueName; 
   }
   
   /** 
   * The accessor method to get the number of laps of the venue.
   */
   public int getNoOfLaps()
   {
   return noOfLaps; 
   }
   
   /** 
   * The accessor method to get the average lap time of the venue.
   */
   public int getAverageLapTime()
   {
   return averageLapTime; 
   }
   
   /** 
   * The accessor method to get the chance of rain at a venue.
   */
   public double getChanceOfRain()
   {
   return chanceOfRain; 
   }
   
   /** 
   * The mutator method to set name to a venue.
   * @param newVenueName: A String specifying the new name of the venue
   */
   public void setVenueName(String newVenueName)
   {
   venueName = newVenueName; 
   }
   
   /** 
   * The mutator method to set no of laps to a venue.
   * @param newNoOfLaps: An integer specifying the number of laps of a venue
   */
   public void setNoOfLaps(int newNoOfLaps)
   {
   noOfLaps = newNoOfLaps; 
   }
   
   /** 
   * The mutator method to set average lap time to a venue.
   * @param newAverageLapTime: An integer specifying the average lap time of a venue
   */
   public void setAverageLapTime(int newAverageLapTime)
   {
   averageLapTime = newAverageLapTime; 
   }
   
   /** 
   * The mutator method to set chance of rain to a venue.
   * @param newChanceOfRain: An integer specifying the chance of rain at a venue.
   */
   public void setChanceOfRain(double newChanceOfRain)
   {
   chanceOfRain = newChanceOfRain; 
   }
   
}
