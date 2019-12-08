import java.awt.*;

import javax.swing.*;

public class RegisterPage {
    private JFrame frame;
    private JTextField email;
    private JPasswordField password;
    private JTextField tckn;
    private JTextField name;

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public RegisterPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 400);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.getContentPane().setLayout(null);

        JLabel lblemail = new JLabel("E-Mail");
        lblemail.setBounds(82, 52, 68, 27);
        frame.getContentPane().add(lblemail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(82, 107, 68, 27);
        frame.getContentPane().add(lblPassword);

        JLabel lblTckn = new JLabel("TCKN (Optional)");
        lblTckn.setBounds(82, 162, 150, 27);
        frame.getContentPane().add(lblTckn);

        JLabel nameLbl = new JLabel("Name");
        nameLbl.setBounds(82, 217, 150, 27);
        frame.getContentPane().add(nameLbl);

        email = new JTextField();
        email.setBounds(199, 55, 160, 20);
        frame.getContentPane().add(email);
        email.setColumns(10);

        password = new JPasswordField();
        password.setEchoChar('*');
        password.setBounds(199, 110, 160, 20);
        frame.getContentPane().add(password);
        password.setColumns(10);

        tckn = new JTextField();
        tckn.setDocument(new JTextFieldLimit(11));
        tckn.setBounds(199, 165, 160, 20);
        frame.getContentPane().add(tckn);
        tckn.setColumns(10);

        name = new JTextField();
        name.setBounds(199, 220, 160, 20);
        frame.getContentPane().add(name);
        name.setColumns(10);


        JLabel label = new JLabel("Register Page");
        label.setForeground(Color.MAGENTA);
        label.setBounds(150, 1, 150, 75);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        frame.getContentPane().add(label);

        JButton register = new JButton("Register");
        register.addActionListener(new TextFieldListener(frame, email, password, tckn, name));
        register.setBounds(235, 250, 87, 23);
        frame.getContentPane().add(register);
        frame.setVisible(true);
    }
}
