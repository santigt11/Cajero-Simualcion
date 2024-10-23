import java.util.ArrayList;
import java.util.Random;

public class Caja {
    private ArrayList<Persona> cola;
    private Integer tiempoEscanItem;
    private Integer tiempoTotal = 0;

    public Caja(String cajero) {
        this.cola = new ArrayList<Persona>();
        if (cajero == "experto") {
            this.tiempoEscanItem = 5;
        } else if (cajero == "novato") {
            this.tiempoEscanItem = 10;
        } else {
            this.tiempoEscanItem = 7;
        }
    }

    public int calcularTiempoTotal() {
        for (Persona p : cola) {
            tiempoTotal += (p.getNumArticulos() * tiempoEscanItem) + p.getTiempCobro();
        }
        return tiempoTotal;
    }


    public void llenarCola(int personas) {
        Random rand = new Random();
        for (int i = 0; i < personas; i++) {
            int nRand = rand.nextInt(1, 50);
            getCola().add(new Persona(nRand));
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
}
