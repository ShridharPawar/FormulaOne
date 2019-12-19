import java.util.*;
import java.io.*;

//the class Championship
public class ChampionShip
{
        private ListOfDrivers drivers;
        private ListOfVenues venues;
        
        /** 
        * The default constructor of the championship class
        */  
        public ChampionShip()
        {
            drivers = new ListOfDrivers();
            venues = new ListOfVenues();
        }
        
        /** 
        * The alternate constructor of the championship class
        * @param newDrivers: Object of ListOfDrivers
        * @param newVenues: Object of ListOfVenues
        */
        public ChampionShip(ListOfDrivers newDrivers,ListOfVenues newVenues)
        {
            drivers = newDrivers;
            venues = newVenues;
        }
        
        
        /** 
        * The accessor method to get the drivers object
        */
        public ListOfDrivers getDrivers()
        {
            return drivers;
        }
        
        
        /** 
        * The accessor method to get the venues object
        */
        public ListOfVenues getVenues()
        {
            return venues;
        }
        
        /** 
        * The mutator method to set the ListOfDrivers object
        * @param newDrivers: An object of ListOfDrivers class
        */
        public void setDrivers(ListOfDrivers newDrivers)
        {
            drivers = newDrivers;
        }
        
        /** 
        * The mutator method to set the ListOfVenues object
        * @param newVenues: An object of ListOfVenues class
        */
        public void setVenues(ListOfVenues newVenues)
        {
            venues = newVenues;
        }
        
        /** 
        * The actual game starts from here.
        */  
        public void start()
        {
        System.out.println("***************************************************************************************************************************");   
        System.out.println("                                          Welcome to Formula 9131 Championship                                             ");
        System.out.println("***************************************************************************************************************************");
        System.out.println("");
        String driversFileName="drivers.txt";
        String venuesFileName="venues.txt";  
        readDriverFile(driversFileName);
        readVenueFile(venuesFileName);
        int noOfRaces = 0;
        boolean isRaceNumberValid = false;
        int noOfVenues  = venues.getVenues().size();
        while(isRaceNumberValid == false)
        {
         Validation validation = new Validation();
         Input input = new Input();
         String displayMessage = "Please enter the number of races in the championship between 3 and 5...";
         noOfRaces = input.acceptInteger(displayMessage);
         boolean ifIsWithinRange = validation.isWithinRange(noOfRaces,3,5);
         boolean ifIsPositiveNumber = validation.ifPositiveNumber(noOfRaces);
         boolean ifEnoughVenues = validation.ifEnoughVenues(noOfVenues,noOfRaces);
         if (ifEnoughVenues == false && ifIsWithinRange == true && ifIsPositiveNumber == true)
         {
            System.out.println("The number of venues can't be smaller than the number of races since we cannot repeat a particular venue.");
         }
         if (ifIsWithinRange && ifIsPositiveNumber && ifEnoughVenues)
         {
            isRaceNumberValid = true;
         }
        }
        ArrayList<Integer> selectedVenues =  new ArrayList<Integer>();
        
        for(int j = 1;j <= noOfRaces;j++)
        {
            System.out.println("");
            System.out.println("Alright,let's start race " + j + "...");
            
            for (int i=0;i < drivers.getDrivers().size();i++)
            {
               drivers.setEligibleToRace(i,true);
               drivers.setAccumulatedTime(i,0);
            }
            System.out.println("");
            System.out.println("Setting out the driver positions....");
            System.out.println("");
            for(int l = 0;l < drivers.getDrivers().size();l++)
            {
                System.out.println("The driver " + (l+1) + " is " + drivers.getName(l) + " with the initial rank of " + drivers.getRanking(l) 
                + " in this championship");
            }
            
            System.out.println("");
            System.out.println("The next scheduled venue is..." + "\n");
            
            RNG rng = new RNG();
            
            int randomNumberForVenue = rng.generateRandomNumber(1,noOfVenues);
            while(selectedVenues.contains(randomNumberForVenue))
            {
                randomNumberForVenue = rng.generateRandomNumber(1,noOfVenues);
            }
            selectedVenues.add(randomNumberForVenue);
            
            String selectedVenue=venues.getName(randomNumberForVenue - 1);
            System.out.println("The " + selectedVenue + " welcomes us.");
            System.out.println("The racers are going to compete over " + venues.getLaps(randomNumberForVenue - 1) + " laps with an average lap time of " +
            venues.getLapTime(randomNumberForVenue - 1) + " seconds..");
            System.out.println("");
            System.out.println("Press Enter to start the race...");
            Scanner console = new Scanner(System.in);
            console.nextLine();
            theActualRace(drivers,randomNumberForVenue - 1,j);
        }
        displayResult();
        }
        
