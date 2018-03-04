package com.training.homework;

public class Attempt {

    private int number;
    private int inputValue;
    private ResultType result;
    private int minLimit;
    private int maxLimit;

    public Attempt(int number, int inputValue, ResultType result, int minLimit, int maxLimit) {
        this.number = number;
        this.inputValue = inputValue;
        this.result = result;
        this.minLimit = minLimit;
        this.maxLimit = maxLimit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getInputValue() {
        return inputValue;
    }

    public void setInputValue(int inputValue) {
        this.inputValue = inputValue;
    }

    public ResultType getResult() {
        return result;
    }

    public void setResult(ResultType result) {
        this.result = result;
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
