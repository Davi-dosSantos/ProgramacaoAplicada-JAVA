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
import java.lang.Math;

public class Lab1EX6 {

// main method begins execution of Java application
public static void main( String args[] )
{ // create Scanner to obtain input from command window 
Scanner input = new Scanner( System.in );

System.out.print( "Entre com a palavra que deseja verificar: " ); // prompt
String normal = input.nextLine();
String invertida = new StringBuffer(normal).reverse().toString(); 
if(normal.equals(invertida)){ 
    System.out.print( "É palindrome\n" );
}else{ 
    System.out.print( "não é palindrome\n" );
}
}
}
