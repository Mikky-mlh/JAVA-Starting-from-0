//TODO: Arithmetic Operators

public class Third {
    public static void main(String[] args) {
        double x, y;
        x = 10;
        y = 20;
        System.out.println("Sum is: " + (x + y));
        System.out.println("Subtraction is: " + (x - y));
        System.out.println("Multiplication is: " + (x * y));
        System.out.println("Division is: " + (x / y));
        System.out.println("Modulus is: " + (x % y)); //& modulus operator gives the remainder of the division
        System.out.println("Increment is: " + (++x));
        System.out.println("Decrement is: " + (--y));
        
        double a,b;
        
        a = 15;
        b = 10;
        System.out.println("a += b: " + (a += b));
        System.out.println("a -= b: " + (a -= b));
        System.out.println("a *= b: " + (a *= b));
        System.out.println("a /= b: " + (a /= b));
        System.out.println("a %= b: " + (a %= b));

        System.out.println("New a is: " + (a));
        System.out.println("New b is: " + (b));
        System.out.println("New x is: " + (x));
        System.out.println("New y is: " + (y));
        
        System.out.println((x/y)+(9*a/b)-(a*x-b*y)); //& PEMDAS rule

    }
}
