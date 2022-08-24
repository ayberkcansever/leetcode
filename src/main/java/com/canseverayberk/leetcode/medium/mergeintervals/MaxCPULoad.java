package com.canseverayberk.leetcode.medium.mergeintervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxCPULoad {

    public static void main(String[] args) {
        Job job1 = new Job(1, 4, 3);
        Job job2 = new Job(2, 5, 4);
        Job job3 = new Job(7, 9, 6);
        int maxCPULoad = findMaxCPULoad(new ArrayList<>(List.of(job1, job2, job3)));
    }

    public static int findMaxCPULoad(List<Job> jobs) {
        int maxCpu = 0;

        jobs.sort(Comparator.comparing(job -> job.start));

        for (int i = 0; i < jobs.size(); i++) {
            Job job1 = jobs.get(i);
            int max = job1.cpuLoad;
            for (int j = i + 1; j < jobs.size(); j++) {
                Job job2 = jobs.get(j);

                if (intersects(job1, job2)) {
                    max += job2.cpuLoad;
                }

            }
            maxCpu = Math.max(maxCpu, max);
        }

        return maxCpu;
    }

    private static boolean intersects(Job job1, Job job2) {
        int lo = Math.max(job1.start, job2.start);
        int hi = Math.min(job1.end, job2.end);
        return lo < hi;
    }

    static class Job {
        int start;
        int end;
        int cpuLoad;

        public Job(int start, int end, int cpuLoad) {
            this.start = start;
            this.end = end;
            this.cpuLoad = cpuLoad;
        }
    }

}
