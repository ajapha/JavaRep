package tetris;

import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class Board extends JFrame {

    JPanel panel;
    JPanel l;
    Shape shape;
    Shape last;

    public Board() {
        setBackground(Color.white);
        setTitle("Tetris");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1100, 700);
        setLocationRelativeTo(null);
        l = new JPanel();
        l.setPreferredSize(new Dimension(600, 700));
        add(l);
        setVisible(true);
        int i = 0;
        l.setLayout(null);

        new Thread(new Runnable() {
            @Override
            public void run() {
                int position = 100;
                boolean gameOver = false;
                while (!gameOver) {
                    int piece = new Random().nextInt(4);
                    switch (piece) {
                        case 0:
                            shape = new FourShape();
                            break;
                        case 1:
                            shape = new LeftL();
                            break;
                        case 2:
                            shape = new ZShape();
                            break;
                        case 3:
                            shape = new BoxShape();
                    }
                    l.add(shape);
                    shape.setFocusable(true);
                    shape.requestFocusInWindow();
                    shape.setBounds(position, -100, shape.getWidth(), shape.getHeight());
                    boolean test = false;
                    while (shape.getLocation().y + shape.getHeight() < Board.this.getHeight() - 20 && !test) {
                        shape.setLocation(shape.getLocation().x, shape.getLocation().y + 20);
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                        }
                        if (last != null) {
                            if ((shape.getLocation().x < last.getLocation().x + last.getWidth() || shape.getLocation().x + shape.getWidth() < last.getLocation().x + shape.getWidth()) && shape.getLocation().y + shape.getHeight() >= last.getLocation().y) {
                                test = true;
                                if (shape.getLocation().y <= -10) {
                                    gameOver = true;
                                    continue;
                                }
                            }
                        }
                    }
                    last = shape;
                }
            }
        }).start();
    }

}
