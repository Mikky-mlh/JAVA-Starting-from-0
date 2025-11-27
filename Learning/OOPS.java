//TODO: OOPS


class Car {
    
    String company;
    String model;
    int year;
    String color;
    boolean isfourwheeler; 

    //! Constructor
    // This is a special method used to initialize a new object of the Car class.
    // It has the same name as the class and no return type.
    // It takes parameters to set the initial values of the object's attributes.
    //* They can also be OVERLOADED!
    public Car(String company, String model, int year, String carColor) {
        System.out.println("A new car is being created...");
        this.company = company;
        this.model = model;
        this.year = year;
        this.color = carColor;
        this.isfourwheeler = true;
    }

    //& Constructor chaining: calling another constructor using this()
    public Car(String company, String model, int year) {
        this(company, model, year, "Unknown"); //& Calls the main constructor with default color
    }

    // Methods
    // These methods define the actions a Car object can perform.
    void honk() {
        System.out.println("Beep beep! I am a " + this.company + " " + this.model);
    }

    void displayDetails() {
        System.out.println("Car Details: " + this.year + " " + this.color + " " + this.company + " " + this.model);
    }

    void drive() {
        System.out.println("You are driving a " + this.color + " " + this.company + " " + this.model);
    }

}

class Animal{
    String name;
    int age;

    void makeSound(){
        System.out.println("Animal makes a sound");
    }

    void eat(){
        System.out.println("Animal eats");
    }

    void sleep(){
        System.out.println("Animal sleeps");
    }
}

class Dog extends Animal{ //& Dog is a subclass of Animal and extend is used to make it inherit its properties
    String breed;

    void bark(){
        System.out.println("Dog barks");
    }
}

class Person{
    String first, last;

    Person(String first, String last){
        this.first = first;
        this.last = last;
    }

    void showName(){
        System.out.println(first + " " + last);
    }

}

class Student extends Person{
    double gpa;
    Student(String first, String last, double gpa){
        super(first, last); //! super keyword is used to call the constructor of the superclass
        this.gpa = gpa;
    }
}


    public class OOPS {
    public static void main(String[] args) {

        // Here, we are creating two different 'Car' objects from the 'Car' class blueprint.
        // We use the 'new' keyword and call the constructor with specific values.
        Car myFerrari = new Car("Ferrari", "F50", 2022, "red");
        Car myPorsche = new Car("Porsche", "911", 2023, "blue");
        Car myMerc = new Car("Mercedes", "C63", 2022, "black");

        Car[] cars = {myFerrari, myPorsche, myMerc};

        for (Car car : cars) {
            car.honk();
            car.displayDetails();
            car.drive();
        }

        //! Accessing class from different files
        secondOOPS obj = new secondOOPS();
        obj.x = 20;
        obj.y = 30;
        System.out.println(obj.x + obj.y);

        FriendsOOPS friend1 = new FriendsOOPS("Mikky");
        FriendsOOPS friend2 = new FriendsOOPS("Yuvraj");

        System.out.println(friend1.name);
        System.out.println(friend2.name);
        System.out.println(FriendsOOPS.numberOfFriends);
        System.out.println(friend1.numberOfFriends); //& Can also be accessed using object reference, but not recommended
        System.out.println(friend2.numberOfFriends);

        Dog dog1 = new Dog();
        dog1.bark();
        dog1.makeSound();
        dog1.eat();
        dog1.sleep();

        Student s1 = new Student("Yuvraj", "Sarathe", 9.7);
        s1.showName();

    }
}
