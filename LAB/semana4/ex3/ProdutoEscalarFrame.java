
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ProdutoEscalarFrame extends JFrame {

	private JTextField textoV1;
	private JTextField textoV2;
	private JButton btnCalcular;
	private JLabel display;

    public ProdutoEscalarFrame() {
        super("Produto escalar de dois vetores");
		
		setLayout ( new FlowLayout() ); // altera o layout da janela
		
		add(new JLabel("Entre com os elementos dos vetores, separados por espaço nos campos abaixo: "));
		
		textoV1 = new JTextField(20); // alocoa caixa de texto para mostras 20 colunas
		add(textoV1);	//coloca na interface grafica
		textoV2 = new JTextField(20); // alocoa caixa de texto para mostras 20 colunas
		add(textoV2);	//coloca na interface grafica

		btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(  new ActionListener() { 
					public void actionPerformed(ActionEvent e){
						display.setText("Produto Escalar = " + produtoEscalar(textoV1.getText(), textoV2.getText()));
					}
			});
		
		add (btnCalcular);
		
		display = new JLabel("       ");
		add(display); 
		
		setSize(500,150);
		setVisible(true);
    }

    
	private int produtoEscalar(String v1, String v2) {
        int total = 0;
		String [] vetor1, vetor2;
        
		vetor1 = v1.split(" ");
		vetor2 = v2.split(" ");
		
		int tam = Math.min(vetor1.length, vetor2.length);
		
		for(int i = 0; i < tam; i++){
              total += Integer.parseInt(vetor1[i]) * Integer.parseInt(vetor2[i]);
          }
		
		return total;
    }

}
