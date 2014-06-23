package uy.edu.ort.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uy.edu.ort.model.Arribo;
import uy.edu.ort.model.Contenedor;
import uy.edu.ort.propiedades.ManejoPropiedades;

/**
 *
 * @author Bruno Montanter - Victor Nessi
 * 
 * Clase auxiliar para manejar las operaciones de creacion y manejo de datos para los archivos PDF
 */
public class PdfUtil {

    private static String DIR = ManejoPropiedades.obtenerInstancia().obtenerPropiedad("Pdf");
    private static String FILEMES = "ReporteMes.pdf";
    private static String FILEMESBARCO = "ReporteMesBarco.pdf";
    private static String FILEPROFILING = "Profiling.pdf";
    
    public static void crearReportePDFMes(List<Arribo> arribos, String mes) {
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(DIR + FILEMES));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            document.add(new Paragraph("Reporte de arribos para el mes: " + mes));
            document.add(new Paragraph("\n\n\n"));
            document.add(crearTablaArribos(arribos));
           
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearReportePDFMesBarco(List<Arribo> arribos, String mes, String codBarco) {
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(DIR + FILEMESBARCO));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            document.add(new Paragraph("Reporte de arribos para el mes: " + mes + " y el barco: " + codBarco));
            document.add(new Paragraph("\n\n\n"));
            document.add(crearTablaArribosBarcos(arribos));
           
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void crearReportePDFProfiling(List<String> masRapido, List<String> masLento, List<List<String>> promedios) {
        try {
            Document document = new Document();
            try {
                PdfWriter.getInstance((com.itextpdf.text.Document) document, new FileOutputStream(DIR + FILEPROFILING));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
            document.open();
            document.add(new Paragraph(" Reporte de Profiling "));
            document.add(new Paragraph("\n\n\n"));
            
            document.add(new Paragraph("<< Servicio mas rapido >>"));
            document.add(new Paragraph(" Servicio >> " + masRapido.get(0) + " con un tiempo: " + masRapido.get(1) + " (nanosegundos)\n"));
            document.add(new Paragraph("\n\n"));
            
            document.add(new Paragraph("<< Servicio mas lento >>"));
            document.add(new Paragraph(" Servicio >> " + masLento.get(0) + " con un tiempo: " + masLento.get(1) + " (nanosegundos)\n"));
            document.add(new Paragraph("\n\n"));
            
            document.add(new Paragraph("<< Tiempo promedio de ejecucion por servicio >>"));
            document.add(new Paragraph("\n\n\n"));
            document.add(crearTablaProfiling(promedios));
           
            document.close();
        } catch (DocumentException ex) {
            Logger.getLogger(PdfUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static PdfPTable crearTablaArribos(List<Arribo> arribos) {
        // a table with three columns
        PdfPTable table = new PdfPTable(6);
        table.addCell("ID");
        table.addCell("Origen");
        table.addCell("Fecha");
        table.addCell("Descripcion");
        table.addCell("Barco");
        table.addCell("Contenedores");
        for (Arribo arribo : arribos) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
            String codigoConts = "";
            for (Object c : arribo.getContenedores()) {
                codigoConts += " - " + ((Contenedor) c).getCodigo();
            }
            codigoConts += " - ";
            
            table.addCell(String.valueOf(arribo.getId()));
            table.addCell(arribo.getOrigen());
            table.addCell(fechaString);
            table.addCell(arribo.getDescripcion());
            table.addCell(arribo.getBarco().getCodigo());
            table.addCell(codigoConts);
            
        }
        return table;
    }
    
    private static PdfPTable crearTablaArribosBarcos(List<Arribo> arribos) {
        // a table with three columns
        PdfPTable table = new PdfPTable(7);
        table.addCell("ID");
        table.addCell("Origen");
        table.addCell("Fecha");
        table.addCell("Descripcion");
        table.addCell("Barco");
        table.addCell("Contenedores");
        table.addCell("Peso Total");
        for (Arribo arribo : arribos) {
            String fechaString = new SimpleDateFormat("dd-MM-yyyy").format(arribo.getFecha());
            String codigoConts = "";
            int peso = 0;
            for (Object c : arribo.getContenedores()) {
                codigoConts += " - " + ((Contenedor) c).getCodigo();
                peso += ((Contenedor) c).getCapacidad();
            }
            codigoConts += " - ";
            
            table.addCell(String.valueOf(arribo.getId()));
            table.addCell(arribo.getOrigen());
            table.addCell(fechaString);
            table.addCell(arribo.getDescripcion());
            table.addCell(arribo.getBarco().getCodigo());
            table.addCell(codigoConts);
            table.addCell(String.valueOf(peso));
            
        }
        return table;
    }
    
    private static PdfPTable crearTablaProfiling(List<List<String>> promedios) {
        PdfPTable table = new PdfPTable(2);
        
        table.addCell("Servicio");
        table.addCell("Tiempo Promedio (nanosegundos)");
        for (List<String> list : promedios) {
            table.addCell(list.get(0));
            table.addCell(list.get(1));
            
        }
        return table;
    }
}
