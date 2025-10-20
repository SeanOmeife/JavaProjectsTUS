package Week1.Introdution.Practice;

import java.util.Scanner; // Imports scanner for user input

public class WeekOneExercises {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read user input

    // 1. Call static method didOswaldActAlone()
    System.out.println("Do you thinl Oswald acted alone? (true/false): ");
    boolean oswaldAlone = didOswaldActAlone(scanner); // calls static method, passes scanner

    if (oswaldAlone){
        System.out.println("You think Oswald acted alone.");
    } else {
        System.out.println("You think Oswald did not act alone.");
    }

    // 2. Call non-static method wasOjGuilty()
    WeekOneExercises ex = new WeekOneExercises(); // Creates instance to call non-static method
    System.out.println("Do you think OJ was guilty? (true/false): ");
    boolean ojGuilty = ex.wasOjGuilty(scanner); // Calls non-static method, passes scanner
    if (ojGuilty){
        System.out.println("You think OJ was guilty.");
    } else {
        System.out.println("You think OJ was not guilty.");
    }
        
    // 3. Call static method favouriteFilm()
    System.out.println("What is your favourite film? ");
    String favFilm = favouriteFilm(scanner); // calls static method and passes scanner
    System.out.println("Your favourite film is: " + favFilm); // Outputs returned value
    
    // 4. Call static method filmRating(int)
    int rating = filmRating(scanner, favFilm); // passes film name to method
    System.out.println("You rated " + favFilm + " as: " + rating); //outputs rating

    scanner.close(); // closes scanner to free resources
    }

    // Static method: can be called without creating an object
    public static boolean didOswaldActAlone(Scanner scanner){
        return scanner.nextBoolean(); // reads boolean input and returns it
    }

    // Non-static method: must be called on an object instance
    public boolean wasOjGuilty(Scanner scanner){
        return scanner.nextBoolean();
    }

    // static method: returns user's favourite film
    public static String favouriteFilm(Scanner scanner){
        return scanner.next(); // reads next word as film name
    }

    // static method: asks for rating of a film and returns it
    public static int filmRating(Scanner scanner, String film){
        System.out.println("What is the rating for " + film + "? ");
        return scanner.nextInt(); // outputs rating
    }


}
