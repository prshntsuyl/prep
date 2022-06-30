import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

    static class Task {
        int priority;
        String description;

        Task(int priority, String description) {
            this.priority = priority;
            this.description = description;
        }
    }

    public static void main(String[] args) {
        System.out.println("!!!");

        PriorityQueue<Task> task = new PriorityQueue<>(5, Comparator.comparingInt(t -> (-1) * t.priority));
        task.add(new Task(0, "task0!!!"));
        task.add(new Task(5, "task5!!!"));
        task.add(new Task(6, "task6!!!"));
        task.add(new Task(2, "task2!!!"));

        Task head = task.poll();
        System.out.println(head.description);
    }   
}
