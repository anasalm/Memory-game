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

        JLabel label = new JLabel("hej");
        label.setIcon(image);
        JFrame frame = new JFrame();
        frame.add(label);
        frame.setVisible(true);
        frame.setSize(2000, 3000);
    }
    public void boardVisible(){
        /*
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

         */

    }

    public static void main(String[] args) {
        Board board = new Board();
        board.boardVisible();
        board.makeLabels();
    }

}