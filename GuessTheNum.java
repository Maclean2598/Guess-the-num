import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create a Random object to generate random numbers.
        Random random = new Random();

        // Define the range for the secret number.
        int lowerBound = 1;
        int upperBound = 100;
        
        int secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
        
        // Keep track of the number of attempts the player makes.
        int attempts = 0;
        
        // Variable to store the player's guess.
        int guess;
        
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Guess the Number Game!");
        System.out.println("I have secretly chosen a number between " + lowerBound + " and " + upperBound + ".");
        System.out.println("Can you guess what it is?");

        // Game loop: continues until the player guesses correctly.
        while (!hasGuessedCorrectly) {
            System.out.print("Enter your guess: ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt(); 
                // Read the player's guess.
                attempts++; // Increment the attempt counter.

                if (guess < secretNumber) {
                    System.out.println("Your guess is too low. Try again!");
                } else if (guess > secretNumber) {
                    System.out.println("Your guess is too high. Try again!");
                } else {
                    hasGuessedCorrectly = true; 
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly!");
                    System.out.println("It took you " + attempts + " attempts.");
                }
            } else {
                // Handle invalid input (non-integer).
                System.out.println("Invalid input. Please enter a whole number.");
                scanner.next(); // Consume the invalid input to prevent an infinite loop.
            }
        }

        // Close the scanner to release system resources.
        scanner.close();
        System.out.println("Thanks for playing!");
    }
}
