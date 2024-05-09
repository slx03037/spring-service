package com.shenlx.xinwen.leaf.segment.model;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author shenlx
 * @description
 * @date 2024/5/9 15:04
 */
public class Segment {
    private AtomicLong value = new AtomicLong(0);

    private volatile long max;

    private volatile int step;

    private final SegmentBuffer buffer;

    public Segment(SegmentBuffer buffer) {
        this.buffer = buffer;
    }

    public AtomicLong getValue() {
        return value;
    }

    public void setValue(AtomicLong value) {
        this.value = value;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public SegmentBuffer getBuffer() {
        return buffer;
    }

    public long getIdle() {
        return this.getMax() - getValue().get();
    }

    @Override
    public String toString() {
        String sb = "Segment(" + "value:" +
                value +
                ",max:" +
                max +
                ",step:" +
                step +
                ")";
        return sb;
    }
}