        /** 
        * This is the Actual race method in which the drivers compete with each other.
        * @param drivers: An object of the ListOfDrivers class.
        * @param selectedVenueIndex: An integer specifying the index of the venue which is selected.
        * @param raceNumber: An integer specifying the race number.
        */  
        public void theActualRace(ListOfDrivers drivers,int selectedVenueIndex,int raceNumber)
        {
            int numberOfLaps = venues.getLaps(selectedVenueIndex);
            RNG rng = new RNG();
            rng.setMinimumValue(1);
            rng.setMaximumValue(100);
            double chanceOfRain = venues.getChanceRain(selectedVenueIndex);
            int randomNumberForRain = rng.generateRandomNumber(1,100);
            Validation validationForRain = new Validation();
            boolean ifChanceOfRain = validationForRain.ifRainChance(randomNumberForRain,chanceOfRain);
            System.out.println("VRMM....VRMM....VRMM....Here they go...");
            System.out.println();
            int lapTime = venues.getLapTime(selectedVenueIndex);
            ArrayList<Boolean> driverDryTyre = new ArrayList<Boolean>(Arrays.asList(new Boolean[drivers.getDrivers().size()]));    //logic taken from 
            Collections.fill(driverDryTyre, Boolean.TRUE);                                                                         //stackoverflow.com
            for(int j = 1;j <= numberOfLaps;j++)
            {
               ArrayList<Integer> driverDurationsForEachLap = new ArrayList<Integer>();
               ArrayList<Integer> driverDurationsForEachLapWithoutEligible = new ArrayList<Integer>();
               System.out.println("The results of lap " + j + "/" + numberOfLaps + " are....");
               System.out.println();
               int lapTimeForDriver = 0;
               for(int i = 0;i < drivers.getDrivers().size();i++)
               {
                  lapTimeForDriver = lapTime;
                  boolean cleanRun = true;
                  String driverDetail = "";
                  driverDetail = driverDetail + drivers.getName(i) + "\n";
                  if (j == 1)
                  {
                       int rankingOfTheDriver = drivers.getRanking(i);
                       int penaltyForTheDriver = 0;
                       if (rankingOfTheDriver == 2)
                       {
                        penaltyForTheDriver = 3;
                       }
                       else if (rankingOfTheDriver == 3)
                       {
                        penaltyForTheDriver = 5;
                       }
                       else if (rankingOfTheDriver == 4)
                       {
                        penaltyForTheDriver = 7;
                       }
                       else if (rankingOfTheDriver >= 5)
                       {
                        penaltyForTheDriver = 10;
                       }
                       lapTimeForDriver = lapTimeForDriver + penaltyForTheDriver;
                  }
                  String specificSkill = drivers.getSpecialSkill(i);
                  if(specificSkill.toUpperCase().equals("BRAKING") || specificSkill.toUpperCase().equals("CORNERING"))
                  {
                     int randomTimeForSkill = rng.generateRandomNumber(1,8);
                     lapTimeForDriver = lapTimeForDriver - randomTimeForSkill;
                     driverDetail = driverDetail + "That " + specificSkill + " skill is really paying off...gained " + randomTimeForSkill 
                     + " seconds" + "\n";
                  }
                  
                  if(j == 3 && specificSkill.toUpperCase().equals("OVERTAKING"))
                  {
                     int randomTimeForOvertakingSkill = rng.generateRandomNumber(10,20);
                     lapTimeForDriver = lapTimeForDriver - randomTimeForOvertakingSkill;
                     driverDetail = driverDetail + "That " + specificSkill + " skill is really paying off...gained " 
                     + randomTimeForOvertakingSkill + " seconds" + "\n";
                  }
                  
                  int randomNumberForMinor=rng.generateRandomNumber(1,100);
                  Validation minorValidation = new Validation();
                  boolean ifMinorMechanicalFault = minorValidation.minorMechanicalFault(randomNumberForMinor);
                  if (ifMinorMechanicalFault)
                  {
                    lapTimeForDriver = lapTimeForDriver + 20;
                    driverDetail = driverDetail + "Oops!faced a minor mechanical fault." + "\n";
                    cleanRun = false;
                  }
                 
                  int randomNumberForMajor = rng.generateRandomNumber(1,100);
                  Validation majorValidation = new Validation();
                  boolean ifMajorMechanicalFault = majorValidation.majorMechanicalFault(randomNumberForMajor);
                  if (ifMajorMechanicalFault)
                  {
                    lapTimeForDriver = lapTimeForDriver + 120;
                    driverDetail = driverDetail + "Aah! Unfortunately,faced a major mechanical fault." + "\n";
                    cleanRun = false;
                  }
                  
                  int randomNumberForUnRecoverable = rng.generateRandomNumber(1,100);
                  Validation validationForUnrecoverable = new Validation();
                  boolean ifUnrecoverableMechanicalFault = validationForUnrecoverable.unrecoverableMechanicalFault(randomNumberForUnRecoverable);
                  boolean inTheRace = drivers.getEligibleToRace(i);
                  if (ifUnrecoverableMechanicalFault)
                  {
                    drivers.setEligibleToRace(i,false);
                    driverDetail = driverDetail + "Oh No....What a terrible luck! An unrecoverable mechanical fault..." + drivers.getName(i) +
                    " is out of" + " the race now!" + "\n";
                    cleanRun = false;
                  }
                  
                  if(j == 2 && ifChanceOfRain)
                  {
                    int chanceOfChangeToWetTyre = rng.generateRandomNumber(1,100);
                    Validation wetTyre = new Validation();
                    boolean ifTyreChanged = wetTyre.ifWetTyre(chanceOfChangeToWetTyre);
                    if(ifTyreChanged)
                    {
                       lapTimeForDriver = lapTimeForDriver + 10;
                       driverDryTyre.set(i,false);
                       driverDetail = driverDetail + "The driver has changed the tyres to the wet-weather tyres and hence has taken extra 10 seconds \n";
                    }
                  }
                  
                  if(ifChanceOfRain)
                  {
                      if(driverDryTyre.get(i))
                      {
                        lapTimeForDriver = lapTimeForDriver + 5; 
                        driverDetail = driverDetail + "Since,its raining, and the driver's car has dry-weather tyres, the driver has taken extra 5" +
                        " seconds to complete the lap \n";
                      }
                  }
                
                  driverDetail = driverDetail + "Completed the lap within " + lapTimeForDriver + " seconds \n";
                  drivers.setAccumulatedTime(i,drivers.getAccumulatedTime(i) + lapTimeForDriver);
                  if(drivers.getEligibleToRace(i) == true)
                  {
                  driverDurationsForEachLap.add(lapTimeForDriver);
                  }
                  driverDurationsForEachLapWithoutEligible.add(lapTimeForDriver);
                  if(cleanRun)
                  {
                     driverDetail = driverDetail + "What a clean run with no issues at all....";
                  }
                  if(drivers.getEligibleToRace(i))
                  {
                    System.out.println(driverDetail);
                  }
                  else
                  {
                    if(inTheRace == false)
                    {
                       System.out.println(drivers.getName(i));
                       System.out.println("The driver is already out of the race."); 
                    }
                    else
                    {
                        System.out.println(drivers.getName(i));
                        System.out.println("Oh no!Terrible luck!!!" + drivers.getName(i) + " faced an unrecoverable fault,hence is out of the race."); 
                    }   
                  }
                  System.out.println("");
              }
               
               int minVal = 0;
               if (driverDurationsForEachLap.size() > 0)           //to get the lap duration of the driver who completed the lap first
               {
                  minVal = Collections.min(driverDurationsForEachLap);
               }
               else
               {
                 System.out.println("Not a single driver is eligible for this race."); 
               }
             
               String leadingDriverName = "";
               for(int k = 0;k < drivers.getDrivers().size();k++)
               {
               if (driverDurationsForEachLapWithoutEligible.get(k) == minVal && drivers.getEligibleToRace(k) == true)
               {
                   leadingDriverName = leadingDriverName + drivers.getName(k) + " with a lap time of " + minVal + " seconds." 
                   + "\n";
               }
               }
               System.out.println("");
               System.out.println("***********The leading driver(s) for the lap " + j + "***********" + "\n" + leadingDriverName );
               System.out.println("");
               if (j != numberOfLaps)
               {
               System.out.println("Press enter to continue.");
               Scanner clearsc = new Scanner(System.in);
               clearsc.nextLine();
               System.out.print("\u000C");
               }
             }
            
            ArrayList<Integer> lowestRaceDurations = new ArrayList<Integer>();
            for(int l = 0;l < drivers.getDrivers().size();l++)
            {
             if(drivers.getEligibleToRace(l) == true)
             {
               lowestRaceDurations.add(drivers.getAccumulatedTime(l));
             }
            }
            Collections.sort(lowestRaceDurations);
            
            ArrayList<Integer> sortedLowestRaceDurations = new ArrayList<Integer>();
            if(lowestRaceDurations.size() >= 5)
            {
                sortedLowestRaceDurations= new ArrayList<Integer>(lowestRaceDurations.subList(0,4));
            }
            else
            {
               sortedLowestRaceDurations= new ArrayList<Integer>(lowestRaceDurations);
            }
            
            ArrayList<Integer> duplicateTimes = new ArrayList<Integer>();    //durations of the drivers having the same durations
            for (int y = 0; y < sortedLowestRaceDurations.size(); y++) 
            { 
                for (int z = y + 1; z < sortedLowestRaceDurations.size(); z++) 
                {
                    if (sortedLowestRaceDurations.get(y).equals(sortedLowestRaceDurations.get(z))) 
                    { 
                        duplicateTimes.add(sortedLowestRaceDurations.get(y));
                    } 
                }
            }
            
            ArrayList<Integer> randNumbers = new ArrayList<Integer>();
            String firstDriver = "";
            String secondDriver = "";
            String thirdDriver = "";
            String fourthDriver = "";
            //the logic to assign rankings of the race to the drivers and if the two drivers have same timings,then assign them rankings randomly
            for (int s = 0;s < drivers.getDrivers().size();s++)
            {
                if (drivers.getEligibleToRace(s) == true && sortedLowestRaceDurations.contains(drivers.getAccumulatedTime(s)) && 
                !duplicateTimes.contains(drivers.getAccumulatedTime(s)))
                {
                    int time = drivers.getAccumulatedTime(s);
                    int index = 0;
                    for(int e = 0;e < sortedLowestRaceDurations.size();e++)
                    {
                      if(sortedLowestRaceDurations.get(e) == time)
                      {
                      index = e;  
                      }
                    }
                    if(index == 0)
                    {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 8);
                       firstDriver = drivers.getName(s) + " finished this race first with 8 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                    }
                    else if(index == 1)
                    {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 5);
                       secondDriver = drivers.getName(s) + " finished this race second with 5 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                    }
                    else if(index == 2)
                    {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 3);
                       thirdDriver = drivers.getName(s) + " finished this race third with 3 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                    }
                    else if(index == 3)
                    {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 1);
                       fourthDriver = drivers.getName(s) + " finished this race fourth with 1 point and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                    }
                }
                else if(drivers.getEligibleToRace(s) == true && sortedLowestRaceDurations.contains(drivers.getAccumulatedTime(s)) 
                && duplicateTimes.contains(drivers.getAccumulatedTime(s)))
                {
                   ArrayList<Integer> indexes = new ArrayList<Integer>();
                   int time = drivers.getAccumulatedTime(s);
                   for(int e = 0;e < sortedLowestRaceDurations.size();e++)
                   {
                        if(time == sortedLowestRaceDurations.get(e))
                        {
                        indexes.add(e);
                        }
                   }
                   int randomNumber = rng.generateRandomNumber(Collections.min(indexes),Collections.max(indexes));
                   while(randNumbers.contains(randomNumber))
                   {
                   randomNumber = rng.generateRandomNumber(Collections.min(indexes),Collections.max(indexes));
                   }
                   randNumbers.add(randomNumber);
                   if(randomNumber == 0)
                   {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 8);
                       firstDriver = drivers.getName(s) + " finished this race first with 8 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                   }
                   else if(randomNumber == 1)
                   {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 5);
                       secondDriver = drivers.getName(s) + " finished this race second with 5 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                   }
                   else if(randomNumber == 2)
                   {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 3);
                       thirdDriver = drivers.getName(s) + " finished this race third with 3 points and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                   }
                   else if(randomNumber == 3)
                   {
                       drivers.setAccumulatedScore(s,drivers.getAccumulatedScore(s) + 1);
                       fourthDriver = drivers.getName(s) + " finished this race fourth with 1 point and a race duration of " + drivers.getAccumulatedTime(s) +
                        " seconds!";
                   }
                }
            }
            System.out.println("The winners of the race " + raceNumber + " are:");
            System.out.println("");
            System.out.println(firstDriver);
            System.out.println(secondDriver);
            System.out.println(thirdDriver);
            System.out.println(fourthDriver);
            System.out.println("");
            System.out.println("Press enter to continue");
            Scanner enter = new Scanner(System.in);
            enter.nextLine();
            System.out.print("\u000C");
            
        }
        
