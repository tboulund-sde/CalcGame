package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.util.Random;

public class GameController {
    private GameModel game = new GameModel();

    @FXML
    private Label lblNumber1;

    @FXML
    private Label lblNumber2;

    @FXML
    private Label lblOperator;

    @FXML
    private Label lblGameOver;

    @FXML
    private TextField txtGuess;

    @FXML
    private Button btnGuess;

    @FXML
    private Label lblScore;

    public void initialize() {
        lblNumber1.textProperty().bind(game.getNumber1().asString());
        lblNumber2.textProperty().bind(game.getNumber2().asString());
        lblOperator.textProperty().bind(game.getOperator());
        lblScore.textProperty().bind(game.getScore().asString());
        txtGuess.textProperty().bindBidirectional(game.getGuess());

        btnGuess.disableProperty().bind(game.getIsGameOver());
        txtGuess.disableProperty().bind(game.getIsGameOver());
        lblGameOver.visibleProperty().bind(game.getIsGameOver());

        game.start();
    }

    @FXML
    private void guess() {
        game.checkGuess();
    }
}