import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

class MyFrame extends JFrame implements ListSelectionListener
{
    // Split Pane
    JSplitPane sp;
    // List For Colors
    JList list;
    // Label to show change of colors
    JLabel lbl;

    MyFrame()
    {
        super("Split Demo");

        // Array to Hold colors
        String[] cols = {"RED", "GREEN", "BLUE", "YELLOW", "MAGENTA", "ORANGE", "BLACK"};

        // Color Tab implementation
        list = new JList<>(cols);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        JScrollPane p1 = new JScrollPane(list);

        // Label Tab Implementation
        lbl = new JLabel(" ");
        lbl.setOpaque(true);
        lbl.setBackground(Color.RED);
        JScrollPane p2 = new JScrollPane(lbl);

        // Split Pane
/*        sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, p1, p2);
        sp.setDividerLocation(200);
        add(sp);*/

        // Tabbed Pane
        JTabbedPane tp = new JTabbedPane();
        tp.addTab("Colors", p1);
        tp.addTab("Label", p2);
        add(tp);
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        String str = (String)list.getSelectedValue();
        // Label Window color is changed based on which list item is selected
        switch (str)
        {
            case "RED" -> lbl.setBackground(Color.RED);
            case "GREEN" -> lbl.setBackground(Color.GREEN);
            case "BLUE" -> lbl.setBackground(Color.BLUE);
            case "YELLOW" -> lbl.setBackground(Color.YELLOW);
            case "MAGENTA" -> lbl.setBackground(Color.MAGENTA);
            case "ORANGE" -> lbl.setBackground(Color.ORANGE);
            case "BLACK" -> lbl.setBackground(Color.BLACK);
        }

    }
}
public class split_tabbedPane
{

    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(800,800);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
