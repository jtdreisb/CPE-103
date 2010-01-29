/** * HeapTest to test BinHeap class * * @version cpe 103 section 4 * * @author Mathew Duhon and Jason Dreisbach * @version Program 2 */

import java.util.Scanner;

public class HeapTest 
{



/**
 *Takes a choice from a printed menu
 *Does the appropriate method based upon entry
 */  
   public static void main(String[] args)
   {
      BinHeap<String> q = new BinHeap<String>();
      
      boolean repeat = true;
      String input;
      char decision = 'h';
      String temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- delete (enter letter d)");
      System.out.println("- check if empty (enter letter e)");
      System.out.println("- size (enter letter s)");
      System.out.println("- print heap (enter letter p)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      
      
      
      while( repeat )
      {
         System.out.println("Enter your choice: (a, d, e, s, p, or q)");
         input = scan.nextLine();
         if(!input.isEmpty())
         {
            decision  = input.charAt(0);
         }
         switch( decision ) 
         {
            case 'a':
            case 'A':
               System.out.println("Enter an someting to add");
               if(scan.hasNext())
               {
                  temp = scan.nextLine();
                  q.insert(temp);
                  System.out.println(temp+" inserted");
               }
               else
               {
                  System.out.println("Please enter an the correct something");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               try
               {
                  System.out.println(q.deleteMin()+" delete");
               }
               catch (BinHeap.MyException e)
               {
                  System.out.println("Invalid Operation - The heap is empty");
               }
               break;
            case 'e':
            case 'E':
                  if( q.isEmpty())
                     System.out.println("heap is empty");
                  else
                     System.out.println("heap is not empty");
                  break;
            case 's':
            case 'S':
                  System.out.println("The size is: " +q.size());
                  break;
            case 'p':
            case 'P':
                  q.print();
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
      while (!q.isEmpty())
      {
         System.out.print(q.deleteMin()+" ");
      }
      System.out.println();
   }
}  

