import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ex5 extends JPanel {
    private final int[] data;
    private int total;
    private final Color[] colors;

    public Ex5(int[] data, Color[] colors) {
        this.data = data;
        this.colors = colors;
        total = 0;
        for (int i : data) {
            total += i;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension size = getSize();
        Graphics2D g2d = (Graphics2D) g;
        int radius = Math.min(size.width, size.height) / 2 - 10;
        // desenhar as fatias
        float angle = 0;
        for (int i = 0; i < data.length; i++) {
            float perc = data[i] / (float) total; // calcula % da fatia
            g.setColor(colors[i]);
            g.fillArc(10, 10, radius * 2, radius * 2, (int) (angle * 360), (int) (perc * 360));
            angle += perc; // incrementa ângulo da próxima fatia
        }

        // desenhar as legenda
        angle = 0;
        for (int i = 0; i < data.length; i++) {
            float perc = data[i] / (float) total;
            int x = size.width / 2;
            int y = size.height / 2;
            x += (int) (radius / 2 * Math.cos((angle + perc / 2.0f) * Math.PI * 2.0));
            y -= (int) (radius / 2 * Math.sin((angle + perc / 2.0f) * Math.PI * 2.0));
            g.setColor(Color.BLACK);
            g2d.drawString(String.format("%.1f%%", perc * 100.0), x, y);
            angle += perc;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public static void main(String args[]) {
        JFrame janela = new JFrame("Grafico de Pizza");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Ex5 pizza = new Ex5(new int[] { 1, 2, 3, 4, 5 },
                new Color[] { Color.LIGHT_GRAY, Color.YELLOW, Color.BLUE, Color.RED, Color.PINK });
        janela.add(pizza);
        janela.setSize(400, 400);
        janela.setVisible(true);
    }
}