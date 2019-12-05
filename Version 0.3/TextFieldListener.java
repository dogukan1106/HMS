import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("deprecation")

public class RegisterInputListener implements ActionListener{
    Controller cont;
    JFrame frame;
    JTextField name;
    JPasswordField password;
    JTextField tckn;

    public RegisterInputListener(JFrame frame, Controller cont, JTextField name, JPasswordField password, JTextField tckn){
        this.frame = frame;
        this.name = name;
        this.password = password;
        this.tckn = tckn;
        this.cont = cont;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String nameInput = name.getText();
        nameInput = "'" + nameInput + "'";

        String tcknInput = tckn.getText();
        tcknInput = "'" + tcknInput + "'";

        String p = password.getText();
        String passwordInput = new PasswordHash(p).hash();

        passwordInput = "'" + passwordInput + "'";

        //System.out.println("name: " + nameInput);
        //System.out.println("password: " + passwordInput);
        //System.out.println("tckn: " + tcknInput + "\n");
        
         try {
            cont.addPatient(nameInput,passwordInput, "'emrekarakuz@gmail.com'",tcknInput);
            frame.dispose();
            JOptionPane.showMessageDialog(null,"You Registered :)");
        } catch(Exception exc){
            //Wrong input/email/tckn type
        }
        
    }
}
