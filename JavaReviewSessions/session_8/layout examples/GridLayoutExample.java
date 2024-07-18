import javax.swing.*;
import java.awt.GridLayout;

/**
 * Class for showing an example of a grid layout in Java Swing.
 */
public class GridLayoutExample {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // create a grid layout with two rows and two columns
        frame.setLayout(new GridLayout(2, 2));

        frame.add(new JButton("Button 1"));
        frame.add(new JButton("Button 2"));
        frame.add(new JButton("Button 3"));
        frame.add(new JButton("Button 4"));

        frame.setVisible(true);

    }
}