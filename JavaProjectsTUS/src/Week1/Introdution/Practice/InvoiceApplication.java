package Week1.Introdution.Practice;

// Import scanner library utility
import java.util.Scanner;

public class InvoiceApplication {

    public static void main(String[] args){

        // Scanner is always in the main class. DOn't forget
        Scanner sc = new Scanner(System.in);

        // Method 1: static method variable declaration 
        // double subtotal = 100;
        // double discountPercent = 0.2;
        // double discountAmount = subtotal * discountPercent;
        // double total = subtotal - discountAmount;

        // Prompt for subtotal (validate numeric)
        System.out.println("Enter subtotal: ");
        while (!sc.hasNextDouble()){
            System.out.println("Invalid input. Enter numeric subtotal: ");
            sc.next();
        }
        double subtotal = sc.nextDouble();

        // Prompt for discount amount(validate numeric)
        System.out.println("Enter the discount amount: ");
        // while loop repeats as long as next token is NOT a valid double
        while (!sc.hasNextDouble()){ //this returns true if the next token is a double
            System.out.println("Invalid input. Enter numeric discount amount: ");
            sc.next();
        }
        double discountAmount = sc.nextDouble();

        // Compute percent and total (guard against division by zero)
        double discountPercent = (subtotal != 0) ? (discountAmount / subtotal) : 0.0;
        // ternary operator (condition ? valueIfTrue : valueIfFalse)
        // if subtotal is not zero, dA/sub. Else dP is set to 0.0
        double total = subtotal - discountAmount;

        // Welcome the user to the program
        System.out.println("Welcome to the Invoice Total Calculator\n");
        System.out.printf("Subtotal:                  %.2f%n ",  subtotal);
        System.out.printf("Discount percent:          %.2f%%%n ",  discountPercent);
        System.out.printf("Discount amount:           %.2f%n ",  discountAmount);
        System.out.printf("Total:                     %.2f%n ",  total);


        sc.close(); // close scanner to avoid wasting resources

    }

}
