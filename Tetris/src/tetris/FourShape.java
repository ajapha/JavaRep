/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author AJ
 */
public class FourShape extends Shape {
    
    public FourShape() {
        super(203, 55, 0, 0, 51, 0, 102, 0, 153, 0, Color.MAGENTA);    
    }
    /*
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.BLACK);
        g2.drawRect(0, 0, 50, 50);
        g2.drawRect(51, 0, 50, 50);
        g2.drawRect(102, 0, 50, 50);
        g2.drawRect(153, 0, 50, 50);
        g2.setColor(Color.MAGENTA);
        g2.fill3DRect(0, 0, 50, 50, true);
        g2.fill3DRect(51, 0, 50, 50, true);
        g2.fill3DRect(102, 0, 50, 50, true);
        g2.fill3DRect(153, 0, 50, 50, true);
        g2.setStroke(new BasicStroke(5));
    }*/
    
    
}
