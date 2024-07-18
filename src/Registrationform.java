import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class Registrationform {
    private static Connection connection;

    public static void main(String[] args) {
        // Initialize the database connection
        try {
            connection = Databaseconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        JFrame frame = new JFrame("User Registration");
        JPanel panel = new JPanel();
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);

        JLabel userLabel = new JLabel("username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JLabel emailLabel = new JLabel("email:");
        emailLabel.setBounds(10, 80, 80, 25);
        panel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        panel.add(emailText);

        JLabel phone_numberlable = new JLabel("phone_number:");
        phone_numberlable.setBounds(10, 110, 80, 25);
        panel.add(phone_numberlable);

        JTextField phone_numberText = new JTextField(20);
        phone_numberText.setBounds(100, 110, 165, 25);
        panel.add(phone_numberText);

        JLabel first_nameLabel = new JLabel("first_name:");
        first_nameLabel.setBounds(10, 140, 80, 25);
        panel.add(first_nameLabel);

        JTextField first_nameText = new JTextField(20);
        first_nameText.setBounds(100, 140, 165, 25);
        panel.add(first_nameText);

        JLabel last_nameLabel = new JLabel("last_name:");
        last_nameLabel.setBounds(10, 170, 80, 25);
        panel.add(last_nameLabel);

        JTextField last_nameText = new JTextField(20);
        last_nameText.setBounds(100, 170, 165, 25);
        panel.add(last_nameText);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(10, 200, 150, 25);
        panel.add(registerButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 230, 300, 25);
        panel.add(messageLabel);

        frame.add(panel);
        frame.setVisible(true);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                String email = emailText.getText();
                String phone_number = phone_numberText.getText();
                String first_name = first_nameText.getText();
                String last_name = last_nameText.getText();

                Userdetails newUser = new Userdetails();
                newUser.setusername(username);
                newUser.setPassword(password);
                newUser.setemail(email);
                newUser.setPhone_number(phone_number);
                newUser.setfirst_name(first_name);
                newUser.setLast_name(last_name);

                boolean isRegistered = Userregistration.registerUser(connection, newUser);
                if (isRegistered) {
                    messageLabel.setText("Registration successful!");
                } else {
                    messageLabel.setText("Registration failed. Try again.");
                }
            }
        });
    }
}
