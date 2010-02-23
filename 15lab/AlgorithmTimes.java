
public class AlgorithmTimes
{
   public static long linearAlgTime(long n)
   {
      long endTime, startTime = System.nanoTime();
      int x;
      for( int i = 1 ; i < n ;i++)
      {
         x = i;
      }
      endTime = System.nanoTime();
      
      return (endTime-startTime)/1000000;
   }


   public static long quadraticAlgTime(long n)
   {
      long endTime, startTime = System.nanoTime();
      int x;
      for(int i = 1 ; i < n  ;i++)
      {
         for (int j = 1; j < n; j++)
         {
            x = i;
         }
      }
      endTime = System.nanoTime();
      
      return (endTime-startTime)/1000000;
   }


   public static long logarithmicAlgTime(long n)
   {
      long endTime, startTime = System.nanoTime();
      long x;
      for( long i = n ; i > 1  ; i =i/2)
      {
         x = i;
      }
      endTime = System.nanoTime();
      
      return (endTime-startTime)/1000000;
   }


   public static long NLogNAlgTime(long n)
   {
      long endTime, startTime = System.nanoTime();
      long x;
      for( int i = 1 ; i < n ;i++)
      {
         for( long j = n ; j > 1  ;j=j/2)
         {
            x = j;
         }
      }
      endTime = System.nanoTime();
      
      return (endTime-startTime)/1000000;
   }
}
