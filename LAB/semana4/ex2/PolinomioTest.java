
import java.util.Scanner;
import java.util.StringTokenizer;


public class PolinomioTest {

    public static void main(String[] args) {
        String polinomio;
        Scanner input = new Scanner(System.in);
         
        System.out.print("Entre com os coeficientes do polinomio separados "
                       + "espaço em ordem decrescente de grau: ");
         
        polinomio = input.nextLine();
         
        StringTokenizer strT;
        strT = new StringTokenizer( polinomio );
         
        double[] coef = new double[ strT.countTokens() ];
        int i = 0;
        while(strT.hasMoreTokens())
        {
            coef[i] = Double.valueOf(strT.nextToken());
            i++;
        }
         
        Polinomio p = new Polinomio( coef );
         
        System.out.print("\nUma das raízes é : " + p.root(1000));
        
    }
    
}
