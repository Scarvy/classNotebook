import javax.swing.*;
import java.awt.*;

/**
 * Class for showing an example of a JPanel in Java Swing.
 */
public class Panel {

    public static void main(String[] args) {

        // create a new JFrame
        JFrame frame = new JFrame("Minimal JPanel Example");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // Create a JPanel instance
        JPanel panel = new JPanel();

        // set the background color of the JPanel to green
        panel.setBackground(Color.GREEN);

        frame.add(panel);

        frame.setVisible(true);

    }
}