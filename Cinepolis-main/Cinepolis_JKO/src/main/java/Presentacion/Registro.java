/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTO.ClienteDTO;
import Negocio.ClienteNegocio;
import Negocio.interfaces.IClienteNegocio;
import Negocio.excepcion.NegocioException;
import Persistencia.excepcion.PersistenciaException;
import java.awt.Color;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Registro extends javax.swing.JFrame {

    IClienteNegocio clienteNegocio = new ClienteNegocio();

    /**
     * Creates new form Registro
     */
    public Registro() {
        initComponents();
        personalizador();

        clienteNegocio = new ClienteNegocio();

    }

    public void personalizador() {
        Agrupador.setBackground(Color.decode("#07285B"));
    }

    public void registrar() {
        String nombre = txtNombre.getText();
        String materno = txtAMaterno.getText();
        String paterno = txtAPaterno.getText();
        LocalDate nacimiento = dateNacimiento.getDate();
        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();

        // Validación de campos de texto obligatorios
        if (nombre == null || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre es obligatorio.");
            return;
        }
        if (paterno == null || paterno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El apellido paterno es obligatorio.");
            return;
        }

        if (nacimiento == null) {
            JOptionPane.showMessageDialog(null, "La fecha de nacimiento es obligatoria.");
            return;
        }
        if (correo == null || correo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El correo electrónico es obligatorio.");
            return;
        }
        if (contrasena == null || contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La contraseña es obligatoria.");
            return;
        }

        // Validación de formato del correo electrónico
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(correo);
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null, "El formato del correo electrónico no es válido.");
            return;
        }

        // Validación de fecha de nacimiento (mayor de 18 años)
        LocalDate ahora = LocalDate.now();
        if (Period.between(nacimiento, ahora).getYears() < 18) {
            JOptionPane.showMessageDialog(null, "El cliente debe ser mayor de 18 años.");
            return;
        }

        // Validación de contraseña (mínimo 8 caracteres, al menos una letra y un número)
        if (contrasena.length() < 8 || !contrasena.matches(".*[a-zA-Z].*") || !contrasena.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres, incluyendo letras y números.");
            return;
        }

        // Creación del DTO del cliente
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setNombre(nombre);
        clienteDTO.setApellidoPaterno(paterno);
        clienteDTO.setApellidoMaterno(materno);
        clienteDTO.setFechaNacimiento(nacimiento);
        clienteDTO.setCorreo(correo);
        clienteDTO.setContrasena(contrasena);

        // Intentar registrar el cliente
        try {
            clienteNegocio.registrarCliente(clienteDTO);
            JOptionPane.showMessageDialog(null, "Registro exitoso.");

            LogIn login = new LogIn();

            login.setVisible(true);
            dispose();

        } catch (NegocioException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error en el negocio: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Agrupador = new javax.swing.JPanel();
        btnCancelar3 = new javax.swing.JButton();
        btnRegistrarse3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAMaterno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dateNacimiento = new com.github.lgooddatepicker.components.DatePicker();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        txtAPaterno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(0, 51, 102));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar3.setText("Cancelar");
        btnCancelar3.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar3.setForeground(new java.awt.Color(0, 0, 0));
        btnCancelar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar3ActionPerformed(evt);
            }
        });
        Agrupador.add(btnCancelar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 150, 50));

        btnRegistrarse3.setText("Registrarse");
        btnRegistrarse3.setBackground(new java.awt.Color(255, 255, 255));
        btnRegistrarse3.setForeground(new java.awt.Color(0, 0, 0));
        btnRegistrarse3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarse3ActionPerformed(evt);
            }
        });
        Agrupador.add(btnRegistrarse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 150, 50));

        jLabel1.setText("REGISTRO");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        Agrupador.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 220, 50));

        txtAMaterno.setBackground(new java.awt.Color(242, 242, 242));
        txtAMaterno.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(txtAMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 180, 30));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cinepolis logo.png"))); // NOI18N
        Agrupador.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 190));
        Agrupador.add(dateNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 210, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Apellido Materno");
        Agrupador.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 160, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nombre:");
        Agrupador.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 90, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");
        Agrupador.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 160, 30));

        txtCorreo.setBackground(new java.awt.Color(242, 242, 242));
        txtCorreo.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 390, 30));

        txtAPaterno.setBackground(new java.awt.Color(242, 242, 242));
        txtAPaterno.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(txtAPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 180, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Apellido Paterno");
        Agrupador.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Nacimiento");
        Agrupador.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 160, 30));

        txtNombre.setBackground(new java.awt.Color(242, 242, 242));
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 390, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Correo electronico");
        Agrupador.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 160, 30));

        txtContrasena.setBackground(new java.awt.Color(255, 255, 255));
        txtContrasena.setForeground(new java.awt.Color(0, 0, 0));
        Agrupador.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 386, 390, 30));

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Ver");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        Agrupador.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar3ActionPerformed
        LogIn inicio = new LogIn();
        inicio.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelar3ActionPerformed

    private void btnRegistrarse3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarse3ActionPerformed

        registrar();
    }//GEN-LAST:event_btnRegistrarse3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        
          if (jCheckBox1.isSelected()) {
            txtContrasena.setEchoChar((char) 0);
        } else {
            txtContrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JButton btnCancelar3;
    private javax.swing.JButton btnRegistrarse3;
    private com.github.lgooddatepicker.components.DatePicker dateNacimiento;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAMaterno;
    private javax.swing.JTextField txtAPaterno;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
