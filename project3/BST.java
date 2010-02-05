public class BST<T extends Comparable<? super T>>
{
   private class BSTNode
   {
      // data hold the value for the specific node
      T data;
      /*
       * left holds a reference to the node's left child
       * right holds a reference to the node's right child
       */
      BSTNode left, right;
   }
   
   private BSTNode root;
   
   private class PreIter
   {
   
   }
   private class InIter
   {
   
   }
   private class LevelIter
   {
   
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
	
	public BST()
	{}
	public void insert(T item)
	{
	
	}
	public void delete(T item)
	{
	
	}
	public boolean find(T item)
	{
	
	}
	public boolean isEmpty()
	{
	
	}
	public void makeEmpty()
	{
	
	}
	public int size()
	{
	
	}
	public T findMinimum() throws MyException
	{
	
	}
	public T findMaximum() throws MyException
	{
	
	}
	public Iterator<T> iteratorPre(){}
	public Iterator<T> iteratorIn(){}
	public Iterator<T> iteratorLevel(){}
	public void testPrint() {}
}
