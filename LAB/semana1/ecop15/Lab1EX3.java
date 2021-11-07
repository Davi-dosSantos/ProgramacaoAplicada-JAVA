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
public class Lab1EX3 {

// main method begins execution of Java application
public static void main( String args[] )
{ // create Scanner to obtain input from command window 
Scanner input = new Scanner( System.in );
int numero; // first number to add 
int result=1;

System.out.print( "Entre com o numero: " ); // prompt
numero = input.nextInt(); // read first number from user 

for(int i = numero; i>0; i--){
   result = result*i; 
}
    System.out.printf( "Reultado do fatorial de "+ numero +" = " + result + "\n");





    
}
}
