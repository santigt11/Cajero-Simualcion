public class Main {
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String verde = "\u001B[32m";
        // Caja de Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(9);
        System.out.println(verde + "======== Caja con Experto =======" + reset);
        System.out.println(caja1.calcularTiempoTotal() + " segundos.");

        // Caja de Novato
        Caja caja2 = new Caja("novato");
        caja1.llenarCola(5);
        System.out.println(verde + "======== Caja con Novato =======" + reset);
        System.out.println(caja1.calcularTiempoTotal() + " segundos.");
    }
}