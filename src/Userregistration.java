import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Userregistration {
    public static boolean registerUser(Connection connection, Userdetails userDetails) {
        String query = "INSERT INTO Users (username, password, email, first_name,last_name,phone_number) VALUES (?, ?, ?, ?,?,?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userDetails.getusername());
            statement.setString(2, userDetails.getPassword());
            statement.setString(3, userDetails.getemail());
            statement.setString(4, userDetails.getfirst_name());
            statement.setString(5, userDetails.getLast_name());
            statement.setString(6, userDetails.getPhone_number());

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

