/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programiranje.vodic.text;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Mikec
 */
public class Preslovljavanje {
    protected TreeMap<String,String> mapa = new TreeMap<String,String>();
    protected LinkedList<String> originali = new LinkedList<>();  
    
    public Preslovljavanje(TreeMap<String,String> map){
        mapa = new TreeMap<String,String>(map);
    }
   
    public Preslovljavanje(Preslovljavanje map){
        mapa = map.getPravilo(); 
    }
    
    public synchronized TreeMap<String,String> getPravilo(){
        return new TreeMap<>(mapa);
    }
    
    public synchronized Collection<String> getAzbuku(){
         return mapa.keySet();
    }
    
    public synchronized Collection<String> getAbecedu(){
         return mapa.values();
    }
    
    public synchronized Preslovljavanje otvori(String original){
        originali.add(original);
        return this; 
    }
    
    public synchronized Preslovljavanje preslovi(){
        if(originali.size()==0) throw new PreslovljavanjeException("Preslovljavanje nije otvoreno.");
        String text = originali.getLast();
        for(Map.Entry<String,String> me: mapa.entrySet()){
            text=text.replace(me.getKey(), me.getValue());
        }
        originali.add(text);
        return this; 
    }
    
    public synchronized String preuzmi(){
        if(originali.size()==0) throw new PreslovljavanjeException("Preslovljavanje nije otvoreno.");
        String text = originali.getLast();
        return text; 
    }
    
    public synchronized String preuzmi(int n){
        if(originali.size()==0) throw new PreslovljavanjeException("Preslovljavanje nije otvoreno.");
        if(originali.size()<=n) throw new PreslovljavanjeException("Prevelik indeks slike.");
        if(n<0) throw new PreslovljavanjeException("Premali indeks slike.");
        return original(originali.size()-1-n);
    }
    
    public synchronized String original(){
        if(originali.size()==0) throw new PreslovljavanjeException("Preslovljavanje nije otvoreno.");
        String text = originali.getFirst();
        return text; 
    }
    
    public synchronized String original(int n){
        if(originali.size()==0) throw new PreslovljavanjeException("Preslovljavanje nije otvoreno.");
        if(originali.size()<=n) throw new PreslovljavanjeException("Prevelik indeks originala.");
        if(n<0) throw new PreslovljavanjeException("Premali indeks originala.");
        String text = originali.get(n);
        return text; 
    }
    
    public synchronized String zatvori(){
        String str = preuzmi();
        originali.clear();
        return str; 
    }
}
