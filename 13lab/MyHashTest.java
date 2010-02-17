import java.util.*;
public class MyHashTest
{
   public static void main(String[] args)
   {

      boolean repeat = true;
      String input;
      char decision;
      int size, temp;
      Scanner scan = new Scanner(System.in);
      
      System.out.println("Please enter size of table");
      do
         if(scan.hasNextInt())
         {
            size=scan.nextInt();
            scan.nextLine();
            break;
         }
         else
         {
            System.out.println("Please enter an int");
            scan.nextLine();
         }
         
      while(true); 
      MyHashTable<Integer> q = new MyHashTable<Integer>(size);      
      
      System.out.println("Choose one of the following operations:");    
      System.out.print("a(add/insert), f(fine),d(delete),e(empty?), ");
      System.out.println("k(Empty), s(size), o(output), p(print) or q(quit)");
      
      
      while( repeat )
      {
         
         input = scan.nextLine();
         decision  = input.charAt(0);
         
         
         switch( decision ) 
         {

            case 'a':
            case 'A':
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.insert(new Integer(temp));
                  System.out.println(temp+" added");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'f':
            case 'F':
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  System.out.println(temp + " found: " +q.find(new Integer(temp)));
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.delete(new Integer(temp));
                  System.out.println(temp + " deleted");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
                  break;
            case 'e':
            case 'E':
                  System.out.println("Empty: " +q.isEmpty());
                  break;
            case 'k':
            case 'K':
                  q.makeEmpty();
                  System.out.println("Emptied");
                  break;
            case 's':
            case 'S':
                  System.out.println("Size: " +q.size());
                  break;
            case 'o':
            case 'O':
                  Iterator<Integer> it = q.iterator();
                  while(it.hasNext())
                  {
                     System.out.print(it.next()+" ");
                  }
                  System.out.println();
                  break;
            case 'p':
            case 'P':
                  q.print();
                  break;
            case 'q':
            case 'Q':
                 repeat = false;
                 System.out.println("Quiting...");
                 break;
            default:
                 System.out.println("Invalid Choice"); 
         }  
      }
      System.out.println();
   }
}
