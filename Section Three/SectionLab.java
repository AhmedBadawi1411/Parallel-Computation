import java.util.ArrayList;
import java.util.List;

public class SectionLab {
    public static void main(String[] args) {
        List<Runnable> tasks = new ArrayList<>();
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE ONE");
        });
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE TWO");
        });
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE THREE");
        });
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE FOUR");
        });
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE FIVE");
        });
        tasks.add(() -> {
            System.out.println("HI I AM RUNNABLE SIX");
        });
        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        multiExecutor.executeAll();
    }
}

/**
 * * a class that executes a list of tasks in parallel using multiple threads
 * * using one thread per task
 */
class MultiExecutor {
    List<Runnable> tasksList;
    int COUNTER = 0;

    MultiExecutor(List<Runnable> taskList) {
        if (taskList == null) {
            this.tasksList = new java.util.ArrayList<>();
        } else {
            this.tasksList = taskList;
        }
    }

    public void executeAll() {
        if (tasksList.size() < 1) {
            System.out.println("There is no tasks to execute!");
            return;
        }

        for (Runnable task : tasksList) {
            COUNTER++;
            Thread thread = new Thread(task, "TASK" + COUNTER);
            thread.start();
            System.out.println("TASK" + COUNTER + "STARTING...");
        }
    }
}