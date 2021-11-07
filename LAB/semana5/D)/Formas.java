
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Formas extends JPanel {
    private int forma = 1;
    private JRadioButton bola;
    private JRadioButton tri;
    private JRadioButton quad;
    private ButtonGroup radioGroup;

    public Formas() {
        bola = new JRadioButton("Circulo", true);
        tri = new JRadioButton("Triangulo", false);
        quad = new JRadioButton("Quadrado", false);
        add(bola);
        add(tri);
        add(quad);
        radioGroup = new ButtonGroup();
        radioGroup.add(bola);
        radioGroup.add(tri);
        radioGroup.add(quad);
        // register events for JRadioButtons
        bola.addItemListener(new TrataEvento(1));
        tri.addItemListener(new TrataEvento(2));
        quad.addItemListener(new TrataEvento(3));
    } // end Formas constructor
      // private inner class to handle radio button events

    private class TrataEvento implements ItemListener {
        // Numero da forma a ser desenhada
        private int var;

        public TrataEvento(int i) {
            var = i;
        }

        @Override
        public void itemStateChanged(ItemEvent ie) {
            forma = var;
            repaint();
        }
    } // end private inner class TrataEvento

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        if (forma == 1) {
            g.fillOval(90, 90, 100, 100);
        }
        if (forma == 2) {
            int[] x = { 90, 190, 140 };
            int[] y = { 190, 190, 90 };
            g.fillPolygon(x, y, 3);
        }
        if (forma == 3) {
            g.fillRect(90, 90, 100, 100);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Desenha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Formas());
        frame.setSize(300, 300); // set frame size
        frame.setVisible(true); // display frame
    }
}