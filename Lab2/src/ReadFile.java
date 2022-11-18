/* This main method allows for the user to input text file name of the required input and then it will make a new with a output text 
 * that prints the determinant and matrix out*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFile 
{
   private static Scanner input;
   private static PrintStream ps;
   static Determinant d = new Determinant();
   
   public static void main(String[] args) throws FileNotFoundException 
   {
      try 
      {
         ps = new PrintStream("Output.txt"); 
         FileInputStream inputStream = new FileInputStream("Lab2RequiredInput.txt");
         input = new Scanner(inputStream);
         input.useDelimiter("[[\\s]&&[^\\n]]+"); // whitespace, except newline
         while (true)
         {
            int order = 0;
            if(input.hasNextInt()) {
            // This should be here to get size of array before getting each array
               order = input.nextInt();
            }else {
               break;
            }
            int[][] mat = new int[order][order];
            //print the input matrix
            int j = 0;
            ps.println("\nThe matrix is : ");
            ps.println("order: "+order);
            input.nextLine();
            for (int i = 0; i < order; i++) 
            {
               for (j = 0; j < order; j++) 
               {
                  if(input.hasNextInt()) {
                  mat[i][j] = input.nextInt();
                  ps.printf("%3d", mat[i][j]);
               }else {
                throw new NoSuchElementException("error");
               }
               }
               if(input.hasNextInt()) {
               }
               if(input.hasNextLine())
                  input.nextLine();
               ps.println(); 
            }
            ps.println("determinant = "+d.determinant(mat, order));
         }
      } 
      catch (NoSuchElementException e)
      {
         ps.println("\nCannot calculate determinant. Matrix is not a square matrix.");
         
      }
   }
}