/*** HashTable with open addressing* With quadratic probing* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 5*/

public class TestDriver
{
   public static void main(String[] args)
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
      
      System.out.println("Unsorted:");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }  
      
      Sorts.selectionSort(arr,10);
      
      System.out.println("Sorted  :");
      for( int i = 0 ; i < index; i++)
      {
         System.out.print(" " + arr[i]);
      }
      
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
   }
}
