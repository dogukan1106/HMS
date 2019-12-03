import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Controller {
    public Object addDoctor;
    Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public Controller(Connection conn, Statement stmt, PreparedStatement pstmt) {
        this.conn = conn;
        this.stmt = stmt;
        this.pstmt = pstmt;
    }

    String sql;
    public void addAdmin(){
            sql = "INSERT INTO administrator(a_Hashpw, a_Email) " +
                    "VALUES('12345678', 'emrekarakuz@gmail.com')";
            //Should be taken as input
            //Hash value of password
            //e-mail should be checked before
            try {
                stmt.executeUpdate(sql);
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }
    

    



    

}
    class removeDoctor implements ActionListener{
        public void actionPerformed(ActionEvent a){

        }
    }



