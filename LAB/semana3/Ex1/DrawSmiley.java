import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawSmiley extends JPanel {
    boolean desenha = true;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // draw the face
        g.setColor(Color.YELLOW);
        g.fillOval(10, 10, 200, 200);
        // draw the eyes
        g.setColor(Color.BLACK);
        g.fillOval(55, 65, 30, 30);
        if (desenha)
            g.fillOval(135, 65, 30, 30);
        // draw the mouth
        g.fillOval(50, 110, 120, 60);
        // "touch up" the mouth into a smile
        g.setColor(Color.YELLOW);
        g.fillRect(50, 110, 120, 30);
        g.fillOval(50, 120, 120, 40);
    }

    // end method paintComponent// construtor de DrawSmiley para inicializar o Timer
    public DrawSmiley() {
        Timer t = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                desenha = !desenha;
                repaint();
            }
        });
        t.start();
    }
} // end class DrawSmiley// Aplicativo de teste que exibe um rosto sorridente.
