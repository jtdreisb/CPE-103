/*** Binary Search tree* Provides a generic implentation of a binary search tree* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 3*/
import java.util.*;
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
   /*
    * root holds a reference to the root node of the bst
    */
   private BSTNode root;
   /*
    * Preorder iterator class will traverse the BST
    *
    */
   private class PreIter
   {
   
   }
   private class InIter
   {
   
   }
   private class LevelIter
   {
   
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
	
	public BST()
	{}
	/**
	 * Inserts item in the BST
	 * @Pre-conditions: none
	 * @Post-conditions: BST has one more element which is item
	 */
	public void insert(T item)
	{
	   root = insertX(item, root);
	}
	/**
	 * Inserts item in the BS sub T
	 * @Pre-conditions: none
	 * @Post-conditions: BS sub T has one more element which is item
	 */
	private BSTNode insertX(T item, BSTNode n)
	{
	   if(n == null)
	   {
	      n = new BSTNode();
	      n.data = item;
	   }
	   else
	   {
	      if(item.compareTo(n.data) < 0)
	      {
	         n.left = insertX(item, n.left);
	      }
	      else
	      {
	         n.right = insertX(item, n.right);
	      }
	   }
	   return n;  
	}
	/**
	 * removes item in the BST
	 * @Pre-conditions: none
	 * @Post-conditions: BST will have one fewer T item
	 */
	public void delete(T item)
	{
	   root = deleteX(item,root);
	}
	/**
	 * removes item in the BS sub T
	 * @Pre-conditions: item != null
	 * @Post-conditions: BS sub T will have one fewer T item
	 */
	private BSTNode deleteX(T item, BSTNode n)
	{
	   if(n != null)
	   {
	      if(item.compareTo(n.data) < 0)
	      {
	         n.left = deleteX(item, n.left);
	      }
	      else if(item.compareTo(n.data) > 0)
	      {
	         n.right = deleteX(item, n.right);
	      }
	      else
	      {
	         n = deleteNode(n);
	      }
	   }
	   return n;
	  
	}
	/**
	 * removes node given in parameter
	 * @Pre-conditions: n != null
	 * @Post-conditions: n will be deleted from tree
	 */
	private BSTNode deleteNode(BSTNode n)
	{
	   T nextData;
	   BSTNode ans;
	   if(n.left != null && n.right != null)
	   {
	      nextData = successor(n);
	      n.data = nextData;
	      n.right = deleteX(nextData, n.right);
	      ans = n;
	   }
	   else if(n.left != null && n.right == null)
      {
         ans = n.left;
      }
	   else if(n.left == null && n.right != null)
	   {
	      ans = n.right;
	   }
	   else
	   {
	      ans = null;
	   }
	   return ans;
	}
	/**
	 * Finds the successor value in the BST
	 * @Pre-conditions: n != null
	 * @Post-conditions: returns the next greates value in the BST
	 */
	private T successor(BSTNode n)
	{
	   BSTNode temp = n.right;
	   while( temp.left != null)
	   {
	      temp = temp.left;
	   }
	   return temp.data;
   }
	/**
	 * Finds and returns if the item is in the BST
	 * @Pre-conditions: item != null
	 * @Post-conditions: returns wether the item is found in the BST
	 */
	public boolean find(T item)
	{
	   return findX(root, item);
	}
	/**
	 * Compares the data of the node to the item  in the BST
	 * @Pre-conditions: item != null
	 * @Post-conditions: returns wether the item is found in the BST
	 */
	private boolean findX(BSTNode n,T item)
	{
	   if(n == null)
	      return false;
	   int cmp = n.data.compareTo(item);
	   if(cmp == 0)
	      return true;
	   else if( cmp > 0)
	      return findX(n.left, item);
	   else 
	      return findX(n.right, item);
	}
	public boolean isEmpty()
	{
	   return root == null;
	}
	/**
	 * Removes reference to the previous root node
	 * @Pre-conditions: none
	 * @Post-conditions: root == null and BST is empty
	 */
	public void makeEmpty()
	{
	   root = null;
	}
	/**
	 * Finds the size of the BST
	 * @Pre-conditions: none
	 * @Post-conditions: returns the size of the BST
	 */
	public int size()
	{
	   if(root == null)
	   {
	      return 0;
	   }
	   return sizeX(root);
	}
	/**
	 * Finds the size of the BST
	 * @Pre-conditions: none
	 * @Post-conditions: returns the size of the BS sub T
	 */
	private int sizeX(BSTNode n)
	{
	   int count = 1;
	   if(n.left != null)
	   {
	      count += sizeX(n.left);
	   }
	   if(n.right != null)
	   {
	      count += sizeX(n.right);
	   }
	   return count;
	}
	/**
	 * Finds and returns the minimum object in the BST
	 * @Pre-conditions: none
	 * @Post-conditions: throws myexception if item is not found
	 * otherwise returns the minimum value
	 */
	public T findMinimum() throws MyException
	{
	   if(root ==null)
	      throw new BST.MyException("The tree is Empty - Operation unsupported");
	   return findMinimum(root);
	}
	/**
	 * Finds and returns the minimum object in the BST
	 * @Pre-conditions: n != null
	 * @Post-conditions: throws myexception if item is not found
	 * otherwise returns the minimum value
	 */
	private T findMinimum(BSTNode n) 
	{
	   if(n.left == null)
	   {
	      return n.data;
	   }
	   else
	   {
	      return findMinimum(n.left);
	   }
	}
	/**
	 * Finds and returns the maximum object in the BST
	 * @Pre-conditions: none
	 * @Post-conditions: throws myexception if tree is empty
	 * otherwise returns the maximum value
	 */
	public T findMaximum() throws MyException
	{
	   if(root == null)
	         throw new BST.MyException("The tree is Empty - Operation unsupported");
	   return findMaximum(root);
	}
	/**
	 * Finds and returns the maximum object in the BST
	 * @Pre-conditions: n != null
	 * @Post-conditions: throws myexception if item is not found
	 * otherwise returns the maximum value
	 */
	private T findMaximum(BSTNode n) 
	{
	   if(n.right == null)
	   {
	      return n.data;
	   }
	   else
	   {
	      return findMaximum(n.right);
	   }
	}
	public Iterator<T> iteratorPre(){return null;}
	public Iterator<T> iteratorIn(){return null;}
	public Iterator<T> iteratorLevel(){return null;}
	public void testPrint() 
	{
	   if(isEmpty())
	      return;
	   testPrintx(root, 0);
	}
	private void testPrintx(BSTNode x, int level)
	{
	   for(int i=0; i<level; i++)
	   {
	      System.out.print("   ");
	   }
	   System.out.println(x.data);
	   if(x.left != null)
	   {
	      testPrintx(x.left,level + 1);
	   }
	   if(x.right != null)
	   {
	      testPrintx(x.right, level + 1);
	   }
	}
}
