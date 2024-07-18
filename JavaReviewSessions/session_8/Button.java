import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for showing how a JButton works in Java Swing.
 */
public class Button {

    public static void main(String[] args) {

        // create a new JFrame
        JFrame frame = new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // create a new JButton
        JButton button = new JButton("Click Me!");
        JButton button2 = new JButton("Click Me Again!");

        // add an action listener to the first button
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // show a message when the button is clicked
                JOptionPane.showMessageDialog(frame, "Button Clicked!");
                //System.out.println("Button Clicked!");
            }

        });

        // add the buttons to the frame
        frame.add(button);
        frame.add(button2);

        // don't use a frame layout
        frame.setLayout(null);

        // set the position and the sizes of the buttons
        button.setBounds(150, 100, 100, 40);
        button2.setBounds(50, 50, 100, 40);

        // make the frame visible
        frame.setVisible(true);
        
    }
}