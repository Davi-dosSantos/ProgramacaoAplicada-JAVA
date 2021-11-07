import static java.lang.Math.pow;

public class Polinomio {
    public double[] polinome;

    public Polinomio(int n) {
        polinome = new double[n];
    }

    public Polinomio(double[] n) {
        polinome = new double[n.length];
        for (int i = 0; i < polinome.length; i++)
            polinome[i] = n[n.length - 1 - i];
    }

    public Polinomio Derivate() {
        Polinomio d = new Polinomio(this.polinome.length - 1);
        for (int i = 0; i < d.polinome.length; i++)
            d.polinome[i] = polinome[i + 1] * (i + 1);
        return d;
    }

    public double valueAt(double x) {
        double total = 0;
        for (int i = 0; i < polinome.length; i++)
            total += polinome[i] * pow(x, i);
        return total;
    }

    public double root(double x) {
        double raiz = 0;
        double pertoDeZero = .00000000000001;
        for (int i = 0; i < 500; i++) {
            raiz = x - this.valueAt(x) / this.Derivate().valueAt(x);
            if (Math.abs(raiz - x) < pertoDeZero)
                break;
            x = raiz;
        }
        return raiz;
    }
}// end class
