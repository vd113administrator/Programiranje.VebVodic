/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.beans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import programiranje.vodic.VodicController;
import programiranje.vodic.alat.HtmlUtil;
import programiranje.vodic.alat.PathUtil;
import programiranje.vodic.model.VodicManager;

/**
 *
 * @author Mikec
 */
public class VodicBean implements Serializable{
    private VodicManager vodic = new VodicManager(VodicController.getRootDirectory()); 
    
    private transient String osnovnaPutanja; 
    private transient String tekucaPutanja; 
    private transient String aktivnaPutanja;  
    
    private transient String kodAktivnePutanje;
    private transient String kodListeDirektorijuma; 
    
    public String getOsnovnaPutanja() throws IOException{
        return HtmlUtil.encodeForNestingToHTML(vodic.getOsnovanaPutanjaTekst()); 
    }
    
    public String getTekucaPutanja() throws IOException{
        return HtmlUtil.encodeForNestingToHTML(vodic.getTekucaPutanjaTekst());
    }
    
    public String getKodAktivnePutanje() throws IOException{
        String osnovna = vodic.getOsnovanaPutanjaTekst();
        String tekuca = vodic.getTekucaPutanjaTekst();
        String trazena = tekuca.substring(osnovna.length());
        if(trazena.trim().length()==0) return ""+File.separator+trazena;
        else{
            trazena = ""; 
            List<File> paths = vodic.listKodijenskeDirektorijumeDoOsnovog(); 
            for(File file: paths){
                String putanja = HtmlUtil.escapeForForwardToJavaScript(PathUtil.path(file));
                String name = HtmlUtil.encodeForNestingToHTML(file.getName());
                trazena += "<span class='manual-link' onclick=\"vodic_forma_reakcija('"+putanja+"')\">"+File.separator+name+"</span>";
            }
            return trazena;  
        }
    }
    
    public String getKodListeDirektorijuma() throws IOException{
        String str = "";
        List<File> files = vodic.listaDirektorijuma();
        String osnovna = vodic.getOsnovanaPutanjaTekst(); 
        String tekuca = vodic.getTekucaPutanjaTekst(); 
        String trazena = tekuca.substring(osnovna.length());
        
        str+="<b>ДИРКТОРИЈУМИ : "+files.size()+"</b><br><br>";
        
        if(trazena.trim().length()!=0){
            String tekuci = HtmlUtil.escapeForForwardToJavaScript(tekuca); 
            String osnovni = HtmlUtil.escapeForForwardToJavaScript(osnovna); 
            File predhodni = vodic.getTekucaPutanja().getParentFile(); 
            String predhodna = HtmlUtil.escapeForForwardToJavaScript(PathUtil.path(predhodni));
            str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija('"+osnovni+"')\">.</div>\n";
            str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija('"+predhodna+"')\">..</div>\n";
            str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija('"+tekuci+"')\">...</div>\n";
        }
        
        for(File file: files){ 
            String text = HtmlUtil.escapeForForwardToJavaScript(PathUtil.path(file));
            String kod = HtmlUtil.encodeForNestingToHTML(file.getName()); 
            str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija('"+text+"')\">"+kod+"</div>\n";
        }
        return str;
    }
    public String getKodListeDatoteka() throws IOException{
        String str = "";
        List<File> files = vodic.listaDatoteka();
        str+="<b>ДАТОТЕКЕ : "+files.size()+"</b><br><br>";
        str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija_podaci(null)\"><center>&gt;&lt;</center></div>\n";
        for(File file: files){ 
            String kod = HtmlUtil.encodeForNestingToHTML(file.getName());
            String text = HtmlUtil.escapeForForwardToJavaScript(PathUtil.path(file));
            str+= "\t<div class='manual-link' onclick=\"vodic_forma_reakcija_podaci('"+text+"')\">"+kod+"</div>\n";
        }
        return str;
    }
    
    public VodicManager getVodic(){
        return vodic; 
    }
    
    private String opis;
    private String naslov; 
    
    public String getOpis(){
        return opis;
    }
    
    public String getNaslov(){
        return naslov; 
    }
    
    public void setOpis(String as){
        opis = as; 
    }
    
    public void setNaslov(String as){
        naslov = as; 
    }
    
    private String datoteka;
    
    public String getDatoteka() throws IOException{
        File file = vodic.getDatoteka();
        if(file==null) return "";
        return file.getName();
    }
}
