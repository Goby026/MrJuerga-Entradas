/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AbrirCajaControl;
import Controlador.CerrarCajaControl;
import Controlador.ManejadorFechas;
import Controlador.MyiReportVisor;
import Modelo.Conexion;
import Modelo.FlujoCaja;
import Modelo.MySQLDAO.FlujoCajaDAO;
import Modelo.MySQLDAO.VentaNotaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Marce
 */
public class CerrarCajaVIP extends javax.swing.JFrame {

    MyiReportVisor mrv;
    HashMap parametros = new HashMap();
    int opc = 0;

    public CerrarCajaVIP(String usuario) throws Exception {
        initComponents();
        setLocationRelativeTo(null);
        datosIniciales(usuario);
    }

    public CerrarCajaVIP() {
    }

    public void datosIniciales(String usuario) throws Exception {
        lblFecha.setText(new ManejadorFechas().getFechaActual());
        lblCaja.setText(new AbrirCajaControl().getCajaDeUsuario(usuario));
        txtUsuario.setText(usuario);
        if (new AbrirCajaControl().verificarEstadoCaja(usuario) > 0) {
            lblEstado.setText("CAJA APERTURADA");
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            FlujoCaja fc = new FlujoCajaDAO().obtener(idFlujoCaja);
            txtMontoApertura.setText("" + fc.getSaldo());
            //txtTotalVentas.setText("" + new CerrarCajaControl().getMontoVentas(new CerrarCajaControl().getIdUsuario(usuario), new CerrarCajaControl().getIdCaja(lblCaja.getText())));            
            txtTotalVentas.setText("" + new FlujoCajaDAO().getMontoFlujo(idFlujoCaja));
            txtTotalNotaPedido.setText("" + new VentaNotaDAO().getTotalNotaPedido(idFlujoCaja));
            double ingresos = (Double.parseDouble(txtMontoApertura.getText()) + Double.parseDouble(txtTotalVentas.getText()) + Double.parseDouble(txtTotalNotaPedido.getText()));
            lblIngresos.setText("" + ingresos);
            lblTotalEfectivo.setText("" + ingresos);
        } else {
            lblEstado.setText("CAJA CERRADA");
        }
    }

//    public double calcularBalanceTotal() {
//        double saldoInicial = Double.parseDouble(txtMontoApertura.getText()), visa = Double.parseDouble(txtVisa.getText()),mastercard = Double.parseDouble(txtMaster.getText()) ,efectivo = Double.parseDouble(txtEfectivo.getText()), egresos = Double.parseDouble(txtEgresos.getText());
//        return (saldoInicial+ efectivo) - (visa+mastercard + egresos);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMontos = new javax.swing.JDialog();
        txtMontos = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jarraCalcular = new javax.swing.JButton();
        jarraSiete = new javax.swing.JButton();
        jarraOcho = new javax.swing.JButton();
        jarraNueve = new javax.swing.JButton();
        jarraCuatro = new javax.swing.JButton();
        jarraCinco = new javax.swing.JButton();
        jarraSeis = new javax.swing.JButton();
        jarraUno = new javax.swing.JButton();
        jarraDos = new javax.swing.JButton();
        jarraTres = new javax.swing.JButton();
        jarraCero = new javax.swing.JButton();
        jarraBorrar = new javax.swing.JButton();
        jarraPunto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtMontoApertura = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTotalNotaPedido = new javax.swing.JTextField();
        lblIngresos = new javax.swing.JLabel();
        lblTotalEfectivo = new javax.swing.JLabel();
        btnCerrarCaja = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblCaja = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        txtVisa = new javax.swing.JTextField();
        txtMasterCard = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lblEgresos = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnResumenNotaPedido = new javax.swing.JButton();

