/*** A linked list stack* contains one private instance variable for the top of the stack and has four* public methods that impliments stack operations* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 3*/

public class MyStack<T>
{
   /*
    * Linked list node that holds data and next node reference 
    *
    */
   private class Node 
	{
	   T data;
	   Node next;
	}
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
    * top holds the address of the first node in the linked list if the list is not empty, and is null otherwise.
    */
	private Node top;
	/**
	 * Initialises an empty stack
	 * Pre-conditions: none
	 * Post-conditions: empty stack, top points to null
	 */
	public MyStack() {
      
   }
   /**
	 * Implements the push operation of the Stack structure: adds the value given as a parameter to the front of the linked list
	 * Pre-conditions: item != null
	 * Post-conditions:top points to a node containing item
	 * @param item A object of type T to be added to the stack<T>
	 */
   public void push(T item)
   {
      Node newNode = new Node();
      newNode.data = item;
      if(top == null)
      {
         top = newNode;
      }
      else {
         newNode.next = top;
         top = newNode;
      }
   }
   /**
	 * Implements the pop operation of the Stack structure: removes and returns the top value of the linked list
	 * Pre-conditions: checked non-empty stack
	 * Post-conditions: returns top.item and points item to the next node
	 * @throws MyException
	 * @return Variable type T that was on top of the stack
	 */
   public T pop()
   {
      if(isEmpty())
      {
         throw new MyException("Stack is empty!");
      }
      T temp = top.data;
      if(top.next == null)
      {
         top = null;
      }
      else 
      {
         top = top.next;
      }
      return temp;
   }
   /**
	 * Implements the peek operation of the Stack structure: returns the top of the linked list
	 * Pre-conditions: checked non-empty stack
	 * Post-conditions: returns top.item, no change to the stack
	 * @throws MyException
	 * @return Variable type T that is on top of the stack
	 */
   public T peek()
   {
      if(isEmpty())
      {
         throw new MyException("Stack is empty!");
      }
      return top.data;
   }
   /**
	 * Implements the empty check operation of the Stack structure: Checks if top is initialized with a value
	 * Pre-conditions: none
	 * Post-conditions: none
	 * @return Boolean if the stack is empty
	 */
   public boolean isEmpty()
   {
      return top == null;
   }
}
