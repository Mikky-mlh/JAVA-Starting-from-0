// TODO: Hangman game in JAVA

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman 
{
    public static void main(String[] args) {
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
        int maxIncorrectGuesses = 6;

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + maxIncorrectGuesses + " tries to guess the word. Good luck!");

        printHangman(incorrectGuesses);

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

            printHangman(incorrectGuesses);

            System.out.println("Incorrect guesses: " + incorrectGuesses);
            System.out.println("Guessed word: " + new String(guessedWord));

            if (new String(guessedWord).equals(word)) {
                System.out.println("Congratulations! You guessed the word: " + word);
                break;
            }
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println("GAME OVER!! YOU KILLED HIM!!!");
            System.out.println("The word was: " + word);
        }

        scanner.close();
    }

    public class WordReader {
    
        public static String getRandomWordFromFile(String filename) throws IOException {
            List<String> words = Files.readAllLines(Paths.get(filename));
            Random random = new Random();
            return words.get(random.nextInt(words.size()));
        }
        
        public static void main(String[] args) {
            try {
                String word = getRandomWordFromFile("words.txt");
                System.out.println("Random word from file: " + word);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }

    public static void printHangman(int incorrectGuesses) {
        System.out.println("------");
        System.out.println("|    |");
        if (incorrectGuesses >= 1) {
            System.out.println("|    O"); // Head
        } else {
            System.out.println("|");
        }
        if (incorrectGuesses == 2) {
            System.out.println("|    |"); // Body
        } else if (incorrectGuesses == 3) {
            System.out.println("|   /|"); // Body and one arm
        } else if (incorrectGuesses >= 4) {
            System.out.println("|   /|\\"); // Body and both arms
        } else {
            System.out.println("|");
        }
        if (incorrectGuesses == 5) {
            System.out.println("|   /"); // One leg
        } else if (incorrectGuesses >= 6) {
            System.out.println("|   / \\"); // Both legs
        } else {
            System.out.println("|");
        }
        System.out.println("|");
        System.out.println("---");
    }
}

