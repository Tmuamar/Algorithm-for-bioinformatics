import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadFile 
{
   public static void main(String[] args) throws FileNotFoundException, IOException
   {
      // two sets of arguments for when you launch the program which is input then the output name.
      if(args.length != 2)
      {
         System.err.println("enter file name with two arguments: {input} {output}");
      }
      String inputName = args[0];
      String outputName = args[1];
      Scanner input;
      
      int order = 0;
      int[][] A;
      int[][] B;
      
      try(BufferedReader br = new BufferedReader(new FileReader(inputName)))
      {
         String line = null;
         int count = 0;
         while (true) 
         {
            line = br.readLine();
            if(line == null) {
               break;
            }else if(line.trim().length() == 0) {
               continue;
            }
            try {
               order = Integer.parseInt(line);
               count++;
              
            }catch (Exception e2) { 
               System.out.println("Error Check inputfile for order");
               System.err.println(e2);
               e2.printStackTrace();
            } 

            // Initialize both matrices with correct order
            A = new int[order][order];
            B = new int[order][order];
            for (int row = 0; row < order; row++) {

               line = br.readLine();
               input = new Scanner(line);

               try { 
                  for (int col = 0; col < order; col++) {
                     A[row][col] = Integer.parseInt(input.next());
                  }
               }
              
               catch (Exception e) { 
                  System.out.println("ERROR: check Input file");
                  System.err.println(e);
                  e.printStackTrace();
               } 

            }
            for (int row = 0; row < order; row++) {

               line = br.readLine();
               input = new Scanner(line);

               try { 

                  for (int col = 0; col < order; col++) {
                     B[row][col] = Integer.parseInt(input.next());
                  }
               }
               catch (Exception e) {
                  System.out.println("Error Check input file ");
                  System.err.println(e);
                  e.printStackTrace();
               } 

            }
            try (PrintWriter printOut = new PrintWriter(new FileWriter(outputName, true))) 
            {
               //generates the output to the text file of both the matrices and product
               int[][] product = StrassenMultiplication.StrassenMultiplication1(A, B);
               int[][] product2 = OrdinaryMulti.OrdinaryMulti(A, B);
                     
               printOut.println("Strassen Matrix Multiplication #" + count +":");
               printOut.println("Order Of Matrix = " + order);

               printOut.println("\nMatrix A:");
               printOut.println("--------------------------------------------------------------------");
               for (int row = 0; row < order; row++) {
                  for (int col = 0; col < order; col++) {
                     printOut.print(A[row][col]);
                     printOut.print("   ");
                  }
                  printOut.println();
               }

               printOut.println("\nMatrix B:");
               printOut.println("--------------------------------------------------------------------");
               for (int row = 0; row < order; row++) {
                  for (int col = 0; col < order; col++) {
                     printOut.print(B[row][col]);
                     printOut.print("   ");
                  }
                  printOut.println();
               }
               //generates the product the is formed from strassen
               printOut.println("\nProduct of A and B Strassen:");
               printOut.println("--------------------------------------------------------------------");
               for (int row = 0; row < order; row++) {
                  
                  for (int col = 0; col < order; col++) {
                     printOut.print(product[row][col]);
                     printOut.print("   ");
                  }
                  printOut.println();

               }
               printOut.println("Total Number of Multiplications: " +StrassenMultiplication.strassenCount1);
               
               
               // calculating time it takes strassen method to multiply a matrix.
               long startTime_strassenMultiplication = System.nanoTime();
               StrassenMultiplication.StrassenMultiplication1(A, B);
               long endTime_strassenMultiplication = System.nanoTime();
               long strassen_Multiplication = endTime_strassenMultiplication - startTime_strassenMultiplication;
              
               printOut.println("Total time taken by the Strassen multiplication = " + strassen_Multiplication + " nanoseconds");
                  printOut.println();
               printOut.println("\n\n");
               
               printOut.println("\nProduct of A and B Ordinary:");
               printOut.println("--------------------------------------------------------------------");
               // generates product formed from ordinary multiplication
               for (int row = 0; row < order; row++) {
                  
                  for (int col = 0; col < order; col++) {
                     printOut.print(product2[row][col]);
                     printOut.print("   ");
                  }
                  printOut.println();

               }
               //calulcating the time it takes ordinary multiplication of matrixes to occur and the number of multiplications it takes
               printOut.println("Total number of multiplications: "+ OrdinaryMulti.numberOfMultiplications);
               long startTime_ordinaryMultiplication = System.nanoTime();
               OrdinaryMulti.OrdinaryMulti(A, B);
               long endTime_ordinaryMultiplication = System.nanoTime();
               long ordinary_Multiplication = endTime_ordinaryMultiplication - startTime_ordinaryMultiplication;
              
               printOut.println("Total time taken by the Ordinary multiplication = " + ordinary_Multiplication + " nanoseconds");
                  printOut.println();
               printOut.println("\n\n");
            } 
               
            }
         }
      }
}


