package borders;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

class MyFrame extends JFrame
{
    JLabel l;
    JTextField tf;
    JButton b;

    JPanel p;

    MyFrame()
    {
        l = new JLabel("Name");
        tf = new JTextField(20);
        b = new JButton("OK");
        p = new JPanel();

        p.add(l);
        p.add(tf);
        p.add(b);

//        Border br = BorderFactory.createLoweredBevelBorder();
//        Border br = BorderFactory.createRaisedBevelBorder();
//        Border br = BorderFactory.createTitledBorder("Name");
//        Border br = BorderFactory.createLineBorder(Color.BLUE, 4);
        // Can Combine Multiple Methods
        // TitleBorder.Top, and TitleBorder.Center are best for placing the title at a pleasant location for the viewer
        Border br = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.blue), "Login", TitledBorder.CENTER, TitledBorder.TOP);
        p.setBorder(br);


        setLayout(new FlowLayout());
        add(p);
    }
}

public class borders
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
