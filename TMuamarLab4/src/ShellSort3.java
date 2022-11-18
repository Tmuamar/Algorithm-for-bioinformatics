/**
 * Uses the next increment of 1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160.
 */
import java.util.Arrays;

public class ShellSort3 
{
   static int increament3[] = {1, 10, 30, 60, 120, 360, 1080, 3240, 9720, 29160};
   public static int[] Shellsort3(int[] array)
   {
      int element = 0;
      int elementOfLargeNum = 0;
      int num = 0;
      int interval = 0;
      // Find the first value larger than the file
      for (element = 0; element <= increament3.length; element++) 
      {
         num = increament3[element];
         // Break when first gap value greater than file/array length is found
         if (num > (array.length)) 
         {
            break;
         }
      }
      elementOfLargeNum = element;
      // Move back two increments to find the starting increment
      int start = elementOfLargeNum - 2;
      // Starting gap value found
      interval = increament3[start]; 
      
      while (interval > 0)
      {
         for(int i = interval; i <array.length; i++)
         {
            int temp=array[i];
            int y;
            for(y=i;y>interval - 1 && array[y-interval]>= temp; y=y-interval)
            {
               array[y] = array[y-interval];
            }
            array[y]= temp;
         }
         interval = interval - 1;
      }
      return array;
   }
}
   
   //public static void main(String args[])
   //{
       //int arr[] = {10, 52, 23, 32, 3, 56, 87, 12, 37, 91, 34, 78};
    //System.out.println("Array before sorting");
      //printArray(arr);

   //int[] sort = Shellsort3(arr);

      //System.out.println("Array after sorting");
     //System.out.println("sorted: "+ Arrays.toString(sort));
   //}
   //}