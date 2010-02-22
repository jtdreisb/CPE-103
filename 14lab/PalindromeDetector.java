import java.util.*;
public class PalindromeDetector
{
   public static boolean isPalindrome(String word)
   {
         if(word.length()>1)
         {
            if(word.charAt(0) == word.charAt(word.length()-1))
            {
                  return isPalindrome(word.substring(1,word.length()-1));
            }
            else
               return false;
         }
         return true;  
   }
   public static void main(String args[])
   {
      Scanner scan = new Scanner(System.in);
      String word;
      LList<String> list = new LList<String>();
      Iterator it;

      while(scan.hasNext())
      {
         word = scan.next();
         if(isPalindrome(word))
            list.add(word);  
      }
      it = list.iterator();
      if(it.hasNext())
      {
         System.out.print(it.next());
      }
      while(it.hasNext())
      {
         System.out.print(", "+it.next());
      }
      System.out.println();
   }
}
