package tetris;

import java.awt.Color;
import java.awt.Graphics;

public class LeftL extends Shape {
    public LeftL() {
        super(153, 101, 0, 0, 51, 0, 102, 0, 0, 51, Color.BLUE);
    }
    
   /* @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 50, 50);
        g.fillRect(51, 0, 50, 50);
        g.fillRect(102, 0, 50, 50);
        g.fillRect(0, 51, 50, 50);
        g.setColor(Color.blue);
        g.fillRect(0, 0, 50, 50);
        g.fillRect(51, 0, 50, 50);
        g.fillRect(102, 0, 50, 50);
        g.fillRect(0, 51, 50, 50);
        
    }*/
}
