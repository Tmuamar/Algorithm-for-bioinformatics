
public class Chaining 
{
   private static long executionTime;
   public static int numCollisions;

   /**This is a chaining method. When a collision happens this will go 
    * through the free space array and find a free location where the element can be stored.  
   *
   * @param bucket1 acts as the item that is being stored
   * @param address this is the calculated hash function
   */
   public static void ChainingStrat(int bucket1, int address)
   {
      long startTime = System.nanoTime();
      int hashFunc = address;
      
      if(hashFunc >= HashTable.table.length)
      {
         hashFunc = hashFunc - HashTable.tableSlots;
      }
     
      int tr = 0;
      boolean searching = true;

     
      //Collision happened
      if (HashTable.table[hashFunc] != null && HashTable.table[hashFunc].getBucket1() != bucket1)
      {
     
         //counting the amount of collisions that happen
         if (HashTable.table[hashFunc].hasCollided())
         {
            numCollisions++;
         }else {
            numCollisions++;
         }         
         //allows to traverse through the end of the list before we add
         HashTable.hold = HashTable.table[hashFunc];
         while(HashTable.hold.getNext() != null)
         {
            HashTable.hold = HashTable.hold.getNext();
         }
         
         //searching for the free space in the list.
         while (searching)
         {
            //Creates the new entry after finding a location in the freespace
            if(HashTable.freeSpace[tr] == 0)
            {
               HashTable.table[tr] = new HashEntry(bucket1);
               HashTable.table[tr].setCollide();
               //adds entry as the new node
               HashTable.hold.add(HashTable.table[tr]);
               HashTable.freeSpace[tr] = 0;
               searching = false;
            }
            else
            {
               //keep looping through the free list
               tr++;
               if (tr > HashTable.freeSpace.length)
               {
                  System.out.println("Table is full no more space " + bucket1);
                  return;
               }
            }
         } 
      }
      //no collision
      else{
         HashTable.table[hashFunc] = new HashEntry(bucket1);
         //Location no longer free so take off the free list
         HashTable.freeSpace[hashFunc] = 0;
      }
     
      long endTime = System.nanoTime();
      executionTime = endTime - startTime;
   }
   public static void chainingPrintStats()
   {
      System.out.println("\nNumber of Collisions: " + numCollisions);
      System.out.println("Time: " + executionTime + " ns\n");
      //set to 0 for next chaining calculation
      numCollisions = 0;
      executionTime = 0;
   }
}
