import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class RegisterListener implements ActionListener {
    JFrame frame;
    Controller cont;
    public RegisterListener(JFrame frame, Controller cont) {
        this.frame = frame;
        this.cont = cont;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RegisterPage rPage = new RegisterPage(cont);
    }
}
