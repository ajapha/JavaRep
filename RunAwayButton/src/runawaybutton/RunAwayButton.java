package runawaybutton;

import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RunAwayButton {
    int x = 300;
    int y = 300;
    boolean gameOver = false;
    public static void main(String[] args) {
        RunAwayButton rab = new RunAwayButton();
        rab.start();
    }

    private void start() {
        JFrame frame = new JFrame("Run Away Button");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JButton button = new JButton("Click Me!");
        addButtonListener(button);
        frame.add(panel);
        panel.add(button);
        JLabel l = new JLabel("Try to click the button");
        panel.add(l);
        panel.setLayout(null);
        button.setLocation(x, y);
        button.setSize(100, 30);
        button.repaint();
        l.setBounds(220, 1, 200, 30);
        addMouseAdapter(panel, button, l);
        frame.setVisible(true);
    }
    
    private void addButtonListener(final JButton button) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!gameOver) {
                    gameOver = true;
                    button.setText("You got me!");
                    if (JOptionPane.showConfirmDialog(null, "You Won!\r\nDo you want to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                         gameOver = false;
                         button.setText("Click Me");
                         button.setLocation(200, 200);
                     }
                 }
                
            }
        });
    }
    private void addMouseAdapter(JPanel panel, final JButton button, final JLabel l) {
        panel.addMouseMotionListener(new MouseMotionListener() {
            
            @Override
            public void mouseMoved(MouseEvent e) {
                if(!gameOver) {
                    if((Math.abs(button.getLocation().x - e.getX())) < 30 
                        | Math.abs((button.getLocation().y - e.getY())) < 30
                        | Math.abs(e.getX() - button.getLocation().x) < 30 
                        | Math.abs(e.getY() - button.getLocation().y) < 70) {
                    int r1 = new Random().nextInt(20)+20;
                    int r2 = new Random().nextInt(20)+20;
                    int xNegativeOrPositive = new Random().nextInt(2);
                    int yNegativeOrPositive = new Random().nextInt(2);
                    if(xNegativeOrPositive == 0) {
                        x += (r1 * 1);
                    }
                    else {
                        x += (r1 * -1);
                    }
                    if(yNegativeOrPositive == 0) {
                        y += (r2 * 1);
                    }
                    else {
                        y += (r2 * -1);
                    }
                    if(x>500) {
                        x -= 130;
                    }
                    if(x<0) {
                        x += 130;  
                    }
                    if(y>540) {
                        y -= 130;
                    }
                    if(y<0) {
                        y += 130;  
                    }
                    int eX = e.getX();
                    int eY = e.getY();
                    if((x -15)>= eX | (x+15)>= eX) {
                        if(!(x >= 480))x += 20;
                    }
                    if((y -15)>= eY | (y+15)>= eY) {
                        if(!(y >= 530))y += 20;
                    }
                    button.setLocation(x, y);}
                    button.repaint();
                    }
            } 

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseMoved(e);
            }
        
        });
    }
    
}
