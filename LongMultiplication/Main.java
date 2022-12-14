package LongMultiplication;

import java.util.Scanner;

public class Main {
    private static int a, b, c, productToAdd;
    private static String A, B;
    private static Scanner sc;
    private static boolean done;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println("If a x b = c and a, b, and c are integers...");
            enterOperands();

            // to prevent a few bugs, we need to restrict the range of numbers that can be calculated
            if ((String.valueOf(c).length() > 9)) {
                while ((String.valueOf(c).length() > 9)) {
                    System.out.println("\nNumbers are too big (product is greater than 999,999,999)");
                    enterOperands();
                }
            } else if (a < 0 | b < 0) {
                System.out.println("\nNumber's shouldn't be negative for now");
                enterOperands();
            }

            /*
              To make the solution more readable,
              the max length of characters per line is set to be the number of digits
              contained in the largest number amongst a, b, and c
              For example, if we're to multiply 23 by 34, we'll get 782
              782 has the most digits of the three so the largest length will be 5 (3 + 2)
             */
            int largestLength = String.valueOf(c).length() + 2;

            System.out.println("\nSolution:\n");

            // print the multiplicand
            for (int i = 0; i < (largestLength - String.valueOf(a).length()); i++)
                System.out.print(" ");
            System.out.println(a);

            System.out.print("x");

            // print the multiplier
            for (int i = 0; i < (largestLength - String.valueOf(b).length() - 1); i++)
                System.out.print(" ");
            System.out.println(b);

            // draw a line
            for (int i = 0; i < largestLength; i++)
                System.out.print("-");
            System.out.println();

            // convert b to an array so that we can split it and make use of its digits later
            char[] bChar = String.valueOf(b).toCharArray();

            /*
             In a long multiplication method
             the first number is repeatedly multiplied by the digits of the second number
             starting from behind
             until every digit of the second number has multiplied the first one
             For example: 123 x 45
             We first do 123 x 5, and then 123 x 4,
             and then we find the sum after relatively shifting each product to the left
             by a tens value as shown below
             
                615
             + 492
             
             This is exactly what the block of code below does
             */
            int l = 0;
            for (int i = String.valueOf(b).length() - 1; i >= 0; i--) {
                int intFormOfbChar = Integer.parseInt(String.valueOf(bChar[i]));
                productToAdd = intFormOfbChar * a;
                int lengthOfProductToAdd = String.valueOf(productToAdd).length();
                int numberOfSpaces = largestLength - l - lengthOfProductToAdd;

                if ((bChar.length == 1) || (String.valueOf(removeZeros(b)).length() == 1)) {

                    for (int j = 0; j < numberOfSpaces; j++)
                        System.out.print(" ");

                    System.out.println(productToAdd);
                } else if (bChar[i] != '0') {

                    // print a "+" sign before the last product
                    if ((i == 0) & (bChar.length != 1) & (String.valueOf(removeZeros(b)).length() != 1)) {
                        System.out.print("+");
                    }

                     /*
                     this specifies the number of spaces to be left before
                     each product in such a way it's shifted one ten's place
                     to the left
                     */
                    for (int j = 0; j < numberOfSpaces; j++)
                        System.out.print(" ");

                    if (i == 0)
                        System.out.print("\b");

                    System.out.print(productToAdd);

                    System.out.println();
                }

                l++;

            }

            // draw a line
            for (int i = 0; i < largestLength; i++)
                System.out.print("-");

            /*
              if and only if the second number contains more than one digit will we need to
              use the long multiplication method.
              And so a final answer is needed after adding two or more products
              But if the second number has just one digit, this block of code will not be
              executed
             */
            if (bChar.length > 1) {

                // print final result
                System.out.println("\n  " + c);

                // draw a line
                for (int i = 0; i < largestLength; i++)
                    System.out.print("-");
            }
        }

    }

    // eradicate 0's at the end of a number (100 changes to 1)
    private static int removeZeros(int num) {
        return reverseInt(reverseInt(num));
    }

    private static int reverseInt(int num) {
        int reverse = 0;

        while (num != 0) {
            reverse *= 10;
            reverse += num % 10;
            num /= 10;
        }

        return reverse;
    }

    private static void enterOperands() {
        System.out.print("Enter a: ");
        A = sc.next();

        // ensure that a is an integer
        done = false;
        while ((!done)) {
            try {
                a = Integer.parseInt(A);
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("\na must be an integer");
                System.out.print("Enter a: ");
                A = sc.next();
            }
        }

        System.out.print("Enter b: ");
        B = sc.next();

        // ensure that b is an integer
        done = false;
        while ((!done)) {
            try {
                b = Integer.parseInt(B);
                done = true;
            } catch (NumberFormatException e) {
                System.out.println("\nb must be an integer");
                System.out.print("Enter b: ");
                B = sc.next();
            }
        }

        // swap the values of a and b if b > a
        if ((String.valueOf(b).length()) > (String.valueOf(a).length())) {
            int temp = a;
            a = b;
            b = temp;

        }

        c = a * b;
    }
}
