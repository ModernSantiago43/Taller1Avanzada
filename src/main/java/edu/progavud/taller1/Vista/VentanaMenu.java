/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.progavud.taller1.Vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextArea facturaArea;
    private JLabel estadoPago;
    private JLabel ticketLabel;

    private JButton botonFinalizar;
    private JButton botonPagos;
    private JButton botonEfectivo;
    private JButton botonTarjeta;
    private JButton botonPuntos;
    private JButton botonMostrarCategorias;
    private JButton botonParaLlevar;

    private ArrayList<JButton> botonesCategorias;

    private double totalFactura;

    public VentanaMenu() {
        setTitle("Menú Principal");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        botonesCategorias = new ArrayList<>();

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel panelCategorias = new JPanel(new BorderLayout());
        JPanel botonesPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        String[] categorias = {"Hamburguesas", "Papas", "Wraps", "Nuggets", "Combos", "Cubetas", "Gaseosas"};

        for (String categoria : categorias) {
            JButton boton = new JButton(categoria);
            botonesCategorias.add(boton);
            botonesPanel.add(boton);

            JPanel panelCategoria = crearPanelCategoria(categoria);
            cardPanel.add(panelCategoria, categoria);

            boton.addActionListener(e -> cardLayout.show(cardPanel, categoria));
        }

        botonMostrarCategorias = new JButton("Mostrar Categorías");
        panelCategorias.add(botonesPanel, BorderLayout.CENTER);
        panelCategorias.add(botonMostrarCategorias, BorderLayout.SOUTH);

        botonPagos = new JButton("Pagar");
        panelCategorias.add(botonPagos, BorderLayout.SOUTH);

        cardPanel.add(panelCategorias, "Categorias");

        // Factura como ventana separada
        facturaArea = new JTextArea();
        facturaArea.setEditable(false);
        JScrollPane scrollFactura = new JScrollPane(facturaArea);
        JPanel panelFactura = new JPanel(new BorderLayout());
        panelFactura.add(scrollFactura, BorderLayout.CENTER);

        // Botón para ver la factura
        botonFinalizar = new JButton("Ver Factura");
        botonFinalizar.addActionListener(e -> mostrarFactura());
        panelFactura.add(botonFinalizar, BorderLayout.SOUTH);

        cardPanel.add(panelFactura, "Factura");

        // Configuración de los pagos
        JPanel panelPago = new JPanel(new FlowLayout());
        botonEfectivo = new JButton("Pagar en efectivo");
        botonTarjeta = new JButton("Pagar con tarjeta");
        botonPuntos = new JButton("Canjear puntos");
        panelPago.add(botonEfectivo);
        panelPago.add(botonTarjeta);
        panelPago.add(botonPuntos);

        cardPanel.add(panelPago, "Pago");

        estadoPago = new JLabel("Estado de pago: Pendiente");
        ticketLabel = new JLabel("Ticket: No generado");

        JPanel panelEstado = new JPanel(new GridLayout(2, 1));
        panelEstado.add(estadoPago);
        panelEstado.add(ticketLabel);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelEstado, BorderLayout.NORTH);
        panelPrincipal.add(cardPanel, BorderLayout.CENTER);

        add(panelPrincipal);

        totalFactura = 0.0;

        cardLayout.show(cardPanel, "Categorias");

        // Llamamos a un hilo para cerrar la ventana después de 60 segundos
        cerrarVentanaConTiempo(60000); // 60 segundos
    }

    private void cerrarVentanaConTiempo(long tiempo) {
        new Thread(() -> {
            try {
                // Esperamos el tiempo especificado
                Thread.sleep(tiempo);
                
                // Cierra la ventana
                System.exit(0);  // Cierra la aplicación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private JPanel crearPanelCategoria(String categoria) {
        JPanel panel = new JPanel(null);

        JLabel titulo = new JLabel("Productos de " + categoria);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setBounds(280, 20, 300, 30);
        panel.add(titulo);

        double precioProducto1 = 15000.0;
        double precioProducto2 = 18000.0;
        double precioProducto3 = 20000.0;
        double precioProducto4 = 25000.0;

        JButton producto1 = new JButton(categoria + " 1 - $" + precioProducto1);
        producto1.setBounds(20, 80, 200, 100);
        producto1.addActionListener(e -> agregarProductoAFactura(categoria + " 1", precioProducto1));
        panel.add(producto1);

        JButton producto2 = new JButton(categoria + " 2 - $" + precioProducto2);
        producto2.setBounds(560, 80, 200, 100);
        producto2.addActionListener(e -> agregarProductoAFactura(categoria + " 2", precioProducto2));
        panel.add(producto2);

        JButton producto3 = new JButton(categoria + " 3 - $" + precioProducto3);
        producto3.setBounds(20, 350, 200, 100);
        producto3.addActionListener(e -> agregarProductoAFactura(categoria + " 3", precioProducto3));
        panel.add(producto3);

        JButton producto4 = new JButton(categoria + " 4 - $" + precioProducto4);
        producto4.setBounds(560, 350, 200, 100);
        producto4.addActionListener(e -> agregarProductoAFactura(categoria + " 4", precioProducto4));
        panel.add(producto4);

        JButton volverBtn = new JButton("Volver");
        volverBtn.setBounds(320, 500, 150, 40);
        volverBtn.addActionListener(e -> cardLayout.show(cardPanel, "Categorias"));
        panel.add(volverBtn);

        return panel;
    }

    private void agregarProductoAFactura(String producto, double precio) {
        totalFactura += precio;
        String facturaTexto = facturaArea.getText();
        facturaTexto += producto + " - $" + String.format("%.2f", precio) + "\n";
        facturaArea.setText(facturaTexto);
    }

    // Nueva función para mostrar la factura
    private void mostrarFactura() {
        String facturaTexto = "Factura Finalizada:\n";
        facturaTexto += facturaArea.getText();
        facturaTexto += "\nTotal: $" + String.format("%.2f", totalFactura);
        facturaArea.setText(facturaTexto);
        cardLayout.show(cardPanel, "Factura");
    }

    // Nuevo método para agregar el ActionListener para finalizar el pedido
    public void addFinalizarPedidoListener(ActionListener listener) {
        botonFinalizar.addActionListener(listener);
    }

    // Métodos de acceso
    public ArrayList<JButton> getBotonesCategorias() {
        return botonesCategorias;
    }

    public JButton getBotonMostrarCategorias() {
        return botonMostrarCategorias;
    }

    public JButton getBotonEfectivo() {
        return botonEfectivo;
    }

    public JButton getBotonTarjeta() {
        return botonTarjeta;
    }

    public JButton getBotonPuntos() {
        return botonPuntos;
    }

    public JButton getBotonFinalizar() {
        return botonFinalizar;
    }

    public JButton getBotonPagos() {
        return botonPagos;
    }

    public JButton getBotonParaLlevar() {
        return botonParaLlevar;
    }

    public void mostrarCategoria(String categoria) {
        cardLayout.show(cardPanel, categoria);
    }

    public void mostrarFactura(String textoFactura) {
        facturaArea.setText(textoFactura);
        cardLayout.show(cardPanel, "Factura");
    }

    public void mostrarCategorias() {
        cardLayout.show(cardPanel, "Categorias");
    }

    public void mostrarPago() {
        cardLayout.show(cardPanel, "Pago");
    }

    public void actualizarEstadoPago(String estado) {
        if (estadoPago != null) {
            estadoPago.setText("Estado del pago: " + estado);
        }
    }

    public void actualizarTicket(String ticket) {
        if (ticketLabel != null) {
            ticketLabel.setText("Ticket: " + ticket);
        }
    }

    public void setFactura(String texto) {
        facturaArea.setText(texto);
    }

    public void setEstadoPago(String estado) {
        if (estadoPago != null) {
            estadoPago.setText("Estado de pago: " + estado);
        }
    }

    public void actualizarTotal(double total) {
        JLabel totalLabel = new JLabel("Total: $" + String.format("%.2f", total));
        if (totalLabel != null) {
            totalLabel.setText("Total: $" + String.format("%.2f", total));
        }
    }
}
