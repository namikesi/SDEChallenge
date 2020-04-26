package com.paytm.interview.impl;


import com.paytm.interview.MovingAverage;
import org.junit.Assert;
import org.junit.Test;

public class MovingAverageImplTest {

    @Test
    public void next() {
        MovingAverage<Integer> movingAverage = new MovingAverageImpl(3);
        Assert.assertEquals(Double.compare(movingAverage.next(1), 1.0) , 0);
        Assert.assertEquals(Double.compare(movingAverage.next(5), 3.0), 0);
        Assert.assertEquals(Double.compare(movingAverage.next(3), 3.0), 0);
        Assert.assertEquals(Double.compare(movingAverage.next(30), 12.666666666666666), 0);

        movingAverage = new MovingAverageImpl(1);
        Assert.assertEquals(Double.compare(movingAverage.next(1), 1.0) , 0);
        Assert.assertEquals(Double.compare(movingAverage.next(5), 5.0), 0);
        Assert.assertEquals(Double.compare(movingAverage.next(3), 3.0), 0);
        Assert.assertEquals(Double.compare(movingAverage.next(30), 30), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nextWithException() {
        new MovingAverageImpl(-1);
    }

    @Test
    public void get_add_test() {
        int windowSize = 3;
        MovingAverage<Integer> movingAverage = new MovingAverageImpl(windowSize);
        movingAverage.add(1);
        movingAverage.add(1);
        movingAverage.add(1);
        movingAverage.add(1);
        movingAverage.add(1);
        Assert.assertEquals(movingAverage.get().size() , windowSize);
    }


}