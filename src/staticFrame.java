import javax.swing.*;
import java.awt.*;

public class staticFrame {

    public staticFrame(){

    }

    public JFrame createFrame(JButton button, JPanel panel){
        JFrame frame = new JFrame();



        //JButton button2 = buttonInstance.createButton(2);



        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setTitle("Game");
        return frame;
    }
}
