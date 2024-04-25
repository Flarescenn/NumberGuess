import java.util.Random;

public class GameLogic {

    private int correctGuess;
    private int maxAttempts;
    private int attemptsUsed;
    private int guessedNumber;

    public GameLogic(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        correctGuess = new Random().nextInt(15) + 1; // Generate random number between 1 and 15 (inclusive)
        attemptsUsed = 0;
    }

    public boolean guess(int number) {
        attemptsUsed++;
        this.guessedNumber=number;
        if (guessedNumber == correctGuess) {
            return true;

        } else if ( guessedNumber < correctGuess) {
            System.out.println("Your guess is lower"); //Jlabel
            return false;
        } else {
            System.out.println("Your guess is higher");
            return false;
        }
    }

    public int getAttemptsUsed() {
        return attemptsUsed;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getCorrectGuess() {
        return correctGuess; // Reveal the answer only after all attempts are used
    }
}
