import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("deprecation")

public class TextFieldListener implements ActionListener{
    JFrame frame;
    JTextField name;
    JPasswordField password;
    JTextField tckn;
    JTextField email;
    String sql;
    QueryHandler handler = new QueryHandler();

    public TextFieldListener(JFrame frame, JTextField name, JPasswordField password, JTextField tckn){
        //for Register
        this.frame = frame;
        this.name = name;
        this.password = password;
        this.tckn = tckn;
    }

    public TextFieldListener(JFrame frame, JTextField email,JPasswordField password){
        //For Sign-In
        this.frame = frame;
        this.email = email;
        this.password = password;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handler.connect();
        if(!name.equals(""))//If its register page
        {
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

            sql= "INSERT INTO hms.patient(p_Tckn, p_Name, p_Email, p_Hashpw) " +
                    "VALUES("+
                    tcknInput + "," +
                    nameInput + "," +
                    "'emrekarakuz@gmail.com'" + "," +
                    passwordInput + ");";


            //cont.addPatient(nameInput,passwordInput, "'emrekarakuz@gmail.com'",tcknInput);
            if(handler.handleQuery(sql)){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You Registered :)");
            }
            else{
                JOptionPane.showMessageDialog(null,"Something bad happened!");
            }


        }
        else{//If its login page
            String mail = email.getText();
            mail = "'" + mail + "'";

            String tcknInput = tckn.getText();
            tcknInput = "'" + tcknInput + "'";

            String p = password.getText();
            String passwordInput = new PasswordHash(p).hash();

            passwordInput = "'" + passwordInput + "'";

            try {
                //cont.login(mail,passwordInput);
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You have loged on!");
            } catch(Exception exc){
                //Wrong input/email/tckn type
            }

        }

    }
}