        panelMontos.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMontos.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMontos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelMontos.getContentPane().add(txtMontos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 50));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("MONTOS");
        panelMontos.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, -1));

        jarraCalcular.setBackground(new java.awt.Color(51, 153, 0));
        jarraCalcular.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCalcular.setForeground(new java.awt.Color(255, 255, 255));
        jarraCalcular.setText("ACEPTAR");
        jarraCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCalcularActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraCalcular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 230, 60));

        jarraSiete.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraSiete.setText("7");
        jarraSiete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraSieteActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraSiete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 70, 60));

        jarraOcho.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraOcho.setText("8");
        jarraOcho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraOchoActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraOcho, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, 60));

        jarraNueve.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraNueve.setText("9");
        jarraNueve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraNueveActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraNueve, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 70, 60));

        jarraCuatro.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCuatro.setText("4");
        jarraCuatro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCuatroActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraCuatro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 60));

        jarraCinco.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCinco.setText("5");
        jarraCinco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCincoActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraCinco, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 70, 60));

        jarraSeis.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraSeis.setText("6");
        jarraSeis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraSeisActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraSeis, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 70, 60));

        jarraUno.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraUno.setText("1");
        jarraUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraUnoActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraUno, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 70, 60));

        jarraDos.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraDos.setText("2");
        jarraDos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraDosActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraDos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 70, 60));

        jarraTres.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraTres.setText("3");
        jarraTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraTresActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraTres, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 70, 60));

        jarraCero.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraCero.setText("0");
        jarraCero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraCeroActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraCero, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 70, 60));

        jarraBorrar.setBackground(new java.awt.Color(255, 51, 51));
        jarraBorrar.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jarraBorrar.setText("<");
        jarraBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraBorrarActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 70, 60));

        jarraPunto.setFont(new java.awt.Font("Consolas", 0, 24)); // NOI18N
        jarraPunto.setText(".");
        jarraPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarraPuntoActionPerformed(evt);
            }
        });
        panelMontos.getContentPane().add(jarraPunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 70, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CIERRE VIP");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255)), "INGRESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 14), new java.awt.Color(51, 153, 255))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("SALDO INICIAL");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 220, -1));

        txtMontoApertura.setEditable(false);
        txtMontoApertura.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtMontoApertura.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtMontoApertura, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 120, -1));

        jLabel15.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("TOTAL VENTAS");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, -1));

        txtTotalVentas.setEditable(false);
        txtTotalVentas.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtTotalVentas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtTotalVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 120, -1));

        jLabel16.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("TOTAL NOTA DE PEDIDO");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, -1));

        txtTotalNotaPedido.setEditable(false);
        txtTotalNotaPedido.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtTotalNotaPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtTotalNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 420, 200));

        lblIngresos.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblIngresos.setForeground(new java.awt.Color(204, 0, 0));
        lblIngresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 120, 30));

        lblTotalEfectivo.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        lblTotalEfectivo.setForeground(new java.awt.Color(0, 102, 51));
        getContentPane().add(lblTotalEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, 280, 50));

        btnCerrarCaja.setBackground(new java.awt.Color(255, 0, 0));
        btnCerrarCaja.setFont(new java.awt.Font("Consolas", 1, 24)); // NOI18N
        btnCerrarCaja.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/caja-de-seguridad-cerrada-en-esquema.png"))); // NOI18N
        btnCerrarCaja.setText("CERRAR CAJA");
        btnCerrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarCajaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCerrarCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 660, 470, 110));

        lblFecha.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblFecha.setText("____________");
        getContentPane().add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 170, -1));

        jLabel31.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel31.setText("FECHA:");
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel32.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel32.setText("ESTADO CAJA:");
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, -1, -1));

        lblEstado.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblEstado.setText("________________");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 180, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 120, 20));

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jLabel1.setText("CAJA:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        lblCaja.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        lblCaja.setText("____________");
        getContentPane().add(lblCaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 170, -1));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CIERRE DE CAJA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 40));

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(102, 102, 102));
        txtUsuario.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true), "USUARIO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 8), new java.awt.Color(255, 255, 255))); // NOI18N
        txtUsuario.setEnabled(false);
        txtUsuario.setFocusable(false);
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 230, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 110));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)), "EGRESOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Consolas", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel34.setText("VISA");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 120, -1));

        txtVisa.setEditable(false);
        txtVisa.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtVisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVisa.setText("0.0");
        jPanel3.add(txtVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 120, 30));

        txtMasterCard.setEditable(false);
        txtMasterCard.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        txtMasterCard.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMasterCard.setText("0.0");
        jPanel3.add(txtMasterCard, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 120, 30));

        jLabel33.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel33.setText("MASTERCARD");
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 120, -1));

        jButton1.setText("C");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 50, 30));

        jButton2.setText("C");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 50, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 420, 200));

        jLabel17.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel17.setText("INGRESOS");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        lblEgresos.setFont(new java.awt.Font("Consolas", 1, 16)); // NOI18N
        lblEgresos.setForeground(new java.awt.Color(204, 0, 0));
        lblEgresos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblEgresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 420, 120, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 450, 120, 20));

        jLabel18.setFont(new java.awt.Font("Consolas", 0, 16)); // NOI18N
        jLabel18.setText("EGRESOS");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, -1, -1));

        jLabel19.setFont(new java.awt.Font("Consolas", 0, 36)); // NOI18N
        jLabel19.setText("TOTAL EFECTIVO");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 490, 300, 50));

        btnResumenNotaPedido.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        btnResumenNotaPedido.setText("RESUMEN NOTA DE PEDIDO");
        btnResumenNotaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumenNotaPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnResumenNotaPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 610, 470, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarCajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarCajaActionPerformed

        if (!txtVisa.getText().trim().isEmpty()) {
            if (!txtMasterCard.getText().trim().isEmpty()) {
                try {
                    int opc = JOptionPane.showConfirmDialog(null, "¿CERRAR CAJA?");
                    if (opc == 0) {
                        FlujoCaja fc = new FlujoCaja();
                        fc.setFechaFinal(new ManejadorFechas().getFechaActualMySQL());
                        fc.setHoraFinal(new ManejadorFechas().getHoraActual());
                        fc.setIngresos(Double.parseDouble(lblIngresos.getText()));
                        fc.setEgresos(0);
                        fc.setSaldo(Double.parseDouble(txtMontoApertura.getText()));
                        fc.setVisa(Double.parseDouble(txtVisa.getText()));
                        fc.setMaster(Double.parseDouble(txtMasterCard.getText()));
                        fc.setJarras(0);
                        fc.setDescuadre(0);
                        fc.setEstado("0");

                        if (new CerrarCajaControl().cerrarCaja(new CerrarCajaControl().getIdUsuario(txtUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()), fc)) {
                            JOptionPane.showMessageDialog(null, "SE CERRO LA CAJA CORRECTAMENTE");
                            //datosIniciales(txtUsuario.getText());
                            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(txtUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));

                            if (validarVentaEntradas(idFlujoCaja) > 0) {
                                parametros.put("idflujo", idFlujoCaja);
                                parametros.put("usuario", txtUsuario.getText());
                                parametros.put("total", lblIngresos.getText());
                                parametros.put("nota", Double.parseDouble(txtTotalNotaPedido.getText()));
                                mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\CierreEntradasVIP.jrxml", parametros, getPageSizeVIP());
                                mrv.setNombreArchivo("CierreEntradasGeneral");
                                mrv.exportarADocxConCopia("CierreEntradasVIP.docx");
                            }

                            parametros.put("idflujo", idFlujoCaja);
                            parametros.put("usuario", txtUsuario.getText());
                            parametros.put("visa", txtVisa.getText());
                            parametros.put("master", txtMasterCard.getText());                            
                            parametros.put("total", lblIngresos.getText());
                            parametros.put("nota", Double.parseDouble(txtTotalNotaPedido.getText()));
                            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\CierreEntradasVIPNotaPedido.jrxml", parametros, getPageSizeVIP());
                            mrv.setNombreArchivo("CierreEntradasVipNota");
                            mrv.exportarADocxConCopia("CierreEntradasVIPNota.docx");

                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL CERRAR LA CAJA");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(null, "INDIQUE MONTO MASTERCARD");
            }
        } else {
            JOptionPane.showMessageDialog(null, "INDIQUE MONTO VISA");
        }
    }//GEN-LAST:event_btnCerrarCajaActionPerformed

    private void jarraCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCalcularActionPerformed

//        if (opc == 1) {
//            txtVisa.setText(txtMontos.getText());
//            txtMontos.setText("");
//            panelMontos.dispose();
//
//        } else {
//            txtMasterCard.setText(txtMontos.getText());
//            txtMontos.setText("");
//            panelMontos.dispose();
//        }
        double subtotal = 0.0;
        if (opc == 1) {
            txtVisa.setText(txtMontos.getText());
            txtMontos.setText("");
            subtotal = (Double.parseDouble(lblIngresos.getText()) - (Double.parseDouble(txtVisa.getText()) + Double.parseDouble(txtMasterCard.getText())));
            lblTotalEfectivo.setText("" + subtotal);
            panelMontos.dispose();
        } else {
            txtMasterCard.setText(txtMontos.getText());
            txtMontos.setText("");
            subtotal = (Double.parseDouble(lblIngresos.getText()) - (Double.parseDouble(txtVisa.getText()) + Double.parseDouble(txtMasterCard.getText())));
            lblTotalEfectivo.setText("" + subtotal);
            panelMontos.dispose();
        }
    }//GEN-LAST:event_jarraCalcularActionPerformed

    private void jarraSieteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraSieteActionPerformed
        String numero = txtMontos.getText() + 7;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraSieteActionPerformed

    private void jarraOchoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraOchoActionPerformed
        String numero = txtMontos.getText() + 8;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraOchoActionPerformed

    private void jarraNueveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraNueveActionPerformed
        String numero = txtMontos.getText() + 9;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraNueveActionPerformed

    private void jarraCuatroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCuatroActionPerformed
        String numero = txtMontos.getText() + 4;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraCuatroActionPerformed

    private void jarraCincoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCincoActionPerformed
        String numero = txtMontos.getText() + 5;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraCincoActionPerformed

    private void jarraSeisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraSeisActionPerformed
        String numero = txtMontos.getText() + 6;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraSeisActionPerformed

    private void jarraUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraUnoActionPerformed
        String numero = txtMontos.getText() + 1;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraUnoActionPerformed

    private void jarraDosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraDosActionPerformed
        String numero = txtMontos.getText() + 2;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraDosActionPerformed

    private void jarraTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraTresActionPerformed
        String numero = txtMontos.getText() + 3;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraTresActionPerformed

    private void jarraCeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraCeroActionPerformed
        String numero = txtMontos.getText() + 0;
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraCeroActionPerformed

    private void jarraBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraBorrarActionPerformed
        txtMontos.setText("");
    }//GEN-LAST:event_jarraBorrarActionPerformed

    private void jarraPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarraPuntoActionPerformed
        String numero = txtMontos.getText() + ".";
        txtMontos.setText(numero);
    }//GEN-LAST:event_jarraPuntoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        opc = 1; //visa
        panelMontos.setVisible(true);
        panelMontos.setBounds(700, 150, 268, 458);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        opc = 2; //mastercard
        panelMontos.setVisible(true);
        panelMontos.setBounds(700, 150, 268, 458);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnResumenNotaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumenNotaPedidoActionPerformed
        try {
            int idFlujoCaja = new FlujoCajaDAO().getIdFlujo(new CerrarCajaControl().getIdUsuario(txtUsuario.getText()), new CerrarCajaControl().getIdCaja(lblCaja.getText()));
            parametros.put("idflujo", idFlujoCaja);
            parametros.put("usuario", txtUsuario.getText());
            parametros.put("caja", lblCaja.getText());
            mrv = new MyiReportVisor(System.getProperty("user.dir") + "\\reportes\\ResumenProductosNotaPedido.jrxml", parametros);
            mrv.exportarAPdf();
        } catch (Exception ex) {
            Logger.getLogger(CerrarCajaVIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnResumenNotaPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null,lblIngresos  }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new CerrarCaja().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarCaja;
    private javax.swing.JButton btnResumenNotaPedido;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jarraBorrar;
    private javax.swing.JButton jarraCalcular;
    private javax.swing.JButton jarraCero;
    private javax.swing.JButton jarraCinco;
    private javax.swing.JButton jarraCuatro;
    private javax.swing.JButton jarraDos;
    private javax.swing.JButton jarraNueve;
    private javax.swing.JButton jarraOcho;
    private javax.swing.JButton jarraPunto;
    private javax.swing.JButton jarraSeis;
    private javax.swing.JButton jarraSiete;
    private javax.swing.JButton jarraTres;
    private javax.swing.JButton jarraUno;
    private javax.swing.JLabel lblCaja;
    private javax.swing.JLabel lblEgresos;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblTotalEfectivo;
    private javax.swing.JDialog panelMontos;
    private javax.swing.JTextField txtMasterCard;
    private javax.swing.JTextField txtMontoApertura;
    private javax.swing.JTextField txtMontos;
    private javax.swing.JTextField txtTotalNotaPedido;
    private javax.swing.JTextField txtTotalVentas;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtVisa;
    // End of variables declaration//GEN-END:variables

    //METODO PARA VALIDAR SI SE REGISTRARON VENTAS VIP
    private int validarVentaEntradas(int idFlujoCaja) throws SQLException {
        Conexion con = new Conexion();
        int total = 0;
        try {
            con.conectar();
            String sql = "SELECT count(idEntradaVip) FROM entradavip\n"
                    + "where idflujocaja = ?";
            PreparedStatement pst = con.getConexion().prepareStatement(sql);
            pst.setInt(1, idFlujoCaja);
            ResultSet res = pst.executeQuery();
            if (res.getInt(1) > 0) {
                total++;
            }
            pst.close();
            res.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            con.cerrar();
        }
        return total;
    }

    //METODO PARA LOS TAMAÑOS DE LA IMPRESION
    private int getPageSize() {
        int filas = 2;
        System.out.println("cantidad de filas: " + filas);
        int rowCount = 2;//FILAS DE GRACIA
        int fontSize = 9;//TAMAÑO DE LETRA DEL DETAIL
        int rowSize = fontSize + 2;//TAMAÑO DE LA FILA
        int caracteresPorLinea = 14;// CANTIDAD DE CARACTERES PARA QUE PASE A LA SIGTE LINEA
        for (int i = 0; i < filas; i++) {
            //String descripcionDeProducto = tblPedidos.getValueAt(i, 1).toString();
            //rowCount += (1 + (int) (descripcionDeProducto.length() / caracteresPorLinea));
            rowCount += 1;
        }
        int cabecera = 90;
        int piePagina = 200;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finales:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }

    private int getPageSizeVIP() {
        int filas = 2;
        System.out.println("cantidad de filas: " + filas);
        int rowCount = 2;//FILAS DE GRACIA
        int fontSize = 9;//TAMAÑO DE LETRA DEL DETAIL
        int rowSize = fontSize + 2;//TAMAÑO DE LA FILA
        int caracteresPorLinea = 14;// CANTIDAD DE CARACTERES PARA QUE PASE A LA SIGTE LINEA
        for (int i = 0; i < filas; i++) {
            //String descripcionDeProducto = tblPedidos.getValueAt(i, 1).toString();
            //rowCount += (1 + (int) (descripcionDeProducto.length() / caracteresPorLinea));
            rowCount += 1;
        }
        int cabecera = 80;
        int piePagina = 200;
        int pageSize = (rowCount * rowSize) + cabecera + piePagina;
        System.out.println("Cantidad de Filas finales:" + rowCount);
        System.out.println("pageSize:" + pageSize);
        return pageSize;
    }
}
