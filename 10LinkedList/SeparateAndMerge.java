import java.util.*;
public class SeparateAndMerge
{
   public static void main (String[] args)
   {
      LList <Integer> listInt = new LList <Integer> ();
      LList <Float> listFloat = new LList <Float> ();
      Scanner scan = new Scanner (System.in);
      
      System.out.println("Please insert some numbers");
      while ( scan.hasNext())
      {
         if(scan.hasNextInt())
            listInt.add(new Integer (scan.nextInt()));
         else if( scan.hasNextFloat())
            listFloat.add(new Float (scan.nextFloat()));
         else
            scan.next();
      }
      System.out.println();
      System.out.print("Inputted values: ");
      Iterator intIt = listInt.iterator();
      Iterator floatIt = listFloat.iterator();
      while( intIt.hasNext() || floatIt.hasNext())
      {
         if( intIt.hasNext())
            System.out.print(intIt.next() + "   ");
         if( floatIt.hasNext())
            System.out.print(floatIt.next() + "   ");
      }
      System.out.println();
   }
}
