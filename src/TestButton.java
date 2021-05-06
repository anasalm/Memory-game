import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton implements ActionListener {
    GameInstanceTest newInstance = new GameInstanceTest();

    public JButton createButton(int e){
        JButton button = new JButton("memorybricka" + e);
    
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("klick");
        //newInstance.GameInstanceTest(frame);
        //button.setVisible(false);

    }
}
