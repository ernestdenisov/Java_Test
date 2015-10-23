package ernest.denisov.com.ua;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1Exercise2 {
    /*
    * Receive the string (converted int value) from user input
    * and make a reverse.
    * equals() method returns the true value when we have achieved a palindom
     */
    public static Boolean makePalindrome(String s) {
        return s.equals((new StringBuilder(s)).reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println("Please, input Your number:");
        Scanner scanner = new Scanner(System.in);
        //catch incorrect input (characters, strings etc.)
        try {
            //scan user input
            int myInt = scanner.nextInt();
            Boolean bool;
            String s;
            Integer myWrappedInt;
            //do-while loop to check if we have a palindrome or not after an increment step
            do {
                myInt++;
                //make an object of int value and result in String value
                myWrappedInt = new Integer(myInt);
                s = myWrappedInt.toString();
                //use our makePalindrome method to reverse the string
                bool = makePalindrome(s);
            } while (!bool);

            System.out.println("The nearest palimdromic number is: " + myInt);

        } catch (InputMismatchException e) {
            System.out.println("Input error. Use just numbers, please.");
        }
    }
}
