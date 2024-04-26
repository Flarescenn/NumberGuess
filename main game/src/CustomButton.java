/*import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton extends JButton {

    public CustomButton(String text) {
        super(text); // Set button text
        super.setContentAreaFilled(false); // Remove default button background
        super.setFocusPainted(false); // Remove focus indicator

        // Set preferred size (adjust as needed)
        super.setPreferredSize(new Dimension(100, 50));

        // Set border
        super.setBorder(BorderFactory.createLineBorder(Color.WHITE));

        // Set text color (white)
        super.setForeground(Color.WHITE);

        // Handle mouse events for hover and selection
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change background to white on hover
                super.setContentAreaFilled(true); // Make sure content area is filled
                super.setBackground(Color.WHITE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Revert background to transparent on exit
                super.setBackground(new Color(0, 0, 0, 0)); // Transparent background
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Change text color to white on selection (pressed)
                super.setForeground(Color.WHITE);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Optionally, revert text color to default on release (optional)
                // super.setForeground(Color.BLACK); // Uncomment to revert text color
            }
        };
        super.addMouseListener(mouseAdapter);
    }
}*/