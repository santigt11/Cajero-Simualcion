package Modelo;

import Vista.AnimacionCajas;


public class Main {
    
    public static String convertirTiempo (int tiempo){
        String tiempoC = "";
        if (tiempo >+ 3600) {
            tiempoC = " (" + (tiempo / 3600) + " h. " + ((tiempo % 3600) / 60) + " min. " + (tiempo %60) + " s.)";
        } if (tiempo < 3600) {
            tiempoC = " (" + (tiempo / 60) + " min. "+ (tiempo % 60) + " s.)";
        }
        return tiempoC;
    }
    
    public static void main(String[] args) {
        String reset = "\u001B[0m";
        String verde = "\u001B[32m";
        String prueba = "\u001B[32t";

        // Caja Experto
        Caja caja1 = new Caja("Experto");
        caja1.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #1 (Experto) =======" + reset);
        System.out.println(caja1.calcularTiempoTotal()+ " segundos" + convertirTiempo(caja1.getTiempoTotal()));

        // Caja Novato
        Caja caja2 = new Caja("Regular");
        caja2.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #2 (Principiante) =======" + reset);
        System.out.println(caja2.calcularTiempoTotal()+ " segundos" + convertirTiempo(caja2.getTiempoTotal()));

        // Caja Regular
        Caja caja3 = new Caja("Principiante");
        caja3.llenarCola(5, "normal");
        System.out.println(verde + "======== Caja #3 (Regular) =======" + reset);
        System.out.println(caja3.calcularTiempoTotal()+ " segundos" + convertirTiempo(caja3.getTiempoTotal()));
        
        // Caja Express
        Caja caja4 = new Caja("Express");
        caja4.llenarCola(10, "express");
        System.out.println(verde + "======== Caja Express =======" + reset);
        System.out.println(caja4.calcularTiempoTotal()+ " segundos" + convertirTiempo(caja4.getTiempoTotal()));
        
        // Caja con el menor tiempo
        int menorTiempo = Math.min(caja1.getTiempoTotal(), Math.min(caja2.getTiempoTotal(), Math.min(caja3.getTiempoTotal(), caja4.getTiempoTotal())));
        System.out.println(prueba + "\n ======== Caja mas rapida =======" + reset);
        if (menorTiempo == caja1.getTiempoTotal()) {
            System.out.println("Caja #1 (Experto) | " + menorTiempo + " segundos" + convertirTiempo(caja1.getTiempoTotal()));
        } else if (menorTiempo == caja2.getTiempoTotal()) {
            System.out.println("Caja #2 (Principiante) | " + menorTiempo + " segundos" + convertirTiempo(caja2.getTiempoTotal()));
        } else if (menorTiempo == caja3.getTiempoTotal()) {
            System.out.println("Caja #3 (Regular) | " + menorTiempo + " segundos" + convertirTiempo(caja3.getTiempoTotal()));
        } else {
            System.out.println("Caja Express | " + menorTiempo + " segundos" + convertirTiempo(caja4.getTiempoTotal()));
        }
        
        // Crear y mostrar la animación pasando las cajas
        AnimacionCajas animacion = new AnimacionCajas(caja1, caja2, caja3, caja4);
        animacion.setVisible(true);
    }
}