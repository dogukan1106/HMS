import java.sql.*;


public class ViewAppointments {


    public ResultSet view(){
        QueryHandler handler = new QueryHandler();
        handler.connect();
        switch (LoginPage.role){
            case 1:
                try {
                    System.out.println(LoginPage.current_email);
                    Statement stmt = handler.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    ResultSet ID = handler.stmt.executeQuery("select id from patient where email = "+LoginPage.current_email);
                    ID.next();
                    int id = ID.getInt(1);
                    ResultSet rs = stmt.executeQuery("select * from make_appointments where p_id = "+id);
                    return rs;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

            case 2:
                try{
                    Statement stmt = handler.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                    int dId = 0;
                    System.out.println(LoginPage.current_email);
                    ResultSet dIdRs = stmt.executeQuery("select id from doctor where email = "+LoginPage.current_email);
                    while(dIdRs.next()){
                        dId = dIdRs.getInt(1);
                    }
                    ResultSet rs = stmt.executeQuery("SELECT * FROM make_appointments where d_id ="+dId);
                    return rs;
                }

                catch(Exception e){
                    e.printStackTrace();
                }
                break;
            case 3:
                try{
                Statement stmt = handler.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                ResultSet rs = stmt.executeQuery("SELECT * FROM make_appointments");
                return rs;
                }

                catch(Exception e){
                    e.printStackTrace();
                }
                break;



        }
        return null;
    }
}
