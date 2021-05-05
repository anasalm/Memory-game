import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest extends JFrame implements ActionListener {

    int count =0;
    JLabel label;

    public ButtonTest(){

        JFrame frame = new JFrame();

        JButton button = new JButton("memory-bricka");
        button.addActionListener(this);

        label = new JLabel("antal rätt: 0");


        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 50, 100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Board();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("antal rätt:" + count);
    }
}
