package Presentacion;

import DTO.ClienteDTO;
import Persistencia.ReportePdf;
import Presentacion.PeliculaVer;
import com.itextpdf.text.BadElementException;
import entidad.Pelicula;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Compra extends javax.swing.JFrame {

    private String imagenSeleccionada;

    private Pelicula pelicula;

    private ClienteDTO cliente;

    public Compra() {
        this.pelicula = pelicula;

        initComponents();
        personalizador();
        agregarOpcionesMenu();
        mostrarDetallesPelicula();

    }

    public Compra(Pelicula pelicula, ClienteDTO cliente) {
        this.pelicula = pelicula;
        this.cliente = cliente;
        initComponents();
        personalizador();
        agregarOpcionesMenu();
        mostrarDetallesPelicula();
        clienteobtenido();
    }

    public void clienteobtenido() {
        System.out.println("cliente:" + cliente.getIdCliente());
        System.out.println("nombre:" + cliente.getNombre());
        System.out.println("Correo:" + cliente.getCorreo());

    }

    private void mostrarDetallesPelicula() {
        if (pelicula != null) {

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
        lblimagen.setOpaque(true);
        lblimagen.setBackground(new Color(0x07, 0x28, 0x5B));

        btnComprar.setBackground(Color.decode("#07285B"));
        btnCancelar.setBackground(Color.decode("#07285B"));

        // Agregar ActionListener al label de sumador
        lblSumador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                sumarUno();
            }
        });

        // Agregar ActionListener al label de restador
        lblRestador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                restarUno();
            }
        });
    }

    private void sumarUno() {
        int cantidadActual = Integer.parseInt(txtCantidadBoleto.getText());
        cantidadActual++;
        txtCantidadBoleto.setText(String.valueOf(cantidadActual));
    }

    private void restarUno() {
        int cantidadActual = Integer.parseInt(txtCantidadBoleto.getText());
        if (cantidadActual > 0) {
            cantidadActual--;
            txtCantidadBoleto.setText(String.valueOf(cantidadActual));
        }
    }

    public void agregarOpcionesMenu() {
        JMenu menuPeliculas = new JMenu("Películas");
        JMenuItem verPeliculas = new JMenuItem("Ver Películas");
        JMenuItem agregarPeliculas = new JMenuItem("Agregar Películas");
        // Agregar acciones a los elementos del menú
        verPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí colocas la lógica para ver las películas
            }
        });
        agregarPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aquí colocas la lógica para agregar películas
            }
        });
        menuPeliculas.add(verPeliculas);
        menuPeliculas.add(agregarPeliculas);

        // Aquí agregas más menús y elementos de menú según tu aplicación
        MenuBarAdmin.add(menuPeliculas);
        // Aquí agregas más menús al menú bar según tu aplicación
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Agrupador = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnComprar = new javax.swing.JButton();
        panelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblimagen = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadBoleto = new javax.swing.JTextField();
        lblSumador = new javax.swing.JLabel();
        lblRestador = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        MenuBarAdmin = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Agrupador.setBackground(new java.awt.Color(255, 255, 255));
        Agrupador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(0, 102, 153));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        Agrupador.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 470, 170, 30));

        btnComprar.setBackground(new java.awt.Color(0, 102, 153));
        btnComprar.setForeground(new java.awt.Color(255, 255, 255));
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });
        Agrupador.add(btnComprar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 170, 30));

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

        lblimagen.setText("Imagen");
        Agrupador.add(lblimagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 160, 250));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Ttitulo");
        Agrupador.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 120, 30));

        jLabel4.setText("##");
        Agrupador.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, -1, -1));

        txtCantidadBoleto.setEditable(false);
        txtCantidadBoleto.setText("0");
        txtCantidadBoleto.setEnabled(false);
        txtCantidadBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadBoletoActionPerformed(evt);
            }
        });
        Agrupador.add(txtCantidadBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 90, -1));

        lblSumador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSumador.setText("+");
        Agrupador.add(lblSumador, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 20, 20));

        lblRestador.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblRestador.setText("-");
        Agrupador.add(lblRestador, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 20, 20));

        jLabel7.setText("Boletos:");
        Agrupador.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Agrupador.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 120, -1));

        jLabel8.setText("Funcion");
        Agrupador.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel9.setText("$$$$");
        Agrupador.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, -1, -1));

        jLabel10.setText("Sala:");
        Agrupador.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        jLabel11.setText("-----------------------------------------------------------------------------------------------------");
        Agrupador.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, -1, -1));

        jLabel12.setText("Precio Boleto:");
        Agrupador.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        jLabel13.setText("Total:");
        Agrupador.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, -1));
        Agrupador.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 400, 110, 20));

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PeliculaVer peliculavr = new PeliculaVer(pelicula, cliente);
        peliculavr.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void generarReportePDF() {
        // Utiliza una ruta temporal en lugar de una ruta fija
        String rutaPDF = Paths.get(System.getProperty("java.io.tmpdir"), "reporte_boletos.pdf").toString();
        // Crea una instancia de la clase ReportePdf
        ReportePdf reportePdf = new ReportePdf();
        try {
            // Genera el reporte PDF
            reportePdf.generarReporte(rutaPDF);
            System.out.println("Reporte generado en: " + rutaPDF);

            // Abrir el archivo PDF generado
            File archivoPDF = new File(rutaPDF);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            } else {
                System.out.println("Abrir el archivo no es compatible en este sistema.");
            }
        } catch (BadElementException | IOException e) {
            // Maneja cualquier excepción que pueda ocurrir al generar el reporte PDF
            e.printStackTrace();
            // Muestra un mensaje de error si ocurre alguna excepción
            JOptionPane.showMessageDialog(null, "Error al generar el reporte PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        // Llama al método para generar el reporte PDF
        generarReportePDF();
        // Muestra un mensaje de confirmación
        JOptionPane.showMessageDialog(this, "Compra realizada con éxito");
    }//GEN-LAST:event_btnComprarActionPerformed

    private void txtCantidadBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadBoletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadBoletoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // Crear una instancia de la clase Compra
        Compra compra = new Compra();

        // Llamar a los métodos necesarios desde la instancia
        compra.initComponents();
        compra.agregarOpcionesMenu();

        // Hacer visible la ventana de Compra
        compra.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Agrupador;
    private javax.swing.JMenuBar MenuBarAdmin;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblRestador;
    private javax.swing.JLabel lblSumador;
    private javax.swing.JLabel lblimagen;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTextField txtCantidadBoleto;
    // End of variables declaration//GEN-END:variables
}
