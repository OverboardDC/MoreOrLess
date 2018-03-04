package com.training.homework;

import java.util.ArrayList;

public class Model {

    private int number;
    private int attemptNumber;
    private ArrayList<Attempt> stats;
    private int minLimit;
    private int maxLimit;

    public void generateRandomNum() {
        number = (int) Math.ceil(Math.random() *
                        (maxLimit - minLimit - 1) + minLimit);
    }

    public Attempt makeAttempt(int inputValue) {
        if (stats == null) {
            stats = new ArrayList<>();
        }
        ResultType result = getResultType(inputValue);
        attemptNumber++;
        Attempt attempt = new Attempt(attemptNumber, inputValue, result, minLimit, maxLimit);
        stats.add(attempt);
        return attempt;
    }

    private ResultType getResultType(int inputValue) {
        ResultType result;
        if (inputValue == number) {
            result = ResultType.TRUE_VALUE;
        } else if (inputValue > number) {
            result = ResultType.LESS;
            maxLimit = inputValue;
        } else {
            result = ResultType.MORE;
            minLimit = inputValue;
        }
        return result;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Attempt> getStatistics() {
        return stats;
    }

    public int getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(int minLimit) {
        this.minLimit = minLimit;
    }

    public int getMaxLimit() {
        return maxLimit;
    }

    public void setMaxLimit(int maxLimit) {
        this.maxLimit = maxLimit;
    }
}
