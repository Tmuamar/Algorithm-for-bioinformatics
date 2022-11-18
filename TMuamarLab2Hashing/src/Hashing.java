import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Hashing 
{
   public static int tableSlots = 120;
   static Scanner s;
   public static void main(String[] args) throws FileNotFoundException 
   {
      if(args.length != 2)
      {
         System.err.println("enter file name with two arguments: {input} {output}");
      }
      String inputName = args[0];
      String outputName = args[1];
      Scanner input;
      
      //Reading the file using a scanner
      int[] totalNum = new int[tableSlots];
      try 
      {
         input = new Scanner(new File(inputName));
         int i = 0;
         while(input.hasNextInt())
         {
            totalNum[i] = input.nextInt();
            i++;
         }
         
      }
      catch (FileNotFoundException ex) 
      {
         System.out.print("ERROR: "+ inputName + " file not found");
      }
      
      PrintStream out = new PrintStream(new FileOutputStream(outputName));
      System.setOut(out);
      //Linear Probing Collision Handling
      //division modulo 120 and bucket size 1
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 120);
         LinearProbing.linearProbing1(totalNum[i], hashFunc);
      }
      System.out.println("Hashing with Linear Probing mod 120: \n");
      HashTable.printTable(4);
      LinearProbing.LinearProbingPrintStats();
      
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 113);
         LinearProbing.linearProbing1(totalNum[i], hashFunc);
      }
      System.out.println("Hashing with Linear Probing mod 113: \n");
      HashTable.printTable(4);
      LinearProbing.LinearProbingPrintStats();
      //Linear Probing Collision Handling
      //division module 41 bucket size 3
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 41);
         LinearProbing.linearProbingB3(totalNum[i], hashFunc);
      }
      System.out.println("Hashing with Linear Probing Bucket size 3: \n");
      HashTable.printTable(3);
      LinearProbing.LinearProbingPrintStats();
      //Quadratic Probing Collision Handling
      //120 division modulo bucket size 1
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 120);
         QuadraticProbing.quadProbing(totalNum[i], hashFunc, 120);
      }
      System.out.println("Hashing with Quadratic Probing mod 120: \n ");
      HashTable.printTable(4);
      QuadraticProbing.quadProbingPrintStats();
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 113);
         QuadraticProbing.quadProbing(totalNum[i], hashFunc, 113);
      }
      System.out.println("Hashing with Quadratic Probing mod 113: \n ");
      HashTable.printTable(4);
      QuadraticProbing.quadProbingPrintStats();
      //Quadratic Probing Collision Handling
      //division modulo 41 bucket size 3
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 41);
         QuadraticProbing.quadProbingB3(totalNum[i], hashFunc, 41);
      }
      System.out.println("Hashing with Quadratic Probing and Bucket size 3: \n");
      HashTable.printTable(3);
      QuadraticProbing.quadProbingPrintStats();
      
      //Chaining Collision Handling
      //division modulo 120 
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 120);
         Chaining.ChainingStrat(totalNum[i], hashFunc);
      }
      System.out.println("Hashing with Chaining modulo 120: ");
      HashTable.printTable(4);
      Chaining.chainingPrintStats();
      //chaining collision handling with modulo 113
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (totalNum[i] % 113);
         Chaining.ChainingStrat(totalNum[i], hashFunc);
      }
      System.out.println("Hashing with Chaining modulo 113: ");
      HashTable.printTable(4);
      Chaining.chainingPrintStats();
      //chaining with multiplication scheme
      for (int i = 0; i < totalNum.length; i++)
      {
       int hashFunc = (int)(Math.floor(tableSlots*(totalNum[i]*0.3 % 1)));
         Chaining.ChainingStrat(totalNum[i], hashFunc);
      }
      System.out.println("My Hashing Scheme Chaining multiplication constant 0.3:");
      HashTable.printTable(4);
      Chaining.chainingPrintStats();
      //Quadratic probing with multiplication scheme
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (int)(Math.floor(tableSlots*(totalNum[i]*0.3 % 1)));
         QuadraticProbing.quadProbing(totalNum[i], hashFunc, 120);
      }
      System.out.println("My hashing Scheme Quad: \n ");
      HashTable.printTable(4);
      QuadraticProbing.quadProbingPrintStats();
      
      for (int i = 0; i < totalNum.length; i++)
      {
         int hashFunc = (int)(Math.floor(tableSlots*(totalNum[i]*0.3 % 1)));
         LinearProbing.linearProbing1(totalNum[i], hashFunc);
      }
      System.out.println("My Hashing scheme for Linear Probing: \n");
      HashTable.printTable(4);
      LinearProbing.LinearProbingPrintStats();
   }

}