/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import DTO.ClienteDTO;
import DTO.SucursalDTO;
import Negocio.excepcion.NegocioException;
import Negocio.PeliculaNegocio;
import Negocio.SucursalNegocio;
import Persistencia.excepcion.PersistenciaException;
import Presentacion.Admin.Funciones;
import Presentacion.Admin.Peliculas;
import Presentacion.Admin.Reportes;
import Presentacion.Admin.Sucursales;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import entidad.Pelicula;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author jesus
 */
public class Inicio extends javax.swing.JFrame {

    private JPanel cardPanel;
    private CardLayout cardLayout;

    private int indiceInicio = 0;
    private int peliculasPorPagina = 10;

    private List<Pelicula> listaPeliculas;
    private ClienteDTO cliente;
    private int paginaActual = 1;
    private SucursalNegocio sucursalNegocio;

    /**
     * Creates new form Inicio
     */
    public Inicio(ClienteDTO cliente) throws NegocioException {
        this.cliente = cliente;
        this.sucursalNegocio = new SucursalNegocio();

        initComponents();
        personalizador();
        this.listaPeliculas = obtenerPeliculasDesdeBaseDeDatos();
        agregarLabelsEnPanel();
        agregarOpcionesMenu();
        clienteobtenido();

        cbSucursal = new JComboBox<>();
        cbSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO sucursalSeleccionada = (SucursalDTO) cbSucursal.getSelectedItem();
                if (sucursalSeleccionada != null) {
                    mostrarInformacionSucursal(sucursalSeleccionada);
                }
            }
        });
        
        llenarComboBoxSucursales();
    }

    public Inicio(List<Pelicula> listaPeliculas) {
        this.listaPeliculas = listaPeliculas;
        this.sucursalNegocio = new SucursalNegocio();

        initComponents();
        personalizador();
        agregarLabelsEnPanel();
        agregarOpcionesMenu();
        clienteobtenido();

        cbSucursal = new JComboBox<>();
        cbSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO sucursalSeleccionada = (SucursalDTO) cbSucursal.getSelectedItem();
                if (sucursalSeleccionada != null) {
                    mostrarInformacionSucursal(sucursalSeleccionada);
                }
            }
        });
        llenarComboBoxSucursales();
    }

    public Inicio() {
    }

    private void llenarComboBoxSucursales() {
        try {
            sucursalNegocio.llenarCMBX(cbSucursal);
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las sucursales: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarInformacionSucursal(SucursalDTO sucursal) {
        // Muestra la información de la sucursal seleccionada
        System.out.println("Sucursal seleccionada: " + sucursal.getNombre());
        System.out.println("Ciudad: " + sucursal.getCiudad());
        // Aquí puedes agregar más información de la sucursal si es necesario
    }

    public void personalizador() {
        panelMenu.setBackground(Color.decode("#07285B"));
        btnAtras.setBackground(Color.decode("#07285B"));
        btnSiguiente.setBackground(Color.decode("#07285B"));
        btnCercana.setBackground(Color.decode("#07285B"));

    }

    public void agregarOpcionesMenu() {

        JMenu menuPeliculas = new JMenu("Películas");
        JMenuItem verPeliculas = new JMenuItem("Ver Películas");
        verPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open your frame here
                Inicio Inicio = new Inicio();
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

    public void agregarLabelsEnPanel() {
        panelPeliculas.removeAll(); // Limpiar el panel antes de agregar los nuevos elementos
        panelPeliculas.setLayout(new GridLayout(2, 3, 50, 15)); // Filas, columnas, espaciado horizontal, espaciado vertical

        if (listaPeliculas != null && listaPeliculas.size() > 0) {
            int indiceFin = Math.min(indiceInicio + peliculasPorPagina, listaPeliculas.size());
            for (int i = indiceInicio; i < indiceFin; i++) {
                Pelicula pelicula = listaPeliculas.get(i);
                JLabel label = new JLabel("", SwingConstants.CENTER);
                label.setOpaque(true);
                label.setBackground(new java.awt.Color(0x07, 0x28, 0x5B)); // #07285B
                label.setForeground(java.awt.Color.WHITE); // Blanco

                try {
                    String imagePath = "src\\main\\resources\\portadas\\" + pelicula.getImagen();
                    File imageFile = new File(imagePath);
                    if (imageFile.exists()) {
                        URL imageUrl = imageFile.toURI().toURL(); // Convertir la ruta a URL
                        ImageIcon imageIcon = new ImageIcon(imageUrl);

                        Image img = imageIcon.getImage();
                        Image scaledImg = img.getScaledInstance(100, 150, Image.SCALE_SMOOTH); // Escalar la imagen
                        label.setIcon(new ImageIcon(scaledImg));
                    } else {
                        System.out.println("La imagen no existe en la ruta especificada: " + imagePath);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Agregar el listener de clic al label
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        abrirNuevoFrame(pelicula, cliente);
                    }
                });

                panelPeliculas.add(label);
            }
        }
        // Calcular el número total de páginas
        int totalPaginas = (int) Math.ceil((double) listaPeliculas.size() / peliculasPorPagina);
        lblPagina.setText("Página " + paginaActual + " de " + totalPaginas);

        panelPeliculas.revalidate(); // Actualizar el panel para que se muestren los cambios
        panelPeliculas.repaint(); // Volver a pintar el panel
    }

    public void abrirNuevoFrame(Pelicula pelicula, ClienteDTO cliente) {
        PeliculaVer peliculaVer = new PeliculaVer(pelicula, cliente);
        peliculaVer.setVisible(true);

        dispose();
    }

    private List<Pelicula> obtenerPeliculasDesdeBaseDeDatos() throws NegocioException {

        PeliculaNegocio peliculaNegocio = new PeliculaNegocio();
        try {
            return peliculaNegocio.obtenerPeliculas();
        } catch (PersistenciaException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void siguientePagina() {
        if (indiceInicio + peliculasPorPagina < listaPeliculas.size()) {
            indiceInicio += peliculasPorPagina;
            paginaActual++;
            agregarLabelsEnPanel();
        }
    }

    public void paginaAnterior() {
        if (indiceInicio - peliculasPorPagina >= 0) {
            indiceInicio -= peliculasPorPagina;
            paginaActual--;
            agregarLabelsEnPanel();
        }
    }

    public void clienteobtenido() {
        System.out.println("cliente:" + cliente.getIdCliente());
        System.out.println("nombre:" + cliente.getNombre());
        System.out.println("Correo:" + cliente.getCorreo());

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
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelPeliculas = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        cbSucursal = new javax.swing.JComboBox<>();
        btnCercana = new javax.swing.JButton();
        MenuBarAdmin = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        panelPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        panelPeliculas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Agrupador.add(panelPeliculas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 790, 330));

        btnSiguiente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSiguiente.setForeground(new java.awt.Color(255, 255, 255));
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        Agrupador.add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, 100, 40));

        btnAtras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        Agrupador.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 470, 100, 40));

        lblPagina.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPagina.setText("1");
        Agrupador.add(lblPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 180, -1));

        cbSucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Agrupador.add(cbSucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 140, -1));

        btnCercana.setForeground(new java.awt.Color(255, 255, 255));
        btnCercana.setText("Sucursal cercana");
        Agrupador.add(btnCercana, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        setJMenuBar(MenuBarAdmin);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Agrupador, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:

        siguientePagina();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:

        paginaAnterior();
    }//GEN-LAST:event_btnAtrasActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnCercana;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JComboBox<String> cbSucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPeliculas;
    // End of variables declaration//GEN-END:variables
}
