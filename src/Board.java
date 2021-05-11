import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Board extends JFrame {

    private JFrame frame;
    private JPanel panel;
    private final int numberOfImages =8 ;
    private final int numberOfCards = 16 ;
    JButton[] buttonList;
    int l=0;
    int timesClicked = 0;
    Icon[] imageList;
    Icon tempIcon;
    JButton tempButton;


private  ImageIcon image;
    Board() {
        boardOfButtons();
    }


    public void boardOfButtons(){

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Memory");
        frame.setSize(500,500);
        frame.setLayout(new GridLayout(4,4,50,50));
/**
 panel =new JPanel();
 panel.setSize(4000,4000);
 panel.setBackground(Color.CYAN);
 panel.setLayout(new GridLayout(4,4,50,50));
 */

        Border board = BorderFactory.createLineBorder(Color.BLACK,5);


        List<JLabel> labelList = new ArrayList<>();
        //JFrame frame3 = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(5000,5000);
        frame.setLayout(new GridLayout(4,4,50,50));

        buttonList = new JButton[numberOfCards];

        TestButton testButton = new TestButton();

        for (int i=0; i < numberOfCards; i++) {

            JButton button = new JButton("m" + (i + 1));

            button.setPreferredSize(new Dimension(100,100));
            button.setBackground(Color.CYAN);
            button.setBorder(board);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(timesClicked==0){
                      //  System.out.println(button.getText());
                        button.setOpaque(false);
                        button.setContentAreaFilled(false);
                        //button.setBorderPainted(false);
                        button.setIcon(button.getDisabledIcon());
                        //button.getIcon();
                      //  button.
                        tempIcon = button.getIcon();
                        tempButton = button;

                        timesClicked++;
                        System.out.println(l);
                        l++;
                    }
                    else if(timesClicked ==1){
                        //System.out.println(button.getText());
                        button.setOpaque(false);
                        button.setContentAreaFilled(false);
                        //button.setBorderPainted(false);
                        button.setIcon(button.getDisabledIcon());
                        if(button.getIcon().equals(tempIcon)){
                            System.out.println("YOU GOT A PAIR");
                            button.removeAll();
                            tempButton.removeAll();
                        }
                        timesClicked++;
                        System.out.println(l);
                        l++;

                    }
                    else if(timesClicked == 2) {
                        for(int g=0; g <buttonList.length; g++) {
                            buttonList[g].setOpaque(true);
                            buttonList[g].setContentAreaFilled(true);
                            buttonList[g].setBorderPainted(true);
                            buttonList[g].setIcon(null);
                            //button.setIcon(button.getDisabledIcon());
                        }
                        timesClicked = 0;
                    }
                }
            });

            buttonList[i] = button;
            frame.add(buttonList[i]);
        }


        imageList = new Icon[numberOfCards];

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
            imageList[i] = scaledImage;
            imageList[numberOfImages + i] = scaledImage;


            //Add every card two times
            JLabel label  = new JLabel();
            //buttonList[i].setIcon(scaledImage);
            labelList.add(label);
            //buttonList[i].setBorder(board);

            //panel.add(scaledImage);

            JLabel label1 = new JLabel();
            //buttonList[i].setIcon(scaledImage);
            labelList.add(label1);
            label1.setBorder(board);
        }

        Collections.shuffle(Arrays.asList(imageList));

        for(int e = 0; e < imageList.length; e ++){
            buttonList[e].setDisabledIcon(imageList[e]);
        }
        //
/**
        Random rand =new Random();
        for (int j = 0; j < numberOfCards; j++) {
            int randomIndex = rand.nextInt(labelList.size());
            //panel.add(labelList.get(randomIndex));
            //frame.add(labelList.get(randomIndex));
            labelList.remove(randomIndex);
        }
 */

        //frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        frame.setVisible(true);
        frame.pack();
    }



    /**
     * add images to the table.
     */
    public void makeLabels(){


    }
    private Image scaleImage(Image image, int w, int h) {

        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);

    }/**
     *trying to make a new frame with buttons. when we click the buttons a card will show up
     */


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



    public void whatHappensWhenClicked(){

    }
}