import javax.swing.*;

/**
 * Class for showing how a basic graphical user interface works in Java Swing.
 */
public class HelloSwing {

    public static void main(String[] args) {

        // create a new JFrame
        JFrame frame = new JFrame();

        // set the default close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the window size
        frame.setSize(800, 600);

        // set the window position to center of the screen
        frame.setLocationRelativeTo(null);

        // add a label to the window
        JLabel label = new JLabel("Hello Swing!", SwingConstants.CENTER);
        frame.add(label);

        // make the window visible
        frame.setVisible(true);

    }
}

/*

The setDefaultCloseOperation defines how the Swing application should respond when a user attempts to close the window

    - What happens when you click the "X" on the top of the window?
    - What happens if you don't have a setDefaultCloseOperation?

The program will default to HIDE_ON_CLOSE (the program will keep running!)


There are a few different options that you can use here:

    - EXIT_ON_CLOSE - terminates the application when the user closes the window

    - DISPOSE_ON_CLOSE - disposes of the window but does not necessarily terminate the program

    - HIDE_ON_CLOSE - hides the window but the application still keeps running

    - DO_NOTHING_ON_CLOSE - this does nothing when the user clicks the "X" button

*/