        /** 
        * This method calculates the final rankings of the drivers and displays the winners.
        */  
        public void displayResult()
        {
            ArrayList<Integer> driverPoints = new ArrayList<Integer>();
            for(int k = 0;k < drivers.getDrivers().size();k++)
            {
            driverPoints.add(drivers.getAccumulatedScore(k));
            }
            Collections.sort(driverPoints);
            Collections.reverse(driverPoints);
            ArrayList<Integer> duplicates = new ArrayList<Integer>();
            for (int y = 0; y < driverPoints.size(); y++) 
            { 
                for (int z = y + 1; z < driverPoints.size(); z++) 
                {
                    if (driverPoints.get(y).equals(driverPoints.get(z))) 
                    { 
                        duplicates.add(driverPoints.get(y));
                    } 
                }
            }
            
            ArrayList<Integer> randNumbers = new ArrayList<Integer>();
            RNG rng = new RNG();
            String championshipDriverName = "";
            String firstDriver = "";
            String secondDriver = "";
            String thirdDriver = "";
            String fourthDriver = "";
            String fifthDriver = "";
            for (int s = 0;s < drivers.getDrivers().size();s++)
            {
                if (!duplicates.contains(drivers.getAccumulatedScore(s)))
                {
                    int score = drivers.getAccumulatedScore(s);
                    int index = 0;
                    for(int e = 0;e < driverPoints.size();e++)
                    {
                      if(driverPoints.get(e) == score)
                      {
                      index = e;  
                      }
                    }
                    if(index == 0)
                    {
                       drivers.setRanking(s,1);
                       firstDriver = drivers.getName(s) + " finished first with " + drivers.getAccumulatedScore(s) + " points.";
                       championshipDriverName = "*************************The championship driver is " + drivers.getName(s) + "*************************";
                    }
                    else if(index == 1)
                    {
                       drivers.setRanking(s,2);
                       secondDriver = drivers.getName(s) + " finished second with " + drivers.getAccumulatedScore(s) + " points.";
                    }
                    else if(index == 2)
                    {
                       drivers.setRanking(s,3);
                       thirdDriver = drivers.getName(s) + " finished third with " + drivers.getAccumulatedScore(s) + " points.";
                    }
                    else if(index == 3)
                    {
                       drivers.setRanking(s,4);
                       fourthDriver = drivers.getName(s) + " finished fourth with " + drivers.getAccumulatedScore(s) + " points.";
                    }
                    else if(index >= 4)
                    {
                      drivers.setRanking(s,5);
                      fifthDriver = fifthDriver + drivers.getName(s) + " finished fifth with " + drivers.getAccumulatedScore(s) + " points." + "\n";
                    }
                }
                else
                {
                   ArrayList<Integer> indexes = new ArrayList<Integer>();
                   int score = drivers.getAccumulatedScore(s);
                   for(int e = 0;e < driverPoints.size();e++)
                   {
                        if(score == driverPoints.get(e))
                        {
                        indexes.add(e);
                        }
                   }
                   int randomNumber = rng.generateRandomNumber(Collections.min(indexes) + 1,Collections.max(indexes) + 1);
                   while(randNumbers.contains(randomNumber))
                   {
                   randomNumber = rng.generateRandomNumber(Collections.min(indexes) + 1,Collections.max(indexes) + 1);
                   }
                   randNumbers.add(randomNumber);
                   if(randomNumber == 1)
                   {
                       drivers.setRanking(s,1);
                       firstDriver = drivers.getName(s) + " finished first with " + drivers.getAccumulatedScore(s) + " points.";
                       championshipDriverName = "*************************The championship driver is:" + drivers.getName(s) + "*************************";
                   }
                   else if(randomNumber == 2)
                   {
                       drivers.setRanking(s,2);
                       secondDriver = drivers.getName(s) + " finished second with " + drivers.getAccumulatedScore(s) + " points.";
                   }
                   else if(randomNumber == 3)
                   {
                       drivers.setRanking(s,3);
                       thirdDriver = drivers.getName(s) + " finished third with " + drivers.getAccumulatedScore(s) + " points.";
                   }
                   else if(randomNumber == 4)
                   {
                       drivers.setRanking(s,4);
                       fourthDriver = drivers.getName(s) + " finished fourth with " + drivers.getAccumulatedScore(s) + " points.";
                   }
                   else if(randomNumber >= 5)
                   {
                      drivers.setRanking(s,5);
                      fifthDriver = fifthDriver + drivers.getName(s) + " finished fifth with " + drivers.getAccumulatedScore(s) + " points." + "\n";
                   }
                }
            }
            
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println(championshipDriverName);
            System.out.println("-------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println("The driver positions are as follows:");
            System.out.println("");
            System.out.println(firstDriver);
            System.out.println(secondDriver);
            System.out.println(thirdDriver);
            System.out.println(fourthDriver);
            System.out.println(fifthDriver);
            writeBackToTheFile(drivers);
            System.out.println("");
            System.out.println("Writing the driver details back to the file for the next championship....");
            System.out.println("Done..");
            
        }
        
        
        /** 
        * This method calls the method in the FileIO class to read the data from the "drivers" file.
        * @param driversFileName: A string specifying the name of the file which has drivers details.
        */  
        public void readDriverFile(String driversFileName)
        {
           FileIO fileIO = new FileIO(driversFileName);
           ArrayList<String> driversResponse = new ArrayList<String>();
           driversResponse = fileIO.readFile(driversResponse,driversFileName);
           for(int i = 0;i < driversResponse.size();i++)
           {
                try
                {
                   String[] driverSpecifications =driversResponse.get(i).split(",");
                   drivers.setDriver(i,driverSpecifications[0],driverSpecifications[1],driverSpecifications[2]);
                }
                catch(Exception e)
                {
                  System.out.println("It's a null pointer exception since the driver file is not appropriate.");
                  break;
                }
           }
        }
        
        /** 
        * This method calls the method in the FileIO class to read the data from the "venues" file.
        * @param venuesFileName: A string specifying the name of the file which has venues details.
        */  
        public void readVenueFile(String venuesFileName)
        {
           FileIO fileIO = new FileIO(venuesFileName);
           ArrayList<String> venuesResponse = new ArrayList<String>();
           venuesResponse = fileIO.readFile(venuesResponse,venuesFileName);
           for(int i = 0;i < venuesResponse.size();i++)
           {
            try
            {
               String[] venueSpecifications = venuesResponse.get(i).split(",");
               venues.setVenue(i,venueSpecifications[0],venueSpecifications[1],venueSpecifications[2],venueSpecifications[3]);
            }
            catch(Exception e)
            {
               System.out.println("It's a null pointer exception since the venue file is not appropriate.Please edit the venues file.");
               break;
            }
           }
        }
        
        /** 
        * This method calls the method in the FileIO class to write the driver details back to the "drivers" file.
        * @param drivers: An object of the ListOfDrivers class.
        */  
        public void writeBackToTheFile(ListOfDrivers drivers)
        {
            FileIO fileIO = new FileIO();
            String driversFileName="drivers.txt";
            String driverDetails = "";
            for(int u = 0;u < drivers.getDrivers().size();u++)
            {
                   driverDetails = driverDetails + drivers.getName(u) + "," + drivers.getRanking(u) + "," + drivers.getSpecialSkill(u) + "\n";
            }
            fileIO.writeToTheFile(driverDetails,driversFileName);
            
        } 
        
 }
