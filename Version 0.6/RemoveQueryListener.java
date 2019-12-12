import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveQueryListener implements ActionListener {
    JFrame frame;
    JComboBox email;
    QueryHandler handler = new QueryHandler();
    String sql;

    public RemoveQueryListener(JFrame frame, JComboBox email) {
        this.frame = frame;
        this.email = email;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        handler.connect();

        String emailInput = "'" + String.valueOf(email.getSelectedItem()) + "'";

        sql = "SELECT * FROM hms.doctor WHERE email=" + emailInput;
        if(handler.isEmailExists(sql, String.valueOf(email.getSelectedItem()))){
            sql = "DELETE FROM hms.doctor WHERE email=" + emailInput ;
            handler.handleQuery(sql);
            JOptionPane.showMessageDialog(null,"Doctor Removed");
        }
        else{
            JOptionPane.showMessageDialog(null,"Doctor does not exists");
        }


        AdministratorPage aPage = new AdministratorPage();
    }



}

