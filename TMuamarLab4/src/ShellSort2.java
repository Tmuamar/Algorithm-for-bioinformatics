/**
 * This is using the second set of increments for the shell sort which is
 * 1, 5, 17, 53, 149, 373, 1123, 3371, 10111, 30341.
 * @author thomas
 *
 */
public class ShellSort2 
{
      public static int[] Shellsort2 (int[] array)
      {
         int interval = 1;
         int temp;
         while (interval <= array.length/3)
         {
            interval = (interval*3)+2;
         }
         while (interval > 0)
         {
            for(int i = interval; i <array.length; i++)
            {
               temp=array[i];
               int y;
               for(y=i;y>interval - 1 && array[y-interval]>= temp; y=y-interval)
               {
                  array[y] = array[y-interval];
               }
               array[y]= temp;
            }
            interval = (interval - 1)/3;
         }
         return array;
      }
   }
// test for shell sort
//public static void main(String args[])
//{
   // int arr[] = {10, 52, 23, 32, 3, 56, 87, 12, 37, 91, 34, 78};
 //System.out.println("Array before sorting");
  //printArray(arr);

//int[] sort = Shellsort2(arr);

   //System.out.println("Array after sorting");
  //System.out.println("sorted: "+ Arrays.toString(sort));
//}
//}