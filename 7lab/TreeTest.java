import java.util.Scanner;
public class TreeTest
{
   public static void main(String[] args)
   {
      Integer[] arr = new Integer[20];
      
      Scanner scan = new Scanner(System.in);
      int count = 0;
      while( count < 20  && scan.hasNext())
      {
         arr[count] = new Integer(scan.nextInt());
         count++;
      }
      if(count == 0) 
      {
         System.out.println("Tree is empty");
         return;
      }
      System.out.println("isHeap? " + TreeWork.isHeap(arr, count));
      System.out.println();
      TreeWork.printTree(arr, count);
   }
}
