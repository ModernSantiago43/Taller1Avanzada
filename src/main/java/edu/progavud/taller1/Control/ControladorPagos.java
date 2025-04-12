/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Control;

/**
 *
 * @author Santiago
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.progavud.taller1.Vista.VentanaMenu;
import edu.progavud.taller1.Control.ControladorFactura; // Asegúrate de importar ControladorFactura

public class ControladorPagos {
    private VentanaMenu vista;
    private ControladorFactura controladorFactura;  // Añadir el controladorFactura

    public ControladorPagos(VentanaMenu vista, ControladorFactura controladorFactura) {
        this.vista = vista;
        this.controladorFactura = controladorFactura;

        vista.getBotonEfectivo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPago("Efectivo");
            }
        });

        vista.getBotonTarjeta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPago("Tarjeta");
            }
        });

        vista.getBotonPuntos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarPago("Puntos");
            }
        });
    }

    private void procesarPago(String metodo) {
        String mensaje = "Pago realizado con " + metodo;
        vista.setEstadoPago(mensaje);
        vista.setFactura("Total pagado con: " + metodo + "\n¡Gracias por su compra!");
    }
}
