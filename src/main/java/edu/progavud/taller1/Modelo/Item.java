/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */

public class Item extends Producto {

    public Item(String nombre, int cantidad, double precio, double valorPuntos) {
        super(precio, cantidad, nombre, "", valorPuntos, "");
    }

    public Item() {
        super();
    }
}

