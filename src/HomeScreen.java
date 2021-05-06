import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame implements ActionListener{
    private JButton button;
    private JPanel panel;
    private JFrame frame;
    int count =0;
    JLabel label;

    public HomeScreen(){

       // trying to

        button = new JButton("Start");
        button.addActionListener(this);
        panel = new JPanel();
        panel.add(button);

        frame = new JFrame();
        frame.add(panel, BorderLayout.SOUTH);
        frame.setTitle("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);




        TestButton buttonInstance = new TestButton();
        JButton button = buttonInstance.createButton(1);
        //button.addActionListener(this);

        label = new JLabel("antal rätt: 0");


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

    public static void main(String[] args) {
        new HomeScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("let's start");
    }
}



/*
@Override
public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("antal rätt:" + count);
        }

        */