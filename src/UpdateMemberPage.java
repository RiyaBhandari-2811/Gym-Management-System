import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UpdateMemberPage extends JFrame {
    private JFrame frame ;
    private ImageIcon AddMemberBg ;
    private JTextField  RecepitNoText , firstnameText , lastnameText, emailText, addressText , phoneText ;
    private JComboBox memberIdChoice;
    private JButton updateBtn , cancelBtn ;
    private Font myFont = new Font("monospace" , Font.BOLD , 24 );
    private Color fontColor = Color.decode("#e97025");
    private Color lightBlue = Color.decode("#a1cff0");
   
 

    
    UpdateMemberPage() {
        // Adding AddTrainerPage BG
        AddMemberBg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./Images/UpdateMemberBG.png")));
        JLabel imgLabel = new JLabel(AddMemberBg);
        imgLabel.setBounds(0,-3 , 1547,850);

        // Label for idText
        JLabel idLabel = new JLabel("Member Id : "); // Creates a JLabel instance with the specified text.
        idLabel.setBounds(850,150,150,25); // Moves and resizes this component.
        idLabel.setFont(myFont);
        idLabel.setForeground(fontColor);
        imgLabel.add(idLabel); // Adding nameLabel

        // Choice menu for member Id
        Choice memberIdChoice = new Choice(); // Creates a new choice menu. AWT
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT MId FROM addmember";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next()){
                memberIdChoice.add(rest.getString("MId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        memberIdChoice.setBounds(1000,150,330,35);
        memberIdChoice.setFont(myFont);
        memberIdChoice.setBackground(lightBlue);
        memberIdChoice.setForeground(fontColor);
        imgLabel.add(memberIdChoice);

        memberIdChoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    int MId = Integer.parseInt(memberIdChoice.getSelectedItem());
                    String Query1 = "SELECT * FROM addmember WHERE MId= '" +MId+"'" ;
                    ResultSet rest1 = obj1.stm.executeQuery(Query1);
                    while (rest1.next()){
                        RecepitNoText.setText(rest1.getString("RecepitNo"));
                        firstnameText.setText(rest1.getString("FirstName"));
                        lastnameText.setText(rest1.getString("LastName"));
                        emailText.setText(rest1.getString("Email"));
                        addressText.setText(rest1.getString("Address"));
                        phoneText.setText(rest1.getString("Phone"));
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });


        // Label for RecepitNo
        JLabel RecepitNoLabel = new JLabel("Recepit No : "); // Creates a JLabel instance with the specified text.
        RecepitNoLabel.setBounds(850,210,200,25); // Moves and resizes this component.
        RecepitNoLabel.setFont(myFont);
        RecepitNoLabel.setForeground(fontColor);
        imgLabel.add(RecepitNoLabel); // Adding nameLabel

        // TextField for RecepitNo label
        RecepitNoText = new JTextField(); // Constructs a new TextField. A default model is created, the initial string is null .
        RecepitNoText.setBounds(1000,210,330,35); // Moves and resizes this component.
        RecepitNoText.setFont(myFont); // Sets the current font.
        RecepitNoText.setBackground(lightBlue); // Sets the background color of this component.
        RecepitNoText.setForeground(fontColor); // Sets the foreground color of this component.
        imgLabel.add(RecepitNoText); // Appends the specified component to the end of this container.

        // Label for name
        JLabel firstnameLabel = new JLabel("Firstname : "); // Creates a JLabel instance with the specified text.
        firstnameLabel.setBounds(850,270,200,25); // Moves and resizes this component.
        firstnameLabel.setFont(myFont);
        firstnameLabel.setForeground(fontColor);
        imgLabel.add(firstnameLabel); // Adding nameLabel

        // TextField for name label
        firstnameText = new JTextField();
        firstnameText.setBounds(1000,270,330,35);
        firstnameText.setFont(myFont);
        firstnameText.setBackground(lightBlue);
        firstnameText.setForeground(fontColor);
        imgLabel.add(firstnameText);

        // Label for surnameText
        JLabel lastnameLabel = new JLabel("Lastname  : "); // Creates a JLabel instance with the specified text.
        lastnameLabel.setBounds(850,330,200,25); // Moves and resizes this component.
        lastnameLabel.setFont(myFont);
        lastnameLabel.setForeground(fontColor);
        imgLabel.add(lastnameLabel); // Adding nameLabel

        // TextField for surname label
        lastnameText = new JTextField();
        lastnameText.setBounds(1000,330,330,35);
        lastnameText.setFont(myFont);
        lastnameText.setBackground(lightBlue);
        lastnameText.setForeground(fontColor);
        imgLabel.add(lastnameText);

        // Label for emailtext
        JLabel emailLabel = new JLabel("Email-Id  : "); // Creates a JLabel instance with the specified text.
        emailLabel.setBounds(850,390,200,25); // Moves and resizes this component.
        emailLabel.setFont(myFont);
        emailLabel.setForeground(fontColor);
        imgLabel.add(emailLabel); // Adding nameLabel

        // TextField for email label
        emailText = new JTextField();
        emailText.setBounds(1000,390,330,35);
        emailText.setFont(myFont);
        emailText.setBackground(lightBlue);
        emailText.setForeground(fontColor);
        imgLabel.add(emailText);

        // Label for addressText
        JLabel addressLabel = new JLabel("Address  : "); // Creates a JLabel instance with the specified text.
        addressLabel.setBounds(850,450,200,25); // Moves and resizes this component.
        addressLabel.setFont(myFont);
        addressLabel.setForeground(fontColor);
        imgLabel.add(addressLabel); // Adding nameLabel

        // TextField for address label
        addressText = new JTextField();
        addressText.setBounds(1000,450,330,35);
        addressText.setFont(myFont);
        addressText.setBackground(lightBlue);
        addressText.setForeground(fontColor);
        imgLabel.add(addressText);

        // Label for phoneText
        JLabel phoneLabel = new JLabel("Phone  : "); // Creates a JLabel instance with the specified text.
        phoneLabel.setBounds(850,510,200,25); // Moves and resizes this component.
        phoneLabel.setFont(myFont);
        phoneLabel.setForeground(fontColor);
        imgLabel.add(phoneLabel); // Adding nameLabel

        // TextField for Phone label
        phoneText = new JTextField();
        phoneText.setBounds(1000,510,330,35);
        phoneText.setFont(myFont);
        phoneText.setBackground(lightBlue);
        phoneText.setForeground(fontColor);
        imgLabel.add(phoneText);

        // Label for Gender
        JLabel genderLabel = new JLabel("Gender : ");
        genderLabel.setBounds(850,570,150,35);
        genderLabel.setFont(myFont);
        genderLabel.setBackground(lightBlue);
        genderLabel.setForeground(fontColor);
        imgLabel.add(genderLabel);

        // Choice menu for gender
        Choice genderChoice = new Choice(); // Creates a new choice menu.
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.setBounds(1000,570,330,35);
        genderChoice.setFont(myFont);
        genderChoice.setBackground(lightBlue);
        genderChoice.setForeground(fontColor);
        imgLabel.add(genderChoice);

        // Label for MembershipPlanText
        JLabel MemberShipPlanLabel = new JLabel("Plan  : "); // Creates a JLabel instance with the specified text.
        MemberShipPlanLabel.setBounds(850,630,150,25); // Moves and resizes this component.
        MemberShipPlanLabel.setFont(myFont);
        MemberShipPlanLabel.setForeground(fontColor);
        imgLabel.add(MemberShipPlanLabel); // Adding nameLabel

        Choice PlanChoice = new Choice(); // Creates a new choice menu.
        PlanChoice.add("3 Month");
        PlanChoice.add("5 Month");
        PlanChoice.add("7 Month");
        PlanChoice.add("9 Month");
        PlanChoice.add("1 Year");
        PlanChoice.setBounds(1000,630,330,30);
        PlanChoice.setFont(myFont);
        PlanChoice.setBackground(lightBlue);
        PlanChoice.setForeground(fontColor);
        imgLabel.add(PlanChoice);



        // Save btn
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(840,690,200,40);
        updateBtn.setFont(myFont);
        updateBtn.setBackground(lightBlue);
        updateBtn.setForeground(fontColor);
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int MId = Integer.parseInt(memberIdChoice.getSelectedItem());
                int RecepitNo = Integer.parseInt(RecepitNoText.getText());
                String FirstName = firstnameText.getText();
                String LastName = lastnameText.getText();
                String Email = emailText.getText();
                String Address = addressText.getText();
                String Phone = phoneText.getText();
                String Gender = (String) genderChoice.getSelectedItem();
                String MembershipPlan = (String) PlanChoice.getSelectedItem();
                try{
                    ConnectionClass obj = new ConnectionClass();
                    String query = "UPDATE AddMember SET  RecepitNo='"+RecepitNo+"' ,FirstName='"+FirstName+"' , LastName='"+LastName+"' , Email='"+Email+"' , Address='"+Address+"' , Phone='"+Phone+"' , Gender='"+Gender+"', MembershipPlan='"+MembershipPlan+"' WHERE MId='"+MId+"' ";
                    obj.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(imgLabel,"Data Updated !!!");
                    frame.setVisible(false);
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
        imgLabel.add(updateBtn);

        // Cancel btn
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.setBounds(1090,690,200,40);
        cancelBtn.setFont(myFont);
        cancelBtn.setBackground(lightBlue);
        cancelBtn.setForeground(fontColor);
        cancelBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Are you sure ??");
                frame.setVisible(false);
            }

        });
        imgLabel.add(cancelBtn);

        frame = new JFrame("Add Member Form");
        frame.add(imgLabel);
        frame.setSize(1530, 863);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new UpdateMemberPage().setVisible(true);
    }
}
