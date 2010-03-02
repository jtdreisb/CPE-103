/*** Static class which allows for a generic implementation of
* sorting algorithms* * @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 5*/


public class Sorts <Type>
{
   /*
   *  Sorts an array of type Type elements with a size of T
   *  with selection sort algorithm
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: size the number of elements held within the array
   *  @Preconditions: arr != null, all elements in arr < size !=null
   *  @Postconditions: array is sorted by the selection sort process
   */
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
   
   
   /*
   *  Sorts an array of type Type elements with a size of T
   *  with bubble sort algorithm
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: size the number of elements held within the array
   *  @Preconditions: arr != null, all elements in arr < size !=null
   *  @Postconditions: array is sorted by the bubble sort process
   */
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
   
   
   /*
   *  Sorts an array of type Type elements with a size of T
   *  with insertion sort algorithm
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: size the number of elements held within the array
   *  @Preconditions: arr != null, all elements in arr < size !=null
   *  @Postconditions: array is sorted by the insertion sort process
   */
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
   
   
   /*
   *  Private method that supports the simple sorting techniques
   *  swaps the elements at indexes a and b in arr
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: a an index of an element to be swapped
   *  @param: b an index of an element to be swapped
   *  @Preconditions: arr != null, a and b are valid indices
   *  @Postconditions: arr[b] will be in arr[a] and vice versa
   */
   private static <Type extends Comparable<? super Type>>
                  void swap(Type[] arr, int a, int b)
   {
      Type temp = arr[a];
      arr[a] = arr[b];
      arr[b] = temp;
   }
   
   
   /*
   *  Sorts an array of type Type elements with a size of T
   *  with merge sort algorithm
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: size the number of elements held within the array
   *  @Preconditions: arr != null, all elements in arr < size !=null
   *  @Postconditions: array is sorted by the merge sort technique
   */
   public static <Type extends Comparable<? super Type>> 
                  void mergeSort(Type[] arr, int size)
   {
      Sorts.mergesort(arr,0,size-1);
   }
   
   
   /*
   *  Private method that supports the functionality of the mergesort
   *  algorithm. Splits the list and calls itself recursively
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: first The first element of the sub array
   *  @param: last   The last element of the sub array 
   *  @Preconditions: arr != null, first and last are valid indices                 
   *  @Postconditions: given array is sorted between first and last
   */
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
    *
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
   
   
   /*
   *  Sorts an array of type Type elements with a size of T
   *  with quick sort algorithm
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: size the number of elements held within the array
   *  @Preconditions: arr != null, all elements in arr < size !=null
   *  @Postconditions: array is sorted by the quicksort process
   */
   public static <Type extends Comparable<? super Type>> 
                  void quickSort(Type[] arr, int size)
   {
      quicksort(arr, 0, size-1);
   }
   
   
   /*
   *  Private method that supports the quicksort technique
   *  moves pivot to the end of the array, splits and recursively
   *  calls itself to further sort the list.
   *
   *  @param: arr an array of Type elements to be sorted
   *  @param: first the index of the first element of the subarray
   *  @param: last the index of the last element of the subarray
   *  @Preconditions: arr != null, first and last are valid indices
   *  @Postconditions: arr[first..last] will be sorted
   */
   private static <Type extends Comparable<? super Type>>
      void quicksort(Type[] arr, int first, int last)
   {
      if(first<last)
      {
         setPivotToEnd(arr, first, last);
         int index = splitList(arr, first, last);
         quicksort(arr, first, index-1);
         quicksort(arr, index+1, last);
      }
   }
  
  
  /* Chooses pivot in array and moves it to the end of the segment
   *
   * @Precondition: none
   * @Postcondition: arr[right] is the pivot
   */
   private static <Type extends Comparable<? super Type>>
       void setPivotToEnd(Type[] arr, int left, int right)
   {
      Type temp;
      int center = (left+right)/2;
      
      if(arr[center].compareTo(arr[left]) < 0)
      {
         temp = arr[center];
         arr[center] = arr[left];
         arr[left] = temp;
      }
      if(arr[right].compareTo(arr[left]) < 0)
      {
         temp = arr[right];
         arr[right] = arr[left];
         arr[left] = temp;
      }
      if(arr[center].compareTo(arr[right]) < 0)
      {
         temp = arr[center];
         arr[center] = arr[right];
         arr[right] = temp;
      }   
   }
   
   
   /* Rearranges list by placing pivot so that it is preceeded
    *    by smaller values and proceeded by greater values
    *    returns pivot's index
    *
    * @Precondition: arr[right] contains pivot
    * @Postcondition: pivot is placed at the index in the list and
    *    and it's index is returned. 
    */
   private static <Type extends Comparable<? super Type>>
      int splitList(Type[] arr, int left, int right)
   {
      int indexL = left;
      int indexR = right-1;
      Type temp, pivot  = arr[right];

      while(indexL<=indexR)
      {
         while(arr[indexL].compareTo(pivot) < 0 )
         {
            indexL++;
         }
         while(indexL <= indexR && arr[indexR].compareTo(pivot) > 0)
         {
            indexR--;
         }
         if(indexL <= indexR)
         {
            temp = arr[indexL];
            arr[indexL] = arr[indexR];
            arr[indexR] = temp;
            indexL++;
            indexR--;
         }
      }
      if(indexL != indexR)
      {
         temp = arr[indexL];
         arr[indexL] = arr[right];
         arr[right] = temp;
      }
      return indexL;
   }
}
