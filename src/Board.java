import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Board extends JFrame {

    private JFrame frame;
    private JPanel panel;
private  ImageIcon image;
    Board() {

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



        List<JLabel> labelList = new ArrayList<>();

        for (int i = 1; i < 9; i++) {
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
            //panel.add(scaledImage);


            JLabel label1 = new JLabel();
            label1.setIcon(scaledImage);
            labelList.add(label1);
        }

        //
        Random rand =new Random();
        for (int j = 0; j < 16; j++) {
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


       // frame1.setVisible(true);

/*
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
*/
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.boardVisible();
        board.makeLabels();
    }

}