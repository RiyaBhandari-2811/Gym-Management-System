import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class DisplayTrainerPage extends JFrame implements ActionListener{

    //x array
    String x[] =  {"Trainer ID", "First Name", "Last Name" ,"Email", "Address", "Contact No", "Gender"};

    //button for delete
    JButton bt;
    JPanel p1,p2,p3;
    JLabel l1, l2;
    JTextField tf1;
    Font f1, f2;
    private Color lightBlue = Color.decode("#a1cff0");
    private Color fontColorOrange = Color.decode("#e97025");
    private Color navy = Color.decode("#394a7b");

    //20 row and 7 coloumn
    String y[][]=new String[25][7];

    int i=0, j= 0;

    JTable t;
    Font f;

    DisplayTrainerPage()
    {
        //title of table
        super("Trainer Information");
        setSize(1500,500);
        setLocation(1,1);
        f = new Font ("monospace", Font.PLAIN, 15);

        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from AddTrainer";
            ResultSet rest= obj.stm.executeQuery(q);
            while(rest.next())

            {
                y[i][j++]=rest.getString("TId");
                y[i][j++]=rest.getString("FirstName");
                y[i][j++]=rest.getString("LastName");
                y[i][j++]=rest.getString("Email");
                y[i][j++]=rest.getString("Address");
                y[i][j++]=rest.getString("Phone");
                y[i][j++]=rest.getString("Gender");

                i++;
                j=0;

            }

            t = new JTable(y,x);

            t.setFont(f);

            t.setBackground(lightBlue);
            t.setForeground(Color.BLACK);
        }

        catch (Exception ex)
        {
            ex.printStackTrace();

        }

        JScrollPane sp =new JScrollPane(t);

        f1 = new Font("monospace", Font.BOLD, 25);

        l1 = new JLabel("Delete any Trainer ? ");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont (f1);

        l1.setForeground(fontColorOrange);

        p1 = new JPanel();
        p1.setLayout(new GridLayout (1,1,10,10));
        p1.add(l1);

        tf1 =new JTextField();
        bt = new JButton ("Delete Trainer");
        tf1.setFont(f);
        bt.setFont(f);

        bt.addActionListener(this);
        bt.setBackground(navy);
        bt.setForeground(fontColorOrange);

        l2 = new JLabel("Trainer ID");
        l2.setFont(f1);
        l2.setForeground(fontColorOrange);


        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt);

        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));

        p3.add(p1);
        p3.add(p2);

        p1.setBackground(lightBlue);
        p2.setBackground(lightBlue);
        p3.setBackground(lightBlue);

        add(p3, "South");
        add(sp);
    }

    public void actionPerformed(ActionEvent e)
    {
        int TId = Integer.parseInt(tf1.getText());
        if(e.getSource()==bt);
        {
            try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q = "delete from AddTrainer where tid = '"+TId+"'";
                obj1.stm.executeUpdate(q);
                setVisible(true);
                new DisplayTrainerPage().setVisible(true);
            }

            catch(Exception evx)
            {
                evx.printStackTrace();

            }
        }
    }

    public static void main(String args[])
    {
        new DisplayTrainerPage().setVisible(true);
    }





}