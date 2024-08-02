package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 5, 5));

        JLabel celsiusLabel = new JLabel("Celsius:");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");

        celsiusField = new JTextField();
        fahrenheitField = new JTextField();
        fahrenheitField.setEditable(false);

        add(celsiusLabel);
        add(celsiusField);
        add(fahrenheitLabel);
        add(fahrenheitField);

        celsiusField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                convertTemperature();
            }
        });

        setVisible(true);
    }

    private void convertTemperature() {
        try {
            double celsius = Double.parseDouble(celsiusField.getText());
            double fahrenheit = celsius * 9 / 5 + 32;
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            fahrenheitField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConverter());
    }
}

