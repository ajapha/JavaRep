package paint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintFrame extends JFrame {

    Paint paint;
    private Color color = (Color.black);
    private int lineThickness;
    JPanel colorPalet;
    JPanel lineChooser;
    JPanel shapes;

    public static void main(String[] args) {
        PaintFrame frame = new PaintFrame();
    }

    public PaintFrame() {
        lineThickness = 8;
        setTitle("Paint.java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        BorderLayout bl = new BorderLayout();
        setLayout(bl);
        JMenuBar menu = new JMenuBar();
        setMenu(menu);
        setJMenuBar(menu);
        paint = new Paint();
        paint.setBackground(Color.white);
        paint.setOpaque(true);
        setColorPalet();
        setThicknessChooser();
        setShapePicker();
        JPanel paletC = new JPanel();
        paletC.setLayout(new GridLayout(0, 1, 0, 10));
        paletC.setBackground(Color.LIGHT_GRAY);
        paletC.add(colorPalet);
        paletC.add(lineChooser);
        paletC.add(shapes);
        add(paint, BorderLayout.CENTER);
        add(paletC, BorderLayout.WEST);
        paint.setBackground(Color.white);
        setVisible(true);
        paint.setBackground(Color.white);
    }

    private void addActionListenerColor(final JMenuItem item) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = item.getBackground();
                paint.setColor(PaintFrame.this.color);
            }
        });
    }

    private void addPanelColorListener(final JPanel item) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                color = item.getBackground();
                paint.setColor(PaintFrame.this.color);
            }
        });
    }

    private void addActionListenerThickness(final JMenuItem item) {
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lineThickness = Integer.parseInt(item.getName());
                paint.setThickness(lineThickness);
            }
        });
    }

    private void addPanelListenerThickness(final Line item) {
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                lineThickness = item.getThickness();
                paint.setThickness(lineThickness);
            }
        });
    }

    private void setMenu(JMenuBar menu) {
        //The file menu
        JMenu file = new JMenu("File");
        JMenuItem newFile = new JMenuItem("New");
        //Create new Paint instance when new is selected 
        newFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PaintFrame p = new PaintFrame();
            }
        });
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");
        file.add(newFile);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        //Create the edit menu
        JMenu edit = new JMenu("Edit");
        JMenuItem undo = new JMenuItem("Undo");
        JMenuItem redo = new JMenuItem("Redo");
        //Colors Menu
        JMenu colors = new JMenu("Color");
        JMenuItem white = new JMenuItem("White");
        white.setBackground(Color.WHITE);
        white.setForeground(Color.BLACK);
        colors.add(white);
        JMenuItem red = new JMenuItem("Red");
        red.setForeground(Color.WHITE);
        red.setBackground(Color.RED);
        colors.add(red);
        JMenuItem blue = new JMenuItem("Blue");
        blue.setForeground(Color.WHITE);
        blue.setBackground(Color.BLUE);
        colors.add(blue);
        JMenuItem yellow = new JMenuItem("Yellow");
        yellow.setForeground(Color.WHITE);
        yellow.setBackground(Color.YELLOW);
        colors.add(yellow);
        JMenuItem black = new JMenuItem("Black");
        black.setForeground(Color.WHITE);
        black.setBackground(Color.BLACK);
        colors.add(black);
        JMenuItem green = new JMenuItem("Green");
        green.setForeground(Color.WHITE);
        green.setBackground(Color.GREEN);
        colors.add(green);
        JMenuItem orange = new JMenuItem("Orange");
        orange.setForeground(Color.WHITE);
        orange.setBackground(Color.ORANGE);
        colors.add(orange);
        JMenuItem pink = new JMenuItem("Pink");
        pink.setForeground(Color.WHITE);
        pink.setBackground(Color.PINK);
        colors.add(pink);
        addActionListenerColor(white);
        addActionListenerColor(red);
        addActionListenerColor(blue);
        addActionListenerColor(yellow);
        addActionListenerColor(black);
        addActionListenerColor(green);
        addActionListenerColor(orange);
        addActionListenerColor(pink);
        edit.add(undo);
        edit.add(redo);
        menu.add(file);
        menu.add(edit);
        menu.add(colors);
        //Add a menu to set the line thickness
        JMenu thickness = new JMenu("Line Thickness");
        JMenuItem thin = new JMenuItem("Thin");
        thin.setName("1");
        thickness.add(thin);
        JMenuItem medThin = new JMenuItem("Medium Thin");
        medThin.setName("4");
        thickness.add(medThin);
        JMenuItem med = new JMenuItem("Medium");
        med.setName("8");
        thickness.add(med);
        JMenuItem medThick = new JMenuItem("Medium Thick");
        medThick.setName("11");
        thickness.add(medThick);
        JMenuItem thick = new JMenuItem("Thick");
        thick.setName("15");
        thickness.add(thick);
        menu.add(thickness);
        //Add the action listeners to the menuItems
        addActionListenerThickness(thin);
        addActionListenerThickness(medThin);
        addActionListenerThickness(med);
        addActionListenerThickness(medThick);
        addActionListenerThickness(thick);

        //Add a background menu to paint the background the current color
        JMenu background = new JMenu("Background");
        JMenuItem paintBackground = new JMenuItem("Paint Background");
        background.add(paintBackground);
        paintBackground.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                paint.setBackground(color);
            }
        });
        menu.add(background);
    }

    private void setColorPalet() {
        colorPalet = new JPanel(new GridLayout(0, 2, 4, 6));
        colorPalet.setPreferredSize(new Dimension(95, 185));
        colorPalet.setBackground(Color.LIGHT_GRAY);
        JPanel whiteP = new JPanel();
        whiteP.setBackground(Color.white);
        whiteP.setSize(40, 40);
        colorPalet.add(whiteP);
        JPanel blackP = new JPanel();
        blackP.setBackground(Color.black);
        blackP.setSize(40, 40);
        colorPalet.add(blackP);
        JPanel redP = new JPanel();
        redP.setBackground(Color.red);
        redP.setSize(40, 40);
        colorPalet.add(redP);
        JPanel blueP = new JPanel();
        blueP.setBackground(Color.blue);
        blueP.setSize(40, 40);
        colorPalet.add(blueP);
        JPanel yellowP = new JPanel();
        yellowP.setBackground(Color.yellow);
        yellowP.setSize(40, 40);
        colorPalet.add(yellowP);
        JPanel greenP = new JPanel();
        greenP.setBackground(Color.green);
        greenP.setSize(40, 40);
        colorPalet.add(greenP);
        JPanel orangeP = new JPanel();
        orangeP.setBackground(Color.orange);
        orangeP.setSize(40, 40);
        colorPalet.add(orangeP);
        JPanel pinkP = new JPanel();
        pinkP.setBackground(Color.pink);
        pinkP.setSize(40, 40);
        colorPalet.add(pinkP);
        addPanelColorListener(whiteP);
        addPanelColorListener(blackP);
        addPanelColorListener(redP);
        addPanelColorListener(blueP);
        addPanelColorListener(greenP);
        addPanelColorListener(blueP);
        addPanelColorListener(yellowP);
        addPanelColorListener(orangeP);
        addPanelColorListener(pinkP);
    }

    private void setShapePicker() {
        shapes = new JPanel();//new GridLayout(0, 1, 0, 10));
        shapes.setBackground(Color.lightGray);
    }

    private void setThicknessChooser() {
        JButton painter = new JButton("Paint");
        painter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                paint.setBackground(color);
            }
        });
        lineChooser = new JPanel(new GridLayout(0, 1, 0, 5));
        lineChooser.setBackground(Color.LIGHT_GRAY);
        lineChooser.add(painter);
        JLabel h = new JLabel("Line Thickness");
        lineChooser.add(h);
        Line line1 = new Line(color, 1);
        Line line2 = new Line(color, 4);
        Line line3 = new Line(color, 8);
        Line line4 = new Line(color, 11);
        Line line5 = new Line(color, 15);
        addPanelListenerThickness(line1);
        addPanelListenerThickness(line2);
        addPanelListenerThickness(line3);
        addPanelListenerThickness(line4);
        addPanelListenerThickness(line5);
        lineChooser.add(line1);
        lineChooser.add(line2);
        lineChooser.add(line3);
        lineChooser.add(line4);
        lineChooser.add(line5);
        JLabel shapesL = new JLabel("     Shapes");
        lineChooser.add(shapesL);
    }

}
