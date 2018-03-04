package com.training.homework;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class View {

    //Resource bundle installation
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale(""));

    //Output constants
    public static final String GREETING = "greeting";
    public static final String SET_MIN_LIMIT = "set.min.limit";
    public static final String SET_MAX_LIMIT = "set.max.limit";
    public static final String WRONG_SETTING_RANGE = "wrong.setting.range";
    public static final String GUESS_NUMBER = "guess.number";
    public static final String YOU_WON = "you.won";
    public static final String WRONG_INPUT = "wrong.input";
    public static final String WRONG_RANGE = "wrong.range";
    public static final String STATS = "stats";

    public static final String ATTEMPT_NUMBER = "attempt.number";
    public static final String TYPED_NUMBER = "typed.number";
    public static final String MESSAGE = "result.message";
    public static final String RANGE = "range.message";

    public static final String LEFT_CLOSING_BRACKET = "[";
    public static final String RIGHT_CLOSING_BRACKET = "]";
    public static final String WHITE_SPACE = " ";
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameInfoMessage(Attempt attempt) {
        printInfoMessage(bundle.getString(ATTEMPT_NUMBER), WHITE_SPACE, Integer.toString(attempt.getNumber()), COMMA, WHITE_SPACE,
                bundle.getString(TYPED_NUMBER), WHITE_SPACE, Integer.toString(attempt.getInputValue()), COMMA, WHITE_SPACE,
                bundle.getString(MESSAGE), WHITE_SPACE, attempt.getResult().toString(), COMMA, WHITE_SPACE, bundle.getString(RANGE),
                WHITE_SPACE, getRangeLimits(attempt.getMinLimit(), attempt.getMaxLimit()));
    }

    public void printFullStatistics(List<Attempt> stats) {
        printInfoMessage(NEW_LINE, bundle.getString(STATS));
        for (Attempt attempt : stats) {
            printGameInfoMessage(attempt);
        }
    }

    public void printGreeting() {
        printInfoMessage(bundle.getString(GREETING));
    }

    public void printSetMinLimit(){
        printInfoMessage(bundle.getString(SET_MIN_LIMIT));
    }

    public void printSetMaxLimit(){
        printInfoMessage(bundle.getString(SET_MAX_LIMIT));
    }

    public void printWrongSettingRange(){
        printInfoMessage(bundle.getString(WRONG_SETTING_RANGE), WHITE_SPACE, Integer.toString(GlobalConstants.MIN_RANGE_DISTANCE));
    }

    public void printGuessNumber(Model model){
        printInfoMessage(bundle.getString(GUESS_NUMBER), WHITE_SPACE, getRangeLimits(model));
    }

    public void printWrongRange(Model model) {
        printInfoMessage(bundle.getString(WRONG_RANGE), WHITE_SPACE, getRangeLimits(model));
    }

    public void printWrongInput() {
        printInfoMessage(bundle.getString(WRONG_INPUT));
    }

    public void printWinMessage() {
        printInfoMessage(bundle.getString(YOU_WON));
    }

    private void printInfoMessage(String... strings) {
        printMessage(concatenateString(strings));
    }

    private String getRangeLimits(Model model) {
        return concatenateString(LEFT_CLOSING_BRACKET, Integer.toString(model.getMinLimit()),
                COMMA, Integer.toString(model.getMaxLimit()), RIGHT_CLOSING_BRACKET);
    }

    private String getRangeLimits(int minRange, int maxRange) {
        return concatenateString(LEFT_CLOSING_BRACKET, Integer.toString(minRange),
                COMMA, Integer.toString(maxRange), RIGHT_CLOSING_BRACKET);
    }

    private String concatenateString(String... strings) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str);
        }
        return new String(stringBuilder);
    }
}
