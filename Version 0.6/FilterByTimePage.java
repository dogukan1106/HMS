import java.awt.*;

import javax.swing.*;

public class FilterByTimePage {

    private JFrame frame;
    public String[] timeslots = {"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"};



    /**
     * Launch the application.
     */


    /**
     * Create the application.
     */
    public FilterByTimePage() {
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


        JLabel label = new JLabel("Select a time-slot");
        label.setForeground(Color.black);
        label.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        label.setBounds(30,20,200,70);
        frame.getContentPane().add(label);


        JComboBox time_slots = new JComboBox(timeslots);
        time_slots.setBounds(30, 70, 173, 23);
        time_slots.addActionListener(new FilterByTimeListener(frame));
        frame.getContentPane().add(time_slots);

        frame.setVisible(true);
    }
}