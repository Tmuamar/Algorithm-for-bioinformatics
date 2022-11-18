
public class QuadraticProbing 
{
   private static long executionTime;
   private static int numCollisions;
   /**Collision through using quadratic probing.
    * When collision does occur the method will calculate a new hash function.
   *
   * @param bucket1 this is the item being stored
   * @param address calculation of the hash function
   * @param mod Used in calculating the new address when a collision occurs.
   */
   public static void quadProbing(int bucket1, int address, int mod)
   {
      long startTime = System.nanoTime();
     
      int hashFunc = address;
      //Makes sure that the address is not larger than the hash table
      if(hashFunc >= HashTable.table.length)
      {
         hashFunc = hashFunc - HashTable.tableSlots;
      }
      int comparisons = 0;
     
      boolean collision = false;
     
      //Collision happened
      while (HashTable.table[hashFunc] != null && HashTable.table[hashFunc].getBucket1() != bucket1)
      {
         comparisons++;
         collision = true;
         //Collision counts, takes into account primary or secondary
         if (HashTable.table[hashFunc].hasCollided())
         {
            numCollisions++;
         }else
            numCollisions++;
         //allows for the program to stop or it will end up running
         if(comparisons == mod)
         {
            System.out.println("Unable to store " + bucket1);
            return;
         }
         
         //takes into consideration homework problem
         hashFunc = (hashFunc + comparisons) % mod;
      }
      HashTable.table[hashFunc] = new HashEntry(bucket1);
      
      if(collision)
      {
         HashTable.table[hashFunc].setCollide();
      }
      
      long endTime = System.nanoTime();
      executionTime = endTime - startTime;
   }
   
   /**Collision through using quadratic probing. When collision does 
    * occur the method will calculate a new hash function. Only difference for this
    * method is it takes into consideration a bucket size of 3.
   *
   * @param bucket1 this is the item being stored
   * @param address calculation of the hash function
   * @param mod Used in calculating the new address when a collision occurs.
   */
   public static void quadProbingB3(int bucket1, int address, int mod)
   {
      long startTime = System.nanoTime();
      int hashFunc = address;
      //Makes sure that the address is not larger than the hash table
      if(hashFunc >= HashTable.table.length)
      {
         hashFunc = hashFunc - HashTable.tableSlots;
      }
      int comparisons = 0;
      
      boolean collision = false;
      
      //Collision happened
      while (HashTable.table[hashFunc] != null && HashTable.table[hashFunc].getBucket3() != 0)
      {
         comparisons++;
         collision = true;
         //Collision counts
         if (HashTable.table[hashFunc].hasCollided())
         {
            numCollisions++;
         }else
            numCollisions++;
         //allows for the program to stop or it will end up running
         if(comparisons == mod)
         {
            System.out.println("Table full, unable to store " + bucket1);
            return;
         }
         //Based on homework problem
         hashFunc = (hashFunc + comparisons) % mod;
         }
      if (HashTable.table[hashFunc] == null)
      {
         HashTable.table[hashFunc] = new HashEntry(bucket1);
      }
      else if(HashTable.table[hashFunc].getBucket1() != 0 && HashTable.table[hashFunc].getBucket2() == 0)
      {
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
      executionTime = endTime - startTime;
   }
   public static void quadProbingPrintStats()
   {
      System.out.println("\nNumber of Collisions: " + numCollisions);
      System.out.println("Time: " + executionTime + " ns\n");
  
      numCollisions = 0;
      executionTime = 0;
   }
}
