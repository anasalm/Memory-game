import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Collections;


public class Images {

    Icon[] imageList;
    private ImageIcon image;

    public Icon[] Images ( int numberOfCards, int numberOfImages){
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
        return imageList;
    }
    private Image scaleImage(Image image, int w, int h) {
        return image.getScaledInstance(w, h, Image.SCALE_SMOOTH);
    }
 }
