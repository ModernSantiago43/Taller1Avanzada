/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Control;

/**
 *
 * @author Santiago
 */
import edu.progavud.taller1.Vista.VentanaMenu;

public class ControladorFactura {
    private VentanaMenu vista;
    private double total;

    public ControladorFactura(VentanaMenu vista) {
        this.vista = vista;
        this.total = 0.0;  // Inicializamos el total a 0
    }

    public void agregarItemAFactura(String item, double precio) {
        total += precio;  // Sumar el precio al total
        String linea = item + " - $" + String.format("%.2f", precio);
        vista.mostrarFactura(linea);  // Mostrar la línea del producto
        vista.actualizarTotal(total);  // Actualizar el total en la vista
    }

    public void limpiarFactura() {
        total = 0.0;  // Reseteamos el total
        vista.mostrarFactura("Factura vacía.");
        vista.actualizarTotal(total);  // Actualizar el total en la vista
    }

    public double obtenerTotal() {
        return total;
    }
    
}
