package Modelo;

import java.util.ArrayList;
import java.util.Random;

public class Caja {
    private ArrayList<Cliente> cola;
    private Integer tiempoEscanItem;
    private Integer tiempoTotal = 0;
    private String tipo;

    public Caja(String tipo) {
        this.cola = new ArrayList<Cliente>();
        this.tipo = tipo;
        switch (tipo) {
            case "experto":
                this.tiempoEscanItem = 5;
                break;
            case "principiante":
                this.tiempoEscanItem = 10;
                break;
            default:
                this.tiempoEscanItem = 7;
                break;
        }
    }

    public int calcularTiempoTotal() {
        for (Cliente p : cola) {
            tiempoTotal += (p.getNumArticulos() * tiempoEscanItem) + p.getTiempoPago();
        }
        return tiempoTotal;
    }


    public void llenarCola(int clientes, String tipo) {
        getCola().removeAll(cola);
        Random rand = new Random();
        for (int i = 0; i < clientes; i++) {
            getCola().add(new Cliente(tipo));
        }
    }

    public ArrayList<Cliente> getCola() {
        if (cola == null)
            cola = new ArrayList<Cliente>();
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
}
