import javax.swing.*;
import java.awt.*;

public class Rata extends JLabel {

    public Rata(){
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(new Color(0xFF552358, true));
        g2D.fillRect(0,0,10,10);
    }
}
