//TODO: Guess The Number game in JAVA

import java.util.Scanner;

public class GTN 
{
    public static void main(String[] args) 
    {

        Scanner scanner = new Scanner(System.in);

        int secretNumber = (int) (Math.random() * 100) + 1;
        int guess;
        int numGuesses = 0;

        System.out.println("Welcome to the Guess the Number game!");
        System.out.println("I'm thinking of a number between 1 and 100. Can you guess it?");

        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            numGuesses++;

            if (guess < secretNumber)
            {
                System.out.println("Too low! Try again.");
            } else if (guess > secretNumber)
            {
                System.out.println("Too high! Try again.");
            } else
            {
                System.out.println("Congratulations! You guessed the number in " + numGuesses + " guesses.");
            }

        } while (guess != secretNumber);

        scanner.close();
    }
}
    
