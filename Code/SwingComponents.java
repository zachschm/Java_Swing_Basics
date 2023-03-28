package swingcomponents;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class firstSwingFile extends JFrame implements ActionListener
{
    JLabel l;
    JButton b;
    int count = 0;

    firstSwingFile()
    {
        super("Swing Demo");

        setLayout(new FlowLayout());
        l = new JLabel("Clicked " + count + " Times");
        b = new JButton("Click");

        add(l);
        add(b);
        b.addActionListener(this);

        // Allows for main button, will also map enter key to click the button
        getRootPane().setDefaultButton(b);

        // Can set a button to any image
//        b.setIcon(new ImageIcon("Path of Image"));

        // Essentially alt text, allows a button to have descriptive text;
        l.setToolTipText("Counter");
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        count++;
        l.setText("Clicked " + count + " Times");
    }

}

public class SwingComponents
{
    public static void main(String[] args)
    {
        firstSwingFile f = new firstSwingFile();
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
