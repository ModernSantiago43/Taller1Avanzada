/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Control;

/**
 *
 * @author Santiago
 */
import edu.progavud.taller1.Vista.VentanaInicio;
import edu.progavud.taller1.Vista.VentanaMenu;
import edu.progavud.taller1.Control.ControladorCategorias;
import edu.progavud.taller1.Control.ControladorFactura;
import edu.progavud.taller1.Control.ControladorPagos;

public class ControladorPrincipal {
    private VentanaInicio ventanaInicio;  // Cambié "Vista" a "ventanaInicio" para mayor claridad
    private VentanaMenu ventanaMenu;      // Cambié "vista" a "ventanaMenu"
    private ControladorCategorias controladorCategorias;
    private ControladorFactura controladorFactura;
    private ControladorPagos controladorPagos;

    public ControladorPrincipal() {
        // Inicializamos las vistas
        ventanaInicio = new VentanaInicio();
        ventanaMenu = new VentanaMenu();
        
        // Inicializamos los controladores
        controladorCategorias = new ControladorCategorias(ventanaMenu);
        controladorFactura = new ControladorFactura(ventanaMenu);
        controladorPagos = new ControladorPagos(ventanaMenu, controladorFactura);

        // Agregar el listener al botón "Para llevar"
        ventanaInicio.addParaLlevarListener(e -> {
            // Ocultar la ventana de inicio
            ventanaInicio.ocultar();

            // Mostrar la ventana de menú
            ventanaMenu.mostrarCategorias();  // Esto muestra las categorías del menú
            ventanaMenu.setVisible(true);     // Asegúrate de que la ventana de menú sea visible
        });

        // Mostramos la ventana de inicio
        ventanaInicio.setVisible(true);
    }

    public static void main(String[] args) {
        // Creamos el controlador principal que manejará todo el flujo
        new ControladorPrincipal();
    }
}
