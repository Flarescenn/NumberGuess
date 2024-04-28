import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class GameGUII extends JFrame {

    private JButton startButton, historyButton, exitButton;
    private JLabel titleLabel;
    private GameLogic gameLogic;
    GameController gameController;
    JTextArea feedbackArea;


    public GameGUII() {
        super("Number Guessing Game"); // Set window title

        this.setSize(800, 600);


        // Title
        titleLabel = new JLabel("GUESS IT", JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Monospaced", Font.BOLD, 58)); // Adjust font size and style


        //Buttons
        startButton = new JButton("PLAY");
        historyButton = new JButton("HISTORY");
        exitButton = new JButton("EXIT");


//Buttons and Formatting (Should've done it in a new Class instead)
        startButton.setPreferredSize(new Dimension(150, 75));
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFont(new Font("DialogInput", Font.BOLD, 20));
        historyButton.setPreferredSize(new Dimension(150, 75));
        historyButton.setBackground(Color.BLACK);
        historyButton.setForeground(Color.WHITE);
        historyButton.setFont(new Font("DialogInput", Font.BOLD, 20));
        exitButton.setPreferredSize(new Dimension(150, 75));
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFont(new Font("DialogInput", Font.BOLD, 20));



        feedbackArea = new JTextArea(1, 1); // Adjust rows and columns as needed
        feedbackArea.setEditable(false);
        feedbackArea.setBackground(Color.BLACK);
        feedbackArea.setForeground(Color.WHITE);
        feedbackArea.setFont(new Font("Monospaced", Font.PLAIN, 30));


        // Create main panel with GridLayout (buttons centered)
        JPanel mainPanel = new JPanel(new GridLayout(3, 1, 100, 30));
        mainPanel.setBackground(Color.BLACK);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 20, 20));
        buttonPanel.setMaximumSize(new Dimension(150, 400));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(startButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(exitButton);


        //Formatting the center
        JPanel leftpanel = new JPanel();
        JPanel rightpanel = new JPanel();
        leftpanel.setBackground(Color.BLACK);
        rightpanel.setBackground(Color.BLACK);
        JPanel parentPanel = new JPanel(new GridLayout(1, 3, 0, 0));
        parentPanel.add(leftpanel);
        parentPanel.add(buttonPanel);
        parentPanel.add(rightpanel);

        //mainPanel.add(titleLabel);
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(parentPanel, BorderLayout.CENTER);
        //mainPanel.add(buttonPanel);
        // mainPanel.add(feedbackArea);
        mainPanel.add(feedbackArea, BorderLayout.SOUTH);


        this.getContentPane().add(mainPanel);

        // Setting window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        GameLogic gameLogic = new GameLogic(10);
        GameController gameController = new GameController(gameLogic, feedbackArea);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                feedbackArea.setText("Welcome to the Guessing Game!\n");
                gameController.startGame(feedbackArea);
                gameController.promptForGuess(feedbackArea);
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                feedbackArea.setText("Showing history...");
                //TO DO
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Close the application
            }
        });
    }
}
