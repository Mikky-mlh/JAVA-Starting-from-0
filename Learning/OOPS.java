//TODO: OOPS


class Car {
    
    String company;
    String model;
    int year;
    String color;

    //! Constructor
    // This is a special method used to initialize a new object of the Car class.
    // It has the same name as the class and no return type.
    // It takes parameters to set the initial values of the object's attributes.
    public Car(String company, String model, int year, String carColor) {
        System.out.println("A new car is being created...");
        // The 'this' keyword refers to the current object's attributes.
        // It's used to distinguish between the attribute (this.model) and the parameter (model).
        this.company = company;
        this.model = model;
        this.year = year;
        this.color = carColor;
    }

    // Methods
    // These methods define the actions a Car object can perform.
    void honk() {
        System.out.println("Beep beep! I am a " + this.company + " " + this.model);
    }

    void displayDetails() {
        System.out.println("Car Details: " + this.year + " " + this.color + " " + this.company + " " + this.model);
    }
}


    public class OOPS {
    public static void main(String[] args) {

        // Here, we are creating two different 'Car' objects from the 'Car' class blueprint.
        // We use the 'new' keyword and call the constructor with specific values.
        Car myFerrari = new Car("Ferrari", "F50", 2022, "Red");
        Car myPorsche = new Car("Porsche", "911", 2023, "Silver");

        
        myFerrari.displayDetails();
        myFerrari.honk();

        myPorsche.displayDetails();
        myPorsche.honk();

        //! Accessing class from different files
        secondOOPS obj = new secondOOPS();
        obj.x = 20;
        obj.y = 30;
        System.out.println(obj.x + obj.y);

    }
}
