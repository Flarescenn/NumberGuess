import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameGUII extends JFrame {

    private JButton startButton, historyButton, exitButton;
    private JLabel titleLabel, messageLabel;
    private int selectedState;

    public GameGUII() {
        super("Number Guessing Game"); // Set window title

        // Create UI components
        titleLabel = new JLabel("Guess it", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Adjust font size and style

        startButton = new JButton("Start");
        historyButton = new JButton("History");
        exitButton = new JButton("Exit");

        startButton.setPreferredSize(new Dimension(100, 50));
        historyButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));

        messageLabel = new JLabel();

        // Create main panel with FlowLayout (buttons centered)
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.BLACK); // Set black background

        // Add components to the panel
        mainPanel.add(titleLabel);
        mainPanel.add(startButton);
        mainPanel.add(historyButton);
        mainPanel.add(exitButton);
        mainPanel.add(messageLabel);

        // Add panel to the frame
        this.getContentPane().add(mainPanel);

        // Set window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null); // Center the window on screen
        this.setVisible(true);

        // Register ActionListeners for button clicks
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "Start" button click (logic goes here)
                messageLabel.setText("Welcome to the Guessing Game!\nClick here to guess a number between 0 and 15."); // Set a temporary message (optional)
            }
        });
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "History" button click (logic goes here)
                messageLabel.setText("Showing history..."); // Set a temporary message (optional)
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
