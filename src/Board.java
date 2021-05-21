
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


public class Board extends JFrame {

    private JFrame frame = new JFrame();
    private JPanel cards_panel;
    private JPanel titlePanel;
    private JLabel textField;
    private JLabel numberOfClicks;
    private JPanel difficulty_panel;
    private int numberOfImages;
    private int numberOfCards;
    private int numberOfRows;
    private int numberOfCols;
    private int clicksCounter;
    private int pairCounter;


    private int numberOfPair = 0;


    Icon[] imageList;
    Icon tempIcon;
    JButton tempButton;

    int timesClicked = 0;

    private ImageIcon image;

    Board() {
        DifficultyScreen();
    }


    public void DifficultyScreen() {
        clicksCounter = 0;
        pairCounter = 0;

        frame.setTitle("Memory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        difficulty_panel = new JPanel();
        difficulty_panel.setSize(new Dimension(300, 300));
        difficulty_panel.setLayout(new GridLayout(4, 1));
        JButton level1 = new JButton("Level 1");
        level1.setBackground(new Color(20, 180, 200));
        JButton level2 = new JButton("Level 2");
        level2.setBackground(new Color(20, 165, 200));
        JButton level3 = new JButton("Level 3");
        level3.setBackground(new Color(20, 150, 200));
        JButton level4 = new JButton("Level 4");
        level4.setBackground(new Color(20, 135, 200));
        level1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardOfButtons(8, 4, 4);
            }
        });
        level2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardOfButtons(10, 4, 5);
            }
        });
        level3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardOfButtons(15, 5, 6);
            }
        });
        level4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boardOfButtons(18, 6, 6);
            }
        });

        difficulty_panel.add(level1);
        difficulty_panel.add(level2);
        difficulty_panel.add(level3);
        difficulty_panel.add(level4);


        frame.add(difficulty_panel, BorderLayout.CENTER);
        frame.setVisible(true);


    }


    public void boardOfButtons(int numberOfImages, int numberOfCols, int numberOfRows) {
        Border board = BorderFactory.createLineBorder(new Color(75, 25, 146, 133), 2);
        this.numberOfImages = numberOfImages;
        this.numberOfCards = 2 * numberOfImages;
        this.numberOfCols = numberOfCols;
        this.numberOfRows = numberOfRows;


        frame.remove(difficulty_panel);
        frame.repaint();


        textField = new JLabel();
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(new Color(10, 10, 10));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        //String text  =   + '\n'+ "number of clicks";
        //System.out.println(text);
        textField.setText("Let's start!!");
        textField.setOpaque(true);




        titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 1000, 100);

        cards_panel = new JPanel();
        cards_panel.setLayout(new GridLayout(numberOfRows, numberOfCols));
        cards_panel.setBackground(new Color(1, 248, 219));

        List<JButton> buttonList = new ArrayList<>();

        for (int i = 0; i < numberOfCards; i++) {

            JButton button = new JButton();

            buttonList.add(button);
            button.setFocusable(false);
            button.setBackground(new Color(19, 206, 186));
            button.setBorder(board);
            cards_panel.add(button);


            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    clicksCounter++;
                    if (timesClicked == 0) {
                        for (int g = 0; g < buttonList.size(); g++) {
                            buttonList.get(g).setOpaque(true);
                            buttonList.get(g).setIcon(null);
                        }
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException m) {
                            m.printStackTrace();
                        }
                        button.setOpaque(false);
                        button.setIcon(button.getDisabledIcon());
                        tempIcon = button.getIcon();
                        tempButton = button;

                        timesClicked++;
                        //textField.setText("ONE MORE TIME");
                        textField.setText("Number of clicks: "+ clicksCounter)  ;

                    } else if (timesClicked == 1) {
                        if (button.equals(tempButton)) {
                            return;
                        } else {
                            button.setOpaque(false);
                            button.setIcon(button.getDisabledIcon());
                            if (button.getIcon().equals(tempIcon)) {
                                pairCounter++;
                                //textField.setText("YOU GOT A PAIR");
                                textField.setText("Number of pair: "+ pairCounter);
                                numberOfPair++;
                                button.setEnabled(false);
                                tempButton.setEnabled(false);
                                buttonList.remove(button);
                                buttonList.remove(tempButton);

                                if (numberOfPair == numberOfImages) {
                                    //JTextArea textarea = new JTextArea ("1\n2\n3\n"+"4\n");
                                    //textField.setText("YOU WIN " +" Number of pair: "+ pairCounter + "Number of ckicks: "+ clicksCounter);
                                    textField.setText("<html>YOU WIN <br>Number of pair: </html>" );
                                    playAgain();
                                }
                            } else {
                                textField.setText("Try again");
                                textField.setText("Number of ckicks: "+ clicksCounter);
                            }
                            timesClicked = 0;
                        }
                    }
                }
            });
        }


        imageList = new Icon[numberOfCards];
        for (int i = 0; i < numberOfImages; i++) {
            //image name
            String folder = "icon/image-";
            String prefix = ".png";
            String imageName = folder + i + prefix;
            try {
                image = new ImageIcon(getClass().getResource(imageName));

            } catch (Exception e) {
                System.out.println("Image cannot be found!!");
            }
            //scale the images
            Image scaled = scaleImage(image.getImage(), 100, 100);
            ImageIcon scaledImage = new ImageIcon(scaled);

            imageList[i] = scaledImage;
            imageList[numberOfImages + i] = scaledImage;
        }


        Collections.shuffle(Arrays.asList(imageList));

        for (int e = 0; e < imageList.length; e++) {
            buttonList.get(e).setDisabledIcon(imageList[e]);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(cards_panel);
        frame.setVisible(true);

    }

    public void playAgain() {

        frame.remove(cards_panel);
        titlePanel.setBounds(0, 0, 1000, 500);
        clicksCounter=0;
        pairCounter=0;
        numberOfPair=0;
        textField.setText("let's start again!!");
        frame.add(difficulty_panel);
        frame.repaint();

    }

    private Image scaleImage(Image image, int w, int h) {
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }


}