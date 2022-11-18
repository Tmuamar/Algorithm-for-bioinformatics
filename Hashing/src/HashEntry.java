public class HashEntry 
{
   //This allows for when we have three buckets.
   private int bucket1;
   private int bucket2;
   private int bucket3;
   //this is needed for chaining
   private HashEntry next;
   private boolean collided;
   
   HashEntry(int bucket1) 
   {
      this.bucket1 = bucket1;
      this.bucket2 = 0;
      this.bucket3 = 0;
      this.next = null;
      this.collided = false;
   }
   
   //Getters and setters for the different buckets
   public int getBucket1() 
   {
      return bucket1;
   }
   
   public int getBucket2()
   {
      return bucket2; 
   }
   public int getBucket3()
   {
      return bucket3;
   }
   public void setBucket2(int bucket2)
   {
      this.bucket2 = bucket2;
   }
   
   public void setBucket3(int bucket3)
   {
      this.bucket3 = bucket3;
   }
   //whether there was a collision or not
   public void setCollide()
   {
      this.collided = true;
   }
   public boolean hasCollided()
   {
      return this.collided;
   }
   //used for chaining to create the linked list for the collision
   //this is for both of the methods bellow.
   public HashEntry getNext()
   {
      return next;
   }
   //used for chain collision
   public void add (HashEntry newE)
   {
      this.next = newE;
   }
   //Checks if the buckets are full or not
   public boolean fullBucket()
   {
      if((bucket1 != 0) && (bucket2 != 0) && (bucket3 != 0))
      {
         return true;
      }
      return false;
      
   }
  
}   