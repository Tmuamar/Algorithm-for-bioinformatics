/* strassen's alogrithm for multiplication of matrices */
public class StrassenMultiplication 
{
   static int strassenCount1;
   static int[][] StrassenMultiplication1(int[][] A,int [][] B)
   {
   int s = A.length;
   int[][] C = new int [s][s];
   //if there is only one element
   if(s == 1) 
   {
     C[0][0] = A[0][0] * B[0][0]; 
   }
   //if matrix is greater than 1
   else {
      //splitting the matrix into s/2xs/2
      int[][] A11 = new int[s/2][s/2];
      int[][] A12 = new int[s/2][s/2];
      int[][] A21 = new int[s/2][s/2];
      int[][] A22 = new int[s/2][s/2];
      
      int[][] B11 = new int[s/2][s/2];
      int[][] B12 = new int[s/2][s/2];
      int[][] B21 = new int[s/2][s/2];
      int[][] B22 = new int[s/2][s/2];
      
      splittingMatrix(A, A11, 0, 0);
      splittingMatrix(A, A12, 0, s/2);
      splittingMatrix(A, A21, s/2, 0);
      splittingMatrix(A, A22, s/2, s/2);
      
      splittingMatrix(B, B11, 0, 0);
      splittingMatrix(B, B12, 0, s/2);
      splittingMatrix(B, B21, s/2, 0);
      splittingMatrix(B, B22, s/2, s/2);
     
      // step 2 creating the 10 matrices by adding and subtracting
      int[][] S1 = subtraction(B12, B22);
      int[][] S2 = add(A11, A12);
      int[][] S3 = add(A21, A22);
      int[][] S4 = subtraction(B21, B11);
      int[][] S5 = add(A11, A22);
      int[][] S6 = add(B11, B22);
      int[][] S7 = subtraction(A12, A22);
      int[][] S8 = add(B21, B22);
      int[][] S9 = subtraction(A11, A21);
      int[][] S10 = add(B11, B12);
      
      /* step 3 is using step 1 to multiply 10 matrices in step2
         */
     int[][]P1 = StrassenMultiplication1(A11, S1);
     int[][]P2 = StrassenMultiplication1(S2, B22);
     int[][]P3 = StrassenMultiplication1(S3, B11);
     int[][]P4 = StrassenMultiplication1(A22, S4);
     int[][]P5 = StrassenMultiplication1(S5, S6);
     int[][]P6 = StrassenMultiplication1(S7, S8);
     int[][]P7 = StrassenMultiplication1(S9, S10);
     //counts the 7 multiplication steps
     strassenCount1 = strassenCount1 + 7;
     
     int[][] C11 = add(subtraction(add(P5,P4),P2), P6);
     int[][] C12 = add(P1,P2);
     int[][] C21 = add(P3,P4);
     int[][] C22 = subtraction(subtraction(add(P5,P1),P3), P7);
     //combining matrixes
     combine(C11, C, 0, 0);
     combine(C12, C, 0, s/2);
     combine(C21, C, s/2, 0);
     combine(C22, C, s/2, s/2);
     
   }
   return C;
   
   }
   // splitting the matrixes 
   static void splittingMatrix(int[][]Matrix, int[][]sub, int row, int column) 
   {
      for (int row1 = 0, row2 = row; row1 < sub.length; row1++, row2++)
      {
         
         for (int col1 = 0, col2 = column; col1 < sub.length; col1++, col2++)
         {

             sub[row1][col1] = Matrix[row2][col2];
         }
         
      }
   }
   // method to combine the matrixes for the multiplication in strassen
   static void combine(int[][]Matrix, int[][]sub, int row, int column) 
   {
      for (int row1 = 0, row2 = row; row1 < Matrix.length; row1++, row2++)
      {
         
         // Inner loop for columns
         for (int col1 = 0, col2 = column; col1 < Matrix.length; col1++, col2++)
         {

             sub[row2][col2] = Matrix[row1][col1];
         }
      }
   }
   
   //Method for subtracting the matrixes
   static int[][] subtraction(int[][]A, int [][]B) {
      
      int sub[][] = new int[A.length][A.length];
      for(int i =0; i< A.length; i++) {
         for(int d = 0; d< A.length; d++) {
            sub[i][d] = A[i][d] - B[i][d];
         } 
      }
      return sub;
   }
   
   //method for adding matrixes together
   static int[][] add(int[][]A, int[][]B)
   {
      int add[][] = new int [A.length][A.length];
      for(int i =0; i< A.length; i++)
      {
         for(int d = 0; d< A.length; d++) 
         {
            add[i][d] = A[i][d] + B[i][d];
         }
      }
      return add;
   }
}
