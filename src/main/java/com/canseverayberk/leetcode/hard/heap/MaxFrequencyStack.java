package com.canseverayberk.leetcode.hard.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
https://leetcode.com/problems/maximum-frequency-stack/
 */
public class MaxFrequencyStack {

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(1);
        freqStack.push(0);
        freqStack.push(0);
        freqStack.push(1);
        freqStack.push(5);
        freqStack.push(4);
        freqStack.push(1);
        freqStack.push(5);
        freqStack.push(1);
        freqStack.push(6);
        int pop1 = freqStack.pop();
        int pop2 = freqStack.pop();
        int pop3 = freqStack.pop();
        int pop4 = freqStack.pop();
        int pop5 = freqStack.pop();
        int pop6 = freqStack.pop();
        int pop7 = freqStack.pop();
        int pop8 = freqStack.pop();
        int pop9 = freqStack.pop();
        int pop10 = freqStack.pop();
    }

    static class FreqStack {
        int seq = 0;
        PriorityQueue<Freq> heap;
        Map<Integer, Integer> map;

        public FreqStack() {
            heap = new PriorityQueue<>((e1, e2) -> {
                if (e1.freq != e2.freq)
                    return e2.freq - e1.freq;
                return e2.seq - e1.seq;
            });
            map = new HashMap<>();
        }

        public void push(int val) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            heap.offer(new Freq(val, map.get(val), seq++));
        }

        public int pop() {
            Freq freq = heap.poll();
            map.put(freq.val, freq.freq - 1);
            return freq.val;
        }

        class Freq {
            int val;
            int freq;
            int seq;

            public Freq(int val, int freq, int seq) {
                this.val = val;
                this.freq = freq;
                this.seq = seq;
            }
        }
    }
}
