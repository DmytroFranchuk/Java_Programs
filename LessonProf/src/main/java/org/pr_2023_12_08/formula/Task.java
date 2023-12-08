package org.pr_2023_12_08.formula;

import lombok.Getter;

import java.util.Optional;

@Getter
public class Task {
    private final int low;

    private final int high;

    private Double result;

    public Task(int low, int high) {
        this.low = low;
        this.high = high;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public Optional<Double> getResult() {
        return Optional.ofNullable(result);
    }

    @Override
    public String toString() {
        return "Task{" +
                "low=" + low +
                ", high=" + high +
                ", result=" + result +
                '}';
    }
}
