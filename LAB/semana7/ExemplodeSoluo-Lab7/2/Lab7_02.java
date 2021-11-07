
import javax.swing.JFrame;

public class Lab7_02
{
   // execute application
   public static void main(String[] args)
   {
      JFrame janela =  new JFrame ("teste slider");
	  janela.add( new SliderPanel());
	  janela.setSize(400,150);
	  janela.setVisible(true);
      janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   } 
} // end class Lab7_02
