//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Random;
import java.util.Scanner;

public class Mainside {
    public static void main(String[] args) {

        Random Number_Generated = new Random();
        int CorrectGuess = Number_Generated.nextInt(15);
        int NumberTried = 0;
        int NumberGuessed;
        int Max_Attempts = 5; // This is the Maximum Number of attempts

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        String user = scanner.nextLine();

        // validation to prompt user to input their name before starting the game.
        while (user.isEmpty()) {
            System.out.println("Please enter your name:");
            user = scanner.nextLine();
        }

        System.out.println("Hello " + user + "! Welcome to the guessing game.\nYou'll only have 5 chances to guess the correct number."); //welcome message

        for (int i = 1; i <= Max_Attempts; i++) {
            System.out.println("Guess a number between 0 and 15:");
            NumberGuessed = scanner.nextInt();
            NumberTried++;
           // To Check if the input the user put is the correct value or not

            if (NumberGuessed == CorrectGuess) {
                System.out.println(
                        "Congratulations " + user + "! You have successfully guessed the correct number in " + NumberTried + " attempt(s)");
                break;
            } else if ( NumberGuessed < CorrectGuess) {
                System.out.println("Your guess is lower");
            } else {
                System.out.println("Your guess is higher");
            }


            // To Check if the user has used all the attempts
            if (i == Max_Attempts) {
                System.out.println("Sorry, " + user + ", you didn't guess the number in " + Max_Attempts
                        + " attempts. The correct number was " + CorrectGuess);
            }
        }

        System.out.println("Thank you for playing");

        scanner.close();
    }

}