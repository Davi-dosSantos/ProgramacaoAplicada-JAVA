// Atividade 2
// desenha espiral girando na tela.

import java.awt.*;//Color;
//import java.awt.Graphics;
import javax.swing.*;//JPanel;
import java.awt.event.*;

public class DrawEspiral extends JPanel {
	int angulo = 0;
	int[] pontosX, pontosY;

	public DrawEspiral() {
		// inicializar pontos da espiral.
		pontosX = new int[3 * 360]; // tres voltas
		pontosY = new int[pontosX.length]; // tres voltas

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

		Graphics2D g2d = (Graphics2D) g; // casting g para Graphics2D

		// altera o eixo para o centro do painel.
		// g2d.translate( getWidth()/2, getHeight()/2);
		g2d.translate(100, 100);

		// rotaciona o eixo de "angulo" graus
		g2d.rotate(angulo * Math.PI / 180);

		// mudar a cor da linha
		// g2d.setPaint( Color.RED );
		g2d.setPaint(new GradientPaint(0, 0, Color.RED, 100, 0, Color.BLUE, true));
		// desenha a espiral
		g2d.drawPolyline(pontosX, pontosY, pontosX.length);

	} // fim do m�todo paintComponent
} // fim da classe DrawEspiral
