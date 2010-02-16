import java.util.*;
public class MyHashTable<T>
{
   LinkedList <T> [] table;
   public HashTableSC (int count)
   {
      table = ((LinkedList <T> [] )new LinkedList[count]);
      for (int i =0; i<table.length; i++)
      {
         table[i] = new LinkedList <T>();
      }
   }
   public void insert(T item)
   {
      table[hash(item)].addFirst(item);
   }
   public void delete (T item)
   {
      table[hash(item)].remove(item);
   }
   public boolean find(T item)
   {
      return table[hash(item)].contains(item);
   }
   public boolean isEmpty ()
   {
      for (int i =0; i<table.length; i++)
      {
         if(table[i].size() != 0)
            return false;
      }
      return true;
   }
   public void print()
   {
      for (int i =0; i<table.length; i++)
      {
         System.out.print(i+": "); 
         for (int j =0; j<table[i].size(); j++)
         {
            System.out.print(table[i].get(j) + " ");
         }
         System.out.println();
      }
   }
   private int hash(T item)
   {
      return item.hashCode()%table.length;
   }
   public void makeEmpty()
   {
      for (int i =0; i<table.length; i++)
      {
         table[i].clear();
      }
   }
   public int size()
   {
      int ret=0;
      for (int i =0; i<table.length; i++)
      {         
         ret+= table[i].size();
      }
   }
}
