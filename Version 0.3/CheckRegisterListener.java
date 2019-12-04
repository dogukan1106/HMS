import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CheckRegisterListener implements ActionListener {
    JFrame frame;
    int role;
    public CheckRegisterListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        JOptionPane.showMessageDialog(null,"You Registered :)");
    }


}

