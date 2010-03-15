import java.util.Scanner;

public class StringChecker
{
   public static boolean isBalanced(String str)
   {
      AStack<Character> stack = new AStack<Character>(5);
      char c;
      for( int i = 0; i < str.length(); i++)
      {
         c = str.charAt(i);
         if(c == '[' || c == '{' || c == '(')
         {
            stack.push(new Character(c));
         }
         else if(c == ']' || c == '}' || c == ')')
         {
            try
            {
               switch (c)
               {
                  case ']':
                     if(stack.pop().charValue() != '[')
                        return false;
                     break;
                  case '}':
                     if(stack.pop().charValue() != '{')
                        return false;
                     break;
                  case ')':
                     if(stack.pop().charValue() !='(')
                        return false;
                     break;
               }
               
            }
            catch(AStack.MyException e)
            {
               return false;
            }
         }
      }
      if(stack.isEmpty())
      {
         return true;
         
      }else{
         return false;
         }
   
   }
   public static void main(String[] args)
   {
      Scanner scan = new Scanner(System.in);
      String testStr;
      while(true)
      {
         if(!scan.hasNext())
            break;
         System.out.print("Enter String to be checked:  ");
         testStr = scan.nextLine();
         if( isBalanced(testStr))
         {
            System.out.println("String is balanced!");
         }
         else 
         {
            System.out.println("String is not balanced...");
         }
         System.out.println();
      }
      //System.out.println();
   }
}
