/** * ListPrinter class to test BinHeap class * Reads in the student data from a file and prints out a formatted list
 * * @version cpe 103 section 4 * * @author Mathew Duhon and Jason Dreisbach * @version Program 4 */
import java.util.*;
import java.io.*;
public class HTDriver 
{
   /**
    * Takes in a file name and then
    * Prints out a formatted list of Students
    */ 
   public static void main(String[] args) throws java.io.FileNotFoundException
   {
      Scanner scan = new Scanner(System.in);  
      
      HashTable q; // the hashtable
      
      String fileName;    
      Scanner lineScan;
      int numLines;

      Student newStud;
      String tempName;
      long tempId;
      
      // driver vars
      boolean repeat = true;
      String input;
      char decision;
      int size, temp;
      
      System.out.println("Enter file name: ");
      fileName= scan.nextLine();
      
      
      Scanner file = new Scanner( new File(fileName));
      
      if(file.hasNextInt())
      {
         numLines = file.nextInt();
         q = new HashTable(numLines);
         file.nextLine();
      }
      else
         throw new RuntimeException("Invalid Input file"); 

      while(file.hasNext() && numLines > 0) 
      {
         numLines--;
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
      
      
      /**
       * Normal Driver Stuff
       *
       */
        
      System.out.println("Choose one of the following operations:");    
      System.out.print("a(add/insert), f(find),d(delete),e(empty?), ");
      System.out.println("k(Empty), n(num elements), o(output), p(print) or q(quit)");
      
      
      while( repeat )
      {
         System.out.print("> ");
         input = scan.nextLine();
         decision  = input.charAt(0);
         
         
         switch( decision ) 
         {

            case 'a':
            case 'A':
               System.out.println("Enter Student id AND name");
               lineScan = new Scanner(scan.nextLine());
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
                        System.out.println(newStud.toString()+" added");
                     }
                  }
                  else
                     System.out.println("Please enter accurate data");
                }
               else
                  System.out.println("Please enter accurate data");
               break;
            case 'f':
            case 'F':
               System.out.println("Enter Student id");
               if(scan.hasNextLong())
               {
                  tempId = scan.nextLong();
                  scan.nextLine();
                  System.out.println(tempId + " found: " +q.find(new Student(tempId,null)));
               }
               else
               {
                  System.out.println("Please enter a Long");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               if(scan.hasNextLong())
               {
                  tempId = scan.nextLong();
                  scan.nextLine();
                  q.delete(new Student(tempId,null));
                  System.out.println(tempId + " deleted");
               }
               else
               {
                  System.out.println("Please enter a Long");
                  scan.nextLine();
               }
                  break;
            case 'e':
            case 'E':
                  System.out.println("Empty: " +q.isEmpty());
                  break;
            case 'k':
            case 'K':
                  q.makeEmpty();
                  System.out.println("Emptied");
                  break;
            case 'n':
            case 'N':
                  System.out.println("Element Count: " +q.elementCount());
                  break;
            case 'o':
            case 'O':
                  Iterator it = q.iterator();
                  while(it.hasNext())
                  {
                     System.out.println((Student)it.next());
                  }
                  break;
            case 'p':
            case 'P':
                  q.printTable();
                  break;
            case 'q':
            case 'Q':
                 repeat = false;
                 System.out.println("Quiting...");
                 break;
            default:
                 System.out.println("Invalid Choice"); 
         }  
      }
      System.out.println();

   }
}
