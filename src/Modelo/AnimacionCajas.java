import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Modelo.Cliente;
import Modelo.Caja;

public class AnimacionCajas extends JFrame {

    private JPanel panelCaja1, panelCaja2, panelCaja3, panelCaja4;
    private Caja caja1, caja2, caja3, caja4;

    public AnimacionCajas() {
        setTitle("Animación de Cajas");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 4)); // 4 columnas para las 4 cajas

        // Inicializar los paneles de cada caja
        panelCaja1 = new JPanel();
        panelCaja2 = new JPanel();
        panelCaja3 = new JPanel();
        panelCaja4 = new JPanel();

        panelCaja1.setBorder(BorderFactory.createTitledBorder("Caja Experto"));
        panelCaja2.setBorder(BorderFactory.createTitledBorder("Caja Principiante"));
        panelCaja3.setBorder(BorderFactory.createTitledBorder("Caja Regular"));
        panelCaja4.setBorder(BorderFactory.createTitledBorder("Caja Express"));

        // Añadir los paneles al frame
        add(panelCaja1);
        add(panelCaja2);
        add(panelCaja3);
        add(panelCaja4);

        // Inicializar las cajas
        caja1 = new Caja("experto");
        caja2 = new Caja("principiante");
        caja3 = new Caja("regular");
        caja4 = new Caja("express");

        // Llenar las colas con clientes
        caja1.llenarCola(5, "normal");
        caja2.llenarCola(5, "normal");
        caja3.llenarCola(5, "normal");
        caja4.llenarCola(10, "express");

        // Llenar las colas visuales
        llenarColaVisual(panelCaja1, caja1.getCola());
        llenarColaVisual(panelCaja2, caja2.getCola());
        llenarColaVisual(panelCaja3, caja3.getCola());
        llenarColaVisual(panelCaja4, caja4.getCola());

        // Simular el procesamiento de las colas
        new Thread(() -> procesarCola(panelCaja1, caja1)).start();
        new Thread(() -> procesarCola(panelCaja2, caja2)).start();
        new Thread(() -> procesarCola(panelCaja3, caja3)).start();
        new Thread(() -> procesarCola(panelCaja4, caja4)).start();
    }

    // Método para llenar las colas visuales con los clientes de la lista de la caja
    private void llenarColaVisual(JPanel panel, ArrayList<Cliente> cola) {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Cliente cliente : cola) {
            JLabel clienteLabel = new JLabel("Cliente con " + cliente.getNumArticulos() + " artículos");
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
                Thread.sleep(tiempoProcesamiento * 10); // Convertir el tiempo a milisegundos
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
