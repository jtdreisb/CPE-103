public class DiGraphSP
{
   private int [][] arr; 
   public DiGraphSP (int n)
   {
      arr = new int [n][n];
   }
   public void addEdge(int from, int to)
   {
      arr[from][to]=1;
   }
   public void deleteEdge(int from, int to)
   {
      arr[from][to]=0;
   }
   public int edgeCount()
   {
      int sum=0;
      for(int i=0; i<arr.length; i++)
      {
         for(int j=0; j<arr[i].length; j++)
            sum+=arr[i][j];
      }
      return sum;
   }
   public int vertexCount()
   {
      return arr.length;
   }
   public void print()
   {
      for(int i=0; i<arr.length; i++)
      {
         System.out.print(i+" is connected to: ");
         for(int j=0; j<arr[i].length; j++)
         {
            if(arr[i][j]==1)
               System.out.print(j +" ");
         }
         System.out.println();
      }
   }
   private int[] indegrees()
   {
      int [] ret = new int [arr.length];
      for( int i=0; i<arr.length; i++)
      {
         for ( int j=0; j<arr.length; j++)
         {
            ret[j]+=arr[i][j];
         }
      }
      return ret;
   }
   public int[] topSort()
   {
      int [] temp = indegrees();
      int [] ans = new int[vertexCount()]; 
      LQueue <Integer> q = new LQueue <Integer>();
      int count=0;
      int v;
      for (int i=0; i<temp.length; i++)
      {
         if(temp[i]==0)
            q.enqueue(new Integer (i));
      }

      while(!q.empty())
      {
         v=q.dequeue().intValue();
         ans[count++]=v;
         for(int i=0; i<arr[0].length; i++)
         {
            if(arr[v][i] != 0)
            {
               temp[i]--;
               if(temp[i]==0)
                  q.enqueue(new Integer(i));             
            }
         }
      }
      if(count != arr.length)
         throw new LQueue.MyException();
      return ans;      
   }
   private class PathInfo
   {
      public int distance;
      public int lastVertex;
   }
   private PathInfo[] shortestPaths(int s)
   {
      PathInfo[] arrs = new PathInfo[vertexCount()];
      LQueue<Integer> q = new LQueue<Integer>();
      int v;
      for (int i=0; i<arrs.length; i++)
      {
         arrs[i] = new PathInfo();
         arrs[i].distance = -1;
         arrs[i].lastVertex =-1;
      }
      arrs[s].distance=0;
      q.enqueue(new Integer (s));
      while(!q.empty())
      {
         v=q.dequeue().intValue();
         for( int i=0; i< arrs.length; i++)
         {
            if(arr[v][i] == 1)
            {
               if(arrs[i].distance==-1)
               {
                  arrs[i].distance = arrs[v].distance+1;
                  arrs[i].lastVertex =v;
                  q.enqueue(i);
//                  System.out.println("arrs[ " + i +" ] is " + arrs[i].distance);
               }
            }
         }
      }
      return arrs;
   }
   public boolean isTherePath(int from, int to)
   {
      PathInfo[] isPath= shortestPaths(from);
      return isPath[to].distance!= -1;
   }
   public int lengthOfPath(int from, int to)
   {
      PathInfo[] isPath= shortestPaths(from);
      return isPath[to].distance;
   }
   public void printPath(int from, int to)
   {
      PathInfo[] isPath= shortestPaths(from);
      if(!isTherePath(from, to))
         System.out.println("There is no path from " + from + " to " + to);
      else
         printPath( isPath, from, to);
      System.out.println();
   }
   private void printPath(PathInfo[] arrs, int from, int to)
   {
      if(from==to)
         System.out.print(from);
      else
      {
         printPath(arrs, from, arrs[to].lastVertex);
         System.out.print(" to " + to);
      }
   }
}
