// Fig. 7.23: DrawRainbowTest.java
// Aplicativo de teste para exibir um arco-�ris.
import javax.swing.JFrame;

public class DrawRainbowTest
{
   public static void main( String args[] )
   {
      DrawRainbow panel = new DrawRainbow();      
      JFrame application = new JFrame();
      
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.add( panel );
      application.setSize( 400, 250 );
      application.setVisible( true );
   } // fim de main
} // fim da classe DrawRainbowTest


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/