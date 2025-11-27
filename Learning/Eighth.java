public class Eighth{

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

    }

}