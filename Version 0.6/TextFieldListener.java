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

    public TextFieldListener(JFrame frame,JTextField email , JPasswordField password, JTextField tckn, JTextField name){
        //for Register
        this.frame = frame;
        this.name = name;
        this.password = password;
        this.tckn = tckn;
        this.email = email;
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
        if(!(name == null))//If its register page
        {
            String emailInput = email.getText();
            emailInput = "'" + emailInput + "'";

            String tcknInput = tckn.getText();
            tcknInput = "'" + tcknInput + "'";

            String p = password.getText();
            String passwordInput = new PasswordHash(p).hash();

            String nameInput = name.getText();
            nameInput = "'" + nameInput + "'";

            passwordInput = "'" + passwordInput + "'";

            //System.out.println("name: " + nameInput);
            //System.out.println("password: " + passwordInput);
            //System.out.println("tckn: " + tcknInput + "\n");
            if(tcknInput.equals("''")){
                sql ="INSERT INTO hms.patient(p_Name, email, hashpw) " +
                    "VALUES("+
                    nameInput + "," +
                    emailInput + "," +
                    passwordInput + ");";

            }
            else {
                sql = "INSERT INTO hms.patient(p_Tckn, p_Name, email, hashpw) " +
                        "VALUES(" +
                        tcknInput + "," +
                        nameInput + "," +
                        emailInput + "," +
                        passwordInput + ");";

            }
            //cont.addPatient(nameInput,passwordInput, "'emrekarakuz@gmail.com'",tcknInput);
            if(handler.handleQuery(sql, "")){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You Registered :)");
            }
            else{
                JOptionPane.showMessageDialog(null,"Something bad happened!");
            }


        }
        else if(LoginPage.role == 1)//If its patient-login page
        {
            String mail = email.getText();
            mail = "'" + mail + "'";

            String p = password.getText();
            String passwordInput = new PasswordHash(p).hash();

            passwordInput = "'" + passwordInput + "'";

            sql = "SELECT * FROM hms.patient WHERE email =" + mail ;
            System.out.println(sql);


            if(handler.handleQuery(sql, passwordInput.substring(1,passwordInput.length()-1))){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You have logged on");
                Patientpage pPage = new Patientpage();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect email or password");
            }
        }
        else if(LoginPage.role == 2){//If its doctor-login page
            String mail = email.getText();
            mail = "'" + mail + "'";

            String p = password.getText();
            String passwordInput = new PasswordHash(p).hash();

            passwordInput = "'" + passwordInput + "'";

            sql = "SELECT * FROM hms.doctor WHERE email =" + mail ;
            System.out.println(sql);


            if(handler.handleQuery(sql, passwordInput.substring(1,passwordInput.length()-1))){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You have logged on");
                DoctorPage dPage = new DoctorPage();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect email or password");
            }
        }
        else if(LoginPage.role == 3){//If its admin-login page
            String mail = email.getText();
            mail = "'" + mail + "'";

            String p = password.getText();
            String passwordInput = new PasswordHash(p).hash();

            passwordInput = "'" + passwordInput + "'";

            sql = "SELECT * FROM hms.administrator WHERE email =" + mail ;
            System.out.println(sql);


            if(handler.handleQuery(sql, passwordInput.substring(1,passwordInput.length()-1))){
                frame.dispose();
                JOptionPane.showMessageDialog(null,"You have logged on");
                AdministratorPage aPage = new AdministratorPage();
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect email or password");
            }
        }


    }

    public String login(String tableName){
        String mail = email.getText();
        mail = "'" + mail + "'";

        String p = password.getText();
        String passwordInput = new PasswordHash(p).hash();

        passwordInput = "'" + passwordInput + "'";

        sql = "SELECT * FROM"+ tableName + "WHERE email =" + mail ;

        return "";
    }
}
