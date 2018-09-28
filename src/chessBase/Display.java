package chessBase;

import javax.swing.*;
import java.awt.*;

/**
 * Created by isjo16 on 2018-09-28.
 */
public class Display extends Canvas {
    private String title = "Chess";
    private JFrame frame;

    Display(){
        this.frame = new JFrame(title);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setPreferredSize(new Dimension(720, 720));
        this.setFocusable(true);
        this.requestFocus();

        this.frame.add(this);
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
}
