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
import java.util.List;

class Combo {
    private List<Producto> productos;

    public Combo() {
        productos = new ArrayList<>();
    }

    // Método para agregar un producto al combo
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Método para mostrar los productos del combo con su precio formateado
    public void mostrarCombo() {
        System.out.println("Productos en tu combo:");
        for (Producto producto : productos) {
            System.out.println("Producto: " + producto.getNombre() + ", Tipo: " + producto.getTipo() + ", Precio: " + formatearPrecio(producto.getPrecio()));
        }
    }

    // Método para calcular el precio total del combo
    public double calcularPrecioTotal() {
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio();
        }
        return precioTotal;
    }

    // Método para formatear el precio en pesos colombianos
    public String formatearPrecio(double precio) {
        return "$" + String.format("%,.0f", precio); // Formato de precio en pesos colombianos
    }
}
