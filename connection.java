import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    static Connection connection;
    public static Connection createConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hit","root","Kumar@123");

        return connection;
    }
}
