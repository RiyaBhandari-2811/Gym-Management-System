import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class AttendanceMPage extends JFrame implements ActionListener
{

    JLabel l1,l2,l3,l4;
    Choice ch1,ch2,ch3;
    JButton bt1,bt2;
    JPanel p1,p2;
    private Color lightBlue = Color.decode("#a1cff0");
    private Color fontColorOrange = Color.decode("#e97025");
    private Color navy = Color.decode("#394a7b");

    AttendanceMPage()
    {
        super("Member attendance");
        setLocation(70,10);
        setSize(400,250);


        Font f1 = new Font("monospace", Font.BOLD, 25);
        Font f2 = new Font("monospace", Font.BOLD, 18);

        l1=new JLabel("Recepit No");
        l2=new JLabel("Select Time");
        l3=new JLabel("Take Attendance");
        l4=new JLabel("Member Attendance");

        l1.setForeground(fontColorOrange);//orange
        l2.setForeground(fontColorOrange);//orange
        l3.setForeground(fontColorOrange);//orange
        l4.setForeground(fontColorOrange);//orange

        l4.setFont(f1);
        l4.setHorizontalAlignment(JLabel.CENTER);

        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f2);

        ch1=new Choice();
        ch1.add("Morning Time");
        ch1.add("Evening Time");

        ch2=new Choice();
        ch2.add("Absent");
        ch2.add("Present");

        ch3=new Choice();
        try
        {
            ConnectionClass obj = new ConnectionClass();
            String q ="Select RecepitNo from AddMember";
            ResultSet rest= obj.stm.executeQuery(q);
            while(rest.next())
            {
                ch3.add(rest.getString("RecepitNo"));


            }


        }

        catch(Exception e)
        {
            e.printStackTrace();

        }

        ch1.setFont(f2);
        ch2.setFont(f2);
        ch3.setFont(f2);

        bt1 = new JButton("Submit");
        bt2= new JButton("Cancel");

        bt1.setBackground(navy);
        bt2.setBackground(navy);

        bt1.setForeground(fontColorOrange);
        bt2.setForeground(fontColorOrange);
        bt1.addActionListener(this);
        bt2.addActionListener(this);

        bt1.setFont(f2);
        bt2.setFont(f2);

        p1= new JPanel();
        p1.setLayout(new GridLayout(4,2,10,10));
        p1.add(l1);
        p1.add(ch3);
        p1.add(l2);
        p1.add(ch1);
        p1.add(l3);
        p1.add(ch2);
        p1.add(bt1);
        p1.add(bt2);
        p1.setBackground(lightBlue);//light blue

        p2= new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l4);
        p2.setBackground(lightBlue);

        setLayout(new BorderLayout(0,0));
        add(p2,"North");
        add(p1,"Center");

    }


    public void actionPerformed(ActionEvent e)
    {
        String RecepitNo = ch3.getSelectedItem();
        String time = ch1.getSelectedItem();
        String attendance = ch2.getSelectedItem();

        String data= new java.util.Date().toString();
        if(e.getSource()==bt1)
        {
            try
            {
                ConnectionClass obj1 = new ConnectionClass();
                String q1="insert into member_attendance values('"+RecepitNo+"' ,'"+time+"','"+attendance+"','"+data+"')";

                obj1.stm.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"insert data successfully");
               setVisible(false);
            }

            catch(Exception ex){

                ex.printStackTrace();
            }
        }

        if(e.getSource()==bt2)
        {
            JOptionPane.showMessageDialog(null,"are you share.........");
            setVisible(false);

        }


    }

    public static void main(String[] args) {

        new AttendanceMPage().setVisible(true);
    }

}