import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameGUI extends JFrame {
    private JButton startButton, historyButton, exitButton;
    private JLabel messageLabel;
    private JButton selectedButton;
    private int selectedState;
    public GameGUI() {
        super("Number Guessing Game"); // Set window title

        // Create UI components
        JLabel titleLabel = new JLabel("Guess it", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48)); // Adjust font size and style

         startButton = new JButton("Start");
         historyButton = new JButton("History");
         exitButton = new JButton("Exit");

        startButton.setPreferredSize(new Dimension(100, 50));
        historyButton.setPreferredSize(new Dimension(100, 50));
        exitButton.setPreferredSize(new Dimension(100, 50));




        /*JButton startButton = new JButton("Start New Game");
        startButton.setBounds(50,100,80,30);
        startButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        JButton exitButton = new JButton("Exit Game");
        exitButton.setBounds(100,100,80,30);
        exitButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));*/

        messageLabel = new JLabel();

        // Create main panel with FlowLayout (buttons centered)
        JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBounds(40,80,1000,1000);
        mainPanel.setBackground(Color.BLACK); // Set black background

        // Add components to the panel
        mainPanel.add(titleLabel);
        mainPanel.add(startButton);
        mainPanel.add(historyButton);
        mainPanel.add(exitButton);
        mainPanel.add(messageLabel);

        // Add panel to the frame (use "this" which refers to the GameGUI instance)
        System.out.println("Adding panel to content pane");
        this.getContentPane().add(mainPanel);

        this.setLayout(new BorderLayout()); // Use BorderLayout for full-screen panel
        System.out.println("Adding panel to content pane");
        selectedButton = startButton; // Start button is selected by default
        selectedButton.setFocusable(true);

        // Set window properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Adjust frame size to fit components
        this.setLocationRelativeTo(null); // Center the window on screen
        this.setVisible(true); // Make the frame visible

        /*this.addKeyListener(new KeyListener() {
                                @Override
                                public void keyPressed(KeyEvent e) {
                                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                        // Handle "Enter" key press - Simulate click on selected button
                                        selectedButton.doClick();
                                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                                        // Handle "Up" arrow key press - Move selection up
                                        selectPreviousButton();
                                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                                        // Handle "Down" arrow key press - Move selection down
                                        selectNextButton();
                                    }
                                }
            @Override
            public void keyReleased(KeyEvent e) {
                // Not required for this functionality
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not required for this functionality
            }
            private void selectPreviousButton() {
                JButton previousButton = null;
                if (selectedButton == startButton) {
                    previousButton = exitButton;
                } else if (selectedButton == historyButton) {
                    previousButton = startButton;
                } else if (selectedButton == exitButton) {
                    previousButton = historyButton;
                }

                if (previousButton != null) {
                    selectedButton.setFocusable(false); // Unfocus the previously selected button
                    selectedButton = previousButton;
                    selectedButton.setFocusable(true); // Focus the newly selected button
                }
            }

            private void selectNextButton() {
                JButton nextButton = null;
                if (selectedButton == startButton) {
                    nextButton = historyButton;
                } else if (selectedButton == historyButton) {
                    nextButton = exitButton;
                } else if (selectedButton == exitButton) {
                    nextButton = startButton;
                }

                if (nextButton != null) {
                    selectedButton.setFocusable(false); // Unfocus the previously selected button
                    selectedButton = nextButton;
                    selectedButton.setFocusable(true); // Focus the newly selected button
                }
            }
        }
        );*/
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    selectedState = (selectedState - 1 + 3) % 3; // Decrement state, wrap around from 0 to 2
                } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    selectedState = (selectedState + 1) % 3; // Increment state, wrap around from 2 to 0
                }

                updateButtonSelection(); // Update button selection based on state
            }
            private void updateButtonSelection() {
                JButton[] buttons = {startButton, historyButton, exitButton};
                for (int i = 0; i < buttons.length; i++) {
                    buttons[i].setBorder(null); // Reset all button borders
                }
                buttons[selectedState].setBorder(BorderFactory.createLineBorder(Color.RED)); // Set border for selected button
            }



            @Override
            public void keyReleased(KeyEvent e) {
                // Not required for this functionality
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not required for this functionality
            }
        });

        // Register KeyListener for Enter key to trigger action
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleSelectedButtonAction(); // Trigger action based on selected state
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Not required for this functionality
            }

            @Override
            public void keyTyped(KeyEvent e) {
                // Not required for this functionality
            }
            private void handleSelectedButtonAction() {
                switch (selectedState) {
                    case 0:
                        // Handle "Start" button action
                        System.out.println("Starting the Game!"); // Placeholder, replace with actual game logic
                        break;
                    case 1:
                        // Handle "History" button action
                        System.out.println("Showing history..."); // Placeholder, replace with history logic
                        break;
                    case 2:
                        // Handle "Exit" button action
                        System.exit(0); // Close the window
                        break;
                }
            }
        }

        );





       /* startButton.addActionListener(new ActionListener() {
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
        });*/
    }
}



