import java.awt.*;

import javax.swing.*;

public class RegisterPage {
    private JFrame frame;
    private JTextField username;
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
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Register Page");
        label.setForeground(Color.MAGENTA);
        label.setBounds(150,25,150,75);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        frame.getContentPane().add(label);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(82, 79, 68, 27);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(82, 134, 68, 27);
        frame.getContentPane().add(lblPassword);

        JLabel lblTckn = new JLabel("TCKN (Optional)");
        lblTckn.setBounds(82, 180, 150, 27);
        frame.getContentPane().add(lblTckn);

        tckn = new JTextField();
        tckn.setBounds(199, 180, 96, 20);
        frame.getContentPane().add(tckn);
        tckn.setColumns(10);

        username = new JTextField();
        username.setBounds(199, 82, 96, 20);
        frame.getContentPane().add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setEchoChar('*');
        password.setBounds(199, 137, 96, 20);
        frame.getContentPane().add(password);
        password.setColumns(10);

        tckn = new JTextField();
        tckn.setBounds(199, 180, 96, 20);
        frame.getContentPane().add(tckn);
        tckn.setColumns(10);

        JButton register = new JButton("Register");
       register.addActionListener(new CheckRegisterListener(frame));
        register.setBounds(199, 228, 87, 23);
        frame.getContentPane().add(register);
        frame.setVisible(true);
    }
}
