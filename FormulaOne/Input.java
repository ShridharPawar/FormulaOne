import java.util.*;
import java.io.*;

public class Input
{
    
    /** 
    * The default constructor of the input class
    */
    public Input()
    {
    
    }
    
    /** 
    * The method to accept an integer from the user.
    * @param displayMessage: A string message which is to be displayed to the user.
    */ 
    public int acceptInteger(String displayMessage)
    {
       System.out.println(displayMessage);
       boolean isValid = false;
       int num = 0;
       while(isValid == false)
       {
          try
          {
                Scanner console=new Scanner(System.in);
                num = console.nextInt();
                isValid = true;
          }
          catch (InputMismatchException exception) 
          {
                isValid = false;
                System.out.println("Not an integer, please enter the race count again.");
          }
       }
       return num;
    } 
      
    
     
}
