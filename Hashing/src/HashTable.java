public class HashTable 
{
   final static int tableSlots = 120;
   static HashEntry[] table = new HashEntry[tableSlots];
   static HashEntry hold;
   //Keeping track of the free space for chaining
   static int[] freeSpace = new int[tableSlots];
   //to calculate the number of collisions later
   public HashTable() 
   {
      //initializing the hash table.
      for (int i = 0; i < table.length; i++) 
      {
         table[i] = null;
      }
      //for freespace it will give 0 for empty and 1 for full
      for (int i = 1; i < table.length; i++)
      {
         freeSpace[i] = 1;
      }
      hold = null;
  
   }
  
  
   /**Allows for printing the table for bucket size of 3 and bucket size of 1.
    *
    * @param printR if equal to 4 it will print the items in a row of 5. while anything
    * else will print the 1 row will have a bucket size of 3.
    * 
    */
   public static void printTable(int printR)
   {
      int counter = 0;
  
      if(printR == 4)
      {
         for (int i = 0; i<table.length; i++)
         {
            if(counter < printR)
            {
               if (table[i] == null)
               {
                  System.out.print("Null ");

               }
               else{
                  System.out.print(table[i].getBucket1() + " ");
               }
               counter++;
            }
            else {
               int j = i + 1;
               if (table[i] == null)
               {
                  System.out.println("Null  \t Current Total Buckets: " + j + "");
               }
               else
               {
                  System.out.println(table[i].getBucket1() + "  \t Current Total Buckets: " + j + "");
               }
               counter = 0;
            }
         }
      }
      else{
         for (int i = 0; i<table.length; i++)
         {
            int j = i + 1;
            if(table[i] == null)
            {
               System.out.println("Null Null Null" + "  Bucket Number:" + j + "" );
            }
            else{
               System.out.println(table[i].getBucket1() + " " +
                     table[i].getBucket2() + " " +
                     table[i].getBucket3() + "\tBucket Number: " + j);
            }
         }
      }
      //Reset the table to null, in preparation for the next run.
      for (int i = 0; i < table.length; i++) 
      {
         table[i] = null;
      }
   }
}