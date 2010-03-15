import java.util.*;
public class TreeWork 
{
   public static <T extends Comparable<? super T>> boolean isHeap(T[] arr,
                                                                        int N) 
   { 
      for( int i=0; i< N; i++) {
         if(i*2+1<N)
         {
            if ( arr[i*2+1].compareTo(arr[i]) < 0 )
               return false; 
         }
         if (i*2+2<N)
         {
            if( arr[i*2+2].compareTo(arr[i]) < 0 )
               return false;
         }
      }
      return true;
   }
   public static <T> void printTree(T[] arr, int N) 
   {
      int nodes = 1;
      int sum = 0;
      while( sum < N)
      {
         for (int i = 0; i<nodes && sum+i < N; i++) { 
            
            System.out.print(arr[sum+i]+" ");
            
         }
         sum+= nodes;
         System.out.println();
         nodes+=nodes;
      }
   }
}
