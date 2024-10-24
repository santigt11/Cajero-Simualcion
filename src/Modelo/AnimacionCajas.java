
package Modelo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import Modelo.Cliente;
import Modelo.Caja;

public class AnimacionCajas extends JFrame {

    private JPanel panelPrincipal;
    private JPanel panelCaja1, panelCaja2, panelCaja3, panelCaja4;
    private static Caja caja1, caja2, caja3, caja4;

    // Directorio de imágenes
    private String directorioImagenes = ".\\imagenes";

    public AnimacionCajas() throws HeadlessException {
    }
    
    // Constructor que recibe las cajas
    public AnimacionCajas(Caja caja1, Caja caja2, Caja caja3, Caja caja4) {
        this.caja1 = caja1;
        this.caja2 = caja2;
        this.caja3 = caja3;
        this.caja4 = caja4;

        setTitle("Supermercado Simulacion");
        setSize(1000, 600); // Ajusta el tamaño de la ventana según sea necesario
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el panel principal que contendrá todas las cajas
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(1, 4, 10, 10)); // 4 columnas para las 4 cajas, con separación

        // Inicializar los paneles de cada caja con sus imágenes y nombres
        panelCaja1 = crearPanelCaja("cajero.png", "Caja Experto");
        panelCaja2 = crearPanelCaja("cajero.png", "Caja Principiante");
        panelCaja3 = crearPanelCaja("cajero.png", "Caja Regular");
        panelCaja4 = crearPanelCaja("cajero.png", "Caja Express");

        // Llenar las colas visuales
        llenarColaVisual(panelCaja1, caja1.getCola(), "cliente.png");
        llenarColaVisual(panelCaja2, caja2.getCola(), "cliente.png");
        llenarColaVisual(panelCaja3, caja3.getCola(), "cliente.png");
        llenarColaVisual(panelCaja4, caja4.getCola(), "cliente.png");

        // Añadir los paneles de caja al panel principal
        panelPrincipal.add(panelCaja1);
        panelPrincipal.add(panelCaja2);
        panelPrincipal.add(panelCaja3);
        panelPrincipal.add(panelCaja4);

        // Crear un JScrollPane que contenga el panel principal
        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Añadir el JScrollPane al frame
        add(scrollPane);

        // Simular el procesamiento de las colas
        new Thread(() -> procesarCola(panelCaja1, caja1)).start();
        new Thread(() -> procesarCola(panelCaja2, caja2)).start();
        new Thread(() -> procesarCola(panelCaja3, caja3)).start();
        new Thread(() -> procesarCola(panelCaja4, caja4)).start();
    }

    // Método para crear un panel de caja con su imagen, nombre, y un borde para el carril
    private JPanel crearPanelCaja(String imagenCaja, String nombreCaja) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Cargar la imagen de la caja
        ImageIcon iconoCaja = new ImageIcon(directorioImagenes + "/" + imagenCaja);
        JLabel labelCaja = new JLabel(nombreCaja, iconoCaja, JLabel.CENTER);
        labelCaja.setVerticalTextPosition(JLabel.BOTTOM);
        labelCaja.setHorizontalTextPosition(JLabel.CENTER);

        // Añadir borde para hacer que el carril sea más visible
        panel.setBorder(new LineBorder(Color.BLACK, 3));

        panel.add(labelCaja, BorderLayout.NORTH);
        return panel;
    }

    // Método para llenar las colas visuales con los clientes de la lista de la caja
    private void llenarColaVisual(JPanel panel, ArrayList<Cliente> cola, String imagenCliente) {
        JPanel panelClientes = new JPanel();  // Panel que contendrá los clientes
        panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.Y_AXIS)); // Distribución vertical para los clientes

        for (Cliente cliente : cola) {
            // Cargar la imagen del cliente
            ImageIcon iconoCliente = new ImageIcon(directorioImagenes + "/" + imagenCliente);
            JLabel clienteLabel = new JLabel("Artículos: " + cliente.getNumArticulos(), iconoCliente, JLabel.LEFT);
            clienteLabel.setVerticalTextPosition(JLabel.BOTTOM);
            clienteLabel.setHorizontalTextPosition(JLabel.CENTER);
            panelClientes.add(clienteLabel);
        }

        // Añadir el panel de clientes al panel principal de la caja
        panel.add(panelClientes, BorderLayout.CENTER);

        // Establecer el tamaño preferido para que funcione correctamente con JScrollPane
        panelClientes.setPreferredSize(new Dimension(150, cola.size() * 100)); // Ajusta según el tamaño necesario
    }

    // Método para simular el procesamiento de la cola
    private void procesarCola(JPanel panel, Caja caja) {
        Component[] componentes = panel.getComponents();
        JPanel panelClientes = (JPanel) componentes[1]; // Asumimos que el segundo componente es el panel de clientes

        ArrayList<Cliente> cola = caja.getCola();
        try {
            while (!cola.isEmpty()) {
                Cliente cliente = cola.remove(0); // Eliminar el primer cliente (FIFO)
                int tiempoProcesamiento = (cliente.getNumArticulos() * caja.getTiempoEscanItem()) + cliente.getTiempoPago();
                Thread.sleep(tiempoProcesamiento * 1000); // Convertir el tiempo a milisegundos

                if (panelClientes.getComponentCount() > 0) {
                    panelClientes.remove(0); // Eliminar visualmente el primer cliente
                    panelClientes.revalidate();
                    panelClientes.repaint();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AnimacionCajas frame = new AnimacionCajas(caja1, caja2, caja3, caja4);
            frame.setVisible(true);
        });
    }
}
