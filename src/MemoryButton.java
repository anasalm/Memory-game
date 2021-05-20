import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemoryButton{
    int a;

    public JButton createButton(int e){
        a = e;
        JButton button = new JButton("m" + e);

        return button;
    }


}

