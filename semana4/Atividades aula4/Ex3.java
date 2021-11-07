// (Lista de argumento de comprimento variável) Escreva um aplicativo que calcula o produto
//         de uma série de inteiros que são passados para método product utilizando uma lista de
//         argumentos de comprimento variável. Teste seu método com várias chamadas, cada uma com
//         um número diferente de argumentos.

import java.util.ArrayList;

public class Ex3 {

    public static void product(ArrayList<Integer>items){
        int total = 0;
        for ( int i = 0; i < items.size(); i++ )
            total += items.get( i );
        System.out.printf("%d", total);
        
    }

    public static void main(String[] args) {
        // create a new ArrayList of Strings with an initial capacity of 10
      ArrayList< Integer > items = new ArrayList< Integer >(); 
        boolean stopLoop = false; 
        while(!stopLoop){

            System.out.print( 
                "Deseja parar de add numeros a serie ?(1:sim  'qualquer outra coisa':não):" );
              
        }

      // header
      System.out.print( 
         "Display list contents with counter-controlled loop:" ); 

      // display the colors in the list
      for ( int i = 0; i < items.size(); i++ )
         System.out.printf( " %s", items.get( i ) );

     
      // check if a value is in the List
      System.out.printf( "\"red\" is %sin the list\n",
         items.contains( "red" ) ? "": "not " );

      // display number of elements in the List
      System.out.printf( "Size: %s\n", items.size() );
   } // end main

    // display the ArrayList's elements on the console
    public static void display(ArrayList<String> items, String header) {
        System.out.print(header); // display header

        // display each element in items
        for (String item : items)
            System.out.printf(" %s", item);

        System.out.println(); // display end of line
    } // end method display
} // end class ArrayListCollection

}

} // end class InitArray