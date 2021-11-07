
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawGrid extends JPanel {
    public final int quantidade = 8;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int passoX = getWidth() / quantidade;
        int passoY = getHeight() / quantidade;
        for (int i = 0; i <= quantidade; i++) {
            g.drawLine(0, i * passoY, getWidth(), i * passoY); // linhas horizontais
            g.drawLine(i * passoX, 0, i * passoX, getHeight()); // linhas verticais
        }
    } // fim do método paintComponent

    public static void main(String args[]) {
        DrawGrid panel = new DrawGrid();
        JFrame application = new JFrame("8x8 Grid");

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.add(panel);
        application.setSize(500, 500);
        application.setVisible(true);
    } // fim de main
} // fim da classe DrawGrid
