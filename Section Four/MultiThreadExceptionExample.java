public class MultiThreadExceptionExample {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Worker worker2 = new Worker();
        Worker worker3 = new Worker();

        // worker1.start();
        // worker2.start();
        // worker3.start();

        // !UNCAUGHT EXCEPTION HANDLER
        Thread t1 = new Thread(() -> {
            System.out.println("THREAD ONE");
            int res = 10 / 0;
        });

        t1.setUncaughtExceptionHandler((thread, e) -> {
            System.out.println("Exception in " + thread.getName() + ": " + e.getMessage());
        });

        // t1.start();

        // !DEFAULT UNCAUGHT EXCEPTION HANDLER
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("GLOBAL HANDLER CAUGHT EXCEPTION IN: " + t.getName());
            System.out.println("ERROR: " + e.getMessage());
        });

        Thread t2 = new Thread(()->{
            throw new RuntimeException("Thread Crashed!");
        });
        Thread t3 = new Thread(()->{
            throw new ArithmeticException("Division by zero!");
        });

        t2.start();
        t3.start();
    }
}

class Worker extends Thread {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + "STARTED.");
            int res = 10 / 0;
        } catch (Exception e) {
            System.out.println(Thread.currentThread().getName() + "CAUGHT: " + e);
        }
        System.out.println(Thread.currentThread().getName() + "FINISHED.");
    }
}
