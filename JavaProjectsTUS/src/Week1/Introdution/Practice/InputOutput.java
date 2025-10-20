package Week1.Introdution.Practice;

import java.util.Scanner;
import java.util.InputMismatchException;

public class InputOutput {
    // Package private static scanner for user input, shared by all methods
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        // 1. Basic age input
        int age = getAge();
        System.out.println("Your age is: " + age);
        System.out.println();

        // 2. Age input with custom prompt and error handling
        int age2 = getAge("Please input your age?");
        System.out.println("Your age is: " + age2);
        System.out.println();

        // 3. Age input with custom prompt and name, checks input validity
        int age3 = getAge("Please input your age?", "Sean");
        System.out.println("Your age is " + age3);
        System.out.println();

        // 4. Pension Eligibility check
        boolean eligible47 = checkPension(47);
        System.out.println("Age 47 eligible for pension: " + eligible47);
        System.out.println();

        boolean eligible87 = checkPension(87);
        System.out.println("Age 87 eligible for pension: " + eligible87);
        System.out.println();

        //5. Full name input
        String name = getName();
        System.out.println("Your name is: " + name);
        System.out.println();

        // 6. First and last name input using array
        String[] names = new String[2];
        getName(names);
        System.out.println("First name: " + names [0]);
        System.out.println("Last  name: " + names [1]);
        System.out.println();
    }
    
    // Prompts for age and returns it
    public static int getAge(){
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        return age; // Local variable onyly exists in this method
    }

    // Prompts with a custom message, handles non-integer input
    public static int getAge(String prompt){
        int age = 0; // Default value
        System.out.println(prompt + " ");
        try{
            age = sc.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace(); // Prints error stack for debugging
        }
        return age;
    }

    // Prompts with custom message and name, checks if input is an integer
    public static int getAge(String prompt, String name){
        System.out.println("Hi there " + name + ". " + prompt + " ");
        int age;
        if (sc.hasNextInt()) {
            age = sc.nextInt();
        } else {
            System.out.println("Invalid input for age.");;
            age = -999; //Error value
        }
        return age;
    }

     // Returns true if age is 65 or older, else false
        public static boolean checkPension(int age) {
            // Normal if-els
            if (age >= 65) {
                return true;
            } else {
                return false;
            }
            // Ternart operator version (alternative):
            // return age >= 65 ? true : false;
        }

        // Prompts for full name and returns it 
        public static String getName(){
            sc.nextLine(); // Consume leftover newline
            System.out.println("Enter your full name: ");
            String name = sc.nextLine();
            return name;
        }

        // Fills passed array with first and last name using next()
        public static void getName(String[] arr){
            System.out.println("Enter your first name: ");
            arr[0] = sc.next();
            System.out.println("Enter your last name: ");
            arr[1] = sc.next();
        }
}

   