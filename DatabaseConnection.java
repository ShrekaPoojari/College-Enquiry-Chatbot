import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseConnection {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/college_enquiry_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "pass@123";

    // Method to connect to the database
    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Explicitly load the driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Method to fetch answer based on user input
    public static String getResponse(String userQuestion) {
        String response = "Sorry, I didn't understand that. Could you please rephrase?";
        try (Connection conn = getConnection()) {
            String query = "SELECT answer FROM faq WHERE question LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%" + userQuestion + "%");

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response = rs.getString("answer");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
