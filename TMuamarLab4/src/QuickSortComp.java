/**
 * Allows for Quick Sort to display the time required 
 * for each different k values.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class QuickSortComp 
{
   String file = "";
   int cA[];
   double startTime;
   double endTime;
   static InputFiles c = new InputFiles();
   static QuickSort b = new QuickSort();
   File newFile = new File("QuickSortsOutPut.txt");
   static double timecomplexity;

   public void QuickSortComp() 
   {
      for(int x = 0; x < InputFiles.valueOfFile.length; x=x+1)
      {
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[x]+".dat";
            cA = new int[InputFiles.valueOfFile[x]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            QuickSort.quickSort(cA,0, cA.length-1, 0, 1);
            endTime = System.nanoTime();
            double timecomplexity = endTime - startTime;
            System.out.println("\nWhen sorting " +file+ " Using Quick Sort: ");
            InputFiles.printArray(cA, InputFiles.valueOfFile[x]);
            System.out.println("The time taken to sort " + InputFiles.valueOfFile[x] + " inputs is: " + timecomplexity+"nano seconds");
         }
      }
   }
   public void QuickSortCompFor50() throws FileNotFoundException 
   {
      PrintStream pa = new PrintStream("QuickSortK50.txt");
      for(int y = 0; y<InputFiles.names.length; y++) 
      {
         file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
         cA = new int[InputFiles.valueOfFile[0]];
         cA = InputFiles.changeToArray(file, cA);
         startTime = System.nanoTime();
         QuickSort.quickSort(cA,0, cA.length-1, 50, 1);
         endTime = System.nanoTime();
         timecomplexity = endTime - startTime;
         pa.println("\nWhen sorting " +file+ " Using Quick Sort with stopping case 50: ");
         pa.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
         pa.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
      }
   }
   public void QuickSortCompFor100() throws FileNotFoundException 
   {
      PrintStream pp = new PrintStream("QuickSortK100.txt");
      for(int y = 0; y<InputFiles.names.length; y++) 
      {
         file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
         cA = new int[InputFiles.valueOfFile[0]];
         cA = InputFiles.changeToArray(file, cA);
         startTime = System.nanoTime();
         QuickSort.quickSort(cA,0, cA.length-1, 100, 1);
         endTime = System.nanoTime();
         timecomplexity = endTime - startTime;
         pp.println("\nWhen sorting " +file+ " Using Quick Sort with stopping case 100: ");
         pp.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
         pp.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
      }
   }
   public void QuickSortCompFor2() throws FileNotFoundException 
   {
      PrintStream cp = new PrintStream("QuickSortK2.txt");
      for(int y = 0; y<InputFiles.names.length; y++) 
      {
         file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
         cA = new int[InputFiles.valueOfFile[0]];
         cA = InputFiles.changeToArray(file, cA);
         startTime = System.nanoTime();
         QuickSort.quickSort(cA,0, cA.length-1, 2, 1);
         endTime = System.nanoTime();
         timecomplexity = endTime - startTime;
         cp.println("\nWhen sorting " +file+ " Using Quick Sort with stopping case 2: ");
         cp.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
         cp.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
      }
      
   }
}
