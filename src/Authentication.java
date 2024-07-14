import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
    public static boolean authenticate(String username, String password) {
        String query = "SELECT password FROM Users WHERE username = ?";
            try (Connection connection = Databaseconnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {

                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String storedPassword = resultSet.getString("password");
                    return storedPassword.equals(password);  // Use proper hashing in production
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
}
