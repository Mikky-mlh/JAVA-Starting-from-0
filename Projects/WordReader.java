import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

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
