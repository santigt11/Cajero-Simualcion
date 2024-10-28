package Vista;

import Modelo.Caja;
import Modelo.Cliente;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class AnimacionCajas extends JFrame {

    private BackgroundPanel panelPrincipa;
    private JPanel panelPrincipal;
    private JPanel panelCaja1, panelCaja2, panelCaja3, panelCaja4;
    private static Caja caja1, caja2, caja3, caja4;
    private Thread hilo;

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
        setSize(1000, 600); // Tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panelPrincipal = new BackgroundPanel(directorioImagenes + "/background.png");
        panelPrincipal.setLayout(new GridLayout(1, 4, 10, 10));
        panelCaja1 = crearPanelCaja("cajero.png", caja1.toString());
        panelCaja2 = crearPanelCaja("cajero.png", caja2.toString());
        panelCaja3 = crearPanelCaja("cajero.png", caja3.toString());
        panelCaja4 = crearPanelCaja("cajeroExpress.png", caja4.toString());

        llenarColaVisual(panelCaja1, caja1.getCola(), "cliente");
        llenarColaVisual(panelCaja2, caja2.getCola(), "cliente");
        llenarColaVisual(panelCaja3, caja3.getCola(), "cliente");
        llenarColaVisual(panelCaja4, caja4.getCola(), "cliente");

        panelPrincipal.add(panelCaja1);
        panelPrincipal.add(panelCaja2);
        panelPrincipal.add(panelCaja3);
        panelPrincipal.add(panelCaja4);

        JScrollPane scrollPane = new JScrollPane(panelPrincipal);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        new Thread(() -> procesarCola(panelCaja1, caja1)).start();
        new Thread(() -> procesarCola(panelCaja2, caja2)).start();
        new Thread(() -> procesarCola(panelCaja3, caja3)).start();
        new Thread(() -> procesarCola(panelCaja4, caja4)).start();
    }

    private JPanel crearPanelCaja(String imagenCaja, String nombreCaja) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.setBackground(new Color(213, 180, 148));
        if (nombreCaja.equals("Caja Express")) {
            panel.setBackground(new Color(217, 125, 70));
        }

        ImageIcon iconoCaja = new ImageIcon(directorioImagenes + "/" + imagenCaja);
        JLabel labelCaja = new JLabel(nombreCaja, iconoCaja, JLabel.CENTER);
        labelCaja.setVerticalTextPosition(JLabel.BOTTOM);
        labelCaja.setHorizontalTextPosition(JLabel.CENTER);

        Border topBorder = new MatteBorder(0, 0, 0, 0, Color.WHITE);
        Border otherBorders = new MatteBorder(0, 5, 5, 5, Color.BLACK);
        panel.setBorder(new CompoundBorder(topBorder, otherBorders));
        panel.add(labelCaja, BorderLayout.NORTH);
        return panel;
    }

    private void llenarColaVisual(JPanel panel, ArrayList<Cliente> cola, String imagenCliente) {
        JPanel panelClientes = new JPanel();
        panelClientes.setBackground(new Color(213, 180, 148));
        if (((JLabel) panel.getComponent(0)).getText().equals("Caja Express")) {
            panelClientes.setBackground(new Color(213, 163, 122));
        }
        panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.Y_AXIS));
        Random rand = new Random();
        for (Cliente cliente : cola) {
            int clienteTipo = rand.nextInt(1, 6);
            ImageIcon iconoCliente;
            if (clienteTipo == 1) {
                iconoCliente = new ImageIcon(directorioImagenes + "\\" + imagenCliente + ".png");
            } else {
                iconoCliente = new ImageIcon(directorioImagenes + "\\" + imagenCliente + clienteTipo + ".png");
            }
            JLabel clienteLabel = new JLabel("Artículos: " + cliente.getNumArticulos(), iconoCliente, JLabel.LEFT);
            clienteLabel.setVerticalTextPosition(JLabel.BOTTOM);
            clienteLabel.setHorizontalTextPosition(JLabel.CENTER);
            panelClientes.add(clienteLabel);
        }
        panel.add(panelClientes, BorderLayout.CENTER);
        panelClientes.setPreferredSize(new Dimension(150, cola.size() * 150)); // Ajusta según el tamaño necesario
    }

    private void procesarCola(JPanel panel, Caja caja) {
        Component[] componentes = panel.getComponents();
        JPanel panelClientes = (JPanel) componentes[1]; // Asumimos que el segundo componente es el panel de clientes

        ArrayList<Cliente> cola = caja.getCola();
        try {
            while (!cola.isEmpty()) {
                Cliente cliente = cola.remove(0); // Eliminar el primer cliente (FIFO)
                int tiempoProcesamiento = (cliente.getNumArticulos() * caja.getTiempoEscanItem()) + cliente.getTiempoPago();
                Thread.sleep(tiempoProcesamiento * 50); // Convertir tiempo a milisegundos

                if (panelClientes.getComponentCount() > 0) {
                    Component clienteVisual = panelClientes.getComponent(0); // Obtener el primer cliente visual
                    if (clienteVisual instanceof JLabel) {
                        ((JLabel) clienteVisual).setText("Gracias!"); // Cambiar la etiqueta a "Gracias!"
                    }

                    // Nueva instancia del hilo para cada cliente visual
                    Thread animacionHilo = new Thread(() -> {
                        try {
                            while (clienteVisual.getY() > -clienteVisual.getHeight()) {
                                Thread.sleep(60);
                                clienteVisual.setLocation(clienteVisual.getX(), clienteVisual.getY() - 5);
                                panelClientes.repaint();
                            }
                            panelClientes.remove(clienteVisual); // Eliminar visualmente el primer cliente
                            panelClientes.repaint();

                            // Desplazar el resto de los clientes hacia arriba
                            for (Component c : panelClientes.getComponents()) {
                                if (c instanceof JLabel) {
                                    JLabel clienteRestante = (JLabel) c;
                                    int targetY = clienteRestante.getY() - clienteVisual.getHeight();
                                    while (clienteRestante.getY() > targetY) {
                                        Thread.sleep(49);
                                        clienteRestante.setLocation(clienteRestante.getX(), clienteRestante.getY() - 15);
                                        panelClientes.repaint();
                                    }
                                }
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });

                    // Iniciar la animación para el cliente actual
                    animacionHilo.start();
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
