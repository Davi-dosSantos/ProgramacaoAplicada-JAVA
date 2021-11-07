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

public class Lab1EX4 {

// main method begins execution of Java application
public static void main( String args[] )
{ // create Scanner to obtain input from command window 
Scanner input = new Scanner( System.in );
double distancia, velocidade, angulo, anguloRad; 


System.out.print( "Entre com o angulo em graus(graus): " ); // prompt
angulo = input.nextFloat(); // read first number from user
System.out.print( "Entre com o velocidade(m/s): " ); // prompt
velocidade = input.nextFloat();
anguloRad = ((Math.PI/180.0)*angulo);

distancia = ((velocidade*velocidade)*Math.sin(2.0*anguloRad))/9.8;

System.out.printf( "Distancia: "+ distancia + "m\n");





    
}
}
