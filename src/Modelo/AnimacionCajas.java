package Modelo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Modelo.Cliente;
import Modelo.Caja;

public class AnimacionCajas extends JFrame {

    private JPanel panelCaja1, panelCaja2, panelCaja3, panelCaja4;
    private Caja caja1, caja2, caja3, caja4;

    // Directorio de imágenes
    private String directorioImagenes = "C:\\Users\\santi.LENOVO\\Desktop\\Universidad\\Quinto Ciclo\\Simulacion\\Cajeros-Simulacion\\Cajero-Simualcion\\imagenes\\";

    public AnimacionCajas() {
        setTitle("Animación de Cajas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 4)); // 4 columnas para las 4 cajas

        // Inicializar las cajas
        caja1 = new Caja("experto");
        caja2 = new Caja("principiante");
        caja3 = new Caja("regular");
        caja4 = new Caja("express");

        // Inicializar los paneles de cada caja con sus imágenes y nombres
        panelCaja1 = crearPanelCaja("cajero.png", "Caja Experto");
        panelCaja2 = crearPanelCaja("cajero.png", "Caja Principiante");
        panelCaja3 = crearPanelCaja("cajero.png", "Caja Regular");
        panelCaja4 = crearPanelCaja("cajero.png", "Caja Express");

        // Añadir los paneles al frame
        add(panelCaja1);
        add(panelCaja2);
        add(panelCaja3);
        add(panelCaja4);

        // Llenar las colas con clientes
        caja1.llenarCola(5, "normal");
        caja2.llenarCola(5, "normal");
        caja3.llenarCola(5, "normal");
        caja4.llenarCola(10, "express");

        // Llenar las colas visuales
        llenarColaVisual(panelCaja1, caja1.getCola(), "cliente.png");
        llenarColaVisual(panelCaja2, caja2.getCola(), "cliente.png");
        llenarColaVisual(panelCaja3, caja3.getCola(), "cliente.png");
        llenarColaVisual(panelCaja4, caja4.getCola(), "cliente.png");

        // Simular el procesamiento de las colas
        new Thread(() -> procesarCola(panelCaja1, caja1)).start();
        new Thread(() -> procesarCola(panelCaja2, caja2)).start();
        new Thread(() -> procesarCola(panelCaja3, caja3)).start();
        new Thread(() -> procesarCola(panelCaja4, caja4)).start();
    }

    // Método para crear un panel de caja con su imagen y nombre
    private JPanel crearPanelCaja(String imagenCaja, String nombreCaja) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Cargar la imagen de la caja
        ImageIcon iconoCaja = new ImageIcon(directorioImagenes + imagenCaja);
        JLabel labelCaja = new JLabel(nombreCaja, iconoCaja, JLabel.CENTER);
        labelCaja.setVerticalTextPosition(JLabel.BOTTOM);
        labelCaja.setHorizontalTextPosition(JLabel.CENTER);
        
        panel.add(labelCaja, BorderLayout.CENTER);
        return panel;
    }

    // Método para llenar las colas visuales con los clientes de la lista de la caja
    private void llenarColaVisual(JPanel panel, ArrayList<Cliente> cola, String imagenCliente) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Cliente cliente : cola) {
            // Cargar la imagen del cliente
            ImageIcon iconoCliente = new ImageIcon(directorioImagenes + imagenCliente);
            JLabel clienteLabel = new JLabel("Artículos: " + cliente.getNumArticulos(), iconoCliente, JLabel.LEFT);
            clienteLabel.setVerticalTextPosition(JLabel.BOTTOM);
            clienteLabel.setHorizontalTextPosition(JLabel.CENTER);
            panel.add(clienteLabel);
        }
    }

    // Método para simular el procesamiento de la cola
    private void procesarCola(JPanel panel, Caja caja) {
        ArrayList<Cliente> cola = caja.getCola();
        try {
            while (!cola.isEmpty()) {
                Cliente cliente = cola.remove(0); // Eliminar el primer cliente (FIFO)
                int tiempoProcesamiento = (cliente.getNumArticulos() * caja.getTiempoEscanItem()) + cliente.getTiempoPago();
                Thread.sleep(tiempoProcesamiento * 1000); // Convertir el tiempo a milisegundos
                panel.remove(0); // Eliminar visualmente el primer cliente
                panel.revalidate();
                panel.repaint();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimacionCajas frame = new AnimacionCajas();
            frame.setVisible(true);
        });
    }
}
