import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultyButton implements ActionListener {

    public JButton createButton(String diff){
        JButton button = new JButton(diff);

        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton button = createButton("gogogaog");

        staticFrame staticFrame = new staticFrame();
        JLabel label = new JLabel("vad hände här?");
        PanelMaker panelMaker = new PanelMaker();
        JPanel panel = panelMaker.createPanel(label, button);

        System.out.println("klick");

        JFrame frame = staticFrame.createFrame(button, panel);

        //button.setVisible(false);

    }
}
