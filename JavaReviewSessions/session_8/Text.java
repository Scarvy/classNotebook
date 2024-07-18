import javax.swing.*;

/**
 * Class for showing how JTextFields and JTextAreas work in Java Swing.
 */
public class Text {

    public static void main(String[] args) {

        // create a new JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // set the layout for the window
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        // add a new text field
        JTextField textField = new JTextField("Enter text here");
        frame.add(textField);

        // add a new text area
        JTextArea textArea = new JTextArea("This is a text area", 10, 30);
        frame.add(new JScrollPane(textArea));

        frame.setVisible(true);
    }
}