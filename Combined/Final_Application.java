import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

class MyFrame extends JFrame implements ActionListener
{
    // Tool Bar
    JToolBar tb;
    // Buttons
    JButton b1, b2, b3, b4, b5, b6, b7;
    // Text Area
    JTextArea ta;

    MyFrame()
    {
        super("Toolbar Demo");
        tb = new JToolBar();

        // Tool Bar Buttons Creations
        b1 = new JButton("Save");
        b2 = new JButton("Open");
        b3 = new JButton("New");
        b4 = new JButton("Cut");
        b5 = new JButton("Copy");
        b6 = new JButton("Split");
        b7 = new JButton("Close");

        // Tool Bar Buttons Implementation
        tb.add(b1);
        tb.add(b2);
        tb.add(b3);
        // Separator
        tb.add(new JToolBar.Separator());
        tb.add(b4);
        tb.add(b5);
        tb.add(b6);
        tb.add(b7);

        // Text Area Implementation
        ta = new JTextArea();
        JScrollPane sp = new JScrollPane(ta);

        // Frame Addition
        add(tb, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);

        // Menu Bar Implementation
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem m1 = new JMenuItem("save");
        JMenuItem m2 = new JMenuItem("open");
        // Shortcut key for open
        m2.setMnemonic(KeyEvent.VK_O);

        // Menu Bar Addition
        file.add(m1);
        // Adds Separator between menu items
        file.addSeparator();
        file.add(m2);
        mb.add(file);
        setJMenuBar(mb);

        // Event Listeners
        b2.setActionCommand("open");
        b2.addActionListener(this);
        m2.addActionListener(this);
        b1.addActionListener(this);
        m1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getActionCommand().equals("open"))
        {
            // File Navigator
            JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);
            File f = fc.getSelectedFile();

            try {
                FileInputStream fi = new FileInputStream(f);
                byte[] b = new byte[fi.available()];
                fi.read(b);
                String str = new String(b);
                ta.setText(str);
                fi.close();
            } catch (Exception ignored) {}
        }
        else
        {
            // Color Picker + Setter
            Color col = JColorChooser.showDialog(this, "Font Color", Color.CYAN);
            ta.setForeground(col);
        }
    }
}
public class Final_Application
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(800,800);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
