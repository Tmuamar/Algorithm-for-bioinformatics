import java.util.Arrays;
 /**
  * Starting quick sort and insertion sort code was used 
  * from the geeks for geeks website of 
  * https://www.geeksforgeeks.org/advanced-quick-sort-hybrid-algorithm/
  * 
  * @author mahi_07
  *
  */
class QuickSort 
{
   
   private static void Partition(int[]arr, int low, int high, int pivot) 
   {
      if (pivot == 1) 
      {
         int mid = (high + low) / 2;
         int change = 0;
         if ((arr[low] <= arr[high] & arr[low] >= arr[mid]))
         {
          return;
         }
         if ((arr[high] <= arr[low] & arr[high] >= arr[mid]))
         {
            change = arr[low];
            arr[low] = arr[high];
            arr[high] = change;
            return;
         }
         change = arr[low];
         arr[low] = arr[mid];
         arr[mid] = change;
         return;
      }
   }
   static void quickSort(int[]arr, int start, int end, int kValue, int pivot) 
   {
      int low;
      int high;
      int num = end + 1 - start;
      int parition;
      int mid;
      int[] newArr = new int[1000];
      int i = -1;
      if (num == 1) 
      { 
         return;
      }
      newArr[++i] = start;
      newArr[++i] = end; 
      
      while (i > 0) 
      { 
         end = newArr[i--];
         start = newArr[i--]; 
         low = start;
         high = end;
         Partition(arr, start, end, pivot);
         parition = arr[low];
         while(low<high)
         {
            while (high > low & arr[high] >= parition) 
            {
               high--;
            }
            
            if (high > low) 
            {
               if (arr[high] < parition) arr[low] = arr[high];  
               
            } else 
            {
               break;
            }
            while (high > low & parition >= arr[low]) 
            {
               low++;
            }
            if (low < high) 
            {
               if (parition < arr[low]) arr[high] = arr[low];  
            } else 
            {
            break;
            }
         }
         
         arr[low] = parition;
         mid = low - start;
         if (mid > kValue) 
         {
            newArr[++i] = start;
            newArr[++i] = low - 1;
         } else 
         {
            if (mid > 1) 
            {
               insertionSort(arr,start, low - 1);
            }
         }
         
         mid = end - low;
         if (mid > kValue) 
         {
            newArr[++i] = low + 1;
            newArr[++i] = end;   
         } else 
         {
            if (mid > 1) 
            {
               insertionSort(arr, low + 1, end);
            }
         }
      }
   }

   private static void insertionSort(int[]arr, int low, int high) 
   {
      if (low == high) 
      {
         return;
      }
      int j = 0;
      int temp = 0;
      for (int i = low + 1; i <= high; i++) 
      {
         j = i;
         while(j > low & arr[j] < arr[j - 1]) 
         {
            temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
            if (j <= low) 
            {
               break;
            }
         }
      }
   }
}
//test to see if quick sort class was working
   //public static void main(String[] args)
   //{
      //int[] arr = { 10, 7, 8, 9, 1, 5, 11,13,12 };
      //quickSort(arr,0, arr.length-1, 50, 2);
      //System.out.println("Sorted array: "+ Arrays.toString(arr));
   //}
//}