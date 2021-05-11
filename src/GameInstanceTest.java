import javax.swing.*;
import java.awt.*;

public class GameInstanceTest extends JFrame {

    int count =0;
    JLabel label;

    public void GameInstanceTest(JFrame frame){

        JFrame newframe = frame;

        MemoryButton buttonInstance = new MemoryButton();
        JButton button = buttonInstance.createButton(1);
        //button.addActionListener(this);

        label = new JLabel("wow vad hände här?");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
        panel.setLayout(new GridLayout(2,3));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}