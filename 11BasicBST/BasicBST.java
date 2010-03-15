public class BasicBST 
{
   private BSTNode root;
   private class BSTNode
   {
      // data hold the value for the specific node
      int data;
      BSTNode left, right;
   }
   public BasicBST ()
   {
      root = null;
   }
	public void insert(int item)
	{
	   root = insertX(item, root);
	}
	private BSTNode insertX(int item, BSTNode n)
	{
	   if(n == null)
	   {
	      n = new BSTNode();
	      n.data = item;
	   }
	   else
	   {
	      if(item <n.data)
	      {
	         n.left = insertX(item, n.left);
	      }
	      else
	      {
	         n.right = insertX(item, n.right);
	      }
	   }
	   return n;  
	}   
	public int countOdds()
	{
         return countOddsx(root);
	}
	private int countOddsx(BSTNode n)
	{
	   int odds = 0;
	   if ( n != null)
      {
         if (n.data%2 == 1)
	      {
	         odds += 1;
	      }   
	      odds += countOddsx(n.right);
	      odds += countOddsx(n.left);
	  }
	  return odds;
	}
	public int height ()
	{
	   if (root == null)
	      return -1;
      return heightx(root);
	}
	private int heightx (BSTNode n)
	{
	   int hRight = -1, hLeft = -1;
	   if ( n.right !=null)
	   {
	      hRight = heightx(n.right); 
	   }
	   if ( n.left !=null)
	   {
	      hLeft = heightx(n.left); 
	   }
	   if (hRight > hLeft)
	      return hRight +1;
      else 
         return hLeft +1;
	}
	public int countLeaves ()
	{
	   if (root == null)
	      return 0;
      return countLeavesx(root);
	}
	private int countLeavesx (BSTNode n)
	{
	   int lRight = 0, lLeft = 0;
	   if (n.right == null && n.left == null)
	      return 1;
	   if ( n.right !=null)
	   {
	      lRight = countLeavesx(n.right); 
	   }
	   if ( n.left !=null)
	   {
	      lLeft = countLeavesx(n.left); 
	   }
	   return lLeft+lRight;
	}
	public int countOneChildParents ()
	{
		if (root == null)
	      return 0;
      return oneChildx(root);
	}
	private int oneChildx (BSTNode n)
	{
	   int ret = 0;
	   if (n.right == null && n.left != null || n.right != null && n.left == null)
	      ret =  1;
	   if ( n.right !=null)
	   {
	      ret += oneChildx(n.right); 
	   }
	   if ( n.left !=null)
	   {
	      ret += oneChildx(n.left); 
	   }
	   return ret;
	}
}

