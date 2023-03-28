package checkbox;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

class MyFrame extends JFrame implements ActionListener
{
    // Check Boxes
    JCheckBox c1, c2;
    // Radio Button, One or the other can be pressed, not both
    JRadioButton r1, r2;

    // Text Field
    JTextField tf;

    // Creates Frame
    MyFrame()
    {
        super("Demo");

        // Text Field which contains the text to show alteration with button presses
        tf = new JTextField("Demo Text", 20);
        tf.setBounds(10, 20, 100, 80);

        // Bold Button
        c1 = new JCheckBox("Bold");
        c1.setMnemonic(KeyEvent.VK_B);

        // Italic Button
        c2 = new JCheckBox("Italic");
        c2.setMnemonic(KeyEvent.VK_B);

        // Radio Buttons for upper case and lower case
        r1=new JRadioButton("lower");
        r2=new JRadioButton("UPPER");

        // Button group that links the radio button together
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);

        // Action Listeners
        c1.addActionListener(this);
        c2.addActionListener(this);
        r1.addActionListener(this);
        r2.addActionListener(this);

        // Sets the commands linked with the buttons which helps shorten code later on
        r1.setActionCommand("lower");
        r2.setActionCommand("UPPER");

        setLayout(new FlowLayout());

        add(tf);
        add(c1);
        add(c2);
        add(r1);
        add(r2);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Gets action command, we set these earlier
        switch (e.getActionCommand())
        {
            // If the radios are selected, the text itself is changed to either upper
            // or lower case
            // Enhanced switch statement with no need for breaks;
            case "lower" ->
                    tf.setText(tf.getText().toLowerCase());
            case "UPPER" ->
                    tf.setText(tf.getText().toUpperCase());
        }
        int b = 0, i = 0;

        // If the regular buttons are
        if(c1.isSelected())
            b = Font.BOLD;
        if(c2.isSelected())
            i = Font.ITALIC;

        // If b or i are selected, their font stylers are added onto the set font function
        Font f = new Font("Times New Roman",b|i,15);
        tf.setFont(f);

    }
}
public class checkBox
{
    // Creates the screen
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
        // Forces the program to complete after screen is exited
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
