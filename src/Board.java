import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class Board extends JFrame {

    private JFrame frame;
    private JPanel cards_panel;
    private final int numberOfImages =8 ;
    private final int numberOfCards = 16 ;

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

        Border board = BorderFactory.createLineBorder(new Color(145,153,155),2);

        frame = new JFrame();
        frame.setTitle("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        //  frame.setLayout(new GridLayout(4,4,50,50));

        cards_panel= new JPanel();
        cards_panel.setLayout(new GridLayout(4,4));
        cards_panel.setBackground(Color.MAGENTA);




        List<JButton> buttonList1 = new ArrayList<>();

        for (int i=0; i < numberOfCards; i++) {

            JButton button = new JButton();

            buttonList1.add(button);
            //button.setPreferredSize(new Dimension(150,150));
            button.setFocusable(false);
            button.setBackground(Color.CYAN);
            button.setBorder(board);
            cards_panel.add(button);


            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(timesClicked==0){

                        button.setOpaque(false);
                        button.setIcon(button.getDisabledIcon());
                        tempIcon = button.getIcon();
                        tempButton = button;

                        timesClicked++;
                        System.out.println(l);
                        l++;
                    }
                    else if(timesClicked ==1){

                        button.setOpaque(false);
                        button.setIcon(button.getDisabledIcon());
                        if(button.getIcon().equals(tempIcon)){
                            System.out.println("YOU GOT A PAIR");
                            buttonList1.remove(button);
                            buttonList1.remove(tempButton);
                        }
                        timesClicked++;
                        System.out.println(l);
                        l++;

                    }
                    else if(timesClicked == 2) {
                        for(int g=0; g <buttonList1.size(); g++) {

                            buttonList1.get(g).setOpaque(true);
                            buttonList1.get(g).setContentAreaFilled(true);
                            buttonList1.get(g).setBorderPainted(true);
                            buttonList1.get(g).setIcon(null);

                        }
                        timesClicked = 0;
                    }
                }
            });

            //frame.add(buttonList1.get(i));
        }



        imageList = new Icon[numberOfCards];
        for (int i = 0; i < numberOfImages; i++) {
            //image name
            String folder = "icon/image-";
            String prefix = ".png";
            String imageName = folder + i + prefix;
            try{
                image = new ImageIcon(getClass().getResource(imageName));

            }catch (Exception  e){
                System.out.println("Image cannot be found!!");
            }
            //scale the images
            Image scaled = scaleImage(image.getImage(),100,100);
            ImageIcon scaledImage  = new ImageIcon(scaled);
            imageList[i] = scaledImage;
            imageList[numberOfImages + i] = scaledImage;
        }


        Collections.shuffle(Arrays.asList(imageList));

        for(int e = 0; e < imageList.length; e ++){
            buttonList1.get(e).setDisabledIcon(imageList[e]);
        }

        frame.add(cards_panel,BorderLayout.CENTER);
        //frame.pack();
        frame.setVisible(true);


    }

    private Image scaleImage(Image image, int w, int h) {
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }
}

