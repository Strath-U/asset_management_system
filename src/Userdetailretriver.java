import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdetailretriver {

    public static Userdetails getUserDetails(Connection connection, String username) {
        Userdetails userDetails = null;
        String query = "SELECT username, password, email,first_name,last_name,phone_number,user_id FROM Users WHERE username = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                userDetails = new Userdetails();
                userDetails.setusername(resultSet.getString("username"));
                userDetails.setPassword(resultSet.getString("password"));
                userDetails.setemail(resultSet.getString("email"));
                userDetails.setfirst_name(resultSet.getString("first_name"));
                userDetails.setLast_name(resultSet.getString("last_name"));
                userDetails.setPhone_number(resultSet.getString("phone_number"));
                userDetails.setUser_id(resultSet.getString("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDetails;
    }
}
