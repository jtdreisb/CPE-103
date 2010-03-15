
public class AQueue <T> 
{
   private int front, end, count;
   private T[] arr; 
   
   public  AQueue (int size) {
	   arr = (T[])new Object [size];
	   front=0;
	   count=0;
	   end=-1;
	}
   
   	public T dequeue()  {
		T temp;
		if(count == 0){
			throw new MyException("Queue is empty");
		}
		temp=arr[front];
		arr[front] = null;
		front++;
		count--;
		if (front==arr.length) {
			front=0;
		}
		return temp;
	}
	public void enqueue (T item) {
		if (count == arr.length) {
			//throw new MyException ("Queue is full");
			T[] newArr = (T[])new Object[2*arr.length];
			for( int i = 0; i< arr.length ; i++) {
			   if(front == arr.length) 
			      front = 0;
			   newArr[i] = arr[front++];
			}
			end = arr.length-1;
			arr = newArr;
			front = 0;
		}
		else if(end==arr.length-1){
			end=-1;
		}
		arr[++end] = item;
		count++;

	}
	public boolean empty(){
		return count == 0; 
	}

   public void printArray() {
      for( int i = 0; i < arr.length; i++ )
      {
         System.out.print(arr[i]+" ");
      }
      System.out.println();
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
	
}
