import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;

import static javax.swing.JOptionPane.*;

public class AddTrainerPage extends JFrame{
    private JFrame frame ;
    private JLabel imgLabel ;
    private ImageIcon AddTrainerBg ;
    private JTextField idText , firstnameText , lastnameText, emailText, addressText , phoneText , genderText  ;
    private JComboBox genderChoice;
    private JButton saveBtn , cancelBtn ;
    private Font myFont = new Font("monospace" , Font.BOLD , 24 );
    private Color fontColor = Color.decode("#e97025");
    private Color lightBlue = Color.decode("#a1cff0");

    public AddTrainerPage(){

        // Adding AddTrainerPage BG
        AddTrainerBg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./Images/AddTrainerImg.png")));
        JLabel imgLabel = new JLabel(AddTrainerBg);
        imgLabel.setBounds(0,-3 , 1547,850);

        // Label for idText
        JLabel idLabel = new JLabel("Trainer Id : "); // Creates a JLabel instance with the specified text.
        idLabel.setBounds(850,200,200,25); // Moves and resizes this component.
        idLabel.setFont(myFont);
        idLabel.setForeground(fontColor);
        imgLabel.add(idLabel); // Adding nameLabel

        // TextField for Id label
        idText = new JTextField(); // Constructs a new TextField. A default model is created, the initial string is null .
        idText.setBounds(1000,200,330,35); // Moves and resizes this component.
        idText.setFont(myFont); // Sets the current font.
        idText.setBackground(lightBlue); // Sets the background color of this component.
        idText.setForeground(fontColor); // Sets the foreground color of this component.
        imgLabel.add(idText); // Appends the specified component to the end of this container.

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


        // Save btn
        JButton saveBtn = new JButton("Save");
        saveBtn.setBounds(840,650,200,40);
        saveBtn.setFont(myFont);
        saveBtn.setBackground(lightBlue);
        saveBtn.setForeground(fontColor);
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int TId = Integer.parseInt(idText.getText());
                String FirstName = firstnameText.getText();
                String LastName = lastnameText.getText();
                String Email = emailText.getText();
                String Address = addressText.getText();
                String Phone = phoneText.getText();
                String Gender = (String) genderChoice.getSelectedItem();

                try{
                    ConnectionClass obj = new ConnectionClass();
                    String query = "INSERT INTO AddTrainer values('"+TId+"' , '"+FirstName+"' , '"+LastName+"' ,'"+Email+"' , '"+Address+"' ,'"+Phone+"' , '"+Gender+"' )";
                    obj.stm.executeUpdate(query);
                    JOptionPane.showMessageDialog(imgLabel,"Data Inserted !!!");
                    setVisible(false);
                    new HomePage().setVisible(true);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            });
        imgLabel.add(saveBtn);

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

        new AddTrainerPage().setVisible(true);

    }


}
