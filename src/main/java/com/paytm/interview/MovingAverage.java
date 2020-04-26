package com.paytm.interview;

import java.util.Queue;

public interface MovingAverage<T> {
    /**
     * Add one value to the queue and return the current moving average
     * @param value new value
     * @return moving average
     */
    Double next(T value);

    /**
     * Get the current data queue
     * @return the current queue
     */
    Queue<T> get();

    /**
     * Add one value to the queue
     * @param value new value
     */
    void add(T value);
}
