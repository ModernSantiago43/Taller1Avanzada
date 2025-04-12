/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */

public abstract class Pago {

    protected String medioDePago;
    protected boolean estaPago = false;
    protected double precioConDto;
    protected Orden p;
    protected Cliente c;
    protected int cedula;

    public Pago(String medioDePago, Orden p, Cliente c, int cedula) {
        this.medioDePago = medioDePago;
        this.p = p;
        this.c = c;
        this.cedula = cedula;
    }

    public Pago() {}

    // Métodos específicos que ya tenías
    public double aplicarDescuentoIndigena() {
        precioConDto = p.calcularCostoTotal() * 0.90;
        return precioConDto;
    }

    public double aplicarDescuentoMayorDeEdad() {
        precioConDto = p.calcularCostoTotal() * 0.90;
        return precioConDto;
    }

    public double aplicarDescuentoDoble() {
        precioConDto = p.calcularCostoTotal() * 0.80;
        return precioConDto;
    }

    // ✅ Método nuevo para decidir qué descuento aplicar
    protected double aplicarDescuentos() {
        double total = p.calcularCostoTotal();

        if (c.isAdulto() && c.isIndigena()) {
            precioConDto = total * 0.80; // 20% de descuento
        } else if (c.isAdulto() || c.isIndigena()) {
            precioConDto = total * 0.90; // 10% de descuento
        } else {
            precioConDto = total;
        }

        return precioConDto;
    }

    public void asignarPuntos(int cedula) {
        c.setPuntos(p.calcularTotalPuntos());
    }

    public boolean isEstaPago() {
        return estaPago;
    }

    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }

    public double getPrecioConDto() {
        return precioConDto;
    }

    public void setPrecioConDto(double precioConDto) {
        this.precioConDto = precioConDto;
    }

    public Cliente getCliente() {
        return c;
    }

    public Orden getOrden() {
        return p;
    }

    public abstract void pedidoPago();
}
