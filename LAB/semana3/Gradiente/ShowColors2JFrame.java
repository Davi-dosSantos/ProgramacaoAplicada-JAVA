// Exemplo de solução da atividade 6. Baseado em figura 13.7
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowColors2JFrame extends JFrame 
{
   private final JButton changeColorFJButton;
   private final JButton changeColorIJButton;
   private Color corInicial = Color.YELLOW;
   private Color corFinal = Color.BLUE;
   private JGradientePanel colorJPanel;

   // set up GUI
   public ShowColors2JFrame()
   {
      super("Configurando um Gradiente");

      // create JPanel for display color
      colorJPanel = new JGradientePanel();
      colorJPanel.setCorInicial(corInicial);
	  colorJPanel.setCorFinal(corFinal);

      // set up changeColorFJButton and register its event handler
      changeColorFJButton = new JButton("Cor Final");
      changeColorFJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event)
            {
               corFinal = JColorChooser.showDialog(
                  ShowColors2JFrame.this, "Choose a color", corFinal);

               // set default color, if no colorj is returned 
               if (corFinal == null)
                  corFinal = Color.YELLOW;

               // change content pane's background color
               colorJPanel.setCorFinal(corFinal);
            } 
         } // end anonymous inner class
      ); // end call to addActionListener
 
 // set up changeColorIJButton and register its event handler
      changeColorIJButton = new JButton("Cor Inicial");
      changeColorIJButton.addActionListener(
         new ActionListener() // anonymous inner class
         {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event)
            {
               corInicial = JColorChooser.showDialog(
                  ShowColors2JFrame.this, "Choose a color", corInicial);

               // set default color, if no color is returned 
               if (corInicial == null)
                  corInicial = Color.BLUE;

               // change content pane's background color
               colorJPanel.setCorInicial(corInicial);
            } 
         } // end anonymous inner class
      ); // end call to addActionListener
 
      add(colorJPanel, BorderLayout.CENTER); 
      add(changeColorFJButton, BorderLayout.SOUTH);
	  add(changeColorIJButton, BorderLayout.NORTH);

      setSize(400, 400);
      setVisible(true);
   } // end ShowColor2JFrame constructor
} // end class ShowColors2JFrame

/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
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
