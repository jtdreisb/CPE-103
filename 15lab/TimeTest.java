public class TimeTest
{
   public static void  main(String[] args)
   {
      System.out.println("Logorithmic algorithm runtimes:");
      for(long i = 10000; i < 100000000; i+=i)
      {
         System.out.println("T(" + i +") = " + AlgorithmTimes.logarithmicAlgTime(i));
      }
      System.out.println();
      System.out.println("Linear algorithm runtimes:");
      for(long i = 10000; i < 100000000; i+=i)
      {
         System.out.println("T(" + i +") = " + AlgorithmTimes.linearAlgTime(i));
      }
      System.out.println();
      System.out.println("NLogN algorithm runtimes:");
      for(long i = 10000; i < 100000000; i+=i)
      {
         System.out.println("T(" + i +") = " + AlgorithmTimes.NLogNAlgTime(i));
      }
      System.out.println();
      System.out.println("Quadratic algorithm runtimes:");
      for(long i = 10000; i < 400000; i+=i)
      {
         System.out.println("T(" + i +") = " + AlgorithmTimes.quadraticAlgTime(i));
      }
   }
}
