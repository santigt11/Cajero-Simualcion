import java.util.Random;

public class Persona {
    private Integer numArticulos;
    private Integer tiempCobro;

    public Persona(String tipo) {
        if (tipo == "normal"){
            Random rand = new Random();
            this.numArticulos = rand.nextInt(1, 50);
        } else {
            Random rand = new Random();
            this.numArticulos = rand.nextInt(1, 10);
        }
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
