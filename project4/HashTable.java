/*** HashTable with open addressing* With quadratic probing* @version cpe 103 section 4** @author Mathew Duhon and Jason Dreisbach* @version Program 4*/
public class HashTable
{
   private HashEntry[] table;
   private int count;
   
   private class HashEntry
   {
      public Object item;
      public boolean isActive;
      public HashEntry(Object x)
      {
         item = x;
         isActive = true;
      }
   }
   
   
   /**
    * creates a new Hashtable of size s
    * @param: s the size of the hashtable to be created
    * @Pre-conditions: none
    * @Post-conditions: initialize the empty hashtable of size s
    *                   null
    */
   public HashTable(int size)
   {
      count = 0;
      table = new HashEntry[nextPrime(2*size)];
   }
   
   
   private class Iter implements java.util.Iterator
   {
      public HashEntry[] table;
      public int cursor;
      
      public Iter(HashEntry[] table)
      {
         cursor = 0;
         this.table = table;
      }
      public boolean hasNext()
      {
         return cursor < table.length;
      }
      public Object next()
      {
         
         return null;
      }
      public void remove()
      {
         throw new UnsupportedOperationException();
      }
   }
   
   
   private int nextPrime(int x)
   {
     int prime = x;
     boolean found = false;
     while(!found)
     {
        prime++;         
        found = true;
        for(int i = 2; i < prime; i++)
        {
           if(prime % i == 0)
           {
              found = false;
              break;
           }
        }
     }
     return prime;
   }
}
