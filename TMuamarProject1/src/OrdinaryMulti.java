
public class OrdinaryMulti
{
   static int numberOfMultiplications = 0;
   static int[][] OrdinaryMulti(int[][]A, int[][]B) 
   {
      int size = A.length;
      int [][]C = new int [size][size];
      for (int i = 0; i < size; i++) 
      {
         for (int j = 0; j < size; j++) 
         {
            C[i][j] = 0;
            for(int k = 0; k < size; k++) 
            {
               C[i][j] = C[i][j] + A[i][k] * B[k][j];
               numberOfMultiplications++;
            }
            
         }
         
      }
      return C;
   }
   // test for ordinary matrix
   public static void main(String[]args) 
   {
      int N = 4;
      int[][] A = { { 1, 2, 3, 4 },
                  { 4, 3, 0, 1 },
                  { 5, 6, 1, 1 },
                  { 0, 2, 5, 6 } };


      int[][] B = { { 1, 0, 5, 1 },
                  { 1, 2, 0, 2 },
                  { 0, 3, 2, 3 },
                  { 1, 2, 1, 2 } };

      int [][]C = OrdinaryMulti(A, B);
      
     
    for (int i = 0; i < N; i++) {
        
        for (int j = 0; j < N; j++)

             System.out.print(C[i][j] + " ");
             System.out.println();
   }
   
}
   }
