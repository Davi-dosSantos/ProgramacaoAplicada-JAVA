import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.Random;
import javax.swing.*;

public class Hexagono extends JPanel {
    public Hexagono() {
        // timer para atualizar a janela
        Timer t = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        t.start();
        // registrar eventodomouse para fechar janela
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
        int raio, forma = 6;
        Graphics2D g2d = (Graphics2D) g;
        for (int k = 0; k < 10; k++) {
            raio = 30 + rand.nextInt(80);
            // forma = 3 + rand.nextInt(3); // sortear forma a ser desenhada
            GeneralPath poligono = montaForma(forma, raio); // montar o hexagono
            // sortear posição que vai aparecer na tela
            p.x = rand.nextInt(getWidth() - raio);
            p.y = rand.nextInt(getHeight() - raio);
            Color color1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            Color color2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            g2d.translate(p.x, p.y);
            g2d.rotate(-Math.PI / 2);
            g2d.setPaint(new GradientPaint(0, raio / 2, color1, raio, raio / 2, color2));
            g2d.fill(poligono);
            g2d.rotate(Math.PI / 2);
            g2d.translate(-p.x, -p.y);
        }
    }

    public GeneralPath montaForma(int forma, int raio) {
        int x, y;
        GeneralPath poligono = new GeneralPath();
        poligono.moveTo(0, -raio);
        for (int i = 1; i < forma; i++) {
            x = (int) (raio * Math.cos(-Math.PI / 2 + 2 * Math.PI / forma * i));
            y = (int) (raio * Math.sin(-Math.PI / 2 + 2 * Math.PI / forma * i));
            poligono.lineTo(x, y);
            // se quiser desenhar cubo isométrico
            if (i % 2 == 1) {
                poligono.lineTo(0, 0);
                poligono.lineTo(x, y);
            }
        }
        poligono.closePath();
        return poligono;
    }

    // final da classe

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hexagonos");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension D = tk.getScreenSize();
        frame.setSize(D);
        frame.add(new Hexagono());
        frame.setUndecorated(true);
        frame.setVisible(true);
        // registrar evento do teclado para sair do programa
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                System.exit(0);
            }
        });
    }
}