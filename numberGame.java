import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Number Guessing Game!");

        System.out.print("How many rounds would you like to play? ");
        int rounds = scanner.nextInt();
        int score = 0;

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round + " of " + rounds);
            Random random = new Random();
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean correctGuess = false;

            while (attempts < maxAttempts && !correctGuess) {
                System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": Enter your guess (1-100): ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                    score += maxAttempts - attempts + 1;
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all your attempts. The correct number was " + numberToGuess + ".");
            }
        }

        System.out.println("\nGame Over! Your final score is " + score + ".");
        System.out.print("Would you like to play again? (yes/no): ");
        scanner.nextLine();  // Consume the leftover newline
        String playAgain = scanner.nextLine().toLowerCase();

        if (playAgain.equals("yes")) {
            main(null);  // Restart the game
        } else {
            System.out.println("Thanks for playing! Goodbye.");
        }

        scanner.close();
    }
}