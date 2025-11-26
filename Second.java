import java.util.Scanner;

public class Second {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two numbers to add:");
        System.out.print("First number: ");
        int a = scanner.nextInt();

        System.out.print("Second number: ");
        int b = scanner.nextInt();

        System.out.println("The sum is: " + (a + b));

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "!");

        System.out.println("Program Finished.");
        scanner.close();



    }

}