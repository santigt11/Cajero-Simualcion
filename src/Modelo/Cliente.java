package Modelo;



import java.util.Random;

public class Cliente {
    private Integer numArticulos;
    private Integer tiempoPago;

    public Cliente(String tipo) {
        if ("normal".equals(tipo)){
            Random rand = new Random();
            this.numArticulos = rand.nextInt(1, 50);
        } else {
            Random rand = new Random();
            this.numArticulos = rand.nextInt(1, 10);
        }
        Random rand = new Random();
        this.tiempoPago = rand.nextInt(10, 360);
    }

    public int getNumArticulos() {
        return numArticulos;
    }

    public void setNumArticulos(int numArticulos) {
        this.numArticulos = numArticulos;
    }

    public int getTiempoPago() {
        return tiempoPago;
    }

    public void setTiempoPago(int tiempoPago) {
        this.tiempoPago = tiempoPago;
    }
}
