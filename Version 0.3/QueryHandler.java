import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class QueryHandler {
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public boolean connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "Hektor*3261");
            stmt = conn.createStatement();
            System.out.println("Connected!");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem!");

        }

        //cont.addDoctor();
        //cont.addPatient();
        return true;

    }
    public boolean handleQuery(String query){
        try{
            stmt.executeUpdate(query);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error");
            return false;
        }
        return true;
    }
}
