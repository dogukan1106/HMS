import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PatientViewAppPageListener implements ActionListener {
    JFrame frame;
    public PatientViewAppPageListener (JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        PatientViewAppPage appPage = new PatientViewAppPage();
    }


}

