import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Patientpage {

    private JFrame frame;
    private JTextField email;

    /**
     * Launch the application.
     */
    /**
     * Create the application.
     */
    public Patientpage(JTextField email) {
        this.email = email;
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Patient Page");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.cyan);
        frame.getContentPane().setLayout(null);


        JLabel label = new JLabel("Patient Homepage ");
        label.setForeground(Color.blue);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 15));
        label.setBounds(150,1,200,70);
        frame.getContentPane().add(label);


        JButton btnManagePersonalInfo = new JButton("Manage Personal Info");
        btnManagePersonalInfo.addActionListener(new PersonalInfoListener(frame,email));
        btnManagePersonalInfo.setBounds(120, 60, 173, 23);
        frame.getContentPane().add(btnManagePersonalInfo);


        JButton btnMakeAnAppointment = new JButton("Make an Appointment");
        btnMakeAnAppointment.setBounds(120, 120, 173, 23);
        btnMakeAnAppointment.addActionListener(new MakeAppointmentPageListener(frame));
        frame.getContentPane().add(btnMakeAnAppointment);

        JButton btnViewAppoinments = new JButton("View Appointments");
        btnViewAppoinments.setBounds(120, 180, 173, 23);
        frame.getContentPane().add(btnViewAppoinments);

        btnViewAppoinments.addActionListener(new PatientViewAppPageListener(frame));

        JButton backbutton = new JButton();
        backbutton.setBounds(0,0,73,73);
        try {
            Image img = ImageIO.read(getClass().getResource("backmainb.png"));
            backbutton.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.out.println(e);
        }
        backbutton.addActionListener(new backToMainListener(frame));
        frame.getContentPane().add(backbutton);

        frame.setVisible(true);
    }
}
