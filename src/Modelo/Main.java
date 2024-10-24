package Modelo;

public class Main {
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String verde = "\u001B[32m";

        // Caja Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(5, "normal");
        int tiempoCaja1 = caja1.calcularTiempoTotal();
        System.out.println(verde + "======== Caja #1 (Experto) =======" + reset);
        System.out.println(tiempoCaja1 + " segundos.");

        // Caja Novato
        Caja caja2 = new Caja("principiante");
        caja2.llenarCola(5, "normal");
        int tiempoCaja2 = caja2.calcularTiempoTotal();
        System.out.println(verde + "======== Caja #2 (Principiante) =======" + reset);
        System.out.println(tiempoCaja2 + " segundos.");

        // Caja Regular
        Caja caja3 = new Caja("regular");
        caja3.llenarCola(5, "normal");
        int tiempoCaja3 = caja3.calcularTiempoTotal();
        System.out.println(verde + "======== Caja #3 (Regular) =======" + reset);
        System.out.println(tiempoCaja3 + " segundos.");

        // Caja Express
        Caja caja4 = new Caja("express");
        caja4.llenarCola(10, "express");
        int tiempoCaja4 = caja4.calcularTiempoTotal();
        System.out.println(verde + "======== Caja Express =======" + reset);
        System.out.println(tiempoCaja4 + " segundos.");

        // Caja con el menor tiempo
        int menorTiempo = Math.min(tiempoCaja1, Math.min(tiempoCaja2, Math.min(tiempoCaja3, tiempoCaja4)));
        System.out.println(verde + "======== Caja con el menor tiempo =======" + reset);
        if (menorTiempo == tiempoCaja1) {
            System.out.println("Caja #1 (Experto) | " + menorTiempo + " segundos");
        } else if (menorTiempo == tiempoCaja2) {
            System.out.println("Caja #2 (Principiante) | " + menorTiempo + " segundos");
        } else if (menorTiempo == tiempoCaja3) {
            System.out.println("Caja #3 (Regular) | " + menorTiempo + " segundos");
        } else {
            System.out.println("Caja Express | " + menorTiempo + " segundos");
        }
    }
}