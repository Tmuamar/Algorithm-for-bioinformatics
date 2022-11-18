/* calculcates the determinant using the recursive approach */
public class Determinant 
{
   int x = 0;
   int y = 0;
   public int determinant(int[][] mat, int n) 
   {
      int det = 0;
      // calculates matrix at length one
      if (mat.length == 1)
      {
         det = mat[0][0];
         return det;
      }
      // calculates matrix at length two
      else if (mat.length == 2) 
      {
         det = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
         return det;
      }
      else {
         //dividing the matrix up to small parts to calculate determinant of larger matrix
         int newMat[][] = new int[mat.length - 1][mat.length - 1];
         for (n = 0; n < mat.length; n++) {
         int a = 0;
         int b = 0;
         for (x = 1; x < mat.length; x++) {
            for (y = 0; y < mat.length; y++) {

               if (y != n){
                  newMat[a][b++] = mat[x][y];
                  if(b%(mat.length-1) == 0) {
                     a++;
                     b=0;
                  }
               }
            }
         }
         det = (int) (det+mat[0][n] * Math.pow(-1, (int) n ) * determinant(newMat, mat.length-1)); // calculating the determinant each time by repeating for each part
      }
      return det; 
      }
   }
}