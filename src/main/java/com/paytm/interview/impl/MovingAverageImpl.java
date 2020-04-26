package com.paytm.interview.impl;

import com.paytm.interview.MovingAverage;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageImpl implements MovingAverage<Integer> {
    private Queue<Integer> queue;
    private int maxSize;

    MovingAverageImpl(int windowSize) {
        if (windowSize < 1)
            throw new IllegalArgumentException("Windows size needs to be greater than 0");
        queue = new LinkedList<Integer>();
        maxSize = windowSize;
    }

    @Override
    public Double next(Integer value) {
        this.add(value);
        return getAverage();
    }

    private Double getAverage() {
        Double sum = 0.0;
        for (Integer x : queue) {
            sum += x;
        }
        return sum / queue.size();
    }

    @Override
    public Queue<Integer> get() {
        return this.queue;
    }

    @Override
    public void add(Integer value) {
        if (queue.size() >= maxSize) {
            queue.poll();
        }
        queue.offer(value);
    }
}
