//TODO: Methods


public class Ninth {
    static void myMethod() { //~ Creating a method
        System.out.println("I just got executed!");
    }
    
    static void stringMethod(String name) { //& Creating a method with a parameter
        System.out.println("My name is " + name);
    }

    static void multiparameterMethod(String name, int age) { //& Creating a method with 2 parameter
        System.out.println("My name is " + name + " and my age is " + age);
    }

    static void checkAge(int age) {
        if (age < 18) {
            System.out.println("Access denied - You are not old enough");
        } else {
            System.out.println("Access granted - You are old enough");
        }
    }

    static int sum(int x, int y) {
        return y + x; //& Returning a value from a method, cannot use void in return type
    }

    //& Overloading: same anme but different parameter

    static void myMethod(String name) 
    {
        System.out.println("My name is " + name + " (from overloading)");
    }

    static void myMethod(int age, int fage) 
    {
        System.out.println("My age is " + age + " and my father's age is " + fage);
    }

    static void myMethod(double cgpa) 
    {
        System.out.println("My cgpa is " + cgpa);
    }

    static double myMethod(double a, double b) 
    {
        return a + b;
    }

    static void recFact(int n) {
        if (n == 0) {
            System.out.println("The factorial of 0 is 1");
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            System.out.println("The factorial of " + n + " is " + result);
        }
    }
    
    static void countdown(int n) {
        if (n > 0) {
            System.out.println(n + " seconds remaining...");
            countdown(n - 1);
        }
    }

    //~ Varargs allows a method to accept zero or more arguments.
    //~ The varargs parameter is treated as an array inside the method.
    //~ The '...' syntax after the data type indicates a varargs parameter.
    static int sumVarArgs(int... numbers) {
        int sum = 0;
        System.out.println("Arguments received: " + numbers.length);
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    //~ A method can have other parameters along with varargs, 
    //~ but the varargs parameter must be the LAST parameter in the method signature.
    static void printItems(String listName, String... items) {
        System.out.println("\nItems in " + listName + ":");
        for (String item : items) {
            System.out.println("- " + item);
        }
    }

    public static void main(String[] args) {
        myMethod(); //& Calling a method
        stringMethod("Mikky"); //& Calling a method with a parameter
        multiparameterMethod("Yuvraj", 18); //& Calling a method with 2 parameter
        checkAge(20);
        checkAge(16);
        int result = sum(5, 10); //& Calling a method with return type
        System.out.println(result);

        myMethod("Mikky");
        myMethod(18, 20);
        myMethod(8.9);
        System.out.println(myMethod(5.5, 6.6));
        myMethod(5.5, 6.6);

        //~ Scope: an area where a variable is accessible
        //& Local variable: a variable declared inside a method. example: for loop using temporary variables like i
        //& Global variable: a variable declared outside a method, but within a class

        int x = 10; //& Global variable: can be used anywhere after this declaration
        System.out.println(x);

        {
            int y = 20; //& Local variable: can only be used inside this block{}
            System.out.println(y);
        }

        //! Recursion: a function that calls itself
        recFact(5);

        countdown(5);

        //! Varargs (Variable Arguments): a feature that allows a method to accept a variable number of arguments (zero or more).
        //~ It provides a shorter way to pass an array to a method.
        
        // Calling the varargs method with different numbers of arguments
        System.out.println("Sum (no args): " + sumVarArgs());
        System.out.println("Sum (one arg): " + sumVarArgs(10));
        System.out.println("Sum (multiple args): " + sumVarArgs(1, 2, 3, 4, 5));
        
        // You can also pass an array directly
        int[] myNumbers = {10, 20, 30};
        System.out.println("Sum (from array): " + sumVarArgs(myNumbers));
        
        printItems("Shopping List", "Milk", "Bread", "Eggs");
        printItems("Todo List"); // Calling with no varargs arguments

    }

}
