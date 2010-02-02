/**
* Converter test Class that tests the static methods 
* of the infix to postfix converter and evaluator
*  
* @version cpe 103 section 4
*
* @author Mathew Duhon and Jason Dreisbach
* @version Program 1
*/
import java.util.Scanner;
public class ConTest
{
   /**
   * @description Takes a choice from a printed menu does the appropriate method based upon entry
   *
   */
   public static void main(String[] args)
   {
      
      boolean repeat = true;
      String input;
      char decision = 'h';
      
      System.out.println("Choose one of the following operations:");
      System.out.println("- infix to postfix conversion (enter letter i)");
      System.out.println("- Postfix expression evaluation (enter letter p)");
      System.out.println("- Arithmetic expression evaluation (enter letter a)");
      System.out.println("- quit (enter letter q)");
      Scanner scan = new Scanner(System.in);
      

      while( repeat )
      {
         System.out.println("Enter your choice: (i, p, a, or q)");
         input = scan.nextLine();
         if(!input.isEmpty())
         {
            decision  = input.charAt(0);
         }
         switch( decision ) 
         {
            case 'i':
            case 'I':
               System.out.println("Enter an infix expression");
               System.out.println("The postfix expression is: " + Converter.infixToPostfix(scan.nextLine()));
               break;
            case 'p':
            case 'P':
               System.out.println("Enter an postfix to evaluate");
               System.out.println("The value of the expression is: " + Converter.postfixValue(scan.nextLine()));
               break;
            case 'a':
            case 'A':
                  System.out.println("Enter an infix to evaluate");
                  System.out.println("The value of the Arithmetic expression is: " + Converter.postfixValue(Converter.infixToPostfix(scan.nextLine())));
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
   }
   
/*   
      System.out.println(Converter.infixToPostfix("a  / ( b + c * d - e )"));
      System.out.println(Converter.infixToPostfix("a - b * c + d / e"));
      
      String test1 = "1 2 3 * + 4 -";
      String test2 = "5 - 3 * 6 + 4 / 2";
      System.out.println(Converter.infixToPostfix(test2));
      String str = Converter.infixToPostfix(test2);
      System.out.println("Test1 3 =? " + Converter.postfixValue(test1));
      System.out.println("Test2 -11 =? " + Converter.postfixValue(str));
   }*/
}
