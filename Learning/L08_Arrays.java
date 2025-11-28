//TODO: ARRAYS

import java.util.Arrays; //~ For sorting and searching
import java.util.Scanner;

public class L08_Arrays
{

    public static void main(String[] args){


        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; //~ Array of strings
        System.out.println(cars[0]); //& acessing with index

        cars[0] = "Opel"; //& modifying
        System.out.println(cars[0]);
        System.out.println(cars.length); //& length of the array

        for (int i = 0; i < cars.length; i++)
        {
            System.out.println(cars[i]);
        }

        //! OR

        for(String car : cars){
            System.out.println(car);
        }

        String[] f1cars = new String[4]; // size is 4(imp to decide)

        f1cars[0] = "Mercedes"; //& adding elements
        f1cars[1] = "Alpine";
        f1cars[2] = "Williams";
        f1cars[3] = "Ferrari";

        System.out.println(f1cars[0]);

        //! OR

        String[] f1cars2 = {"Mercedes", "Alpine", "Williams", "Ferrari"}; ///no need too  decide the size
        System.out.println(f1cars2[0]);

        int arr[] = {11, 22, 13, 4, 8, 56, 44}; //& array of integers


        //! Bubble sort
        System.out.println("Bubble sort");
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for(int num : arr){
            System.out.println(num);
        }


        //! Using Arrays.sort()
        System.out.println("Using Arrays.sort()");
        Arrays.sort(arr);
        for(int num : arr){
            System.out.println(num);
        }

        //! 2D array

        int[][] myNumbers = { {1, 4, 2}, {3, 6, 8} };
        /*
        * 1 4 2
        * 3 6 8
        & myNumbers[0][0] = 1
        & myNumbers[0][1] = 4
        & myNumbers[0][2] = 2
        & myNumbers[1][0] = 3
        & myNumbers[1][1] = 6
        & myNumbers[1][2] = 8
        ~ To access specific column: myNumbers[row][column]
        */
        System.out.println(myNumbers[1][2]); // Output 8

        myNumbers[1][2] = 9; //& Changed value
        System.out.println(myNumbers[1][2]); //Output 9

        int[][] mynewNumbers = { {1, 4, 2}, {3, 6, 8, 5, 2} };
        System.out.println("Rows: " + mynewNumbers.length);             // 2
        System.out.println("Cols in row 0: " + mynewNumbers[0].length); // 3
        System.out.println("Cols in row 1: " + mynewNumbers[1].length); // 5

        for (int row = 0; row < mynewNumbers.length; row++)
        {
            for (int col = 0; col < mynewNumbers[row].length; col++)
            {
                    System.out.println("mynewNumbers[" + row + "][" + col + "] = " + mynewNumbers[row][col]);
            }
        }

        //! OR


        for (int[] row : mynewNumbers)
        {
            for (int num : row)
            {
                System.out.println(num);
            }
        }

        //! User input in array

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of items you want to add in an array: ");
        int num = scanner.nextInt();
        String[] userArray = new String[num];
        for (int i = 0; i < userArray.length; i++)
        {
            System.out.print("Enter item " + (i + 1) + ": ");
            userArray[i] = scanner.next();
        }
        System.out.println("Your array is: ");
        for (String item : userArray)
        {
            System.out.println(item);
        }

        //! Search in Arrays

        System.out.print("Enter item to search in array: ");
        String searchItem = scanner.next();
        boolean found = false;
        for (String item : userArray)
        {
            if (item.equals(searchItem))
            {
                found = true;
                break;
            }
        }
        if (found)
        {
            System.out.println("Item found in array at index: " + Arrays.asList(userArray).indexOf(searchItem));
        }
        else
        {
            System.out.println("Item not found in array");
        }

        scanner.close();
    

    }

}