/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Vista;

/**
 *
 * @author Santiago
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame {
    private JButton comerAquiBtn;
    private JButton paraLlevarBtn;

    public VentanaInicio() {
        setTitle("Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel bienvenida = new JLabel("BIENVENIDO", JLabel.CENTER);
        bienvenida.setFont(new Font("Arial", Font.BOLD, 24));

        comerAquiBtn = new JButton("Comer aquí");
        paraLlevarBtn = new JButton("Para llevar");

        comerAquiBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "En proceso"));

        JPanel botones = new JPanel();
        botones.setLayout(new GridLayout(2, 1, 10, 10));
        botones.add(comerAquiBtn);
        botones.add(paraLlevarBtn);

        add(bienvenida, BorderLayout.NORTH);
        add(botones, BorderLayout.CENTER);
    }

    // Para que el controlador pueda conectar su lógica
    public void addParaLlevarListener(ActionListener listener) {
        paraLlevarBtn.addActionListener(listener);
    }

    // Método para mostrar esta ventana desde el controlador
    public void mostrar() {
        setVisible(true);
    }

    // Método para ocultarla si es necesario
    public void ocultar() {
        setVisible(false);
    }
}