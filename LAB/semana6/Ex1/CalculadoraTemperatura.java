import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class CalculadoraTemperatura extends JPanel {

    private JRadioButton CelsiusIn;
    private JRadioButton CelsiusOut;
    private JRadioButton FahrenheitIn;
    private JRadioButton FahrenheitOut;
    private JRadioButton KelvinIn;
    private JRadioButton KelvinOut;

    private String typeTemperatureText[] = { "Celsius", "Kelvin", "Fahrenheit" };

    private JTextField textField;

    public double CelsiusToKelvin(double value) {
        return value + 273;
    }

    public double CelsiusToFahrenheit(double value) {
        return (1.8 * value + 32);
    }

    public double KelvinToCelsius(double value) {
        return value - 273;
    }

    public double KelvinToFahrenheit(double value) {
        return CelsiusToFahrenheit(value - 273);
    }

    public double FahrenheitToCelsius(double value) {
        return (value - 32) / 1.8;
    }

    public double FahrenheitToKelvin(double value) {
        return CelsiusToKelvin(FahrenheitToCelsius(value));
    }

    public CalculadoraTemperatura() {
        setLayout(new BorderLayout());

        add(new JTextField(), BorderLayout.NORTH); // adicionar o display
    } // end Calculadora constructor

    public static void main(String args[]) {
        JFrame janela;
        janela = new JFrame("calculadora temperaturas");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.add(new CalculadoraTemperatura());
        janela.setSize(400, 230);
        janela.setVisible(true);
    } // end main
} // end class Calculadora