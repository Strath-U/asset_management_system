import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/Asset management system";
    private static final String USER = "root";
    private static final String PASSWORD = "Student";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
