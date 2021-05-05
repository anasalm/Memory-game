import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButton implements ActionListener {

    public JButton createButton(int e){
        JButton button = new JButton("memorybricka" + e);
    
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("klick");

        staticFrame staticFrame = new staticFrame();
        JLabel label = new JLabel("antal rätt: 0");
        PanelMaker panelMaker = new PanelMaker();
        JPanel panel = panelMaker.createPanel(label, createButton(1));

        System.out.println("klick");

        JFrame frame = staticFrame.createFrame(createButton(1), panel);
        //button.setVisible(false);

    }
}
