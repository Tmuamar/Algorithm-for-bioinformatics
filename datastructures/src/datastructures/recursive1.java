package datastructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class recursive1
{
   private static Scanner in;

   public static void main(String[] args) throws Exception {
        Queue<Character> sq = new LinkedList();
        System.out.print("Enter any string:");
        in = new Scanner(System.in);
        String c = in.nextLine();
        for (int i = 0; i < c.length(); i++) {
            sq.add(c.charAt(i));
        }

        String reverseString = "";

        while (!sq.isEmpty()) 
        {
            reverseString = reverseString+sq.remove();
        }

        if (c.equals(reverseString))
            System.out.println("The input String is a palindrome.");
        else
            System.out.println("The input String is not a palindrome.");

    }
}
