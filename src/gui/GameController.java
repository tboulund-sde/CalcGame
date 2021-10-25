package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.util.Random;

public class GameController {

    private String[] operators = new String[]{"+", "-", "*"};
    private Random random = new Random();

    @FXML
    private Label lblNumber1;

    @FXML
    private Label lblNumber2;

    @FXML
    private Label lblOperator;

    @FXML
    private Label lblGameOver;

    @FXML
    private TextField txtResult;

    @FXML
    private Button btnGuess;

    @FXML
    private Label lblScore;

    public void initialize() {
        prepareQuestion();
        lblScore.setText("0");
        lblGameOver.setVisible(false);
    }

    @FXML
    private void guess() {
        double number1 = Double.parseDouble(lblNumber1.getText());
        double number2 = Double.parseDouble(lblNumber2.getText());
        double guess = Double.parseDouble(txtResult.getText());
        double result = 0;
        switch (lblOperator.getText()) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        }

        if (guess == result) {
            increaseScore();
            prepareQuestion();
        } else {
            gameOver();
        }
    }

    private void prepareQuestion()
    {
        int score = Integer.parseInt(lblScore.getText());
        lblOperator.setText(operators[random.nextInt(operators.length)]);
        lblNumber1.setText(String.valueOf(random.nextInt(10 * (score+1))+1));
        lblNumber2.setText(String.valueOf(random.nextInt(10 * (score+1))+1));
        txtResult.setText("");
    }

    private void increaseScore()
    {
        int score = Integer.parseInt(lblScore.getText());
        score++;
        lblScore.setText(String.valueOf(score));
    }

    private void gameOver()
    {
        btnGuess.setDisable(true);
        txtResult.setDisable(true);
        lblGameOver.setVisible(true);
    }
}