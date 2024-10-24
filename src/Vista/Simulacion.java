/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Caja;

/**
 *
 * @author steve
 */
public class Simulacion extends javax.swing.JFrame {

    public Simulacion() {
        initComponents();
        simulacion();
    }

    public void simulacion() {
        StringBuilder s = new StringBuilder("");

        // Caja Experto
        Caja caja1 = new Caja("experto");
        caja1.llenarCola(5, "normal");
        int tiempoCaja1 = caja1.calcularTiempoTotal();
        s.append("======== Caja #1 (Experto) =======\n");
        s.append(tiempoCaja1 + " segundos.\n");

        // Caja Novato
        Caja caja2 = new Caja("principiante");
        caja2.llenarCola(5, "normal");
        int tiempoCaja2 = caja2.calcularTiempoTotal();
        s.append("======== Caja #2 (Principiante) =======\n");
        s.append(tiempoCaja2 + " segundos.\n");

        // Caja Regular
        Caja caja3 = new Caja("regular");
        caja3.llenarCola(5, "normal");
        int tiempoCaja3 = caja3.calcularTiempoTotal();
        s.append("======== Caja #3 (Regular) =======\n");
        s.append(tiempoCaja3 + " segundos.\n");

        // Caja Express
        Caja caja4 = new Caja("express");
        caja4.llenarCola(10, "express");
        int tiempoCaja4 = caja4.calcularTiempoTotal();
        s.append("======== Caja Express =======\n");
        s.append(tiempoCaja4 + " segundos.\n");

        // Caja con el menor tiempo
        int menorTiempo = Math.min(tiempoCaja1, Math.min(tiempoCaja2, Math.min(tiempoCaja3, tiempoCaja4)));
        s.append("\n======== Caja con el menor tiempo =======\n");
        if (menorTiempo == tiempoCaja1) {
            s.append("Caja #1 (Experto) | " + menorTiempo + " segundos");
        } else if (menorTiempo == tiempoCaja2) {
            s.append("Caja #2 (Principiante) | " + menorTiempo + " segundos");
        } else if (menorTiempo == tiempoCaja3) {
            s.append("Caja #3 (Regular) | " + menorTiempo + " segundos");
        } else {
            s.append("Caja Express | " + menorTiempo + " segundos");
        }
        
        txtSimulacion.setText(s.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSimulacion = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cola1 = new javax.swing.JPanel();
        Cola2 = new javax.swing.JPanel();
        Cola3 = new javax.swing.JPanel();
        Cola4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtSimulacion.setEditable(false);
        txtSimulacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(txtSimulacion);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 330, 210));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Caja Express");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("Caja 1");
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Caja 2");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Caja 3");
        bg.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, -1, -1));

        Cola1.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout Cola1Layout = new javax.swing.GroupLayout(Cola1);
        Cola1.setLayout(Cola1Layout);
        Cola1Layout.setHorizontalGroup(
            Cola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        Cola1Layout.setVerticalGroup(
            Cola1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(Cola1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 390, 30));

        Cola2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout Cola2Layout = new javax.swing.GroupLayout(Cola2);
        Cola2.setLayout(Cola2Layout);
        Cola2Layout.setHorizontalGroup(
            Cola2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        Cola2Layout.setVerticalGroup(
            Cola2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(Cola2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, -1, -1));

        Cola3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout Cola3Layout = new javax.swing.GroupLayout(Cola3);
        Cola3.setLayout(Cola3Layout);
        Cola3Layout.setHorizontalGroup(
            Cola3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        Cola3Layout.setVerticalGroup(
            Cola3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(Cola3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, -1, -1));

        Cola4.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout Cola4Layout = new javax.swing.GroupLayout(Cola4);
        Cola4.setLayout(Cola4Layout);
        Cola4Layout.setHorizontalGroup(
            Cola4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        Cola4Layout.setVerticalGroup(
            Cola4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        bg.add(Cola4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Simulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cola1;
    private javax.swing.JPanel Cola2;
    private javax.swing.JPanel Cola3;
    private javax.swing.JPanel Cola4;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txtSimulacion;
    // End of variables declaration//GEN-END:variables
}