import java.sql.*;

public class main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        PreparedStatement pstmt = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "13212karE");
            stmt = conn.createStatement();
            System.out.println("Connected!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Problem!");
        }


        Controller cont = new Controller(conn,stmt,pstmt);
        //cont.addAdmin();
        //cont.addDoctor();
        //cont.addPatient();
        
        MainPage mPage = new MainPage(cont);

    }
}
