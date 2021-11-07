import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Histograma extends JFrame{
    private final JButton btnCalcular;
    private JLabel vetor1;
    private JLabel vetor2;
    private JLabel display;
    private drawHistograma histograma;
    
    public Histograma(){
        super("Histograma");
        setLayout ( new FlowLayout() );
        add(new JLabel("Media da soma de dois numeros:\n"));
       
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        histograma = new drawHistograma();
        btnCalcular = new JButton("Calcular");
        
		btnCalcular.addActionListener(  new ActionListener() { 
				public void actionPerformed(ActionEvent e){
                    vetor1.setText(""+(random.nextInt(6) + (1)));
                    vetor2.setText(""+(random.nextInt(6) + (1)));
                    numbers.add(Integer.parseInt(vetor1.getText()) + 
									Integer.parseInt(vetor2.getText()));
                    histograma.setDados(numbers);
					display.setText("Media acumulada = " + media(numbers) + ".");
				}
			});
		
		add(btnCalcular);
        
        add(new JLabel("Numero A: "));
        vetor1 = new JLabel(" ");
		add(vetor1);
        
        add(new JLabel("Numero B: "));
		vetor2 = new JLabel(" ");
		add(vetor2);
        
        add(histograma);
        
        display = new JLabel(" ");
		add(display);
        
        setSize(800,700);
		setVisible(true);
    }
    
    public float media(ArrayList<Integer> a){
        int m = 0;
        for(int i = 0; i <a.size(); i++)
            m += a.get(i);
        return (float)m/a.size();
    }
	
	public static void main ( String arg[])	{
		Histograma histograma = new Histograma();
        histograma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
