import java.util.*;
import java.io.*;
public class ListPrinter 
{
   public static void main(String[] args) throws java.io.FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);  
      BinHeap <Student> q = new BinHeap ();
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
