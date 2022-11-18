
public class ShellSort4 
{
   public static int[] Shellsort4(int[] array)
   {
      int interval = 1;
      int temp;
      while (interval <= array.length/3)
      {
         interval = (interval*2)+1;
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
         interval = (interval - 1)/2;
      }
      return array;
   }
}
   //public static void main(String args[])
   //{
       //int arr[] = {10, 52, 23, 32, 3, 56, 87, 12, 37, 91, 34, 78};
    //System.out.println("Array before sorting");
     // printArray(arr);

   //int[] sort = Shellsort4(arr);

      //System.out.println("Array after sorting");
     //System.out.println("sorted: "+ Arrays.toString(sort));
   //}
//}
