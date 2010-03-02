/*** HashTable with open addressing* With quadratic probing* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 5*/

public class TestDriver
{
   public static void main(String[] args)
   {     
      TestDriver.testCaseOne();
   }
   
   public static void testCaseOne()
   {
      Integer[] arr = new Integer[10];
      int index = 0;
      
      arr[index++] = 55;
      arr[index++] = 23;
      arr[index++] = 1;
      arr[index++] = 66;
      arr[index++] = 55;
      arr[index++] = 11;
      arr[index++] = 77;
      arr[index++] = 9;
      arr[index++] = 0;
      arr[index++] = -55;
      
      System.out.print("Unsorted           :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }  
      System.out.println();
      Sorts.selectionSort(arr,10);

      System.out.print("Sorted Selection   :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
      index = 0;
      arr[index++] = 55;
      arr[index++] = 23;
      arr[index++] = 1;
      arr[index++] = 66;
      arr[index++] = 55;
      arr[index++] = 11;
      arr[index++] = 77;
      arr[index++] = 9;
      arr[index++] = 0;
      arr[index++] = -55;
      
      Sorts.bubbleSort(arr,10);

      System.out.print("Sorted Bubble      :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();

      index = 0;
      arr[index++] = 55;
      arr[index++] = 23;
      arr[index++] = 1;
      arr[index++] = 66;
      arr[index++] = 55;
      arr[index++] = 11;
      arr[index++] = 77;
      arr[index++] = 9;
      arr[index++] = 0;
      arr[index++] = -55;

      
      Sorts.insertionSort(arr,10);

      System.out.print("Sorted insertion   :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
      
      
      index = 0;
      arr[index++] = 55;
      arr[index++] = 23;
      arr[index++] = 1;
      arr[index++] = 66;
      arr[index++] = 55;
      arr[index++] = 11;
      arr[index++] = 77;
      arr[index++] = 9;
      arr[index++] = 0;
      arr[index++] = -55;

      
      Sorts.mergeSort(arr,10);

      System.out.print("Sorted Merge       :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
      
      System.out.println();
      
      
      index = 0;
      arr[index++] = 55;
      arr[index++] = 23;
      arr[index++] = 1;
      arr[index++] = 66;
      arr[index++] = 33;
      arr[index++] = 11;
      arr[index++] = 77;
      arr[index++] = 9;
      arr[index++] = 0;
      arr[index++] = -55;

      
      Sorts.quickSort(arr,10);

      System.out.print("Sorted Quick      :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
      
      index = 0;
      arr[index++] = 0;
      arr[index++] = 1;
      arr[index++] = 2;
      arr[index++] = 3;
      arr[index++] = 4;
      arr[index++] = 5;
      arr[index++] = 6;
      arr[index++] = 7;
      arr[index++] = 8;
      arr[index++] = 9;

      
      Sorts.quickSort(arr,10);

      System.out.print("Sorted Quick      :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      System.out.println();
      
      
   }
}
