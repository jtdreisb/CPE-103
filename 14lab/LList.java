import java.util.*;
public class LList <T> 
{
   private Node head;
   private class Node 
   {
      T data;
      Node next;
   }
   public Iterator <T> iterator() 
   {
      return new Iter();
   }
   private class Iter implements Iterator <T> 
   {
      public Node cursor;
      public Iter()
      {
         cursor = head;
      }
      public boolean hasNext()
      {
         return cursor != null;
      }
      public T next()
      {
         T answer = null;
         if (hasNext())
         {
            answer = cursor.data;
            cursor = cursor.next;
         }
         else 
            throw new NoSuchElementException ();
         return answer;
      }
      public void remove() 
      {
         throw new UnsupportedOperationException();
      }
   }
   public LList ()
   {
      head=null;
   }
   public void add (T item)
   {
      if( head==null)
      {
         head = new Node();
         head.data = item;
      }  
      else
         addx(item, head);   
   }
   private void addx (T item, Node x)
   {
      if (x.next == null)
      {
         Node temp = new Node();
         temp.data = item;
         x.next = temp;
      }
      else 
      {
         addx(item, x.next);
      }
   }
}
