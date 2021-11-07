// Atividade 3
// desenha grid 8x8 na tela.

import java.awt.*;//Color;
//import java.awt.Graphics;
import javax.swing.*;//JPanel;
import java.awt.event.*;

public class DrawGrid extends JPanel
{
   public final int quantidade = 8;
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      int passoX = getWidth()/quantidade;
	  int passoY = getHeight()/quantidade;
	  
	  for(int i = 0; i<= quantidade; i++)
	  {
			// linhas horizontais
			g.drawLine( 0, i*passoY, getWidth(), i*passoY);

			// linhas verticais
			g.drawLine( i*passoX, 0, i*passoX, getHeight() );
	  }
   } // fim do método paintComponent
} // fim da classe DrawGrid

