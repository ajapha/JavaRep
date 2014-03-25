package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class ZShape extends Shape{

    public ZShape() {
        super(153, 102, 0, 0, 51, 0, 51, 51, 102, 51, Color.CYAN);
    }
    
    /*@Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, 50, 50);
        g.drawRect(51, 0, 50, 50);
        g.drawRect(51, 51, 50, 50);
        g.drawRect(102, 51, 50, 50);
        g.setColor(Color.red);
        g.fillRect(0, 0, 50, 50);
        g.fillRect(51, 0, 50, 50);
        g.fillRect(51, 51, 50, 50);
        g.fillRect(102, 51, 50, 50);
        
    }*/
    
}
