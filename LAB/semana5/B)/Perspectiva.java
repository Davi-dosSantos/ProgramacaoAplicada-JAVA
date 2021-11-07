import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;

public class Perspectiva extends JPanel {
    GeneralPath poligono;
    int raio = 100;

    public Perspectiva() {
        poligono = new GeneralPath();
        int x, y, forma = 6;
        // montar o hexágono
        poligono.moveTo(0, -raio);
        for (int i = 1; i < forma; i++) {
            x = (int) (raio * Math.cos(-Math.PI / 2 + 2 * Math.PI / forma * i));
            y = (int) (raio * Math.sin(-Math.PI / 2 + 2 * Math.PI / forma * i));
            poligono.lineTo(x, y);
            if (i % 2 == 1) { // interligar o centro ao vértice par
                poligono.lineTo(0, 0);
                poligono.lineTo(x, y);
            }
        }
        poligono.closePath();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        Point p = new Point();
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        // for (int k = 0; k < 5; k++) {
        p.x = rand.nextInt(getWidth() - raio);
        p.y = rand.nextInt(getHeight() - raio);
        g2d.translate(p.x, p.y);
        // g2d.rotate(p.x*Math.PI/180);
        g2d.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        // g2d.setPaint(new GradientPaint(0, 0, color1, raio, raio, color2));
        g2d.draw(poligono);
        // g2d.rotate(-1*(Math.toRadians(p.x)));
        g2d.translate(-p.x, -p.y);
        // }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Perspectiva");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Perspectiva());
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}// end class