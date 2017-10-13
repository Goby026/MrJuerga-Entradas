/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import Modelo.Conexion;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.swing.JRViewer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 *
 * @author Hans
 */
public class MyiReportVisor extends javax.swing.JInternalFrame {

    private String nombreArchivo;
    private JasperPrint printr;
    private List pages = new ArrayList<>();

    /**
     * Creates new form MyiReportVisor
     */
    private MyiReportVisor() {
        super("Visor de Reportes", true, true, true, true);
        initComponents();
        //setBounds(10,10,600,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public MyiReportVisor(String fileName, HashMap parameter) {

        this();
        try {
            Conexion con = new Conexion();
            con.conectar();
            System.out.println("Creo conexion");
            //JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream(fileName + ".jrxml"));   
            //jd.setPageWidth(getPageSize());
            //String nfileName= JasperCompileManager.compileReportToFile(jd.getName());
            String nfileName = JasperCompileManager.compileReportToFile(fileName);
            System.out.println("Compilo");
            JasperPrint print = JasperFillManager.fillReport(nfileName, parameter, con.getConexion());
            System.out.println("Relleno el reporte");
            JRViewer viewer = new JRViewer(print);
            System.out.println("lanzo el visor");
            //JasperPrintManager.printReport(print, true);
            printr = print;
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            c.add(viewer);
        } catch (JRException jre) {
            jre.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(MyiReportVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * si se desea imprimir solo una hoja, se llama al objeto "printr" si se
     * desea imprimir hoja + copia, se llama al objeto "pages"
     */
    public void exportarAPdf() {
        try {
            //EXPORTANDO PDF
            System.out.println("Exportando a pdf");
            final JRPdfExporter exp = new JRPdfExporter();
            exp.setParameter(JRExporterParameter.JASPER_PRINT, printr);
            exp.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
            exp.setParameter(JRExporterParameter.OUTPUT_FILE, new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            exp.exportReport();
            /*
            PrinterJob job = PrinterJob.getPrinterJob();
            PDDocument pdc = PDDocument.load(new File("D:\\pdfGenerados\\"+nombreArchivo+".pdf"));
            System.out.println("" + pdc.getNumberOfPages());
            job.setPageable(new PDFPageable(pdc));
            job.print();
             */
            //Abriendo PDF
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler " + "D:\\pdfGenerados\\" + nombreArchivo + ".pdf");
        } catch (IOException | JRException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * si se desea imprimir solo una hoja, se llama al objeto "printr" si se
     * desea imprimir hoja + copia, se llama al objeto "pages"
     */
    public void exportarAPdfConCopia() throws IOException {
        try {
            //EXPORTANDO PDF
            System.out.println("Exportando a pdf");
            final JRPdfExporter exp = new JRPdfExporter();
            exp.setParameter(JRExporterParameter.JASPER_PRINT_LIST, pages);
            exp.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
            exp.setParameter(JRExporterParameter.OUTPUT_FILE, new File("D:\\pdfGenerados\\"+nombreArchivo+".pdf"));
            exp.exportReport();
            PrinterJob job = PrinterJob.getPrinterJob();
            PDDocument pdc = PDDocument.load(new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            System.out.println("" + pdc.getNumberOfPages());
            job.setPageable(new PDFPageable(pdc));
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(MyiReportVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Mostrando PDF");
            //Abriendo PDF
            //Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"D:\\pdfGenerados\\" + nombreArchivo + ".pdf");
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public void exportarAPdfConCopia(int cantidadCopias) throws IOException {
        try {
            //EXPORTANDO PDF
            System.out.println("Exportando a pdf");
            final JRPdfExporter exp = new JRPdfExporter();

            List nroCopias = new ArrayList<>();
            for (int i = 0; i < cantidadCopias; i++) {
                nroCopias.add(printr);
            }
            exp.setParameter(JRExporterParameter.JASPER_PRINT_LIST, nroCopias);
            exp.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
            exp.setParameter(JRExporterParameter.OUTPUT_FILE, new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            exp.exportReport();
            PrinterJob job = PrinterJob.getPrinterJob();

            PDDocument pdc = PDDocument.load(new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            System.out.println("" + pdc.getNumberOfPages());
            job.setPageable(new PDFPageable(pdc));
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(MyiReportVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Mostrando PDF");
            //Abriendo PDF
            //Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"D:\\pdfGenerados\\" + nombreArchivo + ".pdf");
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public MyiReportVisor(String fileName, HashMap parameter, String cnVacia) {
        this();
        try {
            //Conector con = new Conector();
            String nfileName = JasperCompileManager.compileReportToFile(fileName);
            JasperPrint print = JasperFillManager.fillReport(nfileName, parameter, new JREmptyDataSource());
            JRViewer viewer = new JRViewer(print);
            printr = print;
            Container c = getContentPane();
            c.setLayout(new BorderLayout());
            c.add(viewer);
        } catch (JRException jre) {
            jre.printStackTrace();
        }
    }

    /**
     * Funcionalidad: Este metodo permite el cambio dinamico del tamanio del
     * reporte, adicionalmente para el caso de ticketeras (corte automatico)
     * almacena una hoja + copia. Por eso hace la llamada al metodo.
     *
     * @param fileName
     * @param parameter
     * @param pageSize
     */
    public MyiReportVisor(String fileName, HashMap parameter, int pageSize) {
        this();
        try {
            Conexion con = new Conexion();
            con.conectar();
            System.out.println("Creo conexion");
            //JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream(fileName));   
            JasperDesign jd = JRXmlLoader.load(fileName);
            jd.setPageHeight(pageSize);
            JasperCompileManager.compileReportToFile(jd, fileName + ".jasper");
            //String nfileName= JasperCompileManager.compileReportToFile(fileName);
            System.out.println("Compilo");
            JasperPrint print = JasperFillManager.fillReport(fileName + ".jasper", parameter, con.getConexion());

            pages.add(print);
            //pages.add(print);

            System.out.println("Relleno el reporte");
            //JRViewer viewer=new JRViewer(print);
            System.out.println("lanzo el visor");
            //JasperPrintManager.printReport(print, true);
            printr = print;
            //Container c=getContentPane();
            //c.setLayout(new BorderLayout());
            //c.add(viewer);
        } catch (JRException jre) {
            jre.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(MyiReportVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MyiReportVisor(String fileName) {
        this(fileName, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setTitle("REPORTE GENERADO AUTOMATICAMENTE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 697, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 360, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 713) / 2, (screenSize.height - 389) / 2, 713, 389);
    }// </editor-fold>                        
    // Variables declaration - do not modify                     
    // End of variables declaration                   

    /**
     * @return the nombreArchivo
     */
    private String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /*
    protected byte[] exportReportToRtf(JasperPrint jasperPrint) throws JRException{
   JRRtfExporter exporter = new JRRtfExporter();
   ByteArrayOutputStream baos = new ByteArrayOutputStream();    
   exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
   exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
   exporter.exportReport(); 
   return baos.toByteArray();
}*/
    protected byte[] exportReportToRtf(JasperPrint jasperPrint) throws JRException {
        JRDocxExporter exporter = new JRDocxExporter();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
        exporter.exportReport();
        return baos.toByteArray();

    }

    public void exportarADocx(JasperPrint jasperPrint, String fileName) throws JRException {
        JRDocxExporter exporter = new JRDocxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, false);
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "myreport.docx");
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new File("D:\\docxGenerados\\" + fileName));

        exporter.exportReport();
    }

    public void exportarADocx2(JasperPrint jasperPrint, String fileName) throws JRException {
        JRDocxExporter exporter = new JRDocxExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput("D:\\docxGenerados\\" + fileName));
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "myreport.docx");
        //exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new File("D:\\docxGenerados\\" + fileName));

        exporter.exportReport();
    }

    public void exportarADocxConCopia(String fileName) throws IOException {
        try {
            //EXPORTANDO docx
            System.out.println("Exportando a docx");
            exportarADocx2(printr, fileName);
            imprimeDocx(fileName);
            //exp.setParameter(JRExporterParameter.OUTPUT_FILE, new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            //exp.exportReport();
            //PrinterJob job = PrinterJob.getPrinterJob();

            //PDDocument pdc = PDDocument.load(new File("D:\\pdfGenerados\\" + nombreArchivo + ".pdf"));
            //System.out.println("" + pdc.getNumberOfPages());
            //job.setPageable(new PDFPageable(pdc));
            //try {
            //    job.print();
            /*} catch (PrinterException ex) {
                Logger.getLogger(MyiReportVisor.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            System.out.println("Mostrando Docx");
            //Abriendo PDF
            //Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+"D:\\pdfGenerados\\" + nombreArchivo + ".pdf");
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public void imprimeDocx(String fileName) throws IOException {
        java.awt.Desktop.getDesktop().print(new File("D:\\docxGenerados\\" + fileName));
    }

    //metodo para guardar el pdf en una ruta especifica
    public void GuardarPdf() throws Exception {
        JasperReport jasperReport;
        JasperPrint jasperPrint;
        try {
            Conexion con = new Conexion();
            con.conectar();
            //se carga el reporte - indicar el archivo .jrxml
            URL in = this.getClass().getResource("reporte.jasper");
            jasperReport = (JasperReport) JRLoader.loadObject(in);
            //se procesa el archivo jasper
            jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap(), con.getConexion());
            //se crea el archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "E:/temporal/reporte.pdf");
        } catch (JRException ex) {
            System.err.println("Error iReport: " + ex.getMessage());
        }
    }
}
