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
import edu.progavud.taller1.Vista.VentanaFactura;

public class ControladorPrincipal {
    private VentanaInicio ventanaInicio;
    private VentanaMenu ventanaMenu;
    private VentanaFactura ventanaFactura;
    private ControladorCategorias controladorCategorias;
    private ControladorFactura controladorFactura;
    private ControladorPagos controladorPagos;

    public ControladorPrincipal() {
        // Inicializamos las vistas
        ventanaInicio = new VentanaInicio();
        ventanaMenu = new VentanaMenu();
        ventanaFactura = new VentanaFactura();

        // Inicializamos los controladores
        controladorCategorias = new ControladorCategorias(ventanaMenu);
        controladorFactura = new ControladorFactura(ventanaFactura);
        controladorPagos = new ControladorPagos(ventanaMenu, controladorFactura);

        ventanaInicio.addParaLlevarListener(e -> {
            ventanaInicio.ocultar();

            // Mostrar la ventana de menú
            ventanaMenu.mostrarCategorias();
            ventanaMenu.setVisible(true);
        });

        // Agregar el listener para finalizar el pedido
        ventanaMenu.addFinalizarPedidoListener(e -> {
           
            ventanaFactura.setVisible(true);
        });

        // Mostramos la ventana de inicio
        ventanaInicio.setVisible(true);
    }

    public static void main(String[] args) {
        new ControladorPrincipal();
    }
}
