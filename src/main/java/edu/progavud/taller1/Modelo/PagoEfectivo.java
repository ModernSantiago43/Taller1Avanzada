/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */
public class PagoEfectivo extends Pago {

    public PagoEfectivo(String medioDePago, Orden p, Cliente c, int cedula) {
        super(medioDePago, p, c, cedula);
    }

    @Override
    public void pedidoPago() {
        aplicarDescuentos(); // descuentos según el cliente
        estaPago = true;
    }
}

