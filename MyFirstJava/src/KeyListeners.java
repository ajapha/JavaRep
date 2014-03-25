
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class KeyListeners implements Runnable{
    public static void main(String[] args) {
        KeyListeners l = new KeyListeners();
        
    }
    KeyListeners() {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Key Pressed: " + e.getKeyChar() + " " + e.getKeyCode() + " " + e.getKeyLocation());    
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    @Override
    public void run() {
    }
    
}
