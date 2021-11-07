import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

public class Calculadora extends JPanel {
    private JPanel teclado; // panel to hold buttons
    private JButton buttons[]; // array of buttons
    private String textos[] = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+" };

    public Calculadora() {
        setLayout(new BorderLayout());
        buttons = new JButton[textos.length]; // create buttons array
        teclado = new JPanel(); // set up panel
        teclado.setLayout(new GridLayout(4, 4));
        // create and add buttons
        for (int count = 0; count < buttons.length; count++) {
            buttons[count] = new JButton(textos[count]);
            teclado.add(buttons[count]); // add button to panel
        } // end for 5

        add(teclado, BorderLayout.CENTER); // add o teclado ao JFrame
        add(new JTextField(), BorderLayout.NORTH); // adicionar o display
    } // end Calculadora constructor

    public static void main(String args[]) {
        JFrame janela;
        janela = new JFrame("Janela para calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new Calculadora());
        janela.setSize(230, 250);
        janela.setVisible(true);
    } // end main
} // end class Calculadora