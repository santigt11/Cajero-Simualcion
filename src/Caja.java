import java.util.ArrayList;

public class Caja {
    ArrayList<Persona> cola;
    int tiempoEscanItem;

    public Caja (int tiempoEscanItem) {
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
}
