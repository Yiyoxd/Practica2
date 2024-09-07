package practica2;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.function.BiFunction;

public class Interfaz {
    DecimalFormat formato = new DecimalFormat("#.##");
    private JLabel labelNum1;
    private JLabel labelNum2;
    private JTextField textFieldNum2;
    private JTextField textFieldNum1;
    private JButton sumarButton;
    private JButton restarButton;
    private JButton multiplicarButton;
    private JButton dividirButton;
    private JLabel labelResultado;
    private JPanel panelOperaciones;

    public Interfaz() {
        sumarButton.addActionListener(e -> ejecutarOperacion(Double::sum));
        restarButton.addActionListener(e -> ejecutarOperacion((a, b) -> a - b));
        multiplicarButton.addActionListener(e -> ejecutarOperacion((a, b) -> a * b));
        dividirButton.addActionListener(e -> ejecutarOperacion((a, b) -> a / b));
    }

    public JPanel getPanel() {
        return this.panelOperaciones;
    }

    private void ejecutarOperacion(BiFunction<Double, Double, Double> operacion) {
        try {
            double a = Double.parseDouble(textFieldNum1.getText().trim());
            double b = Double.parseDouble(textFieldNum2.getText().trim());
            double resultado = operacion.apply(a, b);
            mostrar(resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verifique los números", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "No es posible dividir entre 0: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrar(double valor) {
        String resultado = formato.format(valor);
        labelResultado.setText(resultado);
    }
}