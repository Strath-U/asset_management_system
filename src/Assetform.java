import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class Assetform extends JFrame {
        private JTextField assetNameField;
        private JTextField assetValueField;
        private JButton submitButton;
        private Connection connection;


        public Assetform(Connection connection) {
            this.connection = connection;
            setTitle("Add New Asset");
            setSize(300, 200);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            assetNameField = new JTextField(20);
            assetValueField = new JTextField(20);
            submitButton = new JButton("Submit");

            panel.add(new JLabel("Asset Name:"));
            panel.add(assetNameField);
            panel.add(new JLabel("Asset Value:"));
            panel.add(assetValueField);
            panel.add(submitButton);

            add(panel);

            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String assetName = assetNameField.getText();
                    String assetValue = assetValueField.getText();
                    try {
                        PreparedStatement pstmt = Assetform.this.connection.prepareStatement("INSERT INTO assets (name, value) VALUES (?, ?)");
                        pstmt.setString(1, assetName);
                        pstmt.setString(2, assetValue);
                        pstmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Asset " + assetName + " with value " + assetValue + " added successfully.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Asset " + assetName + " with value " + assetValue + " added successfully.");
                    }
                }
            });

        }
        public static void main(String[] args) {
            try {
                Connection connection = Databaseconnection.getConnection();
                new Assetform(connection).setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

