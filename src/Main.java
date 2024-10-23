public class Main {
    public static void main(String[] args) {
        // Caja normal
        Caja caja1 = new Caja(6);
        caja1.llenarCola(5);
        System.out.println(caja1.calcularTiempoTotal());
    }
}