//TODO: Threading and Multihreading


//! A thread is the smallest unit of execution in a program. A program can have one or more threads.
//* Multithreading is when multiple threads are executed concurrently, allowing a program to perform multiple tasks at the same time.
//& This is useful for running background tasks, handling multiple user requests, or improving performance on multi-core processors.

//! METHOD 1: Extending the Thread class
//& Easiest way to create a thread. You create a class that inherits from `java.lang.Thread`.
//* Limitation: Since Java does not support multiple inheritance, this class cannot extend any other class.

class MyThread extends Thread {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    //& The run() method contains the code that will be executed by the new thread.
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + " - Count: " + i);
            try {
                //& Thread.sleep() pauses the thread for a specified time, simulating work.
                Thread.sleep(500); // 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println(threadName + " was interrupted.");
            }
        }
        System.out.println(threadName + " has finished executing.");
    }
}

//! METHOD 2: Implementing the Runnable interface (PREFERRED METHOD)
//& This is more flexible because your class can still extend another class.
//* It separates the task (the `Runnable`) from the execution mechanism (the `Thread`).

class MyRunnable implements Runnable {
    private String runnableName;

    public MyRunnable(String runnableName) {
        this.runnableName = runnableName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(runnableName + " - Count: " + i);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                System.out.println(runnableName + " was interrupted.");
            }
        }
        System.out.println(runnableName + " has finished executing.");
    }
}

//~ PROBLEM: RACE CONDITION
//& A race condition occurs when multiple threads access and manipulate shared data concurrently,
//* Causing conflicts and the final result depends on the unpredictable timing of their execution.

class Counter {
    private int count = 0;

    //& This method is NOT thread-safe.
    public void increment() {
        count++; // This is not an atomic(single step) operation. It's actually three steps:
                 // 1. Read the current value of 'count'.
                 // 2. Add 1 to the value.
                 // 3. Write the new value back to 'count'.
                 // Threads can interrupt each other between these steps, causing lost updates.
    }

    public int getCount() {
        return count;
    }
}

//~ SOLUTION: SYNCHRONIZATION
//& To prevent race conditions, we can use the `synchronized` keyword.
//* A synchronized method can only be executed by one thread at a time for a given object instance.

class SynchronizedCounter {
    private int count = 0;

    //& This method IS thread-safe.
    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class Threading {
    public static void main(String[] args) throws InterruptedException {
        
        MyThread thread1 = new MyThread("Thread-A (extends Thread)");
        
        // To use a Runnable, you create an instance of it and pass it to a new Thread object.
        MyRunnable myRunnable = new MyRunnable("Runnable-B (implements Runnable)");
        Thread thread2 = new Thread(myRunnable);

        //& The start() method begins the execution of the thread. The JVM calls the run() method.
        thread1.start();
        thread2.start();

        //& Wait for both threads to finish before continuing the main thread.
        thread1.join();
        thread2.join();

        //! Race Condition

        Counter unsafeCounter = new Counter();
        Thread t3 = new Thread(() -> { for (int i = 0; i < 10000; i++) unsafeCounter.increment(); });
        Thread t4 = new Thread(() -> { for (int i = 0; i < 10000; i++) unsafeCounter.increment(); });
        t3.start(); t4.start();
        t3.join(); t4.join();
        System.out.println("Unsafe Counter Final Value: " + unsafeCounter.getCount() + " (Expected 20000, but with race condition problem can be different values)");

        
        SynchronizedCounter safeCounter = new SynchronizedCounter();
        Thread t5 = new Thread(() -> { for (int i = 0; i < 10000; i++) safeCounter.increment(); });
        Thread t6 = new Thread(() -> { for (int i = 0; i < 10000; i++) safeCounter.increment(); });
        t5.start(); 
        t6.start();
        t5.join(); 
        t6.join();
        System.out.println("Safe Counter Final Value: " + safeCounter.getCount() + " (Expected 20000)");
    }
}