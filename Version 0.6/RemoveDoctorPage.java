import java.awt.*;

import javax.swing.*;

public class RemoveDoctorPage {
    public static int role;
    private JFrame frame;
    private JTextField email;
    private JPasswordField password;
    QueryHandler handler = new QueryHandler();

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public RemoveDoctorPage() {
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

        JLabel label = new JLabel("Remove a Doctor");
        label.setForeground(Color.blue);
        label.setBounds(82,15,150,75);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        frame.getContentPane().add(label);

        JLabel lblEmail = new JLabel("Doctors: ");
        lblEmail.setBounds(82, 79, 68, 27);
        frame.getContentPane().add(lblEmail);

        /*
        email = new JTextField();
        email.setBounds(199, 82, 96, 20);
        frame.getContentPane().add(email);
        email.setColumns(10);
        */
        handler.connect();
        JComboBox doctors = new JComboBox(handler.sendDoctors("SELECT * FROM hms.doctor"));
        doctors.setBounds(199, 82, 150, 20);
        frame.getContentPane().add(doctors);

        JButton removeDoctor = new JButton("Remove");
        removeDoctor.addActionListener(new RemoveQueryListener(frame,doctors));
        removeDoctor.setBounds(199, 160, 87, 23);
        frame.getContentPane().add(removeDoctor);
        frame.setVisible(true);
    }
}
