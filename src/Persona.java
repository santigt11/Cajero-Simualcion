import java.util.Random;

public class Persona {
    int numArticulos;
    int tiempCobro;

    public Persona(int numArticulos) {
        this.numArticulos = numArticulos;
        Random rand = new Random();
        this.tiempCobro = rand.nextInt(10, 250);
    }

    public int getNumArticulos() {
        return numArticulos;
    }

    public void setNumArticulos(int numArticulos) {
        this.numArticulos = numArticulos;
    }

    public int getTiempCobro() {
        return tiempCobro;
    }

    public void setTiempCobro(int tiempCobro) {
        this.tiempCobro = tiempCobro;
    }
}
