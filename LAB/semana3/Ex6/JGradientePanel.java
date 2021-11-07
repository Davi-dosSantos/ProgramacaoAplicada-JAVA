import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class JGradientePanel extends JPanel {
    Color c1, c2; // define as variáveis para cor inicial e final do gradiente.

    public JGradientePanel() {
        c1 = Color.YELLOW;
        c2 = Color.BLUE;
    }

    public void setCorInicial(Color corInicial) {
        if (corInicial == null)
            corInicial = Color.YELLOW;
        c1 = corInicial;
        repaint();
    }

    public void setCorFinal(Color corFinal) {
        if (corFinal == null)
            corFinal = Color.BLUE;
        c2 = corFinal;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // casting g para Graphics2D
        // Cria um gradiente vertical a partir do ponto inicial 0,0 com cor c1 e
        // termino em 0, altura do painel com cor c2. E seleciona no contexto gráfico
        g2d.setPaint(new GradientPaint(0, 0, c1, 0, getHeight(), c2, true));
        // desenha retângulo 2D preenchida com um gradiente azul-amarelo
        g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
    }
} // end class JGradientePanel 27