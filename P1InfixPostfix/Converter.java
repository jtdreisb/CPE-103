/**
* Converter is a Class that provides static methods to convert prefix 
* expressions to postfix 
*  
* @version cpe 103 section 4
*
* @author Mathew Duhon and Jason Dreisbach
* @version Program 1
*/

public class Converter
{
   /**
	 * Converts an infix expression to a Postfix expression
	 * Pre-conditions: a valid infix expression with spaces delimiting operands and operators
	 * Post-conditions: a postfix expression with spaces delimiting operands and operators
	 * @return String postfix 
	 */
   public static String infixToPostfix(String expression)
   {
      MyStack<String> opStack = new MyStack<String>();
      
      String[] strings;
      String c,peekC;
      String output = new String(); 
      strings = expression.split("\\s+");
      
      for(int i = 0; i < strings.length; i++)
      {
        c = strings[i];
        switch(c.charAt(0))
        {
            case '(':
               opStack.push(c);
               break;
            case ')':
               peekC = opStack.peek();
               while ( !peekC.equals("("))
               {
                  output += opStack.pop() + " ";
                  peekC = opStack.peek();
               }
               opStack.pop();
               break;
            case '*':
            case '/':
               opStack.push(c);
               break;
            case '+':
            case '-':
               while(!opStack.isEmpty() && !opStack.peek().equals("(")) {
                  output += opStack.pop() + " ";
               }
               opStack.push(c);
               break;
            default:
               output += c + " ";
               break;
         }
      }
      while( !opStack.isEmpty())
      {
         output += opStack.pop() + " ";
      }
      
      return output;
   }
   /**
	 * Evaluates a postfix expression to a double value
	 * Pre-conditions: a valid postfix expression 
	 * Post-conditions: double value
	 * @return double the evaluation of the postfix 
	 */
   public static double postfixValue(String expression)
   {
      MyStack<String> stack = new MyStack<String>();

      double lhs, rhs;
      
      String[] strings;
      strings = expression.split("\\s+");
      
      for(int i = 0; i < strings.length; i++)
      {
         if(strings[i].equals("*") || strings[i].equals("/") || strings[i].equals("+") || strings[i].equals("-"))
         {
            rhs = Double.valueOf(stack.pop());
            lhs = Double.valueOf(stack.pop());
            switch ( strings[i].charAt(0))
            {
               case '*':
                  stack.push(String.valueOf(lhs * rhs));
                  break;
               case '/':
                  stack.push(String.valueOf(lhs / rhs));
                  break;
               case '+':
                  stack.push(String.valueOf(lhs + rhs));
                  break;
               case '-':
                  stack.push(String.valueOf(lhs - rhs));
                  break;
            }
            
         }
         else 
         {
            stack.push(strings[i]);
         }
      }
      
      return Double.valueOf(stack.pop());
   }
}
