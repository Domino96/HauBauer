package de.haubauer.business.reports;


import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

import java.util.List;

public class gbJasperDataSource implements JRDataSource {
    private int index = -1;
    List<Gesamtbericht> gesamtberichtList = null;

    public gbJasperDataSource(List<Gesamtbericht> list){
        super();
        this.gesamtberichtList = list;
    }

    public boolean next() throws JRException{
        index++;
        return (gesamtberichtList!=null && index < gesamtberichtList.size()) ? true : false;
    }

    public Object getFieldValue(JRField jrField) throws JRException{
        Gesamtbericht gb = gesamtberichtList.get(index);
        if(gb!=null){
            if (jrField.getName().equals("WOHNUNG")) {
                return gb.getWohnung();
            }
            else if (jrField.getName().equals("ZAHLUNGEN_IST")){
                return gb.getZahlungenIst();
            }
            else if (jrField.getName().equals("ZAHLUNGEN_SOLL")){
                return gb.getZahlungenSoll();
            }
            else if (jrField.getName().equals("FEHLBETRÄGE")){
                return gb.getFehlbetrag();
            }
            else {
                return null;
            }
        }
        return null;
    }
}
