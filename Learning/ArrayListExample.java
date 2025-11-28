//TODO: ArrayList

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args){

        // The type is now correctly referring to java.util.ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("The first fruit is: " + fruits.get(0));
        System.out.println("The list of fruits is: " + fruits);

        fruits.remove(1);
        System.out.println("The list of fruits is: " + fruits);
        System.out.println("The size of the list is: " + fruits.size());

        fruits.clear();
        System.out.println("The list of fruits is: " + fruits);
        System.out.println("The size of the list is: " + fruits.size());
        System.out.println("The list is empty: " + fruits.isEmpty());
        System.out.println("The list contains Apple: " + fruits.contains("Apple"));
        System.out.println("The list contains Banana: " + fruits.contains("Banana"));


        Arrr

    }
}
