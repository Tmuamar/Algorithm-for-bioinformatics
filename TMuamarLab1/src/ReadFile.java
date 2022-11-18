/* This class is main program that reads a text file to check if it has any palindromes */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ReadFile 
{
   private static FileWriter fw;
   private static Scanner input;
   private static Scanner inp;
   
   public static void main(String args[]) throws Exception 
   {
      //starting by creating the stack
      Stack<Character> stack = new Stack<Character>();
      String lab;
      input = new Scanner(System.in);
      System.out.println("Enter input file name with .txt(type exit to leave program): ");
      lab = input.nextLine();
      File text = new File(lab);
      String line;
      //allows for user to exit program from there input
      if(lab.matches("exit"))
      {
         System.out.println("Thank you for using the program.");
         System.exit(0);
      }
      
      //allows for user to reinput text without starting program again
      while(!text.exists())
      {
         System.out.println("Error: please try inputing file name again(type exit to leave program): ");
         lab = input.nextLine();
         text = new File(lab);
         
         if(lab.matches("exit"))
         {
            System.out.println("Thank you for using the program.");
            System.exit(0);
         }
      }
      // if the input text exists then continue with the program
      if(text.exists())
      {
         BufferedReader reader = new BufferedReader(new FileReader(text));
         inp = new Scanner(System.in);
         //asks user for a output file once input file name is recognize.
         System.out.println("Enter output file name with .txt at end: ");
         String output = inp.nextLine();
         fw = new FileWriter(output);
         
         //while loop to repeat each line of text from the input file
         while ((line = reader.readLine()) != null) 
         {
            //allows for the removal of spaces and special characters
            String words = line.toLowerCase().replaceAll("\\W", "");
            //push words into the stack 
            for (int i =0; i < words.length(); i++) 
            {
               stack.push(words.charAt(i)); 
            }
            
            String reverse = "";
            
            //pop the characters into empty string to reverse it
            while (!stack.Empty()) 
            { 
               reverse += stack.pop();
            }
            //once those characters are popped then compare the reverse if it is a palindrome
            if (words.equals(reverse)) 
            {
               fw.write("\n\n" + line + '"' + " is a palindrome.");  
            }
            else
            {
               fw.write("\n\n"+ line+ ""+ " is not a palindrome");  
            }
         }
         fw.close();
         reader.close();
      } 
   }
}