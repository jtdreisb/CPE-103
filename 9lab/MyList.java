public class MyList
{
   private class Node
   {
      int data;
      Node next;
   }
   
   private Node head;
   
   public MyList()
   {
      head = null;
   }
   
   public void add(int item)
   {
      Node x = new Node();
      x.data = item;
      x.next = head;
      head = x;
   }
   
   public boolean find(int item)
   {
      return findx(item, head);
   }
   private boolean findx(int item, Node n)
   {
      if(n == null)
         return false;
      else if( n.data == item)
      {
         return true;
      }
      else
      {
         return findx(item, n.next);
      }
   }
   public void print()
   {
      printx(head);
      System.out.println();
   }
   private void printx(Node x)
   {
      if(x != null)
      {
         printx(x.next);
         System.out.print(x.data+" ");
      }
   }
   public int sum()
   {
      return sumx(head);
   }
   private int sumx(Node x)
   {
      if(x.next == null)
      {
         return x.data;
      }
      return sumx(x.next)+x.data;
   }
   
}
