package priorityQueue;

public class Heapprio 
{
   static int []A = new int[50];
   static int key;
   static int HeapMaximum(int []A)
   {
      return A[1];
   }
   static int insertKey(int[]A, int n)
   {
      A[n+1] = n;
      return IncreaseKey(A, n+1, n);
   }
   
   static int IncreaseKey(int[]A, int i, int n)
   {
      if (n<= A[i]) 
      {
      }else {
       return A[i] = n;
      }
      while(i>i) {
         A[i] = A[parent(A, i)];
         i = parent(A, i);
      }
      return A[i] = n;
   }
    static int HeapExtract(int[]A) 
    {
       if(A.length < 1) {
          System.out.println("error");
       }
       int max = A[1];
       A[1] = A[A.length-1];
       int x = A.length-1;
       MaxHeapify(A,1);
       return max;
    }
    static int parent(int[]A, int i) 
    {
       if(i > 1 && i < A.length) {
          return i/2;
       }
       return -1;
    }
    
    static int MaxHeapify(int[]A, int i)
    {
       int size = A.length;
       int largest = i;
       int l = 2*i+1;
       int r = 2*i+2;
       if(l <= A.length && A[l] > A[largest])
       {
          largest = l;
       }else
          largest = i;
       if(r<= A.length && A[r]> A[largest])
       {
          largest = r;
       }
       if (largest != i)
       {
          A[i] = A[largest];
       }
       return MaxHeapify(A, largest);
       
    }
    }