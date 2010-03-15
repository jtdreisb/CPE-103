import java.util.Scanner;
public class AQueueClient
{
   public static void main(String[] args)
   {
      AQueue<Float> q = new AQueue<Float>(5);
      Scanner scan = new Scanner(System.in);
      while(scan.hasNext())
      {
         if(scan.hasNextFloat())
         {
            q.enqueue(scan.nextFloat());
         }
         else
         {
            scan.next();
         }
      }
      while (!q.empty())
      {

         System.out.print(q.dequeue()+" ");
      }
      System.out.println();
   }
}
