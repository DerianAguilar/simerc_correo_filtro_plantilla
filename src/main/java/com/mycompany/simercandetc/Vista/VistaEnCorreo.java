/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.simercandetc.Vista;

/**
 *
 * @author Admin
 */
public class VistaEnCorreo extends javax.swing.JFrame {

    /**
     * Creates new form VistaEnCorreo
     */
    public VistaEnCorreo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCorreo = new javax.swing.JTable();
        txtIdU = new javax.swing.JTextField();
        txtidFila = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        sTodos = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(jtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(852, 12, 177, -1));

        btnBuscar.setBackground(new java.awt.Color(204, 0, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("BUSCAR");
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 10, 110, -1));

        tablaCorreo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCorreoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCorreo);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 106, 842, 267));

        txtIdU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUActionPerformed(evt);
            }
        });
        jPanel1.add(txtIdU, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 106, 66, -1));
        jPanel1.add(txtidFila, new org.netbeans.lib.awtextra.AbsoluteConstraints(1031, 156, 66, -1));

        btnSiguiente.setBackground(new java.awt.Color(0, 204, 0));
        btnSiguiente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("SIGUIENTE");
        jPanel1.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(937, 440, 108, -1));

        sTodos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sTodos.setText("TODOS");
        sTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sTodosMouseClicked(evt);
            }
        });
        jPanel1.add(sTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 70, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtBuscarActionPerformed

    private void txtIdUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUActionPerformed

    private void tablaCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCorreoMouseClicked
        int fila=tablaCorreo.getSelectedRow();
        
        if(fila>=0){
            String id=(String)tablaCorreo.getValueAt(fila,0).toString();
            txtidFila.setText(id);
            String ida=txtidFila.getText();
            System.out.println(ida);
            
        }
    }//GEN-LAST:event_tablaCorreoMouseClicked

    private void sTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sTodosMouseClicked
        if(sTodos.isSelected()){
        txtidFila.setText("todos");
        String id=txtidFila.getText();
        System.out.println(id);
        }
    }//GEN-LAST:event_sTodosMouseClicked

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
            java.util.logging.Logger.getLogger(VistaEnCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEnCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEnCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEnCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEnCorreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnBuscar;
    public javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField jtBuscar;
    private javax.swing.JCheckBox sTodos;
    public javax.swing.JTable tablaCorreo;
    public javax.swing.JTextField txtIdU;
    public javax.swing.JTextField txtidFila;
    // End of variables declaration//GEN-END:variables
}
