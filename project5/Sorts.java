/*** HashTable with open addressing* With quadratic probing* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 5*/


public class Sorts <Type>
{
   public static <Type extends Comparable<? super Type>> 
                  void selectionSort(Type[] arr, int size)
   {
      int minIndex = 0;
      for( int i = 0; i < size -1 ; i++)
      {
         minIndex = i;
         for( int j = i+1 ; j < size; j++)
         {
            if( arr[j].compareTo(arr[minIndex]) < 0)
               minIndex = j;
         }
         Sorts.swap(arr,i,minIndex);
      }
   }
   
   
   public static <Type extends Comparable<? super Type>> 
                  void bubbleSort(Type[] arr, int size)
   {
      boolean done = false;
      while( !done )
      {
         done = true;
         for( int i = 0; i < size-1; i++)
         {
            if( arr[i].compareTo(arr[i+1]) > 0)
            {
               Sorts.swap(arr, i , i+1);
               done = false;
            }
         }
      }
   }
   
   
   public static <Type extends Comparable<? super Type>> 
                  void insertionSort(Type[] arr, int size)
   {
      Type temp;
      int j;
      for( int i = 1; i < size; i++)
      {
         temp = arr[i];
         j = i;
         while( j != 0 && arr[j-1].compareTo(temp) > 0 )
         {
            arr[j] = arr[j-1];
            j--;
         }
         arr[j] = temp;
      }
   }
   
   
   private static <Type extends Comparable<? super Type>>
                  void swap(Type[] arr, int a, int b)
   {
      Type temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
   }
   
   
   public static <Type extends Comparable<? super Type>> 
                  void mergeSort(Type[] arr, int size)
   {
      Sorts.mergesort(arr,0,size-1);
   }
   
   
   private static <Type extends Comparable<? super Type>>
                  void mergesort(Type[] arr, int first, int last)
   {
      int middle;
      if(first < last)
      {
         middle = (first + last)/2;
         Sorts.mergesort(arr, first ,middle);
         Sorts.mergesort(arr, middle+1 , last);
         Sorts.mergesortedhalves(arr, first, middle, last);
      }
   }
   
   /**
    * Merges two sorted halves of array segment
    * @param: arr       array that contains elements to merge
    * @param: first     index of first element
    * @param: middle    index of middle element
    * @param: last      index of last element
    * @Pre-conditions:  arr[first..middle] && arr[middle+1..last] are sorted
    * @Post-conditions: arr[first..last] is sorted
    */
   private static <Type extends Comparable<? super Type>>
                    void mergesortedhalves(Type[] arr, int first, 
                                          int middle, int last)
   {
      Type[] tempArr = (Type []) new Comparable[last-first+1];
      int indexOne = first;
      int indexTwo = middle+1;
      int index = 0;

      while( indexOne <= middle && indexTwo <= last)
      {
         if(arr[indexOne].compareTo(arr[indexTwo]) < 0 )
         {

            tempArr[index] =  arr[indexOne];
            indexOne++;
         }
         else
         {

            tempArr[index] = arr[indexTwo];
            indexTwo++;
         }
         index++;
      }
      while(indexOne <= middle)
      {
         tempArr[index++] = arr[indexOne++];
      }
      while(indexTwo <= last)
      {
         tempArr[index++] = arr[indexTwo++];
      }

      for( int i = 0; i < tempArr.length; i++ )
      {
         arr[first + i] = tempArr[i];
      }

   }
   
   
   public static <Type extends Comparable<? super Type>> 
                  void quickSort(Type[] arr, int size)
   {
   
   }



    
}
