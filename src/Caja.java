import java.util.ArrayList;
import java.util.Random;

public class Caja {
    private ArrayList<Persona> cola;
    private int tiempoEscanItem;

    public Caja(int tiempoEscanItem) {
        this.cola = new ArrayList<Persona>();
        this.tiempoEscanItem = tiempoEscanItem;
    }

    public int calcularTiempoTotal() {
        int tiempoTotal = 0;
        for (Persona p : cola) {
            tiempoTotal += p.getNumArticulos() * tiempoEscanItem;
        }
        return tiempoTotal;
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

    public void llenarCola(int personas) {
        Random rand = new Random();
        for (int i = 0; i < personas; i++) {
            int nRand = rand.nextInt(1, 50);
            getCola().add(new Persona(nRand));
        }
    }
}
