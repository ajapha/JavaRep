package chasinggame;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class ChasingGame extends JFrame {

    RunningMan man;
    Robot robot;
    JPanel panel;
    boolean gameOver;
    JPanel door;
    JLabel label;
    boolean won;
    SoundEffect applause;
    SoundEffect rayGun;
    String directions;
    Random random;
    Point robotStart;
    Point manStart;
    String choice;
    int speed;

    public static void main(String[] args) {
        new ChasingGame();
    }

    public ChasingGame() {
        robotStart = new Point();
        manStart = new Point();
        random = new Random();
        gameOver = false;
        setSize(700, 705);
        directions = "Get to the door before the robot catches you!";
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        add(panel);
        panel.setFocusable(true);
        panel.setLayout(null);
        panel.setBackground(Color.CYAN);
        man = new RunningMan();
        placeMan();
        panel.add(man);
        robot = new Robot();
        placeRobot();
        panel.add(robot);
        door = new JPanel();
        door.setBackground(Color.black);
        door.setBounds(680, 320, 20, 60);
        panel.add(door);
        label = new JLabel(directions);
        panel.add(label);
        label.setBounds(200, 0, 300, 15);
        applause = new SoundEffect("applause.wav");
        rayGun = new SoundEffect("raygun.wav");
        setVisible(true);
        startRobot();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int xLocation = man.getLocation().x;
                int yLocation = man.getLocation().y;
                if (!gameOver) {
                    switch (e.getKeyCode()) {
                        case KeyEvent.VK_RIGHT:
                            if (xLocation <= 630) {
                                man.setLocation(xLocation + 10, yLocation);
                            }
                            break;
                        case KeyEvent.VK_LEFT:
                            if (xLocation >= 10) {
                                man.setLocation(xLocation - 10, yLocation);
                            }
                            break;
                        case KeyEvent.VK_UP:
                            if (yLocation >= 10) {
                                man.setLocation(xLocation, yLocation - 10);
                            }
                            break;
                        case KeyEvent.VK_DOWN:
                            if (yLocation <= 620) {
                                man.setLocation(xLocation, yLocation + 10);
                            }
                            break;
                        default:
                    }
                }
                if (!gameOver && man.getLocation().x + 40 == door.getLocation().x && (man.getLocation().y == door.getLocation().y)){// && man.getLocation().y <= door.getLocation().y + 20)) {
                    gameOver = true;
                    won = true;
                    label.setText("                       You Win!!!");
                    applause.play(false);
                    promptNewGame();
                }
            }
        });
    }

    private void newGame() {
        gameOver = false;
        won = false;
        robot.setBounds(200, 200, 60, 60);
        man.setBounds(100, 600, 60, 60);
        label.setText(directions);
        startRobot();
    }

    public void placeMan() {
        manStart.x = random.nextInt(7) * 10;
        manStart.y = random.nextInt(7) * 100;
        man.setBounds(manStart.x, manStart.y, 60, 60);
    }

    public void placeRobot() {
        robotStart.x = random.nextInt(10) * 10 + 100;
        robotStart.y = random.nextInt(20) * 10 + 200;
        robot.setBounds(robotStart.x, robotStart.y, 60, 60);
    }

    private void startRobot() {
        speed = chooseSpeed();
        new Thread(new Runnable() {
            @Override
            public void run() {
                chase(robot, man, speed);
                gameOver = true;
                if (!won) {
                    rayGun.play(false);
                    promptNewGame();
                }
            }
        }).start();
    }

    private void promptNewGame() {
        String message = won ? "You Win" : "You Lose";
        if (JOptionPane.showConfirmDialog(null, message + "\r\nDo you want to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            newGame();
        }
    }
    
    private int chooseSpeed() {
        int speed = 0;
        String[] choices = {"Slow" , "Medium", "Fast"};
        String inputTitile = "Robot Chase";
        String inputMessage = "Pick a Speed";
        if (choice == null) {
            choice = "Medium";
        }
        choice = (String)JOptionPane.showInputDialog(null, inputMessage, inputTitile, 3, null, choices, choice);
        if (choice == null) {
            gameOver = true;
            System.exit(0);
        }
        switch(choice) {
            case "Slow": speed = 550;
                break;
            case "Medium": speed = 400;
                break;
            case "Fast" : speed = 250;
                break;
        }
        return speed;
    }
    
    private void chase(JButton r, JButton m, int speed) {
        int xPosition = r.getLocation().x;
        int yPosition = r.getLocation().y;
        int endXLocation = m.getLocation().x;
        int endYLocation = m.getLocation().y;
        while (!gameOver && (Math.abs(xPosition - endXLocation) > 10 || Math.abs(yPosition - endYLocation) > 10)) {
            xPosition = r.getLocation().x;
            yPosition = r.getLocation().y;
            endXLocation = m.getLocation().x;
            endYLocation = m.getLocation().y;

            if (xPosition - endXLocation > 0) {
                if (xPosition > 10) {
                    r.setLocation(xPosition -= 20, yPosition);
                }
            } else {
                if (xPosition < 640) {
                    r.setLocation(xPosition += 20, yPosition);
                }
            }
            if (yPosition - endYLocation > 0) {
                if (yPosition > 0) {
                    r.setLocation(xPosition, yPosition -= 20);
                }
            } else {
                if (yPosition < 640) {
                    r.setLocation(xPosition, yPosition += 20);
                }
            }
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {}
        }
    }
}
