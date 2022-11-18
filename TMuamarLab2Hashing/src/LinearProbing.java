public class LinearProbing 
{
   public static long executionTime;
   public static int numCollisions;
   public static int numCollisions2;
   /**
    *This method allows to handle collisions through linear probing.
    *Basically taking the hashFunc starting point and then go through the list and
    *then checks for it returned from its starting point.
    * @param bucket1 this is the item being stored
    * @param address Hash function that got calculated
    *
    */
   
   public static void linearProbing1(int bucket1, int address)
   {
      
      long startTime = System.nanoTime();
      int hashFunc = address;
      //this allows for checking if the hash function goes over the tables length
      if(hashFunc >= HashTable.table.length)
      {
         hashFunc = hashFunc - Hashing.tableSlots;
      }
      //starting point
      int func = hashFunc;
      boolean collision = false;
      //check if the collision has occured
      while (HashTable.table[hashFunc] != null && HashTable.table[hashFunc].getBucket1() != bucket1)
      {
         collision = true;
         //counting the collisions that occur
         if (HashTable.table[hashFunc].hasCollided()){
            numCollisions++;
         }else {
            numCollisions2++;
         }
         //loop for handling the beginning of the hashing table
         if ((hashFunc + 1) >= HashTable.table.length)
         {
            hashFunc = 0;
         }
         else
         {
            hashFunc = hashFunc + 1;
         }
         //Checks if the looping has returned to initial location
         //calculated by the hash function
         if (hashFunc == func)
         {
            System.out.println("unable able to store: " + bucket1);
            return;
         }
      }
      HashTable.table[hashFunc] = new HashEntry(bucket1);
 
      if(collision)
      {
         HashTable.table[hashFunc].setCollide();
      }
      long endTime = System.nanoTime();
      executionTime = endTime-startTime;

   }
   /**Does Linear Probing with a BUCKET size of 3
    * 
    * @param bucket1 stored value
    * @param address Hash function that got calculated
    *
    */
   public static void linearProbingB3(int bucket1, int address)
   {
      long startTime = System.nanoTime();
      int hashFunc = address;
      //In case the function results in over the table size
      if(hashFunc >= HashTable.table.length)
      {
         hashFunc = hashFunc - HashTable.tableSlots;
      }
      // starting point
      int func = hashFunc;
  
      boolean collision = false;
  
      //checks if all three buckets are full and if collision has happened
      while (HashTable.table[hashFunc] != null && HashTable.table[hashFunc].getBucket3() != 0)
      {
         collision = true;
         //Counting the amount of collisions that occured
         if (HashTable.table[hashFunc].hasCollided())
         {
            numCollisions++;
         }else {
            numCollisions2++;
         }
         if ((hashFunc + 1) > HashTable.table.length)
         {
            hashFunc = 0;
         }
         else
         {
            hashFunc = hashFunc + 1;
         }

         if (hashFunc == func)
         {
            System.out.println("unable able to store: " + bucket1);
         }
      }
  
      //Fills the keys one by one until all three are full
      if (HashTable.table[hashFunc] == null)
      {
         HashTable.table[hashFunc] = new HashEntry(bucket1);
      }
      else if(HashTable.table[hashFunc].getBucket1() != 0 && HashTable.table[hashFunc].getBucket2() == 0){
         HashTable.table[hashFunc].setBucket2(bucket1);
      }
      else
      {
         HashTable.table[hashFunc].setBucket3(bucket1);
      }

      if(collision)
      {
         HashTable.table[hashFunc].setCollide();
      }
  
      long endTime = System.nanoTime();
      executionTime = endTime-startTime;
   }
   public static void LinearProbingPrintStats()
   {
      int collisions = numCollisions + numCollisions2;
      System.out.println("\nNumber of Collisions: " + collisions);
      System.out.println("Time: " + executionTime + " ns\n");
  
      numCollisions = 0;
      numCollisions2 = 0;
      collisions = 0;
      executionTime = 0;
   }
   
}
