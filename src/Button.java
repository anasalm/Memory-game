import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button implements ActionListener {
    JButton button;

    public JButton createButton(int e){
        JButton button = new JButton("memorybricka" + e);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        button.setVisible(false);
    }
}
