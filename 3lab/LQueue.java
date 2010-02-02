import java.util.Scanner;

public class LQueue <T> {
	
	private class Node 
	{
	   T data;
	   Node next;
	}
	
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
     
	private Node front, end;


   public LQueue ()
   {
      front = end = null;
   }
   
   public boolean empty(){
		return front ==  null; 
	}

	public T dequeue()  {
		T temp;
		if(front == null){
			throw new MyException("Queue is empty");
		}
		temp = front.data;
		front = front.next;
		return temp;
	}
	public void enqueue (T item) {
		if (front == null) {
			front = end = new Node();
			front.data = item;
			front.next = null;
		}
		else 
		{
		   Node temp = new Node();
		   
		   end.next = temp;
		   temp.data = item;
		   temp.next = null;
		   end = temp;
		}
	}
}
