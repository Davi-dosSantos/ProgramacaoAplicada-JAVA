
// Fig. 6.17: DrawSmileyTest.java
// Aplicativo de teste que exibe um rosto sorridente.
import javax.swing.JFrame;

public class DrawEspiralTest {
   public static void main(String args[]) {
      DrawEspiral panel = new DrawEspiral();
      JFrame application = new JFrame("Desenhando uma Espiral");

      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.add(panel);
      application.setSize(500, 500);
      application.setVisible(true);
   } // fim de main
} // fim da classe DrawEspiralTest
