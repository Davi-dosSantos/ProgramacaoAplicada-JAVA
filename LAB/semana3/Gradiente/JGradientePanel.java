//
//Classe que representa um painel para teste de Gradiente de cores
//
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class JGradientePanel extends JPanel
{
	// define as variáveis para cor inicial e final do gradiente.
	Color c1, c2;
	
	//construtor padrão
	public JGradientePanel()
	{
		c1 = Color.YELLOW;
		c2 = Color.BLUE;
	}
	
	// metodo que permite a alteração da cor inicial do gradiente
	public void setCorInicial(Color corInicial){
		if (corInicial == null)
                corInicial = Color.YELLOW;
			
		c1 = corInicial;
		repaint();
	}

	// metodo que permite a alteração da cor final do gradiente
	public void setCorFinal(Color corFinal){
		if (corFinal == null)
                corFinal = Color.BLUE;
			
		c2 = corFinal;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g; // casting g para Graphics2D
		
		// Cria um gradiente vertical a partir do ponto inicial 0,0 com cor c1 end
		// termino em 0 , altura do painel com cor c2.
		
		//--------------------------------------------------------------
		//Gradiente normal de duas cores
		// -------------------------------------------------------------
		GradientPaint p = new GradientPaint(0, 0, c1, 0, getHeight(), c2, true);
		
		
		//--------------------------------------------------------------
		//Gradiente radial e com multiplas cores
		// -------------------------------------------------------------
		//Point2D center = new Point2D.Float(getWidth()/2, getHeight()/2);
		//float radius = getWidth()/4;
		//Point2D focus = new Point2D.Float(getWidth()/3, getHeight()/3);
		//float[] dist = {0.33f, 0.66f, 1.0f};
		//Color[] colors = {c1, Color.WHITE, c2};
		//RadialGradientPaint p =
		//	new RadialGradientPaint(center, radius, //focus, 
		//							dist, colors,
		//							MultipleGradientPaint.CycleMethod.NO_CYCLE); //NO_CYCLE, REFLECT, or REPEAT
		//---------------------------------------------------------------
	   	
		//--------------------------------------------------------------
		//Gradiente linear com multiplas cores
		// -------------------------------------------------------------
//		Point2D start = new Point2D.Float(0, 0);
//		Point2D end = new Point2D.Float(0, getHeight());
//		float[] dist = {0.10f, 0.25f, 0.40f, 0.55f, 0.70f, 0.85f, 1.0f};
//		Color colors[] = { Color.RED, Color.MAGENTA, Color.BLUE, Color.CYAN,
//							Color.GREEN, Color.YELLOW, Color.RED };
//		LinearGradientPaint p =
//				new LinearGradientPaint(start, end, dist, colors, 
//									MultipleGradientPaint.CycleMethod.NO_CYCLE);


		// E seleciona no contexto grafico
		g2d.setPaint(p);
		
		// desenha retangulo 2D preenchida com um gradiente c1-c2
		g2d.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight() ));

 
		
	}
} // end class JGradientePanel