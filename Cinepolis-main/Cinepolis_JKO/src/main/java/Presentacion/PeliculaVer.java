/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTO.ClienteDTO;
import Negocio.excepcion.NegocioException;
import Presentacion.Admin.Funciones;
import Presentacion.Admin.Peliculas;
import Presentacion.Admin.Reportes;
import Presentacion.Admin.Sucursales;
import entidad.Pelicula;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

/**
 *
 * @author jesus
 */
public class PeliculaVer extends javax.swing.JFrame {

    private Pelicula pelicula;
    private ClienteDTO cliente;

    public PeliculaVer(Pelicula pelicula) {
        this.pelicula = pelicula;

        setTitle("Detalles de la Película");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        initComponents();
        mostrarDetallesPelicula();
        personalizador();
        agregarOpcionesMenu();
        clienteobtenido();
    }
    
    public PeliculaVer(Pelicula pelicula, ClienteDTO cliente) {
        this.pelicula = pelicula;
        this.cliente = cliente;

        setTitle("Detalles de la Película");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);

        initComponents();
        mostrarDetallesPelicula();
        personalizador();
        agregarOpcionesMenu();
        clienteobtenido();
    }

    /**
     * Creates new form Pelicula
     */
    public PeliculaVer() {
        initComponents();
        mostrarDetallesPelicula();
        personalizador();
        agregarOpcionesMenu();
        clienteobtenido();

    }
    
     public void clienteobtenido(){
        System.out.println("cliente:" + cliente.getIdCliente());
        System.out.println("nombre:" + cliente.getNombre());
        System.out.println("Correo:" + cliente.getCorreo());
    
        
    }

    private void mostrarDetallesPelicula() {
        if (pelicula != null) {
            lblNombre.setText(pelicula.getTitulo());
            // Utilizar HTML para dar formato al texto de la sinopsis
            lblSinopsis.setText("<html><body style='width: 250px'>" + pelicula.getSinopsis() + "</body></html>");

            lblTrailer.setText("Presiona para ver el trailer de la pelicula");

            try {
                String imagePath = "src/main/resources/portadas/" + pelicula.getImagen();
                URL imageUrl = new URL("file:" + imagePath);
                ImageIcon imageIcon = new ImageIcon(imageUrl);

                Image img = imageIcon.getImage();
                Image scaledImg = img.getScaledInstance(220, 310, Image.SCALE_SMOOTH);
                lblimagen.setIcon(new ImageIcon(scaledImg));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Imprimir la información de la película en la consola nomas para confirmar si se obtuvo
            System.out.println("ID:" + pelicula.getIdPelicula());
            System.out.println("Titulo: " + pelicula.getTitulo());
            System.out.println("Sinopsis: " + pelicula.getSinopsis());
            System.out.println("Trailer: " + pelicula.getTrailer());
            System.out.println("Imagen: " + pelicula.getImagen());
        }
    }

    public void personalizador() {
        panelMenu.setBackground(Color.decode("#07285B"));

        lblimagen.setOpaque(true);
        lblimagen.setBackground(new java.awt.Color(0x07, 0x28, 0x5B));

        btnComprar.setBackground(Color.decode("#07285B"));
        btnVolver.setBackground(Color.decode("#07285B"));

    }


    public void cargarPelicula() {

        // Verificar si Desktop es soportado
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();

            // Verificar si BROWSE es soportado
            if (desktop.isSupported(Desktop.Action.BROWSE)) {
                try {
                    // Crear el URI del hipervínculo
                    URI uri = new URI(pelicula.getTrailer());

                    // Abrir el hipervínculo en el navegador predeterminado
                    desktop.browse(uri);
                } catch (Exception e) {
                    // Manejar excepciones de URI y IO
                    e.printStackTrace();
                }
            } else {
                System.out.println("La acción BROWSE no está soportada en esta plataforma.");
            }
        } else {
            System.out.println("La clase Desktop no está soportada en esta plataforma.");
        }
    }
    
    public void agregarOpcionesMenu() {

        JMenu menuPeliculas = new JMenu("Peliculas");
        JMenuItem verPeliculas = new JMenuItem("Ver Peliculas");
        verPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Inicio Inicio;
                Inicio = new Inicio();
                Inicio.setVisible(true);
                dispose();

            }
        });

        menuPeliculas.add(verPeliculas);

        JMenu menuFunciones = new JMenu("Funciones");
        JMenuItem verFunciones = new JMenuItem("Ver Funciones");
        verFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Funciones Funciones = new Funciones();
                Funciones.setVisible(true);

                dispose();
            }
        });

        JMenuItem agregarFunciones = new JMenuItem("Agregar Funciones");
        agregarFunciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Funciones Funciones = new Funciones();
                Funciones.setVisible(true);

                dispose();
            }
        });
        menuFunciones.add(verFunciones);
        menuFunciones.add(agregarFunciones);

        JMenu menuReportes = new JMenu("Reportes");
        JMenuItem GenerarReporte = new JMenuItem("Ganancias Sucursales");
        GenerarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Sucursales Reportes = new Sucursales();
                Reportes.setVisible(true);

                dispose();
            }
        });

        JMenuItem reportePeliculas = new JMenuItem("Ganancias Peliculas");
        reportePeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Peliculas Reportes = new Peliculas();
                Reportes.setVisible(true);

                dispose();
            }
        });
        menuReportes.add(GenerarReporte);
        menuReportes.add(reportePeliculas);

        JMenu menuBoletos = new JMenu("Boletos");
        JMenuItem ComprarBoleto = new JMenuItem("Comprar Boleto");
        ComprarBoleto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Compra comprar = new Compra();
                comprar.setVisible(true);

                dispose();
            }
        });
        menuBoletos.add(ComprarBoleto);

        JMenu menuSucursales = new JMenu("Sucursales");
        JMenuItem verSucursales = new JMenuItem("Ver Sucursales");
        verSucursales.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Sucursales Sucursales = new Sucursales();
                Sucursales.setVisible(true);

                dispose();
            }
        });
        menuSucursales.add(verSucursales);

        MenuBarAdmin.add(menuPeliculas);
        MenuBarAdmin.add(menuFunciones);
        MenuBarAdmin.add(menuReportes);
        MenuBarAdmin.add(menuBoletos);
        MenuBarAdmin.add(menuSucursales);
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
        btnVolver = new javax.swing.JButton();
        lblSinopsis = new javax.swing.JLabel();
        btnComprar = new javax.swing.JButton();
        lblTrailer = new javax.swing.JLabel();
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblimagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        MenuBarAdmin = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVolver.setBackground(new java.awt.Color(0, 102, 153));
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        Agrupador.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 240, 30));

        lblSinopsis.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSinopsis.setForeground(new java.awt.Color(0, 0, 0));
        lblSinopsis.setText("Sinopsis");
        Agrupador.add(lblSinopsis, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 330, 100));

        btnComprar.setBackground(new java.awt.Color(0, 102, 153));
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar boletos");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        Agrupador.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 240, 30));

        lblTrailer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTrailer.setForeground(new java.awt.Color(0, 0, 0));
        lblTrailer.setText("Trailer");
        lblTrailer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTrailerMouseClicked(evt);
            }
        });
        Agrupador.add(lblTrailer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 270, 40));

        panelMenu.setBackground(new java.awt.Color(0, 51, 102));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cinepolis logo barra.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("inepolis");

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 490, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Agrupador.add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 60));
        Agrupador.add(lblimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 220, 310));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Trailer");
        Agrupador.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 290, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Titulo");
        Agrupador.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 290, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Sinopsis");
        Agrupador.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 290, -1));

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(0, 0, 0));
        lblNombre.setText("Titulo");
        Agrupador.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 270, 40));

        setJMenuBar(MenuBarAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            Inicio inicio = new Inicio(cliente);
            inicio.setVisible(true);
            dispose();
        } catch (NegocioException ex) {
            Logger.getLogger(PeliculaVer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // TODO add your handling code here:
        Compra comprar = new Compra(pelicula, cliente);

        comprar.setVisible(true);

        dispose();

    }//GEN-LAST:event_btnComprarActionPerformed

    private void lblTrailerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTrailerMouseClicked

        cargarPelicula();

    }//GEN-LAST:event_lblTrailerMouseClicked

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
            java.util.logging.Logger.getLogger(PeliculaVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeliculaVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeliculaVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeliculaVer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeliculaVer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JButton btnComprar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblSinopsis;
    private javax.swing.JLabel lblTrailer;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JPanel panelMenu;
    // End of variables declaration//GEN-END:variables
}
