import java.lang.reflect.Array;
import java.util.Arrays;

public class Minimum {
   static class InsertionSort 
   {
      static void sort(int arr[])
      {
         int n = arr.length;
         for (int i = 1; i < n; ++i) 
         {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > value) 
            {
               arr[j + 1] = arr[j];
               j = j - 1;
            }
            arr[j + 1] = value;
         }
      }
}
   static int minimumValue(int arr[], int i, int sub1, int sub2) 
   {
      int diff = 0;
      int first = 0;
      int second = 0;
      while(i  == arr.length) 
      {
         diff = Math.abs(sub1 - sub2);
         return diff;
      }
      while(i < arr.length)
      {
        first = minimumValue(arr, i+1, sub1+arr[i], sub2);
        second = minimumValue(arr, i+1, sub1, sub2+arr[i]);
        return Math.min(first, second);
   }
      return minimumValue(arr, 0, 0, 0);
   }
         
   public static void main(String args[]) 
   {
      int nums[] = { 3,9, 7, 10,2};
      System.out.print("The minimum difference"
                       + " between two sets is "
                       + minimumValue(nums,0,0,0));
   }
}
