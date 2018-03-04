package com.training.homework;

import java.util.Scanner;

public class Controller {

    private Model model;
    private View view;
    private Scanner scanner;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        scanner = new Scanner(System.in);
        view.printGreeting();
        setRanges();
        model.generateRandomNum();
        view.printGuessNumber(model);
        startGameLoop(model.getNumber());
    }


    private void setRanges(){
        int min, max;
        do {
            min = setMinRange();
            max = setMaxRange();
            checkRangeDistance(min, max);
        } while (max - min < GlobalConstants.MIN_RANGE_DISTANCE);
        model.setMinLimit(min);
        model.setMaxLimit(max);
    }

    private void checkRangeDistance(int min, int max) {
        if(max - min < GlobalConstants.MIN_RANGE_DISTANCE) {
            view.printWrongSettingRange();
        }
    }

    private int setMinRange() {
        view.printSetMinLimit();
        checkInputType();
        return scanner.nextInt();
    }

    private int setMaxRange() {
        view.printSetMaxLimit();
        checkInputType();
        return scanner.nextInt();
    }

    private void startGameLoop(int number) {
        int inputNumber;
        do {
            inputNumber = scanValue();
            Attempt attempt = model.makeAttempt(inputNumber);
            compareNumbers(number, inputNumber, attempt);
        } while (inputNumber != number);
        view.printWinMessage();
        view.printFullStatistics(model.getStatistics());
    }

    private void compareNumbers(int number, int inputNumber, Attempt attempt) {
        if (inputNumber != number) {
            view.printGameInfoMessage(attempt);
        }
    }

    private int scanValue() {
        int inputValue;
        do {
            checkInputType();
            inputValue = scanner.nextInt();
            checkInputLimits(inputValue);
        } while (inputValue <= model.getMinLimit() || inputValue >= model.getMaxLimit());

        return inputValue;
    }

    private void checkInputLimits(int inputValue) {
        if (inputValue <= model.getMinLimit() || inputValue >= model.getMaxLimit()) {
            view.printWrongRange(model);
        }
    }

    private void checkInputType() {
        while (!scanner.hasNextInt()) {
            view.printWrongInput();
            scanner.next();
        }
    }
}
