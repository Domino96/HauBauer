package de.haubauer.business.reports;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;


import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class gbJasperReport {

    List<Gesamtbericht> gesamtberichtList = new ArrayList<de.haubauer.business.reports.Gesamtbericht>();
    //public void generate() {
    //    String sourceFileName =
    //            "C://tools/jasperreports-5.0.1/test/jasper_report_template.jasper";
//
    //    DataBeanList DataBeanList = new DataBeanList();
    //    ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();
//
    //    JRBeanCollectionDataSource beanColDataSource =
    //            new JRBeanCollectionDataSource(dataList);
//
    //    Map parameters = new HashMap();
    //    /**
    //     * Passing ReportTitle and Author as parameters
    //     */
    //    parameters.put("ReportTitle", "List of Contacts");
    //    parameters.put("Author", "Prepared By Manisha");
//
    //    try {
    //        JasperFillManager.fillReportToFile(
    //                sourceFileName, parameters, beanColDataSource);
    //    } catch (
    //            JRException e) {
    //        e.printStackTrace();
    //    }
    //}

    public void generateReport() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
         /*
        Generierung eines Reports (Bsp mit Rennwagen Datenbank)
         */
        try {
            // Versuch diese Pfade mal
            //InputStream inS= new FileInputStream(new File("Templates/new_Gesamtübersicht.jrxml"));
            //JasperDesign jd= JRXmlLoader.load(inS);
            //net.sf.jasperreports.engine.gbJasperReport jr= JasperCompileManager.compileReport("Templates/new_Gesamtübersicht.jrxml");

            File jasperReport = new File("Templates\\new_Gesamtbericht.jrxml");
            File pdfFile = new File("Templates\\new.pdf");
            InputStream inS= new FileInputStream(jasperReport);
            JasperDesign jd= JRXmlLoader.load(inS);
            net.sf.jasperreports.engine.JasperReport jr= JasperCompileManager.compileReport(jasperReport.getAbsolutePath());
            HashMap para=new HashMap();
            para.put("choosenDate", "01.01.2019");
            para.put("WOHNUNG", "");
            para.put("ZAHLUNGEN_IST", "");
            para.put("ZAHLUNGEN_SOLL", "");
            para.put("FEHLBETRAG", "");
            JasperPrint j= JasperFillManager.fillReport(jr,para);
            JasperViewer.viewReport(j, false);
            OutputStream os=new FileOutputStream(new File(pdfFile.getAbsolutePath()));
            JasperExportManager.exportReportToPdfStream(j, os);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
