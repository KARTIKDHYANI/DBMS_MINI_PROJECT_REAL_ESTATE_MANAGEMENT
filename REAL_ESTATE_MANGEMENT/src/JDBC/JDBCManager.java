package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCManager {
    private Connection connection;

    public JDBCManager(String url, String username, String password) {
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Open a connection
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {
            // Create a statement
            Statement statement = connection.createStatement();
            
            // Execute the query
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Other methods for executing update statements, prepared statements, etc. can be added as needed
}
