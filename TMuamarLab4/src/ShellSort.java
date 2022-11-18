/**
 * https://www.geeksforgeeks.org/shellsort/
 * Started off with the basic code and then implemented knuth sequence 
 * shell sort then for the next shell shorts modified it to
 * allow the other increments.
 * @author Rajat mishra
 *
 */
public class ShellSort 
{
   static void printArray(int arr[])
   {
       int n = arr.length;
       for (int i=0; i<n; ++i)
           System.out.print(arr[i] + " ");
       System.out.println();
   }
   public static int[] Shellsort(int[] array)
   {
      int interval = 1;
      int temp;
      // using knuth's interval sequence
      while (interval <= array.length/3)
      {
         interval = (interval*3)+1;// interval is equal to highest sequence of interval when less then or equal to the length/3
      }
      while (interval > 0)
      {
         //similar to insertion sort
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
     //  int arr[] = {10, 52, 23, 32, 3, 56, 87, 12, 37, 91, 34, 78};
      // System.out.println("Array before sorting");
       // printArray(arr);

     // int[] sort = Shellsort(arr);

       // System.out.println("Array after sorting");
     //  System.out.println("sorted: "+ Arrays.toString(sort));
   //}
//}
