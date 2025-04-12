/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Modelo;

/**
 *
 * @author Santiago
 */
public class Cliente {
    private double puntos;
    private int cedula;
    private boolean Adulto;
    private boolean Indigena;

    public Cliente(double puntos, int cedula, boolean Adulto, boolean Indigena) {
        this.puntos = puntos;
        this.cedula = cedula;
        this.Adulto = Adulto;
        this.Indigena = Indigena;
    }

    public Cliente() {
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public boolean isAdulto() {
        return Adulto;
    }

    public void setAdulto(boolean adulto) {
        this.Adulto = adulto;
    }

    public boolean isIndigena() {
        return Indigena;
    }

    public void setIndigena(boolean indigena) {
        this.Indigena = indigena;
    }
}