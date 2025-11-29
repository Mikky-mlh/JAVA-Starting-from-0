// TODO: Hangman game in JAVA

import java.io.IOException;
import java.util.Scanner;

public class Hangman 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        String word;
        try
        {
            word = WordReader.getRandomWordFromFile("words.txt");
        }
        catch (IOException e)
        {
            System.err.println("Error: Could not read the words file. Make sure 'words.txt' exists.");
            System.err.println("Details: " + e.getMessage());
            scanner.close();
            return; // Exit the game
        }
        
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++)
        {
            guessedWord[i] = '_';
        }

        int incorrectGuesses = 0;
        int maxIncorrectGuesses = 7;

        System.out.println("Welcome to Hangman!");
        System.out.println("You have 7 tries to guess the word. Good luck!");
        System.out.println("Guess the word: " + new String(guessedWord));

        while (incorrectGuesses < maxIncorrectGuesses)
        {
            System.out.print("Enter a letter: ");
            char guess = scanner.next().charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (found) {
                System.out.println("Correct guess!");
            }
            else {
                System.out.println("Incorrect guess!");
                incorrectGuesses++;
            }

            System.out.println("Incorrect guesses: " + incorrectGuesses);
            System.out.println("Guessed word: " + new String(guessedWord));

            if (new String(guessedWord).equals(word)) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println("Game over! You ran out of incorrect guesses. The word was: " + word);
        }

        scanner.close();
    }
}
