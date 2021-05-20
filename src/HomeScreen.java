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
        startButton.setFocusable(false);//Vet inte vad den här gör
        setBounds(100,160,200,40);
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






    }

    /**
    this method will be called when we click "Start"
    Start button must disappear and a new page with 16 images
    ( let's start with just 16 images) will come up and the timer will start.
     */
    public void Start() {

       frame.remove(startButton);
       frame.dispose();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("let's start");
        Start();
        if(e.getSource()==startButton){

        }


    }
    public static void main(String[] args) {

        Board board = new Board();
    }
}