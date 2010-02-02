/*** StackTest to test a linked stack* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 1*/

import java.util.Scanner;
public class StackTest
{
   /**   * @description Takes a choice from a printed menu does the appropriate method based upon entry   *   */
   public static void main(String[] args)
   {
      MyStack<String> q = new MyStack<String>();
      
      boolean repeat = true;
      String input;
      char decision = 'h';
      String temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- delete (enter letter d)");
      System.out.println("- peek (enter letter p)");
      System.out.println("- check if empty (enter letter e)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      
      
      
      while( repeat )
      {
         System.out.println("Enter your choice: (a, d, e, p, or q)");
         input = scan.nextLine();
         if(!input.isEmpty())
         {
            decision  = input.charAt(0);
         }
         switch( decision ) 
         {
            case 'a':
            case 'A':
               System.out.println("Enter an String to add");
               if(scan.hasNext())
               {
                  temp = scan.nextLine();
                  q.push(temp);
                  System.out.println(temp+" pushed in");
               }
               else
               {
                  System.out.println("Please enter an String");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               try
               {
                  System.out.println(q.pop()+" popped out");
               }
               catch (MyStack.MyException e)
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
            case 'p':
            case 'P':
               try
               {
                  System.out.println(q.peek() + " on the top" );
               }
               catch (MyStack.MyException e)
               {
                  System.out.println("Invalid Operation - The stack is empty");
               }
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
         System.out.print(q.pop()+" ");
      }
      System.out.println();
   }
}  
