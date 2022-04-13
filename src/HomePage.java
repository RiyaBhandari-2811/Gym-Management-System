import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;



public class HomePage extends JFrame implements ActionListener {
    private JFrame frame ;
    private JLabel homePageImgLabel ;
    private ImageIcon HomePageImg ;
    private Font myFont = new Font("monospace" , Font.BOLD , 18);
    private Color fontColor = Color.decode("#e97025");
    private Color lightBlue = Color.decode("#a1cff0");


    public HomePage () {

        // Creates an ImageIcon from the specified URL.
        HomePageImg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./Images/HomePageImg.png")));

        homePageImgLabel = new JLabel(HomePageImg);
        homePageImgLabel.setBounds(0,-5 , 1550,790);

        JMenuBar menuBar = new JMenuBar(); // Creates a new menu bar
        menuBar.setBackground(lightBlue); // Sets the background color of this component.

        JMenu New = new JMenu("New"); // Constructs a new JMenu with the supplied string as its text.
        JMenuItem addT = new JMenuItem("Add Trainer"); // Creates a JMenuItem with the specified text.
        JMenuItem addM = new JMenuItem("Add Member");
        menuBar.add(New);  // Appends the specified menu to the end of the menu bar.
        New.add(addT);
        New.add(addM);
        New.setForeground(fontColor); // Sets the foreground color of this component.
        New.setFont(myFont); // Sets the font for this component.
        addT.setForeground(fontColor);
        addT.setBackground(lightBlue);
        addT.setFont(myFont);
        addM.setForeground(fontColor);
        addM.setBackground(lightBlue);
        addM.setFont(myFont);
        addT.addActionListener(this);
        addM.addActionListener(this);

        JMenu space = new JMenu("  |   "); // Just to create some space and design between two Menu Items .
        space.setForeground(fontColor); // Sets the foreground color of this component.
        space.setFont(myFont); // Sets the font for this component.
        menuBar.add(space);

        JMenu attendance = new JMenu("Attendance");
        JMenuItem attendanceT = new JMenuItem("Trainer Attendance");
        JMenuItem attendanceM = new JMenuItem("Member Attendance");
        menuBar.add(attendance);
        attendance.add(attendanceT);
        attendance.add(attendanceM);
        attendance.setForeground(fontColor); // Sets the foreground color of this component.
        attendance.setFont(myFont); // Sets the font for this component.
        attendanceT.setForeground(fontColor);
        attendanceT.setBackground(lightBlue);
        attendanceT.setFont(myFont);
        attendanceM.setForeground(fontColor);
        attendanceM.setBackground(lightBlue);
        attendanceM.setFont(myFont);
        attendanceT.addActionListener(this);
        attendanceM.addActionListener(this);

        JMenu space2 = new JMenu("  |   ");
        space2.setForeground(fontColor); // Sets the foreground color of this component.
        space2.setFont(myFont); // Sets the font for this component.
        menuBar.add(space2);

        JMenu update = new JMenu("Update");
        JMenuItem updateT = new JMenuItem("Update Trainer");
        JMenuItem updateM = new JMenuItem("Update Member");
        menuBar.add(update);
        update.add(updateT);
        update.add(updateM);
        update.setForeground(fontColor); // Sets the foreground color of this component.
        update.setFont(myFont); // Sets the font for this component.
        updateT.setForeground(fontColor);
        updateT.setBackground(lightBlue);
        updateT.setFont(myFont);
        updateM.setForeground(fontColor);
        updateM.setBackground(lightBlue);
        updateM.setFont(myFont);
        updateT.addActionListener(this);
        updateM.addActionListener(this);


        JMenu space3 = new JMenu("  |   ");
        space3.setForeground(fontColor); // Sets the foreground color of this component.
        space3.setFont(myFont); // Sets the font for this component.
        menuBar.add(space3);


        JMenu payment = new JMenu("PaymentInfo");
        JMenuItem paymentT = new JMenuItem("PaymentInfo Trainer");
        JMenuItem paymentM = new JMenuItem("PaymentInfo Member");
        menuBar.add(payment);
        payment.add(paymentT);
        payment.add(paymentM);
        payment.setForeground(fontColor); // Sets the foreground color of this component.
        payment.setFont(myFont); // Sets the font for this component.
        paymentT.setForeground(fontColor);
        paymentT.setBackground(lightBlue);
        paymentT.setFont(myFont);
        paymentM.setForeground(fontColor);
        paymentM.setBackground(lightBlue);
        paymentM.setFont(myFont);
        paymentT.addActionListener(this);
        paymentM.addActionListener(this);


        JMenu space4 = new JMenu("  |   ");
        space4.setForeground(fontColor); // Sets the foreground color of this component.
        space4.setFont(myFont); // Sets the font for this component.
        menuBar.add(space4);

        JMenu display = new JMenu("Display");
        JMenuItem displayT = new JMenuItem("DisplayInfo Trainer");
        JMenuItem displayM = new JMenuItem("DisplaytInfo Member");
        menuBar.add(display);
        display.add(displayT);
        display.add(displayM);
        display.setForeground(fontColor); // Sets the foreground color of this component.
        display.setFont(myFont); // Sets the font for this component.
        displayT.setForeground(fontColor);
        displayT.setBackground(lightBlue);
        displayT.setFont(myFont);
        displayM.setForeground(fontColor);
        displayM.setBackground(lightBlue);
        displayM.setFont(myFont);
        displayT.addActionListener(this);
        displayM.addActionListener(this);


        frame = new JFrame("Home Page"); // Creates a new, initially invisible Frame with the specified title.
        frame.add(homePageImgLabel);
        frame.setSize(1550,850); // Resizes this component so that it has width width and height height.
        frame.setJMenuBar(menuBar); // Sets the menubar for this frame.
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true); // Shows or hides this Window depending on the value of parameter b .
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String click = e.getActionCommand();

        if(click.equals("Add Trainer")){
            new AddTrainerPage().setVisible(true);
        }
        else if (click.equals("Add Member")){
            new AddMemberPage().setVisible(true);
        }
        else if (click.equals("Trainer Attendance")){
            new AttendanceTPage().setVisible(true);
        }
        else if (click.equals("Member Attendance")){
            new AttendanceMPage().setVisible(true);
        }
        else if (click.equals("Update Trainer")){
            new UpdateTrainerPage().setVisible(true);
        }
        else if (click.equals("Update Member")){
            new UpdateMemberPage().setVisible(true);
        }
        else if (click.equals("PaymentInfo Trainer")){
            new PaymentTrainerPage().setVisible(true);
        }
        else if (click.equals("PaymentInfo Member")){
            new PaymentMemberPage().setVisible(true);
        }
        else if (click.equals("DisplayInfo Trainer")){
            new DisplayTrainerPage().setVisible(true);
        }
        else if (click.equals("DisplaytInfo Member")){
            new DisplayMemberPage().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new HomePage();
    }

}
