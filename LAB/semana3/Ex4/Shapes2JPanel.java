import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Shapes2JPanel extends JPanel {
    // desenha caminhos gerais
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // chama o paintComponent da superclasse
        Random random = new Random(); // obtém o gerador de números aleatórios
        int xPoints[] = { 67, 55, 43 };
        int yPoints[] = { 0, 96, 36 };
        Graphics2D g2d = (Graphics2D) g;
        GeneralPath triangle = new GeneralPath(); // cria o objeto GeneralPath

        // configura a coordenada inicial do General Path
        triangle.moveTo(xPoints[0], yPoints[0]);
        // cria a triangulos -- isso não desenha a triangulos
        for (int count = 1; count < xPoints.length; count++)
            triangle.lineTo(xPoints[count], yPoints[count]);
        triangle.closePath(); // fecha a forma
        g2d.translate(random.nextInt(200), random.nextInt(200)); // translada a origem para (200, 200)
        // gira em torno da origem e desenha trianguloss em cores aleatórias
        for (int count = 1; count <= 20; count++) {
            g2d.rotate(Math.PI / 10.0); // rotaciona o sistema de coordenadas
            // configura cores aleatórias
            g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g2d.fill(triangle); // desenha triangulos preenchida
        } // for final
    } // fim do método paintComponent
} // fim da classe Shapes2JPanel
