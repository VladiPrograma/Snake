import javax.swing.*;

public class MyFrame extends JFrame {
    Snake game = new Snake();
    MyFrame(){
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(296,299);

        game.setBounds(0,0,300,300);
        this.addKeyListener(game);
        this.add(game);



        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

//        Dimension size = this.getSize();
//        Insets insets = this.getInsets();
//        if (insets != null) {
//            size.height -= insets.top + insets.bottom;
//            size.width -= insets.left + insets.right;
//        }
    }


}
