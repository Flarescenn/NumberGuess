import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUII extends JFrame {

    private JButton startButton, historyButton, exitButton;
    private JLabel titleLabel;
    private GameLogic gameLogic;
    GameController gameController;
    JTextArea feedbackArea;


    public GameGUII() {
        super("Number Guessing Game"); // Set window title

        // Create UI components
        titleLabel = new JLabel("Guess it", JLabel.CENTER);
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(new Font("Arial",  Font.BOLD, 48)); // Adjust font size and style

        startButton = new JButton("Start");
        historyButton = new JButton("History");
        exitButton = new JButton("Exit");

        startButton.setPreferredSize(new Dimension(100, 50));
        historyButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));


        feedbackArea = new JTextArea(5, 20); // Adjust rows and columns as needed
        feedbackArea.setEditable(false);

        // Create main panel with FlowLayout (buttons centered)
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.BLACK); // Set black background
        mainPanel.setBounds(40,80,800,800);

        mainPanel.add(titleLabel);
        mainPanel.add(startButton);
        mainPanel.add(historyButton);
        mainPanel.add(exitButton);
        mainPanel.add(feedbackArea);

        this.getContentPane().add(mainPanel);

        // Setting window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);



        GameLogic gameLogic=new GameLogic(10);
        GameController gameController= new GameController(gameLogic, feedbackArea);
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
