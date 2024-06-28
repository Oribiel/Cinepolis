package Persistencia;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportePdf {

    public void generarReporte(String rutaPDF) throws BadElementException, IOException {
        ConexionBD conexionBD = new ConexionBD();

        try (Connection conexion = conexionBD.crearConexion()) {
            String consulta = "SELECT b.ID_Boleto, b.FechaCompra, b.Estado, c.Nombre AS NombreCliente, "
                    + "p.Titulo, s.Nombre AS Sucursal, f.Fecha, f.HoraInicio, f.HoraFin "
                    + "FROM Boleto b "
                    + "INNER JOIN Funcion f ON b.ID_Funcion = f.ID_Funcion "
                    + "INNER JOIN Pelicula p ON f.ID_Pelicula = p.ID_Pelicula "
                    + "INNER JOIN Sala s ON f.ID_Sala = s.ID_Sala "
                    + "INNER JOIN Cliente c ON b.ID_Cliente = c.ID_Cliente";

            Document documento = new Document();
            PdfWriter.getInstance(documento, new FileOutputStream(rutaPDF));
            documento.open();

            Image imagen = Image.getInstance("cinepolis_logo.png");
            imagen.scaleToFit(150, 150);
            documento.add(imagen);

            documento.add(new Paragraph("Boleto de Cinépolis"));

            try (PreparedStatement ps = conexion.prepareStatement(consulta); ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    PdfPTable tabla = new PdfPTable(2);
                    tabla.setWidthPercentage(100);
                    tabla.setSpacingBefore(10f);
                    tabla.setSpacingAfter(10f);

                    agregarCelda(tabla, "Boleto", String.valueOf(rs.getInt("ID_Boleto")));
                    agregarCelda(tabla, "Fecha de Compra", rs.getTimestamp("FechaCompra").toString());
                    agregarCelda(tabla, "Estado", rs.getBoolean("Estado") ? "Activo" : "Inactivo");
                    agregarCelda(tabla, "Nombre Cliente", rs.getString("NombreCliente"));
                    agregarCelda(tabla, "Pelicula", rs.getString("Titulo"));
                    agregarCelda(tabla, "Sucursal", rs.getString("Sucursal"));
                    agregarCelda(tabla, "Fecha de la Funcion", rs.getDate("Fecha").toString());
                    agregarCelda(tabla, "Hora de Inicio", rs.getTime("HoraInicio").toString());
                    agregarCelda(tabla, "Hora de Fin", rs.getTime("HoraFin").toString());

                    documento.add(tabla);

                    Image qrCode = Image.getInstance("qr_code.png");
                    qrCode.scaleToFit(100, 100);
                    qrCode.setAlignment(Element.ALIGN_CENTER);
                    documento.add(qrCode);

                    documento.add(new Paragraph("\n\n"));
                    documento.newPage();
                }
            }

            documento.close();
        } catch (SQLException | DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private void agregarCelda(PdfPTable tabla, String etiqueta, String valor) {
        PdfPCell celdaEtiqueta = new PdfPCell(new Paragraph(etiqueta));
        PdfPCell celdaValor = new PdfPCell(new Paragraph(valor));
        tabla.addCell(celdaEtiqueta);
        tabla.addCell(celdaValor);
    }

}
