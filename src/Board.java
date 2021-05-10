import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Board extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private final int numberOfImages =8 ;
    private final int numberOfCards = 16 ;
private  ImageIcon image;
    Board() {
        makeLabels();
    }


    /**
     * add images to the table.
     */
    public void makeLabels(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Memory");
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(4,4,50,50));

        panel =new JPanel();
        panel.setSize(4000,4000);
        panel.setBackground(Color.CYAN);
        panel.setLayout(new GridLayout(4,4,50,50));

        Border board = BorderFactory.createLineBorder(Color.BLACK,5);

        List<JLabel> labelList = new ArrayList<>();

        for (int i = 0; i < numberOfImages; i++) {
            //image name
            String folder = "icon/image-";
            String prefix = ".png";
            String imageName = folder + i + prefix;
            try{
                image = new ImageIcon(getClass().getResource(imageName));
                // image = new ImageIcon(getClass().getResource("icon/color-palette.png"));
            }catch (Exception  e){
                System.out.println("Image cannot be found!!");
            }
            //scale the images
            Image scaled = scaleImage(image.getImage(),100,100);
            ImageIcon scaledImage  = new ImageIcon(scaled);

            //Add every card two times
            JLabel label  = new JLabel();
            label.setIcon(scaledImage);
            labelList.add(label);
            label.setBorder(board);

            //panel.add(scaledImage);

            JLabel label1 = new JLabel();
            label1.setIcon(scaledImage);
            labelList.add(label1);
            label1.setBorder(board);
        }

        //
        Random rand =new Random();
        for (int j = 0; j < numberOfCards; j++) {
            int randomIndex = rand.nextInt(labelList.size());
            //panel.add(labelList.get(randomIndex));
            frame.add(labelList.get(randomIndex));
            labelList.remove(randomIndex);
        }
        //frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    private Image scaleImage(Image image, int w, int h) {

        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

    }/**
     *trying to make a new frame with buttons. when we click the buttons a card will show up
     */
    public void boardOfButtons(){
        JFrame frame3 = new JFrame();
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setSize(5000,5000);
        frame3.setLayout(new GridLayout(4,4,50,50));

        List<JButton> buttonList = new ArrayList<>();


        for (int i = 0; i < numberOfCards; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(100,100));
            button.setBackground(Color.CYAN);
            JPanel panel = new JPanel();
            frame3.add(button);
            buttonList.add(button);
        }
        frame3.setVisible(true);
        frame3.pack();
    }

    

    public static void main(String[] args) {
        Board board = new Board();
        //board.boardVisible();
        //board.makeLabels();
        board.boardOfButtons();
    }

    public void boardVisible(){

        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500,500);
        frame1.setLayout(new GridLayout(3,3,2,2));
        for (int i = 0; i < 9; i++) {
            JLabel labelTest = new JLabel("hej");
            frame1.add(labelTest);
        }
         //frame1.setVisible(true);
    }

}