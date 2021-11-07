
// Exemplo de solução da atividade 6. Baseado em figura 13.7
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowColors2JFrame extends JFrame {
    private final JButton changeColorFJButton;
    private final JButton changeColorIJButton;
    private Color corInicial = Color.YELLOW;
    private Color corFinal = Color.BLUE;
    private JGradientePanel colorJPanel;

    public ShowColors2JFrame() // configura a GUI
    {
        super("Configurando um Gradiente");
        // cria JPanel para exibir as cores
        colorJPanel = new JGradientePanel();
        colorJPanel.setCorInicial(corInicial);
        colorJPanel.setCorFinal(corFinal);
        // configura changeColorFJButton e registra sua rotina de tratamento de evento
        changeColorFJButton = new JButton("Cor Final");
        changeColorFJButton.addActionListener(new ActionListener() // classe interna anônima
        {
            // exibe JColorChooser quando o usuário clica no botão
            @Override
            public void actionPerformed(ActionEvent event) {
                corFinal = JColorChooser.showDialog(ShowColors2JFrame.this, "Cor Inicial do Gradiente", Color.BLUE);
                // configura a cor padrão, se nenhuma cor for retornada
                if (corFinal == null)
                    corFinal = Color.YELLOW;
                // muda a cor de fundo do painel de conteúdo
                colorJPanel.setCorFinal(corFinal);
            } // fim do método actionPerformed
        } // fim da classe interna anônima
        ); // fim da chamada para addActionListener 23
           // set up changeColorIJButton and register its event handler
        changeColorIJButton = new JButton("Cor Inicial");
        changeColorIJButton.addActionListener(new ActionListener() // anonymous inner class
        {
            // display JColorChooser when user clicks button
            @Override
            public void actionPerformed(ActionEvent event) {
                corInicial = JColorChooser.showDialog(ShowColors2JFrame.this, "Choose a color", corInicial);
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
  // Figura 13.8: ShowColors2.java
  // Escolhendo cores com JColorChooser.
