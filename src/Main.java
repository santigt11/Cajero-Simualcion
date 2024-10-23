public class Main {
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String verde = "\u001B[32m";

        // Caja Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja con Experto =======" + reset);
        System.out.println(caja1.calcularTiempoTotal() + " segundos.");

        // Caja Novato
        Caja caja2 = new Caja("novato");
        caja2.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja con Novato =======" + reset);
        System.out.println(caja2.calcularTiempoTotal() + " segundos.");

        // Caja Regular
        Caja caja3 = new Caja("regular");
        caja3.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja Regular =======" + reset);
        System.out.println(caja3.calcularTiempoTotal() + " segundos.");

        // Caja Express
        Caja caja4 = new Caja("express");
        caja4.llenarCola(10, "express");
        System.out.println(verde + "======== Caja Express =======" + reset);
        System.out.println(caja4.calcularTiempoTotal() + " segundos.");
    }
}