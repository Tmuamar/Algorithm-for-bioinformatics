import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class InputFiles 
{
   static int valueOfFile[] = {50, 500, 1000,2000, 5000};
   static String names[] = {"ran", "asc", "rev"};
   static int cA[];
   static String name; 
   static String ShellSortsOutPut;
   
   //creates the files and the names into a .dat file
   public static void InputFiles() 
   {
      for (int i = 0; i <valueOfFile.length; i++)
   {
     cA = new int[valueOfFile[i]];
     cA = random(valueOfFile[i]);
     for(int y = 0; y < names.length; y++) 
     {
        String nameOfFile = names[y] + valueOfFile[i]+ ".dat";
        toFile(nameOfFile, cA, valueOfFile[i], y);
     }
     }
      
   }
   //puts the contents in the 3 files from random to sorted to reverse. 
   public static void toFile(String name, int cA[], int values, int choice) 
   {
      try
      {
         PrintStream ps = new PrintStream(new File(name));
         if (choice == 0)
         {
         }
         else if(choice == 1) 
         {
            Arrays.sort(cA);
         }else if(choice == 2) 
         {
            Arrays.sort(cA);
            cA = reverse(cA, values);
         }
         for (int i = 0; i < values; i++)
         {
            ps.println(cA[i]);
         }
         ps.close();
      }
      
      catch (Exception e)
      {
         System.out.println(e.getMessage());
      }
      
   }
   // makes the values with in the text file reversed
   public static int[] reverse(int cA[], int values) 
   {
      int newcA[] = new int[values];
      for(int i = 0; i<values; i++) 
      {
         newcA[i] = cA[values - i - 1]; 
      }
      return newcA;
      
   }
   //allows to randomize the values with in the text file
   public static int[] random(int values) 
   {
      int cA[] = new int[values];
      for(int x = 0; x<values; x++) {
         cA[x] = (int) (Math.random() * (valueOfFile[valueOfFile.length - 1])-1)+1;
      }
      return cA;
   }
   // changing the values read within the text files that were generated to an array
   public static int[] changeToArray(String names, int cA[]) 
   {
      try 
      {
         Scanner scanner = new Scanner(new File(names));    
         int i = 0;
         while(scanner.hasNext())
         {
            cA[i] = scanner.nextInt();
            i++;
         }
         scanner.close();
   }catch (Exception e)
      {
         System.out.println("error invalid");
      }
      return cA;
   }

   // print array on console only by showing the first 50.
   public static void printArray(int array[], int size)
   {
      int n = 50;
        for (int j = 0; j < n; j++)
        {
            System.out.printf("%5d \t", array[j]);
            if ((j + 1) % 10 == 0) 
            {
               System.out.println();
            }
        }
   }
   public static String printArray2(int array[], int size)
   {
      int n = 50;
        for (int j = 0; j < n; j++)
        {
            if ((j + 1) % 10 == 0) 
            {
               System.out.println();
            }
        }
        return Arrays.toString(array);
   }
   public static void main(String[]args) throws FileNotFoundException 
   {
     shellSortComp d= new shellSortComp();
     QuickSortComp e = new QuickSortComp();
     d.shellSortComp1();
     e.QuickSortComp();
     e.QuickSortCompFor50();
     e.QuickSortCompFor100();
     e.QuickSortCompFor2();
     d.shellSortComp2();
     d.shellSortComp3();
     d.shellSortComp4();
     d.shellSortComp5();
   }
}
