import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame implements ActionListener{
    private JButton startButton;
    private JPanel panel;
    private JFrame frame;

    int count =0;
    JLabel label;

    public HomeScreen(){

       // trying to

        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100,100));
        startButton.addActionListener(this);
        panel = new JPanel();
        panel.add(startButton);

        frame = new JFrame();
        frame.add(panel, BorderLayout.SOUTH);
        frame.setTitle("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.pack();




        TestButton buttonInstance = new TestButton();
        JButton button = buttonInstance.createButton(1);
        //button.addActionListener(this);
/*
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
 */
    }

    /**
    this method will be called when we click "Start"
    Start button must disappear and a new page with 16 images
    ( let's start with just 16 images) will come up and the timer will start.
     */
    public void Start() {
        //HomeScreen homeScreen = new HomeScreen();
        //frame.remove(panel);
       // HomeScreen(false)

       frame.remove(startButton);
       repaint();
       //frame.setVisible(true);
        System.out.println("hej");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("let's start");
        Start();

    }
    public static void main(String[] args) {
        new HomeScreen();
    }
}