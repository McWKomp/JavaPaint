package paintPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;

public class UI extends JFrame implements MouseMotionListener,KeyListener {
    private int oldX;
    private int oldY;
    private boolean isSpaceDown;
    private Color color = Color.BLACK;
    private int size = 10;

    UI(){

        setLayout(null);

        setSize(800,400);

        setVisible(true);

        setTitle("Drawing...");

        addMouseMotionListener(this);
        addKeyListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (isSpaceDown){
            g.setColor(Color.WHITE);
            g.fillRect(oldX,oldY,30,30);
        }else {
            g.setColor(color);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(size));
            g2.draw(new Line2D.Float(oldX,oldY,e.getX(),e.getY()));
        }

        oldX = e.getX();
        oldY = e.getY();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        oldX = e.getX();
        oldY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }


    int x = -210;
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){

            //ERASER

            case KeyEvent.VK_SPACE:
                if (isSpaceDown){
                    isSpaceDown = false;
                    setTitle("Drawing...");
                }
                else{
                    isSpaceDown = true;
                    setTitle("Erasing...");
                }
                break;

                //REGULAR COLORS

            case KeyEvent.VK_R:
                color = Color.RED;
                break;

            case KeyEvent.VK_O:
                color = Color.ORANGE;
                break;

            case KeyEvent.VK_Y:
                color = Color.YELLOW;
                break;

            case KeyEvent.VK_G:
                color = Color.GREEN;
                break;

            case KeyEvent.VK_B:
                color = Color.BLUE;
                break;

            case KeyEvent.VK_C:
                color = Color.CYAN;
                break;

            case KeyEvent.VK_P:
                color = Color.PINK;
                break;

            case KeyEvent.VK_M:
                color = Color.MAGENTA;
                break;

                //SHADES OF BLACK

            case KeyEvent.VK_1:
                color = Color.BLACK;
                break;

            case KeyEvent.VK_2:
                color = Color.DARK_GRAY;
                break;

            case KeyEvent.VK_3:
                color = Color.GRAY;
                break;

            case KeyEvent.VK_4:
                color = Color.LIGHT_GRAY;
                break;

            case KeyEvent.VK_5:
                color = Color.WHITE;
                break;

                //PEN SIZE

            case KeyEvent.VK_EQUALS:
                size+=5;
                break;

            case KeyEvent.VK_MINUS:
                size-=5;
                break;

                //TEXT

            case KeyEvent.VK_T:
                JTextArea textArea = new JTextArea("textArea");
                textArea.setBounds(x+=210, 20, 200, 50);
                textArea.setFont(new Font("Arial", Font.PLAIN, 20));
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(color);
                textArea.setVisible(true);
                add(textArea);
                break;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
