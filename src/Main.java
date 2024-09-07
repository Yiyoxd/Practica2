import practica2.Interfaz;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora");
            frame.setSize(580, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Interfaz interfaz = new Interfaz();
            frame.setContentPane(interfaz.getPanel());
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.pack();
        });
    }
}