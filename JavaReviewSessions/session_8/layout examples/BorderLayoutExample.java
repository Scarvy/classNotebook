import javax.swing.*;
import java.awt.*;

/**
 * A class for showing an example of a border layout in Java Swing.
 */
public class BorderLayoutExample {

    public static void main(String[] args) {

        // create a JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // set the layout to a border layout
        frame.setLayout(new BorderLayout());

        // add Java Swing components to each of the different sections of the layout
        frame.add(new JButton("North"), java.awt.BorderLayout.NORTH);
        frame.add(new JButton("South"), java.awt.BorderLayout.SOUTH);
        frame.add(new JButton("East"), java.awt.BorderLayout.EAST);
        frame.add(new JButton("West"), java.awt.BorderLayout.WEST);
        frame.add(new JButton("Center"), java.awt.BorderLayout.CENTER);

        frame.setVisible(true);

    }
}