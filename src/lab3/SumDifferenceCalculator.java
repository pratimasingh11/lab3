package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SumDifferenceCalculator extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JLabel resultLabel;

    public SumDifferenceCalculator() {
        setTitle("Sum and Difference Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel number1Label = new JLabel("Number 1:");
        JLabel number2Label = new JLabel("Number 2:");
        resultLabel = new JLabel("Result:");

        number1Field = new JTextField();
        number2Field = new JTextField();

        add(number1Label);
        add(number1Field);
        add(number2Label);
        add(number2Field);
        add(resultLabel);

        number1Field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        });

        number2Field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        });

        setVisible(true);
    }

    private void calculateSum() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double sum = num1 + num2;
            resultLabel.setText("Sum: " + sum);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    private void calculateDifference() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());
            double difference = num1 - num2;
            resultLabel.setText("Difference: " + difference);
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SumDifferenceCalculator());
    }
}

