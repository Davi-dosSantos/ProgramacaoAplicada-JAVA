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
public class Lab1EX2 {

// main method begins execution of Java application
public static void main( String args[] )
{ // create Scanner to obtain input from command window 
Scanner input = new Scanner( System.in );
int numNumsPrimos = 0, n = 1;

    while(numNumsPrimos < 20){
        int primo = n;
		boolean isPrimo = true;
		int divisor = 0;
		for (int i = 2; i <= primo; i++) {
			if ( ( (primo % i) == 0) && (i != primo) ) {
				isPrimo = false;
				divisor = i;
				break;
			}
		}
		if (isPrimo) {
			System.out.println(  primo + "\n" );
                        n++;
                        numNumsPrimos++;
		} else {
			n++;
		}

	}
}
}
