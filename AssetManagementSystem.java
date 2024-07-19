import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;

public class AssetManagementSystem {
    private JTextField searchField;
    private JTextArea resultArea;
    private Connection connection;

    public AssetManagementSystem(Connection connection) {
        this.connection = connection;

        JFrame frame = new JFrame("Asset Management System");
        JPanel panel = new JPanel();
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        // Create the main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Create the search panel with a flow layout
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search Assets"));

        searchField = new JTextField(30);
        JButton searchButton = new JButton("Search");
        JButton clearButton = new JButton("Clear");
        JButton addAssetButton = new JButton("Add Asset");

        searchButton.addActionListener(new SearchListener());
        clearButton.addActionListener(new ClearListener());
        addAssetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Assetform(connection);
            }
        });

        searchPanel.add(new JLabel("Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(clearButton);

        // Create the result area with a scroll pane
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Search Results"));

        mainPanel.add(searchPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
    }

    private class SearchListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the search term from the user input
            String searchTerm = searchField.getText();
            searchAssets(searchTerm);
        }
    }

    private class ClearListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Clear the search field and results area
            searchField.setText("");
            resultArea.setText("");
        }
    }

    public static void main(String[] args) {
        try {
            Connection connection = Databaseconnection.getConnection();
            new AssetManagementSystem(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void searchAssets(String searchTerm) {
        try {
            // Prepare the SQL query with placeholders for search criteria
            String query = "SELECT a.AssetID, a.AssetType, a.Coordinates, a.LocationDetails, a.EstimatedValue, a.OwnershipFees, a.FinancingTracking, a.InsurancePremiums, " +
                    "a.Make, a.Model, a.Year, a.LicensePlate, o.Name as user_name " +
                    "FROM Assets a " +
                    "LEFT JOIN AssetOwners ao ON a.AssetID = ao.AssetID " +
                    "LEFT JOIN users o ON ao.OwnerID = o.user_id " +
                    "WHERE a.AssetType LIKE ? OR a.LocationDetails LIKE ? OR o.Name LIKE ? OR a.Make LIKE ? OR a.Model LIKE ? OR a.LicensePlate LIKE ?";
            PreparedStatement statement = connection.prepareStatement(query);
            // Using wildcards to enable partial matches
            statement.setString(1, "%" + searchTerm + "%");
            statement.setString(2, "%" + searchTerm + "%");
            statement.setString(3, "%" + searchTerm + "%");
            statement.setString(4, "%" + searchTerm + "%");
            statement.setString(5, "%" + searchTerm + "%");
            statement.setString(6, "%" + searchTerm + "%");

            // Execute the query and process the result set
            ResultSet resultSet = statement.executeQuery();
            resultArea.setText("");  // Clear previous results

            while (resultSet.next()) {
                // Append each asset's details to the result area
                resultArea.append("Asset ID: " + resultSet.getInt("AssetID") + "\n");
                resultArea.append("Asset Type: " + resultSet.getString("AssetType") + "\n");
                resultArea.append("Coordinates: " + resultSet.getString("Coordinates") + "\n");
                resultArea.append("Location Details: " + resultSet.getString("LocationDetails") + "\n");
                resultArea.append("Estimated Value: " + resultSet.getBigDecimal("EstimatedValue") + "\n");
                resultArea.append("Ownership Fees: " + resultSet.getBigDecimal("OwnershipFees") + "\n");
                resultArea.append("Financing Tracking: " + resultSet.getString("FinancingTracking") + "\n");
                resultArea.append("Insurance Premiums: " + resultSet.getBigDecimal("InsurancePremiums") + "\n");
                resultArea.append("Make: " + resultSet.getString("Make") + "\n");
                resultArea.append("Model: " + resultSet.getString("Model") + "\n");
                resultArea.append("Year: " + resultSet.getInt("Year") + "\n");
                resultArea.append("License Plate: " + resultSet.getString("LicensePlate") + "\n");
                resultArea.append("user: " + resultSet.getString("user_name") + "\n\n");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace();
        }
    }


}


