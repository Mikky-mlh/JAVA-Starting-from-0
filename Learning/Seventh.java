//TODO: LOOPS

import java.util.Scanner;
public class Seventh 
{
    public static void main(String[] args) 
    {

        //! While loops: Iterate until the condition is false, sometimes iterate even infinitely if wrong conditions are used

        /*
        while (condition)
        {
            code block to be executed
        }
        */

        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        int countdown = 3;

        while (countdown > 0) {
        System.out.println(countdown);
        countdown--;
        }

        System.out.println("Happy New Year!!");

        int j = 10;

        while (j < 5) {
        System.out.println("This will never be printed");
        j++;
        }

        //! Do-While loops: Iterate at least once, then iterate until the condition is false
        /*
        do
        {
            code block to be executed
        } while (condition);
        */

        int k = 1;
        do {
        System.out.println(k);
        k++;
        } while (k <= 5);

        int l = 10;
        do {
        System.out.println("i is " + l);
        l++;
        } while (i < 5); //false condition but will still print one time

        //! For loops: Iterate a fixed number of times
        /*
        for (initialization; condition; update)
        {
            code block to be executed
        }
        */

        for (int m = 1; m <= 5; m++) {
        System.out.println(m);
        }

        for (int n = 0; n <= 10; n = n + 2)
        {
            System.out.println(n); //print even numbers
        }

        int sum = 0;
        for (int g = 1; g <= 5; g++) {
        sum = sum + g;
        }
        System.out.println("Sum is " + sum);

        int x = 13;
        for(int h=1; h<=10; h++)
        {
            System.out.println(x + " x " + h + " = " + (x*h));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        int fact = 1;
        for(int p = 1; p<=n; p++){
            fact *= p;
        }
        System.out.println("Factorial of " + n + " is " + fact);
        scanner.close();

        //

        //! for each loop: Iterate over elements of an array or collection
        /*
        for (type variableName : arrayName)
        {
            code block to be executed
        }
        */

        int[] numbers = {3, -1, 7, 0, 9};
        for (int number : numbers) {
        System.out.println(number);
        }

        for (int q : numbers)
        {
            if (q<0){
                continue; //~skips the negative numbers
            }
            if (q==0){
                break; //~stops the loop at 0
            }
            System.out.println(q);
        }
    }


}

