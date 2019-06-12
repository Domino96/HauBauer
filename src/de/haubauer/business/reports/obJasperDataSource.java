package de.haubauer.business.reports;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class obJasperDataSource implements JRDataSource {
    private int index = -1;
    List<Objektbericht> objektberichtList = null;

    public obJasperDataSource(List<Objektbericht> list){
        super();
        this.objektberichtList = list;
    }

    public boolean next() throws JRException{
        index++;
        return (objektberichtList!=null && index < objektberichtList.size()) ? true : false;
    }

    public Object getFieldValue(JRField jrField) throws JRException{
        Objektbericht ob = objektberichtList.get(index);
        if (ob!=null){
            if (jrField.getName().equals("OBJEKTNUMMER")){
                return ob.getObjNr();
            }
            else if(jrField.getName().equals("ANSCHRIFT")){
                return ob.getAnschrift();
            }
            else if(jrField.getName().equals("MIETER")){
                return ob.getMieter();
            }
            else if (jrField.getName().equals("OFFENE_BETRÄGE")){
                return ob.getOffeneBetraege();
            }
            else if (jrField.getName().equals("MONAT")){
                return ob.getMonat();
            }
            else if (jrField.getName().equals("DATUM")){
                return ob.getDatum();
            }
            else if (jrField.getName().equals("WARMMIETE")){
                return ob.getWarmmiete();
            }
            else if (jrField.getName().equals("STELLPLATZ")){
                return ob.getStellplatz();
            }
            else if (jrField.getName().equals("GElEISTET")){
                return ob.getGeleistet();
            }
            else if (jrField.getName().equals("OFFEN")){
                return ob.getOffen();
            }
            else{
                return null;
            }
        }
        return null;
    }
}
