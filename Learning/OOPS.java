//TODO: OOPS - Object-Oriented Programming

/*

*   OOPS is a programming paradigm based on the concept of "objects", which can contain
*   data (attributes or properties) and code (methods or procedures). The primary
*   purpose of OOPS is to increase the flexibility and maintainability of programs.

~ The Four Pillars of OOPS:

& 1. Encapsulation: Bundling data (attributes) and methods that work on the data
&    into a single unit or class. It also involves data hiding, where the internal
&    state of an object is protected from outside access.

& 2. Abstraction: Hiding complex implementation details and showing only the
&    essential features of the object. It helps in managing complexity.

& 3. Inheritance: A mechanism where a new class (subclass) derives attributes
&    and methods from an existing class (superclass). It promotes code reusability.

& 4. Polymorphism: The ability of an object to take on many forms. The most common
&    use of polymorphism in OOPS occurs when a parent class reference is used to
&    refer to a child class object. This allows for runtime polymorphism.
*/

public class OOPS {
    //~ 1. ENCAPSULATION
    
    //& We create a BankAccount class to demonstrate encapsulation.
    //& The data (balance) is kept 'private', so it cannot be accessed directly from outside the class.
    //& We provide 'public' methods (deposit, withdraw, getBalance) to interact with the data safely.
    static class BankAccount {
        //! private data member - hidden from other classes
        private double balance;

        //& Constructor to initialize the account
        public BankAccount(double initialBalance) {
            if (initialBalance > 0) {
                this.balance = initialBalance;
            } else {
                this.balance = 0;
            }
        }

        //& Public method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("/* Deposit Successful! New Balance: " + balance + " */");
            } else {
                System.out.println("/* Deposit amount must be positive. */");
            }
        }

        //& Public method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("/* Withdrawal Successful! New Balance: " + balance + " */");
            } else {
                System.out.println("/* Invalid withdrawal amount or insufficient funds. */");
            }
        }

        //& Public "getter" method to view the balance
        public double getBalance() {
            return balance;
        }
    }


    
    //~ 2, 3, & 4. ABSTRACTION, INHERITANCE, AND POLYMORPHISM
    
    //& We use an 'Animal' hierarchy to demonstrate these three concepts together.

    //*** ABSTRACTION ***//
    //& 'Animal' is an abstract class. It cannot be instantiated.
    //& It contains an abstract method 'makeSound()', which has no implementation.
    //& This forces any subclass of Animal to provide its own implementation for makeSound().
    static abstract class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        //& Abstract method (does not have a body)
        public abstract void makeSound();

        //& Concrete method
        public void sleep() {
            System.out.println(name + " is sleeping... Zzz");
        }

        public String getName() {
            return name;
        }
    }

    //*** INHERITANCE ***//
    //& The 'Dog' class inherits from the 'Animal' class using the 'extends' keyword.
    //& It gets all the non-private fields and methods from Animal (like name, sleep(), getName()).
    static class Dog extends Animal {
        public Dog(String name) {
            //& 'super(name)' calls the constructor of the parent class (Animal)
            super(name);
        }

        //*** POLYMORPHISM (Method Overriding) ***//
        //& The Dog class provides its own specific implementation for the abstract makeSound() method.
        //& The @Override annotation is good practice to indicate that we are overriding a parent method.
        @Override
        public void makeSound() {
            System.out.println(getName() + " says: Woof Woof!");
        }
    }

    //& The 'Cat' class also inherits from 'Animal'.
    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        //& The Cat class provides its own version of makeSound().
        @Override
        public void makeSound() {
            System.out.println(getName() + " says: Meow!");
        }
    }


    
    //~ A SIMPLE CLASS & OBJECT (From original file)
    
    static class Car {
        String company;
        String model;
        int year;

        //! Constructor: A special method to initialize objects
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

        System.out.println("\n//*** 1. DEMONSTRATING ENCAPSULATION ***//");
        //& Creating an instance of BankAccount. We can't access 'balance' directly.
        BankAccount myAccount = new BankAccount(500.00);
        // System.out.println(myAccount.balance); //! This would cause a compile error!

        System.out.println("Initial Balance: " + myAccount.getBalance());
        myAccount.deposit(200.00);
        myAccount.withdraw(150.00);
        myAccount.withdraw(1000.00); // This will fail
        System.out.println("Final Balance: " + myAccount.getBalance());


        System.out.println("\n//*** 2, 3, & 4. DEMONSTRATING ABSTRACTION, INHERITANCE, AND POLYMORPHISM ***//");
        // Animal myAnimal = new Animal("generic"); //! This would cause a compile error because Animal is abstract.

        //*** POLYMORPHISM IN ACTION ***//
        //& We can create a reference of the parent type (Animal) and point it to a child object (Dog or Cat).
        Animal myDog = new Dog("Buddy");
        Animal myCat = new Cat("Whiskers");

        //& When we call makeSound(), Java determines at runtime which specific version of the method to run.
        myDog.makeSound(); // Calls the Dog's version of makeSound()
        myCat.makeSound(); // Calls the Cat's version of makeSound()

        myDog.sleep(); // Calls the method from the parent Animal class
        myCat.sleep();


        System.out.println("\n//*** A SIMPLE CLASS & OBJECT ***//");
        Car myCar = new Car("Ferrari", "F50", 2022);
        myCar.displayDetails();


        System.out.println("\n//*** DEMONSTRATING STATIC MEMBERS (from FriendsOOPS.java) ***//");
        //& 'numberOfFriends' is a static variable, shared among all objects of the FriendsOOPS class.
        FriendsOOPS friend1 = new FriendsOOPS("Mikky");
        FriendsOOPS friend2 = new FriendsOOPS("Yuvraj");
        System.out.println("Friend 1: " + friend1.name);
        System.out.println("Friend 2: " + friend2.name);
        //& We access the static variable using the class name itself.
        System.out.println("Total number of friends created: " + FriendsOOPS.numberOfFriends);


        System.out.println("\n//*** DEMONSTRATING CLASS FROM ANOTHER FILE (from secondOOPS.java) ***//");
        secondOOPS obj = new secondOOPS();
        System.out.println("Sum from secondOOPS object: " + (obj.x + obj.y));
    }
}
