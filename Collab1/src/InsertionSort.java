import java.util.Arrays;

class InsertionSort 
{
   void sort(int arr[])
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
    public static void main(String args[]) {
       int sum = 0;
       int sum2 = 0;
       int arr[] = {2, 4, 6, 5, 9 ,8};
       InsertionSort sorted = new InsertionSort();
       sorted.sort(arr);
       int n = arr.length;
       int[] a = new int[(n+1)/2];
       int [] b = new int[n- a.length];
       for(int i = 0; i<n; i++)
       {
          if(i< a.length) {
             a[i] = arr[i];
          }
          else {
             b[i-a.length] = arr[i];
          }
          System.out.println(Arrays.toString(a));
          System.out.println(Arrays.toString(b));
       }
       for(int i = 0; i<a.length; i++) {
          sum = sum + a[i];
       }
       for(int i = 0; i<b.length; i++) {
          sum2 = sum2 + b[i];
       }
       System.out.println("Total: "+sum);
       System.out.println("Total2: "+sum2);
       int difference = sum2 - sum;
       System.out.println("Difference of the two subsets: "+difference);
    }
}