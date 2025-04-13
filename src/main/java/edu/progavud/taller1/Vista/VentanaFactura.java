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

public class VentanaFactura extends JFrame {
    private JTextArea areaFactura;
    private JButton botonPagar;
    private JTextField cedulaField, mayorEdadField, indigenaField;

    public VentanaFactura() {
        setTitle("Factura");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Área de la factura
        areaFactura = new JTextArea();
        areaFactura.setEditable(false);
        JScrollPane scrollFactura = new JScrollPane(areaFactura);

        // Panel para los datos de pago
        JPanel panelPago = new JPanel(new GridLayout(4, 2));
        JLabel labelCedula = new JLabel("Cédula:");
        cedulaField = new JTextField();

        JLabel labelMayorEdad = new JLabel("¿Es mayor de edad? (sí/no):");
        mayorEdadField = new JTextField();

        JLabel labelIndigena = new JLabel("¿Es indígena? (sí/no):");
        indigenaField = new JTextField();

        botonPagar = new JButton("Pagar");

        panelPago.add(labelCedula);
        panelPago.add(cedulaField);
        panelPago.add(labelMayorEdad);
        panelPago.add(mayorEdadField);
        panelPago.add(labelIndigena);
        panelPago.add(indigenaField);
        panelPago.add(botonPagar);

        add(scrollFactura, BorderLayout.CENTER);
        add(panelPago, BorderLayout.SOUTH);
    }

    public void mostrarFactura(String factura) {
        areaFactura.setText(factura);
    }

    public String getCedula() {
        return cedulaField.getText();
    }

    public String getMayorEdad() {
        return mayorEdadField.getText();
    }

    public String getIndigena() {
        return indigenaField.getText();
    }

    public void addPagarListener(ActionListener listener) {
        botonPagar.addActionListener(listener);
    }
}
