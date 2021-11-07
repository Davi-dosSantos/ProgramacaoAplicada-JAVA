import java.awt.*;
import java.util.*;
import javax.swing.*;

public class drawHistograma extends JPanel {
    
    private final ArrayList<Integer> dados = new ArrayList<Integer>();
    private final ArrayList<Integer> freq = new ArrayList<Integer>();
    
    public Dimension getPreferredSize(){
        return new Dimension(700,530);
    }
        
    public void setDados(ArrayList<Integer> a){
        //limpar vetores internos
		dados.clear();
        freq.clear();
		//criar vet temporario para manipulações
        int[] copia = new int[a.size()];
        for(int i = 0; i < a.size(); i++){
            copia[i] = a.get(i);
        }
		//ordenar dados
        Arrays.sort(copia);
        //encontrar frequencia e preencher dados
		int cont;
        for(int i = 0; i < a.size(); i++){
            cont = 1;
            for(int j = a.size() - 1; j >= 0; j--)
               if(copia[i] == copia[j] && i != j)
                    cont++;
            if(!dados.contains(copia[i])){
                dados.add(copia[i]);
                freq.add(cont);
            }
        }
        repaint();
    }
    
     public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        
        g.setFont(new Font("Serif", Font.BOLD, 14));
        Random random = new Random();
        
        g.drawLine(25, 25, 25, 500);
        g.drawString("Frequência", 30, 20);
        g.drawLine(25, 480, 600, 480);
        g.drawString("Soma", 610, 482);
        
		//encontrar maior valor para fazer a escala.
        int aux = 0;
        for(int i = 0; i < freq.size(); i++)
            if(freq.get(i) > aux)
				aux = freq.get(i);
		
		aux++;
		
        for(int i = 0; i < dados.size(); i++){
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            g.fillRect(35 + 40*i, 480 - (455/aux)*freq.get(i), 40,(455/aux)*freq.get(i));
            g.setColor(Color.BLACK);
            g.drawLine(20, (480 - 455/aux*freq.get(i)), 30, (480 - 455/aux*freq.get(i)));
            g.drawLine(55 + 40*i, 475, 55 + 40*i, 485);
            g.drawString(""+ dados.get(i), 55+40*i, 500);
            g.drawString(""+ freq.get(i), 10, (480 - 455/aux*freq.get(i)));
        }   
     }
}
