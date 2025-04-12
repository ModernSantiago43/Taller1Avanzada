/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Control;

/**
 *
 * @author Santiago
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import edu.progavud.taller1.Vista.VentanaMenu;

public class ControladorCategorias {
    private VentanaMenu vista;

    public ControladorCategorias(VentanaMenu vista) {
        this.vista = vista;

        for (JButton boton : vista.getBotonesCategorias()) {
            boton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String categoria = boton.getText();
                    vista.mostrarCategoria(categoria);
                }
            });
        }

        vista.getBotonMostrarCategorias().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.mostrarCategoria("Todas");
            }
        });
    }
}
