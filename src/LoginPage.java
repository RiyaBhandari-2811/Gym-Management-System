import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class LoginPage extends JFrame implements ActionListener {
    private JFrame frame ;
    private ImageIcon loginBg ;
    private JTextField userNameText ;
    private JPasswordField passwordFieldText;
    private JButton loginBtn;
    private  JLabel loginFail ;
    private Font myFont = new Font("monospace" , Font.BOLD , 18);
    private Color fontColor = Color.decode("#e97025");
    private Color lightBlue = Color.decode("#a1cff0");

    public LoginPage () {

        // Adding loginPage BG
        loginBg = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("./Images/LoginPageImg.png")));
        JLabel imgLabel = new JLabel(loginBg);
        imgLabel.setSize(1550, 850);

        // Label for username
        JLabel lb1 = new JLabel("UserName:"); // // Creates a JLabel instance with the specified text.
        lb1.setBounds(890, 390, 100, 24);
        lb1.setFont(myFont); // Font style or size
        lb1.setForeground(fontColor); // font color
        imgLabel.add(lb1); // Adding userlabel

        // TextField for username label
        userNameText = new JTextField();
        userNameText.setBounds(1000, 390, 228, 30);
        userNameText.setFont(myFont);
        userNameText.setBackground(lightBlue);
        userNameText.setForeground(fontColor);
        imgLabel.add(userNameText);

        // Label for password
        JLabel lb2 = new JLabel("Password:");
        lb2.setBounds(890, 480, 100, 24);
        imgLabel.add(lb2);
        lb2.setFont(myFont);
        lb2.setForeground(fontColor);

        // TextField for password label
        passwordFieldText = new JPasswordField();
        passwordFieldText.setBounds(1000, 480, 228, 30);
        imgLabel.add(passwordFieldText);
        passwordFieldText.setFont(myFont);
        passwordFieldText.setBackground(lightBlue);
        passwordFieldText.setForeground(fontColor);

        // Login btn with its action listener
        loginBtn = new JButton("Login");
        loginBtn.setBounds(950, 580, 230, 30);
        loginBtn.setFont(myFont);
        loginBtn.setBackground(lightBlue);
        loginBtn.setForeground(fontColor);
        loginBtn.addActionListener(this);
        imgLabel.add(loginBtn);

        loginFail = new JLabel("");
        loginFail.setBounds(870, 630, 500, 30);
        loginFail.setFont(myFont);
        loginFail.setBackground(lightBlue);
        loginFail.setForeground(fontColor);
        imgLabel.add(loginFail);

        frame = new JFrame("Login Form");
        frame.add(imgLabel);
        frame.setSize(1550, 850);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginPage();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
            String user = userNameText.getText();
            String password = passwordFieldText.getText();

            if(user.equals("Admin") && password.equals("admin")){
                loginFail.setText("");
                this.setVisible(false);
                new HomePage().setVisible(true);
            }else{
                loginFail.setText("Please Fill Correct UserName and Password !!");
            }
        }
}
