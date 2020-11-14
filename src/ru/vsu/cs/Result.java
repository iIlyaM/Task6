package ru.vsu.cs;

public class Result {
    private double sum;
    private int iteration;

    public Result(double sum, int iteration) {
        this.sum = sum;
        this.iteration = iteration;
    }

    public double getSum() {
        return sum;
    }

    public int getIteration() {
        return iteration;
    }
}
