package lightbright;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class LightBright extends JFrame {
 static int clicksn = 3;
    public static void main(String[] args) {
        LightBright lb = new LightBright();
    }
    
    LightBright() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        setSize(dim.width, dim.height-100);
        int rows = 50;
        int columns = 65;
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        GridLayout layout = new GridLayout(rows, columns);
        panel.setLayout(layout);
        add(panel);
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                Shape circle = new Shape();
                panel.add(circle);
            }
        }
    setVisible(true);
    }    
    
    //The following is the code of how I made the project with buttons
        /*int l=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                B b = new B();
                //b.setText(""+l);//i + " , " + j);
                panel.add(b, i, j);l++;
            }
        }
    }
    
    class B extends JButton {
        B() {
            setSize(1, 1);
            setOpaque(true);
            colorLights(this);
         }
         private void colorLights(final B b){
             b.addActionListener(new ActionListener() {
             int clicks = 0;
                 @Override
                public void actionPerformed(ActionEvent e) {
                    switch(clicks) {
                        case 0: b.setBackground(Color.WHITE);b.setBorderPainted(true);clicks++;
                            break;
                        case 1: b.setBackground(Color.RED);b.setBorderPainted(false);clicks++;
                            break;
                        case 2: b.setBackground(Color.yellow);clicks++;System.out.println("Clicked " + clicks);
                            break;
                        case 3: b.setBackground(Color.BLUE);clicks = 0;System.out.println("Clicked " + clicks);
                            break;
                    }
                }
            });*/
         }
        
    
    class Shape extends JPanel {
        int init = 0;   
        @Override
         public void paintComponent(Graphics g) {
             super.paintComponent(g);
             g.fillOval(0, 0, 10, 10);
             if (init==0)
                 this.setForeground(Color.white);
             init = 1;
        }

         public Shape() {
            this.addMouseListener(new MouseListener() {
            int clicksn = 1; 
            @Override
            
            public void mouseClicked(MouseEvent e) {
                switch(clicksn) {
                     case 0: Shape.this.setForeground(Color.WHITE);
                         clicksn = 1; 
                         break;
                     case 1: 
                         Shape.this.setForeground(Color.gray);
                         clicksn = 2;// System.out.println(clicks);
                         break;
                     case 2:
                         Shape.this.setForeground(Color.magenta);
                         clicksn = 3; //System.out.println(clicks); 
                         break;
                     case 3: 
                         Shape.this.setForeground(Color.green);
                         clicksn = 0;// System.out.println(clicksn);
                         break;
                }
                repaint();
                }
                @Override
                public void mousePressed(MouseEvent e) {
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                }
                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        } 
    }

//The code that adds the mouse listener when instantiating the Shape.  
//I was able to change it to be within the Shape class which I think is more correct
/*circle.addMouseListener(new MouseListener() {
                    int clicks = 1;
                    @Override
                    public void mouseClicked(MouseEvent e) {
                    switch(clicks) {
                    case 0: circle.setForeground(Color.WHITE);clicks = 1;
                        break;
                    case 1: circle.setForeground(Color.red);clicks = 2;
                        break;
                    case 2: circle.setForeground(Color.yellow);clicks = 3;
                        break;
                    case 3: circle.setForeground(Color.blue);clicks = 0;
                        break;
                }
                    }
                    @Override
                    public void mousePressed(MouseEvent e) {
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }
                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }
                    @Override
                    public void mouseExited(MouseEvent e) {
                    }
                });*/