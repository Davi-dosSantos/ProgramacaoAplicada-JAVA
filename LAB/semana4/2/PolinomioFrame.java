
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PolinomioFrame extends JFrame {

    private JTextField textoV1;
    private JButton btnCalcular;
    private JLabel display;

    public PolinomioFrame() {
        super("Polinomio");

        setLayout(new FlowLayout()); // altera o layout da janela

        add(new JLabel(
                "Entre com os coeficientes do polinomio separados por " + "espacos em ordem decrescente de grau: "));

        textoV1 = new JTextField(20); // alocoa caixa de texto para mostras 20 colunas
        add(textoV1); // coloca na interface grafica

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("Uma das raizes e : " + polinomioTotal(textoV1.getText()));
            }
        });

        add(btnCalcular);

        display = new JLabel("       ");
        add(display);

        setSize(700, 150);
        setVisible(true);
    }

    private double polinomioTotal(String polinomio) {

        StringTokenizer strT;
        strT = new StringTokenizer(polinomio);

        double[] coef = new double[strT.countTokens()];

        int i = 0;
        while (strT.hasMoreTokens()) {
            coef[i] = Double.valueOf(strT.nextToken());
            i++;
        }
        Polinomio p = new Polinomio(coef);
        return p.root(1000);
    }

}
