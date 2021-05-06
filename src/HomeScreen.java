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

    public HomeScreen(boolean visible ){

       // trying to

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        panel = new JPanel();
        panel.add(startButton);

        frame = new JFrame();
        frame.add(panel, BorderLayout.SOUTH);
        frame.setTitle("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        System.out.println(visible);
        frame.setVisible(visible);
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

    public static void main(String[] args) {

        new HomeScreen(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        /*
        Memory memory = new Memory();
        memory.Start();

         */
        System.out.println("let's start");

    }
    /*
    this method will be called when we click "Start"
    Start button must disappear and a new page with 16 images
    ( let's start with just 16 images) will come up and the timer will start.
     */
    public void Start() {
        HomeScreen homeScreen = new HomeScreen(false);
        frame.remove(panel);

        System.out.println("hej");
    }
}




/*
@Override
public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("antal rätt:" + count);
        }

        */