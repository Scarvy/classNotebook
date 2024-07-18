import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Class for showing how choices work in Java Swing.
 */
public class Choices {

    public static void main(String[] args) {

        // create a new JFrame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        // create a JPanel to hold our components
        JPanel panel = new JPanel();

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // we can also add borders to our JPanels
        panel.setBorder(new EtchedBorder());

        // create some radio buttons
        JRadioButton radioButton1 = new JRadioButton("Small");
        JRadioButton radioButton2 = new JRadioButton("Medium");
        JRadioButton radioButton3 = new JRadioButton("Large");

        // we add the radio buttons to a group so that only one can be selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        // add an action listener to the first radio button
        radioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.out.println("Small radio button selected");
            }
       });

        // create a combo box with a few different items
        String[] items = {"Serif", "San-Serif", "Times New Roman"};
        JComboBox<String> comboBox = new JComboBox<>(items);

        // you can get the value that the user selected by using
        // String selectedString = (String) comboBox.getSelectedItem();

        // create a checkbox
        JCheckBox checkBox = new JCheckBox("Check Box");

        // add the components to the panel
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(comboBox);
        panel.add(checkBox);

        // add the panel to the frame
        frame.add(panel);

        // make the frame visible
        frame.setVisible(true);
    }
}