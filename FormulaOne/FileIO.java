import java.util.*;
import java.io.*;

public class FileIO
{
     private String fileName;
     
     /** 
     * The default constructor of the FileIO class
     */  
     public FileIO()
     {
        fileName = "";
     }
     
     /** 
     * The default constructor of the FileIO class
     * @param newFileName: The name of the file
     */ 
     public FileIO(String newFileName)
     {
        fileName = newFileName;   
     }
     
     /** 
     * The accessor method to get the name of a file
     */ 
     public String getFileName()
     {
        return fileName;   
     }
     
     /** 
     * The mutator method to set name to a file
     * @param newFileName: The name of the new file to be set
     */ 
     public void setFileName(String newFileName)
     {
        fileName = newFileName;
     }
    
     /** 
     * The method to read contents from a file
     * @param response: A List of Strings
     * @param fileName: The name of the file from which the content is to read.
     */ 
     public ArrayList<String> readFile(ArrayList<String> response,String fileName)
     {
        if(fileName.length() > 0)
        {
          try
            {
                FileReader inputFile = new FileReader(fileName);
                try
                {
                    Scanner parser = new Scanner(inputFile);
                    while(parser.hasNext())
                    {
                      response.add(parser.nextLine());
                    }
                }
                finally
                {
                   inputFile.close();
                }
            }
            catch(FileNotFoundException exception)
            {
               System.out.println(fileName + " not found");
            }
            catch(IOException exception)
            {
              System.out.println("Unexpected I/O exception occurs");
            }
        }
         return response;
     }
    
     /** 
     * The method to write contents to a file
     * @param details: A string having details of all the drivers.
     * @param fileName: The name of the file to which the data is to be written to.
     */
     public void writeToTheFile(String details,String fileName)
     {
         if(fileName.length() > 0)
         {
            try
            {
                PrintWriter outputFile = new PrintWriter(fileName);
                try
                {
                   outputFile.println(details);
                }
                finally
                {
                   outputFile.close();
                }
            }
            catch(Exception e)
            {
                System.out.println("Error while writing to the file..");
            }
         }
            
     }
    
}
