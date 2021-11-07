import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;

public class Protetor extends JPanel { // painel para desenhar triângulos
    GeneralPath poligono;
    int raio = 100;

    public Protetor() {
        poligono = new GeneralPath();
        int x, y, forma = 3;
        // construir o triângulos equilátero
        poligono.moveTo(0, -raio);
        for (int i = 1; i < forma; i++) {
            x = (int) (raio * Math.cos(2 * Math.PI / forma * i));
            y = (int) (raio * Math.sin(2 * Math.PI / forma * i));
            poligono.lineTo(x, y);
        }
        poligono.closePath();

        Timer t = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        t.start();
        // registrar o evento do mouse para fechar o programa
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.exit(0);
            }
        });
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Random rand = new Random();
        Point p = new Point();
        Graphics2D g2d = (Graphics2D) g;
        Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));

        // desenha 10 triângulos em posições aleatórias
        for (int k = 0; k < 10; k++) {
            p.x = rand.nextInt(getWidth() - raio);
            p.y = rand.nextInt(getHeight() - raio);
            g2d.translate(p.x, p.y);
            g2d.rotate(p.x * Math.PI / 180);
            g2d.setPaint(new GradientPaint(0, 0, color1, raio, raio, color2));
            g2d.fill(poligono);
            g2d.rotate(-1 * (Math.toRadians(p.x)));
            g2d.translate(-p.x, -p.y);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Protetor de tela");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension D = tk.getScreenSize();
        frame.setSize(D);
        frame.add(new Protetor());
        frame.setUndecorated(true);
        frame.setVisible(true);
        // Registrar evento do teclado para fechar o programa.
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
    } // fim da classe ProtetorDeTela 9
}