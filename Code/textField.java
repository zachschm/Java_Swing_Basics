package swingtextfield;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class MyFrame extends JFrame
{
    MyFrame()
    {

        JTextField tf1 = new JTextField(15);

        // Second Button
        // Date Formatting
        DateFormat df = new SimpleDateFormat("dd/MMMM/yyyy"); // 4 M's means Text Months
        JFormattedTextField tf2 = new JFormattedTextField(df);
        tf2.setColumns(15);
        // Obtains Today's Date
        tf2.setValue(new Date());

        // Third Button
        // Sets a dollar amount format for a text field.
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormatter nft = new NumberFormatter(nf);
        // Does not allow invalid TExt fields.
        nft.setAllowsInvalid(false);
        // Sets Maximum Number allowed to be entered
        nft.setMaximum(10000);
        // Sets Minimum Number
        nft.setMinimum(0);
        JFormattedTextField tf3 = new JFormattedTextField(nft);
        tf3.setColumns(15);
        tf3.setValue(0);

        // Text Box
        // A larger text area that can be both rows and columns
        JTextArea ta = new JTextArea(30,30);

        setLayout(new FlowLayout());
        add(tf1);
        add(tf2);
        add(tf3);
        add(ta);

    }
}
public class textField
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(500, 500);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
