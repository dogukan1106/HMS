import javax.swing.*;
import java.sql.*;

public class QueryHandler {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public boolean connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "13212karE");
            stmt = conn.createStatement();
            //System.out.println("Connected!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem!");

        }
        return true;
    }

    public boolean handleQuery(String query) {
        try {
            stmt.executeUpdate(query);
            closeConnection();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean handleQuery(String query, String password){//For log-in
        try (ResultSet rs = stmt.executeQuery(query)) {
            if(rs.next()){
                if(rs.getString("hashpw").equals(password)){
                    closeConnection();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection();
        return false;
    }

    public boolean isEmailExists(String query, String email){
        try (ResultSet rs = stmt.executeQuery(query)) {
            if(rs.next()){
                if(rs.getString("email").equals(email)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error at line66");
        }
    }
}



