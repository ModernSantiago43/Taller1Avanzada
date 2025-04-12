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

public class VentanaCedula extends JFrame {

    private JTextField txtCedula;
    private JLabel lblPuntos;
    private JButton btnConsultar;
    private JButton btnPagarConPuntos;

    public VentanaCedula() {
        setTitle("Pago con Puntos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblTitulo = new JLabel("Ingrese su número de cédula", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));

        txtCedula = new JTextField();
        lblPuntos = new JLabel("Puntos disponibles: ---", JLabel.CENTER);
        lblPuntos.setFont(new Font("Arial", Font.PLAIN, 14));

        btnConsultar = new JButton("Consultar Puntos");
        btnPagarConPuntos = new JButton("Pagar con Puntos");
        btnPagarConPuntos.setEnabled(false); // Solo se activa tras consultar

        panel.add(lblTitulo);
        panel.add(txtCedula);
        panel.add(lblPuntos);
        panel.add(btnConsultar);
        panel.add(btnPagarConPuntos);

        add(panel);
    }

    public String getCedulaIngresada() {
        return txtCedula.getText().trim();
    }

    public void setPuntosDisponibles(int puntos) {
        lblPuntos.setText("Puntos disponibles: " + puntos);
        btnPagarConPuntos.setEnabled(true);
    }

    public void addConsultarListener(ActionListener listener) {
        btnConsultar.addActionListener(listener);
    }

    public void addPagarConPuntosListener(ActionListener listener) {
        btnPagarConPuntos.addActionListener(listener);
    }
        public JButton getBtnConsultar() {
        return btnConsultar;
    }

    public JButton getBtnPagarConPuntos() {
        return btnPagarConPuntos;
    }
}
