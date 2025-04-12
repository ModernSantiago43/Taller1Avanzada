/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */
public class PagoPuntos extends Pago {

    public PagoPuntos(String medioDePago, Orden p, Cliente c, int cedula) {
        super(medioDePago, p, c, cedula);
    }

    @Override
    public void pedidoPago() {
        double total = aplicarDescuentos(); // aún aplica descuentos
        int puntosCliente = (int) c.getPuntos(); // redondeo si es double

        if (puntosCliente >= total) {
            c.setPuntos(puntosCliente - (int) total); // descuenta puntos
            precioConDto = 0;
            estaPago = true;
        } else {
            estaPago = false; // no alcanza
            precioConDto = total; // conserva el precio
        }
    }
}
