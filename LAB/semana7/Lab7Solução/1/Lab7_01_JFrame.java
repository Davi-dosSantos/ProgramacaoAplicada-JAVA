
// Exemplo de solução da atividade 1. Baseado em figura 13.7 e ex6 do lab3
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lab7_01_JFrame extends JFrame {
   private final JButton changeColorFJButton;
   private final JButton changeColorIJButton;
   private Color corInicial = Color.YELLOW;
   private Color corFinal = Color.BLUE;
   private JGradientePanel colorJPanel;

   // set up GUI
   public Lab7_01_JFrame() {
      super("Configurando um Gradiente");

      // create JPanel for display color
      colorJPanel = new JGradientePanel();
      colorJPanel.setCorInicial(corInicial);
      colorJPanel.setCorFinal(corFinal);

      // set up changeColorFJButton and register its event handler
      changeColorFJButton = new JButton("Cor Final");
      changeColorFJButton.addActionListener(new ActionListener() // anonymous inner class
      {
         // display JColorChooser when user clicks button
         @Override
         public void actionPerformed(ActionEvent event) {
            selecionaCorFinal();
         }
      } // end anonymous inner class
      ); // end call to addActionListener

      // set up changeColorIJButton and register its event handler
      changeColorIJButton = new JButton("Cor Inicial");
      changeColorIJButton.addActionListener(new ActionListener() // anonymous inner class
      {
         // display JColorChooser when user clicks button
         @Override
         public void actionPerformed(ActionEvent event) {
            selecionaCorInicial();
         }
      } // end anonymous inner class
      ); // end call to addActionListener

      add(colorJPanel, BorderLayout.CENTER);
      add(changeColorFJButton, BorderLayout.SOUTH);
      add(changeColorIJButton, BorderLayout.NORTH);

      preparaMenu();

      setSize(400, 400);
      setVisible(true);

   } // end Lab7_01_JFrame constructor

   public void preparaMenu() {
      JMenuBar barra = new JMenuBar();
      JMenu menuArquivo = new JMenu("Arquivo");
      menuArquivo.setMnemonic('A');
      barra.add(menuArquivo);

      JMenu menuConfigurar = new JMenu("Configurar");
      menuConfigurar.setMnemonic('C');
      barra.add(menuConfigurar);

      setJMenuBar(barra);

      JMenuItem itemSobre = new JMenuItem("Sobre ...");
      menuArquivo.add(itemSobre);
      itemSobre.addActionListener(new ActionListener() // anonymous inner class
      {
         @Override
         public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(Lab7_01_JFrame.this, "Solucao\nquestao 1 do lab 07\n Davi dos Santos Costa",
                  "Sobre", JOptionPane.PLAIN_MESSAGE);
         }
      });
      menuArquivo.addSeparator();

      JMenuItem itemSair = new JMenuItem("Sair");
      menuArquivo.add(itemSair);
      itemSair.addActionListener(new ActionListener() // anonymous inner class
      {
         // terminate application when user clicks exitItem
         @Override
         public void actionPerformed(ActionEvent event) {
            System.exit(0); // exit application
         }
      });

      JMenuItem itemCorInicial = new JMenuItem("Cor Inicial ...");
      menuConfigurar.add(itemCorInicial);
      itemCorInicial.addActionListener(new ActionListener() // anonymous inner class
      {
         // display JColorChooser when user clicks button
         @Override
         public void actionPerformed(ActionEvent event) {
            selecionaCorInicial();
         }
      } // end anonymous inner class
      ); // end call to addActionListener

      JMenuItem itemCorFinal = new JMenuItem("Cor Final ...");
      menuConfigurar.add(itemCorFinal);
      itemCorFinal.addActionListener(new ActionListener() // anonymous inner class
      {
         // display JColorChooser when user clicks button
         @Override
         public void actionPerformed(ActionEvent event) {
            selecionaCorFinal();
         }
      } // end anonymous inner class
      ); // end call to addActionListener

   }

   public void selecionaCorInicial() {
      corInicial = JColorChooser.showDialog(Lab7_01_JFrame.this, "Choose a color", corInicial);

      // set default color, if no color is returned
      if (corInicial == null)
         corInicial = Color.BLUE;

      // change content pane's background color
      else
         colorJPanel.setCorInicial(corInicial);
   }

   public void selecionaCorFinal() {
      corFinal = JColorChooser.showDialog(Lab7_01_JFrame.this, "Choose a color", corFinal);

      // set default color, if no colorj is returned
      if (corFinal == null)
         corFinal = Color.YELLOW;

      // change content pane's background color
      else
         colorJPanel.setCorFinal(corFinal);
   }
} // end class Lab7_01_JFrame
