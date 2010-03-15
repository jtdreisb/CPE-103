public class AStack <T> 
{
   private T[] arr;
   private int top;

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

   public AStack (int size)
   {
      top=-1;
      arr= (T[]) new Object [size];
   }
   public void push (T item)
   {
      //System.out.println(arr.length+"=="+top);
      if (arr.length-1 == top) {
      //System.out.println("Making new Array");
         T [] temp = (T[]) new Object [arr.length*2];
         for (int i = 0; i<arr.length; i++) {
            temp[i]=arr[i];
         }
         arr=temp;
      }
      arr[++top]=item;
   }
   public T pop () 
   {
      if (top==-1)
         throw new MyException("Invalid operation: stack is empty");
      T temp= arr[top--];
      return temp;
   }
   public T peek () 
   {
      if (top==-1)
         throw new MyException("Invalid operation: stack is empty");
      return arr[top];
   }
   public boolean isEmpty()
   {
      return top==-1;
   }
}
