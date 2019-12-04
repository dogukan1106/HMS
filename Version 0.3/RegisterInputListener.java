import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("deprecation")

public class RegisterInputListener implements ActionListener{
    JFrame frame;
    JTextField name;
    JPasswordField password;
    JTextField tckn;

    public RegisterInputListener(JFrame frame, JTextField name, JPasswordField password, JTextField tckn){
        this.frame = frame;
        this.name = name;
        this.password = password;
        this.tckn = tckn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nameInput = name.getText();   //receive input from text field
        String tcknInput = tckn.getText();
        String passwordInput = new PasswordHash(password.getText()).hashed;


        System.out.println("name: " + nameInput);
        System.out.println("password: " + passwordInput);
        System.out.println("tckn: " + tcknInput + "\n");
    }
}
