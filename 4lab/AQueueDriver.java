import java.util.Scanner;
public class AQueueDriver
{
   public static void main(String[] args)
   {
      AQueue<Integer> q = new AQueue<Integer>(5);
      
      boolean repeat = true;
      String input;
      char decision;
      int temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- delete (enter letter d)");
      System.out.println("- check if empty (enter letter e)");
      System.out.println("- print array (enter letter p)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      
      
      
      while( repeat )
      {
         System.out.println("Enter your choice: (a, d, e, p, or q)");
         input = scan.nextLine();
         decision  = input.charAt(0);
         
         
         switch( decision ) 
         {

            case 'a':
            case 'A':
               System.out.println("Enter an integer to add");
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.enqueue(temp);
                  System.out.println(temp+" enqueued");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               try
               {
                  System.out.println(q.dequeue()+" dequeued");
               }
               catch (AQueue.MyException e)
               {
                  System.out.println("Invalid Operation - The queue is empty");
               }
               break;
            case 'e':
            case 'E':
                  if( q.empty())
                     System.out.println("Queue is empty");
                  else
                     System.out.println("Queue is not empty");
                  break;
            case 'p':
            case 'P':
                  q.printArray();
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
      while (!q.empty())
      {

         System.out.print(q.dequeue());
      }
   }
}
