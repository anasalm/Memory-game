import javax.swing.*;
import java.awt.*;

public class PanelMaker {

    public JPanel createPanel(JLabel label, JButton button){
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
        panel.setLayout(new GridLayout(2,3));
        panel.add(button);
        panel.add(label);
        return panel;
    }


}
