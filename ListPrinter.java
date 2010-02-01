/** * ListPrinter class to test BinHeap class * Reads in the student data from a file and prints out a formatted list
 * * @version cpe 103 section 4 * * @author Mathew Duhon and Jason Dreisbach * @version Program 2 */
import java.util.*;
import java.io.*;
public class ListPrinter 
{
   /**
    * Takes in a file name and then
    * Prints out a formatted list of Students
    */ 
   public static void main(String[] args) throws java.io.FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);  
      BinHeap <Student> q = new BinHeap <Student> ();
      String fileName;
      String tempName;
      long tempId;
      System.out.println("Enter file name: ");
      fileName= scan.nextLine();
      Scanner file = new Scanner( new File(fileName));
      
      Scanner lineScan;
      Student newStud;
      int i=1;
      while(file.hasNext()) 
      {
         lineScan = new Scanner(file.nextLine());
         if(lineScan.hasNextLong())
         {
            tempId= lineScan.nextLong();
            
            if(lineScan.hasNext() && tempId > 0) 
            {
               tempName = lineScan.next();
               if(!lineScan.hasNext())
               {
                  newStud = new Student(tempId, tempName);
                  q.insert(newStud);
               }
            }
         }        
      }
      System.out.println("Student List:");
      while(!q.isEmpty())
      {
         System.out.println(i++ +". " + q.deleteMin().toString());
         
      }
   }
}
