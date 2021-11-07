import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PascalFrame extends JFrame {
	private JTextField texto;
	private JTextArea display;

	public PascalFrame() {
		super("Triangulo de Pascal");
		setLayout(new FlowLayout()); // altera o layout da janela
		add(new JLabel("Digite o numero de linhas desejado do triangulo de pascal "));
		texto = new JTextField(6); // alocoa caixa de texto para mostrar 6 colunas
		// registrar o evento de ação para texto
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				montaTrianguloPascal();
			}
		});
		add(texto); // coloca na interface grafica
		display = new JTextArea(20, 70);
		display.setFont(new Font("Monospaced", Font.PLAIN, 10));
		add(new JScrollPane(display));
		setSize(500, 400);
		setVisible(true);
	}

	private void montaTrianguloPascal() {
		int linha;
		linha = Integer.parseInt(texto.getText());
		display.setText(" "); // Alocar a Matriz triangular
		int mat[][];
		mat = new int[linha][];
		for (int i = 0; i < mat.length; i++)
			mat[i] = new int[i + 2];
		mat[0][0] = 1;
		mat[0][1] = 1;
		for (int i = 1; i < mat.length; i++) {
			mat[i][0] = 1;
			mat[i][mat[i].length - 1] = 1;
			for (int j = 1; j < mat[i].length - 1; j++)
				mat[i][j] = mat[i - 1][j] + mat[i - 1][j - 1];
		}
		String triangulo = ""; // montar a interface de saida.
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++)
				triangulo += " " + mat[i][j];
			triangulo += "\n";
		}
		display.setText(triangulo);
	}
} // end class 6