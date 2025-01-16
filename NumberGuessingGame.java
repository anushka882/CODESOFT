import java.util.Random;
import java.util.Scanner;


        public class NumberGuessingGame{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int range = 100;
            boolean playAgain;

            do {
                int randomNumber = random.nextInt(range) + 1;
                int attempts = 0;
                int maxAttempts = 10;
                boolean correctGuess = false;

                System.out.println("Guess a number between 1 and " + range + ":");

                while (attempts < maxAttempts) {
                    attempts++;
                    System.out.print("Attempt " + attempts + ": Enter your guess: ");
                    int userGuess = scanner.nextInt();

                    if (userGuess == randomNumber) {
                        System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                        correctGuess = true;
                        break;
                    } else if (userGuess > randomNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.println("Too low! Try again.");
                    }
                }

                if (!correctGuess) {
                    System.out.println("Sorry! You've used all attempts. The correct number was " + randomNumber + ".");
                }

                System.out.print("Do you want to play again? (yes/no): ");
                playAgain = scanner.next().equalsIgnoreCase("yes");

            } while (playAgain);

            System.out.println("Thank you for playing!");
            scanner.close();
        }
    }


