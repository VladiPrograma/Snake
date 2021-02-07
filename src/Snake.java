import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Snake extends JPanel implements KeyListener, ActionListener {
    Timer timer= new Timer(50, this);
    Rata rata;
    Cubo[] snake = new Cubo[30*30];
    int N;
    public Snake(){
        rata= new Rata();
        int RataX = (int)(Math.random()*29);
        RataX*=10;
        int RataY = (int)(Math.random()*26);
        RataY*=10;
        System.out.println(RataX+" "+ RataY);
        rata.setBounds(RataX, RataY,10,10);
        rata.setOpaque(true);

        snake[N++] = new Cubo();
        snake[0].setBounds(0,0,10,10);

        this.addKeyListener(this);
        this.add(rata);
        this.add(snake[0]);
        this.setLayout(null);
        timer.start();
    }



    public boolean muere(){
        int x =snake[0].getX();
        int y= snake[0].getY();
        if (x<0||y>260||y<0||x>290){ return true; }
        for (int i=2; i<N; i++){
            if (x==snake[i].getX()&&y==snake[i].getY()){ return true;}
        }
        return false;
    }
    public void come(){
        if (rata.getLocation().equals(snake[0].getLocation())){
            int RataX = (int)(Math.random()*29);
            RataX*=10;
            int RataY = (int)(Math.random()*26);
            RataY*=10;
            rata.setLocation(RataX,RataY);
            System.out.println(rata.getLocation().toString());
            addSnake();
            System.out.println("Ñam");
        }
    }

    public void addSnake(){
        if (N==0){
            wRel=false;
            sRel=false;
            dRel=false;
            aRel=false;
            snake[N++] = new Cubo();
            snake[0].setBounds(0,0,10,10);
            this.add(snake[0]);
            repaint();

        }
        else {
            snake[N++] = new Cubo();
            Cubo ant = snake[N - 2];
            if (wRel) {
                snake[N - 1].setBounds(ant.getX(), ant.getY() + 10, 10, 10);
            }
            if (sRel) {
                snake[N - 1].setBounds(ant.getX(), ant.getY() - 10, 10, 10);
            }
            if (aRel) {
                snake[N - 1].setBounds(ant.getX() + 10, ant.getY(), 10, 10);
            }
            if (dRel) {
                snake[N - 1].setBounds(ant.getX() - 10, ant.getY(), 10, 10);
            }
            this.add(snake[N - 1]);
        }
    }



    boolean wRel, sRel,aRel,dRel;
    public void onlyOne(char x){

        if (x=='w'&&(!sRel||N==1)){
            wRel=true;
            sRel=false;
            aRel=false;
            dRel=false;
        }
        else if (x=='s'&&(!wRel||N==1)){
            sRel=true;
            wRel=false;
            aRel=false;
            dRel=false;
        }
        else if (x=='a'&&(!dRel||N==1)){
            aRel=true;
            wRel=false;
            sRel=false;
            dRel=false;
        }
        else if (x=='d'&&(!aRel||N==1)){
            dRel=true;
            wRel=false;
            sRel=false;
            aRel=false;
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {
        onlyOne(e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {

            this.come();

            if (muere()){
                System.out.println("sisisi");
                for (int i=0; i<N; i++){
                    System.out.println("i");
                    snake[i].setBackground(new Color(1, true));
                    this.remove(snake[i]);
                    repaint();
                }
                N=0;
                addSnake();
            }

            if (wRel) {
                for (int i=N-1; i>0; i--){
                    snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
                }
                snake[0].setLocation(snake[0].getX(), snake[0].getY()-10);
            }

             else if (sRel) {
                for (int i=N-1; i>0; i--){
                    snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
                }
                snake[0].setLocation(snake[0].getX(), snake[0].getY()+10);
            }

            else if (aRel) {
                for (int i=N-1; i>0; i--){
                    snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
                }
                snake[0].setLocation(snake[0].getX()-10, snake[0].getY());
            }

            else if (dRel) {
                for (int i=N-1; i>0; i--){
                    snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
                }
                snake[0].setLocation(snake[0].getX()+10, snake[0].getY());
            }

        }



    }





}
