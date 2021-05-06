import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Board extends JFrame {

private  ImageIcon image;
    Board() {


    }
    /*
    add images to the table.

    */

    public void makeLabels(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(4,4,2,2));
        //JLabel[] labelArray  = new JLabel [8];
     //   HashMap<String, JLabel> aWeirdLabelMap = new HashMap<String,JLabel>();
        for (int i = 1; i < 9; i++) {
            //image name
            String folder = "icon/image-";
            String prefix = ".png";
            String imageName = folder + i + prefix;
            System.out.println(imageName);
            try{
                image = new ImageIcon(getClass().getResource(imageName));
                // image = new ImageIcon(getClass().getResource("icon/color-palette.png"));
            }catch (Exception  e){
                System.out.println("Image cannot be found!!");
            }
            Image scaled = scaleImage(image.getImage(),50,50);
            ImageIcon scaledImage  = new ImageIcon(scaled);

            JLabel label  = new JLabel();
            label.setIcon(scaledImage);
            frame.add(label);
            JLabel label1 = new JLabel();
            label1.setIcon(scaledImage);
            frame.add(label1);


            //labelArray[i-1]= label;
            //frame.add(label);

            //aWeirdLabelMap.put(imageName,new JLabel(scaledImage));
            //frame.add(aWeirdLabelMap.get(imageName));
           // label.setH




        }

        frame.setVisible(true);
        frame.setSize(2000, 3000);
//
        //for (int j = 0; j < 8; j++) {

        //}
        /*
        frame.add(labelArray[0]);
        frame.add(labelArray[1]);
        frame.add(labelArray[2]);
        labelArray[3] = new JLabel();
        labelArray[4] = new JLabel();
        labelArray[5] = new JLabel();

         */





        //frame.pack();
    }
    private Image scaleImage(Image image, int w, int h) {

        Image scaled1 = image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        return scaled1;
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

        frame1.setVisible(true);
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