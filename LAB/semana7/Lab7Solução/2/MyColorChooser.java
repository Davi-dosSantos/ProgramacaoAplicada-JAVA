
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;



public class MyColorChooser extends JPanel 
{
	private SliderPanel sliderR;
	private SliderPanel sliderG;
	private SliderPanel sliderB;
	
	
	public MyColorChooser ()
	{
		setLayout(new GridLayout(3,1) );
		
		sliderR = new SliderPanel();
		sliderG = new SliderPanel();
		sliderB= new SliderPanel();
		
		add (sliderR);
		add (sliderG);
		add (sliderB);
		
		sliderR.setOpaque(false);
		sliderG.setOpaque(false);
		sliderB.setOpaque(false);
	}
	
   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      g.setColor(getColor());
	  g.fillRect(0,0, 200,200);
	  
	  //setBackground(getColor()); 
	  this.setBackground(getColor());
   }

  
   
   // used by layout manager to determine preferred size
   public Dimension getPreferredSize()
   {
      return new Dimension(400, 150);
   }

   // used by layout manager to determine minimum size
   public Dimension getMinimumSize()
   {
      return getPreferredSize();
   } 
   
   public Color getColor ()
   {
	   Color cor = new Color(sliderR.getValue(), sliderG.getValue(), sliderB.getValue() );
	   return cor;
   }
   
   
   //main de teste
    // execute application
   public static void main(String[] args)
   {
      JFrame janela =  new JFrame ("teste MyColorChooser");
	  janela.add( new MyColorChooser());
	  janela.setSize(400,450);
	  janela.setVisible(true);
      janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
   
} // end class MyColorChooser

