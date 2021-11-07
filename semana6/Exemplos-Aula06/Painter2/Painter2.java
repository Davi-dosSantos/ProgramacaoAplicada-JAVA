import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Painter2 extends JFrame
{
	private final Color colorValues[] =
      { Color.BLACK, Color.BLUE, Color.RED,
			Color.GREEN, Color.YELLOW, Color.ORANGE,
			Color.PINK};
	// array listing string colors
    private final String colors[] = { "Black", "Blue",
										"Red", "Green",
										"Yellow","Orange",
										"Pink" };

   private JRadioButton colorItems[]; // RadioBUtton para as cores  
   private ButtonGroup colorButtonGroup; // manages color menu items
   private PaintPanel2 paintPanel,paintPanel2;   // cria o painel de pintura

	
	public static void main( String args[] )
   { 
      // cria o JFrame
      Painter2 application = new Painter2( );
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   } // fim de main
	
   public Painter2 ()
   { 
      super("Painter com cores");
	  
	  // cria um painel para inserir dois componentes
		JPanel painelCentral = new JPanel();
		// muda o Layout para aceitar dois componentes
		painelCentral.setLayout(new GridLayout(1,2));
		
		// aloca os paineis de desenho
      paintPanel = new PaintPanel2(); 
	  paintPanel2 = new PaintPanel2();
	  
	  // adiciona eles no painel central
	  painelCentral.add(paintPanel);
	  painelCentral.add(paintPanel2);
	  
	  //adiciona os paineis de desenho no centro
      add(painelCentral, BorderLayout.CENTER); 
      
      // adiciona um label no sul do borderlayout
      add(new JLabel("Arraste o mouse para desenhar."), 
         BorderLayout.SOUTH);


		//
		// criando uma barra de ferramentas.
		//
		JPanel barraFerramentas = new JPanel();
		// create radiobutton for colors
		colorItems = new JRadioButton[ colors.length ];
		// grupo logico para os botões
		colorButtonGroup = new ButtonGroup(); // manages colors
		// objeto para tratar o evento
		ColorHandler colorHandler = new ColorHandler();
		//
		
		// create color radio buttons
      for ( int count = 0 ; count < colors.length; count++ )
      {
         colorItems[ count ] =                                          
            new JRadioButton( colors[ count ] ); // create item    
         barraFerramentas.add( colorItems[ count ] ); // add item to color menu
         colorButtonGroup.add( colorItems[ count ] ); // add to group   
         colorItems[ count ].addActionListener( colorHandler );
      } // end for

      colorItems[ 0 ].setSelected( true ); // select first Color item	

		// adiciona a barra de ferramentas no norte
		add(barraFerramentas, BorderLayout.NORTH); 
      
      setSize(600, 300); 
      setVisible(true); 
   } 
   
      // inner class to handle action events from menu items
    private class ColorHandler implements ActionListener
    {
       // process color and font selections
       public void actionPerformed( ActionEvent event )
       {
          // process color selection
          for ( int count = 0 ; count < colorItems.length; count++ )
          {
             if ( colorItems[ count ].isSelected() )
             {
			    paintPanel.setCorAtual(colorValues[ count ] );
			    paintPanel2.setCorAtual(colorValues[ count ] );
                break ;
             } // end if
          } // end for

          repaint(); // redraw application
       } // end method actionPerformed
    } // end class ItemHandler
   
} // end class Painter2
