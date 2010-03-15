/* Jason Dreisbach
 * Ross Light
 * Lab1
 */
import java.util.*;
 
public class ListWork
{
   public static <T> boolean search( T [] arr, T target)
   {
      for(T var : arr)
      {
         if(var.equals(target))
            return true;
      }
      return false;
   }
   public static <T> void print( T [] arr)
   {
      for(T var : arr)
      {
            System.out.println(var);
      }
   }
   public static void main(String [] args)
   {
      Integer data[] = new Integer[10];
      int i = 0;
      String userInput;
      boolean shouldSearch = true, found;
      int temp = 0;
      Scanner in = new Scanner(System.in);
      
      while(i < 10)
      {
         try
         {
            temp = in.nextInt();
            data[i++] = new Integer(temp);
         }
         catch (InputMismatchException e)
         {
            in.next();
         }
      }
      in.nextLine();
      while(shouldSearch)
      {
         System.out.print("What do you want to search for? ");
         try
         {
            temp = in.nextInt();
            found = search(data, new Integer(temp));
            if (found)
            {
               System.out.println("Found in the array");
            }
            else
            {
               System.out.println("Not found in the array");
            }
         }
         catch (InputMismatchException e)
         {
            System.out.println("You need to enter in an integer!");
            in.next();
         }
         
         System.out.print("Do you want to search again (y/n)? ");
         userInput = in.next();
         while (!userInput.equals("y") && !userInput.equals("n"))
         {
            System.out.println("Please enter y or n!");
            userInput = in.next();
         }
         if (userInput.equals("y"))
            shouldSearch = true;
         else
            shouldSearch = false;
      }
      
      print(data);
   } 
}
