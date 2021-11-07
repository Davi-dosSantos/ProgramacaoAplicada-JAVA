import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class PaintPanel2 extends JPanel 
{
   // list Point references
   private final ArrayList<Point> points = new ArrayList<>(); 
   private final ArrayList<Color> cores = new ArrayList<>();
   private Color corAtual = Color.BLACK;
   // set up GUI and register mouse event handler
   public PaintPanel2()
   {
      // handle frame mouse motion event
      addMouseMotionListener(
         new MouseMotionAdapter() // anonymous inner class
         {  
            // store drag coordinates and repaint
            @Override
            public void mouseDragged(MouseEvent event)
            {
               points.add(event.getPoint());
			   cores.add(corAtual);
               repaint(); // repaint JFrame
            } 
         } 
      ); 
   }

   public void setCorAtual(Color c)
   {
      if( c != null )
		corAtual = c;
	  else 
		corAtual = Color.BLACK;
   }

   // draw ovals in a 4-by-4 bounding box at specified locations on window
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g); // clears drawing area

      // draw all 
	  int n = cores.size();
      for (int i = 0; i < n; i++ )
	  {
		 Point point = points.get(i);
		 g.setColor( cores.get(i) );
         g.fillOval(point.x, point.y, 4, 4);
	  }
   } 
	
} // end class PaintPanel2
