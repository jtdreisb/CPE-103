import java.util.Scanner;
public class MyListDriver
{
   public static void main(String[] args)
   {
      MyList q = new MyList();
      
      boolean repeat = true;
      String input;
      char decision;
      int temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- find (enter letter f)");
      System.out.println("- sum (enter letter s)");
      System.out.println("- print array (enter letter p)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      
      
      
      while( repeat )
      {
         System.out.println("Enter your choice: (a, f, s, p, or q)");
         input = scan.nextLine();
         decision  = input.charAt(0);
         
         
         switch( decision ) 
         {

            case 'a':
            case 'A':
               System.out.println("Enter an integer to add");
               if(scan.hasNextInt())
               {
                  temp = scan.nextInt();
                  scan.nextLine();
                  q.add(temp);
                  System.out.println(temp+" added");
                  System.out.println();
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
                  //q.add(temp);
                  System.out.println("found? "+ q.find(temp));
                  System.out.println();
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 's':
            case 'S':
                  System.out.println("The sum is " + q.sum());
                  System.out.println();
                  break;
            case 'p':
            case 'P':
                  q.print();
                  System.out.println();
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
      q.print();
      System.out.println();
   }
}
