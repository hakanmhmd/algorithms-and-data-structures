package Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z
 * where different letters represent different tasks.Tasks could be done without original order.
 * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks,
 * there must be at least n intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 */
public class TaskScheduler {
    static class Task {
        char taskName;
        int numberOfInstances;

        public Task(char taskName, int numberOfInstances) {
            this.taskName = taskName;
            this.numberOfInstances = numberOfInstances;
        }
    }

    public static void main(String[] args) {
        char[] tasks = new char[]{'A','A','A','A','B','C', 'D', 'D', 'E'};
        int n = 3;
        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> queue = new PriorityQueue<>((o1, o2) -> o2.numberOfInstances - o1.numberOfInstances);

        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        for (int i = 0; i < map.length; i++) {
            int count = map[i];
            if(count > 0) queue.offer(new Task((char) ((int) 'A' + i),count));
        }

        int time = 0;
        while(!queue.isEmpty()){
            int i=0;
            List<Task> temp = new ArrayList<>();
            while(i<=n){
                if(!queue.isEmpty()){
                    Task task = queue.poll();
                    if(task.numberOfInstances > 1){
                        task.numberOfInstances--;
                        temp.add(task);
                    }
                    System.out.println("Execute " + task.taskName);
                } else {
                    System.out.println("IDLE");
                }
                time++;
                if(queue.isEmpty() && temp.size() == 0) break;
                i++;
            }
            for (Task task : temp) {
                queue.offer(task);
            }
        }

        return time;
    }
}
