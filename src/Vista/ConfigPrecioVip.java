/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ColumnasTablas;
import Modelo.Conexion;
import Modelo.MySQLDAO.ProdPromocionDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MARCEL
 */
public class ConfigPrecioVip extends javax.swing.JFrame {

    DefaultTableModel modelo;

    public ConfigPrecioVip() throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        LlenarTabla();
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
        lblProducto = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBox = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        txtPrecioEntradaVip = new javax.swing.JTextField();
        btnGuardarPrecioEntradaVip = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRECIOS VIP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblProducto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblProducto.setForeground(new java.awt.Color(255, 255, 255));
        lblProducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 640, 30));

        tblBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblBox.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBoxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBox);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 650, 490));

        btnGuardar.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardar.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 680, -1, 50));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRECIO ENTRADA VIP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, 30));

        txtPrecio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 690, 100, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRECIO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 650, 100, 30));

        btnSalir.setBackground(new java.awt.Color(255, 0, 0));
        btnSalir.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 150, 50));

        txtPrecioEntradaVip.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPanel1.add(txtPrecioEntradaVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 100, -1));

        btnGuardarPrecioEntradaVip.setBackground(new java.awt.Color(51, 255, 51));
        btnGuardarPrecioEntradaVip.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnGuardarPrecioEntradaVip.setText("GUARDAR");
        btnGuardarPrecioEntradaVip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrecioEntradaVipActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarPrecioEntradaVip, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 130, 30));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PRECIOS VIP");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 650, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtPrecio.getText().trim().isEmpty()) {
            try {
                int fila = tblBox.getSelectedRow();
                int idprodpresentacion = Integer.parseInt(tblBox.getValueAt(fila, 0).toString());
                double precio = Double.parseDouble(txtPrecio.getText());

                ProdPromocionDAO pdao = new ProdPromocionDAO();

                if (pdao.updatePrecio(precio, idprodpresentacion)) {
                    JOptionPane.showMessageDialog(getRootPane(), "SE ACTUALIZÓ EL PRECIO DEL PRODUCTO");
                    LlenarTabla();
                    btnGuardar.setEnabled(false);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "INDIQUE PRECIO DEL PRODUCTO SELECCIONADO");
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tblBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBoxMouseClicked

        int fila = tblBox.getSelectedRow();

        lblProducto.setText(tblBox.getValueAt(fila, 1).toString());

        txtPrecio.setText("" + Double.parseDouble(tblBox.getValueAt(fila, 2).toString()));

        btnGuardar.setEnabled(true);

    }//GEN-LAST:event_tblBoxMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnGuardarPrecioEntradaVipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrecioEntradaVipActionPerformed
        if (!txtPrecioEntradaVip.getText().trim().isEmpty()) {
            double precioVip = Double.parseDouble(txtPrecioEntradaVip.getText());
            //ACTUALIZAR LA TABLA
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "INGRESE UN PRECIO PARA ENTRADA VIP");
        }
    }//GEN-LAST:event_btnGuardarPrecioEntradaVipActionPerformed

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
            java.util.logging.Logger.getLogger(ConfigPrecioVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigPrecioVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigPrecioVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigPrecioVip.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConfigPrecioVip().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ConfigPrecioVip.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnGuardarPrecioEntradaVip;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JTable tblBox;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtPrecioEntradaVip;
    // End of variables declaration//GEN-END:variables

    private void titulos() {
        String titulos[] = {"COD", "PRODUCTO", "PRECIO"};
        modelo = new DefaultTableModel(null, titulos);
        tblBox.setModel(modelo);
    }

    private void LlenarTabla() throws Exception {
        titulos();
        LimpiarTabla(tblBox, modelo);
        Conexion con = new Conexion();
        try {
            con.conectar();
            String sql = "SELECT prodpromocion.idproductopresentacion, producto.nombre, prodpromocion.precio1\n"
                    + "FROM prodpromocion\n"
                    + "inner join productopresentacion on prodpromocion.idproductopresentacion = productopresentacion.idproductopresentacion\n"
                    + "inner join producto on productopresentacion.idproducto = producto.idproducto";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);

            ResultSet res = pst.executeQuery();

            Object datos[] = new Object[3];

            while (res.next()) {
                datos[0] = res.getInt(1);
                datos[1] = res.getString(2);
                //crear condicional de la hora para modificar el precio(precio1->precio2) despues de las 12:00 de la noche            
                datos[2] = res.getDouble(3);

                modelo.addRow(datos);
            }

            tblBox.setModel(modelo);

            pst.close();
            res.close();

            new ColumnasTablas().tresColumnas(tblBox, 50, 500, 100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }

    }

    private void LimpiarTabla(JTable tabla, DefaultTableModel model) {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

}
