public class SectionThree {
    public static void main(String[] args) {
        // ************************* TOPIC ONE: Thread Naming *************************//
        // ! 1- By Passing Name On Creation
        Thread t1 = new Thread("First Thread");
        // System.out.println(t1.getName());

        // ! 2- Using setName() Method
        t1.setName("First Thread New Name");
        // System.out.println(t1.getName());

        // ! 3- Will Passing Runnable Task - Looks like first one.
        Runnable task2 = () -> System.out.println("Runnable Task 2");
        Runnable task3 = () -> System.out.println("Runnable Task 3");
        // @params: runnable, thread name;
        Thread t2 = new Thread(task2, "Runnable Thread2");
        Thread t3 = new Thread(task3, "Runnable Thread3");

        // ************************* TOPIC TWO: Thread Priority *************************//
        /*
         * ? Determines Which Thread Should Be Executed First When Multiple Threads are
         * ready to execute
         * ? Max Priority Value is 10 and lowest one is 1
         * ? Default Priority is 5
         */
        // ! NOTE: setPriority() has no effect if we call it after start() but there is
        // not Syntax Error
        // ! GOLDEN NOTE: Not Guaranteed
        t2.setPriority(1);
        t3.setPriority(10);

        t2.start();
        t3.start();

        // ************************* TOPIC THREE: Thread States *************************//
        Thread threadState = new Thread(() -> {
            System.out.println("State Inside run(): " + Thread.currentThread().getState());
        });

        // ? State After Creating Thread Before start()
        System.out.println("Thread State Before Start: " + threadState.getState());
        threadState.start();

        // ? State After Starting
        System.out.println("Thread State After Start: " + threadState.getState());

        // ? State After Finishing
        try {
            threadState.join();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Thread State After Finishing: " + threadState.getState());

        // ************************* TOPIC FOUR: Thread Group *************************//
        // ? Used For Organization and hierarchical thread management

        // Decaler Thread group using ThreadGroup class;
        ThreadGroup group = new ThreadGroup("Group One");
        Thread thread1 = new Thread(group, () -> {
            System.out.println("HELLO FROM THREAD " + Thread.currentThread().getName());
        }, "Thread One");
        Thread thread2 = new Thread(group, () -> {
            System.out.println("HELLO FROM THREAD " + Thread.currentThread().getName());
        }, "Thread Two");
        Thread thread3 = new Thread(group, () -> {
            System.out.println("HELLO FROM THREAD " + Thread.currentThread().getName());
        }, "Thread Three");

        /*
         ? Now, We Know The Params Of Thread Constructor
         @First Param is Threads Group its default value is null.
         @Secound Param is Runnable Method or Instance from class which extends Threador implements Runnable.
         @Third Param is Thread Name.
        */

        thread1.start();
        thread2.start();
        thread3.start();

        // ! THREAD GROUP HAS SOME HELPFULL METHODS
        group.activeCount();
        group.list();

        // ******************** USER THREAD EXAMPLE ************************** //
        Thread userThread = new Thread(()->{
            System.out.println("THIS IS USER THREAD!");
        });
        userThread.start();

        // ******************** DAEMON THREAD EXAMPLE ************************** //
        Thread daemon = new Thread(()->{
            try {
                Thread.sleep(5000);
                System.out.println("THIS IS DAEMON THREAD");
            } catch (InterruptedException e) {
                System.out.println("EN ERROR OCCURED ON DAEMON THREAD");
            }
        });

        // ! we can make daemon thread using setDaemon(true)
        daemon.setDaemon(true);
        daemon.start();
    }
}
