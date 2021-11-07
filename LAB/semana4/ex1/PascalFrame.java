
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PascalFrame extends JFrame {

	private JTextField texto;
	private JTextArea display;

    public PascalFrame() {
        super("Triangulo de Pascal");
		
		setLayout ( new FlowLayout() ); // altera o layout da janela
		
		add(new JLabel("Digite o numero de linhas desejado do triangulo de pascal "));
		
		texto = new JTextField(6); // alocoa caixa de texto para mostras 6 colunas
		// registrar o evento de ação para texto
		texto.addActionListener( new ActionListener() { 
					public void actionPerformed(ActionEvent e){
						montaTrianguloPascal();
					}
			});
		add(texto);	//coloca na interface grafica
		
		display = new JTextArea(20,70);
		display.setFont(new Font("Monospaced", Font.PLAIN, 18));
		add(new JScrollPane(display)); 
		
		setSize(500,400);
		setVisible(true);
    }

    
private void montaTrianguloPascal() {
        int linha;
        
        linha = Integer.parseInt(texto.getText());
        
        display.setText(" ");
         
		//Alocar a Matriz triagular
		int mat[][];
		mat = new int [linha][];
		for(int i = 0 ; i< mat.length; i++)
			mat[i] = new int [i+2];
		 
		mat[0][0] = 1;
		mat[0][1] = 1;
		for(int i = 1; i< mat.length; i++){
			mat[i][0] = 1;
			mat[i][mat[i].length-1] = 1;
		  	for(int j = 1; j< mat[i].length-1; j++)
			{
                 mat[i][j] = mat[i-1][j] + mat[i-1][j - 1];
            }
		}
         
        // montar a interface de saida.
		String triangulo="";
		for(int i = 0; i< mat.length; i++){
		  for(int j = 0; j< mat[i].length; j++)
				triangulo += " " + mat[i][j];
		  triangulo += "\n";
		}
		display.setText(triangulo);
    }
    
	
    private void montaTrianguloPascal2() {
        int num;
        
        num = Integer.parseInt(texto.getText());
        
        display.setText(" ");
         
		int[] a = new int[1];
        for (int i = 1; i <= num; i++) {
            int[] x = new int[i];
            
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == (i - 1)) {
                    x[j] = 1;
                } else {
                    x[j] = a[j] + a[j - 1];
                }
                 display.append(Integer.toString(x[j])+ " ");
            }
            a = x;
            display.append("\n");
        }
    }

    
}
