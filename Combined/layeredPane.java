import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MyFrame extends JFrame implements ActionListener {
    // JLayeredPane allows for easy altering of 'z' indexes and layering components
    JLayeredPane lp;
    // JRadioButtons which will alter the layer of our label
    JRadioButton r1, r2, r3;
    // Labels to showcase the abilities of JLayeredPane
    JLabel l1, l2, l3, l4;

    MyFrame()
    {
        super("Layered Demo");

        // Radio Buttons Creation and Addition
        r1 = new JRadioButton("Red");
        r2 = new JRadioButton("Green");
        r3 = new JRadioButton("Blue");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);

        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);

        JPanel p1 = new JPanel();
        p1.add(r1);
        p1.add(r2);
        p1.add(r3);

        // Label Creation and Addition
        l1 = new JLabel("Red");
        l1.setBounds(10, 10, 250, 250);
        l1.setBackground(Color.RED);
        l1.setOpaque(true);

        l2 = new JLabel("Green");
        l2.setBounds(50, 50, 250, 250);
        l2.setBackground(Color.GREEN);
        l2.setOpaque(true);

        l3 = new JLabel("Blue");
        l3.setBounds(100, 100, 350, 350);
        l3.setBackground(Color.BLUE);
        l3.setOpaque(true);

        l4 = new JLabel("Black");
        l4.setBounds(125, 125, 150, 150);
        l4.setBackground(Color.BLACK);
        l4.setOpaque(true);

        // Adding to our Layered Pane and setting our proper index layers
        lp = new JLayeredPane();
        lp.add(l1);
        lp.add(l2);
        lp.add(l3);
        lp.add(l4);
        lp.setLayer(l1, 0);
        lp.setLayer(l2, 1);
        lp.setLayer(l3, 2);
        lp.setLayer(l4, 3);
        add(p1,BorderLayout.NORTH);
        add(lp, BorderLayout.CENTER);

        // Handles Mouse movements, moves our fourth label with mouse movement
        addMouseMotionListener(new MouseAdapter()
        {
            public void mouseMoved(MouseEvent e)
            {
                l4.setLocation(e.getX(), e.getY());
            }
        });

    }

    // Handles Radio Button Clicks, Changes the layer of our fourth label
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (r1.isSelected())
            lp.setLayer(l4,1);
        else if (r2.isSelected())
            lp.setLayer(l4,2);
        else if (r3.isSelected())
            lp.setLayer(l4,3);
    }
}

public class layeredPane
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(800,800);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
