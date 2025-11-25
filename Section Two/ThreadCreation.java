/*
* There are two ways to create Threads in Java 
* FIRST ONE : Extends Thead Class
*/

// * First Way:
class Threader extends Thread {
    private String threadName;

    Threader(String threadName) {
        this.threadName = threadName;
    }

    // ! In this way we have to override run method from Thread Class
    @Override
    public void run() {
        System.out.println("Message From " + this.threadName);
    }
}

// * Second Way:
class Runner implements Runnable {
    @Override
    public void run() {
        System.out.println("Message From Runner Class");
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        // ! Create Thread From Threader Class Which extends Thread class.
        Threader threadOne = new Threader("First Thread");
        threadOne.start();

        // ! In the seconed way we can create thread by passing Runnable to Thread class
        // ! 1- using Anonymos class
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Message from Anonymous Runnable");
            }
        };

        Thread threadTwo = new Thread(task);
        threadTwo.start();

        // ! 2- using Lambda
        Runnable task2 = () -> {
            System.out.println("Message from Lambda Runnable");
        };

        Thread threadThree = new Thread(task2);
        threadThree.start();

        // ! 3- using class which implements runnable interface
        Runnable task3 = new Runner();
        Thread threadFour = new Thread(task3);
        threadFour.start();
    }

}
