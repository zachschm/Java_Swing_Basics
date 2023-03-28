import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyInternalFrame extends JInternalFrame
{
    // Tracks number of documents made
    static int count = 0;
    // Text area for documents
    JTextArea ta;
    // Allows documents to have scroll bars
    JScrollPane sp;
    MyInternalFrame()
    {
        // Title = Document, can be resizable, closable, maximizable, and iconifiable.
        super("Document" + (++count), true, true, true, true);

        // Text Area Creation
        ta = new JTextArea();
        sp = new JScrollPane(ta);
        add(sp);

        // Menu Bar Creation
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem m1 = new JMenuItem();

        // Menu Bar Fill
        file.add(m1);
        mb.add(file);
        setJMenuBar(mb);

        // Setting up size and location of new documents
        setSize(300,300);
        setLocation(50, 50);
        setVisible(true);
    }
}

class MyFrame extends JFrame implements ActionListener
{
    JDesktopPane jp;
    // Window Creation
    MyFrame()
    {
        // Window Title
        super("Internal Frame Demo");

        jp = new JDesktopPane();
        setContentPane(jp);

        // Window Menu Bar
        JMenuBar mb = new JMenuBar();
        JMenu d = new JMenu("Document");
        JMenuItem m1 = new JMenuItem("New");

        d.add(m1);
        mb.add(d);
        setJMenuBar(mb);

        m1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // Creates new documents when (document, new) is selected in the window menu bar
        MyInternalFrame mi = new MyInternalFrame();
        jp.add(mi);
    }
}

public class internalFrame
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(800,800);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
