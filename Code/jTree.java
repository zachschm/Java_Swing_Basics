import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.util.Objects;

class MyFrame extends JFrame implements TreeSelectionListener
{
   JTree tree;
   JLabel label;

   // Constructor
   MyFrame()
   {
       super("Tree Demo");

       DefaultMutableTreeNode root = new DefaultMutableTreeNode("/Users/zachschmitz/SoftwareEngineering/java/swing");
       File f = new File("/Users/zachschmitz/SoftwareEngineering/java/swing");

       for(File x: Objects.requireNonNull(f.listFiles()))
       {
           if(x.isDirectory())
           {
               DefaultMutableTreeNode temp = new DefaultMutableTreeNode(x.getName());
               for (File y : Objects.requireNonNull(x.listFiles()))
               {
                   temp.add(new DefaultMutableTreeNode(y.getName()));
               }
               root.add(temp);
           }
           else
               root.add(new DefaultMutableTreeNode(x.getName()));

       }

       tree = new JTree(root);
       label = new JLabel("No Files Selected");

       tree.addTreeSelectionListener(this);
       JScrollPane sp = new JScrollPane(tree);

       add(sp, BorderLayout.CENTER);
       add(label,BorderLayout.SOUTH);
   }

    @Override
    public void valueChanged(TreeSelectionEvent e)
    {
        label.setText(e.getPath().toString());
    }
}
public class jTree
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
