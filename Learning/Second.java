//TODO: Taking user inputs

import java.util.Scanner; //& import statement to use Scanner class from java.util package for taking user input

public class Second {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //& Scanner object creation to read input from console (System.in)

        System.out.println("Enter two numbers to add:");
        System.out.print("First number: "); //& print() doesn't add newline, keeps cursor on same line
        int a = scanner.nextInt(); //& nextInt() method reads integer input from user

        System.out.print("Second number: ");
        int b = scanner.nextInt();

        System.out.println("The sum is: " + (a + b));

        scanner.nextLine(); //& Consume leftover newline character after nextInt() to prevent skipping next input
        
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine(); //& nextLine() reads entire line including spaces
        System.out.println("Hello " + fullName + "!");
        System.out.print("Enter your name: ");
        String name = scanner.next(); //& next() reads only one word/token, stops at whitespace
        System.out.println("Hello " + name + "!");

        System.out.print("Enter your GPA: ");
        double GPA = scanner.nextDouble();
        System.out.println("Your GPA is: " + GPA);

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = scanner.nextBoolean();
    
        if(isStudent) {
            System.out.println("You are a student.");
        }
        else {
            System.out.println("You are not a student.");
        }


        double height;
        double width;
        double area;
        System.out.print("Enter height of rectangle: ");
        height = scanner.nextDouble();

        System.out.print("Enter width of rectangle: ");
        width = scanner.nextDouble();

        area = height * width;
        System.out.println("The area of the rectangle is: " + area + "cm²");

        System.out.println("Program Finished.");
        scanner.close(); //& close() method releases system resources used by Scanner object



    }

}