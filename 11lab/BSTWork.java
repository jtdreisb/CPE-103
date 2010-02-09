import java.util.Scanner;
public class BSTWork
{
   public static void main(String[] args)
   {
      BasicBST q = new BasicBST();
      
      boolean repeat = true;
      String input;
      char decision;
      int temp;
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- add (enter letter a)");
      System.out.println("- odds (enter letter o)");
      System.out.println("- height (enter letter h)");
      System.out.println("- leaves(enter letter l)");
      System.out.println("- one child (enter letter c)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter your choice: (a, o, h, l, c or q)");
      
      
      while( repeat )
      {
         
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
                  q.insert(temp);
                  System.out.println(temp+" added");
               }
               else
               {
                  System.out.println("Please enter an int");
                  scan.nextLine();
               }
               break;
            case 'o':
            case 'O':
               System.out.println("odds: "+ q.countOdds());
               break;
            case 'h':
            case 'H':
               System.out.println("height: " +q.height());
               break;
            case 'l':
            case 'L':
                  System.out.println("Leaves: "+ q.countLeaves());
                  break;
            case 'c':
            case 'C':
                  System.out.println("OneChild: "+ q.countOneChildParents());
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
