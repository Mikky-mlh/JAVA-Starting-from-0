public class First {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//! Variable declaration and initialization

//* Primitive data types = int, double, char, boolean */

int age;
age = 20;
System.out.println("My age is " + age);
double pi = 3.14;
double radius = 5.5;
double area = pi * radius * radius;
System.out.println("The area of the circle is " + area);
char grade = 'A';
char dollarSign = '$';
System.out.println("USA currency is " + dollarSign);
System.out.println("My grade is " + grade);
boolean isStudent = true;

if(isStudent) { //& if-else is a conditional satement
    System.out.println("I am a student.");
}
else {
    System.out.println("I am not a student.");
}

/*
* Non-primitive/Reference data types = String, Arrays, Classes, Interface
*/

String name = "Mikky";
System.out.println("My name is " + name);

int arr[]= {1,2,3,4,5}; //& arr is nothing but a list
System.out.println("First element of array is " + arr[0]);
System.out.println("Length of array is " + arr.length);
System.out.println("Last element of array is " + arr[arr.length - 1]);
System.out.println("Array elements are: ");
for(int i=0; i<arr.length; i++) {
    System.out.println(arr[i]);
}



    }
}