//TODO: OOPS - Aggregation Illustration

import java.util.ArrayList;
import java.util.List;


class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "'}";
    }
}


class Library {
    private final String name;
    private final List<Book> books; // The Library has a list of Books

    public Library(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void displayBooks() {
        System.out.println("Books available in " + this.name + ":");
        if (books.isEmpty()) {
            System.out.println("- No books available.");
        } else {
            for (Book book : books) {
                System.out.println("- " + book.title + " by " + book.author);
            }
        }
    }
}


class Heart {
    private String condition;

    public Heart(String condition) {
        this.condition = condition;
    }

    public void pump() {
        System.out.println("Heart is pumping blood. Condition: " + condition);
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "Heart{condition='" + condition + "'}";
    }
}


class Human {
    private String name;
    private Heart heart; //! Composition: Human "has-a" Heart, and controls its lifecycle

    public Human(String name, String heartCondition) {
        this.name = name;
        //* Composition: The Heart object is created inside the Human's constructor.
        //* It cannot exist independently of the Human in this context.
        this.heart = new Heart(heartCondition);
        System.out.println(name + " was born with a " + heartCondition + " heart.");
    }

    public void live() {
        System.out.println(name + " is living.");
        heart.pump();
    }

    public void checkUp() {
        System.out.println(name + "'s heart condition: " + heart.getCondition());
    }


    @Override
    public String toString() {
        return "Human{name='" + name + "', heart=" + heart + '}';
    }
}


public class OOPS2 { 
    public static void main(String[] args) {

        //~ Aggregation is when a class has a reference to another class
        System.out.println("--- AGGREGATION EXAMPLE (Library and Books) ---");
        // Create individual Book objects. They exist on their own.
        Book book1 = new Book("The Lord of the Rings", "J.R.R. Tolkien");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");
        Book book3 = new Book("1984", "George Orwell");

        // Create a list and add the book objects to it.
        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        // Create a Library object, passing the list of existing books.
        // The Library now "has" these books.
        Library cityLibrary = new Library("City Central Library", bookList);

        // Display the books contained within the library.
        cityLibrary.displayBooks();

        demonstrateComposition();

        demonstrateErrorHandling();
    }

    // Method to demonstrate Composition
    public static void demonstrateComposition() {
        //~ Composition is when a class contains a reference to another class
        System.out.println("\n--- COMPOSITION EXAMPLE (Human and Heart) ---");
        // When a Human is created, its Heart is also created within it.
        Human alice = new Human("Alice", "healthy");
        alice.live();
        alice.checkUp();

        System.out.println(alice);
    }

    // Method to demonstrate Exception Handling
    public static void demonstrateErrorHandling() {
        //! Exception: Error handling
        // How this works?: The try block attempts to execute code that might cause an error.
        // If an exception (error) occurs, the corresponding catch block is executed.
        // The finally block is always executed, regardless of whether an exception occurred or not.
        // This is useful for cleanup operations, like closing files or network connections.
        System.out.println("\n--- EXCEPTION HANDLING EXAMPLES ---");

        // Example 1: ArithmeticException
        System.out.println("\n1. Handling ArithmeticException:");
        try {
            System.out.println("Attempting to divide by zero...");
            int result = 1 / 0; 
            System.out.println("This will not be printed. Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error caught: " + e.getMessage());
        } finally {
            System.out.println("This 'finally' block is always executed after the try-catch.");
        }

        //NullPointerException and ArrayIndexOutOfBoundsException with multiple catch blocks
        System.out.println("\n2. Handling Multiple Exception Types:");
        try {
            String[] names = {"Alice", "Bob"};
            // names = null; // Uncomment this line to trigger NullPointerException
            System.out.println("Accessing array element at index 3...");
            System.out.println(names[3]); // This will throw an ArrayIndexOutOfBoundsException

        } catch (NullPointerException e) {
            System.out.println("Error caught: The array is null and cannot be accessed.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error caught: Invalid index. The array does not have an element at that position.");
        } catch (Exception e) {
            // A general Exception catch block can handle any other unexpected errors.
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}