package com.canseverayberk.leetcode.medium.heap;

import java.util.*;

/*
https://leetcode.com/problems/task-scheduler
 */
public class TaskScheduler {

    public static void main(String[] args) {
        char[] tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int leastInterval = leastInterval(tasks, 2);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char num : tasks) {
            int count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }

        PriorityQueue<Num> queue = new PriorityQueue<>((a, b) -> b.count - a.count > 0 ? 1 : -1);
        for (char key : map.keySet()) {
            queue.offer(new Num(key, map.get(key)));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Queue<Num> wait = new LinkedList<>();
            int maxProcess = n + 1;
            while (maxProcess > 0) {
                Num nb = queue.poll();
                if (nb == null)
                    break;
                count++;
                maxProcess--;
                nb.count--;
                if (nb.count > 0)
                    wait.offer(nb);
            }

            queue.addAll(wait);

            if (!queue.isEmpty())
                count += maxProcess;
        }

        return count;
    }

    static class Num {
        char val;
        int count;

        public Num(char val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
