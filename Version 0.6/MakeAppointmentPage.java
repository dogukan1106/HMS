import java.awt.*;

import javax.swing.*;

public class MakeAppointmentPage {

    private JFrame frame;
    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public MakeAppointmentPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Choose an appointment type");
        label.setForeground(Color.red);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        label.setBounds(100,20,300,70);
        frame.getContentPane().add(label);
        JButton btndfilter = new JButton("Filter by doctor");
        JButton btntfilter = new JButton("Filter by time");
        btndfilter.setBounds(50,85,150,50);
        btndfilter.setBackground(Color.orange);
        btndfilter.addActionListener(new FilterByDoctorListener(frame));
        btntfilter.setBounds(250,85,150,50);
        btntfilter.setBackground(Color.orange);
        btntfilter.addActionListener(new FilterByTimeListener(frame));
        frame.add(btndfilter);
        frame.add(btntfilter);



        frame.setVisible(true);
    }
}