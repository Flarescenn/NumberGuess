import javax.swing.*;
import java.util.Random;

public class GameController {

    private GameLogic gameLogic;
    private JTextField guessField;


    public GameController(GameLogic gameLogic, JTextArea feedbackArea) {
       this.gameLogic=gameLogic;

    }
    public void startGame(JTextArea feedbackArea) {
        gameLogic.attemptsUsed = 0;
    }
    public void promptForGuess(JTextArea feedbackArea) {
        String guessString = JOptionPane.showInputDialog("Guess a number between 0 and 15:");
        if (guessString != null) {
            try {
                int guessedNumber = Integer.parseInt(guessString);
                if (guessedNumber < 0 || guessedNumber > 15) {
                    throw new IllegalArgumentException();
                }
                handleGuess(guessedNumber, feedbackArea); // Pass the guess to handleGuess
            } catch (NumberFormatException ex) {
                feedbackArea.setText("Invalid Input");
                promptForGuess(feedbackArea);
            } catch (IllegalArgumentException e) {
            feedbackArea.setText("Please enter a number between 0 and 15.");
            promptForGuess(feedbackArea);
        }
        }}
        public void handleGuess(int guessedNumber, JTextArea feedbackArea) {
            boolean guessBool = gameLogic.guess(guessedNumber);
            if (guessBool) {
                feedbackArea.setText("Congratulations! You guessed the number in " + gameLogic.getAttemptsUsed() + " attempts!");
                //guessField.setEnabled(false); // Disable guess field after winning
            } else {
                if (gameLogic.getAttemptsUsed() >= gameLogic.getMaxAttempts()) {
                    feedbackArea.setText("Out of attempts! The number was: " + gameLogic.getCorrectGuess());
                    //guessField.setEnabled(false); // Disable guess field after losing
                } else {
                    feedbackArea.setText(guessBool ? "Your guess is correct!" :
                            (guessedNumber < gameLogic.getCorrectGuess() ? "Your guess is lower.": "Your guess is higher."));
                    promptForGuess(feedbackArea);
                }
            }

    }
}