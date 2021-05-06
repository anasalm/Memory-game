import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {

private  ImageIcon image;
    Board() {


    }
    /*
    add images to the table.

    */

    public void makeLabels(){
        try{
            image = new ImageIcon(getClass().getResource("icon/color-palette.png"));
        }catch (Exception  e){
            System.out.println("Image cannot be found!!");
        }
        Image scaled = scaleImage(image.getImage(),100,100);

        int w = image.getIconWidth();
        int h = image.getIconHeight();
        System.out.println(w);

        JLabel label = new JLabel("hej");
        ImageIcon scaledImage  = new ImageIcon(scaled);
        label.setIcon(scaledImage);
        JFrame frame = new JFrame();
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(2000, 3000);
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
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.add(new JLabel("hej"));
        frame1.setVisible(true);



    }

    public static void main(String[] args) {
        Board board = new Board();
        board.boardVisible();
        board.makeLabels();
    }

}