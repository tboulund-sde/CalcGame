package gui;

import javafx.beans.property.*;

import java.util.Random;

public class GameModel {

    private String[] operators = new String[]{"+", "-"};
    private Random random = new Random();

    private SimpleIntegerProperty number1 = new SimpleIntegerProperty();
    private SimpleIntegerProperty number2 = new SimpleIntegerProperty();
    private StringProperty operator = new SimpleStringProperty();
    private BooleanProperty isGameOver = new SimpleBooleanProperty();
    private StringProperty guess = new SimpleStringProperty();
    private IntegerProperty score = new SimpleIntegerProperty();

    public void start()
    {
        getIsGameOver().set(false);
        prepareQuestion();
    }

    private void prepareQuestion()
    {
        getOperator().set(getOperators()[getRandom().nextInt(getOperators().length)]);
        getNumber1().set(getRandom().nextInt(10 * (getScore().get()+1)+1));
        getNumber2().set(getRandom().nextInt(10 * (getScore().get()+1)+1));
        getGuess().set("");
    }

    public void checkGuess() {
        double result = 0;
        switch (getOperator().get()) {
            case ("+"):
                result = getNumber1().get() + getNumber2().get();
                break;
            case "-":
                result = getNumber1().get() - getNumber2().get();
                break;
        }

        if (result == Double.parseDouble(getGuess().get()))
        {
            increaseScore();
            prepareQuestion();
        }
        else
        {
            getIsGameOver().set(true);
        }
    }

    private void increaseScore()
    {
        getScore().set(getScore().get() + 1);
    }

    public String[] getOperators() {
        return operators;
    }

    public Random getRandom() {
        return random;
    }

    public IntegerProperty getNumber1() {
        return number1;
    }

    public IntegerProperty getNumber2() {
        return number2;
    }

    public StringProperty getOperator() {
        return operator;
    }

    public BooleanProperty getIsGameOver() {
        return isGameOver;
    }

    public StringProperty getGuess() {
        return guess;
    }

    public IntegerProperty getScore() {
        return score;
    }
}
