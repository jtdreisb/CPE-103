import java.util.Scanner;
public class AStackDriver
{
   public static void main(String[] args)
   {
      AStack<Integer> q = new AStack<Integer>(5);
      
      boolean repeat = true;
      String input;
      char decision;
      int temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- delete (enter letter d)");
      System.out.println("- peek (enter letter p)");
      System.out.println("- check if empty (enter letter e)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      
      
      
      while( repeat )
      {
         System.out.println("Enter your choice: (a, d, p, e, or q)");
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
                  q.push(temp);
                  System.out.println(temp+" pushed");
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
                  System.out.println(q.pop()+" popped");
               }
               catch (AStack.MyException e)
               {
                  System.out.println("Invalid Operation - The stack is empty");
               }
               break;
            case 'p':
            case 'P':
               try
               {
               System.out.println("The top value is: " +q.peek());
               }
               catch (AStack.MyException e)
               {
                  System.out.println("Invalid Operation - The stack is empty");
               }
               break;
            case 'e':
            case 'E':
                  if( q.isEmpty())
                     System.out.println("Stack is empty");
                  else
                     System.out.println("Stack is not empty");
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
         System.out.print(q.pop()+ " ");
      }
      System.out.println();
   }
}
