import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DesenhaFormas extends JPanel 
{
	private JRadioButton btnFormas[]; // color menu items  
	private ButtonGroup formasButtonGroup; // manages color menu items
	private JPanel painel;
	String strFormas[]={"Quadrado","Triangulo","Oval","Outra"};
	Point ponto = new Point();
	int forma = 0;


	public DesenhaFormas(){
		btnFormas = new JRadioButton[ strFormas.length ];
		formasButtonGroup = new ButtonGroup(); // manages colors
		FormasHandler formaHandler = new FormasHandler(); // handler for colors
		painel =  new JPanel();
		
		
		for ( int count = 0 ; count < strFormas.length; count++ )
		{
			 btnFormas[ count ] =                                          
				new JRadioButton( strFormas[ count ] ); // create item    
			 painel.add( btnFormas[ count ] ); // add item to color menu
			 formasButtonGroup.add( btnFormas[ count ] ); // add to group   
			 btnFormas[ count ].addActionListener( formaHandler );
		} // end for
		  
		  btnFormas[ 0 ].setSelected( true ) ;
		  
		add(painel);
		  
		  // registrando evento do mouse
		  
		 /* addMouseListener(new MouseListener() { 
				public void mouseClicked(MouseEvent e) { repaint(); } 
				public void mousePressed(MouseEvent e) {} 
				public void mouseReleased(MouseEvent e) {} 
				public void mouseEntered(MouseEvent e) {} 
				public void mouseExited(MouseEvent e) {} 
			} 
			);*/			//class Completa extends MouseAdapter{}
		addMouseListener( new MouseAdapter() {
			public void metodo() {};
			public void mouseClicked(MouseEvent e) { 
				ponto =  e.getPoint();
				repaint(); } 
			} 
			);
	}
		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		switch (forma)
        {
			case 0:		
            g.drawRect(ponto.x,ponto.y, 100,100);
			break;
			case 1:
			break;
			case 2:
			g.drawOval(ponto.x,ponto.y, 100,100);
			break;
		
		}
	}
	
class FormasHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e){
		for ( int count = 0 ; count < btnFormas.length; count++ )
        {
             if ( btnFormas[ count ].isSelected() )
			{
				forma = count;
				break;
			}
		}
		repaint();
	}
	
}

 public static void main( String args[] )
   { 
      // cria o JFrame
      JFrame application = new JFrame("Desenha Formas" );
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setSize( 400, 300 ); // configura o tamanho do frame
	  application.setLayout(new GridLayout(1,2));
	  application.add(new DesenhaFormas());
	  application.add(new DesenhaFormas());
	 
      application.setVisible( true ); // exibe o frame
   } // fim de main
}