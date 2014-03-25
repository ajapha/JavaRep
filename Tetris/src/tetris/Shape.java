package tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

abstract public class Shape extends JPanel {
    private int width = 203;
    private int height = 50;
    int one1;
    int one2;
    int two1;
    int two2;
    int three1;
    int three2;
    int four1;
    int four2;
    Color color;
    
    Shape(int width, int height, int one1, int one2, int two1, int two2, int three1, int three2, int four1, int four2, Color color) {
        this.width = width;
        this.height = height;
        this.one1 = one1;
        this.one2 = one2;
        this.two1 = two1;
        this.two2 = two2;
        this.three1 =three1;
        this.three2 = three2;
        this.four1 = four1;
        this.four2 = four2;
        this.color = color;
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char key = e.getKeyChar();
                switch(key) {
                    case ',': if(Shape.this.getLocation().x >= 50)Shape.this.setLocation(Shape.this.getLocation().x -50, Shape.this.getLocation().y); 
                        break;
                    case '/': if(Shape.this.getLocation().x + Shape.this.width <=1100)Shape.this.setLocation(Shape.this.getLocation().x + 50, Shape.this.getLocation().y); 
                        break;
                }
            }
        });
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.draw3DRect(0, 0, 50, 50, false);
        g.draw3DRect(two1, two2, 50, 50, false);
        g.draw3DRect(three1, three2, 50, 50, false);
        g.draw3DRect(four1, four2, 50, 50, false);
        g.setColor(color);
        g.fill3DRect(0 + 1, 0 + 1, 50 - 1, 50 - 1, true);
        g.fill3DRect(two1 + 1, two2 + 1, 50 - 1, 50 - 1, true);
        g.fill3DRect(three1 + 1, three2 + 1 - 1, 50 - 1, 50 - 1, true);
        g.fill3DRect(four1 + 1, four2 + 1, 50 - 1, 50 - 1, true);
        
    }
}
