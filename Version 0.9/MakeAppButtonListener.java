import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class MakeAppButtonListener implements ActionListener {
    JList dList;
    JFrame frame;
    DefaultListModel model;
    JComboBox tBox;
    JComboBox dBox;

    public MakeAppButtonListener(JList dList, JFrame frame, DefaultListModel model, JComboBox tBox, JComboBox dBox) {
        this.dList = dList;
        this.frame = frame;
        this.model = model;
        this.tBox = tBox;
        this.dBox = dBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QueryHandler handler = new QueryHandler();
        handler.connect();
        int d_id = 0;
        int p_id = 0;
        try {
            ResultSet rs = handler.stmt.executeQuery("select id from doctor where d_Name = '" + dList.getSelectedValue()+"'");
            rs.next();
            d_id = rs.getInt(1);
            ResultSet rsID = handler.stmt.executeQuery("select id from patient where email = "+LoginPage.current_email);
            JOptionPane.showMessageDialog(null,LoginPage.current_email);
            rsID.next();
            p_id = rsID.getInt(1);

        }
        catch (Exception a){
            a.printStackTrace();
        }


        String sql = "insert into make_appointments(p_id,d_id,checkin_time,date) values("+p_id+","+d_id+",'"+tBox.getSelectedItem()+"','"+dBox.getSelectedItem()+"')";
        try {
            handler.stmt.executeUpdate(sql);
        }
        catch (Exception bruh){
            bruh.printStackTrace();
        }
    }
}
