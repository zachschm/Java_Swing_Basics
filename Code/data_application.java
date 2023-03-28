import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame implements ActionListener, ListSelectionListener, ChangeListener
{
    JComboBox<String> cb;
    JList<String> list;
    JSpinner sp1, sp2;
    JTextField tf;

    MyFrame()
    {
        super("Spinner Demo");

        String[] countries = {"US", "Mexico", "Canada", "Spain", "France", "Germany"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July"};
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        cb = new JComboBox<>(countries);

        list = new JList<>(months);
        list.setVisibleRowCount(3);

        tf = new JTextField(15);

        sp1 = new JSpinner(new SpinnerNumberModel(1,1, 31, 1));
        sp2 = new JSpinner(new SpinnerListModel(days));

        setLayout(new FlowLayout());
        add(cb);
        add(sp1);
        add(sp2);
        add(new JScrollPane(list));
        add(tf);

        cb.addActionListener(this);
        list.addListSelectionListener(this);
        sp1.addChangeListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        tf.setText((String)cb.getSelectedItem());
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
       tf.setText(list.getSelectedValue());
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        if (e.getSource() == sp1)
        {
            tf.setText(sp1.getValue().toString());
        }
        else
            tf.setText((String)sp2.getValue());
    }
}
public class data_application
{
    public static void main(String[] args)
    {
        MyFrame f = new MyFrame();
        f.setSize(800,400);
        f.setVisible(true);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}