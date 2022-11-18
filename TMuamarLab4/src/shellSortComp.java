/*
 * allows for shell sort to display time anaylsis and the sorted items for each individual file.
 */
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class shellSortComp 
{
   String file = "";
   int cA[];
   double startTime;
   double endTime;
   static InputFiles c = new InputFiles();
   static ShellSort b = new ShellSort();
   private PrintStream ss3;
   private PrintStream ss4;
   private PrintStream ss2;
   private PrintStream ss1;
   public shellSortComp() {
      
   }
   public void shellSortComp1()
   {
      
      for(int x = 0; x<InputFiles.valueOfFile.length; x++) 
      {
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[x]+".dat";
            cA = new int[InputFiles.valueOfFile[x]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            ShellSort.Shellsort(cA);
            endTime = System.nanoTime();
            //variable for displaying the time it took to sort in nano seconds
            double timecomplexity = endTime - startTime;
            System.out.println("\nWhen sorting " +file+ " Using Shell Sort: ");
            // displays values in array after being sorted
            InputFiles.printArray(cA, InputFiles.valueOfFile[x]);
            System.out.println("The time taken to sort " + InputFiles.valueOfFile[x] + " inputs is: " + timecomplexity+"nano seconds");
         }
         
      }
   }
   public void shellSortComp2() throws FileNotFoundException 
   {
      ss1 = new PrintStream("ShellSortIncrement1.txt");
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
            cA = new int[InputFiles.valueOfFile[0]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            ShellSort.Shellsort(cA);
            endTime = System.nanoTime();
            double timecomplexity = endTime - startTime;
            ss1.println("\nWhen sorting " +file+ " Using Shell Sort1: ");
            ss1.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
            ss1.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
         }
         
      }
   public void shellSortComp3() throws FileNotFoundException 
   {
      ss2 = new PrintStream("ShellSortIncrement2.txt");
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
            cA = new int[InputFiles.valueOfFile[0]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            ShellSort2.Shellsort2(cA);
            endTime = System.nanoTime();
            double timecomplexity = endTime - startTime;
            ss2.println("\nWhen sorting " +file+ " Using Shell Sort2: ");
            ss2.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
            ss2.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
         }
   
      }
   public void shellSortComp4() throws FileNotFoundException 
   {
      ss3 = new PrintStream("ShellSortIncrement3.txt");
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
            cA = new int[InputFiles.valueOfFile[0]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            ShellSort3.Shellsort3(cA);
            endTime = System.nanoTime();
            double timecomplexity = endTime - startTime;
            ss3.println("\nWhen sorting " +file+ " Using Shell Sort3: ");
            ss3.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
            ss3.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
         }
   
      }
   public void shellSortComp5() throws FileNotFoundException 
   {
      ss4 = new PrintStream("ShellSortIncrement4.txt");
         for(int y = 0; y<InputFiles.names.length; y++) 
         {
            file = InputFiles.names[y]+InputFiles.valueOfFile[0]+".dat";
            cA = new int[InputFiles.valueOfFile[0]];
            cA = InputFiles.changeToArray(file, cA);
            startTime = System.nanoTime();
            ShellSort4.Shellsort4(cA);
            endTime = System.nanoTime();
            double timecomplexity = endTime - startTime;
            ss4.println("\nWhen sorting " +file+ " Using Shell Sort4: ");
            ss4.println(InputFiles.printArray2(cA, InputFiles.valueOfFile[0]));
            ss4.println("The time taken to sort " + InputFiles.valueOfFile[0] + " inputs is: " + timecomplexity+"nano seconds");
         }
   
      }
   
}
