/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Control;
 
 /**
  *
  * @author Santiago
  */


import edu.progavud.taller1.Vista.VentanaFactura;
import javax.swing.JOptionPane;

public class ControladorFactura {
    private VentanaFactura vista;
    private double total;

    public ControladorFactura(VentanaFactura vista) {
        this.vista = vista;
        this.total = 0.0;

        // Añadir el listener al botón de pagar
        this.vista.addPagarListener(e -> procesarPago());
    }

    public void agregarItemAFactura(String item, double precio) {
        total += precio;  // Actualizar el total
        String linea = item + " - $" + String.format("%.2f", precio);
        vista.mostrarFactura(linea);  // Mostrar la línea en la factura
        vista.mostrarFactura("\nTotal: $" + String.format("%.2f", total));  // Actualizar el total
    }

    public void limpiarFactura() {
        total = 0.0;
        vista.mostrarFactura("Factura vacía.");
    }

    public double obtenerTotal() {
        return total;
    }

    private void procesarPago() {
        String cedula = vista.getCedula();
        String mayorEdad = vista.getMayorEdad();
        String indigena = vista.getIndigena();

        if (validarDatos(cedula, mayorEdad, indigena)) {
            JOptionPane.showMessageDialog(vista, "Pago procesado correctamente.");
            vista.dispose();  // Cerrar la ventana de la factura
        } else {
            JOptionPane.showMessageDialog(vista, "Por favor ingrese datos válidos.");
        }
    }

    private boolean validarDatos(String cedula, String mayorEdad, String indigena) {
        if (cedula.isEmpty() || mayorEdad.isEmpty() || indigena.isEmpty()) {
            return false;
        }

        if (!mayorEdad.equalsIgnoreCase("sí") && !mayorEdad.equalsIgnoreCase("no")) {
            return false;
        }

        if (!indigena.equalsIgnoreCase("sí") && !indigena.equalsIgnoreCase("no")) {
            return false;
        }

        return true;
    }
}
