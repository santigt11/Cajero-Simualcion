package Modelo;

import java.util.ArrayList;

public class Caja {

    private ArrayList<Cliente> cola;
    private Integer tiempoEscanItem;
    private Integer tiempoTotal = 0;
    private String tipo;

    public Caja(String tipo) {
        this.cola = new ArrayList<Cliente>();
        this.tipo = tipo;
        switch (tipo) {
            case "Experto":
                this.tiempoEscanItem = 5;
                break;
            case "Principiante":
                this.tiempoEscanItem = 10;
                break;
            default:
                this.tiempoEscanItem = 7;
                break;
        }
    }

    public Caja(Integer tiempoEscanItem) {
        this.tiempoEscanItem = tiempoEscanItem;
    }

    public int calcularTiempoTotal() {
        for (Cliente p : cola) {
            tiempoTotal += (p.getNumArticulos() * tiempoEscanItem) + p.getTiempoPago();
        }
        return tiempoTotal;
    }

    public void llenarCola(int clientes, String tipo) {
        getCola().removeAll(cola);
        for (int i = 0; i < clientes; i++) {
            getCola().add(new Cliente(tipo));
        }
    }

    public ArrayList<Cliente> getCola() {
        if (cola == null) {
            cola = new ArrayList<Cliente>();
        }
        return cola;
    }

    public void setCola(ArrayList<Cliente> cola) {
        this.cola = cola;
    }

    public int getTiempoEscanItem() {
        return tiempoEscanItem;
    }

    public void setTiempoEscanItem(int tiempoEscanItem) {
        this.tiempoEscanItem = tiempoEscanItem;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Caja " + tipo;
    }
}
