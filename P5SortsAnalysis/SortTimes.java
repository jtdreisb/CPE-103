/*** TestDriver for Sort algorithms in Sorts.java* provides details on running times of each algorithm* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 5*/

public class SortTimes
{
   /* Creates 5 arrays to be sorted by each of the five sort methods
   *  First tests presorted list, the reverse sorted, then random lists
   *  three times. Outputs the time in miliseconds it takes for the 
   *  computer to complete each sort
   *
   *  @Preconditions: Sorts.class must be created and complete
   *  @Postconditions: All 5 lists are sorted, and timing followed by 
   *  a farewell message are outputed
   */
   public static void main(String[] args)
   {
      Integer[] list1 = new Integer[80000] ;
      Integer[] list2 = new Integer[80000] ;
      Integer[] list3 = new Integer[80000] ;
      Integer[] list4 = new Integer[80000] ;
      Integer[] list5 = new Integer[80000] ;


      
      System.out.println("Test 1: presorted list");
      
      for(int i = 5000; i <= 80000; i=2*i)
      {
         for( int j = 0; j < i; j++)
         {
            list1[j] = j;
         }
         for(int j = 0; j < i; j++)
         {
            list2[j] = list1[j];
            list3[j] = list1[j];
            list4[j] = list1[j];
            list5[j] = list1[j];
         }
         long[] times = testTimes(i,list1,list2,list3,list4,list5);
         System.out.println("N=" + i +": T_ss="+times[0]+", T_bs="+times[1]+", T_is=" + times[2] + ", T_ms=" +times[3]+ ", T_qs=" +times[4]);
      }
      
      System.out.println();
      System.out.println("Test 2: reverse sorted list");
      
      for(int i = 5000; i <= 80000; i=2*i)
      {
         for( int j = 0; j < i; j++)
         {
            list1[j] = i-j-1;
         }
         for(int j = 0; j < i; j++)
         {
            list2[j] = list1[j];
            list3[j] = list1[j];
            list4[j] = list1[j];
            list5[j] = list1[j];
         }
         long[] times = testTimes(i,list1,list2,list3,list4,list5);
         System.out.println("N=" + i +": T_ss="+times[0]+", T_bs="+times[1]+", T_is=" + times[2] + ", T_ms=" +times[3]+ ", T_qs=" +times[4]);
      }
      
      java.util.Random rand ;
      System.out.println();
      System.out.println("Test 3: random list");
      
      for(int i = 5000; i <= 80000; i=2*i)
      {
         for(int count = 0; count<3; count++)
         {
            rand = new java.util.Random(System.nanoTime());
            for( int j = 0; j < i; j++)
            {
               list1[j] = rand.nextInt(i);
            }
            for(int j = 0; j < i; j++)
            {
               list2[j] = list1[j];
               list3[j] = list1[j];
               list4[j] = list1[j];
               list5[j] = list1[j];
            }
            long[] times = testTimes(i,list1,list2,list3,list4,list5);
            System.out.println("N=" + i +": T_ss="+times[0]+", T_bs="+times[1]+", T_is=" + times[2] + ", T_ms=" +times[3]+ ", T_qs=" +times[4]);
         }
         System.out.println();
      }
      
      System.out.println();
      System.out.println("a farwell message");
   }
   
   /* 
   *  Private helper method that takes in five lists of integers
   *  and applies an individual sort algorithm to each. Saves running time
   *  of each algorithm in an array of longs
   *
   *  @Preconditions: all lists != null and all items in lists must be non null
   *                 for indices < i
   *  @Postconditions: all lists are sorted, and the time in miliseconds for the sort
   *                 to complete is returned in an array of longs. 
   */
   private static long[] testTimes(int i, Integer[] list1, Integer[] list2, 
                  Integer[] list3, Integer[] list4, Integer[] list5)
   {
      long[] ret = new long[5];
      long endTime, startTime;
      
      startTime = System.nanoTime();
      Sorts.selectionSort(list1, i);
      endTime = System.nanoTime();
      
      ret[0]  = (endTime-startTime)/1000000;
      
      startTime = System.nanoTime();
      Sorts.bubbleSort(list2, i);
      endTime = System.nanoTime();
      
      ret[1]  = (endTime-startTime)/1000000;
      
      startTime = System.nanoTime();
      Sorts.insertionSort(list3, i);
      endTime = System.nanoTime();
      
      ret[2]  = (endTime-startTime)/1000000;
      
      startTime = System.nanoTime();
      Sorts.mergeSort(list4, i);
      endTime = System.nanoTime();
      
      ret[3]  = (endTime-startTime)/1000000;
      
      startTime = System.nanoTime();
      Sorts.quickSort(list5, i);
      endTime = System.nanoTime();
      
      ret[4]  = (endTime-startTime)/1000000;
      
      return ret;
   }
}
