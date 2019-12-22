

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class FilterByDoctorMakeAppListener implements ActionListener {

    JFrame frame;
    DefaultListModel model;
    JComboBox tBox;
    JComboBox dBox;
    JComboBox dateBox;

    public FilterByDoctorMakeAppListener(JFrame frame, DefaultListModel model, JComboBox tBox, JComboBox dBox, JComboBox dateBox) {

        this.frame = frame;
        this.model = model;
        this.tBox = tBox;
        this.dBox = dBox;
        this.dateBox = dateBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        QueryHandler handler = new QueryHandler();
        handler.connect();
        int d_id = 0;
        int p_id = 0;

        try{
            ResultSet rs = handler.stmt.executeQuery("select * from make_appointments natural join doctor where d_name = '"+dBox.getSelectedItem()+"' " +
                    "and checkin_time = '"+tBox.getSelectedItem()+"' and date = '"+dateBox.getSelectedItem()+"'");
            while (rs.next()){

            }

        }
        catch (Exception b){
            b.printStackTrace();
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
