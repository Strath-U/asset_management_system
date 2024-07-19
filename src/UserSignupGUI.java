<<<<<<< HEAD
import java.sql.Connection;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserSignupGUI{
    private static Userdetails loggedInUser;
    private static Connection connection;
    private static JButton detailsButton;
    private static JTextArea userDetailsArea;
    private static JButton registerButton;

    public static void main(String[] args) {

        try {
            connection = Databaseconnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        frame.setSize(300, 200);
=======
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserSignupGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(100, 100);
>>>>>>> 7e26c47438836f4cc3109bc2103a6db020b6f076
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

<<<<<<< HEAD
        JLabel userLabel = new JLabel("Username:");
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

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);

        JLabel messageLabel = new JLabel("");
        messageLabel.setBounds(10, 110, 300, 25);
        panel.add(messageLabel);

        detailsButton = new JButton("Get Details");
        detailsButton.setBounds(100, 80, 120, 25);
        detailsButton.setEnabled(false);
        panel.add(detailsButton);

        userDetailsArea = new JTextArea();
        userDetailsArea.setBounds(10, 140, 350, 100);
        userDetailsArea.setEditable(false);
        panel.add(userDetailsArea);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(230, 80, 100, 25);
        panel.add(registerButton);


        frame.add(panel);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                boolean isAuthenticated = Authentication.authenticate(username, password);
                if (isAuthenticated) {
                    messageLabel.setText("Login successful!");
                    loggedInUser = Userdetailretriver.getUserDetails(connection, username);
                    detailsButton.setEnabled(true);
                } else {
                    messageLabel.setText("Invalid username or password.");
                }
            }
        });
        detailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailsFrame();
            }


    });
        registerButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Registrationform.main(new String[]{});
        }
    });
}

    private static void showDetailsFrame() {
        if (loggedInUser != null) {
            JFrame detailsFrame = new JFrame("User Details");
            detailsFrame.setSize(400, 300);
            detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JPanel detailsPanel = new JPanel();
            detailsPanel.setLayout(null);

            JTextArea userDetailsArea = new JTextArea();
            userDetailsArea.setBounds(10, 10, 350, 200);
            userDetailsArea.setEditable(false);
            userDetailsArea.setText("Username: " + loggedInUser.getusername() + "\n"
                    + "Email: " + loggedInUser.getemail() + "\n"
                    + "Last Name: " + loggedInUser.getLast_name() + "\n"
                    + "Phone Number: " + loggedInUser.getPhone_number() + "\n"
                    + "First Name: " + loggedInUser.getfirst_name());
            detailsPanel.add(userDetailsArea);

            detailsFrame.add(detailsPanel);
            detailsFrame.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "No user details available. Please log in first.");
        }
    }

}









=======
    }
}
>>>>>>> 7e26c47438836f4cc3109bc2103a6db020b6f076
