package Modelo;

public class Main {
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String verde = "\u001B[32m";

        // Caja Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #1 (Experto) =======" + reset);
        System.out.println(caja1.calcularTiempoTotal()+ " segundos.");

        // Caja Novato
        Caja caja2 = new Caja("principiante");
        caja2.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #2 (Principiante) =======" + reset);
        System.out.println(caja2.calcularTiempoTotal() + " segundos.");

        // Caja Regular
        Caja caja3 = new Caja("regular");
        caja3.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #3 (Regular) =======" + reset);
        System.out.println(caja3.calcularTiempoTotal() + " segundos.");

        // Caja Express
        Caja caja4 = new Caja("express");
        caja4.llenarCola(10, "express");
        System.out.println(verde + "======== Caja Express =======" + reset);
        System.out.println(caja4.calcularTiempoTotal() + " segundos.");

        // Caja con el menor tiempo
        int menorTiempo = Math.min(caja1.getTiempoTotal(), Math.min(caja2.getTiempoTotal(), Math.min(caja3.getTiempoTotal(), caja4.getTiempoTotal())));
        System.out.println(verde + "======== Caja con el menor tiempo =======" + reset);
        if (menorTiempo == caja1.getTiempoTotal()) {
            System.out.println("Caja #1 (Experto) | " + menorTiempo + " segundos");
        } else if (menorTiempo == caja2.getTiempoTotal()) {
            System.out.println("Caja #2 (Principiante) | " + menorTiempo + " segundos");
        } else if (menorTiempo == caja3.getTiempoTotal()) {
            System.out.println("Caja #3 (Regular) | " + menorTiempo + " segundos");
        } else {
            System.out.println("Caja Express | " + menorTiempo + " segundos");
        }
        
        // Crear y mostrar la animación pasando las cajas
        AnimacionCajas animacion = new AnimacionCajas(caja1, caja2, caja3, caja4);
        animacion.setVisible(true);
    }
}