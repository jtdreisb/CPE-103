import java.util.Scanner;
public class GCDCalculator
{
   public static int gcd(int x, int y)
   {
      if(x > y)
      {
         return gcd(x-y,y);
      }
      else if( x < y )
      {
         return gcd(x,y-x);
      }
      return x;
   }
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      int x =0, y=0;
      int i = 0 ;
      
      char decision = 'y';
      
      while ( decision == 'y')
      {
         System.out.println("enter 2 integers");
         if( scan.hasNextInt())
         {
            x = scan.nextInt();
            if(scan.hasNextInt())
            {
               y = scan.nextInt();
            }
            else
            {
               System.out.println("Enter an Int!");
            }
         }
         else
         {
            System.out.println("Enter an Int!");
         }
         System.out.println("Thanks! The gcd is: "+ gcd(x,y));
         
         
         System.out.println("Would you like to continue(y or n)?");
         while(!scan.hasNext());
         decision = scan.next().charAt(0);
         scan.nextLine();
         
      }
      
   }
}
