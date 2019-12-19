
import java.util.*;

public class ListOfVenues
{
   private ArrayList<Venue> venues;
   
   /** 
   * The default constructor of the ListOfVenues class
   */ 
   public ListOfVenues()     
   {
     venues= new ArrayList<Venue>();
   }
   
   /** 
   * The alternate constructor of the ListOfVenues class
   * @param newVenues: An ArrayList of Venue
   */ 
   public ListOfVenues(ArrayList<Venue> newVenues)
   {
     venues= newVenues;
   }
   
   /** 
   * The accessor method to get venues.
   */
   public ArrayList<Venue> getVenues()
   {
    return venues;
   }
   
   /** 
   * The mutator method to set the list of drivers
   */
   public void setDrivers(ArrayList<Venue> newVenues)
   {
     venues = newVenues;
   }
   
   /** 
   * The accessor method to get the name of the venue.
   * @param index: An integer
   */
   public String getName(int index)
   {
   return venues.get(index).getVenueName();
   }
   
   /** 
   * The accessor method to get the number of laps of a venue which eventually calls a method in the Venue class.
   * @param index: An integer
   */
   public int getLaps(int index)
   {
    return venues.get(index).getNoOfLaps();
   }
   
   /** 
   * The accessor method to get the lap time of a venue which eventually calls a method in the Venue class.
   * @param index: An integer
   */
   public int getLapTime(int index)
   {
    return venues.get(index).getAverageLapTime();
   }
   
   /** 
   * The accessor method to get the probability of rain at a particular venue which eventually calls a method in the Venue class.
   * @param index: An integer
   */
   public double getChanceRain(int index)
   {
    return venues.get(index).getChanceOfRain();
   }
   
   /** 
   * The mutator method to set name to a venue which eventually calls a method in the Venue class.
   * @param index: An integer
   * @param name: A String specifying the name of a venue
   */
   public void setName(int index,String name)
   {
   venues.get(index).setVenueName(name);
   }
   
   /** 
   * The mutator method to set number of laps to a venue which eventually calls a method in the Venue class.
   * @param index: An integer
   * @param noOfLaps: An integer specifying the number of laps
   */
   public void setLaps(int index,int noOfLaps)
   {
    venues.get(index).setNoOfLaps(noOfLaps);
   }
   
   /** 
   * The mutator method to set lap time to a venue which eventually calls a method in the Venue class.
   * @param index: An integer
   * @param time: An integer specifying the lap time
   */
   public void setLapTime(int index,int time)
   {
    venues.get(index).setAverageLapTime(time);
   }
   
   /** 
   * The mutator method to set chance of rain which eventually calls a method in the Venue class.
   * @param index: An integer
   * @param chanceOfRain: A double specifying the chance of rain
   */
   public void setChanceRain(int index,double chanceOfRain)
   {
    venues.get(index).setChanceOfRain(chanceOfRain);
   }
   
   /** 
   * The method which is called from the championship class to set the initial values to the venues attributes.
   * @param index: An integer
   * @param venueName: A String specifying the name of the venue
   * @param noOfLaps: A String specifying the number of laps
   * @param averageLapTime: A String specifying the average lap time
   * @param chanceOfRain: A String specifying the chance of rain
   */ 
   public void setVenue(int index,String venueName,String noOfLaps,String averageLapTime,String chanceOfRain)
   {
   Venue venue = new Venue();
   venues.add(index,venue);
   setName(index,venueName);
   setLaps(index,Integer.parseInt(noOfLaps));
   setLapTime(index,Integer.parseInt(averageLapTime));
   setChanceRain(index,Double.parseDouble(chanceOfRain));
   }
   
   
}
