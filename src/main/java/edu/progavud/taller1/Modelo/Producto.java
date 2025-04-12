/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */
public class Producto {
    
    protected double precio;
    protected String nombre;
    protected String descripcion;
    protected int cantidad;
    protected double valorPuntos;
    protected String tipo;

    public Producto(double precio, int cantidad, String nombre, String descripcion, double valorPuntos, String tipo) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valorPuntos = valorPuntos;
        this.tipo = tipo;
    }

    public Producto() {
        this.precio = 0.0;
        this.cantidad = 0;
        this.nombre = "";
        this.descripcion = "";
        this.valorPuntos = 0.0;
        this.tipo = "";
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValorPuntos() {
        return valorPuntos;
    }

    public void setValorPuntos(double valorPuntos) {
        this.valorPuntos = valorPuntos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void calcularValorPuntos() {
        this.valorPuntos = (this.precio * this.cantidad) / 1000;
    }
    public double getPuntos() {
    return this.valorPuntos;
}

}