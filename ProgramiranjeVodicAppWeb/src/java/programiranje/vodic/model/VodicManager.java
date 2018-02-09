/*
 * To change this license header, choose License Headers in Proisct Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.model;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import programiranje.vodic.alat.PathUtil;
import programiranje.vodic.lang.VodicException;

/**
 *
 * @author Mikec
 */
public class VodicManager implements Serializable{
    private File osnovnaPutanja;
    private File tekucaPutanja;
    
    public VodicManager(){
    }
    public VodicManager(File osnovnaPutanja){
        this.osnovnaPutanja = osnovnaPutanja;
        this.tekucaPutanja  = osnovnaPutanja;
    }
    public VodicManager(String osnovnaPutanja){
        this(new File(osnovnaPutanja));
    }
    
    public synchronized File getOsnovnaPutanja(){
        return osnovnaPutanja; 
    }
    public synchronized String getOsnovanaPutanjaTekst() throws IOException{
        return osnovnaPutanja.getCanonicalPath(); 
    }
    public synchronized File getTekucaPutanja(){
        return tekucaPutanja; 
    }
    public synchronized String getTekucaPutanjaTekst() throws IOException{
        return tekucaPutanja.getCanonicalPath(); 
    }
    
    public synchronized void setOsnovnaPutanja(File osnovnaPutanja){
        if(isInicijalizovano()) throw new VodicException("Reinicijalizacija.");
        this.osnovnaPutanja = osnovnaPutanja;
        this.tekucaPutanja = osnovnaPutanja; 
    }
    public synchronized void setOsnovnaPutanjaUslovno(File osnovnaPutanja){
        if(isInicijalizovano()) return;
        this.osnovnaPutanja = osnovnaPutanja;
        this.tekucaPutanja = osnovnaPutanja; 
    }
    public synchronized void setOsnovnaPutanja(String osnovnaPutanja){
        setOsnovnaPutanja(new File(osnovnaPutanja));
    }
    public synchronized void setOsnovnaPutanjaUslovno(String osnovnaPutanja){
        setOsnovnaPutanjaUslovno(new File(osnovnaPutanja));
    }
    public synchronized void setTekucaPutanja(File tekucaPutanja) throws IOException{
       if(!isInicijalizovano()) throw new VodicException("Neinicijalizovano.");
       if(!PathUtil.exclusive(osnovnaPutanja, tekucaPutanja)) throw new VodicException("Van korijnskog direktorijuma.");
       this.tekucaPutanja=tekucaPutanja; 
    }
    public synchronized void setTekucaPutanja(String tekucaPutanja) throws IOException{
       if(!isInicijalizovano()) throw new VodicException("Neinicijalizovano.");
       if(!PathUtil.exclusive(osnovnaPutanja, tekucaPutanja)) throw new VodicException("Van korijnskog direktorijuma.");
       this.tekucaPutanja=new File(tekucaPutanja); 
    }
    public synchronized void setTekucaPutanjaUslovno(File tekucaPutanja) throws IOException{
       if(!isInicijalizovano()) return; 
       if(!PathUtil.exclusive(osnovnaPutanja, tekucaPutanja)) return; 
       this.tekucaPutanja=tekucaPutanja; 
    }
    public synchronized void setTekucaPutanjaUslovno(String tekucaPutanja) throws IOException{
       if(!isInicijalizovano()) return; 
       if(!PathUtil.exclusive(osnovnaPutanja, tekucaPutanja)) return;
       this.tekucaPutanja=new File(tekucaPutanja); 
    }
    
    public synchronized boolean isInicijalizovano(){
        if(osnovnaPutanja==null) return false; 
        if(!osnovnaPutanja.exists()) return false; 
        if(!osnovnaPutanja.isDirectory()) return false; 
        return true;
    }
    
    public synchronized List<File> listaDirektorijuma(){
       ArrayList<File> lista = new ArrayList<>(); 
       if(!isInicijalizovano()) throw new VodicException("Neinicijalizovano.");
       for(File file: tekucaPutanja.listFiles()){
           if(file.isDirectory())
               lista.add(file);
       }
       return lista; 
    }
    public synchronized List<File> listaDatoteka(){
       ArrayList<File> lista = new ArrayList<>(); 
       if(!isInicijalizovano()) throw new VodicException("Neinicijalizovano.");
       for(File file: tekucaPutanja.listFiles()){
           if(file.isFile())
               lista.add(file);
       }
       return lista; 
    }
    
    public synchronized void kretanjeNaprijed(File next) throws IOException{
        this.setTekucaPutanjaUslovno(next);
    }
    public synchronized void kretanjeNaprijed(String next) throws IOException{
        this.setTekucaPutanjaUslovno(new File(tekucaPutanja,next));
    }
    public synchronized void kretanjeUnazad() throws IOException{
        this.setTekucaPutanjaUslovno(tekucaPutanja.getParentFile());
    }
    public synchronized void kretanjeUnazad(int n) throws IOException{
        if(n<1) return; 
        kretanjeUnazad();
        kretanjeUnazad(n-1); 
    }
    public synchronized void kretanjePocetak(){
        tekucaPutanja = osnovnaPutanja; 
    }
    public synchronized String calcPutanjaKretanja() throws IOException{
        String osnovna = getOsnovanaPutanjaTekst(); 
        String tekuca = getTekucaPutanjaTekst(); 
        String trazena = tekuca.substring(osnovna.length());
        return trazena;
    }
    public synchronized List<String> calcListKretanja() throws IOException{
        return Arrays.asList(PathUtil.explode(calcPutanjaKretanja()));
    }
    public synchronized List<File> listKodijenskeDirektorijume(){
        ArrayList<File> dirs = new ArrayList<>();
        File dir = tekucaPutanja;
        dirs.add(dir);
        while(dir!=null){
            dir = dir.getParentFile(); 
            if(dir!=null)dirs.add(dir);
        }
        Collections.reverse(dirs);
        return dirs;
    }
    public synchronized List<File> listKodijenskeDirektorijumeDoOsnovog(){
        ArrayList<File> dirs = new ArrayList<>();
        File dir = tekucaPutanja;
        dirs.add(dir);
        while(dir!=null && !dir.equals(osnovnaPutanja)){
            dir = dir.getParentFile(); 
            if(dir!=null && !dir.equals(osnovnaPutanja)) dirs.add(dir);
        }
        Collections.reverse(dirs);
        return dirs;
    }
    
    private File datoteka; 
    public synchronized File getDatoteka(){
        return datoteka; 
    }
    public synchronized void setDatoteka(File file){
        datoteka = file; 
    }
}
