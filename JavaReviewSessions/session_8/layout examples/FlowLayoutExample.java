import javax.swing.*;
import java.awt.FlowLayout;

/**
 * Class for showing how a flow layout works in Java Swing.
 */
public class FlowLayoutExample {

    public static void main(String[] args) {

        // create the JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // set the layout to be a flow layout
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // add Java Swing components to the layout
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));

        frame.add(panel);

        frame.setVisible(true);

    }

}
