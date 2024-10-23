import java.util.ArrayList;
import java.util.Random;

public class Caja {
    private ArrayList<Persona> cola;
    private Integer tiempoEscanItem;
    private Integer tiempoTotal = 0;
    private String tipo;

    public Caja(String tipo) {
        this.cola = new ArrayList<Persona>();
        this.tipo = tipo;
        switch (tipo) {
            case "experto":
                this.tiempoEscanItem = 5;
                break;
            case "novato":
                this.tiempoEscanItem = 10;
                break;
            default:
                this.tiempoEscanItem = 7;
                break;
        }
    }

    public int calcularTiempoTotal() {
        for (Persona p : cola) {
            tiempoTotal += (p.getNumArticulos() * tiempoEscanItem) + p.getTiempCobro();
        }
        return tiempoTotal;
    }


    public void llenarCola(int personas, String tipo) {
        getCola().removeAll(cola);
        Random rand = new Random();
        for (int i = 0; i < personas; i++) {
            getCola().add(new Persona(tipo));
        }
    }

    public ArrayList<Persona> getCola() {
        if (cola == null)
            cola = new ArrayList<Persona>();
        return cola;
    }

    public void setCola(ArrayList<Persona> cola) {
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
