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
   private class PreIter implements Iterator<T>
   {
   /*
    * stack holds a reference to a stack of the objects in the bst in pre-order
    */
      private MyStack<BSTNode> stack;
      /**
	    * creates a new preorder iterator for the BST
	    * @param: root the bst that we wish to iterate through
	    * @Pre-conditions: none
	    * @Post-conditions: initilize a new stack and pushes in the root if !=
	    *                   null
	    */
      public PreIter(BSTNode root) 
      {
         stack = new MyStack<BSTNode> ();
         if(root != null)
         {
            stack.push(root);
         }
      }
      /**
	    * determines whether the stack is empty
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns the check for if the stack is empty
	    *                   
	    */
      public boolean hasNext()
      {
         return !stack.isEmpty();
      }
      /**
	    * returns the next value determined by the iterator
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns a T type element and throws a 
	    *       NoSuchElementException() if there is no next element
	    *                   
	    */
      public T next()
      {
         if(!hasNext())
            throw new NoSuchElementException();
         BSTNode ret = stack.pop();
         if(ret.right != null)
            stack.push(ret.right);
         if(ret.left != null)
            stack.push(ret.left);
         return ret.data;
      }
      /**
	    * remove is unsupported by our implimentation
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: throws UnsupportedOperationException()
	    *                   
	    */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   /*
    * inorder iterator class will traverse the BST
    *
    */
   private class InIter implements Iterator<T>
   {
    /*
     * stack holds a reference to a stack of the objects in the bst in-order
     */
      private MyStack<BSTNode> stack;
      /**
	    * creates a new inorder iterator for the BST
	    * @param: root the bst that we wish to iterate through
	    * @Pre-conditions: none
	    * @Post-conditions: initilize a new stack and stacks up the left nodes if
	    *                   root !=null
	    */
      public InIter(BSTNode root) 
      {
         stack = new MyStack<BSTNode> ();
         if(root != null)
         {
            stackUpLefts(root);
         }
      }
      /**
	    * adds the left nodes onto the stack
	    * @param: x the bst that we wish to add the left nodes on to the stack
	    * @Pre-conditions: none
	    * @Post-conditions: pushes the left children of the x node onto the stack
	    *                   
	    */
      private void stackUpLefts(BSTNode x)
      {
         stack.push(x);
         if(x.left != null)
            stackUpLefts(x.left);
         
      }
      /**
	    * determines whether the stack is empty
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns the check for if the stack is empty
	    *                   
	    */
      public boolean hasNext()
      {
         return !stack.isEmpty();
      }
      /**
	    * returns the next value determined by the iterator
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns a T type element and throws a 
	    *       NoSuchElementException() if there is no next element
	    *                   
	    */
      public T next()
      {
         if(stack.isEmpty())
            throw new NoSuchElementException();
         BSTNode x = stack.pop();
         if(x.right != null)
            stackUpLefts(x.right);
         return x.data;
      }
      /**
	    * remove is unsupported by our implimentation
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: throws UnsupportedOperationException()
	    *                   
	    */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   private class LevelIter implements Iterator<T>
   {
     /*
      * queue holds a reference to a queue of the objects in the bst level-order
      */
      private LQueue<BSTNode> q;
      /**
	    * creates a new levelorder iterator for the BST
	    * @param: root the bst that we wish to iterate through
	    * @Pre-conditions: none
	    * @Post-conditions: initilize a new stack and stacks up the left nodes if
	    *                   root !=null
	    */
      public LevelIter(BSTNode root) 
      {
         q = new LQueue<BSTNode> ();
         if(root != null)
         {
            q.enqueue(root);
         }
      }      
      /**
	    * determines whether the queue is empty
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns the check for if the queue is empty
	    *                   
	    */
      public boolean hasNext()
      {
         return !q.empty();
      }
      /**
	    * returns the next value determined by the iterator
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: returns a T type element and throws a 
	    *       NoSuchElementException() if there is no next element
	    *                   
	    */
      public T next()
      {
         if(q.empty())
            throw new NoSuchElementException();
         BSTNode x = q.dequeue();
         if(x.left != null)
            q.enqueue(x.left);
         if(x.right != null)
            q.enqueue(x.right);
         return x.data;
      }
      /**
	    * remove is unsupported by our implimentation
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: throws UnsupportedOperationException()
	    *                   
	    */
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   /*
    * Exception subclass that we will throw for this implementation
    *
    */
   public static class MyException extends RuntimeException
	{
	   /**
	    * Constructor for MyException class
	    * @param: none
	    * @Pre-conditions: none
	    * @Post-conditions: initilizes a MyException with no message
	    *                   
	    */
	   public MyException()
	   {
	      super();
	   }
	   /**
	    * constructor for MyException class with message
	    * @param: message a message to output to the user
	    * @Pre-conditions: message != null
	    * @Post-conditions: initilizes a MyException with a message "message"
	    */
	   public MyException (String message)
	   {
	      super(message);
	   }
	}
	/**
    * Constructor for BST class
    * @param: none
    * @Pre-conditions: none
    * @Post-conditions: Initializes root to be null. Creates an empty BST 
    *                   data structure
    */
	public BST()
	{
	   root =null;
	}
	/**
	 * Inserts item in the BST
	 * @param: item A T type object to be insterted
	 * @Pre-conditions: none
	 * @Post-conditions: BST has one more element which is item
	 */
	public void insert(T item)
	{
	   root = insertX(item, root);
	}
	/**
	 * Inserts item in the BS sub T
	 * @param: Item A T type object to be inserted in the tree
	 * @param: n    A BSTNode that serves as the "root" of the tree
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
	 * @param: item  the object to remove from the tree
	 * @Pre-conditions: none
	 * @Post-conditions: BST will have one fewer T item
	 */
	public void delete(T item)
	{
	   root = deleteX(item,root);
	}
	/**
	 * removes item in the BS sub T
	 * @param: item the object to remove from the tree
	 * @param: n BSTNode the root of the tree that we are working with
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
	 * @param: n    Node to be deleted from the tree
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
	 * @param: n   Node to find the successor of
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
	 * @param: item  the object to find in the tree
	 * @Pre-conditions: item != null
	 * @Post-conditions: returns wether the item is found in the BST
	 */
	public boolean find(T item)
	{
	   return findX(root, item);
	}
	/**
	 * Compares the data of the node to the item  in the BST
	 * @param: n     the root of the tree to find the object in
	 * @param: item   the object to find in the tree
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
	/**
	 * Checks and returns if the tree is empty
	 * @param: none
	 * @Pre-conditions: none
	 * @Post-conditions: returns the emptyness of the tree
	 */
	public boolean isEmpty()
	{
	   return root == null;
	}
	/**
	 * Removes reference to the previous root node
	 * @param: none
	 * @Pre-conditions: none
	 * @Post-conditions: root == null and BST is empty
	 */
	public void makeEmpty()
	{
	   root = null;
	}
	/**
	 * Finds the size of the BST
	 * @param: none
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
	 * @param: n the root of the subtree to find the size of
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
	 * @param: none
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
	 * @param: n the root of the subtree to find the minimum of
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
	 * @param: none
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
	 * @param: n the root of the subtree to find the maximum of
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
	/**
	 * Returns a reference to an iterator that will traverse the BST in Pre-order
	 * @param: n the root of the tree to iterate over
	 * @Pre-conditions: none
	 * @Post-conditions: creates and returns a new iterator for the end user to
	 *                   be able to iterate over the tree
	 * 
	 */
	public Iterator<T> iteratorPre()
	{
	   return new PreIter(root);
	}
	/**
	 * Returns a reference to an iterator that will traverse the BST in In-order
	 * @param: n the root of the tree to iterate over
	 * @Pre-conditions: none
	 * @Post-conditions: creates and returns a new iterator for the end user to
	 *                   be able to iterate over the tree
	 * 
	 */
	public Iterator<T> iteratorIn()
	{
	   return new InIter(root);
   }
	/**
	 * Returns: reference to an iterator that will traverse the BST in Levelorder
	 * @param: n the root of the tree to iterate over
	 * @Pre-conditions: none
	 * @Post-conditions: creates and returns a new iterator for the end user to
	 *                   be able to iterate over the tree
	 * 
	 */
	public Iterator<T> iteratorLevel()
	{
	   return new LevelIter(root);
	}
	/**
	 * Prints the tree to the console level by level left to right
	 * @param: none
	 * @Pre-conditions: none
	 * @Post-conditions: The tree is printed to the console in a "Directory" tree
	 *                   style
	 */
	public void testPrint() 
	{
	   if(isEmpty())
	      return;
	   testPrintx(root, 0);
	}
	/**
	 * Support method for Test print
	 * @param: x The current Root of the tree that we are printing
	 * @param: level the depth of the node within the BST
	 * @Pre-conditions: none
	 * @Post-conditions: Prints the current node to the console and calls 
	 *                   print on the left and right subTrees
	 */
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
