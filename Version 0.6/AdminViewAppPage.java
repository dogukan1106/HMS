import java.awt.*;

import javax.swing.*;

public class AdminViewAppPage {

    private JFrame frame;

    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public AdminViewAppPage() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.getContentPane().setBackground(Color.yellow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel label = new JLabel("Appointments");
        label.setForeground(Color.black);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 16));
        label.setBounds(150,20,200,70);
        frame.getContentPane().add(label);

        frame.setVisible(true);
    }
}