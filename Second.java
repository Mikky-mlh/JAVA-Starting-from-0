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
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine(); // read whole line
        System.out.println("Hello " + fullName + "!");
        System.out.print("Enter your name: ");
        String name = scanner.next(); // read only one token
        System.out.println("Hello " + name + "!");

        System.out.print("Enter your GPA: ");
        double GPA = scanner.nextDouble();
        System.out.println("Your GPA is: " + GPA);

        System.out.println("Program Finished.");
        scanner.close();



    }

}