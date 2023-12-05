package org.example.task1;

public class Trench {
    private double targetLength;
    private double currentLength;

    public Trench(double targetLength, double currentLength) {
        this.targetLength = targetLength;
        this.currentLength = currentLength;
    }

    public void setCurrentLength(double currentLength) {
        this.currentLength = currentLength;
    }

    public double getTargetLength() {
        return targetLength;
    }

    public double getCurrentLength() {
        return currentLength;
    }
}
