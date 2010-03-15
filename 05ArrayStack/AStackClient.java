import java.util.Scanner;
import java.io.*;
public class AStackClient
{
   public static void main(String[] args)
   {  
      String fileName;
      Scanner fileScan;
      Scanner scan = new Scanner(System.in);
      AStack intStack= new AStack <Integer> (5);
      AStack floatStack= new AStack <Float> (5);
      AStack stringStack = new AStack <String> (5);
      
      System.out.println("Please enter a file name: ");    
      fileName= scan.nextLine();
      try{
         fileScan= new Scanner(new File (fileName));
      }
      catch (Exception e){fileScan=scan;}

      while (fileScan.hasNext()){
         if(fileScan.hasNextInt())
            intStack.push(fileScan.nextInt());
         else if (fileScan.hasNextFloat())
            floatStack.push(fileScan.nextFloat());
         else 
            stringStack.push(fileScan.next());
      }
      System.out.print("Strings: ");
      while ( !stringStack.isEmpty()) {
         System.out.print( stringStack.pop() + " ");
      }
      System.out.println();
      
      System.out.print("Floats: ");
      while ( !floatStack.isEmpty()) {
         System.out.print( floatStack.pop() + " ");
      }
      System.out.println();
      
      System.out.print("Integers: ");
      while ( !intStack.isEmpty()) {
         System.out.print( intStack.pop() + " ");
      }
      System.out.println();
   }
}
