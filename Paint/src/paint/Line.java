package paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

 class Line extends JPanel {
    
    private Color color;
    private int thickness;

    public Line(Color color, int thickness) {
        this.color = color;
        this.thickness = thickness;
    }    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawLine(10, 5, 80, 5);
    }

    public int getThickness() {
        return thickness;
    }
}
