import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class UpdateTrainerPage extends JFrame {

    private JFrame frame ;
    private JLabel imgLabel ;
    private ImageIcon AddTrainerBg ;
    private JTextField  firstnameText , lastnameText, emailText, addressText , phoneText  ;
    private JComboBox genderChoice , trainerIdChoice;
    private JButton updateBtn , cancelBtn ;
    private Font myFont = new Font("monospace" , Font.BOLD , 24 );
    private Color fontColor = Color.decode("#e97025");
    private Color lightBlue = Color.decode("#a1cff0");

    public UpdateTrainerPage(){
        // Adding AddTrainerPage BG
        AddTrainerBg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./Images/UpdateTrainerBG.png")));
        JLabel imgLabel = new JLabel(AddTrainerBg);
        imgLabel.setBounds(0,-3 , 1547,850);

        // Label for idText
        JLabel idLabel = new JLabel("Trainer Id : "); // Creates a JLabel instance with the specified text.
        idLabel.setBounds(850,200,150,25); // Moves and resizes this component.
        idLabel.setFont(myFont);
        idLabel.setForeground(fontColor);
        imgLabel.add(idLabel); // Adding nameLabel

        // Choice menu for trainer Id
        Choice trainerIdChoice = new Choice(); // Creates a new choice menu. AWT
        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT TId FROM addtrainer";
            ResultSet rest = obj.stm.executeQuery(query);
            while(rest.next()){
                trainerIdChoice.add(rest.getString("TId"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        trainerIdChoice.setBounds(1000,200,330,35);
        trainerIdChoice.setFont(myFont);
        trainerIdChoice.setBackground(lightBlue);
        trainerIdChoice.setForeground(fontColor);
        imgLabel.add(trainerIdChoice);

        trainerIdChoice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    int TId = Integer.parseInt(trainerIdChoice.getSelectedItem());
                    String Query1 = "SELECT * FROM addtrainer WHERE TId= '" +TId+"'" ;
                    ResultSet rest1 = obj1.stm.executeQuery(Query1);
                    while (rest1.next()){
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


        // Label for name
        JLabel firstnameLabel = new JLabel("Firstname : "); // Creates a JLabel instance with the specified text.
        firstnameLabel.setBounds(850,260,200,25); // Moves and resizes this component.
        firstnameLabel.setFont(myFont);
        firstnameLabel.setForeground(fontColor);
        imgLabel.add(firstnameLabel); // Adding nameLabel

        // TextField for name label
        firstnameText = new JTextField();
        firstnameText.setBounds(1000,260,330,35);
        firstnameText.setFont(myFont);
        firstnameText.setBackground(lightBlue);
        firstnameText.setForeground(fontColor);
        imgLabel.add(firstnameText);

        // Label for surnameText
        JLabel lastnameLabel = new JLabel("Lastname  : "); // Creates a JLabel instance with the specified text.
        lastnameLabel.setBounds(850,320,200,25); // Moves and resizes this component.
        lastnameLabel.setFont(myFont);
        lastnameLabel.setForeground(fontColor);
        imgLabel.add(lastnameLabel); // Adding nameLabel

        // TextField for surname label
        lastnameText = new JTextField();
        lastnameText.setBounds(1000,320,330,35);
        lastnameText.setFont(myFont);
        lastnameText.setBackground(lightBlue);
        lastnameText.setForeground(fontColor);
        imgLabel.add(lastnameText);

        // Label for emailtext
        JLabel emailLabel = new JLabel("Email-Id  : "); // Creates a JLabel instance with the specified text.
        emailLabel.setBounds(850,380,200,25); // Moves and resizes this component.
        emailLabel.setFont(myFont);
        emailLabel.setForeground(fontColor);
        imgLabel.add(emailLabel); // Adding nameLabel

        // TextField for email label
        emailText = new JTextField();
        emailText.setBounds(1000,380,330,35);
        emailText.setFont(myFont);
        emailText.setBackground(lightBlue);
        emailText.setForeground(fontColor);
        imgLabel.add(emailText);

        // Label for addressText
        JLabel addressLabel = new JLabel("Address  : "); // Creates a JLabel instance with the specified text.
        addressLabel.setBounds(850,440,200,25); // Moves and resizes this component.
        addressLabel.setFont(myFont);
        addressLabel.setForeground(fontColor);
        imgLabel.add(addressLabel); // Adding nameLabel

        // TextField for address label
        addressText = new JTextField();
        addressText.setBounds(1000,440,330,35);
        addressText.setFont(myFont);
        addressText.setBackground(lightBlue);
        addressText.setForeground(fontColor);
        imgLabel.add(addressText);

        // Label for phoneText
        JLabel phoneLabel = new JLabel("Phone  : "); // Creates a JLabel instance with the specified text.
        phoneLabel.setBounds(850,500,200,25); // Moves and resizes this component.
        phoneLabel.setFont(myFont);
        phoneLabel.setForeground(fontColor);
        imgLabel.add(phoneLabel); // Adding nameLabel

        // TextField for Phone label
        phoneText = new JTextField();
        phoneText.setBounds(1000,500,330,35);
        phoneText.setFont(myFont);
        phoneText.setBackground(lightBlue);
        phoneText.setForeground(fontColor);
        imgLabel.add(phoneText);

        // Label for Gender
        JLabel genderLabel = new JLabel("Gender : ");
        genderLabel.setBounds(850,560,150,35);
        genderLabel.setFont(myFont);
        genderLabel.setBackground(lightBlue);
        genderLabel.setForeground(fontColor);
        imgLabel.add(genderLabel);

        // Choice menu for gender
        Choice genderChoice = new Choice(); // Creates a new choice menu. AWT
        genderChoice.add("Male");
        genderChoice.add("Female");
        genderChoice.setBounds(1000,560,330,35);
        genderChoice.setFont(myFont);
        genderChoice.setBackground(lightBlue);
        genderChoice.setForeground(fontColor);
        imgLabel.add(genderChoice);


        // Update btn
        JButton updateBtn = new JButton("Update");
        updateBtn.setBounds(840,650,200,40);
        updateBtn.setFont(myFont);
        updateBtn.setBackground(lightBlue);
        updateBtn.setForeground(fontColor);
        updateBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int TId = Integer.parseInt(trainerIdChoice.getSelectedItem());
                String FirstName = firstnameText.getText();
                String LastName = lastnameText.getText();
                String Email = emailText.getText();
                String Address = addressText.getText();
                String Phone = phoneText.getText();
                String Gender = (String) genderChoice.getSelectedItem();
                try{
                    ConnectionClass obj = new ConnectionClass();
                    String query = "UPDATE AddTrainer SET  FirstName='"+FirstName+"' , LastName='"+LastName+"' , Email='"+Email+"' , Address='"+Address+"' , Phone='"+Phone+"' , Gender='"+Gender+"' WHERE TId='"+TId+"' ";
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
        cancelBtn.setBounds(1090,650,200,40);
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

        frame = new JFrame("Add Trainer Form");
        frame.add(imgLabel);
        frame.setSize(1530, 863);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static void main(String[] args) {

        new UpdateTrainerPage().setVisible(true);

    }

}
