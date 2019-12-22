import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RemoveQueryListener implements ActionListener {
    JFrame frame;
    JTextField textField;
    public RemoveQueryListener(JFrame frame, JTextField textField) {
        this.textField = textField;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        QueryHandler handler = new QueryHandler();
        handler.connect();


        String sql = "delete from doctor where email = '"+textField.getText()+"'";
        try {
            handler.stmt.executeUpdate(sql);
        }
        catch (Exception boy){
            boy.printStackTrace();
        }
        JOptionPane.showMessageDialog(null,"BRUH");
        AdministratorPage aPage = new AdministratorPage();
    }


}

