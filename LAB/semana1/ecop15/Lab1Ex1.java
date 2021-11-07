/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1.ecop15;

/**
 *
 * @author davii
 */
import java.util.Scanner; // program uses class Scanner
public class Lab1Ex1 {

// main method begins execution of Java application
public static void main( String args[] )
{ // create Scanner to obtain input from command window 
Scanner input = new Scanner( System.in );
int altura; // first number to add 
int largura; // second number to add 
int preenchido;

char caracter;
char caracterBorda;

System.out.print( "Entre com a largura: " ); // prompt
largura = input.nextInt(); // read first number from user 
System.out.print( "Entre com a altura: " ); // prompt 
altura = input.nextInt(); // read second number from user 
System.out.print( "Entre o caractere de preenchimento: " ); // prompt 
caracter = input.next().charAt(0);
System.out.print( "Entre o caractere de da borda: " ); // prompt 
caracterBorda = input.next().charAt(0);
System.out.print( "O retangulo sera preenchido?:(1 = sim,  2 = não) " ); // prompt 
preenchido = input.nextInt();
if(preenchido == 1){
    for(int i = 0; i < altura; i++){
    for(int j = 0; j < largura; j++){
        if(i == 0 || i == (altura-1) || j == 0 || j == (largura-1)){
            System.out.printf( ""+ caracterBorda );
        }else{
            System.out.printf( ""+ caracter );
        }   
    }
    System.out.printf( "\n" );
}
}else if(preenchido == 2){
    for(int i = 0; i < altura; i++){
    for(int j = 0; j < largura; j++){
        if(i == 0 || i == (altura-1)){
            System.out.printf( ""+ caracterBorda );
        }else{
            System.out.printf( " " );
        }
    }
    System.out.printf( "\n" );
}
}else{
    System.out.printf( "Opição de preenchimento invalida" );
}




    
}
}
