package paint;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class Paint extends JPanel {

    Color color;
    int thickness;
    ArrayList<Point> points;
    ArrayList<ArrayList<Point>> allPoints;
    ArrayList<Color> colors;
    ArrayList<Integer> lineThicknesses;
    JPanel colorPalet;

    public Paint() {
        addMouseMotionAdapter(this);
        setSize(800, 800);
        setBackground(Color.white);
        colors = new ArrayList();
        allPoints = new ArrayList();
        lineThicknesses = new ArrayList();
        thickness = 8;
    }

    public void setColor(Color color) {
        this.color = color;
        System.out.println("color is now " + color);
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
        System.out.println("thick is now " + thickness);
    }
    boolean pressed = false;

    private void addMouseMotionAdapter(JComponent item) {
        item.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseDragged(MouseEvent e) {
                Point point = new Point(e.getX(), e.getY());
                points.add(point);
                repaint();
            }
        });
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                colors.add(color);
                lineThicknesses.add(thickness);
                System.out.println(thickness);
                points = new ArrayList();
                allPoints.add(points);
                points.add(new Point(e.getX(), e.getY()));
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }
        });

        colorPalet = new JPanel(new GridLayout(2, 8, 1, 1));
        JPanel whiteP = new JPanel();
        whiteP.setBackground(Color.white);
        colorPalet.add(whiteP);
        JPanel blackP = new JPanel();
        blackP.setBackground(Color.black);
        colorPalet.add(blackP);
        JPanel redP = new JPanel();
        redP.setBackground(Color.red);
        colorPalet.add(redP);
        JPanel blueP = new JPanel();
        blueP.setBackground(Color.blue);
        colorPalet.add(blueP);
        JPanel yellowP = new JPanel();
        yellowP.setBackground(Color.yellow);
        colorPalet.add(yellowP);
        JPanel greenP = new JPanel();
        greenP.setBackground(Color.green);
        colorPalet.add(greenP);
        JPanel orangeP = new JPanel();
        orangeP.setBackground(Color.orange);
        colorPalet.add(orangeP);
        JPanel pinkP = new JPanel();
        pinkP.setBackground(Color.pink);
        colorPalet.add(pinkP);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        int i = 0;
        Graphics2D g2 = (Graphics2D) g;
        for (ArrayList<Point> line : allPoints) {
            Color lineColor = colors.get(i);
            g2.setStroke(new BasicStroke(lineThicknesses.get(i)));
            g.setColor(lineColor);
            Point last = null;
            for (Point point : line) {
                if (last != null) {
                    g.drawLine(last.x, last.y, point.x, point.y);
                }
                last = point;
            }
            i++;
        }

    }

    /*
     class Line extends JPanel {
     Line() {
     super();
     System.out.println("instance");
     setSize(800, 800);
            
     }
     @Override
     public void paint(Graphics g) {
     System.out.println("drawing");
     super.paintComponent(g);
     Graphics2D g2 = (Graphics2D)g;
     g2.setStroke(new BasicStroke(1));
     g2.setColor(color);
     int i = Math.abs(xStart-xEnd);
     int j = Math.abs(yStart-yEnd);
     //g2.fillOval(xStart, yStart, 20, 20);
     g2.drawLine(xStart, yStart, xEnd, yEnd);
     //setForeground(color);
     setBackground(null);
     setForeground(color);
     }
     }*/
}
