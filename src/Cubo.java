import javax.swing.*;
import java.awt.*;

public class Cubo extends JLabel {
    public Cubo(){
        this.setOpaque(true);
        this.setBackground(new Color(0xFF65E08E));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
//
//        g2D.setColor(new Color(0xFF65E08E, true));
//        g2D.fillRect(0,0,10,10);
//        g2D.setColor(new Color(0x082D08));
//        g2D.drawRect(0,0,5,5);
    }

}
