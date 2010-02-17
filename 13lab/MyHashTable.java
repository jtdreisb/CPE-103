import java.util.*;
public class MyHashTable<T>
{
   LinkedList <T> [] table;
   public MyHashTable (int count)
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
      return ret;
   }
   private class Iter implements Iterator<T> 
   {
      public int i, j;
      
      public Iter (LinkedList <T> [] table)
      {
         for (int i =0; i<table.length; i++)
         {
            if(table[i].size() != 0)
            break;
         }
         j=0;
      }
      
      public boolean hasNext()
      {
         if(table[i].size() > j+1)
            return true;
            
         for ( int l = i+1 ; l<table.length; l++)
         {
            if(table[l].size() != 0)
               return true;
         }
         return false;
      }
      
      public T next()
      {
         if(table[i].size() > j+1)
         {
            j++;
            return table[i].get(j);
         }
         j = 0;
         for ( i = i+1 ; i<table.length; i++)
         {
            if(table[i].size() != 0)
            {
               return table[i].get(j);
            }
         }
         throw new  NoSuchElementException();
      }
      public void remove()
      {
         throw new UnsupportedOperationException();
      }     
   }
   
   public Iterator<T> iterator()
   {
      return new Iter(table);
   }
}
