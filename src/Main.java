public class Main {
    public static void main(String[] args) {
        // Caja de Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(5);
        System.out.println(caja1.calcularTiempoTotal());
    }
}