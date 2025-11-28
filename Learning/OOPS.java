//TODO: OOPS - Object-Oriented Programming

/*
~ Four Pillars of OOPS:
& 1. Encapsulation: Bundle data and methods together, hide internal details
& 2. Abstraction: Show only essential features, hide complexity
& 3. Inheritance: Child class inherits from parent class (code reuse)
& 4. Polymorphism: One interface, multiple implementations
*/

public class OOPS {
    //~ 1. ENCAPSULATION
    //& Private data + public methods to access it safely
    static class BankAccount {
        private double balance; //! Hidden from outside

        public BankAccount(double initialBalance) {
            if (initialBalance > 0) {
                this.balance = initialBalance;
            } else {
                this.balance = 0;
            }
        }

        
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("/* Deposit Successful! New Balance: " + balance + " */");
            } else {
                System.out.println("/* Deposit amount must be positive. */");
            }
        }

        
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("/* Withdrawal Successful! New Balance: " + balance + " */");
            } else {
                System.out.println("/* Invalid withdrawal amount or insufficient funds. */");
            }
        }

        
        public double getBalance() {
            return balance;
        }
    }

    //~ 2. ABSTRACTION
    //& Hiding the complex implementation details and showing only the essential features of the object
    static abstract class Animal {
        final private String name;

        public Animal(String name) {
            this.name = name;
        }

        //& Abstract method: no body, must be implemented by subclass
        public abstract void makeSound(); //! It mainly exists in the parent class but has no implementation behaviour. The implementation can be done by each child class separately according to the needs

        //& Concrete method: has implementation
        public void sleep() {
            System.out.println(name + " is sleeping... Zzz");
        }

        public String getName() {
            return name;
        }
    }

    //~ 3. INHERITANCE
    //& Dog inherits from Animal using 'extends'
    static class Dog extends Animal {
        public Dog(String name) {
            //& super() calls parent constructor
            super(name);
        }

        //~ 4. POLYMORPHISM (Method Overriding)
        //& Polymorphism: one interface, multiple implementations
        //& Dog provides its own implementation of makeSound()
        @Override
        public void makeSound() {
            System.out.println(getName() + " says: Woof Woof!");
        }
    }

        static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void makeSound() {
            System.out.println(getName() + " says: Meow!");
        }
    }


    
    //~ SIMPLE CLASS & OBJECT
    
    static class Car {
        String company;
        String model;
        int year;

        //! Constructor: initializes object
        public Car(String company, String model, int year) {
            this.company = company;
            this.model = model;
            this.year = year;
        }

        void displayDetails() {
            System.out.println("Car: " + this.year + " " + this.company + " " + this.model);
        }
    }


    public static void main(String[] args) {

        System.out.println("\n DEMONSTRATING ENCAPSULATION");
        BankAccount myAccount = new BankAccount(500.00);
        // System.out.println(myAccount.balance); //! Compile error: balance is private

        System.out.println("Initial Balance: " + myAccount.getBalance());
        myAccount.deposit(200.00);
        myAccount.withdraw(150.00);
        myAccount.withdraw(1000.00); // This will fail
        System.out.println("Final Balance: " + myAccount.getBalance());


        System.out.println("\n DEMONSTRATING ABSTRACTION, INHERITANCE, AND POLYMORPHISM");
        // Animal myAnimal = new Animal("generic"); //! Compile error: Animal is abstract

        //~ POLYMORPHISM IN ACTION
        //& Parent reference, child object
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        //& Java calls the correct version at runtime
        myDog.makeSound(); //& Dog's version
        myCat.makeSound(); //& Cat's version

        myDog.sleep(); //& Inherited from Animal
        myCat.sleep();


        System.out.println("\n A SIMPLE CLASS & OBJECT");
        Car myCar = new Car("Ferrari", "F50", 2022);
        myCar.displayDetails();


        System.out.println("\n DEMONSTRATING STATIC MEMBERS (from FriendsOOPS.java)");
        //& Static variable: shared among all objects
        FriendsOOPS friend1 = new FriendsOOPS("Mikky");
        FriendsOOPS friend2 = new FriendsOOPS("Yuvraj");
        System.out.println("Friend 1: " + friend1.name);
        System.out.println("Friend 2: " + friend2.name);
        //& Access static variable using class name
        System.out.println("Total number of friends created: " + FriendsOOPS.numberOfFriends);


        System.out.println("\n CLASS FROM ANOTHER FILE (secondOOPS.java)");
        secondOOPS obj = new secondOOPS();
        System.out.println("Sum from secondOOPS object: " + (obj.x + obj.y));
    }
}
