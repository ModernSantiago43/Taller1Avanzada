/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;


/**
 * 
 * @author Santiago
 */

import java.util.ArrayList;

public class Cubeta extends Producto {

    private ArrayList<Producto> piezas = new ArrayList<>();

    public Cubeta(double precio, int cantidad, String nombre, String descripcion, String tipo, double valorPuntos) {
        super(precio, cantidad, nombre, descripcion, valorPuntos, tipo);  // Agregar tipo al constructor
    }

    public Cubeta() {
        super();
        this.piezas = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto.getTipo().equalsIgnoreCase("pollo")) {
            int totalPollo = contarPiezasPollo();
            if (totalPollo + producto.getCantidad() > 10) {
                System.out.println("No se pueden agregar más de 10 piezas de pollo.");
                return;
            }
        }

        this.piezas.add(producto);
        this.setPrecio(this.getPrecio() + producto.getPrecio() * producto.getCantidad());
    }

    private int contarPiezasPollo() {
        int total = 0;
        for (Producto p : piezas) {
            if (p.getTipo().equalsIgnoreCase("pollo")) {
                total += p.getCantidad();
            }
        }
        return total;
    }

    public ArrayList<Producto> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Producto> piezas) {
        this.piezas = piezas;
    }
}
