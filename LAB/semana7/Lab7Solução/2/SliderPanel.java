
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderPanel extends JPanel {
	private JTextField texto;
	private JSlider slider;

	private int minValue = 0;
	private int maxValue = 255;

	public SliderPanel() {
		texto = new JTextField(5);

		// set up JSlider to control diameter value
		slider = new JSlider(SwingConstants.HORIZONTAL, minValue, maxValue, 10);
		slider.setMajorTickSpacing(50); // create tick every 10
		slider.setPaintTicks(true); // paint ticks on slider

		// register JSlider event listener
		slider.addChangeListener(new ChangeListener() // anonymous inner class
		{
			// handle change in slider value
			@Override
			public void stateChanged(ChangeEvent e) {
				texto.setText("" + slider.getValue());
				repaint();
			}
		});
		texto.setText("" + slider.getValue());
		texto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int valor = Integer.parseInt(texto.getText());
				slider.setValue(valor);
			}
		});

		add(slider);
		add(new JLabel("valor selecionado"));
		add(texto);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.fillOval(10, 10, diameter, diameter);
	}

	// validate and set minValue, then repaint
	public void setMinValue(int newValue) {
		// if diameter invalid, default to 10
		minValue = (newValue >= 0 ? newValue : 10);
		if (minValue > maxValue)
			maxValue = minValue + 1;
		repaint(); // repaint panel
	}

	// validate and set minValue, then repaint
	public void setMaxValue(int newValue) {
		// if diameter invalid, default to 10
		maxValue = (newValue > minValue ? newValue : minValue + 1);
		repaint(); // repaint panel
	}

	// used by layout manager to determine preferred size
	public Dimension getPreferredSize() {
		return new Dimension(400, 150);
	}

	// used by layout manager to determine minimum size
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	public int getValue() {
		return slider.getValue();
	}
} // end class SliderPanel
