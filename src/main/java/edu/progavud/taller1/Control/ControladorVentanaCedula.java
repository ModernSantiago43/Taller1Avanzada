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
import javax.swing.JOptionPane;
import edu.progavud.taller1.Vista.VentanaMenu;
import edu.progavud.taller1.Vista.VentanaCedula;

public class ControladorVentanaCedula {

    private VentanaCedula ventanaCedula;
    private VentanaMenu vistaMenu;

    public ControladorVentanaCedula(VentanaCedula ventanaCedula, VentanaMenu vistaMenu) {
        this.ventanaCedula = ventanaCedula;
        this.vistaMenu = vistaMenu;

        this.ventanaCedula.setVisible(true);
        this.ventanaCedula.getBtnConsultar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarPuntos();
            }
        });

        this.ventanaCedula.getBtnPagarConPuntos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarConPuntos();
            }
        });
    }

    private void consultarPuntos() {
        String cedula = ventanaCedula.getCedulaIngresada();
        if (cedula.isEmpty() || !cedula.matches("\\d+")) {
            JOptionPane.showMessageDialog(ventanaCedula, "Por favor, ingrese una cédula válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simulación de puntos
        int puntos = (int) (Math.random() * 1000);
        ventanaCedula.setPuntosDisponibles(puntos);
    }

    private void pagarConPuntos() {
        JOptionPane.showMessageDialog(ventanaCedula, "Pago realizado con puntos correctamente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
        vistaMenu.setEstadoPago("Pagado con puntos");
        vistaMenu.setFactura("Factura pagada con puntos. ¡Gracias por su compra!");
        ventanaCedula.dispose(); // cerrar la ventana después del pago
    }
}
