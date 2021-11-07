
// Atividade 2
// desenha espiral girando na tela.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawEspiral extends JPanel {
    int angulo = 0;
    int[] pontosX, pontosY;

    public DrawEspiral() {
        // inicializar pontos da espiral.
        pontosX = new int[3 * 360]; // três voltas
        pontosY = new int[pontosX.length]; // três voltas
        // calcular a espiral centrada em 0,0
        for (int i = 0; i < pontosX.length; i++) {
            pontosX[i] = (int) (0.2 * i * Math.cos(i * Math.PI / 180));
            pontosY[i] = (int) (0.2 * i * Math.sin(i * Math.PI / 180));
        }
        // cria o timer para fazer a espiral girar
        Timer t = new Timer(200, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                angulo += 5;
                angulo %= 360;
                repaint();
            }
        });
        t.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.translate(100, 100);

        g2d.rotate(angulo * Math.PI / 180);

        g2d.setPaint(Color.RED); // mudar a cor da linha
        g2d.drawPolyline(pontosX, pontosY, pontosX.length); // desenha a espiral

    } // fim do método paintComponent

    public static void main(String[] args) {
        DrawEspiral panel = new DrawEspiral();
        JFrame application = new JFrame("Desenhando uma Espiral");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);
    } // fim de main
} // fim da classe DrawEspiral