/*** Binary heap* contains two private instance variables for the size of the heap and the array* of the heap* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 2*/

import java.util.*;

public class BinHeap <T extends Comparable <? super T>> 
{
	/*
    * Exception subclass that we will throw for this implementation
    *
    */
	public static class MyException extends RuntimeException
	{
	   public MyException()
	   {
	      super();
	   }
	   public MyException (String message)
	   {
	      super(message);
	   }
	}
	/*
	 * arr hold the array representation of the heap
	 */
	private T[] arr; 
	/*
	 * count holds the size of the heap and also the index to the next
	 * open position in the heap
	 */
	private int count; 
	/**
	 * Initialises an empty heap
	 * Pre-conditions: none
	 * Post-conditions: empty heap, arr has size 100
	 */
	public BinHeap () {
	   count = 0;
	   arr  = (T[]) new Comparable [100];
	}
	/**
	 * Initialises an empty heap
	 * Pre-conditions: none
	 * Post-conditions: empty heap, arr has size "size"
	 * @param size size of array to house the heap
	 */
	public BinHeap (int size) {
	   count = 0;
	   arr  = (T[]) new Comparable [size];
	}
	/**
	 * Implements the insert operation of the heap structure: adds the value given as a parameter 
	 * an appropriate position in the array
	 * Pre-conditions: item != null
	 * Post-conditions:count is incremented and the heap is repositioned
	 * @param item A object of type T to be added to the heap<T>
	 */
	public void insert(T item) {
	   int hole=count;
	   if (arr.length-1 == count) {
         T [] temp = (T[]) new Comparable [arr.length*2];
         for (int i = 0; i<arr.length; i++) {
            temp[i]=arr[i];
         }
         arr=temp;
      }
	   while ( hole !=0 && arr[(hole-1)/2].compareTo(item)>0)
	   {
	      arr[hole]= arr[(hole-1)/2];
	      hole= (hole-1)/2;
	   }
	   arr[hole]= item;
	   count++;
	   
	}
	/**
	 * Implements the delete minimum value operation of the heap structure: removes the root node and 
	 * adjusts the structure of the heap accordingly
	 * Pre-conditions: item != null
	 * Post-conditions:top points to a node containing item
	 * @param item A object of type T to be added to the stack<T>
	 */
	public T deleteMin() {
	   if( count==0)
      throw new MyException ("Error: The heap is empty");
	   T temp = arr[0];
	   T item = arr[count-1];
	   int hole =0;
	   int newHole = newHole(hole, item);

	   count--;
	   
	   while(newHole!=-1) {
	      arr[hole] = arr[newHole];
	      hole = newHole;
	      newHole = newHole(hole, item);
      }
      arr[hole]=item;
	   return temp;
	}
	// Private method that facilitates traversing the heap
	private int newHole (int hole, T item)
   {
      int newHole = -1;
      if((hole*2+1) < count) {
         if( (hole*2+2) >= count) {
            if( arr[hole*2+1].compareTo(item) < 0) {
               newHole = hole*2+1;
            }
         }
         else {
            if (arr[hole*2+1].compareTo(arr[hole*2+2]) < 0) {
               if (arr[hole*2+1].compareTo(item) < 0)
                  newHole = hole*2+1;
            }
            else {
               if (arr[hole*2+2].compareTo(item) < 0)
                  newHole = hole*2+2;
            }
         }
      }
      
      return newHole;   
   }
	/**
	 * Implements the empty check operation of the Heap structure: Checks if count = 0
	 * Pre-conditions: none
	 * Post-conditions: none
	 * @return Boolean if the stack is empty
	 */
	public boolean isEmpty () {
	   return count == 0;
	}
	/**
	 * Implements the size check operation of the Heap structure: returns size
	 * Pre-conditions: none
	 * Post-conditions: none
	 * @return int pertaining to the amount of elements in the heap
	 */
	public int size () {
	   return count;
	}
	/**
	 * Implements the print operation of the Heap structure
	 * Pre-conditions: none
	 * Post-conditions: printed list of heap by row in the console
	 */
	public void print () {
	   for(int i =0; i<count; i++) {
	      System.out.print(arr[i] + " ");
	   }
	   System.out.println();
	}
}
