package br.com.petshop.util.relatorio;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.bytecode.ByteArray;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;


public class GerarRelatorioAgenda {
    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream outputStream;
    private InputStream inputStream;
    private Connection con;

    public GerarRelatorioAgenda() {
    this.context = FacesContext.getCurrentInstance();
    this.response = (HttpServletResponse) context.getExternalContext().getResponse();
    }
    
    public void gerarPDFJasperReport(){
        inputStream = this.getClass().getResourceAsStream("/br/com/petshop/util/relatorio/relatorioServicoAgenda.jasper");
        outputStream = new ByteArrayOutputStream();
        Map<String, Object> parameters = new HashMap<>();
        try {
            JasperReport relatorio = (JasperReport) JRLoader.loadObject(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(relatorio, parameters, getConexao());
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(outputStream.size());
            response.setHeader("Content-disposition", "inline; filename=relatorioAgenda.pdf");
            response.getOutputStream().write(outputStream.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            context.responseComplete();
            fecharConexao();
        } catch (JRException ex) {
            Logger.getLogger(GerarRelatorioAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerarRelatorioAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Connection getConexao(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://counterchase.servegame.com:5432/petshop", "postgres", "root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerarRelatorioAgenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelatorioAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    private void fecharConexao(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GerarRelatorioAgenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
