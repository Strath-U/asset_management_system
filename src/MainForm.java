import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;

public class MainForm extends JFrame {
    private Connection conn;

    public MainForm(Connection conn) {
        this.conn = conn;
        setTitle("Fleet Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu mainMenu = new JMenu("Main");
        JMenuItem addVehicleMenuItem = new JMenuItem("Add Vehicle");
        mainMenu.add(addVehicleMenuItem);
        menuBar.add(mainMenu);

        JMenu userMenu = new JMenu("Users");
        JMenuItem createUserMenuItem = new JMenuItem("Create New User");
        createUserMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new CreateUserForm(conn).setVisible(true);
            }
        });
        JMenuItem manageUserMenuItem = new JMenuItem("Manage Users");
        userMenu.add(createUserMenuItem);
        userMenu.add(manageUserMenuItem);
        menuBar.add(userMenu);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainForm(null).setVisible(true));
    }
}
