package com.juliacocati;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VerificadorPrimoGUI extends JFrame {

    private JTextField campoNumero;
    private JLabel resultadoLabel;

    public VerificadorPrimoGUI() {
        setTitle("Verificador de Número Primo");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Digite um número:");
        campoNumero = new JTextField(10);
        JButton botaoVerificar = new JButton("Verificar");
        resultadoLabel = new JLabel("");

        botaoVerificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verificarPrimo();
            }
        });

        add(label);
        add(campoNumero);
        add(botaoVerificar);
        add(resultadoLabel);
    }

    private void verificarPrimo() {
        String texto = campoNumero.getText();
        try {
            int numero = Integer.parseInt(texto);
            if (numero < 2) {
                resultadoLabel.setText(numero + " não é primo.");
                return;
            }

            boolean primo = true;
            for (int i = 2; i <= Math.sqrt(numero); i++) {
                if (numero % i == 0) {
                    primo = false;
                    break;
                }
            }

            if (primo) {
                resultadoLabel.setText(numero + " é primo!");
            } else {
                resultadoLabel.setText(numero + " não é primo.");
            }
        } catch (NumberFormatException ex) {
            resultadoLabel.setText("Por favor, digite um número válido.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VerificadorPrimoGUI().setVisible(true);
        });
    }
}
