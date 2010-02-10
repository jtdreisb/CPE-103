import java.util.*;
public class BSTDriver
{
   public static void main(String[] args)
   {
      BST<Integer> q = new BST<Integer>();
      Iterator it;
      boolean repeat = true;
      String input;
      char decision;
      int temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- delete (enter letter d)");
      System.out.println("- find (enter letter f)");
      System.out.println("- check if empty (enter letter e)");
      System.out.println("- make empty (enter letter k)");
      System.out.println("- nodes (enter letter n)");
      System.out.println("- minimum (enter letter m)");
      System.out.println("- maximum (enter letter x)");
      System.out.println("- print preorder (enter letter p)");
      System.out.println("- print inorder (enter letter i)");
      System.out.println("- print levelorder (enter letter l)");
      System.out.println("- test print (enter letter t)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter your choice: (a, d, f, e, k, n, m, x, p, i, l, t or q)");
      
      
      while( repeat )
      {
         input = scan.nextLine();
         if(input.length() > 0 )         
            decision  = input.charAt(0);
         else decision = 'z';
         
         
         switch( decision ) 
         {

            case 'a':
            case 'A':
               System.out.println("Enter an integer to add");
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.insert(temp);
                  System.out.println(temp+" added");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'd':
            case 'D':
               System.out.println("Enter an integer to delete");
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.delete(temp);
                  System.out.println(temp+": deleted");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'f':
            case 'F':
               System.out.println("Enter an integer to find");
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  System.out.println(temp+" found: "+ q.find(temp));
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'e':
            case 'E':
               System.out.println("empty: "+ q.isEmpty());
               break;
            case 'k':
            case 'K':
               q.makeEmpty();
               System.out.println("Tree is Empty");
               break;
            case 'n':
            case 'N':
               System.out.println("nodes: "+ q.size());
               break;
            case 'm':
            case 'M':
               try
               {
                  System.out.println("minimum: "+ q.findMinimum());
               }
               catch (BST.MyException e)
               {
                  System.out.println("Invalid Operation - The BST is empty");
               }
               break;
            case 'x':
            case 'X':
               try
               {
                  System.out.println("maximum: "+ q.findMaximum());
               }
               catch (BST.MyException e)
               {
                  System.out.println("Invalid Operation - The BST is empty");
               }
               break;
            case 'p':
            case 'P':
               it = q.iteratorPre();
               System.out.print("Preorder: ");
               while(it.hasNext())
                  System.out.print(it.next()+" ");
               System.out.println();
               break;
            case 'i':
            case 'I':
               it = q.iteratorIn();
               System.out.print("Inorder: ");
               while(it.hasNext())
                  System.out.print(it.next()+" ");
               System.out.println();
               break;
            case 'l':
            case 'L':
               it = q.iteratorLevel();
               System.out.print("Levelorder: ");
               while(it.hasNext())
                  System.out.print(it.next()+" ");
               System.out.println();
               break;
            case 't':
            case 'T':
               q.testPrint();
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
