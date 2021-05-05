import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame{

    DifficultyButton buttonInstance = new DifficultyButton();
    JButton button = buttonInstance.createButton("Begin game");

    staticFrame staticFrame = new staticFrame();
    JLabel label = new JLabel("yoyo");

    PanelMaker panelMaker = new PanelMaker();
    JPanel panel = panelMaker.createPanel(label, button);

    JFrame frame = staticFrame.createFrame(button, panel);

    public static void main(String[] args) {
        new HomeScreen();
    }

}
