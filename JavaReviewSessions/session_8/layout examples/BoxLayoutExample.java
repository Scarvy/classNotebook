import javax.swing.*;

/**
 * Class for showing an example of how a box layout works in Java Swing.
 */
public class BoxLayoutExample {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // create a JPanel
        JPanel panel = new JPanel();

        // create a new box layout on the horizontal axis
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));

        frame.add(panel);

        frame.setVisible(true);

    }
}
