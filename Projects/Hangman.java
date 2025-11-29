// TODO: Hangman game in JAVA

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman
{
    // COLORS
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String RED_BOLD = "\033[1;31m";    // For Game Over
    public static final String GREEN_BOLD = "\033[1;32m";  // For Winning

    private static final int SCREEN_WIDTH = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            playGame(scanner);
            System.out.print("\nPlay again? (y/n): ");
            playAgain = scanner.next().toLowerCase();
        } while (playAgain.equals("y")|| playAgain.equals("yes"));

        System.out.println(CYAN + "Thanks for playing!" + RESET);
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        String word;
        String usedLetters = "";
        try
        {
            word = WordReader.getRandomWordFromFile("words.txt");
        }
        catch (IOException e)
        {
            System.err.println("Error: Could not read the words file. Make sure 'words.txt' exists.");
            System.err.println("Details: " + e.getMessage());
            return; // Exit the game
        }
        
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < guessedWord.length; i++)
        {
            guessedWord[i] = '_';
        }

        int incorrectGuesses = 0;
        int maxIncorrectGuesses = 6;

        // Title Screen
        
        centerText(CYAN + "*       WELCOME TO HANGMAN     *" + RESET);
        System.out.println("You have " + YELLOW + maxIncorrectGuesses + RESET + " attempts to guess the word.");

        printHangman(incorrectGuesses);

        System.out.println("Guess the word: " + new String(guessedWord));

        while (incorrectGuesses < maxIncorrectGuesses)
        {
            System.out.print("\nEnter a letter: ");
            String input = scanner.next().toLowerCase();

            if(input.length() < 1) continue;
            
            char guess = input.charAt(0);

            boolean found = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            String guessStr = String.valueOf(guess).toLowerCase();

            if(usedLetters.contains(guessStr)) {
                System.out.println("You already guessed that letter!");
                continue;
            }

            usedLetters += guessStr;

            if (found) {
                System.out.println(GREEN + "Correct guess!" + RESET);
            }
            else {
                System.out.println(RED + "Incorrect guess!" + RESET);
                incorrectGuesses++;
            }

            printHangman(incorrectGuesses);

            System.out.println("Incorrect guesses: " + RED  + incorrectGuesses + '/' + maxIncorrectGuesses + RESET);
            System.out.println("Guessed word: " + PURPLE);
            for (char c : guessedWord) {
                System.out.print(c + " ");
            }
            System.out.println(RESET);

            if (new String(guessedWord).equals(word)) {
                System.out.println("\n" + GREEN_BOLD + "Congratulations!!!\nYou guessed the word!!!" + RESET);
                break;
            }
            System.out.println("Used letters: " + BLUE + usedLetters.toUpperCase() + RESET);
        }

        if (incorrectGuesses == maxIncorrectGuesses) {
            System.out.println("\n" + RED_BOLD + "GAME OVER!! YOU KILLED HIM!!!" + RESET);
            System.out.println("The word was: " + CYAN + word + RESET);
        }
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

    private static void centerText(String text) {
        // This regex removes ANSI color codes to accurately measure visible text length
        String plainText = text.replaceAll("\u001B\\[[;\\d]*m", "").replaceAll("\033\\[[;\\d]*m", "");
        int padding = (SCREEN_WIDTH - plainText.length()) / 2;
        System.out.printf("%" + padding + "s%s%n", "", text);
    }

    public static void printHangman(int incorrectGuesses) {
        centerText(YELLOW + "  ------" + RESET);
        centerText(YELLOW + "  |    |" + RESET);
        
        if (incorrectGuesses >= 1) {
            centerText(YELLOW + "  |" + RED + "    O" + RESET); // Head
        } else {
            centerText(YELLOW + "  |" + RESET);
        }
        
        if (incorrectGuesses >= 4) {
            centerText(YELLOW + "  |" + RED + "    /|\\" + RESET); // Arms
        } else if (incorrectGuesses >= 3) {
            centerText(YELLOW + "  |" + RED + "    /|" + RESET); 
        } else if (incorrectGuesses >= 2) {
            centerText(YELLOW + "  |" + RED + "     |" + RESET);
        } else {
            centerText(YELLOW + "  |" + RESET);
        }
        
        if (incorrectGuesses >= 6) {
            centerText(YELLOW + "  |" + RED + "    / \\" + RESET); // Legs
        } else if (incorrectGuesses >= 5) {
            centerText(YELLOW + "  |" + RED + "    /" + RESET);
        } else {
            centerText(YELLOW + "  |" + RESET);
        }
        
        centerText(YELLOW + "  |" + RESET);
        centerText(YELLOW + "---" + RESET);
    }
}
