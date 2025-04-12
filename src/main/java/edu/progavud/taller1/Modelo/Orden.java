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

public class Orden {

    private String categoriaOrden;
    private ArrayList<Item> listaItems;
    private double puntosAcumulados;
    private double costoFinal;
    private Cubeta cubeta;

    public Orden(String categoriaOrden, ArrayList<Item> listaItems, int puntosAcumulados) {
        this.categoriaOrden = categoriaOrden;
        this.listaItems = listaItems;
        this.puntosAcumulados = puntosAcumulados;
    }

    public Orden() {
        this.listaItems = new ArrayList<>();
    }

    public double calcularCostoTotal() {
        double total = 0;
        for (Item i : this.listaItems) {
            total += i.getPrecio() * i.getCantidad();
        }
        this.costoFinal = total;
        return total;
    }

    public void calcularCostoCubeta() {
        if (cubeta == null) return;
        double total = 0;
        for (Producto pieza : cubeta.getPiezas()) {
            total += pieza.getPrecio() * pieza.getCantidad();
        }
        this.costoFinal = total;
    }

    public double calcularPuntosCubeta() {
        if (cubeta == null) return 0;
        double puntos = 0;
        for (Producto pieza : cubeta.getPiezas()) {
            puntos += pieza.getValorPuntos() * pieza.getCantidad();
        }
        return puntos;
    }

    public double calcularTotalPuntos() {
        double puntos = 0;
        for (Item i : listaItems) {
            puntos += i.getPuntos() * i.getCantidad();
        }
        return puntos;
    }

    // Getters y setters

    public String getCategoriaOrden() {
        return categoriaOrden;
    }

    public void setCategoriaOrden(String categoriaOrden) {
        this.categoriaOrden = categoriaOrden;
    }

    public ArrayList<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(ArrayList<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(double puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(double costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Cubeta getCubeta() {
        return cubeta;
    }

    public void setCubeta(Cubeta cubeta) {
        this.cubeta = cubeta;
    }
}
