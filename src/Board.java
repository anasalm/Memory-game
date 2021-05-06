import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {


    Board() {


    }
    /*
    add images to the table.



    */
    public void makeLabels(){

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
    }

}