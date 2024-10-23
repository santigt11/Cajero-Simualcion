import java.util.ArrayList;

public class Caja {
    ArrayList<Persona> fila = new ArrayList<>();
    int tiempoEscaneoPorArticulo;

    public Caja(int tiempoEscaneoPorArticulo) {
        this.tiempoEscaneoPorArticulo = tiempoEscaneoPorArticulo;
    }

    public void agregarPersona(Persona p) {
        fila.add(p);
    }

    public int calcularTiempoTotal() {
        int tiempoTotal = 0;
        for (Persona p : fila) {
            tiempoTotal += p.calcularTiempoAtencion(tiempoEscaneoPorArticulo);
        }
        return tiempoTotal;
    }

    public int getNumPersonas() {
        return fila.size();
    }

    public void atenderCliente() {
        if (!fila.isEmpty()) {
            fila.remove(0);
        }
    }
}
