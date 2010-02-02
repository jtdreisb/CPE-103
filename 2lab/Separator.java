//Jason
//Ross

import java.util.*;

public class Separator
{
   static final int N = 5;
   
   public static void main(String[] args)
   {
      int[] intArr = new int[N];
      float[] floatArr = new float[N];
      int iIndex = 0, fIndex = 0;
      Scanner in = new Scanner(System.in);
      
      while(in.hasNext())
      {
         if(in.hasNextInt())
         {
            if (iIndex == N)
               break;
            intArr[iIndex++] = in.nextInt();
         }
         else if (in.hasNextFloat())
         {
            if (fIndex == N)
               break;
            floatArr[fIndex++] = in.nextFloat();
         }
         else
         {
            // Non-numerical input
            break;
         }
      }
      
      System.out.print("Integers:");
      for (int i = 0; i < iIndex; i++)
      {
         System.out.print(" " + intArr[i]);
      }
      System.out.println();
      
      System.out.print("Floats:");
      for (int i = 0; i < fIndex; i++)
      {
         System.out.print(" " + floatArr[i]);
      }
      System.out.println();
   }
}
