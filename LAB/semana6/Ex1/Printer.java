import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

public class Printer extends JPanel {
    private JPanel imagePanel;
    private JCheckBox tipo[];
    private JPanel selectPanel;
    private JRadioButton selecao[];

    private JPanel painelControl;

    private JLabel labelPQ;
    private JComboBox comboQualidade;
    private JPanel painelSul;

    private JButton botoesLeste[];
    private JPanel painelLeste;
    private String textosRadio[] = { "Selection", "All", "Help" };

    private JPanel painelCentro;

    private String textosBotoes[] = { "Ok", "Cancel", "Setup...", "Help" };
    private String textosCheck[] = { "Image", "Text", "Code" };

    public Printer() {

        setLayout(new BorderLayout());
        botoesLeste = new JButton[textosBotoes.length]; // create buttons array
        painelLeste = new JPanel(); // set up panel
        painelLeste.setLayout(new GridLayout(botoesLeste.length, 1));
        // create and add buttons
        for (int count = 0; count < botoesLeste.length; count++) {
            botoesLeste[count] = new JButton(textosBotoes[count]);
            painelLeste.add(botoesLeste[count]); // add button to panel
        } // end for 5

        add(painelLeste, BorderLayout.EAST); // add o painelLeste ao JFrame

        painelCentro = new JPanel(); // set up panel
        painelCentro.setLayout(new BorderLayout());

        add(painelCentro, BorderLayout.CENTER);

        painelControl = new JPanel(); // set up panel
        painelControl.setLayout(new GridLayout(1, 5));

        painelCentro.add(painelControl, BorderLayout.CENTER);

        painelCentro.add(new JLabel("Printer: MyPrinter"), BorderLayout.NORTH);

        painelSul = new JPanel(); // set up panel
        painelSul.add(new JLabel("Printer: Quality: "));
        String op[] = { "High", "Medium", "Low" };
        painelSul.add(new JComboBox(op));
        painelSul.add(new JCheckBox("Print to File"));

        painelControl.add(painelSul, BorderLayout.SOUTH);

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(textosCheck.length, 1));

        selectPanel = new JPanel();
        selectPanel.setLayout(new GridLayout(textosCheck.length, 1));

        tipo = new JCheckBox[textosCheck.length];
        for (int i = 0; i < textosCheck.length; i++) {
            tipo[i] = new JCheckBox(textosCheck[i]);
            imagePanel.add(tipo[i]);
        }

        selecao = new JRadioButton[textosRadio.length];
        for (int i = 0; i < textosRadio.length; i++) {
            selecao[i] = new JRadioButton(textosRadio[i]);
            selectPanel.add(selecao[i]);
        }

        painelControl.add(new JLabel());
        painelControl.add(imagePanel);
        painelControl.add(new JLabel());
        painelControl.add(selectPanel);
        painelControl.add(new JLabel());

    } // end constructor

    public static void main(String args[]) {
        JFrame janela;
        janela = new JFrame("Printer");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new Printer());
        janela.setSize(600, 200);
        janela.setVisible(true);
    } // end main
} // end class Calculadora