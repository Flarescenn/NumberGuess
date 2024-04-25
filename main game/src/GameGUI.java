import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGUI extends JFrame {

    private JLabel messageLabel;

    public GameGUI() {
        super("Number Guessing Game"); // Set window title

        // Create UI components
        JLabel titleLabel = new JLabel("Guess it", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Adjust font size and style

        JButton startButton = new JButton("Start New Game");
        startButton.setBounds(50,100,80,30);
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(100,100,80,30);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        messageLabel = new JLabel();

        // Create main panel with FlowLayout (buttons centered)
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBounds(40,80,200,200);
        mainPanel.setBackground(Color.BLACK); // Set black background

        // Add components to the panel
        mainPanel.add(titleLabel);
        mainPanel.add(startButton);
        mainPanel.add(exitButton);
        mainPanel.add(messageLabel);

        // Add panel to the frame (use "this" which refers to the GameGUI instance)
        System.out.println("Adding panel to content pane");
        this.getContentPane().add(mainPanel);
        this.setLayout(new BorderLayout()); // Use BorderLayout for full-screen panel
        System.out.println("Adding panel to content pane");
        // Set window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Adjust frame size to fit components
        this.setLocationRelativeTo(null); // Center the window on screen
        this.setVisible(true); // Make the frame visible

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle "Start New Game" button click (logic goes here)
                messageLabel.setText("Welcome to the Guessing Game!\nClick here to guess a number between 0 and 15."); // Set a temporary message (optional)
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



