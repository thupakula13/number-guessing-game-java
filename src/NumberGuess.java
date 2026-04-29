import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * Number Guessing Game
 * ---------------------
 * Skills demonstrated:
 *   - Random number generation (java.util.Random)
 *   - Loops (while)
 *   - Conditional statements (if / else if / else)
 *   - Exception handling for invalid input (try / catch)
 */
public class NumberGuess {

    public static void main(String[] args) {

        // ── Setup ─────────────────────────────────────────────────────────
        Scanner scanner = new Scanner(System.in);
        Random  random  = new Random();

        int secretNumber = random.nextInt(100) + 1; // random number: 1 – 100
        int maxAttempts  = 5;
        int attemptsLeft = maxAttempts;
        boolean playerWon = false;

        // ── Welcome banner ────────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      NUMBER GUESSING GAME            ║");
        System.out.println("║  Guess the number between 1 – 100    ║");
        System.out.println("║  You have " + maxAttempts + " attempts. Good luck!     ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println();

        // ── Main game loop ─────────────────────────────────────────────────
        while (attemptsLeft > 0) {

            System.out.println("Attempts remaining: " + attemptsLeft);
            System.out.print("Your guess: ");

            try {
                int guess = scanner.nextInt();

                // ── Check the guess ────────────────────────────────────────
                if (guess < 1 || guess > 100) {
                    // Out-of-range numbers are accepted but flagged
                    System.out.println("  Hint: the number is between 1 and 100.");

                } else if (guess == secretNumber) {
                    // Correct guess → player wins
                    int usedAttempts = maxAttempts - attemptsLeft + 1;
                    System.out.println();
                    System.out.println("🎉 Correct! The number was " + secretNumber + ".");
                    System.out.println("   You won in " + usedAttempts + " attempt(s)!");
                    playerWon = true;
                    break; // exit the while loop immediately


                } else if (guess < secretNumber) {
                    System.out.println("  ↑ Too low! Try a higher number.");
                    attemptsLeft--;

                } else {
                    System.out.println("  ↓ Too high! Try a lower number.");
                    attemptsLeft--;
                }

            } catch (InputMismatchException e) {
                // User typed something that isn't an integer
                System.out.println("  ⚠  Invalid input! Please enter a whole number.");
                scanner.nextLine(); // flush the bad token so the loop doesn't get stuck
                // Note: we do NOT decrement attemptsLeft for invalid input
            }

            System.out.println();
        }

        // ── End-of-game message ────────────────────────────────────────────
        if (!playerWon) {
            System.out.println();
            System.out.println(" Game over! You've used all " + maxAttempts + " attempts.");
            System.out.println("   The secret number was: " + secretNumber);
        }

        scanner.close();
    }
}
    

