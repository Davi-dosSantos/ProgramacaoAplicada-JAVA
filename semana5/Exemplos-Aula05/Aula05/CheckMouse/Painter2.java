import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Painter2 extends JFrame
{
   private final Color colorValues[] =
      { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.PINK};
   private JRadioButtonMenuItem colorItems[]; // color menu items  
   private ButtonGroup colorButtonGroup; // manages color menu items
   private PaintPanel2 paintPanel,paintPanel2;   // cria o painel de pintura
 
	public Painter2()
	{
		super("Teste de Painter Melhorado");
		
		JPanel painelCentral = new JPanel();
		painelCentral.setLayout(new GridLayout(1,2));
		
		paintPanel = new PaintPanel2(); // cria o painel de pintura
		paintPanel2 = new PaintPanel2(); // cria o painel de pintura
		painelCentral.add(paintPanel2);
		painelCentral.add(paintPanel);
		//painelCentral.add(paintPanel2);
		
        add( painelCentral, BorderLayout.CENTER ); // no centro

        // cria um rótulo e o coloca em SOUTH do BorderLayout
        add( new JLabel( "Drag the mouse to draw" ), 
         BorderLayout.SOUTH );
		
		////////////////////////////////
		 // array listing string colors
      String colors[] = { "Black", "Blue", "Red", "Green", "Yellow","Orange","Pink" };

      JMenu colorMenu = new JMenu( "Color" ); // create color menu
      colorMenu.setMnemonic( 'C' ); // set mnemonic to C          

      // create radiobutton menu items for colors
      colorItems = new JRadioButtonMenuItem[ colors.length ];
      colorButtonGroup = new ButtonGroup(); // manages colors
      ColorHandler colorHandler = new ColorHandler(); // handler for colors

      // create color radio button menu items
      for ( int count = 0 ; count < colors.length; count++ )
      {
         colorItems[ count ] =                                          
            new JRadioButtonMenuItem( colors[ count ] ); // create item    
         colorMenu.add( colorItems[ count ] ); // add item to color menu
         colorButtonGroup.add( colorItems[ count ] ); // add to group   
         colorItems[ count ].addActionListener( colorHandler );
      } // end for

      colorItems[ 0 ].setSelected( true ); // select first Color item
		
		//criando a barra de menu
		JMenuBar barra = new JMenuBar();
		setJMenuBar(barra);
		barra.add(colorMenu);
		
		
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
				
                //displayJLabel.setForeground( colorValues[ count ] );
                break ;
             } // end if
          } // end for

          repaint(); // redraw application
       } // end method actionPerformed
    } // end class ItemHandler
	
   public static void main( String args[] )
   { 
      // cria o JFrame
      Painter2 application = new Painter2( );
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      application.setSize( 400, 300 ); // configura o tamanho do frame
      application.setVisible( true ); // exibe o frame
   } // fim de main
} // fim da classe Painter